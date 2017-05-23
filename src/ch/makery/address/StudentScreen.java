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
    	
    	//Tabela de disciplinas selecionadas
    	this.disciplinasRequiridas = FXCollections.observableArrayList();
    	
    	//Configurar tabela de Disciplas Selecionadas
    	sDisciplina.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("disciplina"));
    	sTurma.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("turma"));
    	sDia.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("dia"));
    	sHorario.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("horario"));
    	sProfessor.setCellValueFactory(new PropertyValueFactory<Disciplina, String>("professor"));
    	selectedTableView.setItems(this.disciplinasRequiridas);
    }
    
    private ObservableList<Disciplina> ListarDisciplinas(){
    	//TODO: Obter do BD uma lista de disciplinas sendo o ofertadas.
    	ObservableList<Disciplina> ofertadas = this.BuscarOfertadas();
    	//TODO: Comparar esta lista com o usuario e remover todas as disciplinas que ele não pode se matricular.
    	ObservableList<Disciplina> disponiveis = ofertadas;
    	disponiveis = this.filtrarDisciplinas(ofertadas);
    	return disponiveis;
    }
    
    private ObservableList<Disciplina> BuscarOfertadas(){
    	//TODO: substituir essa funçao por uma busca ao banco com as disciplinas ofertadas
    	ObservableList<Disciplina> ofertas = FXCollections.observableArrayList(
    			new Disciplina("AOO", "N", "Quarta-Feira", "19-23", "Rafael Muniz e Samuel Martins"),
    			new Disciplina("BD2", "N", "Terça-Feira", "19-23", "Everton Silva e Carlos Beluzo"),
    			new Disciplina("ED1", "N", "Sexta-Feira", "19-23", "José Américo e Samuel Martins"),
    			new Disciplina("IHC", "N", "Quinta-Feira", "19-21", "José Américo"),
    			new Disciplina("LP3", "N", "Segunda-Feira", "19-23", "Everton Silva e André Valente"),
    			new Disciplina("MFI", "N", "Quarta-Feira", "21-23", "Cecília Pereira de Andrade"),
    			new Disciplina("LP1", "N", "Segunda-Feira", "19-23", "Sovat"),
    			new Disciplina("BD1", "N", "Terça-Feira", "19-23", "Zady e Beluzo"),
    			new Disciplina("WEB", "N", "Quinta-Feira", "19-23", "Rafael"),
    			new Disciplina("TST", "N", "Quinta-Feira", "21-23", "José")
    	);
    	return ofertas;
    }
    
    private ObservableList<Disciplina> filtrarDisciplinas(ObservableList<Disciplina> oferta){
    	return oferta;
    }
    
    public void selecionarDisciplina(){
    	Disciplina d = this.avaliableTableView.getSelectionModel().getSelectedItem();
    	boolean canAdd = true;
    	if (d!=null){
    		for (int i = 0; i<this.disciplinasRequiridas.size(); i++){
    			Disciplina old = this.disciplinasRequiridas.get(i);
    			if (d.getDia()==old.getDia()){
    				String[] hrNew = d.getHorario().split("-");
    				String[] hrOld = old.getHorario().split("-");
    				if( hrNew[0].equals(hrOld[0]) || hrNew[1].equals(hrOld[1]) ){
    					canAdd = false;
    				}
    			}
    		}
    		if (canAdd){
    			this.disciplinasRequiridas.add(d);
    			this.disciplinasDisponiveis.remove(d);
    		}else{
    			//TODO: Exibir Menssagem de Erro
    			System.out.println("Não é Possível Requisitar esta Disciplina. Conflito de horário");
    		}
    	}
    }
    
    public void retirarDisciplina(){
    	Disciplina d = this.selectedTableView.getSelectionModel().getSelectedItem();
    	if(d!=null){
    		this.disciplinasDisponiveis.add(d);
    		this.disciplinasRequiridas.remove(d);
    	}
    }
    
    public void enviarRequisicao(){
    	//TODO: Enviar itens da lista para a tabela 'requisicoes' no backend como uma nova requisicao.
    	System.out.println("Requisição enviada com sucesso");
    }

}

