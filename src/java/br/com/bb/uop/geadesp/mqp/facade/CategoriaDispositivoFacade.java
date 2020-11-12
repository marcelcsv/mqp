/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class CategoriaDispositivoFacade extends AbstractFacade<CategoriaDispositivo> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaDispositivoFacade() {
        super(CategoriaDispositivo.class);
    }

    public boolean isDispositivoMovelCollectionEmpty(CategoriaDispositivo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CategoriaDispositivo> categoriaDispositivo = cq.from(CategoriaDispositivo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(categoriaDispositivo, entity), cb.isNotEmpty(categoriaDispositivo.get(CategoriaDispositivo_.dispositivoMovelCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<DispositivoMovel> findDispositivoMovelCollection(CategoriaDispositivo entity) {
        CategoriaDispositivo mergedEntity = this.getMergedEntity(entity);
        Collection<DispositivoMovel> dispositivoMovelCollection = mergedEntity.getDispositivoMovelCollection();
        dispositivoMovelCollection.size();
        return dispositivoMovelCollection;
    }
    
}
