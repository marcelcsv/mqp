package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(TipoLinha.class)
public class TipoLinha_ { 

    public static volatile SingularAttribute<TipoLinha, String> descricaoTipoLinha;
    public static volatile CollectionAttribute<TipoLinha, Telefone> telefoneCollection;
    public static volatile SingularAttribute<TipoLinha, Integer> idTipoLinha;
    public static volatile SingularAttribute<TipoLinha, String> nomeTipoLinha;

}