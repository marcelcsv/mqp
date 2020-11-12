/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos_;
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
public class EquipamentosFacade extends AbstractFacade<Equipamentos> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipamentosFacade() {
        super(Equipamentos.class);
    }

    public boolean isNumRefMQPCollectionEmpty(Equipamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipamentos> equipamentos = cq.from(Equipamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipamentos, entity), cb.isNotEmpty(equipamentos.get(Equipamentos_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(Equipamentos entity) {
        Equipamentos mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(Equipamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipamentos> equipamentos = cq.from(Equipamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipamentos, entity), cb.isNotNull(equipamentos.get(Equipamentos_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Equipamentos entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(Equipamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipamentos> equipamentos = cq.from(Equipamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipamentos, entity), cb.isNotNull(equipamentos.get(Equipamentos_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Equipamentos entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
