/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class MovimentacaoFacade extends AbstractFacade<Movimentacao> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimentacaoFacade() {
        super(Movimentacao.class);
    }

    public boolean isMqpInitCollectionEmpty(Movimentacao entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Movimentacao> movimentacao = cq.from(Movimentacao.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(movimentacao, entity), cb.isNotEmpty(movimentacao.get(Movimentacao_.mqpInitCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<MqpInit> findMqpInitCollection(Movimentacao entity) {
        Movimentacao mergedEntity = this.getMergedEntity(entity);
        Collection<MqpInit> mqpInitCollection = mergedEntity.getMqpInitCollection();
        mqpInitCollection.size();
        return mqpInitCollection;
    }

    public boolean isMqpCollectionEmpty(Movimentacao entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Movimentacao> movimentacao = cq.from(Movimentacao.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(movimentacao, entity), cb.isNotEmpty(movimentacao.get(Movimentacao_.mqpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection(Movimentacao entity) {
        Movimentacao mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection = mergedEntity.getMqpCollection();
        mqpCollection.size();
        return mqpCollection;
    }
    
}
