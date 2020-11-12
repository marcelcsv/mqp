/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo_;
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
public class CartaoCorporativoFacade extends AbstractFacade<CartaoCorporativo> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartaoCorporativoFacade() {
        super(CartaoCorporativo.class);
    }

    public boolean isNumRefMQPCollectionEmpty(CartaoCorporativo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoCorporativo> cartaoCorporativo = cq.from(CartaoCorporativo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoCorporativo, entity), cb.isNotEmpty(cartaoCorporativo.get(CartaoCorporativo_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(CartaoCorporativo entity) {
        CartaoCorporativo mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(CartaoCorporativo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoCorporativo> cartaoCorporativo = cq.from(CartaoCorporativo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoCorporativo, entity), cb.isNotNull(cartaoCorporativo.get(CartaoCorporativo_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(CartaoCorporativo entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(CartaoCorporativo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoCorporativo> cartaoCorporativo = cq.from(CartaoCorporativo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoCorporativo, entity), cb.isNotNull(cartaoCorporativo.get(CartaoCorporativo_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(CartaoCorporativo entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
