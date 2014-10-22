package controller;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import model.GerenciadorDeUsuarios;
import model.Usuario;

@ManagedBean
public class UsuarioController {
	
	private GerenciadorDeUsuarios funcao;
	
	public UsuarioController(GerenciadorDeUsuarios funcao) {
		this.funcao = funcao;
	}
	
	public String formularioDeCadastro() {
		return "/formCadastro.xhtml";
	}

	
	public String cadastrar(Usuario usuario) {
		funcao.cadastrarUsuario(usuario);
		return "/formLogin.xhtml";
	}

	
	public String formularioDeLogin() {
		return "/formLogin.xhtml";
	}

	
	public String logar(Usuario usuario, HttpSession session) {

		if (funcao.logar(usuario) != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		} else {
			return "redirect:formLogin";
		}
	}

	
//	public String listaDeUsuarios() {
//
//		List<Usuario> usuarios = funcao.listaDeUsuarios();
//		usuarios.add("todosOsUsuarios", usuarios);
//		return usuarios;
//	}

}
