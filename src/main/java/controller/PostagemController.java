package controller;

import javax.faces.bean.ManagedBean;

import model.Blog;
import model.Usuario;

@ManagedBean
public class PostagemController {

	private Blog funcao;
	
	public PostagemController(Blog funcao) {
		this.funcao = funcao;
	}
	
	//Assim:
	public String postar(String titulo, String texto, Usuario usuario) {
		funcao.adicionarPostagem(titulo, texto, usuario);
		return "listaDePostagens";
	}
	//Ou assim:
	public String postar(Usuario usuario) {
		funcao.novaPostagem(usuario);
		return "listaDePostagens";
	}
}
