package com.jkali.client.ui.manual;

import com.jkali.client.AppWaves;
import com.jkali.client.MainFrame;
import com.jkali.client.application.MainFrameModel;
import com.jkali.client.page.GridPageModel;
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
public class TestJkali extends AbstractApplication<StackPane>{
    
    private static boolean isApplet = false;
    private static TestJkali testJkali;


    
    /**
     * Get the singleton instance of MainFrame
     * 
     * @return The singleton instance
     */
    public static TestJkali getTestJkali() {
        return testJkali;
    }
    
    /**
    * Application launcher.
    *
    * @param args the command line arguments
    */
    public static void main(final String... args) {
        Application.launch(TestJkali.class, args);
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
                scene.getStylesheets().add(MainFrame.class.getResource("main.css").toExternalForm());
                scene.getStylesheets().add(MainFrame.class.getResource("ensemble2.css").toExternalForm());
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


    
   
}
