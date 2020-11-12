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
@Table(name = "PrestacaoDeContas", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestacaoDeContas.findAll", query = "SELECT p FROM PrestacaoDeContas p")
    , @NamedQuery(name = "PrestacaoDeContas.findByIdPrestacaoDeContas", query = "SELECT p FROM PrestacaoDeContas p WHERE p.idPrestacaoDeContas = :idPrestacaoDeContas")
    , @NamedQuery(name = "PrestacaoDeContas.findByNomePrestacaoDeContas", query = "SELECT p FROM PrestacaoDeContas p WHERE p.nomePrestacaoDeContas = :nomePrestacaoDeContas")
    , @NamedQuery(name = "PrestacaoDeContas.findByDescricaoPrestacaoDeContas", query = "SELECT p FROM PrestacaoDeContas p WHERE p.descricaoPrestacaoDeContas = :descricaoPrestacaoDeContas")})
public class PrestacaoDeContas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestacaoDeContas")
    private Integer idPrestacaoDeContas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomePrestacaoDeContas")
    private String nomePrestacaoDeContas;
    @Size(max = 1000)
    @Column(name = "DescricaoPrestacaoDeContas")
    private String descricaoPrestacaoDeContas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestacaoDeContas")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public PrestacaoDeContas() {
    }

    public PrestacaoDeContas(Integer idPrestacaoDeContas) {
        this.idPrestacaoDeContas = idPrestacaoDeContas;
    }

    public PrestacaoDeContas(Integer idPrestacaoDeContas, String nomePrestacaoDeContas) {
        this.idPrestacaoDeContas = idPrestacaoDeContas;
        this.nomePrestacaoDeContas = nomePrestacaoDeContas;
    }

    public Integer getIdPrestacaoDeContas() {
        return idPrestacaoDeContas;
    }

    public void setIdPrestacaoDeContas(Integer idPrestacaoDeContas) {
        this.idPrestacaoDeContas = idPrestacaoDeContas;
    }

    public String getNomePrestacaoDeContas() {
        return nomePrestacaoDeContas;
    }

    public void setNomePrestacaoDeContas(String nomePrestacaoDeContas) {
        this.nomePrestacaoDeContas = nomePrestacaoDeContas;
    }

    public String getDescricaoPrestacaoDeContas() {
        return descricaoPrestacaoDeContas;
    }

    public void setDescricaoPrestacaoDeContas(String descricaoPrestacaoDeContas) {
        this.descricaoPrestacaoDeContas = descricaoPrestacaoDeContas;
    }

    @XmlTransient
    public Collection<NumRefMQP> getNumRefMQPCollection() {
        return numRefMQPCollection;
    }

    public void setNumRefMQPCollection(Collection<NumRefMQP> numRefMQPCollection) {
        this.numRefMQPCollection = numRefMQPCollection;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UorPos getMatricula() {
        return matricula;
    }

    public void setMatricula(UorPos matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestacaoDeContas != null ? idPrestacaoDeContas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestacaoDeContas)) {
            return false;
        }
        PrestacaoDeContas other = (PrestacaoDeContas) object;
        if ((this.idPrestacaoDeContas == null && other.idPrestacaoDeContas != null) || (this.idPrestacaoDeContas != null && !this.idPrestacaoDeContas.equals(other.idPrestacaoDeContas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas[ idPrestacaoDeContas=" + idPrestacaoDeContas + " ]";
    }
    
}
