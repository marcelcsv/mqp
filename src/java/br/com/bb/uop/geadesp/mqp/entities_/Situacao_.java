package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Situacao.class)
public class Situacao_ { 

    public static volatile SingularAttribute<Situacao, String> nomeSituacao;
    public static volatile SingularAttribute<Situacao, String> descricaoSituacao;
    public static volatile CollectionAttribute<Situacao, Telefone> telefoneCollection;
    public static volatile SingularAttribute<Situacao, Integer> idSituacao;

}