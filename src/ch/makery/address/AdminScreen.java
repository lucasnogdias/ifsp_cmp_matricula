package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class AdminScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> listReq;

    @FXML
    private TableView<?> listTableView;

    @FXML
    private Label reqAluno;

    @FXML
    private Label reqCurso;

    @FXML
    private TableColumn<?, ?> reqDia;

    @FXML
    private TableColumn<?, ?> reqDisc;

    @FXML
    private TableColumn<?, ?> reqHorario;

    @FXML
    private TextField reqJustificativa;

    @FXML
    private Label reqPeriodo;

    @FXML
    private TableColumn<?, ?> reqProf;

    @FXML
    private Label reqPront;

    @FXML
    private TableView<?> reqTableView;

    @FXML
    private TableColumn<?, ?> reqTurma;


    @FXML
    void aprovarReq(ActionEvent event) {
    }

    @FXML
    void recusarReq(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert listReq != null : "fx:id=\"listReq\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert listTableView != null : "fx:id=\"listTableView\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqAluno != null : "fx:id=\"reqAluno\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqCurso != null : "fx:id=\"reqCurso\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqDia != null : "fx:id=\"reqDia\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqDisc != null : "fx:id=\"reqDisc\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqHorario != null : "fx:id=\"reqHorario\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqJustificativa != null : "fx:id=\"reqJustificativa\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqPeriodo != null : "fx:id=\"reqPeriodo\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqProf != null : "fx:id=\"reqProf\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqPront != null : "fx:id=\"reqPront\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqTableView != null : "fx:id=\"reqTableView\" was not injected: check your FXML file 'AdminScreen.fxml'.";
        assert reqTurma != null : "fx:id=\"reqTurma\" was not injected: check your FXML file 'AdminScreen.fxml'.";


    }

}

