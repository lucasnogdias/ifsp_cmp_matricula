package usr;

import java.util.ArrayList;

import ch.makery.address.Disciplina;

/**
 * Classe Aluno. Extende a Classe Usuario, Aluno é um tipo especifico de usuário.
 * 
 */
public class Aluno extends Usuario {
	private String prontuario;
	private String[] disciplinasCod;
	
	public Aluno(String prnt){
		this.prontuario = prnt;
	}
	
	public Aluno(String prnt, String[] disc){
		this.prontuario = prnt;
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

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

}
