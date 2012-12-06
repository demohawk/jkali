package com.jkali.client.application;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SnapShotTest extends Application {

	private final String INITIAL_TEXT = "<head></head><body><p style=\"\"text-align:\" center; font-size:36pt;\"><font face=\"\"Arial\"\">emptyText</font></p></body>";
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("WebView Snapshot Sample");
		stage.setWidth(500);
		stage.setHeight(500);
		Scene scene = new Scene(new Group());
 
		final VBox root = new VBox();
		root.setPadding(new Insets(8, 8, 8, 8));
		root.setSpacing(5);
 
		WebView webView = new WebView();
		webView.getEngine().loadContent(INITIAL_TEXT);
 
		//		Button snapshotButton = new Button("Snapshot");
		//		snapshotButton.setOnAction(new EventHandler<ActionEvent>() {
		//
		//			@Override
		//			public void handle(ActionEvent arg0) {
		//				createSnapShot(root);
		//			}
		//		});
		//
		//		root.getChildren().addAll(webView, new Label("Test Label"), snapshotButton);
		root.getChildren().addAll(webView, new Label("Test Label"));
 
		scene.setRoot(root);
		stage.setScene(scene);
 
		createSnapShot(root);
 
		stage.show();

	}
	
	
	private void createSnapShot(final Node node) {
		Platform.runLater(new Runnable() {
 
			@Override
			public void run() {
				SnapshotParameters params = new SnapshotParameters();
				Image image = node.snapshot(params, null);
				System.out.println("snapshot image created");
 
				try {
					ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("d:\\output.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
 
			}
		});
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
