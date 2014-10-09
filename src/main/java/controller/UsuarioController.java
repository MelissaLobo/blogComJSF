package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Blog;
import model.Usuario;

public class UsuarioController {
	
		
	public String formularioDeCadastro() {
		return "formCadastro";
	}

	
	public String cadastrar(Usuario usuario) {
		funcao.cadastrarUsuario(usuario);
		return "loginForm";
	}

	
	public String formularioDeLogin() {
		return "loginForm";
	}

	
	public String logar(Usuario usuario, HttpSession session) {

		if (funcao.logar(usuario) != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		} else {
			return "redirect:loginForm";
		}
	}

	
	public String listaDeUsuarios() {

		List<Usuario> usuarios = funcao.listaDeUsuarios();
		usuarios.add("todosOsUsuarios", usuarios);
		return usuarios;
	}

}
