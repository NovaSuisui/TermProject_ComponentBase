/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SK
 */
@Embeddable
public class Cv19ddcPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "YEARNUM")
    private int yearnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEKNUM")
    private int weeknum;

    public Cv19ddcPK() {
    }

    public Cv19ddcPK(int yearnum, int weeknum) {
        this.yearnum = yearnum;
        this.weeknum = weeknum;
    }

    public int getYearnum() {
        return yearnum;
    }

    public void setYearnum(int yearnum) {
        this.yearnum = yearnum;
    }

    public int getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(int weeknum) {
        this.weeknum = weeknum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) yearnum;
        hash += (int) weeknum;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv19ddcPK)) {
            return false;
        }
        Cv19ddcPK other = (Cv19ddcPK) object;
        if (this.yearnum != other.yearnum) {
            return false;
        }
        if (this.weeknum != other.weeknum) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cv19ddcPK[ yearnum=" + yearnum + ", weeknum=" + weeknum + " ]";
    }
    
}
