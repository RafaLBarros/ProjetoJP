package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insercao {
	private static final String URL = "jdbc:mysql://localhost/placar";
	
	public Insercao(String nome, int pontos, String data) {
		String sql = "INSERT INTO pontuacao(nome, pontos, data) VALUES('" + nome + "'," + pontos + ", '" + data + "')";

		try {
			Connection conexao = DriverManager.getConnection(URL, "root", "");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			
			System.out.println("Pontuação cadastrada com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
