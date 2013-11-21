
package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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

        // Validators

        // sprawdzanie czy sn jest juz w bazie
 /*       public void serialNumber(FacesContext context, UIComponent component, Object value) {

                String serialNumber = (String) value;

                for (Watch watch : watchMenager.writeAllWatchs()) {
                        if (watch.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                                FacesMessage message = new FacesMessage("Watch with this serial number exists in database");
                                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                throw new ValidatorException(message);
                        }
                }
        } */ 
}