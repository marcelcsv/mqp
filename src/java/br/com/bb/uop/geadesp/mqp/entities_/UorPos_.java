package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.NivelAcesso;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(UorPos.class)
public class UorPos_ { 

    public static volatile CollectionAttribute<UorPos, Gdp> gdpCollection;
    public static volatile CollectionAttribute<UorPos, Servicos> servicosCollection;
    public static volatile CollectionAttribute<UorPos, TagEstacionamento> tagEstacionamentoCollection;
    public static volatile CollectionAttribute<UorPos, Mqp> mqpCollection1;
    public static volatile SingularAttribute<UorPos, Integer> situacao;
    public static volatile CollectionAttribute<UorPos, Equipamentos> equipamentosCollection;
    public static volatile CollectionAttribute<UorPos, Mqp> mqpCollection;
    public static volatile SingularAttribute<UorPos, Integer> uorPos;
    public static volatile CollectionAttribute<UorPos, PrestacaoDeContas> prestacaoDeContasCollection;
    public static volatile CollectionAttribute<UorPos, CartaoMultibeneficios> cartaoMultibeneficiosCollection;
    public static volatile SingularAttribute<UorPos, String> nome;
    public static volatile CollectionAttribute<UorPos, CartaoCorporativo> cartaoCorporativoCollection;
    public static volatile CollectionAttribute<UorPos, Treinamentos> treinamentosCollection;
    public static volatile CollectionAttribute<UorPos, Telefone> telefoneCollection;
    public static volatile SingularAttribute<UorPos, String> matricula;
    public static volatile SingularAttribute<UorPos, String> nomeUorPos;
    public static volatile SingularAttribute<UorPos, NivelAcesso> nivelAcesso;
    public static volatile CollectionAttribute<UorPos, MqpInit> mqpInitCollection1;
    public static volatile SingularAttribute<UorPos, Integer> prefixo;
    public static volatile SingularAttribute<UorPos, Date> dataCaptura;
    public static volatile CollectionAttribute<UorPos, Email> emailCollection;
    public static volatile CollectionAttribute<UorPos, MqpInit> mqpInitCollection;

}