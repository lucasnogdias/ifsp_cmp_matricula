package ch.makery.address;

import javafx.collections.ObservableList;

public class Requisicao {
	private final String alunoProntuario;
	private final ObservableList<Disciplina> disciplinasRequeridas;
	
	public Requisicao(String alunoProntuario, ObservableList<Disciplina> disciplinasRequeridas) {
		super();
		this.alunoProntuario = alunoProntuario;
		this.disciplinasRequeridas = disciplinasRequeridas;
	}
	
	public String getAlunoProntuario() {
		return alunoProntuario;
	}
	public ObservableList<Disciplina> getDisciplinasRequeridas() {
		return disciplinasRequeridas;
	}

}
