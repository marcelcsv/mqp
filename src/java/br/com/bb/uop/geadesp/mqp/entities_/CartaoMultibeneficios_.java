package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(CartaoMultibeneficios.class)
public class CartaoMultibeneficios_ { 

    public static volatile CollectionAttribute<CartaoMultibeneficios, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<CartaoMultibeneficios, Date> dataDeAdesao;
    public static volatile SingularAttribute<CartaoMultibeneficios, UorPos> matricula;
    public static volatile SingularAttribute<CartaoMultibeneficios, Integer> idCartaoMultibeneficios;
    public static volatile SingularAttribute<CartaoMultibeneficios, Status> status;

}