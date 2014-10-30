package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Blog;
import model.Postagem;
import model.Usuario;

@ManagedBean
public class PostagemController {

	private Blog funcao;
	private String titulo;
	private String texto;
	private List<Postagem> postagens;
	
	public PostagemController(Blog funcao) {
		this.funcao = funcao;
	}
	
	public void postar(Usuario usuario){
		funcao.adicionarPostagem(titulo, texto, usuario);
	}
	
	public String cancelar(Usuario usuario) {
		usuario = null;
		return "index";
	}
	
	public List<Postagem> getPosts(Usuario usuario) {
		return  funcao.listaDePostagens(usuario);
       
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	
	
}
