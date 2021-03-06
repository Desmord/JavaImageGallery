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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

		setElementsClickEvents();

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

	private void setElementsClickEvents() {

		setMainFilterClickEvent();
		setFilterButtonClickEvent();
		setClearFilterClickEvent();

	}

	private void setMainFilterClickEvent() {
		majorChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				minorChoiceBox.setDisable(false);
				setSecondartFilterItems(majorChoiceBox.getValue());

			}
		});
	}

	private void setSecondartFilterItems(String type) {

		if (type.equals("Rozmiar")) {
			minorChoiceBox.setItems(sizeList);
		} else if (type.equals("Rodzaj")) {
			minorChoiceBox.setItems(typeList);
		} else {
			minorChoiceBox.setItems(wageList);
		}

	}

	private void setFilterButtonClickEvent() {
		filterButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				filterMain(majorChoiceBox.getValue());

			}
		});
	}

	private void filterMain(String filterType) {

		if (isFiltersChosen()) {

			if (filterType.equals("Rozmiar")) {
				filterSize();
			} else if (filterType.equals("Rozmiary na dysku")) {
				filterWage();
			} else {
				filterType();
			}
		}

	}

	private boolean isFiltersChosen() {

		if (majorChoiceBox.getValue() == null || minorChoiceBox.getValue() == null) {
			return false;
		} else {
			return true;
		}

	}

	private void filterSize() {

		if (minorChoiceBox.getValue().equals("> 2500px")) {
			imageManager.filterBigSize();
		} else if (minorChoiceBox.getValue().equals("2500px < > 1500px")) {
			imageManager.filterMediumSize();
		} else {
			imageManager.filterSmallSize();
		}
	}

	private void filterWage() {

		if (minorChoiceBox.getValue().equals("> 2MB ")) {
			imageManager.filterBigWage();
		} else if (minorChoiceBox.getValue().equals("2MB < > 1MB")) {
			imageManager.filterMediumWage();
		} else {
			imageManager.filterSmallWage();
		}
	}

	private void filterType() {

		if (minorChoiceBox.getValue().equals("Jpeg")) {
			imageManager.filterJpeg();
		} else if (minorChoiceBox.getValue().equals("Jpg")) {
			imageManager.filterJpg();
		} else if (minorChoiceBox.getValue().equals("Bmp")) {
			imageManager.filterBmp();
		} else {
			imageManager.filterPng();
		}
	}
	
	private void setClearFilterClickEvent() {

		clearFilterButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				imageManager.setCurentImageList(imageManager.getFullImageList());
				imageManager.setMainImageIndex(0);
				
				imageManager.displayCurrentImages();

				imageManager.clearLabelInfoText();
				
			}
		});

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
