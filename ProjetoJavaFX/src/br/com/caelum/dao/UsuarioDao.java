package br.com.caelum.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UsuarioDao {
	
	public UsuarioDao() {}
	
	
	public boolean cadastraUsuario(Usuario usuario) {
		Connection con = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (nome, email, telefone, cpf, RG, login, senha) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getTelefone());
			ps.setString(4, usuario.getCpf());
			ps.setString(5, usuario.getRg());
			ps.setString(6, usuario.getLogin());
			ps.setString(7, usuario.getSenha());
			
			ps.execute();
			ps.close();
			
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar inserção no Banco de Dados!", e);
		}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		Connection con = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();
			
			boolean encontrado = rs.next(); //Verifica se é true ou false
			rs.close();
			ps.close();
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
