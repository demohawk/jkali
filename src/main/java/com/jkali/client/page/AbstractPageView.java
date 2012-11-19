package com.jkali.client.page;

import ensemble.dialogs.DialogFX;
import ensemble.dialogs.DialogFXBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import org.javafxdata.datasources.provider.XMLDataSource;
import org.jrebirth.core.exception.CoreException;

import org.jrebirth.core.ui.AbstractView;

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
     
    /**
     * Default Constructor.
     *
     * @param model the controls view model
     *
     * @throws CoreException if build fails
     */
    public AbstractPageView(final M model) throws CoreException {
        super(model);
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
