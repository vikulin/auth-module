package controller;

import org.springframework.security.access.annotation.Secured;
import org.zkoss.zk.ui.select.annotation.Listen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.hibernate.HibernateUtil;

public class DeleteController extends AbstractController {

	private static final long serialVersionUID = 3031513248715349621L;

    @Listen("onClick = #yes")
    @Secured({"ROLE_ADMIN"})
    public void delete() throws Exception {
    	Object obj = getObject();
    	EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    	EntityTransaction tr = entityManager.getTransaction();
    	if (obj!=null){
    		tr.begin();
    		entityManager.remove(obj);
			close(entityManager);
			delete(obj);
    	}
    }

}
