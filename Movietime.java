/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author H
 */
@Entity
@Table(name = "MOVIETIME")
@NamedQueries({
    @NamedQuery(name = "Movietime.findAll", query = "SELECT m FROM Movietime m"),
    @NamedQuery(name = "Movietime.findByTheatorid", query = "SELECT m FROM Movietime m WHERE m.movietimePK.theatorid = :theatorid"),
    @NamedQuery(name = "Movietime.findByMovieid", query = "SELECT m FROM Movietime m WHERE m.movietimePK.movieid = :movieid"),
    @NamedQuery(name = "Movietime.findByTimeid", query = "SELECT m FROM Movietime m WHERE m.movietimePK.timeid = :timeid"),
    @NamedQuery(name = "Movietime.findByMoviedate", query = "SELECT m FROM Movietime m WHERE m.moviedate = :moviedate"),
    @NamedQuery(name = "Movietime.findByStartat", query = "SELECT m FROM Movietime m WHERE m.startat = :startat"),
    @NamedQuery(name = "Movietime.findByDuration", query = "SELECT m FROM Movietime m WHERE m.duration = :duration"),
    @NamedQuery(name = "Movietime.findByTheatoridMovieid", query = "SELECT mt FROM Movietime mt WHERE mt.movietimePK.theatorid = :theatorid and mt.movietimePK.movieid = :movieid"),
    @NamedQuery(name = "Movietime.findByTheatoridMovieidTimeid", query = "SELECT n FROM Movie m, Theator t, Movietime n WHERE m.movieid = n.movietimePK.movieid and t.theatorid = n.theator.theatorid and n.movietimePK.theatorid = :theatorid and m.movieid = :movieid and n.movietimePK.timeid =:timeid")})
public class Movietime implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovietimePK movietimePK;
    @Column(name = "MOVIEDATE")
    @Temporal(TemporalType.DATE)
    private Date moviedate;
    @Column(name = "STARTAT")
    @Temporal(TemporalType.TIME)
    private Date startat;
    @Size(max = 25)
    @Column(name = "DURATION")
    private String duration;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "THEATORID", referencedColumnName = "THEATORID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theator theator;

    public Movietime() {
    }

    public Movietime(MovietimePK movietimePK) {
        this.movietimePK = movietimePK;
    }

    public Movietime(int theatorid, int movieid, int timeid) {
        this.movietimePK = new MovietimePK(theatorid, movieid, timeid);
    }

    public MovietimePK getMovietimePK() {
        return movietimePK;
    }

    public void setMovietimePK(MovietimePK movietimePK) {
        this.movietimePK = movietimePK;
    }

    public Date getMoviedate() {
        return moviedate;
    }

    public void setMoviedate(Date moviedate) {
        this.moviedate = moviedate;
    }

    public Date getStartat() {
        return startat;
    }

    public void setStartat(Date startat) {
        this.startat = startat;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movietimePK != null ? movietimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movietime)) {
            return false;
        }
        Movietime other = (Movietime) object;
        if ((this.movietimePK == null && other.movietimePK != null) || (this.movietimePK != null && !this.movietimePK.equals(other.movietimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movietime[ movietimePK=" + movietimePK + " ]";
    }
    
}
