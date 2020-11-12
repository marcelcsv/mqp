package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Prefixos.class)
public class Prefixos_ { 

    public static volatile CollectionAttribute<Prefixos, Jurisdicionadas> jurisdicionadasCollection;
    public static volatile CollectionAttribute<Prefixos, Mqp> mqpCollection;
    public static volatile SingularAttribute<Prefixos, String> nomePrefixo;
    public static volatile SingularAttribute<Prefixos, Integer> prefixo;

}