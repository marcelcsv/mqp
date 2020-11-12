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
@Table(name = "Servicos", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicos.findAll", query = "SELECT s FROM Servicos s")
    , @NamedQuery(name = "Servicos.findByIdServico", query = "SELECT s FROM Servicos s WHERE s.idServico = :idServico")
    , @NamedQuery(name = "Servicos.findByNomeServico", query = "SELECT s FROM Servicos s WHERE s.nomeServico = :nomeServico")
    , @NamedQuery(name = "Servicos.findByDescricaoServico", query = "SELECT s FROM Servicos s WHERE s.descricaoServico = :descricaoServico")})
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServico")
    private Integer idServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeServico")
    private String nomeServico;
    @Size(max = 1000)
    @Column(name = "DescricaoServico")
    private String descricaoServico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicos")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public Servicos() {
    }

    public Servicos(Integer idServico) {
        this.idServico = idServico;
    }

    public Servicos(Integer idServico, String nomeServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
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
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicos)) {
            return false;
        }
        Servicos other = (Servicos) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Servicos[ idServico=" + idServico + " ]";
    }
    
}
