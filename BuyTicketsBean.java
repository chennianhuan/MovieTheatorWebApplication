/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.movieEJB;
import entity.Movie;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import entity.Movietime;
import entity.Theator;
import java.util.ArrayList;

/**
 *
 * @author Nianhuan Chen
 */
@Named(value = "buyTicketsBean")
@RequestScoped
public class BuyTicketsBean {

    @EJB
    private movieEJB movieEJB;
    private List<Movietime> mtList;
    private Movietime movietime;
    private Movie movie;
    

    /**
     * Creates a new instance of BuyTicketsBean
     */
    public BuyTicketsBean() {
   
    }

    public List<Movietime> getMtList() {
        return mtList;
    }

    public Movietime getMovietime() {
        return movietime;
    }

    public void setMovietime(Movietime movietime) {
        this.movietime = movietime;
    }
    
    public void setMtList(List<Movietime> mtList) {
        this.mtList = mtList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
     
    // Get parameter passed in from the previous page
    public int[] getParameter(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int theatorid = Integer.parseInt(params.get("theatorid"));
        int movieid = Integer.parseInt(params.get("movieid"));
             
        return new int[]{theatorid, movieid};       
    }
      
    public List<Movietime> getMovieTimeList(){
      int[] ids = getParameter();
      setMtList(movieEJB.getTimesForMovie(ids[0], ids[1]));
      List<Movietime> m = movieEJB.getTimesForMovie(ids[0], ids[1]);
      return m;
     }
    
    public Movietime getMovieTime(int theatorid, int movieid, int timeid){
        this.movietime = movieEJB.getMovietimeForTheatoridMovieidTimeid(theatorid, movieid, timeid);
        return this.movietime;
    }
    
    // Get all available time for a selected movie
    public  String getMovieName(){
       int[] ids = getParameter();
       return movieEJB.getMovieForTheatoridMovieid(ids[0], ids[1]).get(0).getMoviename();
    }
}
