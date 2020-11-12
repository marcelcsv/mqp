package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, String> nomeMovimentacao;
    public static volatile CollectionAttribute<Movimentacao, Mqp> mqpCollection;
    public static volatile SingularAttribute<Movimentacao, String> descricaoMovimentacao;
    public static volatile SingularAttribute<Movimentacao, Integer> idMovimentacao;
    public static volatile CollectionAttribute<Movimentacao, MqpInit> mqpInitCollection;

}