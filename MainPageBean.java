/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.movieEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Nianhuan Chen
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean implements Serializable {

    @EJB
    private movieEJB movieEJB; 
    /**
     * Creates a new instance of MainPageBean
     */
    public MainPageBean() {
    }
     
    // Show all available zipcode on the main page under FIND A THEATOR
    public List<Integer> getZipcodeList(){
        return movieEJB.findAllZipcodes();
    }

    // Validate Zipcode
    public void validateZipcode(FacesContext context, UIComponent comp,
			Object value) throws ValidatorException{
        List<Integer> l = getZipcodeList();
        if(!(value instanceof Integer || (value == null))){
            FacesMessage message = new FacesMessage("Please Enter a Valid Zipcode Number."
                    + "you can go back to look up the zipcode by hovering over FIND A THEATOR");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
         String z = String.valueOf(value);
            if(z.length() != 5 || (!l.contains(Integer.parseInt(z)))){
                 FacesMessage message = new FacesMessage("Please Enter a Valid Zipcode Number. You can"
                         + " go back look up the zipcode by hovering over FIND A THEATOR");
                 message.setSeverity(SEVERITY_ERROR);
                 FacesContext.getCurrentInstance().addMessage("zip", message);
            }else{
                  FacesMessage message = new FacesMessage("Please Select a Theator By Hovering Over "
                         + "FIND A THEATOR");
                  message.setSeverity(SEVERITY_INFO);
                 FacesContext.getCurrentInstance().addMessage(null, message);
            }
    }
}
