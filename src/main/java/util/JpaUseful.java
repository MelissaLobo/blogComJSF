package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUseful {

	private static final String PERSISTENCE_UNIT = "blogComJSF";
	private static EntityManagerFactory entityManagerFactory;

	private JpaUseful() {
	}

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return entityManagerFactory.createEntityManager();
	}

}
