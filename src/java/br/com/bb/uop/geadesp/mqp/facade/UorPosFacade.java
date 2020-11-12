/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.UorPos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.NivelAcesso;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class UorPosFacade extends AbstractFacade<UorPos> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UorPosFacade() {
        super(UorPos.class);
    }

    public boolean isEmailCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.emailCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Email> findEmailCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Email> emailCollection = mergedEntity.getEmailCollection();
        emailCollection.size();
        return emailCollection;
    }

    public boolean isTelefoneCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }

    public boolean isGdpCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.gdpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Gdp> findGdpCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Gdp> gdpCollection = mergedEntity.getGdpCollection();
        gdpCollection.size();
        return gdpCollection;
    }

    public boolean isTreinamentosCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.treinamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Treinamentos> findTreinamentosCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Treinamentos> treinamentosCollection = mergedEntity.getTreinamentosCollection();
        treinamentosCollection.size();
        return treinamentosCollection;
    }

    public boolean isTagEstacionamentoCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.tagEstacionamentoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TagEstacionamento> findTagEstacionamentoCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<TagEstacionamento> tagEstacionamentoCollection = mergedEntity.getTagEstacionamentoCollection();
        tagEstacionamentoCollection.size();
        return tagEstacionamentoCollection;
    }

    public boolean isCartaoCorporativoCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.cartaoCorporativoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CartaoCorporativo> findCartaoCorporativoCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<CartaoCorporativo> cartaoCorporativoCollection = mergedEntity.getCartaoCorporativoCollection();
        cartaoCorporativoCollection.size();
        return cartaoCorporativoCollection;
    }

    public boolean isNivelAcessoEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotNull(uorPos.get(UorPos_.nivelAcesso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public NivelAcesso findNivelAcesso(UorPos entity) {
        return this.getMergedEntity(entity).getNivelAcesso();
    }

    public boolean isMqpInitCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.mqpInitCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<MqpInit> findMqpInitCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<MqpInit> mqpInitCollection = mergedEntity.getMqpInitCollection();
        mqpInitCollection.size();
        return mqpInitCollection;
    }

    public boolean isMqpInitCollection1Empty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.mqpInitCollection1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<MqpInit> findMqpInitCollection1(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<MqpInit> mqpInitCollection1 = mergedEntity.getMqpInitCollection1();
        mqpInitCollection1.size();
        return mqpInitCollection1;
    }

    public boolean isEquipamentosCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.equipamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipamentos> findEquipamentosCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Equipamentos> equipamentosCollection = mergedEntity.getEquipamentosCollection();
        equipamentosCollection.size();
        return equipamentosCollection;
    }

    public boolean isCartaoMultibeneficiosCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.cartaoMultibeneficiosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CartaoMultibeneficios> findCartaoMultibeneficiosCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<CartaoMultibeneficios> cartaoMultibeneficiosCollection = mergedEntity.getCartaoMultibeneficiosCollection();
        cartaoMultibeneficiosCollection.size();
        return cartaoMultibeneficiosCollection;
    }

    public boolean isMqpCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.mqpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection = mergedEntity.getMqpCollection();
        mqpCollection.size();
        return mqpCollection;
    }

    public boolean isMqpCollection1Empty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.mqpCollection1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection1(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection1 = mergedEntity.getMqpCollection1();
        mqpCollection1.size();
        return mqpCollection1;
    }

    public boolean isServicosCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.servicosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Servicos> findServicosCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Servicos> servicosCollection = mergedEntity.getServicosCollection();
        servicosCollection.size();
        return servicosCollection;
    }

    public boolean isPrestacaoDeContasCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.prestacaoDeContasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<PrestacaoDeContas> findPrestacaoDeContasCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<PrestacaoDeContas> prestacaoDeContasCollection = mergedEntity.getPrestacaoDeContasCollection();
        prestacaoDeContasCollection.size();
        return prestacaoDeContasCollection;
    }
    
}
