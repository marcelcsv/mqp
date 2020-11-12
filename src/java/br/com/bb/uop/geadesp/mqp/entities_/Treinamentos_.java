package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Treinamentos.class)
public class Treinamentos_ { 

    public static volatile CollectionAttribute<Treinamentos, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Treinamentos, UorPos> matricula;
    public static volatile SingularAttribute<Treinamentos, String> nomeTreinamento;
    public static volatile SingularAttribute<Treinamentos, Integer> idTreinamento;
    public static volatile SingularAttribute<Treinamentos, Status> status;

}