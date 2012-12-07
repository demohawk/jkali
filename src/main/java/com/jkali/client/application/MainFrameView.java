/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.application;

import com.jkali.client.AppWaves;
import com.jkali.client.MainFrame;
import com.jkali.client.Menu;
import com.jkali.client.MenuTreeModel;
import com.jkali.client.ui.manual.ManualPageModel;
import com.jkali.core.util.UTIL;



import ensemble.Page;
import ensemble.Pages;
import ensemble.config.ProxyDialog;
import ensemble.controls.BreadcrumbBar;
import ensemble.controls.SearchBox;
import ensemble.controls.WindowButtons;
import ensemble.controls.WindowResizeButton;
import ensemble.pages.SamplePage;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import netscape.javascript.JSObject;
import org.jrebirth.core.command.basic.ShowModelWaveBuilder;
import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.DefaultView;
import org.jrebirth.core.ui.Model;

/**
 *Main Frame View
 *
 *
 * @author Paul
 */
public final class MainFrameView extends DefaultView<MainFrameModel, StackPane, MainFrameController> {

    private static boolean isApplet = false;
    private Stage stage = getModel().getLocalFacade().getGlobalFacade().getApplication().getStage();
    private Scene scene = getModel().getLocalFacade().getGlobalFacade().getApplication().getScene();
    private BorderPane root;
    private ToolBar toolBar;
    private SplitPane splitPane;
    private TreeView<Menu> menuTree;
    private Pane pageArea;
    private Pages pages;
    private Menu currentMenu;
    private String currentPagePath;
    private Node currentPageView;
    private BreadcrumbBar breadcrumbBar;


    private boolean changingPage = false;
    private double mouseDragOffsetX = 0;
    private double mouseDragOffsetY = 0;
    private WindowResizeButton windowResizeButton;
    public boolean fromForwardOrBackButton = false;
    private StackPane modalDimmer;
    private ProxyDialog proxyDialog;
    private ToolBar pageToolBar;


    private WritableImage snapshot;

    /**
     * Default Constructor.
     *
     * @param model the controls view model
     *
     * @throws CoreException if build fails
     */
    public MainFrameView(final MainFrameModel model) throws CoreException {
        super(model);

    }

    @Override
    protected void customInitializeComponents() {
        //StackPane layerPane = new StackPane();
        // check if applet
//        try {
//            browser = getHostServices().getWebContext();
//            isApplet =  browser != null;
//        } catch (Exception e) {
//            isApplet = false;
//        }
//        if (!isApplet) {
        getModel().listen(AppWaves.DO_START);
        // create window resize button
        windowResizeButton = new WindowResizeButton(stage, 1020, 700);
        // create root
        root = new BorderPane() {
            @Override
            protected void layoutChildren() {
                super.layoutChildren();
                windowResizeButton.autosize();
                windowResizeButton.setLayoutX(getWidth() - windowResizeButton.getLayoutBounds().getWidth());
                windowResizeButton.setLayoutY(getHeight() - windowResizeButton.getLayoutBounds().getHeight());
            }
        };
        root.getStyleClass().add("application");

        root.setId("root");
        getRootNode().setDepthTest(DepthTest.DISABLE);

        // create scene
//        boolean is3dSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
////        scene.setRoot(layerPane);
        getRootNode().setPrefWidth(1020);
        getRootNode().setPrefHeight(700);

        //scene = new Scene(layerPane, 1020, 700, is3dSupported);
//        if (is3dSupported) {
//            //RT-13234
//            scene.setCamera(new PerspectiveCamera());
//        }
        // create modal dimmer, to dim screen when showing modal dialogs
        modalDimmer = new StackPane();
//        modalDimmer.setOpacity(1);
//        modalDimmer.setId("ModalDimmer");
        modalDimmer.setStyle("-fx-background-color: DAE6F3;");
        modalDimmer.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

//        modalDimmer.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent t) {
//                t.consume();
//                hideModalMessage();
//            }
//        });
        modalDimmer.setAlignment(Pos.BASELINE_CENTER);
        modalDimmer.setVisible(false);
//        root.setBottom(modalDimmer);


//        // create main toolbar

        toolBar = new ToolBar();
        toolBar.setId("mainToolBar");
        ImageView logo = new ImageView(new Image(MainFrame.class.getResourceAsStream("images/logo.png")));
        HBox.setMargin(logo, new Insets(0, 0, 0, 5));
        toolBar.getItems().add(logo);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        toolBar.getItems().add(spacer);

        Button newButton = new Button();
        newButton.setId("newButton");
        newButton.setMinSize(120, 66);
        newButton.setPrefSize(120, 66);
        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.err.println("show message..");
                proxyDialog = new ProxyDialog(stage, pages);
                proxyDialog.loadSettings();
                proxyDialog.getDocsInBackground(true,null);
 
            	showModalMessage(proxyDialog);
            }
        });
        toolBar.getItems().add(newButton);

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        toolBar.getItems().add(spacer2);
        ImageView searchTest = new ImageView(new Image(MainFrame.class.getResourceAsStream("images/search-text.png")));
        toolBar.getItems().add(searchTest);
        //       SearchBox searchBox = new SearchBox(getModel().getContextMenu(),getModel().getExtraInfoPopup(),getModel().getSearchErrorTooltip());
