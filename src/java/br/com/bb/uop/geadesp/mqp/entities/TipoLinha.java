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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TipoLinha", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLinha.findAll", query = "SELECT t FROM TipoLinha t")
    , @NamedQuery(name = "TipoLinha.findByIdTipoLinha", query = "SELECT t FROM TipoLinha t WHERE t.idTipoLinha = :idTipoLinha")
    , @NamedQuery(name = "TipoLinha.findByNomeTipoLinha", query = "SELECT t FROM TipoLinha t WHERE t.nomeTipoLinha = :nomeTipoLinha")
    , @NamedQuery(name = "TipoLinha.findByDescricaoTipoLinha", query = "SELECT t FROM TipoLinha t WHERE t.descricaoTipoLinha = :descricaoTipoLinha")})
public class TipoLinha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoLinha")
    private Integer idTipoLinha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeTipoLinha")
    private String nomeTipoLinha;
    @Size(max = 1000)
    @Column(name = "DescricaoTipoLinha")
    private String descricaoTipoLinha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoLinha")
    private Collection<Telefone> telefoneCollection;

    public TipoLinha() {
    }

    public TipoLinha(Integer idTipoLinha) {
        this.idTipoLinha = idTipoLinha;
    }

    public TipoLinha(Integer idTipoLinha, String nomeTipoLinha) {
        this.idTipoLinha = idTipoLinha;
        this.nomeTipoLinha = nomeTipoLinha;
    }

    public Integer getIdTipoLinha() {
        return idTipoLinha;
    }

    public void setIdTipoLinha(Integer idTipoLinha) {
        this.idTipoLinha = idTipoLinha;
    }

    public String getNomeTipoLinha() {
        return nomeTipoLinha;
    }

    public void setNomeTipoLinha(String nomeTipoLinha) {
        this.nomeTipoLinha = nomeTipoLinha;
    }

    public String getDescricaoTipoLinha() {
        return descricaoTipoLinha;
    }

    public void setDescricaoTipoLinha(String descricaoTipoLinha) {
        this.descricaoTipoLinha = descricaoTipoLinha;
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
        hash += (idTipoLinha != null ? idTipoLinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLinha)) {
            return false;
        }
        TipoLinha other = (TipoLinha) object;
        if ((this.idTipoLinha == null && other.idTipoLinha != null) || (this.idTipoLinha != null && !this.idTipoLinha.equals(other.idTipoLinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.TipoLinha[ idTipoLinha=" + idTipoLinha + " ]";
    }
    
}
