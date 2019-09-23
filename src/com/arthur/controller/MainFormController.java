/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthur.controller;

import com.arthur.MainApp;
import com.arthur.entity.Category;
import com.arthur.entity.Item;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class MainFormController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<Category> cbCategory;
    @FXML
    private DatePicker dpExpDate;
    @FXML
    private TableView<Item> tableItem;
    @FXML
    private TableColumn<Item, String> columnID;
    @FXML
    private TableColumn<Item, String> columnName;
    @FXML
    private TableColumn<Item, String> columnCategory;
    @FXML
    private TableColumn<Item, String> columnExpDate;

    private Stage secondStage;

    private ObservableList<Category> categories;
    @FXML
    private Button btnUpdate;

    public ObservableList<Category> getCategories() {
        if (categories == null) {
            categories = FXCollections.observableArrayList();
        }
        return categories;
    }

    private ObservableList<Item> items;

    public ObservableList<Item> getItems() {
        if (items == null) {
            items = FXCollections.observableArrayList();
        }
        return items;
    }

    private Item selectedItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableItem.setItems(getItems());
        cbCategory.setItems(getCategories());

        columnID.setCellValueFactory(d -> {
            Item i = (Item) d.getValue();
            return new SimpleStringProperty(String.valueOf(i.getId()));
        });
        columnName.setCellValueFactory(d -> {
            Item i = (Item) d.getValue();
            return new SimpleStringProperty(i.getName());
        });
        columnCategory.setCellValueFactory(d -> {
            Item i = (Item) d.getValue();
            return new SimpleStringProperty(i.getCategory().getName());
        });
        columnExpDate.setCellValueFactory(d -> {
            Item i = (Item) d.getValue();
            return new SimpleStringProperty(i.getExpDate());
        });
    }

    @FXML
    private void callformAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.
                    setLocation(MainApp.class.
                            getResource("view/ManageForm.fxml"));
            BorderPane root = loader.load();
            ManageFormController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(root);
            secondStage = new Stage();
            secondStage.initModality(Modality.WINDOW_MODAL);
            secondStage.initOwner(root.getScene().getWindow());
            secondStage.setScene(scene);
            secondStage.setTitle("JavaFX Stage");
            secondStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ManageFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Created By");
        alert.setContentText("Arthur Damarwulan (1672025)");
        alert.showAndWait();
    }

    @FXML
    private void btnSave(ActionEvent event) {
        Item i = new Item();
        i.setId(Integer.valueOf(txtId.getText().trim()));
        i.setName(txtName.getText().trim());
        i.setCategory(cbCategory.getValue());
        i.setExpDate(dpExpDate.getValue().toString());
        getItems().add(i);
        tableItem.refresh();
    }

    @FXML
    private void btnReset(ActionEvent event) {
        selectedItem = null;
        btnUpdate.setDisable(true);
        txtId.clear();
        txtName.clear();
    }

    @FXML
    private void tbItemClicked(MouseEvent event) {
        selectedItem = tableItem.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            btnUpdate.setDisable(false);
        }
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
    }

}
