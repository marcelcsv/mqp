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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "Telefone", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")
    , @NamedQuery(name = "Telefone.findByTelefone", query = "SELECT t FROM Telefone t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "Telefone.findByDdd", query = "SELECT t FROM Telefone t WHERE t.ddd = :ddd")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefone")
    private Integer telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DDD")
    private int ddd;
    @JoinColumn(name = "Acao", referencedColumnName = "idAcao")
    @ManyToOne(optional = false)
    private Acao acao;
    @JoinColumn(name = "Dispositivo", referencedColumnName = "idDispositivoMovel")
    @ManyToOne(optional = false)
    private DispositivoMovel dispositivo;
    @JoinColumn(name = "Operadora", referencedColumnName = "idOperadora")
    @ManyToOne
    private OperadoraTelefone operadora;
    @JoinColumn(name = "Situacao", referencedColumnName = "idSituacao")
    @ManyToOne(optional = false)
    private Situacao situacao;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "TipoLinha", referencedColumnName = "idTipoLinha")
    @ManyToOne(optional = false)
    private TipoLinha tipoLinha;
    @JoinColumn(name = "MovimentoPendente", referencedColumnName = "idTipoMovimentoPendente")
    @ManyToOne(optional = false)
    private TipoMovimentoPendente movimentoPendente;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private UorPos matricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefone")
    private Collection<NumRefMQP> numRefMQPCollection;

    public Telefone() {
    }

    public Telefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Telefone(Integer telefone, int ddd) {
        this.telefone = telefone;
        this.ddd = ddd;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public DispositivoMovel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoMovel dispositivo) {
        this.dispositivo = dispositivo;
    }

    public OperadoraTelefone getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraTelefone operadora) {
        this.operadora = operadora;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoLinha getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(TipoLinha tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public TipoMovimentoPendente getMovimentoPendente() {
        return movimentoPendente;
    }

    public void setMovimentoPendente(TipoMovimentoPendente movimentoPendente) {
        this.movimentoPendente = movimentoPendente;
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
        hash += (telefone != null ? telefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Telefone[ telefone=" + telefone + " ]";
    }
    
}
