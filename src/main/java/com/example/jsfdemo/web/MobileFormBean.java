
package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Mobile;
import com.example.jsfdemo.service.MobileManager;

@SessionScoped    //zasieg
@Named("mobileF")  // odwolanie do tej klasy
public class MobileFormBean implements Serializable {
        
	private static final long serialVersionUID = 1L;

		private Mobile mobile = new Mobile();

        @Inject //wstrzykiwanie managera- do obslugi funkcji managera
        private MobileManager mobileMenager;

        public Mobile getMobile() {
                return mobile;
        }

        public void setMobile(Mobile mobile) {
                this.mobile = mobile;
        }

        // dodanie mobile po nacisnieciu przycisku
        public String addMobile() {
                mobileMenager.addMobile(mobile);
                return "mobileList";
        }

        public List<Mobile> getAllMobile() {
                return mobileMenager.getDb();
        }
        
        public String deletedMobile(){
        	mobileMenager.deleteMobile(mobile);
        	return "mobileList";
        }
        
        public String searchedMobile(){
        	mobileMenager.searchMobile(mobile);
        	return "mobileOneList";
        }
        
        public Mobile getoneMobile(){
        return mobile;
        }
       

        // Validators

        // sprawdzanie czy sn jest juz w bazie
        public void model(FacesContext context, UIComponent component, Object value) {

                String modelek = (String) value;

                for (Mobile mobile : mobileMenager.getDb()) {
                        if (mobile.getModel().equalsIgnoreCase(modelek)) {
                                FacesMessage message = new FacesMessage("komorka o danym model juz istnieje");
                                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                throw new ValidatorException(message);
                        }
                }
        }  
}