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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "NivelAcesso", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcesso.findAll", query = "SELECT n FROM NivelAcesso n")
    , @NamedQuery(name = "NivelAcesso.findByIdNivelAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.idNivelAcesso = :idNivelAcesso")
    , @NamedQuery(name = "NivelAcesso.findByNomeAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.nomeAcesso = :nomeAcesso")
    , @NamedQuery(name = "NivelAcesso.findByDescricaoAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.descricaoAcesso = :descricaoAcesso")
    , @NamedQuery(name = "NivelAcesso.findBySiglaAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.siglaAcesso = :siglaAcesso")})
public class NivelAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNivelAcesso")
    private Integer idNivelAcesso;
    @Size(max = 100)
    @Column(name = "NomeAcesso")
    private String nomeAcesso;
    @Size(max = 1000)
    @Column(name = "DescricaoAcesso")
    private String descricaoAcesso;
    @Size(max = 10)
    @Column(name = "SiglaAcesso")
    private String siglaAcesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelAcesso")
    private Collection<UorPos> uorPosCollection;

    public NivelAcesso() {
    }

    public NivelAcesso(Integer idNivelAcesso) {
        this.idNivelAcesso = idNivelAcesso;
    }

    public Integer getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public void setIdNivelAcesso(Integer idNivelAcesso) {
        this.idNivelAcesso = idNivelAcesso;
    }

    public String getNomeAcesso() {
        return nomeAcesso;
    }

    public void setNomeAcesso(String nomeAcesso) {
        this.nomeAcesso = nomeAcesso;
    }

    public String getDescricaoAcesso() {
        return descricaoAcesso;
    }

    public void setDescricaoAcesso(String descricaoAcesso) {
        this.descricaoAcesso = descricaoAcesso;
    }

    public String getSiglaAcesso() {
        return siglaAcesso;
    }

    public void setSiglaAcesso(String siglaAcesso) {
        this.siglaAcesso = siglaAcesso;
    }

    @XmlTransient
    public Collection<UorPos> getUorPosCollection() {
        return uorPosCollection;
    }

    public void setUorPosCollection(Collection<UorPos> uorPosCollection) {
        this.uorPosCollection = uorPosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelAcesso != null ? idNivelAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcesso)) {
            return false;
        }
        NivelAcesso other = (NivelAcesso) object;
        if ((this.idNivelAcesso == null && other.idNivelAcesso != null) || (this.idNivelAcesso != null && !this.idNivelAcesso.equals(other.idNivelAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.NivelAcesso[ idNivelAcesso=" + idNivelAcesso + " ]";
    }
    
}
