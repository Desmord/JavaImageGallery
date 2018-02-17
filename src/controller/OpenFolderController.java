package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import managers.ImageManager;

public class OpenFolderController implements Initializable {

	private ImageManager imageManager = new ImageManager();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("Inicjalizacja otwierania folderu kontrolera");
		
	}

	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}
	
}
