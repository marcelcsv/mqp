/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.TipoInsercao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.TipoInsercao_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class TipoInsercaoFacade extends AbstractFacade<TipoInsercao> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoInsercaoFacade() {
        super(TipoInsercao.class);
    }

    public boolean isMqpCollectionEmpty(TipoInsercao entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoInsercao> tipoInsercao = cq.from(TipoInsercao.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoInsercao, entity), cb.isNotEmpty(tipoInsercao.get(TipoInsercao_.mqpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection(TipoInsercao entity) {
        TipoInsercao mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection = mergedEntity.getMqpCollection();
        mqpCollection.size();
        return mqpCollection;
    }
    
}
