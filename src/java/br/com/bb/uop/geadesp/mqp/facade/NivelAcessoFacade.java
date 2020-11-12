/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.NivelAcesso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.NivelAcesso_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class NivelAcessoFacade extends AbstractFacade<NivelAcesso> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcessoFacade() {
        super(NivelAcesso.class);
    }

    public boolean isUorPosCollectionEmpty(NivelAcesso entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NivelAcesso> nivelAcesso = cq.from(NivelAcesso.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(nivelAcesso, entity), cb.isNotEmpty(nivelAcesso.get(NivelAcesso_.uorPosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<UorPos> findUorPosCollection(NivelAcesso entity) {
        NivelAcesso mergedEntity = this.getMergedEntity(entity);
        Collection<UorPos> uorPosCollection = mergedEntity.getUorPosCollection();
        uorPosCollection.size();
        return uorPosCollection;
    }
    
}
