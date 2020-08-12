/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author H
 */
@Entity
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movie.findByMoviename", query = "SELECT m FROM Movie m WHERE m.moviename = :moviename"),
    @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description"),
    @NamedQuery(name = "Movie.findByTheatorid", query = "SELECT m FROM Movie m, Movietime n WHERE m.movieid = n.movietimePK.movieid and n.movietimePK.theatorid = :theatorid"),
    @NamedQuery(name = "Movie.findByTheatoridMovieid", query = "SELECT m FROM Movie m, Theator t, Movietime n WHERE m.movieid = n.movietimePK.movieid and t.theatorid = n.theator.theatorid and n.movietimePK.theatorid = :theatorid and m.movieid = :movieid")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOVIEID")
    private Integer movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<Movietime> movietimeCollection;

    public Movie() {
    }

    public Movie(Integer movieid) {
        this.movieid = movieid;
    }

    public Movie(Integer movieid, String moviename) {
        this.movieid = movieid;
        this.moviename = moviename;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Movietime> getMovietimeCollection() {
        return movietimeCollection;
    }

    public void setMovietimeCollection(Collection<Movietime> movietimeCollection) {
        this.movietimeCollection = movietimeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieid=" + movieid + " ]";
    }
    
}
