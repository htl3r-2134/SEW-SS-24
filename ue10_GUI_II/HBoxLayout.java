package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HBoxLayout extends Application {

    private int abstandGUI;
    private int rahmenabstandrechts;
    private int rahmenabstandlinks;
    private int rahmenabstandoben;
    private int rahmenabstandunten;
    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Eingabe");
        primarystage.centerOnScreen();
        Group group = new Group();
        Scene scene = new Scene(group, 270, 120);
        primarystage.setScene(scene);


        Label label = new Label("Abstand zwischen den GUI Elementen");
        label.setLayoutY(10);
        label.setLayoutX(10);

        TextField textField = new TextField();
        textField.setLayoutY(30);
        textField.setLayoutX(10);
        textField.setPrefWidth(250);


        Button ok = new Button("OK");
        Button abbrechen = new Button("Abbrechen");
        ok.setLayoutX(40);
        ok.setLayoutY(65);
        ok.setPrefWidth(75);
        abbrechen.setLayoutX(150);
        abbrechen.setLayoutY(65);
        abbrechen.setPrefWidth(75);

        Button ok2 = new Button("OK");
        ok2.setLayoutX(40);
        ok2.setLayoutY(65);
        ok2.setPrefWidth(75);

        Button ok3 = new Button("OK");
        ok3.setLayoutX(40);
        ok3.setLayoutY(65);
        ok3.setPrefWidth(75);


        group.getChildren().addAll(label, textField, ok, abbrechen);

        primarystage.show();

        ok.setOnAction(ActionEvent -> {
            abstandGUI += Integer.parseInt(textField.getText());
            label.setText("Rahmen Abstände: oben, rechts, unten, links");
            textField.clear();
            group.getChildren().add(ok2);
        });
        ok2.setOnAction(ActionEvent -> {
            String[] werte = textField.getText().split(",");
            String[] rahmenabstaende = new String[4];
            for (int i = 0; i < werte.length; i++) {
                rahmenabstaende[i] = "";
                for (int j = 0; j < werte[i].length(); j++) {
                    if (werte[i].charAt(j) != ' ') {
                        rahmenabstaende[i] += werte[i].charAt(j);
                    }
                }
            }
            rahmenabstandoben += Integer.parseInt(rahmenabstaende[0]);
            rahmenabstandrechts += Integer.parseInt(rahmenabstaende[1]);
            rahmenabstandunten += Integer.parseInt(rahmenabstaende[2]);
            rahmenabstandlinks += Integer.parseInt(rahmenabstaende[3]);
            label.setText("Position im Fenster: [oben | mitte | unten], [links | mitte | rechts]");
            primarystage.setWidth(370);
            textField.clear();
            textField.setPrefWidth(335);
            ok.setLayoutX(80);
            ok2.setLayoutX(80);
            ok3.setLayoutX(80);
            abbrechen.setLayoutX(200);
            group.getChildren().add(ok3);
        });
        ok3.setOnAction(ActionEvent -> {
            primarystage.setTitle("Hbox Test");
            HBox hBox = new HBox();
            Scene scene2 = new Scene(hBox, 300, 300);
            primarystage.setScene(scene2);

            String[] Position = textField.getText().split(",");
            String[] PositionImFenster = new String[Position.length];
            for (int i = 0; i < Position.length; i++) {
                PositionImFenster[i] = "";
                for (int j = 0; j < Position[i].length(); j++) {
                    if (Character.isLetter(Position[i].charAt(j))) {
                        PositionImFenster[i] += Position[i].charAt(j);
                    }
                }
            }

            Button button1 = new Button("button 1");
            Button button2 = new Button("button 2");

            Label label1 = new Label("label 1");
            Label label2 = new Label("label 2");

            hBox.setSpacing(abstandGUI);
            hBox.setPadding(new Insets(rahmenabstandoben, rahmenabstandrechts, rahmenabstandunten, rahmenabstandlinks));

            if (PositionImFenster[0].toLowerCase().equals("oben") && PositionImFenster[1].toLowerCase().equals("mitte")) {
                hBox.setAlignment(Pos.TOP_CENTER);
            }
            if (PositionImFenster[0].toLowerCase().equals("oben") && PositionImFenster[1].toLowerCase().equals("rechts")) {
                hBox.setAlignment(Pos.TOP_RIGHT);
            }
            if (PositionImFenster[0].toLowerCase().equals("oben") && PositionImFenster[1].toLowerCase().equals("links")) {
                hBox.setAlignment(Pos.TOP_LEFT);
            }

            if (PositionImFenster[0].toLowerCase().equals("mitte") && PositionImFenster[1].toLowerCase().equals("mitte")) {
                hBox.setAlignment(Pos.CENTER);
            }
            if (PositionImFenster[0].toLowerCase().equals("mitte") && PositionImFenster[1].toLowerCase().equals("rechts")) {
                hBox.setAlignment(Pos.CENTER_RIGHT);
            }
            if (PositionImFenster[0].toLowerCase().equals("mitte") && PositionImFenster[1].toLowerCase().equals("links")) {
                hBox.setAlignment(Pos.CENTER_LEFT);
            }

            if (PositionImFenster[0].toLowerCase().equals("unten") && PositionImFenster[1].toLowerCase().equals("mitte")) {
                hBox.setAlignment(Pos.BOTTOM_CENTER);
            }
            if (PositionImFenster[0].toLowerCase().equals("unten") && PositionImFenster[1].toLowerCase().equals("rechts")) {
                hBox.setAlignment(Pos.BOTTOM_RIGHT);
            }
            if (PositionImFenster[0].toLowerCase().equals("unten") && PositionImFenster[1].toLowerCase().equals("links")) {
                hBox.setAlignment(Pos.BOTTOM_LEFT);
            }

            hBox.getChildren().addAll(button1, label1, button2, label2);
            primarystage.show();
        });
        abbrechen.setOnAction(ActionEvent -> {
            primarystage.close();
        });
    }
}