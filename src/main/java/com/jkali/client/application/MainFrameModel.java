/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.application;

import com.jkali.client.AppWaves;
import com.jkali.client.ui.manual.ManualPageModel;
import ensemble.Page;
import ensemble.Pages;
import ensemble.config.ProxyDialog;
import ensemble.controls.BreadcrumbBar;
import ensemble.controls.WindowResizeButton;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import netscape.javascript.JSObject;
import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.ui.DefaultModel;
import org.jrebirth.core.wave.Wave;

/**
 *
 * @author Paul
 */
public class MainFrameModel  extends AbstractModel<MainFrameModel, MainFrameView>{

    @Override
    protected void customInitialize() {
        listen(AppWaves.DO_START);
    }

    private ContextMenu contextMenu;
    private Popup extraInfoPopup;
    private Tooltip searchErrorTooltip;

    // Handle wave
    public void start(Wave wave){
        contextMenu = new ContextMenu();
        contextMenu.setOnShowing(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                System.out.println("showing");
            }
        });
        contextMenu.setOnShown(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                System.out.println("shown");
            }
        });

        MenuItem item1 = new MenuItem("About");
        item1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("About");
            }
        });
        MenuItem item2 = new MenuItem("Preferences");
        item2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Preferences");
            }
        });
        contextMenu.getItems().addAll(item1, item2);
        extraInfoPopup = new Popup();
        searchErrorTooltip=new Tooltip();
    }

    @Override
    protected void customInitializeInnerModels() {
        getInnerModel(MenuPageInnerModels.Manual);
        
    }

    @Override
    protected void processAction(Wave wave) {
       
    }

    /**
     * @return the contextMenu
     */
    public ContextMenu getContextMenu() {
        return contextMenu;
    }

    /**
     * @return the extraInfoPopup
     */
    public Popup getExtraInfoPopup() {
        return extraInfoPopup;
    }

    /**
     * @return the searchErrorTooltip
     */
    public Tooltip getSearchErrorTooltip() {
        return searchErrorTooltip;
    }
 
 
    
}
