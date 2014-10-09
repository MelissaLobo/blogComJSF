package model;

import java.util.List;

import persistence.UsuarioDAO;

public class GerenciadorDeUsuarios {
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void cadastrarUsuario(String name, String email, String senha) {

		Usuario usuario = new Usuario(name, email, senha);
		
		usuarioDAO.create(usuario);
	}

	public List<Usuario> listaDeUsuarios() {
		return usuarioDAO.findAll();
	}
	
	public Usuario tentaLogar(String email, String senha) {
		return usuarioDAO.buscaPorLoginESenha(email, senha);
	}
	
}
