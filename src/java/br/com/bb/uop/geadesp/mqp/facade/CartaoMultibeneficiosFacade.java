/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios_;
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
public class CartaoMultibeneficiosFacade extends AbstractFacade<CartaoMultibeneficios> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartaoMultibeneficiosFacade() {
        super(CartaoMultibeneficios.class);
    }

    public boolean isNumRefMQPCollectionEmpty(CartaoMultibeneficios entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoMultibeneficios> cartaoMultibeneficios = cq.from(CartaoMultibeneficios.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoMultibeneficios, entity), cb.isNotEmpty(cartaoMultibeneficios.get(CartaoMultibeneficios_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(CartaoMultibeneficios entity) {
        CartaoMultibeneficios mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }

    public boolean isStatusEmpty(CartaoMultibeneficios entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoMultibeneficios> cartaoMultibeneficios = cq.from(CartaoMultibeneficios.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoMultibeneficios, entity), cb.isNotNull(cartaoMultibeneficios.get(CartaoMultibeneficios_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(CartaoMultibeneficios entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(CartaoMultibeneficios entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CartaoMultibeneficios> cartaoMultibeneficios = cq.from(CartaoMultibeneficios.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cartaoMultibeneficios, entity), cb.isNotNull(cartaoMultibeneficios.get(CartaoMultibeneficios_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(CartaoMultibeneficios entity) {
        return this.getMergedEntity(entity).getMatricula();
    }
    
}
