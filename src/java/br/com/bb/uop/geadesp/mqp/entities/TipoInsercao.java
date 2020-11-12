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
@Table(name = "TipoInsercao", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInsercao.findAll", query = "SELECT t FROM TipoInsercao t")
    , @NamedQuery(name = "TipoInsercao.findByIdTipoInsercao", query = "SELECT t FROM TipoInsercao t WHERE t.idTipoInsercao = :idTipoInsercao")
    , @NamedQuery(name = "TipoInsercao.findByNomeTipoInsercao", query = "SELECT t FROM TipoInsercao t WHERE t.nomeTipoInsercao = :nomeTipoInsercao")
    , @NamedQuery(name = "TipoInsercao.findByDescricaoTipoInsercao", query = "SELECT t FROM TipoInsercao t WHERE t.descricaoTipoInsercao = :descricaoTipoInsercao")})
public class TipoInsercao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoInsercao")
    private Integer idTipoInsercao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeTipoInsercao")
    private String nomeTipoInsercao;
    @Size(max = 1000)
    @Column(name = "DescricaoTipoInsercao")
    private String descricaoTipoInsercao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insercao")
    private Collection<Mqp> mqpCollection;

    public TipoInsercao() {
    }

    public TipoInsercao(Integer idTipoInsercao) {
        this.idTipoInsercao = idTipoInsercao;
    }

    public TipoInsercao(Integer idTipoInsercao, String nomeTipoInsercao) {
        this.idTipoInsercao = idTipoInsercao;
        this.nomeTipoInsercao = nomeTipoInsercao;
    }

    public Integer getIdTipoInsercao() {
        return idTipoInsercao;
    }

    public void setIdTipoInsercao(Integer idTipoInsercao) {
        this.idTipoInsercao = idTipoInsercao;
    }

    public String getNomeTipoInsercao() {
        return nomeTipoInsercao;
    }

    public void setNomeTipoInsercao(String nomeTipoInsercao) {
        this.nomeTipoInsercao = nomeTipoInsercao;
    }

    public String getDescricaoTipoInsercao() {
        return descricaoTipoInsercao;
    }

    public void setDescricaoTipoInsercao(String descricaoTipoInsercao) {
        this.descricaoTipoInsercao = descricaoTipoInsercao;
    }

    @XmlTransient
    public Collection<Mqp> getMqpCollection() {
        return mqpCollection;
    }

    public void setMqpCollection(Collection<Mqp> mqpCollection) {
        this.mqpCollection = mqpCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInsercao != null ? idTipoInsercao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInsercao)) {
            return false;
        }
        TipoInsercao other = (TipoInsercao) object;
        if ((this.idTipoInsercao == null && other.idTipoInsercao != null) || (this.idTipoInsercao != null && !this.idTipoInsercao.equals(other.idTipoInsercao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.TipoInsercao[ idTipoInsercao=" + idTipoInsercao + " ]";
    }
    
}
