/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.movieEJB;
import entity.Movie;
import entity.Movietime;
import entity.MovietimePK;
import entity.Theator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author H
 */
@Named(value = "confirmBuyingBean")
@SessionScoped
public class ConfirmBuyingBean implements Serializable{ 
    
    @EJB
    private movieEJB movieEJB;
    private Movietime movietime;
    private Theator theator;
    private Movie movie;

    /**
     * Creates a new instance of ConfirmBuyingBean
     */
    public ConfirmBuyingBean() {
        int[] ids = getParameters();
        setTheator(new Theator(ids[0]));
        setMovie(new Movie(ids[1]));
    }

    public Movietime getMovietime() {
        return movietime;
    }

    public void setMovietime(Movietime movietime) {
        this.movietime = movietime;
    } 
    public String showConfirmBuying(Movietime movietime){
        this.movietime = movietime;
        return "ConfirmBuying";
    }
    public Theator getTheator() {
        return theator;
    }

    public void setTheator(Theator theator) {
        this.theator = theator;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
   
    public int[] getParameters(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int theatorid = Integer.parseInt(params.get("theatorid"));
        int movieid = Integer.parseInt(params.get("movieid"));
        int timeid = Integer.parseInt(params.get("timeid"));
      
        return new int[]{theatorid, movieid, timeid};      
    }    
    
    public Movietime getSelectedMovietime(){
       int[] ids = getParameters();
       this.movietime = movieEJB.getMovietimeForTheatoridMovieidTimeid(ids[0], ids[1], ids[2]);
               
        return this.movietime; 
    }

}
