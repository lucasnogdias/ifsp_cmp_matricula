package ch.makery.address;

import java.net.URL;
import java.util.ArrayList;
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
    
    
    //Inicio das Variaveis de Controle do Usuário
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
    //Fim das variáveis de controle do usuário

    
    // Inicio das variáveis de controle da tabela de Disciplinas Disponiveis
    @FXML
    private TableColumn<Disciplina, String> aDia;

    @FXML
    private TableColumn<Disciplina, String> aDisciplina;

    @FXML
    private TableColumn<Disciplina, String> aHorario;

    @FXML
    private TableColumn<Disciplina, String> aProfessor;

    @FXML
    private TableColumn<Disciplina, String> aTurma;

    @FXML
    private TableView<Disciplina> avaliableTableView;
    // Fim das variaveis de controle da tabela de Disciplinas Disponíveis
    
    // Inicio das variáveis de controle da tabela de Disciplinas Selecionadas
    @FXML
    private TableColumn<Disciplina, String> sDia;

    @FXML
    private TableColumn<Disciplina, String> sDisciplina;

    @FXML
    private TableColumn<Disciplina, String> sHorario;

    @FXML
    private TableColumn<Disciplina, String> sProfessor;

    @FXML
    private TableColumn<Disciplina, String> sTurma;

    @FXML
    private TableView<Disciplina> selectedTableView;   
    // Fim das variavies de controle da tabela de Disciplinas Selecionadas

    // Lista das disciplinas Disponíveis
    private ObservableList<Disciplina> disciplinasDisponiveis;
    
    // Lista das disciplinas Selecionadas para Requerimento
    private ObservableList<Disciplina> disciplinasRequiridas;
    
    @FXML
    void initialize() {
    	assert logedUser != null : "fx:id=\"logedUser\" was not injected: check your FXML file 'StudentScreen.fxml'.";
    	Aluno logdAluno = (Aluno) MainApp.mainInst.user;
    	logedUser.setText(logdAluno.getProntuario());
    	
    	//Obter Disciplinas sendo ofertadas no periodo e disponíveis para o aluno
    	this.disciplinasDisponiveis = this.ListarDisciplinas();
    	
    	
    	//Configurar tabela de Disciplinas Disponíveis
    	aDisciplina.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("disciplina"));
    	aTurma.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("turma"));
    	aDia.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("dia"));
    	aHorario.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("horario"));
    	aProfessor.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("professor"));
    	avaliableTableView.setItems(disciplinasDisponiveis);
    }
    
    private ObservableList<Disciplina> ListarDisciplinas(){
    	//TODO: Obter do BD uma lista de disciplinas sendo o ofertadas.
    	//TODO: Comparar esta lista com o usuario e remover todas as disciplinas que ele não pode se matricular.
    	ObservableList<Disciplina> disponiveis = FXCollections.observableArrayList(
    			new Disciplina("AOO", "N", "Quarta-Feira", "19-23", "Rafael Muniz e Samuel Martins"),
    			new Disciplina("BD2", "N", "Terça-Feira", "19-23", "Everton Silva e Carlos Beluzo"),
    			new Disciplina("ED1", "N", "Sexta-Feira", "19-23", "José Américo e Samuel Martins"),
    			new Disciplina("IHC", "N", "Quinta-Feira", "19-21", "José Américo"),
    			new Disciplina("LP3", "N", "Segunda-Feira", "19-23", "Everton Silva e André Valente"),
    			new Disciplina("MFI", "N", "Quarta-Feira", "21-23", "Cecília Pereira de Andrade")
    	);
    	return disponiveis;
    }

}

