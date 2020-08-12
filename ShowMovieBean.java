/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.movieEJB;
import entity.Movie;
import entity.Theator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nianhuan Chen
 */
@Named(value = "showMovieBean")
@RequestScoped
public class ShowMovieBean {

    @EJB
    private movieEJB movieEJB;
    private Movie movie;
    private Theator theator;
    
    /**
     * Creates a new instance of ShowMovieBean
     */
    public ShowMovieBean() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theator getTheator() {
        return theator;
    }

    public void setTheator(Theator theator) {
        this.theator = theator;
    }
    
    public String showMovie(Movie movie){
        this.movie = movie;
        return "ShowMovie";
    }
    
    // Get the parameter needed for ShowMovie page
    public int getParameter(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        String theatorid_S = params.get("theatorid");
        int theatorid = Integer.parseInt(theatorid_S);
        return theatorid;       
    }
    
    public int findZipcode(){
        int t = getParameter();
        this.theator = movieEJB.findATheatorByID(t);
        int zipcode = this.theator.getZipcode();
        return zipcode;
    }
    
    // List Movies for a theator
     public List<Movie> getMovieList(){
          int  t = getParameter();
          List<Movie> m = movieEJB.getMoviesForTheator(t);
          return m;
     }
        
}
