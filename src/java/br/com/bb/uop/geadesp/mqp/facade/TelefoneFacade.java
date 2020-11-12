/*
 * Todos os direitos reservados, Banco do Brasil SA
 */
package br.com.bb.uop.geadesp.mqp.facade;

import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.mqp.entities.Telefone_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.mqp.entities.Acao;
import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone;
import br.com.bb.uop.geadesp.mqp.entities.Situacao;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.TipoLinha;
import br.com.bb.uop.geadesp.mqp.entities.TipoMovimentoPendente;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;

/**
 *
 * @author Marcel C S Vieira F6750699
 */
@Stateless
public class TelefoneFacade extends AbstractFacade<Telefone> {

    @PersistenceContext(unitName = "mqpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefoneFacade() {
        super(Telefone.class);
    }

    public boolean isAcaoEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.acao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Acao findAcao(Telefone entity) {
        return this.getMergedEntity(entity).getAcao();
    }

    public boolean isDispositivoEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.dispositivo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public DispositivoMovel findDispositivo(Telefone entity) {
        return this.getMergedEntity(entity).getDispositivo();
    }

    public boolean isOperadoraEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.operadora)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public OperadoraTelefone findOperadora(Telefone entity) {
        return this.getMergedEntity(entity).getOperadora();
    }

    public boolean isSituacaoEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.situacao)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Situacao findSituacao(Telefone entity) {
        return this.getMergedEntity(entity).getSituacao();
    }

    public boolean isStatusEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Telefone entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isTipoLinhaEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.tipoLinha)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoLinha findTipoLinha(Telefone entity) {
        return this.getMergedEntity(entity).getTipoLinha();
    }

    public boolean isMovimentoPendenteEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.movimentoPendente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoMovimentoPendente findMovimentoPendente(Telefone entity) {
        return this.getMergedEntity(entity).getMovimentoPendente();
    }

    public boolean isMatriculaEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotNull(telefone.get(Telefone_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Telefone entity) {
        return this.getMergedEntity(entity).getMatricula();
    }

    public boolean isNumRefMQPCollectionEmpty(Telefone entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Telefone> telefone = cq.from(Telefone.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(telefone, entity), cb.isNotEmpty(telefone.get(Telefone_.numRefMQPCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<NumRefMQP> findNumRefMQPCollection(Telefone entity) {
        Telefone mergedEntity = this.getMergedEntity(entity);
        Collection<NumRefMQP> numRefMQPCollection = mergedEntity.getNumRefMQPCollection();
        numRefMQPCollection.size();
        return numRefMQPCollection;
    }
    
}
