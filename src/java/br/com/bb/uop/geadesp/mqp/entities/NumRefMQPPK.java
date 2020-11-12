/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Embeddable
public class NumRefMQPPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NumRef")
    private int numRef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMQP")
    private int idMQP;

    public NumRefMQPPK() {
    }

    public NumRefMQPPK(int numRef, int idMQP) {
        this.numRef = numRef;
        this.idMQP = idMQP;
    }

    public int getNumRef() {
        return numRef;
    }

    public void setNumRef(int numRef) {
        this.numRef = numRef;
    }

    public int getIdMQP() {
        return idMQP;
    }

    public void setIdMQP(int idMQP) {
        this.idMQP = idMQP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numRef;
        hash += (int) idMQP;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumRefMQPPK)) {
            return false;
        }
        NumRefMQPPK other = (NumRefMQPPK) object;
        if (this.numRef != other.numRef) {
            return false;
        }
        if (this.idMQP != other.idMQP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK[ numRef=" + numRef + ", idMQP=" + idMQP + " ]";
    }
    
}
