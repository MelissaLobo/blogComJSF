package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.GerenciadorDeUsuarios;
import model.Usuario;

@ManagedBean
public class UsuarioController {

	private Usuario usuario;
	private GerenciadorDeUsuarios funcao;

	public UsuarioController(GerenciadorDeUsuarios funcao) {
		this.funcao = funcao;
	}

	public void cadastrar(Usuario usuario) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		if (usuario == null) {
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Preencha os campos para se cadastrar", ""));
			return;
		} else {
			funcao.cadastrarUsuario(usuario);
		}
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Pessoa criada com sucesso!", ""));

	}

	public String logar(Usuario usuario, HttpSession session) {

		if (funcao.logar(usuario) != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		} else {
			return "redirect:formLogin";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
