package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import managers.ImageManager;

public class OpenFolderController implements Initializable {

	private ImageManager imageManager = new ImageManager();

	@FXML
	private Button openFolderButton;

	@FXML
	private Label openFolderLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjalizacja otwierania folderu kontrolera");

	}

	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}

	private Button getOpenFolderButton() {
		return openFolderButton;
	}

	private void setOpenFolderButton(Button openFolderButton) {
		this.openFolderButton = openFolderButton;
	}

	private Label getOpenFolderLabel() {
		return openFolderLabel;
	}

	private void setOpenFolderLabel(Label openFolderLabel) {
		this.openFolderLabel = openFolderLabel;
	}

}
