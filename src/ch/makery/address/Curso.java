package ch.makery.address;

public class Curso {
	private final String codCurso;
	private final String nomeCurso;
	private final String dtCriacao;
	private final String[] listaDisciplinas;
	private final int totalHoras;
	
	public Curso(String cdCurso, String nomeCurso, String dtC, String[] lDiscCod, int tH){
		this.codCurso = cdCurso;
		this.nomeCurso = nomeCurso;
		this.dtCriacao = dtC;
		this.listaDisciplinas = lDiscCod;
		this.totalHoras = tH;
	}
	
	public String getCodCurso() {
		return codCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public String[] getListaDisciplinas() {
		return listaDisciplinas;
	}

	public int getTotalHoras() {
		return totalHoras;
	}
	
	
}
