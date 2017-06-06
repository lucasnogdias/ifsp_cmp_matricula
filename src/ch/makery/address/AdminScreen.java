package ch.makery.address;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import usr.Aluno;


public class AdminScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Requisicao, String> listReq;

    @FXML
    private TableView<Requisicao> listTableView;

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
    
/** Variaveis de controle para formulário de cadastro de novo Aluno **/
    @FXML
    private Pane newStudentPane;
    
    @FXML
    private TextField newCurso;

    @FXML
    private TextField newDisciplinas;

    @FXML
    private TextField newEmail;

    @FXML
    private TextField newName;

    @FXML
    private TextField newPeriodo;

    @FXML
    private TextField newRA;


    @FXML
    void aprovarReq(ActionEvent event) {
    }

    @FXML
    void recusarReq(ActionEvent event) {
    }
    
    @FXML 
    void newCadastro(ActionEvent event){
    	closeCadastro(new ActionEvent());
    }
    
    @FXML 
    void closeCadastro(ActionEvent event){
    	this.newStudentPane.setVisible(false);
    	System.out.println("closeCadastro seu lixo");
    }
    
    @FXML
    void openCadastro(ActionEvent event){
    	this.newStudentPane.setVisible(true);
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
        
        ObservableList<Requisicao> reqList = this.BuscarRequicoes();
        
        listReq.setCellValueFactory(new PropertyValueFactory<Requisicao, String>("alunoProntuario"));
    	listTableView.setItems(reqList);
    	
    	listTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    	    if (newSelection != null) {
    	    	Requisicao sel = this.listTableView.getSelectionModel().getSelectedItem();
    	    	//TODO: Requisitar no BD os dados do aluno do prontuario sel.getAlunoProntuario()) e criar um novo Aluno com os dados obtidos.
    	    	Aluno aluno = new Aluno(sel.getAlunoProntuario(), "AlunoTeste", "ADS", "1s2016", 10, null);
    	    	reqPront.setText(aluno.getProntuario());
    	    	reqAluno.setText(aluno.getNomeUsuario());
    	    	reqCurso.setText(aluno.getCurso());
    	    	reqPeriodo.setText(aluno.getPeriodo());
    	    }
    	});
    }
    
    private ObservableList<Requisicao> BuscarRequicoes(){
    	//TODO: substituir essa funçao por uma busca ao banco com as requisicoes em aberto
    	ObservableList<Disciplina> list = FXCollections.observableArrayList(
				new Disciplina("AOO", "N", "Quarta-Feira", "19-23", "Rafael Muniz e Samuel Martins", new String[]{"ESW"}),
				new Disciplina("BD2", "N", "Terça-Feira", "19-23", "Everton Silva e Carlos Beluzo", new String[]{"BD1"}),
				new Disciplina("ED1", "N", "Sexta-Feira", "19-23", "José Américo e Samuel Martins", new String[]{"LP2", "BD1"}),
				new Disciplina("IHC", "N", "Quinta-Feira", "19-21", "José Américo"),
				new Disciplina("LP3", "N", "Segunda-Feira", "19-23", "Everton Silva e André Valente", new String[]{"LP2"}),
				new Disciplina("MFI", "N", "Quarta-Feira", "21-23", "Cecília Pereira de Andrade"),
				new Disciplina("LP1", "N", "Segunda-Feira", "19-23", "Sovat"),
				new Disciplina("BD1", "N", "Terça-Feira", "19-23", "Zady e Beluzo"),
				new Disciplina("WEB", "N", "Quinta-Feira", "19-23", "Rafael", new String[]{"LP1"}),
				new Disciplina("TST", "N", "Quinta-Feira", "21-23", "José"));
    	ObservableList<Requisicao> reqList = FXCollections.observableArrayList(
    			new Requisicao("160000-0",  list),
    			new Requisicao("160000-1",  list),
    			new Requisicao("160000-2",  list),
    			new Requisicao("160000-3",  list),
    			new Requisicao("160000-4",  list));
    	return reqList;
    }

}

