/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.ui.manual;

import com.jkali.client.page.AbstractPageView;
import ensemble.dialogs.DialogFX;
import ensemble.dialogs.DialogFXBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javax.xml.parsers.ParserConfigurationException;
import org.javafxdata.datasources.provider.XMLDataSource;

import org.jrebirth.core.exception.CoreException;
import org.xml.sax.SAXException;

/**
 *
 * @author Paul
 */
public final class ManualPageView  extends AbstractPageView<ManualPageModel, StackPane, ManualPageController> {
    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ManualPageView(final ManualPageModel model) throws CoreException {
        super(model);
    }
    
    
    @Override
    public void doStart() {
        //getRootNode().getScene().getStylesheets().add(TestJkali.class.getResource("main.css").toExternalForm());
    }

    @Override
    public void doReload() {

    }

    
     public Node getContent() {
        // TabPane
        final TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab networkTab = new Tab("network");
//
        networkTab.setContent(buildTableView());
         
        tabPane.getTabs().add(networkTab);

        return tabPane;
    }
     
     

    @Override
    protected void customInitializeComponents() {

          getRootNode().setId("SlideStack");
          getRootNode().autosize();

          getRootNode().getChildren().add(getContent());
        
        

    }

    @Override
    public void doHide() {
        
    }
 
    
}
