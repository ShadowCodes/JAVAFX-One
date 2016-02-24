package com.sysab.client.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sysab.client.jdbc.ConnectionFactory;
import com.sysab.client.model.Pessoa;

public class PessoaDao {
	private Connection connection;
	
	public PessoaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaPessoa(Pessoa pessoa) {
		
		try {
			String sql = "INSERT INTO pessoa (tipo, nome, cpf, rg, razao, fantasia, cnpj, logradouro, numero, "
					+ "complemento, bairro, cep, telefone, celular, email, sexo, nascimento, cadastro)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, pessoa.getPessoa());
			prepared.setString(2, pessoa.getNomeCompleto());
			prepared.setString(3, pessoa.getCpf());
			prepared.setString(4, pessoa.getRg());
			prepared.setString(5, pessoa.getRazao());
			prepared.setString(6, pessoa.getFantasia());
			prepared.setString(7, pessoa.getCnpj());
			prepared.setString(8, pessoa.getLogradouro());
			prepared.setString(9, pessoa.getNumero());
			prepared.setString(10, pessoa.getComplemento());
			prepared.setString(11, pessoa.getBairro());
			prepared.setString(12, pessoa.getCep());
			prepared.setString(13, pessoa.getTelefone());
			prepared.setString(14, pessoa.getCelular());
			prepared.setString(15, pessoa.getEmail());
			prepared.setString(16, pessoa.getSexo());
			prepared.setDate(17, new Date(pessoa.getDataDeNascimento().getTimeInMillis()));
			prepared.setDate(18, new Date(pessoa.getDataDeCadastro().getTimeInMillis()));
			
			prepared.execute();
			prepared.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Impossível realizar a gravação no Banco", e);
		}
	}
	
	public List<Pessoa> getLista() {
		try {
			List<Pessoa> pessoas = new ArrayList<>();
			String sql = "SELECT * FROM pessoa";
			PreparedStatement prepared = connection.prepareStatement(sql);
			ResultSet result = prepared.executeQuery();
			
			while (result.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setPessoa(result.getString("tipo"));
				pessoa.setNomeCompleto(result.getString("nome"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setRg(result.getString("rg"));
				pessoa.setRazao(result.getString("razao"));
				pessoa.setFantasia(result.getString("fantasia"));
				pessoa.setCnpj(result.getString("cnpj"));
				pessoa.setLogradouro(result.getString("logradouro"));
				pessoa.setNumero(result.getString("numero"));
				pessoa.setComplemento(result.getString("complemento"));
				pessoa.setBairro(result.getString("bairro"));
				pessoa.setCep(result.getString("cep"));
				pessoa.setTelefone(result.getString("telefone"));
				pessoa.setCelular(result.getString("celular"));
				pessoa.setEmail(result.getString("email"));
				pessoa.setSexo(result.getString("sexo"));
				Calendar data = Calendar.getInstance();
				data.setTime(result.getDate("nascimento"));
				pessoa.setDataDeNascimento(data);
				Calendar data2 = Calendar.getInstance();
				data2.setTime(result.getDate("cadastro"));
				pessoa.setDataDeCadastro(data2);
	
				pessoas.add(pessoa);
			}
			
			result.close();
			prepared.close();
			connection.close();
			
			return pessoas;
		} catch (SQLException e) {
			throw new RuntimeException("Erro no lançamento da Querie", e);
		}
	}
	
}
