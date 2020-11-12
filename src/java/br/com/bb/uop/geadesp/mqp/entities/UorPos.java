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
@Table(name = "UorPos", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UorPos.findAll", query = "SELECT u FROM UorPos u")
    , @NamedQuery(name = "UorPos.findByMatricula", query = "SELECT u FROM UorPos u WHERE u.matricula = :matricula")
    , @NamedQuery(name = "UorPos.findByPrefixo", query = "SELECT u FROM UorPos u WHERE u.prefixo = :prefixo")
    , @NamedQuery(name = "UorPos.findByNome", query = "SELECT u FROM UorPos u WHERE u.nome = :nome")
    , @NamedQuery(name = "UorPos.findByUorPos", query = "SELECT u FROM UorPos u WHERE u.uorPos = :uorPos")
    , @NamedQuery(name = "UorPos.findByNomeUorPos", query = "SELECT u FROM UorPos u WHERE u.nomeUorPos = :nomeUorPos")
    , @NamedQuery(name = "UorPos.findByDataCaptura", query = "SELECT u FROM UorPos u WHERE u.dataCaptura = :dataCaptura")
    , @NamedQuery(name = "UorPos.findBySituacao", query = "SELECT u FROM UorPos u WHERE u.situacao = :situacao")})
public class UorPos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prefixo")
    private int prefixo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UorPos")
    private int uorPos;
    @Size(max = 200)
    @Column(name = "NomeUorPos")
    private String nomeUorPos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataCaptura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCaptura;
    @Column(name = "Situacao")
    private Integer situacao;
    @OneToMany(mappedBy = "matriculaEnvioManual")
    private Collection<Email> emailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Telefone> telefoneCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<Gdp> gdpCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<Treinamentos> treinamentosCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<TagEstacionamento> tagEstacionamentoCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<CartaoCorporativo> cartaoCorporativoCollection;
    @JoinColumn(name = "NivelAcesso", referencedColumnName = "idNivelAcesso")
    @ManyToOne(optional = false)
    private NivelAcesso nivelAcesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matrMqp")
    private Collection<MqpInit> mqpInitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matrSolicitante")
    private Collection<MqpInit> mqpInitCollection1;
    @OneToMany(mappedBy = "matricula")
    private Collection<Equipamentos> equipamentosCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<CartaoMultibeneficios> cartaoMultibeneficiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Mqp> mqpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaSolicitante")
    private Collection<Mqp> mqpCollection1;
    @OneToMany(mappedBy = "matricula")
    private Collection<Servicos> servicosCollection;
    @OneToMany(mappedBy = "matricula")
    private Collection<PrestacaoDeContas> prestacaoDeContasCollection;

    public UorPos() {
    }

    public UorPos(String matricula) {
        this.matricula = matricula;
    }

    public UorPos(String matricula, int prefixo, String nome, int uorPos, Date dataCaptura) {
        this.matricula = matricula;
        this.prefixo = prefixo;
        this.nome = nome;
        this.uorPos = uorPos;
        this.dataCaptura = dataCaptura;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(int prefixo) {
        this.prefixo = prefixo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUorPos() {
        return uorPos;
    }

    public void setUorPos(int uorPos) {
        this.uorPos = uorPos;
    }

    public String getNomeUorPos() {
        return nomeUorPos;
    }

    public void setNomeUorPos(String nomeUorPos) {
        this.nomeUorPos = nomeUorPos;
    }

    public Date getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(Date dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    @XmlTransient
    public Collection<Gdp> getGdpCollection() {
        return gdpCollection;
    }

    public void setGdpCollection(Collection<Gdp> gdpCollection) {
        this.gdpCollection = gdpCollection;
    }

    @XmlTransient
    public Collection<Treinamentos> getTreinamentosCollection() {
        return treinamentosCollection;
    }

    public void setTreinamentosCollection(Collection<Treinamentos> treinamentosCollection) {
        this.treinamentosCollection = treinamentosCollection;
    }

    @XmlTransient
    public Collection<TagEstacionamento> getTagEstacionamentoCollection() {
        return tagEstacionamentoCollection;
    }

    public void setTagEstacionamentoCollection(Collection<TagEstacionamento> tagEstacionamentoCollection) {
        this.tagEstacionamentoCollection = tagEstacionamentoCollection;
    }

    @XmlTransient
    public Collection<CartaoCorporativo> getCartaoCorporativoCollection() {
        return cartaoCorporativoCollection;
    }

    public void setCartaoCorporativoCollection(Collection<CartaoCorporativo> cartaoCorporativoCollection) {
        this.cartaoCorporativoCollection = cartaoCorporativoCollection;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @XmlTransient
    public Collection<MqpInit> getMqpInitCollection() {
        return mqpInitCollection;
    }

    public void setMqpInitCollection(Collection<MqpInit> mqpInitCollection) {
        this.mqpInitCollection = mqpInitCollection;
    }

    @XmlTransient
    public Collection<MqpInit> getMqpInitCollection1() {
        return mqpInitCollection1;
    }

    public void setMqpInitCollection1(Collection<MqpInit> mqpInitCollection1) {
        this.mqpInitCollection1 = mqpInitCollection1;
    }

    @XmlTransient
    public Collection<Equipamentos> getEquipamentosCollection() {
        return equipamentosCollection;
    }

    public void setEquipamentosCollection(Collection<Equipamentos> equipamentosCollection) {
        this.equipamentosCollection = equipamentosCollection;
    }

    @XmlTransient
    public Collection<CartaoMultibeneficios> getCartaoMultibeneficiosCollection() {
        return cartaoMultibeneficiosCollection;
    }

    public void setCartaoMultibeneficiosCollection(Collection<CartaoMultibeneficios> cartaoMultibeneficiosCollection) {
        this.cartaoMultibeneficiosCollection = cartaoMultibeneficiosCollection;
    }

    @XmlTransient
    public Collection<Mqp> getMqpCollection() {
        return mqpCollection;
    }

    public void setMqpCollection(Collection<Mqp> mqpCollection) {
        this.mqpCollection = mqpCollection;
    }

    @XmlTransient
    public Collection<Mqp> getMqpCollection1() {
        return mqpCollection1;
    }

    public void setMqpCollection1(Collection<Mqp> mqpCollection1) {
        this.mqpCollection1 = mqpCollection1;
    }

    @XmlTransient
    public Collection<Servicos> getServicosCollection() {
        return servicosCollection;
    }

    public void setServicosCollection(Collection<Servicos> servicosCollection) {
        this.servicosCollection = servicosCollection;
    }

    @XmlTransient
    public Collection<PrestacaoDeContas> getPrestacaoDeContasCollection() {
        return prestacaoDeContasCollection;
    }

    public void setPrestacaoDeContasCollection(Collection<PrestacaoDeContas> prestacaoDeContasCollection) {
        this.prestacaoDeContasCollection = prestacaoDeContasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UorPos)) {
            return false;
        }
        UorPos other = (UorPos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.UorPos[ matricula=" + matricula + " ]";
    }
    
}
