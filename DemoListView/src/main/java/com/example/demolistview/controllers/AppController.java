package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service= new PersonService();

    @FXML
    public void initialize(){ //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView

        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener( (obs,oldvValue, newValue) -> {
            loadDataToForm(newValue); //string con el valor de row 0 test-email@gmail.com-18
        }
    );
        listView.setItems(data);
    }

    @FXML
    public void onAddPerson(){
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();

            service.addPerson(name,email,edad);
            lblMsg.setText("persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();

        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try{
            service.updatePerson(index,name,email,edad);
            loadFromFile();
            lblMsg.setText("persona actualizada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    private void loadDataToForm(String item){

        String [] parts = item.split("-");
        txtName.setText(parts[0]);//Corresponde a la parte del nombre
        txtEmail.setText(parts[1]);//Corresponde a la parte del email
        txtEdad.setText(parts[2]);//Corresponde a la parte de la edad


    }

}