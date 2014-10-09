package util;

import static util.Ferramentas.directsHtlm;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

//@WebFilter(urlPatterns = "/*")
public class FilterAccess implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("filtro de acesso inicio");
		
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
			if(usuario == null){
				directsHtlm(req, resp, "/login.jsp");
			}		
			
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("filtro de acesso fim");
	}

	@Override
	public void destroy() {
	
		
	}

}
