/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas_;
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
public class PrestacaoDeContasFacade extends AbstractFacade<PrestacaoDeContas> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestacaoDeContasFacade() {
        super(PrestacaoDeContas.class);
    }

    public boolean isNumRefMQPCollectionEmpty(PrestacaoDeContas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PrestacaoDeContas> prestacaoDeContas = cq.from(PrestacaoDeContas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prestacaoDeContas, entity), cb.isNotEmpty(prestacaoDeContas.get(PrestacaoDeContas_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(PrestacaoDeContas entity) {
        PrestacaoDeContas mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(PrestacaoDeContas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PrestacaoDeContas> prestacaoDeContas = cq.from(PrestacaoDeContas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prestacaoDeContas, entity), cb.isNotNull(prestacaoDeContas.get(PrestacaoDeContas_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(PrestacaoDeContas entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(PrestacaoDeContas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PrestacaoDeContas> prestacaoDeContas = cq.from(PrestacaoDeContas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prestacaoDeContas, entity), cb.isNotNull(prestacaoDeContas.get(PrestacaoDeContas_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(PrestacaoDeContas entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
