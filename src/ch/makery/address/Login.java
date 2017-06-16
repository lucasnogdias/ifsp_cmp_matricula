package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.SqlConnector;
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
    		//TODO: Show error message. Login nÃ£o pode ser deixado vazio.
    		System.out.println("Login não pode ser deixado vazio.");
    	} else if (pass.isEmpty() || pass==null) {
    		//TODO: Show error message. Passowrd nï¿½o pode ser deixado vazio.
    		System.out.println("Password não pode ser deixado vazio.");
    	} else {
    		int usrType = SqlConnector.logUser(user);
    		if (usrType==1){
    			System.out.println("Logado como admin");
    			MainApp.mainInst.loadAdminScreen();
    		}else if (usrType==5 || usrType==6){
    			System.out.println("Logado como Aluno "+user);
    			Aluno al = SqlConnector.getAlunoData(user);
    			MainApp.mainInst.user = al;
    			//TODO: Olhar no Banco por dados do curso do Aluno que logou:
    			MainApp.mainInst.curso = new Curso("ADS", "Análise e Desenvolvimento de Sistemas", "01/02/2010", new String[]{"APO", "AOO", "ARQ", "RAS", "BD1", "BD2", "CEE", "DWE", "ESW", "ED1", "GPR", "HCT", "ING", "IGT", "IHC"}, 360);
    			//TODO: IF Response for bd is true, load next screen.
    			MainApp.mainInst.loadStudentScreen();
    		}else {
    			System.out.println("Usuario não Encontrado!");
    		}
    	}
    }
    
    @FXML
    private void exit(){
    	System.exit(0);
    }

}