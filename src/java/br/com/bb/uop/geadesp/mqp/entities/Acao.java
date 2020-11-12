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
@Table(name = "Acao", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a")
    , @NamedQuery(name = "Acao.findByIdAcao", query = "SELECT a FROM Acao a WHERE a.idAcao = :idAcao")
    , @NamedQuery(name = "Acao.findByNomeAcao", query = "SELECT a FROM Acao a WHERE a.nomeAcao = :nomeAcao")
    , @NamedQuery(name = "Acao.findByDescricaoAcao", query = "SELECT a FROM Acao a WHERE a.descricaoAcao = :descricaoAcao")})
public class Acao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAcao")
    private Integer idAcao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeAcao")
    private String nomeAcao;
    @Size(max = 1000)
    @Column(name = "DescricaoAcao")
    private String descricaoAcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acao")
    private Collection<Telefone> telefoneCollection;

    public Acao() {
    }

    public Acao(Integer idAcao) {
        this.idAcao = idAcao;
    }

    public Acao(Integer idAcao, String nomeAcao) {
        this.idAcao = idAcao;
        this.nomeAcao = nomeAcao;
    }

    public Integer getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(Integer idAcao) {
        this.idAcao = idAcao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
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
        hash += (idAcao != null ? idAcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.idAcao == null && other.idAcao != null) || (this.idAcao != null && !this.idAcao.equals(other.idAcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Acao[ idAcao=" + idAcao + " ]";
    }
    
}
