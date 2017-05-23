package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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
    private Button logExit;
    
    @FXML
    private AnchorPane anchorPaneLog;

    @FXML
    void initialize() {
        
    	
    	assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file  'LoginScreen.fxml'.";
        
        
        
        log.setOnAction(e -> this.logIn());     
       
        
     // Metodo para caputar evento da tecla enter pressionada
        anchorPaneLog.setOnKeyPressed(new EventHandler<KeyEvent>() {  
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                	logIn(); 
                	
                }
            }
        });
                  
        
    }

    
    
    private void logIn(){
    	//TODO: Check with bd if user and password match, if match load a new screen according to the user type.
    	//if it does not match show an error message.
    	
    	String user = userName.getText();
    	String pass = password.getText();
    	
    	if (user.isEmpty() || user==null){
    		//TODO: Show error message. Login não pode ser deixado vazio.
    		System.out.println("Login n�o pode ser deixado vazio.");
    	} else if (pass.isEmpty() || pass==null) {
    		//TODO: Show error message. Passowrd n�o pode ser deixado vazio.
    		System.out.println("Password n�o pode ser deixado vazio.");
    	} else {
    		//TODO: Call BD and check for user name and password. Recieve a response and log the user in.
    		System.out.println("Logado como "+user);
    		MainApp.mainInst.user = new Aluno(user);
    		//TODO: IF Response for bd is true, load next screen.
    		MainApp.mainInst.loadStudentScreen();
    	}
    }
    
    @FXML
    private void exit(){
    	System.exit(0);
    }

}