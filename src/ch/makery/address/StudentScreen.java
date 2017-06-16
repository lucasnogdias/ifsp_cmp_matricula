package ch.makery.address;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import ch.makery.address.model.SqlConnector;
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

    //@FXML
    //private Label usrMedia;

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
    	Curso curso = MainApp.mainInst.curso;
    	logedUser.setText(logdAluno.getProntuario());
    	this.usrNome.setText(logdAluno.getNomeUsuario().split(" ")[0]);
    	this.usrCurso.setText(logdAluno.getCurso());
    	this.usrPeriodo.setText(logdAluno.getPeriodo());
    	//this.usrHoras.setText(Integer.toString(logdAluno.getCargaHoraria())+" Horas");
    	this.usrSobrenome.setText(this.getLastName(logdAluno.getNomeUsuario()));
    	//TODO: Calcular horas faltantes a partir do total de horas do curso e quantas horas foram cumpridas.
    	//this.usrFaltaHoras.setText(Integer.toString(curso.getTotalHoras()-logdAluno.getCargaHoraria())+" Horas");
    	
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
    
    private String getLastName(String nomeUsuario) {
		String lastName = "";
		String[] allNames = nomeUsuario.split(" ");
		for (int i = 1; i<allNames.length; i++){
			lastName+=allNames[i];
			if (i+1<allNames.length){
				lastName+=" ";
			}
		}
		return lastName;
	}

	private ObservableList<Disciplina> ListarDisciplinas(){
		Aluno al = (Aluno) MainApp.mainInst.user;
		return SqlConnector.getDisciplinasOfertadas(al.getCod());
    	/* Useless code?
    	 * //TODO: Obter do BD uma lista de disciplinas sendo o ofertadas.
    	
    	ObservableList<Disciplina> ofertadas = this.BuscarOfertadas();
    	//TODO: Comparar esta lista com o usuario e remover todas as disciplinas que ele não pode se matricular.
    	ObservableList<Disciplina> disponiveis;
    	disponiveis = this.filtrarDisciplinas(ofertadas);
    	return disponiveis; */
    }
    
    private ObservableList<Disciplina> BuscarOfertadas(){
    	//TODO: substituir essa funçao por uma busca ao banco com as disciplinas ofertadas
    	ObservableList<Disciplina> ofertas = FXCollections.observableArrayList(
    			new Disciplina("AOO", "N", "Quarta-Feira", "19-23", "Rafael Muniz e Samuel Martins", new String[]{"ESW"}),
    			new Disciplina("BD2", "N", "Terça-Feira", "19-23", "Everton Silva e Carlos Beluzo", new String[]{"BD1"}),
    			new Disciplina("ED1", "N", "Sexta-Feira", "19-23", "José Américo e Samuel Martins", new String[]{"LP2", "BD1"}),
    			new Disciplina("IHC", "N", "Quinta-Feira", "19-21", "José Américo"),
    			new Disciplina("LP3", "N", "Segunda-Feira", "19-23", "Everton Silva e André Valente", new String[]{"LP2"}),
    			new Disciplina("MFI", "N", "Quarta-Feira", "21-23", "Cecília Pereira de Andrade"),
    			new Disciplina("LP1", "N", "Segunda-Feira", "19-23", "Sovat"),
    			new Disciplina("BD1", "N", "Terça-Feira", "19-23", "Zady e Beluzo"),
    			new Disciplina("WEB", "N", "Quinta-Feira", "19-23", "Rafael", new String[]{"LP1"}),
    			new Disciplina("TST", "N", "Quinta-Feira", "21-23", "José")
    	);
    	return ofertas;
    }
    
    private ObservableList<Disciplina> filtrarDisciplinas(ObservableList<Disciplina> oferta){
    	Aluno lgd = (Aluno) MainApp.mainInst.user;
    	String[] usrDisc = lgd.consultarMatricula();
    	ObservableList<Disciplina> fn = FXCollections.observableArrayList();
    	for (int i = 0; i<oferta.size(); i++){
    		Disciplina d = oferta.get(i);
    		if(!Arrays.asList(usrDisc).contains(d.getDisciplina())){
    			String[] preReqs = d.getPreReqs();
    			boolean meets = true;
    			if (preReqs!=null){
    				for (int j = 0; j<preReqs.length; j++){
    					if ( !Arrays.asList(usrDisc).contains(preReqs[j]) ){
    						meets = false;
    						System.out.println("Aluno não possui o pre-requisito "+preReqs[j]+" para a disciplina "+d.getDisciplina());
    					}
    				}
    				if (meets){
    					fn.add(d);
    				}
    			}else {
    				//Disciplina sem pre-requisitos, adicionar a lista final.
    				fn.add(d);
    			}
    		}else{
    			System.out.println("Aluno já cursou Disciplina "+d.getDisciplina()+" não adicionar na lista final");
    		}
    	}
    	System.out.println("Disciplinas Disponíveis: ");
    	for (int k = 0; k<fn.size(); k++){
    		System.out.println(fn.get(k).getDisciplina());
    	}
    	return fn;
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

