package com.jkali.client.page;

import com.jkali.core.util.UTIL;
import ensemble.Ensemble2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.AbstractView;
import org.jrebirth.core.ui.DefaultView;

/**
 * Grid工具条容器，管理表单默认以及自定义增删改，允许增加自定义按钮，分页
 *
 * @author Paul
 */
public final class GridPageView extends DefaultView<GridPageModel, HBox,GridPageController>{

    private List<Button> buttons = new ArrayList<>();

    private int pageSize = 30;
    private int pageIndex = 1;
    private int total = 1;
    private boolean isPaging = true;
    private boolean isAdd = false;
    private boolean isEdit = false;
    private boolean isDel = false;
    private boolean isRefresh = true;

    private Button newButton;
    private Button editButton;
    private Button delButton;
    private Button refButton;
    private Button firstButton;
    private Button preButton;
    private Button postButton;
    private Button endButton;
    private TextField pageNo;
    private ComboBox pageComboBox;
    private String propPageValue = "10,50,100";

    public GridPageView(final GridPageModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {
        if (isAdd) {
            if (newButton == null) {
                Button btn = new Button("+");
                buttons.add(btn);
            } else {
                buttons.add(newButton);
            }
        }
        if (isEdit) {
            if (editButton == null) {
                Button btn = new Button("E");
                buttons.add(btn);
            } else {
                buttons.add(editButton);
            }
        }
        if (isDel) {
            if (delButton == null) {
                Button btn = new Button("-");
                buttons.add(btn);
            } else {
                buttons.add(delButton);
            }

        }
        if (isRefresh) {
            if (getRefButton() == null) {
                Button btn = new Button("R");
                buttons.add(btn);
            } else {
                buttons.add(getRefButton());
            }
        }
        getRootNode().getChildren().addAll(buttons);
        if (isPaging) {
            HBox pageHBox = new HBox();
            firstButton = new Button("<<");
            preButton = new Button("<");
            postButton = new Button(">");
            endButton = new Button(">>");
            pageNo = new TextField();
            getPageNo().setText(String.valueOf(pageIndex));
            pageComboBox = new ComboBox(FXCollections.observableArrayList(propPageValue.split(",")));
            pageComboBox.setValue("10");
            pageHBox.getChildren().addAll(getFirstButton(), getPreButton(), getPageNo(), getPostButton(), getEndButton(), pageComboBox);
            getRootNode().getChildren().addAll(pageHBox);
        }

    }

    /**
     * @return the newButton
     */
    public Button getNewButton() {
        return newButton;
    }

    /**
     * @return the editButton
     */
    public Button getEditButton() {
        return editButton;
    }

    /**
     * @return the delButton
     */
    public Button getDelButton() {
        return delButton;
    }

    @Override
    public void doStart() {
        
    }

    @Override
    public void doReload() {
        
    }

    @Override
    public void doHide() {
        
    }

    /**
     * @return the refButton
     */
    public Button getRefButton() {
        return refButton;
    }

    /**
     * @return the firstButton
     */
    public Button getFirstButton() {
        return firstButton;
    }

    /**
     * @return the preButton
     */
    public Button getPreButton() {
        return preButton;
    }

    /**
     * @return the postButton
     */
    public Button getPostButton() {
        return postButton;
    }

    /**
     * @return the endButton
     */
    public Button getEndButton() {
        return endButton;
    }

    /**
     * @return the pageNo
     */
    public TextField getPageNo() {
        return pageNo;
    }

  

}
