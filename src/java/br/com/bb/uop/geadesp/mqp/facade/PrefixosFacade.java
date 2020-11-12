/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Prefixos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Prefixos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class PrefixosFacade extends AbstractFacade<Prefixos> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrefixosFacade() {
        super(Prefixos.class);
    }

    public boolean isJurisdicionadasCollectionEmpty(Prefixos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Prefixos> prefixos = cq.from(Prefixos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prefixos, entity), cb.isNotEmpty(prefixos.get(Prefixos_.jurisdicionadasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Jurisdicionadas> findJurisdicionadasCollection(Prefixos entity) {
        Prefixos mergedEntity = this.getMergedEntity(entity);
        Collection<Jurisdicionadas> jurisdicionadasCollection = mergedEntity.getJurisdicionadasCollection();
        jurisdicionadasCollection.size();
        return jurisdicionadasCollection;
    }

    public boolean isMqpCollectionEmpty(Prefixos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Prefixos> prefixos = cq.from(Prefixos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prefixos, entity), cb.isNotEmpty(prefixos.get(Prefixos_.mqpCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Mqp> findMqpCollection(Prefixos entity) {
        Prefixos mergedEntity = this.getMergedEntity(entity);
        Collection<Mqp> mqpCollection = mergedEntity.getMqpCollection();
        mqpCollection.size();
        return mqpCollection;
    }
    
}
