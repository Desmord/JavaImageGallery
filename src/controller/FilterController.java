package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import managers.ImageManager;

public class FilterController implements Initializable {

	private ImageManager imageManager = new ImageManager();
	private ObservableList<String> sizeList = FXCollections.observableArrayList("> 2500px", "2500px < > 1500px",
			"< 1500px");
	private ObservableList<String> wageList = FXCollections.observableArrayList("> 2MB ", "2MB < > 1MB", "< 1BM");
	private ObservableList<String> typeList = FXCollections.observableArrayList("Jpeg", "Jpg", "Bmp", "Png");

	@FXML
	private Button filterButton;

	@FXML
	private Button clearFilterButton;

	@FXML
	private ChoiceBox<String> minorChoiceBox;

	@FXML
	private ChoiceBox<String> majorChoiceBox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		disableElements();

		setMainFilterItems();
		
	}

	public void disableElements() {

		getFilterButton().setDisable(true);
		getClearFilterButton().setDisable(true);
		getMinorChoiceBox().setDisable(true);
		getMajorChoiceBox().setDisable(true);

	}

	public void anableElements() {

		getFilterButton().setDisable(false);
		getClearFilterButton().setDisable(false);
		getMinorChoiceBox().setDisable(false);
		getMajorChoiceBox().setDisable(false);

	}

	private void setMainFilterItems() {

		majorChoiceBox.setItems(FXCollections.observableArrayList("Rozmiar", "Rodzaj", "Rozmiary na dysku"));

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

	private void setMinorChoiceBox(ChoiceBox<String> minorChoiceBox) {
		this.minorChoiceBox = minorChoiceBox;
	}

	private ChoiceBox<?> getMajorChoiceBox() {
		return majorChoiceBox;
	}

	private void setMajorChoiceBox(ChoiceBox<String> majorChoiceBox) {
		this.majorChoiceBox = majorChoiceBox;
	}

}
