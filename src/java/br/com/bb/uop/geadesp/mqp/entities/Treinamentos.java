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
@Table(name = "Treinamentos", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinamentos.findAll", query = "SELECT t FROM Treinamentos t")
    , @NamedQuery(name = "Treinamentos.findByIdTreinamento", query = "SELECT t FROM Treinamentos t WHERE t.idTreinamento = :idTreinamento")
    , @NamedQuery(name = "Treinamentos.findByNomeTreinamento", query = "SELECT t FROM Treinamentos t WHERE t.nomeTreinamento = :nomeTreinamento")})
public class Treinamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTreinamento")
    private Integer idTreinamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeTreinamento")
    private String nomeTreinamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treinamentos")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public Treinamentos() {
    }

    public Treinamentos(Integer idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public Treinamentos(Integer idTreinamento, String nomeTreinamento) {
        this.idTreinamento = idTreinamento;
        this.nomeTreinamento = nomeTreinamento;
    }

    public Integer getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(Integer idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public String getNomeTreinamento() {
        return nomeTreinamento;
    }

    public void setNomeTreinamento(String nomeTreinamento) {
        this.nomeTreinamento = nomeTreinamento;
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
        hash += (idTreinamento != null ? idTreinamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treinamentos)) {
            return false;
        }
        Treinamentos other = (Treinamentos) object;
        if ((this.idTreinamento == null && other.idTreinamento != null) || (this.idTreinamento != null && !this.idTreinamento.equals(other.idTreinamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Treinamentos[ idTreinamento=" + idTreinamento + " ]";
    }
    
}
