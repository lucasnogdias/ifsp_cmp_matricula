package ch.makery.address.model;
import java.sql.Date;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ch.makery.address.Disciplina;
import ch.makery.address.Requisicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import usr.Aluno;

/**
	 * SqlConnector class.
	 */
public class SqlConnector {
	
	public static java.sql.Connection connection;
	
	public static void Connect(){
		System.out.println("Creating SQL Connector to connect");
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
		    SqlConnector.connection = conn;
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public static int logUser(String usr, String pass){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "SELECT * FROM sismatricula.view_consulta_dados_cadastrais where identificacao='"+usr+"'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()){
				System.out.println("Found user");			
				int codTipo = rs.getInt("codTipoUsuario");
				rs.close();
				String query2 = "call procedure_login('"+usr+"', '"+pass+"')";
				ResultSet rs2 = st.executeQuery(query2);
				if (rs2.next()){
					boolean logged = rs2.getBoolean(1);
					if (logged){
						return codTipo;
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			 }else {
				 return -1;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} 
	}
	
	public static Aluno getAlunoData(String usr){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "SELECT * FROM sismatricula.view_consulta_dados_cadastrais where identificacao='"+usr+"'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()){
				System.out.println("Found user");
				String prnt = rs.getString("identificacao");
				String nome = rs.getString("nomeUsuario");
				String cur = "TADS"; //TODO: get from DB
				String per = rs.getString("ingresso");
				int cod = rs.getInt("codUsuario");
				ArrayList<String> discList = new ArrayList<String>();
				String proced = "CALL procedure_disciplinas_concluidas("+cod+")";
				ResultSet rs2 = st.executeQuery(proced);
				while (rs2.next()){
					discList.add(rs2.getString("Turma"));
				}
				String[] disc = new String[discList.size()];
				disc = discList.toArray(disc);
				Aluno al = new Aluno(prnt, nome, cur, per, disc, cod);
				return al;
			 }
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static ObservableList<Disciplina> getDisciplinasOfertadas(int cod){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "CALL procedure_consulta_turmas_disponiveis("+cod+")";
			ResultSet rs = st.executeQuery(query);
			ObservableList<Disciplina> disc = FXCollections.observableArrayList();
			while(rs.next()){
				String dis = rs.getString("nomeDisciplina");
				String tur = rs.getString("siglaTurma");
				String d = rs.getString("diaSemana");
				String h = rs.getString("horario");
				String prof = rs.getString("professor1");
				String prof2 = rs.getString("professor2");
				String profString = prof+", "+prof2;
				int codT = rs.getInt("codTurma");
				disc.add(new Disciplina(dis, tur, d, h, profString, codT));
			}
			return disc;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean requisitaMatricula(int codT, int codAl){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "CALL procedure_solicitar_matricula('"+codT+"','"+codAl+"')";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				return rs.getBoolean(1);
			}
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ObservableList<Requisicao> pesquisarRequisicao(){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "SELECT * FROM view_solicitacoes_matriculas_coordenador";
			ResultSet rs = st.executeQuery(query);
			String prevPront = "";
			ObservableList<Requisicao> allReqs = FXCollections.observableArrayList();
			ObservableList<Disciplina> list = FXCollections.observableArrayList();
			while(rs.next()){
				if (!prevPront.equals(rs.getString("Prontuário")) ){
					prevPront = rs.getString("Prontuário");
					System.out.println("novo aluno "+prevPront);
					list = FXCollections.observableArrayList();
					String disName = rs.getString("Disciplina");
					String tur = rs.getString("Turma");
					String dia = "";
					String hora = "";
					String prof = "";
					int codTurma = rs.getInt("Codigo Turma");
					Disciplina dis = new Disciplina(disName, tur, dia, hora, prof, codTurma);
					list.add(dis);
					ArrayList<Integer> codes = new ArrayList<Integer>();
					codes.add(rs.getInt("Codigo Matricula"));
					Requisicao req = new Requisicao(prevPront, list, codes);
					allReqs.add(req);
				}else{
					System.out.println("Same student "+prevPront);
					String disName = rs.getString("Disciplina");
					String tur = rs.getString("Turma");
					String dia = "";
					String hora = "";
					String prof = "";
					int codTurma = rs.getInt("Codigo Turma");
					Integer codReq = new Integer(rs.getInt("Codigo Matricula"));
					Disciplina dis = new Disciplina(disName, tur, dia, hora, prof, codTurma);
					allReqs.get(allReqs.size()-1).getDisciplinasRequeridas().add(dis); //Ultima entrada
					allReqs.get(allReqs.size()-1).getCodReqs().add(codReq);
				}
			}
			return allReqs;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void aprovar(int reqCode){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "CALL procedure_alterar_status_matricula('"+reqCode+"','3')";
			ResultSet rs = st.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void recusar(int reqCode){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "CALL procedure_alterar_status_matricula('"+reqCode+"','2')";
			ResultSet rs = st.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean cadastraAluno(String id, String nome, String sen, Date data_nas, int CPF, String em, String tel1, String tel2, int curso){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "CALL sismatricula.procedure_insert_aluno('"+id+"', '"+nome+"', '"+sen+"', '"+data_nas+"', "+CPF+", '"+em+"', '"+tel1+"', '"+tel2+"', "+curso+")";
			ResultSet rs = st.executeQuery(query);
			if (rs.next())
				return rs.getBoolean(1);
			else
				return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
