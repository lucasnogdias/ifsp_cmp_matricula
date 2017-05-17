package ch.makery.address;

import java.io.IOException;

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
    
    public static MainApp mainInst = null;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de Matrícula");
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
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
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
    
    public void loadStudentScreen() {
    	//TODO: load the Studentscreen over the login one;
    	try {
            // Carrega a tela de login;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StudentScreen.fxml"));
            AnchorPane student = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
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
