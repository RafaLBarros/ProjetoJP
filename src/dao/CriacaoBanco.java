package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriacaoBanco {
	private static String url = "jdbc:mysql://localhost";
	private static String sql = "CREATE DATABASE placar";
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection(url, "root", "");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			System.out.println("Banco de Dados criado com sucesso!");
			conexao.close();
			url = "jdbc:mysql://localhost/placar";
			conexao = DriverManager.getConnection(url,"root","");
			sql = "CREATE TABLE pontuacao(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,nome VARCHAR(3), pontos INT,data DATE)";
			operacao = conexao.prepareStatement(sql);
			operacao.execute();
			System.out.println("Tabela criada com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
