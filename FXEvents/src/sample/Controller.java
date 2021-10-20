package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox checkBox;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        System.out.println("The Following Button was pressed: " + e.getSource());
        if (e.getSource().equals(helloButton)) {
            nameField.setText("Hello " + nameField.getText());
        }
        if (e.getSource().equals(byeButton)) {
            nameField.setText("Bye " + nameField.getText());
        }

        // UI thread will go to sleep and make the application unresponsive
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException ignored) { }

        if (checkBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isBlank();  // isEmpty will only work for zero length string

        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleCheckBoxChange() {
        System.out.println(checkBox.isSelected());
    }
}
