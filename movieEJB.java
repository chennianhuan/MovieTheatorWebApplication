/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movie;
import entity.Movietime;
import entity.Theator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author H
 */
@Stateless
public class movieEJB {

    @PersistenceContext(unitName = "JSFMoviesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Find all theators
    public List<Theator> findAllTheators(){
        return em.createNamedQuery("Theator.findAll", Theator.class).getResultList();
    }
    
    // Get zipcodes for all theators
    public List<Integer> findAllZipcodes(){
        List<Theator> list = findAllTheators();
        HashSet<Integer> hset = new HashSet<Integer>();
        for(Theator t:list){
            if(!hset.contains(t.getZipcode()))
                hset.add(t.getZipcode());
        }
        
        // Creating a list of zipcodes
        List<Integer> l = new ArrayList<Integer>(hset);
        
        return l;
    }
    
    public Theator findATheatorByID(int theatorid){
        return em.createNamedQuery("Theator.findByTheatorid", Theator.class).setParameter("theatorid", theatorid).getSingleResult();
    }
    
    // Find theators for a zipcode
    public List<Theator> getTheatorsForZipcode(int zipcode){
        return em.createNamedQuery("Theator.findByZipcode", Theator.class).setParameter("zipcode", zipcode).getResultList();
    }
    
    // Find movies for a theator
    public List<Movie> getMoviesForTheator(int theatorid){
        return em.createNamedQuery("Movie.findByTheatorid", Movie.class).setParameter("theatorid", theatorid).getResultList();
    }
    
    // Find movies for a theator id and a movie id
    public List<Movie> getMovieForTheatoridMovieid(int theatorid, int movieid){
        return em.createNamedQuery("Movie.findByTheatoridMovieid", Movie.class).setParameter("theatorid", theatorid).setParameter("movieid", movieid).getResultList();
    }
    // Find times for a movie
    public List<Movietime> getTimesForMovie(int theatorid, int movieid){
        return em.createNamedQuery("Movietime.findByTheatoridMovieid", Movietime.class).setParameter("theatorid", theatorid).setParameter("movieid", movieid).getResultList();
    }
    
    public Movietime getMovietimeForTheatoridMovieidTimeid(int theatorid, int movieid, int timeid){
        return em.createNamedQuery("Movietime.findByTheatoridMovieidTimeid", Movietime.class).setParameter("theatorid", theatorid).setParameter("movieid", movieid).setParameter("timeid", timeid).getSingleResult();
    }
}
