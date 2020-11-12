/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Email;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Email_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class EmailFacade extends AbstractFacade<Email> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmailFacade() {
        super(Email.class);
    }

    public boolean isMovimentacaoEmpty(Email entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Email> email = cq.from(Email.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(email, entity), cb.isNotNull(email.get(Email_.movimentacao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Mqp findMovimentacao(Email entity) {
        return this.getMergedEntity(entity).getMovimentacao();
    }

    public boolean isStatusEmpty(Email entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Email> email = cq.from(Email.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(email, entity), cb.isNotNull(email.get(Email_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Email entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEnvioManualEmpty(Email entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Email> email = cq.from(Email.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(email, entity), cb.isNotNull(email.get(Email_.matriculaEnvioManual)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatriculaEnvioManual(Email entity) {
        return this.getMergedEntity(entity).getMatriculaEnvioManual();
    }
    
}
