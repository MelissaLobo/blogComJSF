package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class FiltroTransacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			System.out.println("filtro de transacao antes");
			EntityLocal.currentEntityManager.set(JpaUseful.getEntityManager());
			EntityLocal.currentEntityManager.get().getTransaction().begin();
			
			chain.doFilter(request, response);
			
			EntityLocal.currentEntityManager.get().getTransaction().commit();
			
			System.out.println("filtro de transacao dps");
		} catch (Exception e) {
			e.printStackTrace();
			EntityLocal.currentEntityManager.get().getTransaction().rollback();

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
