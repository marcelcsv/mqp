package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Acao;
import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone;
import br.com.bb.uop.geadesp.mqp.entities.Situacao;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.TipoLinha;
import br.com.bb.uop.geadesp.mqp.entities.TipoMovimentoPendente;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, Integer> telefone;
    public static volatile SingularAttribute<Telefone, Situacao> situacao;
    public static volatile SingularAttribute<Telefone, DispositivoMovel> dispositivo;
    public static volatile SingularAttribute<Telefone, Integer> ddd;
    public static volatile CollectionAttribute<Telefone, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Telefone, TipoLinha> tipoLinha;
    public static volatile SingularAttribute<Telefone, UorPos> matricula;
    public static volatile SingularAttribute<Telefone, Acao> acao;
    public static volatile SingularAttribute<Telefone, OperadoraTelefone> operadora;
    public static volatile SingularAttribute<Telefone, Status> status;
    public static volatile SingularAttribute<Telefone, TipoMovimentoPendente> movimentoPendente;

}