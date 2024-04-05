package com.main;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PrimaryController {

    @FXML
    private VBox VBox;

    @FXML
    private Button dacButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void click(ActionEvent event) {

    }
}
