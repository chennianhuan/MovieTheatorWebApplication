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
@Named(value = "showDescriptionBean")
@RequestScoped
public class ShowDescriptionBean {

    @EJB
    private movieEJB movieEJB;
    private Movie movie;
    private Theator theator;
    
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public ShowDescriptionBean() {
        int[] ids = getParameter();
        setMovie(new Movie(ids[1]));
        setTheator(new Theator(ids[0]));
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

    // Get the parameter passed in from the previous page
    public int[] getParameter(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int theatorid = Integer.parseInt(params.get("theatorid"));
        int movieid = Integer.parseInt(params.get("movieid"));
             
        return new int[]{theatorid, movieid};       
    }
     // Get the descripion for a movie
     public String getDescription(){
         List<Movie> m = movieEJB.getMovieForTheatoridMovieid(this.theator.getTheatorid(), this.movie.getMovieid());
         
         return m.get(0).getDescription();
     }
       
     // List times for a movie
     public String getMovieName(){
          List<Movie> m = movieEJB.getMovieForTheatoridMovieid(this.theator.getTheatorid(), this.movie.getMovieid());
         
         return m.get(0).getMoviename();
     }
}
