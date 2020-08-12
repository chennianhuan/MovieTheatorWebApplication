/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.util.List;
import java.lang.String;
import ejb.movieEJB;
import entity.Movie;
import entity.Theator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nianhuan Chen
 */
@Named(value = "showTheatorBean")
@SessionScoped
public class ShowTheatorBean implements Serializable {

    @EJB
    private movieEJB movieEJB;
    private Theator theator;
    private int zipcode;


    /**
     * Creates a new instance of ShowTheatorBean
     */
    public ShowTheatorBean() {
    }

    public Theator getTheator() {
        return theator;
    }

    public void setTheator(Theator theator) {
        this.theator = theator;
    }
    
    public String showTheator(Theator theator){
        this.theator = theator;
        return "ShowTheator";
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
 
    // List Theators for a zipcode
    public List<Theator> getTheatorList(){       
        List<Theator> l;       
        l = movieEJB.getTheatorsForZipcode(this.zipcode);
        return l;       
    }    
       
    // Find a theator by theator id
    public String getTheatorByID(int theatorid){
        return movieEJB.findATheatorByID(theatorid).getTheatorname();
    }
}
