package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(NivelAcesso.class)
public class NivelAcesso_ { 

    public static volatile SingularAttribute<NivelAcesso, Integer> idNivelAcesso;
    public static volatile SingularAttribute<NivelAcesso, String> descricaoAcesso;
    public static volatile CollectionAttribute<NivelAcesso, UorPos> uorPosCollection;
    public static volatile SingularAttribute<NivelAcesso, String> nomeAcesso;
    public static volatile SingularAttribute<NivelAcesso, String> siglaAcesso;

}