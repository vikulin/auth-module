package controller;

import java.sql.SQLException;

import org.springframework.security.access.annotation.Secured;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Messagebox;

public abstract class AbstractModifyController extends AbstractController{
	
    @Listen("onClick = #saveButton")
    @Secured({"ROLE_ADMIN"})
	public void saveObject() throws Exception {
		try {
			this.save();
		} catch (Exception e) {
			e.printStackTrace();
			int errorCode = getErrorCode(e);
			if(errorCode==1062){
				Messagebox.show("Такой объект уже существует!","Error",Messagebox.OK, Messagebox.ERROR);
				return;
			}
			throw e;
		}
	}
	
	public static int getErrorCode(Exception e) {
	    Throwable throwable = e;
	    while (throwable != null && !(throwable instanceof SQLException)) {
	        throwable = throwable.getCause();
	    }
	    if (throwable instanceof SQLException) {
	        SQLException sqlex = (SQLException) throwable;
	        int errorCode = sqlex.getErrorCode();
	        return errorCode;
	    }
	    return 0;
	}
	
	protected abstract void save() throws Exception;

}
