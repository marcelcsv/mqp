/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class DispositivoMovelFacade extends AbstractFacade<DispositivoMovel> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DispositivoMovelFacade() {
        super(DispositivoMovel.class);
    }

    public boolean isTelefoneCollectionEmpty(DispositivoMovel entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DispositivoMovel> dispositivoMovel = cq.from(DispositivoMovel.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(dispositivoMovel, entity), cb.isNotEmpty(dispositivoMovel.get(DispositivoMovel_.telefoneCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Telefone> findTelefoneCollection(DispositivoMovel entity) {
        DispositivoMovel mergedEntity = this.getMergedEntity(entity);
        Collection<Telefone> telefoneCollection = mergedEntity.getTelefoneCollection();
        telefoneCollection.size();
        return telefoneCollection;
    }

    public boolean isCategoriaEmpty(DispositivoMovel entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DispositivoMovel> dispositivoMovel = cq.from(DispositivoMovel.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(dispositivoMovel, entity), cb.isNotNull(dispositivoMovel.get(DispositivoMovel_.categoria)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CategoriaDispositivo findCategoria(DispositivoMovel entity) {
        return this.getMergedEntity(entity).getCategoria();
    }
    
}
