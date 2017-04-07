package br.com.jkavdev.devdojo.padrao.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {
	
	public static void addErrorMessage(String key){
		addMessage(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
	}
	
	public static void addWarningMessage(String key){
		addMessage(FacesMessage.SEVERITY_WARN, getBundleValue(key));
	}
	
	public static void addSuccessMessage(String key){
		addMessage(FacesMessage.SEVERITY_INFO, getBundleValue(key));
	}

	private static void addMessage(FacesMessage.Severity severity, String message) {
		final FacesMessage facesMessage = new FacesMessage(severity, message, "");
		// Mantendo a mensagem durante navegacao de paginas
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setRedirect(true);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	private static String getBundleValue(String key) {
		return FacesContext.getCurrentInstance()
				.getApplication()
				.getResourceBundle(FacesContext.getCurrentInstance(), "messages")
				.getString(key);
	}
	
}
