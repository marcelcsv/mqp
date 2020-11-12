/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DispositivoMovel", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DispositivoMovel.findAll", query = "SELECT d FROM DispositivoMovel d")
    , @NamedQuery(name = "DispositivoMovel.findByIdDispositivoMovel", query = "SELECT d FROM DispositivoMovel d WHERE d.idDispositivoMovel = :idDispositivoMovel")
    , @NamedQuery(name = "DispositivoMovel.findByNomeDispositivoMovel", query = "SELECT d FROM DispositivoMovel d WHERE d.nomeDispositivoMovel = :nomeDispositivoMovel")})
public class DispositivoMovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDispositivoMovel")
    private Integer idDispositivoMovel;
    @Size(max = 100)
    @Column(name = "NomeDispositivoMovel")
    private String nomeDispositivoMovel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dispositivo")
    private Collection<Telefone> telefoneCollection;
    @JoinColumn(name = "Categoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private CategoriaDispositivo categoria;

    public DispositivoMovel() {
    }

    public DispositivoMovel(Integer idDispositivoMovel) {
        this.idDispositivoMovel = idDispositivoMovel;
    }

    public Integer getIdDispositivoMovel() {
        return idDispositivoMovel;
    }

    public void setIdDispositivoMovel(Integer idDispositivoMovel) {
        this.idDispositivoMovel = idDispositivoMovel;
    }

    public String getNomeDispositivoMovel() {
        return nomeDispositivoMovel;
    }

    public void setNomeDispositivoMovel(String nomeDispositivoMovel) {
        this.nomeDispositivoMovel = nomeDispositivoMovel;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    public CategoriaDispositivo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDispositivo categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDispositivoMovel != null ? idDispositivoMovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DispositivoMovel)) {
            return false;
        }
        DispositivoMovel other = (DispositivoMovel) object;
        if ((this.idDispositivoMovel == null && other.idDispositivoMovel != null) || (this.idDispositivoMovel != null && !this.idDispositivoMovel.equals(other.idDispositivoMovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel[ idDispositivoMovel=" + idDispositivoMovel + " ]";
    }
    
}
