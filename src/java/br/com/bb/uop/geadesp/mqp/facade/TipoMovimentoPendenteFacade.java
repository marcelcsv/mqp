/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.TipoMovimentoPendente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.TipoMovimentoPendente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class TipoMovimentoPendenteFacade extends AbstractFacade<TipoMovimentoPendente> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMovimentoPendenteFacade() {
        super(TipoMovimentoPendente.class);
    }

    public boolean isTelefoneCollectionEmpty(TipoMovimentoPendente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoMovimentoPendente> tipoMovimentoPendente = cq.from(TipoMovimentoPendente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoMovimentoPendente, entity), cb.isNotEmpty(tipoMovimentoPendente.get(TipoMovimentoPendente_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(TipoMovimentoPendente entity) {
        TipoMovimentoPendente mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }
    
}
