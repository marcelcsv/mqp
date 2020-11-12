/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Situacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Situacao_;
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
public class SituacaoFacade extends AbstractFacade<Situacao> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SituacaoFacade() {
        super(Situacao.class);
    }

    public boolean isTelefoneCollectionEmpty(Situacao entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Situacao> situacao = cq.from(Situacao.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(situacao, entity), cb.isNotEmpty(situacao.get(Situacao_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(Situacao entity) {
        Situacao mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }
    
}
