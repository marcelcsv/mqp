package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Servicos.class)
public class Servicos_ { 

    public static volatile SingularAttribute<Servicos, String> descricaoServico;
    public static volatile SingularAttribute<Servicos, String> nomeServico;
    public static volatile CollectionAttribute<Servicos, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Servicos, Integer> idServico;
    public static volatile SingularAttribute<Servicos, UorPos> matricula;
    public static volatile SingularAttribute<Servicos, Status> status;

}