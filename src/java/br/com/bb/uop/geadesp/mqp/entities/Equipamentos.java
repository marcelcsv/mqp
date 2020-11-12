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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "Equipamentos", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamentos.findAll", query = "SELECT e FROM Equipamentos e")
    , @NamedQuery(name = "Equipamentos.findByIdEquipamentos", query = "SELECT e FROM Equipamentos e WHERE e.idEquipamentos = :idEquipamentos")
    , @NamedQuery(name = "Equipamentos.findByNomeEquipamento", query = "SELECT e FROM Equipamentos e WHERE e.nomeEquipamento = :nomeEquipamento")
    , @NamedQuery(name = "Equipamentos.findByDescricaoEquipamento", query = "SELECT e FROM Equipamentos e WHERE e.descricaoEquipamento = :descricaoEquipamento")})
public class Equipamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipamentos")
    private Integer idEquipamentos;
    @Size(max = 100)
    @Column(name = "NomeEquipamento")
    private String nomeEquipamento;
    @Size(max = 1000)
    @Column(name = "DescricaoEquipamento")
    private String descricaoEquipamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipamentos")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public Equipamentos() {
    }

    public Equipamentos(Integer idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public Integer getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(Integer idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
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
        hash += (idEquipamentos != null ? idEquipamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamentos)) {
            return false;
        }
        Equipamentos other = (Equipamentos) object;
        if ((this.idEquipamentos == null && other.idEquipamentos != null) || (this.idEquipamentos != null && !this.idEquipamentos.equals(other.idEquipamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Equipamentos[ idEquipamentos=" + idEquipamentos + " ]";
    }
    
}
