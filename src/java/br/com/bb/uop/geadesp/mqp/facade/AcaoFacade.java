/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Acao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Acao_;
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
public class AcaoFacade extends AbstractFacade<Acao> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcaoFacade() {
        super(Acao.class);
    }

    public boolean isTelefoneCollectionEmpty(Acao entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Acao> acao = cq.from(Acao.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(acao, entity), cb.isNotEmpty(acao.get(Acao_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(Acao entity) {
        Acao mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }
    
}
