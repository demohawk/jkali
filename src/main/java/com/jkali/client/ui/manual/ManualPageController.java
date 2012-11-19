package com.jkali.client.ui.manual;

import com.jkali.client.page.AbstractPageController;
import com.jkali.client.page.PageWave;
import javafx.scene.input.MouseEvent;
import org.jrebirth.core.exception.CoreException;

/**
 * The class <strong>ClassicController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 */
public final class ManualPageController extends AbstractPageController<ManualPageModel, ManualPageView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public ManualPageController(final ManualPageView view) throws CoreException {
        super(view);
    }

    
 
}
