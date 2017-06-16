package usr;


/**
 * Classe Aluno. Extende a Classe Usuario, Aluno é um tipo especifico de usuário.
 * 
 */
public class Aluno extends Usuario {
	private final String prontuario;
	private String[] disciplinasCod;
	private String curso;
	private String periodo;
	private int cod;
	
	public Aluno(String prnt){
		this.prontuario = prnt;
	}
	
	public Aluno(String prnt, String nome, String cur, String per, String[] disc, int cod){
		this.prontuario = prnt;
		this.nomeUsuario = nome;
		this.curso = cur;
		this.periodo = per;
		this.disciplinasCod = disc;
		this.cod = cod;
	}

	public int getCod(){
		return this.cod;
	}
	
	public void solicitarMatricula(){
		// TODO
	}
	
	public void alterarCadastro(){
		//TODO
	}
	
	public String[] consultarMatricula(){
		
		return this.disciplinasCod;
	}
	
	@Override
	public void consultarDisciplinas() {
		for(String s : this.disciplinasCod)
		    System.out.println(s);

	}

	@Override
	public void consultarTurmas() {
		// TODO Auto-generated method stub

	}

	public String getProntuario() {
		return prontuario;
	}


	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	
	public String getNomeUsuario(){
		return this.nomeUsuario;
	}

}
