/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class TagEstacionamentoFacade extends AbstractFacade<TagEstacionamento> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagEstacionamentoFacade() {
        super(TagEstacionamento.class);
    }

    public boolean isNumRefMQPCollectionEmpty(TagEstacionamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TagEstacionamento> tagEstacionamento = cq.from(TagEstacionamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tagEstacionamento, entity), cb.isNotEmpty(tagEstacionamento.get(TagEstacionamento_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(TagEstacionamento entity) {
        TagEstacionamento mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(TagEstacionamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TagEstacionamento> tagEstacionamento = cq.from(TagEstacionamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tagEstacionamento, entity), cb.isNotNull(tagEstacionamento.get(TagEstacionamento_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(TagEstacionamento entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(TagEstacionamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TagEstacionamento> tagEstacionamento = cq.from(TagEstacionamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tagEstacionamento, entity), cb.isNotNull(tagEstacionamento.get(TagEstacionamento_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(TagEstacionamento entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
