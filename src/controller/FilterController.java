package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import managers.ImageManager;

public class FilterController implements Initializable {

	private ImageManager imageManager = new ImageManager();

	@FXML
	private Button filterButton;

	@FXML
	private Button clearFilterButton;

	@FXML
	private ChoiceBox<?> minorChoiceBox;

	@FXML
	private ChoiceBox<?> majorChoiceBox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Inicjalizacja kontroleru filtru");

	}

	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}

	private Button getFilterButton() {
		return filterButton;
	}

	private void setFilterButton(Button filterButton) {
		this.filterButton = filterButton;
	}

	private Button getClearFilterButton() {
		return clearFilterButton;
	}

	private void setClearFilterButton(Button clearFilterButton) {
		this.clearFilterButton = clearFilterButton;
	}

	private ChoiceBox<?> getMinorChoiceBox() {
		return minorChoiceBox;
	}

	private void setMinorChoiceBox(ChoiceBox<?> minorChoiceBox) {
		this.minorChoiceBox = minorChoiceBox;
	}

	private ChoiceBox<?> getMajorChoiceBox() {
		return majorChoiceBox;
	}

	private void setMajorChoiceBox(ChoiceBox<?> majorChoiceBox) {
		this.majorChoiceBox = majorChoiceBox;
	}

}
