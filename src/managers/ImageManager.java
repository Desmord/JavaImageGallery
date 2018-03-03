package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import controller.FilterController;
import controller.ImagesController;
import controller.OpenFolderController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;

public class ImageManager {

	private ImagesController myImageController;
	private FilterController myFilterController;
	private OpenFolderController myOpenFolderController;
	private List<File> fullImageList = new ArrayList<>();
	private List<File> curentImageList = new ArrayList<>();
	private int mainImageIndex = 0;

	public void setControllers(ImagesController imageController, FilterController filterController,
			OpenFolderController openFolderController) {

		this.myImageController = imageController;
		this.myFilterController = filterController;
		this.myOpenFolderController = openFolderController;

	}

	public void setImages() {

		File selectedDirectory = getDirectory();

		if (isDirectorySelected(selectedDirectory)) {

			setFullImageList(getSelectedDirectoryFileList(selectedDirectory));

			if (isImageListEmpty(getFullImageList())) {

				if (isImageListEmpty(getCurentImageList())) {

					// Empty current imageList and empty folder
					disableElements();

					this.myOpenFolderController
							.setInfoLabelText("Brak zdj�� w folderze: " + selectedDirectory.toString());

				} else {

					// Empty folder but current ImageList is not empty
					this.myOpenFolderController
							.setInfoLabelText("Brak zdj�� w folderze: " + selectedDirectory.toString());

				}

			} else {

				// Folder contains images
				setCurentImageList(getSelectedDirectoryFileList(selectedDirectory));

				setMainImageIndex(0);

				displayCurrentImages();

				this.myOpenFolderController.setOpenFolderLabelText(selectedDirectory.toString());
				this.myOpenFolderController.clearInfoLabelText();

				// ustawianie tekstu filtrow na zero
			}

		} else {

			if (isImageListEmpty(getCurentImageList())) {

				// Cancel and current imageList is empty
				disableElements();

				this.myOpenFolderController.setInfoLabelText("Anulowano wyb�r, lista zdj�� pusta.");

				System.out.println("Tutaj anuluj");

			} else {

				// Cancel but current imageList is not empty
				this.myOpenFolderController.setInfoLabelText("Anulowano wyb�r.");

			}

		}

	}

	public void displayCurrentImages() {

		if (getCurentImageList().size() == 1) {

			displayImage(getCurentImageList().get(getMainImageIndex()), myImageController.getMainImageView());

		} else if (getCurentImageList().size() == 2) {

			anableElements();

			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex())),
					myImageController.getMainImageView());

			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex() + 1)),
					myImageController.getFirstMinorImageView());
			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex() + 1)),
					myImageController.getThirdMinorImageView());

		} else {
			anableElements();

			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex())),
					myImageController.getMainImageView());

			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex() - 1)),
					myImageController.getFirstMinorImageView());
			displayImage(getCurentImageList().get(isIndexOutOfListRange(getMainImageIndex() + 1)),
					myImageController.getThirdMinorImageView());

		}
		this.myImageController.setImageNumberLabelText(getMainImageIndex() + 1 + " / " + getCurentImageList().size());
	}

	public void setPreviousImage() {

		setMainImageIndex(isIndexOutOfListRange(getMainImageIndex() - 1));

		displayCurrentImages();

		this.myImageController.setImageNumberLabelText(getMainImageIndex() + 1 + " / " + getCurentImageList().size());

	}

	public void setNextImage() {

		setMainImageIndex(isIndexOutOfListRange(getMainImageIndex() + 1));

		displayCurrentImages();

		this.myImageController.setImageNumberLabelText(getMainImageIndex() + 1 + " / " + getCurentImageList().size());
		
	}

	private void displayImage(File file, ImageView imageView) {

		try {

			Image image = new Image(new FileInputStream(file.getPath()));

			setImage(imageView, image);

		} catch (FileNotFoundException e) {
			System.out.println("B��d wczytania pliku.");
		}

	}

	private File getDirectory() {

		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Wybierz folder");
		File selectedDirectory = chooser.showDialog(null);

		return selectedDirectory;

	}

	private boolean isDirectorySelected(File directory) {

		if (directory == null) {
			return false;
		} else {
			return true;
		}

	}

	private List<File> getSelectedDirectoryFileList(File directory) {

		List<File> imageList = new ArrayList<>();

		File[] listOfFiles = directory.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {

				if (isImage(file)) {
					imageList.add(file);
				}

			}
		}

		return imageList;
	}

	private boolean isImage(File file) {

		if (file.getName().matches("([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)")) {
			return true;
		}

		return false;
	}

	private boolean isImageListEmpty(List<File> list) {

		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	private void anableElements() {

		myFilterController.anableElements();
		myImageController.anableElements();

	}

	private void disableElements() {

		myFilterController.disableElements();
		myImageController.disableElements();

	}

	private void setImage(ImageView imageView, Image image) {

		if (imageView.getFitWidth() > 200) {
			setMainImage(imageView, image);
		} else {
			setMinorImage(imageView, image);
		}

	}

	private void setMainImage(ImageView imageView, Image image) {

		double aspectRatio = image.getWidth() / image.getHeight();
		double realWidth = Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio);
		double realHeight = Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio);

		imageView.setImage(image);
		imageView.setFitWidth(950);
		imageView.setFitHeight(450);
		imageView.setPreserveRatio(true);
		imageView.setTranslateX((1050 - realWidth) / 2);

	}

	private void setMinorImage(ImageView imageView, Image image) {

		double aspectRatio = image.getWidth() / image.getHeight();
		double realWidth = Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio);
		double realHeight = Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio);

		imageView.setImage(image);
		imageView.setFitWidth(150);
		imageView.setFitHeight(100);
		imageView.setPreserveRatio(true);

	}

	private void centerSecondaryImage(ImageView imageView, Image image) {

		double aspectRatio = image.getWidth() / image.getHeight();
		double realWidth = Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio);
		double realHeight = Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio);

		imageView.setTranslateX((100 - realWidth) / 2);

	}

	/**
	 * Checks whether the given index is larger than the size of the array or less
	 * than 0.
	 * 
	 * @param index
	 * @return proper index
	 */

	private int isIndexOutOfListRange(int index) {

		if (index >= getCurentImageList().size()) {
			return 0;
		} else if (index < 0) {
			return getCurentImageList().size() - 1;
		} else {
			return index;
		}

	}

	public void setMainImageIndex(int index) {
		mainImageIndex = index;
	}

	private int getMainImageIndex() {
		return mainImageIndex;
	}

	private ImagesController getMyImageController() {
		return myImageController;
	}

	private void setMyImageController(ImagesController myImageController) {
		this.myImageController = myImageController;
	}

	private FilterController getMyFilterController() {
		return myFilterController;
	}

	private void setMyFilterController(FilterController myFilterController) {
		this.myFilterController = myFilterController;
	}

	private OpenFolderController getMyOpenFolderController() {
		return myOpenFolderController;
	}

	private void setMyOpenFolderController(OpenFolderController myOpenFolderController) {
		this.myOpenFolderController = myOpenFolderController;
	}

	public List<File> getFullImageList() {
		return fullImageList;
	}

	private void setFullImageList(List<File> fullImageList) {
		this.fullImageList = fullImageList;
	}

	private List<File> getCurentImageList() {
		return curentImageList;
	}

	public void setCurentImageList(List<File> curentImageList) {
		this.curentImageList = curentImageList;
	}

}
