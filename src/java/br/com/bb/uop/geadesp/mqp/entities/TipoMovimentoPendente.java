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
@Table(name = "TipoMovimentoPendente", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimentoPendente.findAll", query = "SELECT t FROM TipoMovimentoPendente t")
    , @NamedQuery(name = "TipoMovimentoPendente.findByIdTipoMovimentoPendente", query = "SELECT t FROM TipoMovimentoPendente t WHERE t.idTipoMovimentoPendente = :idTipoMovimentoPendente")
    , @NamedQuery(name = "TipoMovimentoPendente.findByNomeTipoMovimentoPendente", query = "SELECT t FROM TipoMovimentoPendente t WHERE t.nomeTipoMovimentoPendente = :nomeTipoMovimentoPendente")
    , @NamedQuery(name = "TipoMovimentoPendente.findByDescricaoTipoMovimentoPendente", query = "SELECT t FROM TipoMovimentoPendente t WHERE t.descricaoTipoMovimentoPendente = :descricaoTipoMovimentoPendente")})
public class TipoMovimentoPendente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMovimentoPendente")
    private Integer idTipoMovimentoPendente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeTipoMovimentoPendente")
    private String nomeTipoMovimentoPendente;
    @Size(max = 1000)
    @Column(name = "DescricaoTipoMovimentoPendente")
    private String descricaoTipoMovimentoPendente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimentoPendente")
    private Collection<Telefone> telefoneCollection;

    public TipoMovimentoPendente() {
    }

    public TipoMovimentoPendente(Integer idTipoMovimentoPendente) {
        this.idTipoMovimentoPendente = idTipoMovimentoPendente;
    }

    public TipoMovimentoPendente(Integer idTipoMovimentoPendente, String nomeTipoMovimentoPendente) {
        this.idTipoMovimentoPendente = idTipoMovimentoPendente;
        this.nomeTipoMovimentoPendente = nomeTipoMovimentoPendente;
    }

    public Integer getIdTipoMovimentoPendente() {
        return idTipoMovimentoPendente;
    }

    public void setIdTipoMovimentoPendente(Integer idTipoMovimentoPendente) {
        this.idTipoMovimentoPendente = idTipoMovimentoPendente;
    }

    public String getNomeTipoMovimentoPendente() {
        return nomeTipoMovimentoPendente;
    }

    public void setNomeTipoMovimentoPendente(String nomeTipoMovimentoPendente) {
        this.nomeTipoMovimentoPendente = nomeTipoMovimentoPendente;
    }

    public String getDescricaoTipoMovimentoPendente() {
        return descricaoTipoMovimentoPendente;
    }

    public void setDescricaoTipoMovimentoPendente(String descricaoTipoMovimentoPendente) {
        this.descricaoTipoMovimentoPendente = descricaoTipoMovimentoPendente;
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
        hash += (idTipoMovimentoPendente != null ? idTipoMovimentoPendente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimentoPendente)) {
            return false;
        }
        TipoMovimentoPendente other = (TipoMovimentoPendente) object;
        if ((this.idTipoMovimentoPendente == null && other.idTipoMovimentoPendente != null) || (this.idTipoMovimentoPendente != null && !this.idTipoMovimentoPendente.equals(other.idTipoMovimentoPendente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.TipoMovimentoPendente[ idTipoMovimentoPendente=" + idTipoMovimentoPendente + " ]";
    }
    
}
