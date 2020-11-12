package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Prefixos;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.TipoInsercao;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Mqp.class)
public class Mqp_ { 

    public static volatile SingularAttribute<Mqp, String> servicos;
    public static volatile SingularAttribute<Mqp, UorPos> matriculaSolicitante;
    public static volatile SingularAttribute<Mqp, String> cartaoCorporativo;
    public static volatile SingularAttribute<Mqp, String> cartaoMultibeneficios;
    public static volatile SingularAttribute<Mqp, String> linhaTelefonica;
    public static volatile SingularAttribute<Mqp, String> tagEstacionamento;
    public static volatile SingularAttribute<Mqp, Date> dataHoraRegistro;
    public static volatile SingularAttribute<Mqp, String> treinamento;
    public static volatile SingularAttribute<Mqp, Movimentacao> movimentacao;
    public static volatile SingularAttribute<Mqp, String> gdp;
    public static volatile SingularAttribute<Mqp, UorPos> matricula;
    public static volatile SingularAttribute<Mqp, Integer> id;
    public static volatile SingularAttribute<Mqp, String> prestacaoDeContas;
    public static volatile SingularAttribute<Mqp, Prefixos> prefixo;
    public static volatile SingularAttribute<Mqp, TipoInsercao> insercao;
    public static volatile SingularAttribute<Mqp, String> equipamentos;
    public static volatile CollectionAttribute<Mqp, Email> emailCollection;
    public static volatile SingularAttribute<Mqp, Status> status;

}