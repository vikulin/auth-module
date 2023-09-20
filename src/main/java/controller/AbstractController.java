package controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

import model.hibernate.HibernateUtil;

public abstract class AbstractController extends SelectorComposer<Window> {
	
	private static final long serialVersionUID = 1964345598793160341L;
	private Object obj;
	private AbstractController parentController;
	private static final String selectedItem = "object";
	private static final String controller = "controller";

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		final Execution execution = Executions.getCurrent();
		obj = execution.getArg().get(selectedItem);
		parentController = (AbstractController) execution.getArg().get(controller);
		comp.setAttribute(controller, this);
	}
	
	public void openWindow(String page, Object obj) {
		Map<String, Object> arguments = new HashMap<String, Object>();
		arguments.put(selectedItem, obj);
		arguments.put(controller, this);
		try {
	        Window window = (Window)Executions.createComponents(page, null, arguments);
	        window.doModal();
		} catch (SuspendNotAllowedException e) {
			e.printStackTrace();
		} catch (UiException e) {
			e.printStackTrace();
			alert(e.getMessage());			
		} catch (Exception e) {
			e.printStackTrace();
			alert(e.getMessage());
		}
	}

	public Object getObject() {
		return obj;
	}
	
    @Listen("onClick = #closeButton")
    public void close() throws Exception {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction tr = session.getTransaction();
    	try {
    		if (tr.getStatus().equals(TransactionStatus.ACTIVE)) {
    			tr.commit();
    		}
    	} catch (Exception ex){
    		tr.rollback();
    		throw new Exception(ex);
    	}
    	getSelf().detach();
    }
	
	public void reload(Object obj){
		parentController.reload(obj);
	}
	
	public void delete(Object obj){
		parentController.delete(obj);
	}

}
