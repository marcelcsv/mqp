/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "OperadoraTelefone", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperadoraTelefone.findAll", query = "SELECT o FROM OperadoraTelefone o")
    , @NamedQuery(name = "OperadoraTelefone.findByIdOperadora", query = "SELECT o FROM OperadoraTelefone o WHERE o.idOperadora = :idOperadora")
    , @NamedQuery(name = "OperadoraTelefone.findByNomeOperadora", query = "SELECT o FROM OperadoraTelefone o WHERE o.nomeOperadora = :nomeOperadora")})
public class OperadoraTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOperadora")
    private Integer idOperadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeOperadora")
    private String nomeOperadora;
    @OneToMany(mappedBy = "operadora")
    private Collection<Telefone> telefoneCollection;

    public OperadoraTelefone() {
    }

    public OperadoraTelefone(Integer idOperadora) {
        this.idOperadora = idOperadora;
    }

    public OperadoraTelefone(Integer idOperadora, String nomeOperadora) {
        this.idOperadora = idOperadora;
        this.nomeOperadora = nomeOperadora;
    }

    public Integer getIdOperadora() {
        return idOperadora;
    }

    public void setIdOperadora(Integer idOperadora) {
        this.idOperadora = idOperadora;
    }

    public String getNomeOperadora() {
        return nomeOperadora;
    }

    public void setNomeOperadora(String nomeOperadora) {
        this.nomeOperadora = nomeOperadora;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperadora != null ? idOperadora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperadoraTelefone)) {
            return false;
        }
        OperadoraTelefone other = (OperadoraTelefone) object;
        if ((this.idOperadora == null && other.idOperadora != null) || (this.idOperadora != null && !this.idOperadora.equals(other.idOperadora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone[ idOperadora=" + idOperadora + " ]";
    }
    
}