//        HBox.setMargin(searchBox, new Insets(0, 5, 0, 0));
//        toolBar.getItems().add(searchBox);
        toolBar.setPrefHeight(66);
        toolBar.setMinHeight(66);
        toolBar.setMaxHeight(66);
        GridPane.setConstraints(toolBar, 0, 0);
        if (!isApplet) {
            // add close min max
            final WindowButtons windowButtons = new WindowButtons(stage);
            toolBar.getItems().add(windowButtons);
            // add window header double clicking
            toolBar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 2) {
                        windowButtons.toogleMaximized();
                    }
                }
            });
            // add window dragging
            toolBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mouseDragOffsetX = event.getSceneX();
                    mouseDragOffsetY = event.getSceneY();
                }
            });
            toolBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!windowButtons.isMaximized()) {
                        stage.setX(event.getScreenX() - mouseDragOffsetX);
                        stage.setY(event.getScreenY() - mouseDragOffsetY);
                    }
                }
            });
        }
        this.root.setTop(toolBar);
        // create page tree toolbar
//        ToolBar pageTreeToolBar = new ToolBar() {
//            @Override
//            public void requestLayout() {
//                super.requestLayout();
//                // keep the height of pageToolBar in sync with pageTreeToolBar so they always match
//                if (pageToolBar != null && getHeight() != pageToolBar.prefHeight(-1)) {
//                    pageToolBar.setPrefHeight(getHeight());
//                }
//            }
//        };
//        pageTreeToolBar.setId("page-tree-toolbar");
//        pageTreeToolBar.setMinHeight(29);
//        pageTreeToolBar.setMaxWidth(Double.MAX_VALUE);

        FlowPane flow = new FlowPane();
        flow.setId("page-tree-toolbar");
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(1);
        flow.setHgap(1);
        flow.setPrefWrapLength(90); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");
       
        ImageView pages[] = new ImageView[9];
        for (int i = 0; i < 1; i++) {
            pages[i] = new ImageView(
                    new Image(MainFrame.class.getResourceAsStream(
                    "images/icon-48x48.png")));
            Button button = new Button();
            button.setGraphic(pages[i]);
            button.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	System.err.println("show message..");
                	HBox box = new HBox();
                	for(Function fun:MainFrame.getHistory()){
                	snapshot = scene.snapshot(null);
                	box.getChildren().add(new ImageView(new Image(UTIL.getImageStream(fun.image))));
                	
//                	showModalMessage(new Button("xxxxxxdd"));
                	}
                	showModalMessage(box);
                }
            });
            flow.getChildren().add(button);
        }


        // create left split pane
        final BorderPane leftSplitPane = new BorderPane();
        leftSplitPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.isSecondaryButtonDown())
                        getModel().getContextMenu().show(leftSplitPane, Side.TOP,event.getX(), event.getY());
                }
            });
        
        leftSplitPane.setTop(flow);
        try {
            leftSplitPane.setCenter(buildMenuTree());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // create page toolbar
        pageToolBar = new ToolBar();
        pageToolBar.setId("page-toolbar");
        pageToolBar.setMinHeight(29);
        pageToolBar.setMaxSize(Double.MAX_VALUE, Control.USE_PREF_SIZE);
        if (!isApplet) {
            Button backButton = new Button();
            backButton.setGraphic(new ImageView(new Image(MainFrame.class.getResourceAsStream("images/back.png"))));
            backButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                }
            });
            backButton.setMaxHeight(Double.MAX_VALUE);
            Button forwardButton = new Button();
            forwardButton.setGraphic(new ImageView(new Image(MainFrame.class.getResourceAsStream("images/forward.png"))));
            forwardButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                }
            });
            forwardButton.setMaxHeight(Double.MAX_VALUE);
            Button reloadButton = new Button();
            reloadButton.setGraphic(new ImageView(new Image(MainFrame.class.getResourceAsStream("images/reload.png"))));
            reloadButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                }
            });
            reloadButton.setMaxHeight(Double.MAX_VALUE);
            pageToolBar.getItems().addAll(backButton, forwardButton, reloadButton);
        }
        breadcrumbBar = new BreadcrumbBar();
        pageToolBar.getItems().add(breadcrumbBar);
        if (!isApplet) {
            Region spacer3 = new Region();
            HBox.setHgrow(spacer3, Priority.ALWAYS);
            Button settingsButton = new Button();
            settingsButton.setId("SettingsButton");
            settingsButton.setGraphic(new ImageView(new Image(MainFrame.class.getResourceAsStream("images/settings.png"))));
            settingsButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {

                }
            });
            settingsButton.setMaxHeight(Double.MAX_VALUE);
            pageToolBar.getItems().addAll(spacer3, settingsButton);
        }
        // create page area
        pageArea = new Pane() {
            @Override
            protected void layoutChildren() {
                for (Node child : pageArea.getChildren()) {
                    child.resizeRelocate(0, 0, pageArea.getWidth(), pageArea.getHeight());
                }
            }
        };
        pageArea.setId("page-area");
        // create right split pane
        BorderPane rightSplitPane = new BorderPane();
        rightSplitPane.setTop(pageToolBar);
        rightSplitPane.setCenter(pageArea);
        // create split pane
        splitPane = new SplitPane();
        splitPane.setId("page-splitpane");
        splitPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setConstraints(splitPane, 0, 1);
        splitPane.getItems().addAll(leftSplitPane, rightSplitPane);
        splitPane.setDividerPosition(0, 0.25);


        this.root.setCenter(splitPane);
        // add window resize button so its on top

        windowResizeButton.setManaged(false);
        this.root.getChildren().add(windowResizeButton);
        getRootNode().getChildren().add(root);
        getRootNode().getChildren().add(modalDimmer);

    }

    /**
     * Show the given node as a floating dialog over the whole application, with
     * the rest of the application dimmed out and blocked from mouse events.
     *
     * @param message
     */
    public void showModalMessage(Node message) {

        modalDimmer.getChildren().add(message);
        modalDimmer.setOpacity(0);
        modalDimmer.setVisible(true);
        modalDimmer.setCache(true);
        
        TimelineBuilder.create().keyFrames(
                new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        modalDimmer.setCache(false);
                    }
                },
                new KeyValue(modalDimmer.opacityProperty(), 1, Interpolator.EASE_BOTH))).build().play();
    }

    /**
     * Hide any modal message that is shown
     */
    public void hideModalMessage() {
        modalDimmer.setCache(true);
        TimelineBuilder.create().keyFrames(
                new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        modalDimmer.setCache(false);
                        modalDimmer.setVisible(false);
                        modalDimmer.getChildren().clear();
                    }
                },
                new KeyValue(modalDimmer.opacityProperty(), 0, Interpolator.EASE_BOTH))).build().play();
    }

    /**
     * Get the pages object that contains the tree of all avaliable pages
     *
     * @return Pages containing tree of all pages
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * Change to new page without swapping views, assumes that the current view
     * is already showing the new page
     *
     * @param page The new page object
     */
    public void updateCurrentPage(Menu page) {
        goToPage(page, true, false, false);
    }

    /**
     * Take ensemble to the given page path, navigating there and adding current
     * page to history
     *
     * @param pagePath The path for the new page to show
     */
