/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Entity
@Table(name = "NumRef_MQP", catalog = "DIAGE", schema = "mqp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumRefMQP.findAll", query = "SELECT n FROM NumRefMQP n")
    , @NamedQuery(name = "NumRefMQP.findByNumRef", query = "SELECT n FROM NumRefMQP n WHERE n.numRefMQPPK.numRef = :numRef")
    , @NamedQuery(name = "NumRefMQP.findByIdMQP", query = "SELECT n FROM NumRefMQP n WHERE n.numRefMQPPK.idMQP = :idMQP")})
public class NumRefMQP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumRefMQPPK numRefMQPPK;
    @JoinColumn(name = "NumRef", referencedColumnName = "idCartaoCorporativo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CartaoCorporativo cartaoCorporativo;
    @JoinColumn(name = "NumRef", referencedColumnName = "idCartaoMultibeneficios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CartaoMultibeneficios cartaoMultibeneficios;
    @JoinColumn(name = "Categoria", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categorias categoria;
    @JoinColumn(name = "NumRef", referencedColumnName = "idEquipamentos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipamentos equipamentos;
    @JoinColumn(name = "NumRef", referencedColumnName = "idGDP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gdp gdp;
    @JoinColumn(name = "NumRef", referencedColumnName = "idPrestacaoDeContas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrestacaoDeContas prestacaoDeContas;
    @JoinColumn(name = "NumRef", referencedColumnName = "idServico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicos servicos;
    @JoinColumn(name = "NumRef", referencedColumnName = "Tag", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TagEstacionamento tagEstacionamento;
    @JoinColumn(name = "NumRef", referencedColumnName = "Telefone", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Telefone telefone;
    @JoinColumn(name = "NumRef", referencedColumnName = "idTreinamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Treinamentos treinamentos;

    public NumRefMQP() {
    }

    public NumRefMQP(NumRefMQPPK numRefMQPPK) {
        this.numRefMQPPK = numRefMQPPK;
    }

    public NumRefMQP(int numRef, int idMQP) {
        this.numRefMQPPK = new NumRefMQPPK(numRef, idMQP);
    }

    public NumRefMQPPK getNumRefMQPPK() {
        return numRefMQPPK;
    }

    public void setNumRefMQPPK(NumRefMQPPK numRefMQPPK) {
        this.numRefMQPPK = numRefMQPPK;
    }

    public CartaoCorporativo getCartaoCorporativo() {
        return cartaoCorporativo;
    }

    public void setCartaoCorporativo(CartaoCorporativo cartaoCorporativo) {
        this.cartaoCorporativo = cartaoCorporativo;
    }

    public CartaoMultibeneficios getCartaoMultibeneficios() {
        return cartaoMultibeneficios;
    }

    public void setCartaoMultibeneficios(CartaoMultibeneficios cartaoMultibeneficios) {
        this.cartaoMultibeneficios = cartaoMultibeneficios;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Equipamentos getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Gdp getGdp() {
        return gdp;
    }

    public void setGdp(Gdp gdp) {
        this.gdp = gdp;
    }

    public PrestacaoDeContas getPrestacaoDeContas() {
        return prestacaoDeContas;
    }

    public void setPrestacaoDeContas(PrestacaoDeContas prestacaoDeContas) {
        this.prestacaoDeContas = prestacaoDeContas;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public TagEstacionamento getTagEstacionamento() {
        return tagEstacionamento;
    }

    public void setTagEstacionamento(TagEstacionamento tagEstacionamento) {
        this.tagEstacionamento = tagEstacionamento;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Treinamentos getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(Treinamentos treinamentos) {
        this.treinamentos = treinamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numRefMQPPK != null ? numRefMQPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumRefMQP)) {
            return false;
        }
        NumRefMQP other = (NumRefMQP) object;
        if ((this.numRefMQPPK == null && other.numRefMQPPK != null) || (this.numRefMQPPK != null && !this.numRefMQPPK.equals(other.numRefMQPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.mqp.entities.NumRefMQP[ numRefMQPPK=" + numRefMQPPK + " ]";
    }
    
}
