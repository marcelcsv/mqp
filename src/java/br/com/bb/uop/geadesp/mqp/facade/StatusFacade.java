/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Status_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class StatusFacade extends AbstractFacade<Status> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusFacade() {
        super(Status.class);
    }

    public boolean isEmailCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.emailCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Email> findEmailCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Email> emailCollection = mergedEntity.getEmailCollection();
        emailCollection.size();
        return emailCollection;
    }

    public boolean isTelefoneCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }

    public boolean isGdpCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.gdpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Gdp> findGdpCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Gdp> gdpCollection = mergedEntity.getGdpCollection();
        gdpCollection.size();
        return gdpCollection;
    }

    public boolean isTreinamentosCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.treinamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Treinamentos> findTreinamentosCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Treinamentos> treinamentosCollection = mergedEntity.getTreinamentosCollection();
        treinamentosCollection.size();
        return treinamentosCollection;
    }

    public boolean isTagEstacionamentoCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.tagEstacionamentoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<TagEstacionamento> findTagEstacionamentoCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<TagEstacionamento> tagEstacionamentoCollection = mergedEntity.getTagEstacionamentoCollection();
        tagEstacionamentoCollection.size();
        return tagEstacionamentoCollection;
    }

    public boolean isCartaoCorporativoCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.cartaoCorporativoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CartaoCorporativo> findCartaoCorporativoCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<CartaoCorporativo> cartaoCorporativoCollection = mergedEntity.getCartaoCorporativoCollection();
        cartaoCorporativoCollection.size();
        return cartaoCorporativoCollection;
    }

    public boolean isMqpInitCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.mqpInitCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<MqpInit> findMqpInitCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<MqpInit> mqpInitCollection = mergedEntity.getMqpInitCollection();
        mqpInitCollection.size();
        return mqpInitCollection;
    }

    public boolean isEquipamentosCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.equipamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipamentos> findEquipamentosCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Equipamentos> equipamentosCollection = mergedEntity.getEquipamentosCollection();
        equipamentosCollection.size();
        return equipamentosCollection;
    }

    public boolean isCartaoMultibeneficiosCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.cartaoMultibeneficiosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CartaoMultibeneficios> findCartaoMultibeneficiosCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<CartaoMultibeneficios> cartaoMultibeneficiosCollection = mergedEntity.getCartaoMultibeneficiosCollection();
        cartaoMultibeneficiosCollection.size();
        return cartaoMultibeneficiosCollection;
    }

    public boolean isMqpCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.mqpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection = mergedEntity.getMqpCollection();
        mqpCollection.size();
        return mqpCollection;
    }

    public boolean isServicosCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.servicosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Servicos> findServicosCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Servicos> servicosCollection = mergedEntity.getServicosCollection();
        servicosCollection.size();
        return servicosCollection;
    }

    public boolean isPrestacaoDeContasCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.prestacaoDeContasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<PrestacaoDeContas> findPrestacaoDeContasCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<PrestacaoDeContas> prestacaoDeContasCollection = mergedEntity.getPrestacaoDeContasCollection();
        prestacaoDeContasCollection.size();
        return prestacaoDeContasCollection;
    }
    
}
