package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriacaoExemplo {
	private static String url = "jdbc:mysql://localhost/placar";
	private static String sql;
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection(url, "root", "");
			sql = "INSERT INTO pontuacao(nome,pontos,data) VALUES('RLB',3,'2024-10-24')";
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			sql = "INSERT INTO pontuacao(nome,pontos,data) VALUES('LAM',5,'2024-10-24')";
			operacao = conexao.prepareStatement(sql);
			operacao.execute();
			sql = "INSERT INTO pontuacao(nome,pontos,data) VALUES('DOU',7,'2024-10-24')";
			operacao = conexao.prepareStatement(sql);
			operacao.execute();
			System.out.println("Exemplos criados com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