//    public void goToPage(String classModelName) {
//        goToPage(pages.getPage(classModelName));
//    }
    /**
     * Take ensemble to the given page path, navigating there and adding current
     * page to history.
     *
     * @param pagePath The path for the new page to show
     * @param force Reload page even if its the current page //
     */
//    public void goToPage(String pagePath, boolean force) {
//        goToPage(pages.getPage(pagePath), true, force, true);
//    }
    /**
     * Take ensemble to the given page object, navigating there and adding
     * current page to history.
     *
     * @param page Page object to show
     */
    public void goToPage(Menu page) {
        goToPage(page, true, false, true);
    }

    /**
     * Take ensemble to the given page object, navigating there.
     *
     * @param page Page object to show
     * @param addHistory When true add current page to history before navigating
     * @param force When true reload page if page is current page
     * @param swapViews If view should be swapped to new page
     */
    private void goToPage(Menu menu, boolean addHistory, boolean force, boolean swapViews) {
        if (menu == null) {
            return;
        }
        if (!force && menu == currentMenu) {
            return;
        }
        changingPage = true;
        if (swapViews) {
            // Do stuff on the model !
        	String uuid = UUID.randomUUID().toString();
        	
   

        	try {
        		Function function = new Function();
				function.setUUID(uuid);
				function.setMenu(menu);
				
				function.UUID=uuid;
				function.menu=menu;
				getModel().sendWave(ShowModelWaveBuilder.create()
				        .childrenPlaceHolder(pageArea.getChildren()).keyPart(function)
				        .modelClass((Class<Model>)Class.forName(menu.getClassName()))
				        .build());
		
				

				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
     // done
        changingPage = false; 
            
  
            //getModel().getLocalFacade().retrieve(ManualPageModel.class, "234")

      

    }

    /**
     * Check if current call stack was from back or forward button's action
     *
     * @return True if current call was caused by action on back or forward
     * button
     */
    public boolean isFromForwardOrBackButton() {
        return fromForwardOrBackButton;
    }


    /**
     * Code responsible for creating the CheckBoxTreeView
     */
    private TreeView buildMenuTree() throws Exception {
        final TreeView treeView = new TreeView<String>();
        treeView.setId("page-tree");
        try {
            MenuTreeModel menumodel = new MenuTreeModel();
            final Menu rootmenu = menumodel.getMenuTreeItem();
            rootmenu.setExpanded(true);
            treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue,
                        Object newValue) {
                    if (!changingPage) {
                        Menu selectedPage = (Menu) treeView.getSelectionModel().getSelectedItem();
                        if (selectedPage.getValue() != rootmenu.getValue()) {
                            goToPage(selectedPage);
                        }
                    }
                }
            });

            treeView.setRoot(rootmenu);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return treeView;
    }

    public FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");
        
        ImageView pages[] = new ImageView[8];
        for (int i = 0; i < 8; i++) {
            pages[i] = new ImageView(
                    new Image(MainFrame.class.getResourceAsStream(
                    "images/icon-48x48.png")));
            Button button = new Button();
            button.setGraphic(pages[i]);
            button.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	System.err.println("show message..");
                	showModalMessage(new ImageView(snapshot));
                }
            });
            flow.getChildren().add(button);
        }

        return flow;
    }
    
   
    


    
   
}
