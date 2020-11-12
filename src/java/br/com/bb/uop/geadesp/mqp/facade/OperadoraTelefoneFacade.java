/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone_;
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
public class OperadoraTelefoneFacade extends AbstractFacade<OperadoraTelefone> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperadoraTelefoneFacade() {
        super(OperadoraTelefone.class);
    }

    public boolean isTelefoneCollectionEmpty(OperadoraTelefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OperadoraTelefone> operadoraTelefone = cq.from(OperadoraTelefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(operadoraTelefone, entity), cb.isNotEmpty(operadoraTelefone.get(OperadoraTelefone_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(OperadoraTelefone entity) {
        OperadoraTelefone mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }
    
}
