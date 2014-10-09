package model;

import java.util.ArrayList;
import java.util.List;

import persistence.ComentarioDAO;
import persistence.PostagemDAO;
import persistence.UsuarioDAO;

public class Blog {

	PostagemDAO postagemDAO = new PostagemDAO();
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void adicionarComentario(String nome, String texto, int idDoPost) {

		long id = idDoPost;

		Comentario comentarios = new Comentario(nome, texto);

		Postagem postagem = postagemDAO.find(id);

		postagem.getComentarios().add(comentarios);
		
		postagem.getComentarios().add(comentarios);

		postagemDAO.update(postagem);

	}

	public void adicionarPostagem(String titulo, String texto, Usuario usuario) {

		Usuario usuarioGerenciado = usuarioDAO.find(usuario.getId());
		
		Postagem postagem = new Postagem();
		postagem.setTitulo(titulo);
		postagem.setTexto(texto);
		
		usuarioGerenciado.getPostagens().add(postagem);

		usuarioDAO.update(usuarioGerenciado);

	}

	public List<Postagem> listaPostsPorUsuario(Usuario usuario) {
		return postagemDAO.listaPostsPorUsuario(usuario);
	}

	public List<Postagem> listaTodos() {

		return postagemDAO.findAll();

	}

	public List<Postagem> listaDePostagens(Usuario usuario) {
		List<Postagem> listaTodos = postagemDAO.listaPostsPorUsuario(usuario);

		for (Postagem postagem : listaTodos) {
			postagem.getId();
			postagem.getTitulo();
			for (Comentario coment : postagem.getComentarios()) {
				coment.getId();
				coment.getNome();
			}
		}
		return listaTodos;

	}

	public Postagem buscaPostPorID(Long id) {

		return postagemDAO.find(id);
	}

	public List<Comentario> buscaComentariosDoPostPorID(Long id) {
		ComentarioDAO comentarioDAO = new ComentarioDAO();

		Postagem postagem = postagemDAO.find(id);

		List<Comentario> comentariosDoPost = comentarioDAO.listaComentarioPorPost(postagem);

	    for (Comentario coment : comentariosDoPost) {
			coment.getNome();
			coment.getTexto();
		}

		return comentariosDoPost;
	}

}