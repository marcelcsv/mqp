/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Servicos_;
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
public class ServicosFacade extends AbstractFacade<Servicos> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicosFacade() {
        super(Servicos.class);
    }

    public boolean isNumRefMQPCollectionEmpty(Servicos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicos> servicos = cq.from(Servicos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicos, entity), cb.isNotEmpty(servicos.get(Servicos_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(Servicos entity) {
        Servicos mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(Servicos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicos> servicos = cq.from(Servicos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicos, entity), cb.isNotNull(servicos.get(Servicos_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Servicos entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(Servicos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicos> servicos = cq.from(Servicos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicos, entity), cb.isNotNull(servicos.get(Servicos_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Servicos entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
