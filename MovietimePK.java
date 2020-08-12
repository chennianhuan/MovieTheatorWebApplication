/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author H
 */
@Embeddable
public class MovietimePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATORID")
    private int theatorid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private int movieid;
    @Basic(optional = false)
    @Column(name = "TIMEID")
    private int timeid;

    public MovietimePK() {
    }

    public MovietimePK(int theatorid, int movieid, int timeid) {
        this.theatorid = theatorid;
        this.movieid = movieid;
        this.timeid = timeid;
    }

    public int getTheatorid() {
        return theatorid;
    }

    public void setTheatorid(int theatorid) {
        this.theatorid = theatorid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getTimeid() {
        return timeid;
    }

    public void setTimeid(int timeid) {
        this.timeid = timeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) theatorid;
        hash += (int) movieid;
        hash += (int) timeid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovietimePK)) {
            return false;
        }
        MovietimePK other = (MovietimePK) object;
        if (this.theatorid != other.theatorid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        if (this.timeid != other.timeid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MovietimePK[ theatorid=" + theatorid + ", movieid=" + movieid + ", timeid=" + timeid + " ]";
    }
    
}
