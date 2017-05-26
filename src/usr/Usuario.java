package usr;

import java.util.Date;

/**
 * Classe Usuario. Esta e uma classe abstrata, as classes filhas devem implementar suas fun��es!
 *
 */
public abstract class Usuario {
	int codUsuario;
	String nomeUsuario;
	int cpf;
	String email;
	int tipo;
	Date dataNasc;
	int tipoUsuario;
	String nomeTipoUsuario;
	
	public abstract void consultarDisciplinas();
	public abstract void consultarTurmas();
}