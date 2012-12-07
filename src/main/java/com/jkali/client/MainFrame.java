/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client;

import com.jkali.client.application.Function;
import com.jkali.client.application.MainFrameModel;
import com.jkali.client.page.GridPageModel;
import com.jkali.client.ui.manual.ManualPageModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;


import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jrebirth.core.application.AbstractApplication;
import org.jrebirth.core.resource.font.FontEnum;
import org.jrebirth.core.ui.Model;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.core.wave.WaveBuilder;

/**
 *
 * @author Paul
 */
public class MainFrame extends AbstractApplication<StackPane>{
    
    private static boolean isApplet = false;
    private static MainFrame mainFrame;

    private static List<Function> history = new ArrayList<Function>();


    
    /**
     * Get the singleton instance of MainFrame
     * 
     * @return The singleton instance
     */
    public static MainFrame getMainFrame() {
        return mainFrame;
    }
    
    /**
    * Application launcher.
    *
    * @param args the command line arguments
    */
    public static void main(final String... args) {
        Application.launch(MainFrame.class, args);
    }

    /**
* {@inheritDoc}
*/
    @Override
    public Class<? extends Model> getFirstModelClass() {
        return MainFrameModel.class;
    }

    /**
* {@inheritDoc}
*/
    @Override
    protected String getApplicationTitle() {
        return "MainFrame";
    }

    /**
* {@inheritDoc}
*/
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
       
        stage.setTitle("PDM");
        stage.setWidth(1200);
//        if (!isApplet) {
//            stage.initStyle(StageStyle.UNDECORATED);
//           
//        } 

    }

    /**
* {@inheritDoc}
*/
    @Override
    protected void customizeScene(final Scene scene) {

        Platform.runLater(new Runnable() {

            @Override
            public void run() {    
                scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("ensemble2.css").toExternalForm());
            }
        });
         // set default docs location 
        // create root stack pane that we use to be able to overlay proxy dialog
       

    }

    @Override
    public List<Wave> getPreBootWaveList() {
        return Collections.emptyList();
    }

    @Override
    public List<Wave> getPostBootWaveList() {
        final List<Wave> waveList = new ArrayList<>();
                waveList.add(
                        WaveBuilder.create()
                                .waveType(AppWaves.DO_START)
                                .build()
                        );
        return waveList;
    
    }

    @Override
    protected List<FontEnum> getFontToPreload() {
        return Collections.emptyList();
    }

	public static List<Function> getHistory() {
		return history;
	}

	public static void setHistory(List<Function> history) {
		MainFrame.history = history;
	}
    
   
}
