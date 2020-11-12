package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.beans.cdi.SessionChave;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.facade.EmailFacade;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.MqpFacade;
import java.sql.Timestamp;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
//import javax.persistence.PostUpdate;
//import org.primefaces.component.datatable.DataTable;

@Named(value = "mqpController")
@ViewScoped
public class MqpController extends AbstractController<Mqp> {

    @Inject
    private MovimentacaoController movimentacaoController;
    @Inject
    private PrefixosController prefixoController;
    @Inject
    private StatusController statusController;
    @Inject
    private TipoInsercaoController insercaoController;
    @Inject
    private UorPosController matriculaController;
    @Inject
    private UorPosController matriculaSolicitanteController;
    @Inject
    @SessionChave
    private String iSessionChave;

    @EJB
    private EmailSenderBean emailSenderBean;

    @EJB
    private EmailFacade emailFacade;

    private boolean valueOnLinhaTelefonica;
    private boolean valueOnEquipamentos;
    private boolean valueOnServicos;
    private boolean valueOnTagEstacionamento;
    private boolean valueOnCartaoCorporativo;
    private boolean valueOnGdp;
    private boolean valueOnTreinamento;
    private boolean valueOnPrestacaoDeContas;
    private boolean valueOnCartaoMultibeneficios;

    private Date currentDate = new Date();
    java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    // Flags to indicate if child collections are empty
    private boolean isEmailCollectionEmpty;

