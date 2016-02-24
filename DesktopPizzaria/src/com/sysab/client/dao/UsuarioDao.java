package com.sysab.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sysab.client.jdbc.ConnectionFactory;
import com.sysab.client.model.Usuario;

public class UsuarioDao {
	Connection connection;
	
	public UsuarioDao() {
		Connection connection = new ConnectionFactory().getConnection();
		this.connection = connection;
	}
	
	public void cadastraUsuario(Usuario usuario) {
		try {
			String query = "INSERT INTO usuario (email, senha) VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar cadastro de usuário!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Impossível realizar fechamento de conexão com banco de dados!", e);
			}
		}
	}
	
	public void deletaUsuario(Usuario usuario) {
		try {
			String query = "DELETE FROM usuario WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usuario.getEmail());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar exclusão de usuário!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Impossível realizar fechamento de conexão com banco de dados!", e);
			}
		}
	}
	
	public boolean verificaUsuarioExistencia(Usuario usuario) {
		try {
			String query = "SELECT * FROM usuario WHERE email = ? and senha = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			
			ResultSet result = ps.executeQuery();

			return result.next();
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar validação de usuário!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Impossível realizar fechamento de conexão com banco de dados!", e);
			}
		}
	}
	
	public List<Usuario> getListaDeUsuario() {
		try {
			String sql = "SELECT email FROM usuario";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			List<Usuario> listaDeUsuario = new ArrayList<>();
			
			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setEmail(result.getString("email"));
				listaDeUsuario.add(usuario);
			}
			
			return listaDeUsuario;
		} catch (SQLException e) {
			throw new RuntimeException("A consulta causou uma exceção!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Impossível realizar fechamento de conexão com banco de dados!", e);
			}
		}
	}
}
