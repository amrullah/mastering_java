package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        System.out.println("The Following Button was pressed: " + e.getSource());
        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello " + nameField.getText());
            nameField.setText("Hello " + nameField.getText());
        }
        if (e.getSource().equals(byeButton)) {
            System.out.println("Bye " + nameField.getText());
            nameField.setText("Bye " + nameField.getText());
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isBlank();  // isEmpty will only work for zero length string

        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
}
