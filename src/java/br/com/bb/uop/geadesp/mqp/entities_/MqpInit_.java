package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(MqpInit.class)
public class MqpInit_ { 

    public static volatile SingularAttribute<MqpInit, Movimentacao> movimentacao;
    public static volatile SingularAttribute<MqpInit, Date> dtref;
    public static volatile SingularAttribute<MqpInit, Integer> idMQPinit;
    public static volatile SingularAttribute<MqpInit, UorPos> matrMqp;
    public static volatile SingularAttribute<MqpInit, Status> status;
    public static volatile SingularAttribute<MqpInit, UorPos> matrSolicitante;

}