package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(TagEstacionamento.class)
public class TagEstacionamento_ { 

    public static volatile SingularAttribute<TagEstacionamento, String> veiculo;
    public static volatile CollectionAttribute<TagEstacionamento, NumRefMQP> numRefMQPCollection;
    public static volatile SingularAttribute<TagEstacionamento, String> cpf;
    public static volatile SingularAttribute<TagEstacionamento, UorPos> matricula;
    public static volatile SingularAttribute<TagEstacionamento, String> nome;
    public static volatile SingularAttribute<TagEstacionamento, Integer> tag;
    public static volatile SingularAttribute<TagEstacionamento, String> placa;
    public static volatile SingularAttribute<TagEstacionamento, Status> status;

}