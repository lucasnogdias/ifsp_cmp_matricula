package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Label usrCurso;

    @FXML
    private Label usrFaltaHoras;

    @FXML
    private Label usrHoras;

    @FXML
    private Label usrMedia;

    @FXML
    private Label usrNome;

    @FXML
    private Label usrPeriodo;

    @FXML
    private Label usrSobrenome;

    
    // Inicio das variáveis de controle da tabela de Disciplinas Disponiveis
    @FXML
    private TableColumn<TableDiscipline, String> aDia;

    @FXML
    private TableColumn<TableDiscipline, String> aDisciplina;

    @FXML
    private TableColumn<TableDiscipline, String> aHorario;

    @FXML
    private TableColumn<TableDiscipline, String> aProfessor;

    @FXML
    private TableColumn<TableDiscipline, String> aTurma;

    @FXML
    private TableView<TableDiscipline> avaliableTableView;
    // Fim das variaveis de controle da tabela de Disciplinas Disponíveis

    // Popular dados da Tabela de Disciplinas Disponíveis
    final ObservableList<TableDiscipline> data = FXCollections.observableArrayList(
    		new TableDiscipline("LPIII", "A", "Segunda", "19-23", "Samuel"),
    		new TableDiscipline("AOO", "A", "Terça", "19-23", "Samuel")
    		);
    
    @FXML
    void initialize() {
    	assert logedUser != null : "fx:id=\"logedUser\" was not injected: check your FXML file 'StudentScreen.fxml'.";
    	Aluno logdAluno = (Aluno) MainApp.mainInst.user;
    	logedUser.setText(logdAluno.getProntuario());
    	
    	//Configurar tabela de Disciplinas Disponíveis
    	aDisciplina.setCellValueFactory(new PropertyValueFactory<TableDiscipline, String>("disciplina"));
    	aTurma.setCellValueFactory(new PropertyValueFactory<TableDiscipline, String>("turma"));
    	aDia.setCellValueFactory(new PropertyValueFactory<TableDiscipline, String>("dia"));
    	aHorario.setCellValueFactory(new PropertyValueFactory<TableDiscipline, String>("horario"));
    	aProfessor.setCellValueFactory(new PropertyValueFactory<TableDiscipline, String>("professor"));
    	avaliableTableView.setItems(data);
    }

}

