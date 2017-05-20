package ch.makery.address;

import javafx.beans.property.SimpleStringProperty;

public class TableDiscipline {
	private final SimpleStringProperty disciplina;
	private final SimpleStringProperty turma;
	private final SimpleStringProperty dia;
	private final SimpleStringProperty horario;
	private final SimpleStringProperty professor;
	
	public TableDiscipline (String dis, String tur, String d, String h, String prof){
		this.disciplina = new SimpleStringProperty(dis);
		this.turma = new SimpleStringProperty(tur);
		this.dia = new SimpleStringProperty(d);
		this.horario = new SimpleStringProperty(h);
		this.professor = new SimpleStringProperty(prof);
	}

	public String getDisciplina() {
		return disciplina.get();
	}

	public String getTurma() {
		return turma.get();
	}

	public String getDia() {
		return dia.get();
	}

	public String getHorario() {
		return horario.get();
	}

	public String getProfessor() {
		return professor.get();
	}
}
