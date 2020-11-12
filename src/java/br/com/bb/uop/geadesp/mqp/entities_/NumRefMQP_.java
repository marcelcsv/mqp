package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Categorias;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(NumRefMQP.class)
public class NumRefMQP_ { 

    public static volatile SingularAttribute<NumRefMQP, Servicos> servicos;
    public static volatile SingularAttribute<NumRefMQP, Gdp> gdp;
    public static volatile SingularAttribute<NumRefMQP, Telefone> telefone;
    public static volatile SingularAttribute<NumRefMQP, CartaoCorporativo> cartaoCorporativo;
    public static volatile SingularAttribute<NumRefMQP, CartaoMultibeneficios> cartaoMultibeneficios;
    public static volatile SingularAttribute<NumRefMQP, NumRefMQPPK> numRefMQPPK;
    public static volatile SingularAttribute<NumRefMQP, Treinamentos> treinamentos;
    public static volatile SingularAttribute<NumRefMQP, Categorias> categoria;
    public static volatile SingularAttribute<NumRefMQP, TagEstacionamento> tagEstacionamento;
    public static volatile SingularAttribute<NumRefMQP, PrestacaoDeContas> prestacaoDeContas;
    public static volatile SingularAttribute<NumRefMQP, Equipamentos> equipamentos;

}