package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Categorias.class)
public class Categorias_ { 

    public static volatile SingularAttribute<Categorias, String> descricaoCategoria;
    public static volatile CollectionAttribute<Categorias, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<Categorias, Integer> idCategoria;
    public static volatile SingularAttribute<Categorias, String> nomeCategoria;

}