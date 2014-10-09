package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Comentario;
import model.Postagem;

public class ComentarioDAO extends DaoGenerico<Comentario, Long> {

	@SuppressWarnings("unchecked")
	public List<Comentario> listaComentarioPorPost(Postagem postagem) {

		try {
			Query query = entityManager.createQuery("from Comentario comentario");
		//	query.setParameter("postagem", postagem);
			return query.getResultList();

		} catch (Exception e) {
		   e.printStackTrace();
		}
		return null;
	}

}
