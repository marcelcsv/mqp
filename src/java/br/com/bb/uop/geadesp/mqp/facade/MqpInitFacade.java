/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class MqpInitFacade extends AbstractFacade<MqpInit> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MqpInitFacade() {
        super(MqpInit.class);
    }

    public boolean isMovimentacaoEmpty(MqpInit entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MqpInit> mqpInit = cq.from(MqpInit.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqpInit, entity), cb.isNotNull(mqpInit.get(MqpInit_.movimentacao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Movimentacao findMovimentacao(MqpInit entity) {
        return this.getMergedEntity(entity).getMovimentacao();
    }

    public boolean isStatusEmpty(MqpInit entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MqpInit> mqpInit = cq.from(MqpInit.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqpInit, entity), cb.isNotNull(mqpInit.get(MqpInit_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(MqpInit entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatrMqpEmpty(MqpInit entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MqpInit> mqpInit = cq.from(MqpInit.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqpInit, entity), cb.isNotNull(mqpInit.get(MqpInit_.matrMqp)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatrMqp(MqpInit entity) {
        return this.getMergedEntity(entity).getMatrMqp();
    }

    public boolean isMatrSolicitanteEmpty(MqpInit entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MqpInit> mqpInit = cq.from(MqpInit.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(mqpInit, entity), cb.isNotNull(mqpInit.get(MqpInit_.matrSolicitante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatrSolicitante(MqpInit entity) {
        return this.getMergedEntity(entity).getMatrSolicitante();
    }
    
}
