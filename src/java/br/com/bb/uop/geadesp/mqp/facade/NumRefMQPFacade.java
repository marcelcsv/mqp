/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Categorias;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class NumRefMQPFacade extends AbstractFacade<NumRefMQP> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NumRefMQPFacade() {
        super(NumRefMQP.class);
    }

    public boolean isCartaoCorporativoEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.cartaoCorporativo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CartaoCorporativo findCartaoCorporativo(NumRefMQP entity) {
        return this.getMergedEntity(entity).getCartaoCorporativo();
    }

    public boolean isCartaoMultibeneficiosEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.cartaoMultibeneficios)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CartaoMultibeneficios findCartaoMultibeneficios(NumRefMQP entity) {
        return this.getMergedEntity(entity).getCartaoMultibeneficios();
    }

    public boolean isCategoriaEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.categoria)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Categorias findCategoria(NumRefMQP entity) {
        return this.getMergedEntity(entity).getCategoria();
    }

    public boolean isEquipamentosEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.equipamentos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipamentos findEquipamentos(NumRefMQP entity) {
        return this.getMergedEntity(entity).getEquipamentos();
    }

    public boolean isGdpEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.gdp)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Gdp findGdp(NumRefMQP entity) {
        return this.getMergedEntity(entity).getGdp();
    }

    public boolean isPrestacaoDeContasEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.prestacaoDeContas)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public PrestacaoDeContas findPrestacaoDeContas(NumRefMQP entity) {
        return this.getMergedEntity(entity).getPrestacaoDeContas();
    }

    public boolean isServicosEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.servicos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Servicos findServicos(NumRefMQP entity) {
        return this.getMergedEntity(entity).getServicos();
    }

    public boolean isTagEstacionamentoEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.tagEstacionamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TagEstacionamento findTagEstacionamento(NumRefMQP entity) {
        return this.getMergedEntity(entity).getTagEstacionamento();
    }

    public boolean isTelefoneEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.telefone)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Telefone findTelefone(NumRefMQP entity) {
        return this.getMergedEntity(entity).getTelefone();
    }

    public boolean isTreinamentosEmpty(NumRefMQP entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NumRefMQP> numRefMQP = cq.from(NumRefMQP.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(numRefMQP, entity), cb.isNotNull(numRefMQP.get(NumRefMQP_.treinamentos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Treinamentos findTreinamentos(NumRefMQP entity) {
        return this.getMergedEntity(entity).getTreinamentos();
    }
    
}
