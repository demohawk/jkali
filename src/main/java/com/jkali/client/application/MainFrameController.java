/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.WindowEvent;
import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.DefaultController;

/**
 *
 * @author Paul
 */
public class MainFrameController extends DefaultController<MainFrameModel, MainFrameView> {

    /**
     * Default Constructor.
     *
     * @param view the view to control
     *
     * @throws CoreException if an error occurred while creating event handlers
     */
    public MainFrameController(final MainFrameView view) throws CoreException {
        super(view);
    }

    @Override
    protected void customInitializeEventHandlers() throws CoreException {

        

    }
}