    public MqpController() {
        // Inform the Abstract parent controller of the concrete Mqp Entity
        super(Mqp.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        movimentacaoController.setSelected(null);
        prefixoController.setSelected(null);
        statusController.setSelected(null);
        insercaoController.setSelected(null);
        matriculaController.setSelected(null);
        matriculaSolicitanteController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmailCollectionEmpty();
    }

    public boolean getIsEmailCollectionEmpty() {
        return this.isEmailCollectionEmpty;
    }

    private void setIsEmailCollectionEmpty() {
        Mqp selected = this.getSelected();
        if (selected != null) {
            MqpFacade ejbFacade = (MqpFacade) this.getFacade();
            this.isEmailCollectionEmpty = ejbFacade.isEmailCollectionEmpty(selected);
        } else {
            this.isEmailCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Email entities that are
     * retrieved from Mqp and returns the navigation outcome.
     *
     * @return navigation outcome for Email page
     */
    public String navigateEmailCollection() {
        Mqp selected = this.getSelected();
        if (selected != null) {
            MqpFacade ejbFacade = (MqpFacade) this.getFacade();
            Collection<Email> selectedEmailCollection = ejbFacade.findEmailCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Email_items", selectedEmailCollection);
        }
        return "/app/email/index";
    }

    /**
     * Sets the "selected" attribute of the Movimentacao controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMovimentacao(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && movimentacaoController.getSelected() == null) {
            movimentacaoController.setSelected(selected.getMovimentacao());
        }
    }

    /**
     * Sets the "selected" attribute of the Prefixos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrefixo(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && prefixoController.getSelected() == null) {
            prefixoController.setSelected(selected.getPrefixo());
        }
    }

    /**
     * Sets the "selected" attribute of the Status controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStatus(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && statusController.getSelected() == null) {
            statusController.setSelected(selected.getStatus());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoInsercao controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInsercao(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && insercaoController.getSelected() == null) {
            insercaoController.setSelected(selected.getInsercao());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatricula(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && matriculaController.getSelected() == null) {
            matriculaController.setSelected(selected.getMatricula());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatriculaSolicitante(ActionEvent event) {
        Mqp selected = this.getSelected();
        if (selected != null && matriculaSolicitanteController.getSelected() == null) {
            matriculaSolicitanteController.setSelected(selected.getMatriculaSolicitante());
        }
    }

    public boolean isValueOnLinhaTelefonica() {
        return valueOnLinhaTelefonica;
    }

    public void setValueOnLinhaTelefonica(boolean valueOnLinhaTelefonica) {
        this.valueOnLinhaTelefonica = valueOnLinhaTelefonica;
    }

    public boolean isValueOnEquipamentos() {
        return valueOnEquipamentos;
    }

    public void setValueOnEquipamentos(boolean valueOnEquipamentos) {
        this.valueOnEquipamentos = valueOnEquipamentos;
    }

    public boolean isValueOnServicos() {
        return valueOnServicos;
    }

    public void setValueOnServicos(boolean valueOnServicos) {
        this.valueOnServicos = valueOnServicos;
    }

    public boolean isValueOnTagEstacionamento() {
        return valueOnTagEstacionamento;
    }

    public void setValueOnTagEstacionamento(boolean valueOnTagEstacionamento) {
        this.valueOnTagEstacionamento = valueOnTagEstacionamento;
    }

    public boolean isValueOnCartaoCorporativo() {
        return valueOnCartaoCorporativo;
    }

    public void setValueOnCartaoCorporativo(boolean valueOnCartaoCorporativo) {
        this.valueOnCartaoCorporativo = valueOnCartaoCorporativo;
    }

    public boolean isValueOnGdp() {
        return valueOnGdp;
    }

    public void setValueOnGdp(boolean valueOnGdp) {
        this.valueOnGdp = valueOnGdp;
    }

    public boolean isValueOnTreinamento() {
        return valueOnTreinamento;
    }

    public void setValueOnTreinamento(boolean valueOnTreinamento) {
        this.valueOnTreinamento = valueOnTreinamento;
    }

    public boolean isValueOnPrestacaoDeContas() {
        return valueOnPrestacaoDeContas;
    }

    public void setValueOnPrestacaoDeContas(boolean valueOnPrestacaoDeContas) {
        this.valueOnPrestacaoDeContas = valueOnPrestacaoDeContas;
    }

    public boolean isValueOnCartaoMultibeneficios() {
        return valueOnCartaoMultibeneficios;
    }

    public void setValueOnCartaoMultibeneficios(boolean valueOnCartaoMultibeneficios) {
        this.valueOnCartaoMultibeneficios = valueOnCartaoMultibeneficios;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void addEmailAdviseMessage() {
        String summaryLinhaTelefonica = valueOnLinhaTelefonica ? "O item Linha Telefônica será incluído no e-mail a ser enviado pelo sistema." : "O item Linha Telefônica não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryLinhaTelefonica));
    }

    public void addEmailAdviseEquipamentosMessage() {
        String summaryEquipamentos = valueOnEquipamentos ? "O item Equipamentos será incluído no e-mail a ser enviado pelo sistema" : "O item Equipamentos não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryEquipamentos));
    }

    public void addEmailAdviseServicosMessage() {
        String summaryServicos = valueOnServicos ? "O item Serviços será incluído no e-mail a ser enviado pelo sistema" : "O item Serviços não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryServicos));
    }

    public void addEmailAdviseTagEstacionamentoMessage() {
        String summaryTagEstacionamento = valueOnTagEstacionamento ? "O item Tag de Estacionamento será incluído no e-mail a ser enviado pelo sistema" : "O item Tag de Estacionamento não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryTagEstacionamento));
    }

    public void addEmailAdviseCartaoCorporativoMessage() {
        String summaryCartaoCorporativo = valueOnCartaoCorporativo ? "O item Cartão Corporativo será incluído no e-mail a ser enviado pelo sistema" : "O item Cartão Corporativo não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryCartaoCorporativo));
    }

    public void addEmailAdviseGdpMessage() {
        String summaryGdp = valueOnGdp ? "O item GDP será incluído no e-mail a ser enviado pelo sistema" : "O item GDP não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryGdp));
    }

    public void addEmailAdviseTreinamentoMessage() {
        String summaryTreinamento = valueOnTreinamento ? "O item Treinamento será incluído no e-mail a ser enviado pelo sistema" : "O item Treinamento não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryTreinamento));
    }

    public void addEmailAdvisePrestacaoDeContasMessage() {
        String summaryPrestacaoDeContas = valueOnPrestacaoDeContas ? "O item Prestação de Contas será incluído no e-mail a ser enviado pelo sistema" : "O item Prestação de Contas não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryPrestacaoDeContas));
    }

    public void addEmailAdviseCartaoMultibeneficiosMessage() {
        String summaryCartaoMultibeneficios = valueOnCartaoMultibeneficios ? "O item Cartão Multibenefícios será incluído no e-mail a ser enviado pelo sistema" : "O item Cartão Multibenefícios não será incluído no e-mail.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summaryCartaoMultibeneficios));
    }

    public String mensagemEmail() {

        String msgLinhaTelefonica = valueOnLinhaTelefonica ? "Telefonia: gentileza atualizar o vínculo da(s) linha(s) telefônica(s) descrita(s) a seguir, informando-nos se pretende fazer a portabilidade da linha móvel (quando permitida pelo Gestor), cancelamento ou transferência para outro usuário: " + this.getSelected().getLinhaTelefonica() + "\n\n" : "";
        String msgEquipamentos = valueOnEquipamentos ? "Equipamentos (caso exista(m) outro(s) equipamento(s) do BB sob sua guarda, gentileza entregá-lo(s) à GEADE SP (mediante Termo de Recebimento) ou nos informar para transferir para outro funcionário): " + this.getSelected().getEquipamentos() + "\n\n" : "";
        String msgServicos = valueOnServicos ? "Usuários de Serviços: caso utilize serviços contratados no seu prefixo (como Bloomberg, Valor Pró, Agência Estado, CMA etc, periódicos físicos/digitais (jornais, revistas etc) e/ou mídia eletrônica), gentileza nos informar para procedermos com as devidas providências junto ao respectivo prefixo e/ou fornecedor(es): " + this.getSelected().getServicos() + "\n\n" : "";
        String msgTagEstacionamento = valueOnTagEstacionamento ? "TAG de estacionamento: " + this.getSelected().getTagEstacionamento() + "\n\n" : "";
        String msgCartaoCorporativo = valueOnCartaoCorporativo ? "Cartão Corporativo: " + this.getSelected().getCartaoCorporativo() + "\n\n" : "";
        String msgGdp = valueOnGdp ? "GDP (conforme data de desligamento, é necessário observar se cabem procedimentos): " + this.getSelected().getGdp() + "\n\n" : "";
        String msgTreinamento = valueOnTreinamento ? "Bolsa de Estudo/Cursos pendentes (verificar/tratar eventuais pendências): " + this.getSelected().getTreinamento() + "\n\n" : "";
        String msgPrestacaoDeContas = valueOnPrestacaoDeContas ? "Prestação de contas pendentes - providenciar, se houver: " + this.getSelected().getPrestacaoDeContas() + "\n\n" : "";
        String msgCartaoMultibeneficios = valueOnCartaoMultibeneficios ? "Cartão Multibenefício – cancelar a adesão, se houver: " + this.getSelected().getCartaoMultibeneficios() + "\n\n" : "";

        String mensagem = "#interna\n\n"
                + "Prezado(a) " + this.getSelected().getMatricula().getNome() + ",\n\n"
                + "Antes de efetivar sua movimentação, elencamos abaixo os itens do BB sob sua responsabilidade que requerem suas devidas providências."
                + "\n\n"
                + msgLinhaTelefonica
                + msgEquipamentos
                + msgServicos
                + msgTagEstacionamento
                + msgCartaoCorporativo
                + msgGdp
                + msgTreinamento
                + msgPrestacaoDeContas
                + msgCartaoMultibeneficios
                + "Estamos à disposição para auxíliar no que for preciso."
                + "\n"
                + "GEADE SP.";

        return mensagem;
    }

    @Override
    public void save(ActionEvent event) {
        UorPos u = new UorPos();
        Status status = new Status();
        Email e = new Email();

        u.setMatricula(iSessionChave);

        FacesContext context = FacesContext.getCurrentInstance();

        String assunto = "#interna - Movimentação no Quadro de Pessoal nº " + this.getSelected().getId().toString() + ".";
        String emailMatricula = this.getSelected().getMatricula().getMatricula() + "@bb.com.br";
        String emailCo = this.getSelected().getMatriculaSolicitante().getMatricula() + "@bb.com.br";
        String emailMsg = mensagemEmail();

        String enviou = "";

        if (this.getSelected().getStatus().getIdStatus() == 7) {
            enviou = emailSenderBean.sendEmail(emailMatricula, emailCo, assunto, emailMsg);
        }

        if (enviou.equals("E-mail enviado com Sucesso!")) {
            status.setIdStatus(8);

            Mqp m = new Mqp();
            Movimentacao mov = new Movimentacao();
            mov.setIdMovimentacao(this.getSelected().getMovimentacao().getIdMovimentacao());
            m.setMovimentacao(mov);
            m.setId(this.getSelected().getId());
            e.setMovimentacao(m);
            e.setStatus(status);
            e.setMatriculaEnvioManual(u);
            e.setDataEnvio(timestamp);
            //e.setDataEnvio(this.getSelected().getDataHoraRegistro());
            e.setDestino(emailMatricula);
            e.setCc("uop.geadesp@bb.com.br");
            e.setCo(emailCo);
            e.setAssunto(assunto);
            e.setMensagem(emailMsg);
            
            System.out.println("currentDate = " + currentDate);
            System.out.println("sqlDate = " + sqlDate);
            System.out.println("timestamp = " + timestamp);
            
            e.setIdEmail(17);
            
            System.out.println("e = " + e);
            System.out.println("e.getIdEmail() = " + e.getIdEmail());
            System.out.println("e.getMovimentacao() = " + e.getMovimentacao());
            System.out.println("e.getDestino() = " + e.getDestino());
            System.out.println("e.getStatus() = " + e.getStatus());
            System.out.println("e.getCc = " + e.getCc());
            System.out.println("e.getCo() = " + e.getCo());
            System.out.println("e.getAssunto() = " + e.getAssunto());
            System.out.println("e.getMensagem() = " + e.getMensagem());
            System.out.println("e.getMatriculaEnvioManual() = " + e.getMatriculaEnvioManual());
            System.out.println("e.getDataEnvio() = " + e.getDataEnvio());
            
            
            
            emailFacade.create(e);

            //saveNewEmail(e);
            context.addMessage(null, new FacesMessage("E-mail referente à Movimentação nº " + this.getSelected().getId() + " enviado com sucesso!"));
        } else {
            context.addMessage(null, new FacesMessage("E-mail referente à Movimentação nº " + this.getSelected().getId() + " ainda não enviado; para isso, gentileza salvar novamente escolhendo o status Pronto para envio."));
            status.setIdStatus(9);
        }

        this.getSelected().setMatriculaSolicitante(u);
        this.getSelected().setStatus(status);
        this.getSelected().setDataHoraRegistro(currentDate);

        //super.saveNewEmail();
        super.save(event);
        //saveNewEmail(e);

    }

//  @PostUpdate
//    public void saveNewEmail(Email e) {
//        System.out.println("after update... ");
//        emailFacade.create(e);
//
//    }
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void create(Email e) {
//        entityManager.getEntityManagerFactory().createEntityManager();
//        //getEntityManager().persist(e);
//    }
}
