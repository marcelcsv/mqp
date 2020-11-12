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
@Table(name = "GDP", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gdp.findAll", query = "SELECT g FROM Gdp g")
    , @NamedQuery(name = "Gdp.findByIdGDP", query = "SELECT g FROM Gdp g WHERE g.idGDP = :idGDP")
    , @NamedQuery(name = "Gdp.findByNomeGDP", query = "SELECT g FROM Gdp g WHERE g.nomeGDP = :nomeGDP")
    , @NamedQuery(name = "Gdp.findByDescricaoGDP", query = "SELECT g FROM Gdp g WHERE g.descricaoGDP = :descricaoGDP")})
public class Gdp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGDP")
    private Integer idGDP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomeGDP")
    private String nomeGDP;
    @Size(max = 1000)
    @Column(name = "DescricaoGDP")
    private String descricaoGDP;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdp")
    private Collection<NumRefMQP> numRefMQPCollection;

    public Gdp() {
    }

    public Gdp(Integer idGDP) {
        this.idGDP = idGDP;
    }

    public Gdp(Integer idGDP, String nomeGDP) {
        this.idGDP = idGDP;
        this.nomeGDP = nomeGDP;
    }

    public Integer getIdGDP() {
        return idGDP;
    }

    public void setIdGDP(Integer idGDP) {
        this.idGDP = idGDP;
    }

    public String getNomeGDP() {
        return nomeGDP;
    }

    public void setNomeGDP(String nomeGDP) {
        this.nomeGDP = nomeGDP;
    }

    public String getDescricaoGDP() {
        return descricaoGDP;
    }

    public void setDescricaoGDP(String descricaoGDP) {
        this.descricaoGDP = descricaoGDP;
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

    @XmlTransient
    public Collection<NumRefMQP> getNumRefMQPCollection() {
        return numRefMQPCollection;
    }

    public void setNumRefMQPCollection(Collection<NumRefMQP> numRefMQPCollection) {
        this.numRefMQPCollection = numRefMQPCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGDP != null ? idGDP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gdp)) {
            return false;
        }
        Gdp other = (Gdp) object;
        if ((this.idGDP == null && other.idGDP != null) || (this.idGDP != null && !this.idGDP.equals(other.idGDP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Gdp[ idGDP=" + idGDP + " ]";
    }
    
}
