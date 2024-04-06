package com.example;

import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryController extends Application {
    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Selecciona tu fecha de nacimiento:");

        DatePicker datePicker = new DatePicker();
        Button button = new Button("Calcular edad");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, datePicker, button);

        button.setOnAction(event -> {
            LocalDate fechaSeleccionada = datePicker.getValue();
            LocalDate fechaActual = LocalDate.now();
            Period period = Period.between(fechaSeleccionada, fechaActual);
            if (fechaSeleccionada.getMonth().getValue()<(fechaActual.getMonth().getValue())) {
               period = period.minusYears(1);
            }
            System.out.println("Su edad es: " + period.getYears());
        });
        

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Caculadora Edad");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


