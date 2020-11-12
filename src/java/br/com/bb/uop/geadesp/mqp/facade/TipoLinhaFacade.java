/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.TipoLinha;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.TipoLinha_;
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
public class TipoLinhaFacade extends AbstractFacade<TipoLinha> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoLinhaFacade() {
        super(TipoLinha.class);
    }

    public boolean isTelefoneCollectionEmpty(TipoLinha entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoLinha> tipoLinha = cq.from(TipoLinha.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoLinha, entity), cb.isNotEmpty(tipoLinha.get(TipoLinha_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(TipoLinha entity) {
        TipoLinha mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }
    
}
