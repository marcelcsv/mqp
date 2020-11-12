/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "CartaoMultibeneficios", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoMultibeneficios.findAll", query = "SELECT c FROM CartaoMultibeneficios c")
    , @NamedQuery(name = "CartaoMultibeneficios.findByIdCartaoMultibeneficios", query = "SELECT c FROM CartaoMultibeneficios c WHERE c.idCartaoMultibeneficios = :idCartaoMultibeneficios")
    , @NamedQuery(name = "CartaoMultibeneficios.findByDataDeAdesao", query = "SELECT c FROM CartaoMultibeneficios c WHERE c.dataDeAdesao = :dataDeAdesao")})
public class CartaoMultibeneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCartaoMultibeneficios")
    private Integer idCartaoMultibeneficios;
    @Column(name = "DataDeAdesao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeAdesao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartaoMultibeneficios")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public CartaoMultibeneficios() {
    }

    public CartaoMultibeneficios(Integer idCartaoMultibeneficios) {
        this.idCartaoMultibeneficios = idCartaoMultibeneficios;
    }

    public Integer getIdCartaoMultibeneficios() {
        return idCartaoMultibeneficios;
    }

    public void setIdCartaoMultibeneficios(Integer idCartaoMultibeneficios) {
        this.idCartaoMultibeneficios = idCartaoMultibeneficios;
    }

    public Date getDataDeAdesao() {
        return dataDeAdesao;
    }

    public void setDataDeAdesao(Date dataDeAdesao) {
        this.dataDeAdesao = dataDeAdesao;
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
        hash += (idCartaoMultibeneficios != null ? idCartaoMultibeneficios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaoMultibeneficios)) {
            return false;
        }
        CartaoMultibeneficios other = (CartaoMultibeneficios) object;
        if ((this.idCartaoMultibeneficios == null && other.idCartaoMultibeneficios != null) || (this.idCartaoMultibeneficios != null && !this.idCartaoMultibeneficios.equals(other.idCartaoMultibeneficios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios[ idCartaoMultibeneficios=" + idCartaoMultibeneficios + " ]";
    }
    
}
