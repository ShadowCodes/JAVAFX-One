package br.com.caelum.view;

import java.sql.Connection;

import br.com.caelum.jdbc.ConnectionFactory;

public class TesteView {
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		if (con != null) {
			System.out.println("Conexão realizada com sucesso!");
		}
	}
}
