package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("taktowanie")
public class Vali implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		int proc = (Integer) arg2;
		
		if (proc < 399){
			FacesMessage message = new FacesMessage();
			message.setDetail("procesor miec taktowanie powyzej 399");
			message.setSummary("procesor miec taktowanie powyzej 399");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}

}
