/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthur.controller;

import com.arthur.entity.Category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class ManageFormController implements Initializable {

    @FXML
    private TableView<Category> tableCategory;
    @FXML
    private TableColumn<Category, String> columnID;
    @FXML
    private TableColumn<Category, String> columnName;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtName;
    @FXML
    private BorderPane root;

    private MainFormController mainController;

    public void setMainController(MainFormController mainController) {
        this.mainController = mainController;
        tableCategory.setItems(mainController.getCategories());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnID.setCellValueFactory(d -> {
            Category c = (Category) d.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(c.getId());
            return new SimpleStringProperty(sb.toString());
        });
        columnName.setCellValueFactory(d -> {
            Category c = (Category) d.getValue();
            return new SimpleStringProperty(c.getName());
        });
    }

    @FXML
    private void saveCategory(ActionEvent event) {
        Category c = new Category();
        c.setId(Integer.valueOf(txtID.getText().trim()));
        c.setName(txtName.getText().trim());
        mainController.getCategories().add(c);
        tableCategory.refresh();
    }

}
