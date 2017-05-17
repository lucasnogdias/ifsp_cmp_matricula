package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import usr.Aluno;


public class StudentScreen {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane requestPanel;

    @FXML
    private URL location;
    
    @FXML
    private Label logedUser;

    @FXML
    void initialize() {
    	assert logedUser != null : "fx:id=\"logedUser\" was not injected: check your FXML file 'StudentScreen.fxml'.";
    	Aluno logdAluno = (Aluno) MainApp.mainInst.user;
    	logedUser.setText(logdAluno.getProntuario());
    }

}

