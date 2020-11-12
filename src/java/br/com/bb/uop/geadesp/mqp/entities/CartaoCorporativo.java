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
@Table(name = "CartaoCorporativo", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoCorporativo.findAll", query = "SELECT c FROM CartaoCorporativo c")
    , @NamedQuery(name = "CartaoCorporativo.findByIdCartaoCorporativo", query = "SELECT c FROM CartaoCorporativo c WHERE c.idCartaoCorporativo = :idCartaoCorporativo")
    , @NamedQuery(name = "CartaoCorporativo.findByContaCartao", query = "SELECT c FROM CartaoCorporativo c WHERE c.contaCartao = :contaCartao")
    , @NamedQuery(name = "CartaoCorporativo.findByPlastico", query = "SELECT c FROM CartaoCorporativo c WHERE c.plastico = :plastico")
    , @NamedQuery(name = "CartaoCorporativo.findByBandeira", query = "SELECT c FROM CartaoCorporativo c WHERE c.bandeira = :bandeira")
    , @NamedQuery(name = "CartaoCorporativo.findByValidade", query = "SELECT c FROM CartaoCorporativo c WHERE c.validade = :validade")})
public class CartaoCorporativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCartaoCorporativo")
    private Integer idCartaoCorporativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContaCartao")
    private int contaCartao;
    @Size(max = 20)
    @Column(name = "Plastico")
    private String plastico;
    @Size(max = 20)
    @Column(name = "Bandeira")
    private String bandeira;
    @Size(max = 10)
    @Column(name = "Validade")
    private String validade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartaoCorporativo")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public CartaoCorporativo() {
    }

    public CartaoCorporativo(Integer idCartaoCorporativo) {
        this.idCartaoCorporativo = idCartaoCorporativo;
    }

    public CartaoCorporativo(Integer idCartaoCorporativo, int contaCartao) {
        this.idCartaoCorporativo = idCartaoCorporativo;
        this.contaCartao = contaCartao;
    }

    public Integer getIdCartaoCorporativo() {
        return idCartaoCorporativo;
    }

    public void setIdCartaoCorporativo(Integer idCartaoCorporativo) {
        this.idCartaoCorporativo = idCartaoCorporativo;
    }

    public int getContaCartao() {
        return contaCartao;
    }

    public void setContaCartao(int contaCartao) {
        this.contaCartao = contaCartao;
    }

    public String getPlastico() {
        return plastico;
    }

    public void setPlastico(String plastico) {
        this.plastico = plastico;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
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
        hash += (idCartaoCorporativo != null ? idCartaoCorporativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaoCorporativo)) {
            return false;
        }
        CartaoCorporativo other = (CartaoCorporativo) object;
        if ((this.idCartaoCorporativo == null && other.idCartaoCorporativo != null) || (this.idCartaoCorporativo != null && !this.idCartaoCorporativo.equals(other.idCartaoCorporativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo[ idCartaoCorporativo=" + idCartaoCorporativo + " ]";
    }
    
}
