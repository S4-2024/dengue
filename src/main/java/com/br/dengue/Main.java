package com.br.dengue;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static final String[] PERGUNTAS = {
            "Febre alta de início abrupto",
            "Forte dor de cabeça",
            "Dor atrás dos olhos",
            "Perda de paladar e apetite",
            "Náuseas e vômitos",
            "Tonturas",
            "Extremo cansaço",
            "Manchas e erupções na pele",
            "Moleza e dor no corpo",
            "Dor nas articulações"
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Verificador de Dengue");

        VBox vbox = new VBox(10);
        List<CheckBox> checkBoxes = new ArrayList<>();

        for (String pergunta : PERGUNTAS) {
            CheckBox checkBox = new CheckBox(pergunta);
            checkBoxes.add(checkBox);
            vbox.getChildren().add(checkBox);
        }

        Button verificarButton = new Button("Verificar");
        verificarButton.setOnAction(e -> {
            long count = checkBoxes.stream().filter(CheckBox::isSelected).count();
            String message = count > 5 ? "Você está com dengue!" : "Não está com dengue!";
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });

        vbox.getChildren().add(verificarButton);

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
