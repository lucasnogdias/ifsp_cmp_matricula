package ch.makery.address.model;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ch.makery.address.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import usr.Aluno;

/**
	 * SqlConnector class.
	 */
public class SqlConnector {
	
	public static java.sql.Connection connection;
	
	public static void Connect(){
		//TODO: Connect to the DB and save the connection on a class private variable. The adress, if needed, should be passed as parameter.
		System.out.println("Creating SQL Connector to connect");
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
		    SqlConnector.connection = conn;
			/*System.out.println("Database connected!");
		    java.sql.Statement st = connection.createStatement();
		    String query = "SELECT * FROM sismatricula.view_consulta_dados_cadastrais where nomeUsuario='Administrador'";
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()) {
		    	System.out.println(rs.getInt(1));
		    	System.out.println(rs.getString(3));
		    }*/
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public static int logUser(String usr){
		String url = "jdbc:mysql://localhost:3307/sismatricula";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
			java.sql.Statement st = conn.createStatement();
			String query = "SELECT * FROM sismatricula.view_consulta_dados_cadastrais where nomeUsuario='"+usr+"'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()){
				System.out.println("Found user");
				return rs.getInt("codTipoUsuario");
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
			String query = "SELECT * FROM sismatricula.view_consulta_dados_cadastrais where nomeUsuario='"+usr+"'";
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
				String prof = rs.getString("professor");
				disc.add(new Disciplina(dis, tur, d, h, prof));
			}
			return disc;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
