package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import usr.Aluno;


public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userName;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button log;

    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file  'LoginScreen.fxml'.";
        
        log.setOnAction(e -> this.logIn());
    }
    
    private void logIn(){
    	//TODO: Check with bd if user and password match, if match load a new screen according to the user type.
    	//if it does not match show an error message.
    	
    	String user = userName.getText();
    	String pass = password.getText();
    	if (user.isEmpty() || user==null){
    		//TODO: Show error message. Login não pode ser deixado vazio.
    		System.out.println("Login não pode ser deixado vazio.");
    	} else if (pass.isEmpty() || pass==null) {
    		//TODO: Show error message. Passowrd não pode ser deixado vazio.
    		System.out.println("Password não pode ser deixado vazio.");
    	} else {
    		//TODO: Call BD and check for user name and password. Recieve a response and log the user in.
    		System.out.println("Logado como "+user);
    		MainApp.mainInst.user = new Aluno(user, "Lucas Nogueira Dias","ADS", "1s2016", 80, new String[]{"LP1", "BD1"});
    		//TODO: Olhar no Banco por dados do curso do Aluno que logou:
    		MainApp.mainInst.curso = new Curso("ADS", "Análise e Desenvolvimento de Sistemas", "01/02/2010", new String[]{"APO", "AOO", "ARQ", "RAS", "BD1", "BD2", "CEE", "DWE", "ESW", "ED1", "GPR", "HCT", "ING", "IGT", "IHC"}, 360);
    		//TODO: IF Response for bd is true, load next screen.
    		MainApp.mainInst.loadStudentScreen();
    	}
    }

}