/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Gdp_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class GdpFacade extends AbstractFacade<Gdp> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GdpFacade() {
        super(Gdp.class);
    }

    public boolean isStatusEmpty(Gdp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Gdp> gdp = cq.from(Gdp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gdp, entity), cb.isNotNull(gdp.get(Gdp_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Gdp entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(Gdp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Gdp> gdp = cq.from(Gdp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gdp, entity), cb.isNotNull(gdp.get(Gdp_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Gdp entity) {
        return this.getMergedEntity(entity).getMatricula();
    }

    public boolean isNumRefMQPCollectionEmpty(Gdp entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Gdp> gdp = cq.from(Gdp.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(gdp, entity), cb.isNotEmpty(gdp.get(Gdp_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(Gdp entity) {
        Gdp mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }
    
}
