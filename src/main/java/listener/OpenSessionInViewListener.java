package listener;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.util.ExecutionCleanup;
import org.zkoss.zk.ui.util.ExecutionInit;

import model.hibernate.HibernateUtil;

public class OpenSessionInViewListener implements ExecutionInit, ExecutionCleanup {

	private static final Logger log = LoggerFactory.getLogger(OpenSessionInViewListener.class);
 
    public void init(Execution exec, Execution parent) {
        if (parent == null) { //the root execution of a servlet request
            log.debug("Starting a database transaction: "+exec);
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        }
    }
 
    public void cleanup(Execution exec, Execution parent, List errs) throws Exception{
        if (parent == null) { //the root execution of a servlet request
            if (errs == null || errs.isEmpty()) {
                log.debug("Committing the database transaction: "+exec);
                Transaction tr = HibernateUtil.getSessionFactory().getCurrentSession().getTransaction();
                TransactionStatus status = tr.getStatus();
				if (tr.isActive()){
                	tr.commit();
                }
            } else {
                final Throwable ex = (Throwable) errs.get(0);
                rollback(exec, ex);
            }
        }
    }
 
    private void rollback(Execution exec, Throwable ex) {
        try {
            if (HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                log.debug("Trying to rollback database transaction after exception:"+ex);
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            }
        } catch (Throwable rbEx) {
            log.error("Could not rollback transaction after exception! Original Exception:\n"+ex, rbEx);
        }
    }

}