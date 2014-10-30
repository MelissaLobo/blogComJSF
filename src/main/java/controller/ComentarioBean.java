package controller;

import java.util.ArrayList;
import java.util.List;

import model.Blog;
import model.Comentario;
import model.Postagem;

public class ComentarioBean {
	
	private Blog funcao;
    private Postagem postagens;
    private List <Comentario> comentario = new ArrayList<>();
    private Long id_postagem;
	public Postagem getPostagens() {
		return postagens;
	}
	public void setPostagens(Postagem postagens) {
		this.postagens = postagens;
	}
	public List<Comentario> getComentario() {
		return comentario;
	}
	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	public Long getId_postagem() {
		return id_postagem;
	}
	public void setId_postagem(Long id_postagem) {
		this.id_postagem = id_postagem;
	}

    
}
