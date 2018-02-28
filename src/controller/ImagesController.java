package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import managers.ImageManager;

public class ImagesController implements Initializable {
	
	private ImageManager imageManager = new ImageManager();
	
	@FXML
    private ImageView mainImageView;

    @FXML
    private ImageView firstMinorImageView;

    @FXML
    private ImageView secondMinorImageView;

    @FXML
    private ImageView thirdMinorImageView;

    @FXML
    private Button previousImageButton;

    @FXML
    private Button nextImageButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		disableElements();
		
	}
	
	public void disableElements() {
		
		getPreviousImageButton().setDisable(true);
		getNextImageButton().setDisable(true);
		
	}
	
	public void anableElements() {
		
		getPreviousImageButton().setDisable(false);
		getNextImageButton().setDisable(false);
		
	}

	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}

	public ImageView getMainImageView() {
		return mainImageView;
	}

	private void setMainImageView(ImageView mainImageView) {
		this.mainImageView = mainImageView;
	}

	public ImageView getFirstMinorImageView() {
		return firstMinorImageView;
	}

	private void setFirstMinorImageView(ImageView firstMinorImageView) {
		this.firstMinorImageView = firstMinorImageView;
	}

	public ImageView getSecondMinorImageView() {
		return secondMinorImageView;
	}

	private void setSecondMinorImageView(ImageView secondMinorImageView) {
		this.secondMinorImageView = secondMinorImageView;
	}

	public ImageView getThirdMinorImageView() {
		return thirdMinorImageView;
	}

	private void setThirdMinorImageView(ImageView thirdMinorImageView) {
		this.thirdMinorImageView = thirdMinorImageView;
	}

	private Button getPreviousImageButton() {
		return previousImageButton;
	}

	private void setPreviousImageButton(Button previousImageButton) {
		this.previousImageButton = previousImageButton;
	}

	private Button getNextImageButton() {
		return nextImageButton;
	}

	private void setNextImageButton(Button nextImageButton) {
		this.nextImageButton = nextImageButton;
	}
	
}
