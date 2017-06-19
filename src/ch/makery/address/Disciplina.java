package ch.makery.address;

public class Disciplina {
	private final String disciplina;
	private final String turma;
	private final int codTurma;
	private final String dia;
	private final String horario;
	private final String professor;
	private String[] preReqs;
	
	public Disciplina (String dis, String tur, String d, String h, String prof, int codTurma){
		this.disciplina = dis;
		this.turma = tur;
		this.dia = d;
		this.horario = h;
		this.professor = prof;
		this.preReqs = null;
		this.codTurma = codTurma;
	}
	
	public Disciplina (String dis, String tur, String d, String h, String prof, String[] pre, int codTurma){
		this.disciplina = dis;
		this.turma = tur;
		this.dia = d;
		this.horario = h;
		this.professor = prof;
		this.preReqs = pre;
		this.codTurma = codTurma;
	}
	
	public int getCodTurma(){
		return this.codTurma;
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
	
	public String[] getPreReqs(){
		return this.preReqs;
	}
}
