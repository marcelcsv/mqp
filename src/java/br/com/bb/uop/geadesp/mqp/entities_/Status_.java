package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile CollectionAttribute<Status, Gdp> gdpCollection;
    public static volatile CollectionAttribute<Status, Servicos> servicosCollection;
    public static volatile CollectionAttribute<Status, TagEstacionamento> tagEstacionamentoCollection;
    public static volatile CollectionAttribute<Status, Equipamentos> equipamentosCollection;
    public static volatile CollectionAttribute<Status, Mqp> mqpCollection;
    public static volatile CollectionAttribute<Status, PrestacaoDeContas> prestacaoDeContasCollection;
    public static volatile CollectionAttribute<Status, CartaoMultibeneficios> cartaoMultibeneficiosCollection;
    public static volatile SingularAttribute<Status, Integer> idStatus;
    public static volatile SingularAttribute<Status, String> descricaoStatus;
    public static volatile CollectionAttribute<Status, CartaoCorporativo> cartaoCorporativoCollection;
    public static volatile CollectionAttribute<Status, Treinamentos> treinamentosCollection;
    public static volatile CollectionAttribute<Status, Telefone> telefoneCollection;
    public static volatile SingularAttribute<Status, String> status;
    public static volatile CollectionAttribute<Status, Email> emailCollection;
    public static volatile CollectionAttribute<Status, MqpInit> mqpInitCollection;

}