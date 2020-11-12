/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "Email", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
    , @NamedQuery(name = "Email.findByIdEmail", query = "SELECT e FROM Email e WHERE e.idEmail = :idEmail")
    , @NamedQuery(name = "Email.findByDestino", query = "SELECT e FROM Email e WHERE e.destino = :destino")
    , @NamedQuery(name = "Email.findByCc", query = "SELECT e FROM Email e WHERE e.cc = :cc")
    , @NamedQuery(name = "Email.findByCo", query = "SELECT e FROM Email e WHERE e.co = :co")
    , @NamedQuery(name = "Email.findByAssunto", query = "SELECT e FROM Email e WHERE e.assunto = :assunto")
    , @NamedQuery(name = "Email.findByMensagem", query = "SELECT e FROM Email e WHERE e.mensagem = :mensagem")
    , @NamedQuery(name = "Email.findByDataEnvio", query = "SELECT e FROM Email e WHERE e.dataEnvio = :dataEnvio")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmail")
    private Integer idEmail;
    @Size(max = 1000)
    @Column(name = "Destino")
    private String destino;
    @Size(max = 1000)
    @Column(name = "cc")
    private String cc;
    @Size(max = 1000)
    @Column(name = "co")
    private String co;
    @Size(max = 1000)
    @Column(name = "Assunto")
    private String assunto;
    @Size(max = 8000)
    @Column(name = "Mensagem")
    private String mensagem;
    @Column(name = "DataEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvio;
    @JoinColumn(name = "Movimentacao", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Mqp movimentacao;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "MatriculaEnvioManual", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matriculaEnvioManual;

    public Email() {
    }

    public Email(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Mqp getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Mqp movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UorPos getMatriculaEnvioManual() {
        return matriculaEnvioManual;
    }

    public void setMatriculaEnvioManual(UorPos matriculaEnvioManual) {
        this.matriculaEnvioManual = matriculaEnvioManual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmail != null ? idEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.idEmail == null && other.idEmail != null) || (this.idEmail != null && !this.idEmail.equals(other.idEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Email[ idEmail=" + idEmail + " ]";
    }
    
}
