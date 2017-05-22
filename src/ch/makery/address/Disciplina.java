package ch.makery.address;

public class Disciplina {
	private final String disciplina;
	private final String turma;
	private final String dia;
	private final String horario;
	private final String professor;
	
	public Disciplina (String dis, String tur, String d, String h, String prof){
		this.disciplina = dis;
		this.turma = tur;
		this.dia = d;
		this.horario = h;
		this.professor = prof;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getTurma() {
		return this.turma;
	}

	public String getDia() {
		return this.dia;
	}

	public String getHorario() {
		return this.horario;
	}

	public String getProfessor() {
		return this.professor;
	}
}
