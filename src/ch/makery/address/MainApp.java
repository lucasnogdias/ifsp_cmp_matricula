package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.SqlConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import usr.Usuario;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public Usuario user = null;
    public Curso curso = null;
    
    public static MainApp mainInst = null;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de Matricula");
        
        SqlConnector conect = new SqlConnector("addr");
        
        if (MainApp.mainInst==null){
        	MainApp.mainInst = this;
        }else {
        	System.out.println("There should not be any other instances of the class MainApp running!");
        }

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.setResizable(false);
            primaryStage.setWidth(520);
            primaryStage.setHeight(200);
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre a tela de login dentro do root layout.
     */
    public void showPersonOverview() {
        try {
            // Carrega a tela de login;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginScreen.fxml"));
            AnchorPane login = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadAdminScreen(){
    	try{
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/AdminScreen.fxml"));
            AnchorPane admin = (AnchorPane) loader.load();
            
            primaryStage.setResizable(false);
            primaryStage.setWidth(805);
            primaryStage.setHeight(520);
            

            // Define a Admin Screen dentro do root layout.
            rootLayout.setCenter(admin);
    	} catch (IOException e) {
            e.printStackTrace();
    	}
    }
    
    public void loadStudentScreen() {
    	try {
            // Carrega a tela de login;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StudentScreen.fxml"));
            AnchorPane student = (AnchorPane) loader.load();
            
            primaryStage.setResizable(false);
            primaryStage.setWidth(805);
            primaryStage.setHeight(530);
            

            // Define a Student Screen do root layout.
            rootLayout.setCenter(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
