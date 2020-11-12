/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "CategoriaDispositivo", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaDispositivo.findAll", query = "SELECT c FROM CategoriaDispositivo c")
    , @NamedQuery(name = "CategoriaDispositivo.findByIdCategoria", query = "SELECT c FROM CategoriaDispositivo c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaDispositivo.findByNomeCategoria", query = "SELECT c FROM CategoriaDispositivo c WHERE c.nomeCategoria = :nomeCategoria")})
public class CategoriaDispositivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Size(max = 100)
    @Column(name = "NomeCategoria")
    private String nomeCategoria;
    @OneToMany(mappedBy = "categoria")
    private Collection<DispositivoMovel> dispositivoMovelCollection;

    public CategoriaDispositivo() {
    }

    public CategoriaDispositivo(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @XmlTransient
    public Collection<DispositivoMovel> getDispositivoMovelCollection() {
        return dispositivoMovelCollection;
    }

    public void setDispositivoMovelCollection(Collection<DispositivoMovel> dispositivoMovelCollection) {
        this.dispositivoMovelCollection = dispositivoMovelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaDispositivo)) {
            return false;
        }
        CategoriaDispositivo other = (CategoriaDispositivo) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo[ idCategoria=" + idCategoria + " ]";
    }
    
}
