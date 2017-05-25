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
	private int cargaHoraria;
	
	public Aluno(String prnt){
		this.prontuario = prnt;
	}
	
	public Aluno(String prnt, String nome, String cur, String per, int ch ,String[] disc){
		this.prontuario = prnt;
		this.nomeUsuario = nome;
		this.curso = cur;
		this.periodo = per;
		this.cargaHoraria = ch;
		this.disciplinasCod = disc;
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
		// TODO Auto-generated method stub

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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getNomeUsuario(){
		return this.nomeUsuario;
	}

}
