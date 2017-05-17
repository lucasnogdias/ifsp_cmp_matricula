package usr;
/**
 * Classe Aluno. Extende a Classe Usuario, Aluno é um tipo especifico de usuário.
 * 
 */
public class Aluno extends Usuario {
	private String prontuario;
	
	public Aluno(String prnt){
		this.setProntuario(prnt);
	}
	
	public void solicitarMatricula(){
		// TODO
	}
	
	public void alterarCadastro(){
		//TODO
	}
	
	public boolean consultarMatricula(){
		//TODO
		
		return true;
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
