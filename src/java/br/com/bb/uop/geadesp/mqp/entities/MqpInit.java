/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "mqp_init", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MqpInit.findAll", query = "SELECT m FROM MqpInit m")
    , @NamedQuery(name = "MqpInit.findByIdMQPinit", query = "SELECT m FROM MqpInit m WHERE m.idMQPinit = :idMQPinit")
    , @NamedQuery(name = "MqpInit.findByDtref", query = "SELECT m FROM MqpInit m WHERE m.dtref = :dtref")})
public class MqpInit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMQPinit")
    private Integer idMQPinit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtref")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtref;
    @JoinColumn(name = "movimentacao", referencedColumnName = "idMovimentacao")
    @ManyToOne(optional = false)
    private Movimentacao movimentacao;
    @JoinColumn(name = "status", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "matr_mqp", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private UorPos matrMqp;
    @JoinColumn(name = "matr_solicitante", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private UorPos matrSolicitante;

    public MqpInit() {
    }

    public MqpInit(Integer idMQPinit) {
        this.idMQPinit = idMQPinit;
    }

    public MqpInit(Integer idMQPinit, Date dtref) {
        this.idMQPinit = idMQPinit;
        this.dtref = dtref;
    }

    public Integer getIdMQPinit() {
        return idMQPinit;
    }

    public void setIdMQPinit(Integer idMQPinit) {
        this.idMQPinit = idMQPinit;
    }

    public Date getDtref() {
        return dtref;
    }

    public void setDtref(Date dtref) {
        this.dtref = dtref;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UorPos getMatrMqp() {
        return matrMqp;
    }

    public void setMatrMqp(UorPos matrMqp) {
        this.matrMqp = matrMqp;
    }

    public UorPos getMatrSolicitante() {
        return matrSolicitante;
    }

    public void setMatrSolicitante(UorPos matrSolicitante) {
        this.matrSolicitante = matrSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMQPinit != null ? idMQPinit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MqpInit)) {
            return false;
        }
        MqpInit other = (MqpInit) object;
        if ((this.idMQPinit == null && other.idMQPinit != null) || (this.idMQPinit != null && !this.idMQPinit.equals(other.idMQPinit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.MqpInit[ idMQPinit=" + idMQPinit + " ]";
    }
    
}
