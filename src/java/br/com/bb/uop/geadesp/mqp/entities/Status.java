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
@Table(name = "Status", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByIdStatus", query = "SELECT s FROM Status s WHERE s.idStatus = :idStatus")
    , @NamedQuery(name = "Status.findByStatus", query = "SELECT s FROM Status s WHERE s.status = :status")
    , @NamedQuery(name = "Status.findByDescricaoStatus", query = "SELECT s FROM Status s WHERE s.descricaoStatus = :descricaoStatus")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStatus")
    private Integer idStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Status")
    private String status;
    @Size(max = 1000)
    @Column(name = "DescricaoStatus")
    private String descricaoStatus;
    @OneToMany(mappedBy = "status")
    private Collection<Email> emailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Telefone> telefoneCollection;
    @OneToMany(mappedBy = "status")
    private Collection<Gdp> gdpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Treinamentos> treinamentosCollection;
    @OneToMany(mappedBy = "status")
    private Collection<TagEstacionamento> tagEstacionamentoCollection;
    @OneToMany(mappedBy = "status")
    private Collection<CartaoCorporativo> cartaoCorporativoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<MqpInit> mqpInitCollection;
    @OneToMany(mappedBy = "status")
    private Collection<Equipamentos> equipamentosCollection;
    @OneToMany(mappedBy = "status")
    private Collection<CartaoMultibeneficios> cartaoMultibeneficiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Mqp> mqpCollection;
    @OneToMany(mappedBy = "status")
    private Collection<Servicos> servicosCollection;
    @OneToMany(mappedBy = "status")
    private Collection<PrestacaoDeContas> prestacaoDeContasCollection;

    public Status() {
    }

    public Status(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Status(Integer idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
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

    @XmlTransient
    public Collection<MqpInit> getMqpInitCollection() {
        return mqpInitCollection;
    }

    public void setMqpInitCollection(Collection<MqpInit> mqpInitCollection) {
        this.mqpInitCollection = mqpInitCollection;
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
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.Status[ idStatus=" + idStatus + " ]";
    }
    
}
