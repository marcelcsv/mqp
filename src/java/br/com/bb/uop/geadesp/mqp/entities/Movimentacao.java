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
@Table(name = "Movimentacao", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m")
    , @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao")
    , @NamedQuery(name = "Movimentacao.findByNomeMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.nomeMovimentacao = :nomeMovimentacao")
    , @NamedQuery(name = "Movimentacao.findByDescricaoMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.descricaoMovimentacao = :descricaoMovimentacao")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimentacao")
    private Integer idMovimentacao;
    @Size(max = 100)
    @Column(name = "NomeMovimentacao")
    private String nomeMovimentacao;
    @Size(max = 1000)
    @Column(name = "DescricaoMovimentacao")
    private String descricaoMovimentacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimentacao")
    private Collection<MqpInit> mqpInitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimentacao")
    private Collection<Mqp> mqpCollection;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getNomeMovimentacao() {
        return nomeMovimentacao;
    }

    public void setNomeMovimentacao(String nomeMovimentacao) {
        this.nomeMovimentacao = nomeMovimentacao;
    }

    public String getDescricaoMovimentacao() {
        return descricaoMovimentacao;
    }

    public void setDescricaoMovimentacao(String descricaoMovimentacao) {
        this.descricaoMovimentacao = descricaoMovimentacao;
    }

    @XmlTransient
    public Collection<MqpInit> getMqpInitCollection() {
        return mqpInitCollection;
    }

    public void setMqpInitCollection(Collection<MqpInit> mqpInitCollection) {
        this.mqpInitCollection = mqpInitCollection;
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
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }
    
}
