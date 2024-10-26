package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Consulta {
	private static final String URL = "jdbc:mysql://localhost/placar";
	private ResultSet resultado;
	private Connection conexao;
	public Consulta() {
		String sql = "SELECT * FROM pontuacao ORDER BY pontos DESC LIMIT 3";
		
		try {
			conexao = DriverManager.getConnection(URL, "root", "");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			resultado = operacao.executeQuery();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public String getNome() {
		try {
			return (String)resultado.getObject(2);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Vazio";
		}
	}
	public int getPontos() {
		try {
			return (int)resultado.getObject(3);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public String getData() {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(resultado.getObject(4));
			return data;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Vazio";
		}
	}
	public void Proximo() {
		try {
			resultado.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Fechar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
