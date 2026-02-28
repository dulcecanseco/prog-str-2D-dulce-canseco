package com.example.login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage window;
    private Scene loginScene, dashScene;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle(" Sistema de Login");

        Label titulo = new Label("Inicio de sesion");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuario (mín. 4)");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Correo (debe tener @ y .)");

        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Contraseña (mín. 6)");

        Button btnLogin = new Button("Entrar");
        Label lblError = new Label();
        lblError.setTextFill(Color.RED);

        VBox layoutLogin = new VBox(15);
        layoutLogin.setPadding(new Insets(30));
        layoutLogin.setAlignment(Pos.CENTER);
        layoutLogin.getChildren().addAll(titulo, txtUsuario, txtEmail, txtPass, btnLogin, lblError);

        loginScene = new Scene(layoutLogin, 350, 450);

        btnLogin.setOnAction(e -> {
            String user = txtUsuario.getText();
            String email = txtEmail.getText();
            String pass = txtPass.getText();

            if (user.length() < 4) {
                lblError.setText("Error: Usuario muy corto.");
            } else if (!email.contains("@") || !email.contains(".")) {
                lblError.setText("Error: Correo no válido.");
            } else if (pass.length() < 6) {
                lblError.setText("Error: Contraseña muy corta.");
            } else {
                mostrarDashboard(user);
            }
        });

        window.setScene(loginScene);
        window.show();
    }

    private void mostrarDashboard(String nombreUsuario) {

        Label lblBienvenida = new Label("Bienvenido, " + nombreUsuario);
        lblBienvenida.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Button btnSalir = new Button("Cerrar Sesión");
        btnSalir.setOnAction(e -> window.setScene(loginScene));

        VBox layoutDash = new VBox(20);
        layoutDash.setAlignment(Pos.CENTER);
        layoutDash.getChildren().addAll(lblBienvenida, btnSalir);

        dashScene = new Scene(layoutDash, 350, 450);
        window.setScene(dashScene);
    }

    public static void main(String[] args) {
        launch();
    }
}