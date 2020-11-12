package br.com.bb.uop.geadesp.mqp.entities;

import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-28T17:15:45")
@StaticMetamodel(Email.class)
public class Email_ { 

    public static volatile SingularAttribute<Email, String> cc;
    public static volatile SingularAttribute<Email, String> assunto;
    public static volatile SingularAttribute<Email, Mqp> movimentacao;
    public static volatile SingularAttribute<Email, Integer> idEmail;
    public static volatile SingularAttribute<Email, String> mensagem;
    public static volatile SingularAttribute<Email, String> destino;
    public static volatile SingularAttribute<Email, String> co;
    public static volatile SingularAttribute<Email, UorPos> matriculaEnvioManual;
    public static volatile SingularAttribute<Email, Date> dataEnvio;
    public static volatile SingularAttribute<Email, Status> status;

}