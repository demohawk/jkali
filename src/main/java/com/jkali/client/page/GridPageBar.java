/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.page;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Paul
 */
public class GridPageBar extends HBox{
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
    
    public GridPageBar(boolean isAdd,boolean isEdit,boolean isDel,boolean isRefresh,boolean isPaging){
         this.setId("GridPageBar");
        
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
        this.getChildren().addAll(buttons);
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
            this.getChildren().addAll(pageHBox);
    }
    
}

    /**
     * @return the buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(TextField pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the pageComboBox
     */
    public ComboBox getPageComboBox() {
        return pageComboBox;
    }

    /**
     * @param propPageValue the propPageValue to set
     */
    public void setPropPageValue(String propPageValue) {
        this.propPageValue = propPageValue;
    }
}