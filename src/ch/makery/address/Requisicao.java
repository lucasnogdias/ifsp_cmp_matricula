package ch.makery.address;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Requisicao {
	private final String alunoProntuario;
	private final ObservableList<Disciplina> disciplinasRequeridas;
	private final ArrayList<Integer> codReqs;
	
	public Requisicao(String alunoProntuario, ObservableList<Disciplina> disciplinasRequeridas, ArrayList<Integer> cod) {
		super();
		this.alunoProntuario = alunoProntuario;
		this.disciplinasRequeridas = disciplinasRequeridas;
		this.codReqs = cod;
	}
	
	public String getAlunoProntuario() {
		return alunoProntuario;
	}
	public ObservableList<Disciplina> getDisciplinasRequeridas() {
		return disciplinasRequeridas;
	}
	public ArrayList<Integer> getCodReqs(){
		return this.codReqs;
	}

}
