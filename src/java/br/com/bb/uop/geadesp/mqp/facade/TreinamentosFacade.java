/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos_;
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
public class TreinamentosFacade extends AbstractFacade<Treinamentos> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TreinamentosFacade() {
        super(Treinamentos.class);
    }

    public boolean isNumRefMQPCollectionEmpty(Treinamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Treinamentos> treinamentos = cq.from(Treinamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(treinamentos, entity), cb.isNotEmpty(treinamentos.get(Treinamentos_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(Treinamentos entity) {
        Treinamentos mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(Treinamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Treinamentos> treinamentos = cq.from(Treinamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(treinamentos, entity), cb.isNotNull(treinamentos.get(Treinamentos_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Treinamentos entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(Treinamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Treinamentos> treinamentos = cq.from(Treinamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(treinamentos, entity), cb.isNotNull(treinamentos.get(Treinamentos_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Treinamentos entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
