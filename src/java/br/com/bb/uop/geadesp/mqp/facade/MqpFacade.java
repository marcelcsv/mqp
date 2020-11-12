/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Mqp_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Prefixos;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.TipoInsercao;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class MqpFacade extends AbstractFacade<Mqp> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MqpFacade() {
        super(Mqp.class);
    }

    public boolean isEmailCollectionEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotEmpty(mqp.get(Mqp_.emailCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Email> findEmailCollection(Mqp entity) {
        Mqp mergedEntity = this.getMergedEntity(entity);
        Collection<Email> emailCollection = mergedEntity.getEmailCollection();
        emailCollection.size();
        return emailCollection;
    }

    public boolean isMovimentacaoEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.movimentacao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Movimentacao findMovimentacao(Mqp entity) {
        return this.getMergedEntity(entity).getMovimentacao();
    }

    public boolean isPrefixoEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.prefixo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Prefixos findPrefixo(Mqp entity) {
        return this.getMergedEntity(entity).getPrefixo();
    }

    public boolean isStatusEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Mqp entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isInsercaoEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.insercao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoInsercao findInsercao(Mqp entity) {
        return this.getMergedEntity(entity).getInsercao();
    }

    public boolean isMatriculaEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Mqp entity) {
        return this.getMergedEntity(entity).getMatricula();
    }

    public boolean isMatriculaSolicitanteEmpty(Mqp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Mqp> mqp = cq.from(Mqp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqp, entity), cb.isNotNull(mqp.get(Mqp_.matriculaSolicitante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatriculaSolicitante(Mqp entity) {
        return this.getMergedEntity(entity).getMatriculaSolicitante();
    }
    
}
