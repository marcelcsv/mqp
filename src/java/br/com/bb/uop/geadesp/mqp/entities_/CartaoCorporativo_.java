package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(CartaoCorporativo.class)
public class CartaoCorporativo_ { 

    public static volatile CollectionAttribute<CartaoCorporativo, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<CartaoCorporativo, UorPos> matricula;
    public static volatile SingularAttribute<CartaoCorporativo, String> plastico;
    public static volatile SingularAttribute<CartaoCorporativo, Integer> idCartaoCorporativo;
    public static volatile SingularAttribute<CartaoCorporativo, Integer> contaCartao;
    public static volatile SingularAttribute<CartaoCorporativo, String> bandeira;
    public static volatile SingularAttribute<CartaoCorporativo, String> validade;
    public static volatile SingularAttribute<CartaoCorporativo, Status> status;

}