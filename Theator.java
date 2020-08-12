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
@Table(name = "THEATOR")
@NamedQueries({
    @NamedQuery(name = "Theator.findAll", query = "SELECT t FROM Theator t"),
    @NamedQuery(name = "Theator.findByTheatorid", query = "SELECT t FROM Theator t WHERE t.theatorid = :theatorid"),
    @NamedQuery(name = "Theator.findByTheatorname", query = "SELECT t FROM Theator t WHERE t.theatorname = :theatorname"),
    @NamedQuery(name = "Theator.findByZipcode", query = "SELECT t FROM Theator t WHERE t.zipcode = :zipcode")})
public class Theator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "THEATORID")
    private Integer theatorid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATORNAME")
    private String theatorname;
    @Column(name = "ZIPCODE")
    private Integer zipcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theator")
    private Collection<Movietime> movietimeCollection;

    public Theator() {
    }

    public Theator(Integer theatorid) {
        this.theatorid = theatorid;
    }

    public Theator(Integer theatorid, String theatorname) {
        this.theatorid = theatorid;
        this.theatorname = theatorname;
    }

    public Integer getTheatorid() {
        return theatorid;
    }

    public void setTheatorid(Integer theatorid) {
        this.theatorid = theatorid;
    }

    public String getTheatorname() {
        return theatorname;
    }

    public void setTheatorname(String theatorname) {
        this.theatorname = theatorname;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
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
        hash += (theatorid != null ? theatorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theator)) {
            return false;
        }
        Theator other = (Theator) object;
        if ((this.theatorid == null && other.theatorid != null) || (this.theatorid != null && !this.theatorid.equals(other.theatorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theator[ theatorid=" + theatorid + " ]";
    }
    
}
