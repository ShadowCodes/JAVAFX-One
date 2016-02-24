package com.sysab.client.test;

import java.util.List;

import com.sysab.client.dao.UsuarioDao;
import com.sysab.client.model.Pessoa;
import com.sysab.client.model.Usuario;

public class Teste {
	public static void main(String[] args) {		
		
		UsuarioDao usuario = new UsuarioDao();
		List<Usuario> usuarioLista = usuario.getListaDeUsuario();
		
		for (Usuario novoUsuario : usuarioLista) {
			System.out.println(novoUsuario.getEmail());
		}
		
		
	}
}
