package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(DispositivoMovel.class)
public class DispositivoMovel_ { 

    public static volatile CollectionAttribute<DispositivoMovel, Telefone> telefoneCollection;
    public static volatile SingularAttribute<DispositivoMovel, CategoriaDispositivo> categoria;
    public static volatile SingularAttribute<DispositivoMovel, Integer> idDispositivoMovel;
    public static volatile SingularAttribute<DispositivoMovel, String> nomeDispositivoMovel;

}