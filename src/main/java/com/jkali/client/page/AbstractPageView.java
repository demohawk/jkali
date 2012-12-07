package com.jkali.client.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import ensemble.dialogs.DialogFX;
import ensemble.dialogs.DialogFXBuilder;

import com.jkali.client.MainFrame;
import com.jkali.client.application.Function;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import org.javafxdata.datasources.provider.XMLDataSource;
import org.jrebirth.core.exception.CoreException;

import org.jrebirth.core.ui.AbstractView;

import com.jkali.client.application.Function;

/**
 *
 * The class <strong>AbstractSlideView</strong>.
 *
 * @author Sébastien Bordes
 *
 * @param <M> the slide model class
 * @param <N> the layout node
 * @param <C> the slide controller class
 */
public abstract class AbstractPageView<M extends AbstractPageModel<?, ?, ?>, N extends StackPane, C extends AbstractPageController<?, ?>> extends AbstractView<M, N, C> {

    
     private boolean isShowPageToolBar = true;
     private GridPageBar gridPageBar;
     private Stage stage = getModel().getLocalFacade().getGlobalFacade().getApplication().getStage();
     private Scene scene = getModel().getLocalFacade().getGlobalFacade().getApplication().getScene();
     
    /**
     * Default Constructor.
     *
     * @param model the controls view model
     *
     * @throws CoreException if build fails
     */
    public AbstractPageView(final M model) throws CoreException {
    	
    	
        super(model);
        stage.toFront();
        
        
//    	Rectangle sceneRect = new Rectangle(
//    			this.getRootNode().getScene().getX(), this.getRootNode().getScene().getY(), 
//    			this.getRootNode().getScene().getWidth(), this.getRootNode().getScene().getHeight());
//    	
//    	BufferedImage img;
//		try {
//			img = new Robot().createScreenCapture(
//					  new java.awt.Rectangle(
//					    (int)sceneRect.getX(),       (int)sceneRect.getY(),
//					    (int)sceneRect.getWidth()-1, (int)sceneRect.getHeight()-1));
//		    Function function = (Function)getModel().getModelObject();
//		    function.setImage(img);
//			MainFrame.getHistory().add(function);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        Image image =new WritableImage(150, 60);

    }
    

    protected BorderPane buildTableView() {

        BorderPane border = new BorderPane();
        final TableView<String[]> tableView = new TableView<>();


//            tableView.setItems(ds);
//            tableView.getColumns().addAll(ds.getColumns());
//
//            System.out.println("ADDED items: " + ds.size());
        border.setCenter(tableView);
        ToolBar toolbar = new ToolBar();
        border.setBottom(toolbar);
        StackPane stack = new StackPane();
        gridPageBar =new GridPageBar(true,true,true,true,true);
        stack.getChildren().add(gridPageBar);
        HBox.setHgrow(stack, Priority.ALWAYS);
//        final Button btn = new Button();
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                DialogFX dialog = DialogFXBuilder.create().titleText("Insert test control..").modal(true).message("Insert....Hol").build();
//
//                dialog.show();
//            }
//        });
        
        toolbar.getItems().add(stack);

        GridPane.setVgrow(tableView, Priority.ALWAYS);
        return border;
    }

    /**
     * @return the gridPageBar
     */
    public GridPageBar getGridPageBar() {
        return gridPageBar;
    }

    
}
