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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "TagEstacionamento", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagEstacionamento.findAll", query = "SELECT t FROM TagEstacionamento t")
    , @NamedQuery(name = "TagEstacionamento.findByTag", query = "SELECT t FROM TagEstacionamento t WHERE t.tag = :tag")
    , @NamedQuery(name = "TagEstacionamento.findByNome", query = "SELECT t FROM TagEstacionamento t WHERE t.nome = :nome")
    , @NamedQuery(name = "TagEstacionamento.findByCpf", query = "SELECT t FROM TagEstacionamento t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TagEstacionamento.findByVeiculo", query = "SELECT t FROM TagEstacionamento t WHERE t.veiculo = :veiculo")
    , @NamedQuery(name = "TagEstacionamento.findByPlaca", query = "SELECT t FROM TagEstacionamento t WHERE t.placa = :placa")})
public class TagEstacionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tag")
    private Integer tag;
    @Size(max = 100)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 14)
    @Column(name = "CPF")
    private String cpf;
    @Size(max = 100)
    @Column(name = "Veiculo")
    private String veiculo;
    @Size(max = 20)
    @Column(name = "Placa")
    private String placa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tagEstacionamento")
    private Collection<NumRefMQP> numRefMQPCollection;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;

    public TagEstacionamento() {
    }

    public TagEstacionamento(Integer tag) {
        this.tag = tag;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        hash += (tag != null ? tag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagEstacionamento)) {
            return false;
        }
        TagEstacionamento other = (TagEstacionamento) object;
        if ((this.tag == null && other.tag != null) || (this.tag != null && !this.tag.equals(other.tag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento[ tag=" + tag + " ]";
    }
    
}
