package com.jkali.client.page;

import javafx.scene.input.MouseEvent;
import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.DefaultController;

/**
 * The class <strong>AbstractSlideController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @param <M> The SlideModel class
 * @param <V> The SlideView class
 */
public abstract class AbstractPageController<M extends AbstractPageModel<M, V, ?>, V extends AbstractPageView<M, ?, ? extends AbstractPageController<M, V>>>
        extends DefaultController<M, V> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public AbstractPageController(final V view) throws CoreException {
        super(view);
    }
    
         @Override
    protected void customInitializeEventHandlers() throws CoreException {

//        linkCommand(getView().getOpenButton(), MouseEvent.MOUSE_CLICKED, OpenEventTrackerFileCommand.class);
         linkWave(getView().getGridPageBar().getPostButton(), MouseEvent.MOUSE_CLICKED, PageWave.DO_POST_PAGE);
//        linkWave(getView().getPlayPauseButton(), MouseEvent.MOUSE_CLICKED, EditorWaves.DO_PLAY);
//        linkWave(getView().getBackwardButton(), MouseEvent.MOUSE_CLICKED, EditorWaves.DO_PREVIOUS);
//        linkWave(getView().getForwardButton(), MouseEvent.MOUSE_CLICKED, EditorWaves.DO_NEXT);
//        linkWave(getView().getStopButton(), MouseEvent.MOUSE_CLICKED, EditorWaves.DO_STOP);

        // Register mouse clicked handler
        // getView().getOpenButton().setOnMouseClicked(getMouseHandler());
        // getView().getUnloadButton().setOnMouseClicked(getMouseHandler());
        // getView().getPlayPauseButton().setOnMouseClicked(getMouseHandler());
        // getView().getForwardButton().setOnMouseClicked(getMouseHandler());
        // getView().getBackwardButton().setOnMouseClicked(getMouseHandler());
        // getView().getStopButton().setOnMouseClicked(getMouseHandler());
    }

}
