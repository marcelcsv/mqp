package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Equipamentos.class)
public class Equipamentos_ { 

    public static volatile SingularAttribute<Equipamentos, String> nomeEquipamento;
    public static volatile CollectionAttribute<Equipamentos, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Equipamentos, String> descricaoEquipamento;
    public static volatile SingularAttribute<Equipamentos, UorPos> matricula;
    public static volatile SingularAttribute<Equipamentos, Integer> idEquipamentos;
    public static volatile SingularAttribute<Equipamentos, Status> status;

}