/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Nianhuan Chen
 */
@Named(value = "receiptBean")
@SessionScoped
public class ReceiptBean implements Serializable {
    private String creditcard;
    /**
     * Creates a new instance of ReceiptBean
     */
    public ReceiptBean() {
       
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }
   
    // Validate Credit card
    public void validateCreditCard(FacesContext context, UIComponent comp,
			Object value) throws ValidatorException{
  
         if(value == null){
            FacesMessage message = new FacesMessage("Credit Card Number is Needed, Please Go Back");
            message.setSeverity(SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
         }
         String z = (String) value;
         if(z.length() != 16 || !z.matches("\\d{16}")){
            FacesMessage message = new FacesMessage("Please Go Back Enter a Valid Card Number");
            message.setSeverity(SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
         }else{
              FacesMessage message = new FacesMessage("Thank you for your payment!");
              FacesContext.getCurrentInstance().addMessage(null, message);
         }    
    }
    
}
