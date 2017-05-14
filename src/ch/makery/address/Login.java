package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userName;


    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'LoginScreen.fxml'.";


    }

}