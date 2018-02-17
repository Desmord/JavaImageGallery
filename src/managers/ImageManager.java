package managers;

import controller.FilterController;
import controller.ImagesController;
import controller.OpenFolderController;
import javafx.fxml.FXML;

public class ImageManager {

	private ImagesController myImageController;
	private FilterController myFilterController;	
	private OpenFolderController myOpenFolderController;
	
	public void setControllers(ImagesController imageController, FilterController filterController,OpenFolderController openFolderController) {
		this.myImageController = imageController;
		this.myFilterController = filterController;
		this.myOpenFolderController = openFolderController;
	}
	
	
}
