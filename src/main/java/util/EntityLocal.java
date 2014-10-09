package util;

import javax.persistence.EntityManager;

public class EntityLocal {

	public static ThreadLocal<EntityManager> currentEntityManager = new ThreadLocal<EntityManager>();
	
}
