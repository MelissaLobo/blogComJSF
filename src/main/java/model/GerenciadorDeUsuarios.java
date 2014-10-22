package model;

import java.util.List;

import persistence.UsuarioDAO;

public class GerenciadorDeUsuarios {
	
	private UsuarioDAO dao;
		
	public void cadastrarUsuario(Usuario usuario) {
		dao.create(usuario);
	}

	public Usuario logar(Usuario usuario) {
		dao.buscaPorLoginESenha(usuario);
		return usuario;
	}

	public List<Usuario> listaDeUsuarios() {

		List<Usuario> usuarios = dao.findAll();
		return usuarios;
	}
	
}
