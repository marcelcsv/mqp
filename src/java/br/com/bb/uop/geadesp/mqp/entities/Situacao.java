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
@Table(name = "Situacao", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s")
    , @NamedQuery(name = "Situacao.findByIdSituacao", query = "SELECT s FROM Situacao s WHERE s.idSituacao = :idSituacao")
    , @NamedQuery(name = "Situacao.findByNomeSituacao", query = "SELECT s FROM Situacao s WHERE s.nomeSituacao = :nomeSituacao")
    , @NamedQuery(name = "Situacao.findByDescricaoSituacao", query = "SELECT s FROM Situacao s WHERE s.descricaoSituacao = :descricaoSituacao")})
public class Situacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSituacao")
    private Integer idSituacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeSituacao")
    private String nomeSituacao;
    @Size(max = 1000)
    @Column(name = "DescricaoSituacao")
    private String descricaoSituacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacao")
    private Collection<Telefone> telefoneCollection;

    public Situacao() {
    }

    public Situacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Situacao(Integer idSituacao, String nomeSituacao) {
        this.idSituacao = idSituacao;
        this.nomeSituacao = nomeSituacao;
    }

    public Integer getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public String getNomeSituacao() {
        return nomeSituacao;
    }

    public void setNomeSituacao(String nomeSituacao) {
        this.nomeSituacao = nomeSituacao;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    public void setDescricaoSituacao(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
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
        hash += (idSituacao != null ? idSituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idSituacao == null && other.idSituacao != null) || (this.idSituacao != null && !this.idSituacao.equals(other.idSituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Situacao[ idSituacao=" + idSituacao + " ]";
    }
    
}
