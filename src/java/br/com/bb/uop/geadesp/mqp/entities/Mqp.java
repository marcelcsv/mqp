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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "MQP", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mqp.findAll", query = "SELECT m FROM Mqp m")
    , @NamedQuery(name = "Mqp.findById", query = "SELECT m FROM Mqp m WHERE m.id = :id")
    , @NamedQuery(name = "Mqp.findByDataHoraRegistro", query = "SELECT m FROM Mqp m WHERE m.dataHoraRegistro = :dataHoraRegistro")
    , @NamedQuery(name = "Mqp.findByLinhaTelefonica", query = "SELECT m FROM Mqp m WHERE m.linhaTelefonica = :linhaTelefonica")
    , @NamedQuery(name = "Mqp.findByEquipamentos", query = "SELECT m FROM Mqp m WHERE m.equipamentos = :equipamentos")
    , @NamedQuery(name = "Mqp.findByServicos", query = "SELECT m FROM Mqp m WHERE m.servicos = :servicos")
    , @NamedQuery(name = "Mqp.findByTagEstacionamento", query = "SELECT m FROM Mqp m WHERE m.tagEstacionamento = :tagEstacionamento")
    , @NamedQuery(name = "Mqp.findByCartaoCorporativo", query = "SELECT m FROM Mqp m WHERE m.cartaoCorporativo = :cartaoCorporativo")
    , @NamedQuery(name = "Mqp.findByGdp", query = "SELECT m FROM Mqp m WHERE m.gdp = :gdp")
    , @NamedQuery(name = "Mqp.findByTreinamento", query = "SELECT m FROM Mqp m WHERE m.treinamento = :treinamento")
    , @NamedQuery(name = "Mqp.findByPrestacaoDeContas", query = "SELECT m FROM Mqp m WHERE m.prestacaoDeContas = :prestacaoDeContas")
    , @NamedQuery(name = "Mqp.findByCartaoMultibeneficios", query = "SELECT m FROM Mqp m WHERE m.cartaoMultibeneficios = :cartaoMultibeneficios")})
public class Mqp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataHoraRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraRegistro;
    @Size(max = 2000)
    @Column(name = "LinhaTelefonica")
    private String linhaTelefonica;
    @Size(max = 2000)
    @Column(name = "Equipamentos")
    private String equipamentos;
    @Size(max = 2000)
    @Column(name = "Servicos")
    private String servicos;
    @Size(max = 2000)
    @Column(name = "TagEstacionamento")
    private String tagEstacionamento;
    @Size(max = 2000)
    @Column(name = "CartaoCorporativo")
    private String cartaoCorporativo;
    @Size(max = 2000)
    @Column(name = "GDP")
    private String gdp;
    @Size(max = 2000)
    @Column(name = "Treinamento")
    private String treinamento;
    @Size(max = 2000)
    @Column(name = "PrestacaoDeContas")
    private String prestacaoDeContas;
    @Size(max = 2000)
    @Column(name = "CartaoMultibeneficios")
    private String cartaoMultibeneficios;
    @OneToMany(mappedBy = "movimentacao", cascade = CascadeType.PERSIST)
    private Collection<Email> emailCollection;
    @JoinColumn(name = "Movimentacao", referencedColumnName = "idMovimentacao")
    @ManyToOne(optional = false)
    private Movimentacao movimentacao;
    @JoinColumn(name = "Prefixo", referencedColumnName = "Prefixo")
    @ManyToOne(optional = false)
    private Prefixos prefixo;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "Insercao", referencedColumnName = "idTipoInsercao")
    @ManyToOne(optional = false)
    private TipoInsercao insercao;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private UorPos matricula;
    @JoinColumn(name = "MatriculaSolicitante", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private UorPos matriculaSolicitante;

    public Mqp() {
    }

    public Mqp(Integer id) {
        this.id = id;
    }

    public Mqp(Integer id, Date dataHoraRegistro) {
        this.id = id;
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(Date dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public String getLinhaTelefonica() {
        return linhaTelefonica;
    }

    public void setLinhaTelefonica(String linhaTelefonica) {
        this.linhaTelefonica = linhaTelefonica;
    }

    public String getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(String equipamentos) {
        this.equipamentos = equipamentos;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getTagEstacionamento() {
        return tagEstacionamento;
    }

    public void setTagEstacionamento(String tagEstacionamento) {
        this.tagEstacionamento = tagEstacionamento;
    }

    public String getCartaoCorporativo() {
        return cartaoCorporativo;
    }

    public void setCartaoCorporativo(String cartaoCorporativo) {
        this.cartaoCorporativo = cartaoCorporativo;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

    public String getPrestacaoDeContas() {
        return prestacaoDeContas;
    }

    public void setPrestacaoDeContas(String prestacaoDeContas) {
        this.prestacaoDeContas = prestacaoDeContas;
    }

    public String getCartaoMultibeneficios() {
        return cartaoMultibeneficios;
    }

    public void setCartaoMultibeneficios(String cartaoMultibeneficios) {
        this.cartaoMultibeneficios = cartaoMultibeneficios;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Prefixos getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Prefixos prefixo) {
        this.prefixo = prefixo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoInsercao getInsercao() {
        return insercao;
    }

    public void setInsercao(TipoInsercao insercao) {
        this.insercao = insercao;
    }

    public UorPos getMatricula() {
        return matricula;
    }

    public void setMatricula(UorPos matricula) {
        this.matricula = matricula;
    }

    public UorPos getMatriculaSolicitante() {
        return matriculaSolicitante;
    }

    public void setMatriculaSolicitante(UorPos matriculaSolicitante) {
        this.matriculaSolicitante = matriculaSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mqp)) {
            return false;
        }
        Mqp other = (Mqp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Mqp[ id=" + id + " ]";
    }

}
