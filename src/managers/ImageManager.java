package managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controller.FilterController;
import controller.ImagesController;
import controller.OpenFolderController;
import javafx.stage.DirectoryChooser;

public class ImageManager {

	private ImagesController myImageController;
	private FilterController myFilterController;
	private OpenFolderController myOpenFolderController;
	private List<File> fullImageList = new ArrayList<>();
	private List<File> curentImageList = new ArrayList<>();

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

					disableElements();

					System.out.println("pusty folder i puste curent ");
					// tutaj blokowanie wszyskiego i wyswietlanie ze nie ma zadnych zdjec
					// zmiana labelu ze jest pusy
				} else {

					System.out.println("Nic nie wczytano ale jest kurent");

				}

			} else {

				setCurentImageList(getSelectedDirectoryFileList(selectedDirectory));
				anableElements();

				System.out.println("gotowe i dobrze" + getFullImageList().size());
				// tutaj odblokowanie wszystekogi i gotowe
				// label ok
			}

		} else {

			if (isImageListEmpty(getFullImageList())) {

				disableElements();

				System.out.println("Tutaj anuluj");
				// tutaj blad nie wybranego image ----- anuluj
				// getFolderPathButton().setText(directory.toString());

			}

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

	private List<File> getFullImageList() {
		return fullImageList;
	}

	private void setFullImageList(List<File> fullImageList) {
		this.fullImageList = fullImageList;
	}

	private List<File> getCurentImageList() {
		return curentImageList;
	}

	private void setCurentImageList(List<File> curentImageList) {
		this.curentImageList = curentImageList;
	}

}
