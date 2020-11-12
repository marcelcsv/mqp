package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Gdp.class)
public class Gdp_ { 

    public static volatile CollectionAttribute<Gdp, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Gdp, String> descricaoGDP;
    public static volatile SingularAttribute<Gdp, UorPos> matricula;
    public static volatile SingularAttribute<Gdp, String> nomeGDP;
    public static volatile SingularAttribute<Gdp, Integer> idGDP;
    public static volatile SingularAttribute<Gdp, Status> status;

}