package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(OperadoraTelefone.class)
public class OperadoraTelefone_ { 

    public static volatile SingularAttribute<OperadoraTelefone, Integer> idOperadora;
    public static volatile CollectionAttribute<OperadoraTelefone, Telefone> telefoneCollection;
    public static volatile SingularAttribute<OperadoraTelefone, String> nomeOperadora;

}