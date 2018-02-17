package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import managers.ImageManager;

public class MainController implements Initializable {

	private ImageManager imageManager = new ImageManager();
	
	@FXML
	private ImagesController myImageController;
	
	@FXML
	private FilterController myFilterController;
	@FXML
	
	private OpenFolderController myOpenFolderController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		imageManager.setControllers(myImageController, myFilterController, myOpenFolderController);	
		
		setImageManagerInControllers();
		
	}
	
	private void setImageManagerInControllers() {
		
		myImageController.setImageManager(imageManager);
		myFilterController.setImageManager(imageManager);
		myOpenFolderController.setImageManager(imageManager);
		
	}

}
