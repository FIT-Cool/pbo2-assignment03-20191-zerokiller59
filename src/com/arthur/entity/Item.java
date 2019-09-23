/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthur.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Arthur
 */
public class Item {

    private final IntegerProperty id = new SimpleIntegerProperty();

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    private final StringProperty name = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    private final ObjectProperty<Category> category
            = new SimpleObjectProperty<>();

    public Category getCategory() {
        return category.get();
    }

    public void setCategory(Category value) {
        category.set(value);
    }

    public ObjectProperty categoryProperty() {
        return category;
    }
    private final StringProperty expDate = new SimpleStringProperty();

    public String getExpDate() {
        return expDate.get();
    }

    public void setExpDate(String value) {
        expDate.set(value);
    }

    public StringProperty expDateProperty() {
        return expDate;
    }

}
