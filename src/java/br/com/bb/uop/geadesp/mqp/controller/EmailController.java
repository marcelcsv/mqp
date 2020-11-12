package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "emailController")
@ViewScoped
public class EmailController extends AbstractController<Email> {

    @Inject
    private MqpController movimentacaoController;
    @Inject
    private StatusController statusController;
    @Inject
    private UorPosController matriculaEnvioManualController;

    public EmailController() {
        // Inform the Abstract parent controller of the concrete Email Entity
        super(Email.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        movimentacaoController.setSelected(null);
        statusController.setSelected(null);
        matriculaEnvioManualController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Mqp controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMovimentacao(ActionEvent event) {
        Email selected = this.getSelected();
        if (selected != null && movimentacaoController.getSelected() == null) {
            movimentacaoController.setSelected(selected.getMovimentacao());
        }
    }

    /**
     * Sets the "selected" attribute of the Status controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStatus(ActionEvent event) {
        Email selected = this.getSelected();
        if (selected != null && statusController.getSelected() == null) {
            statusController.setSelected(selected.getStatus());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatriculaEnvioManual(ActionEvent event) {
        Email selected = this.getSelected();
        if (selected != null && matriculaEnvioManualController.getSelected() == null) {
            matriculaEnvioManualController.setSelected(selected.getMatriculaEnvioManual());
        }
    }

//    @Override
//    public void saveEmail() {
//
//        Mqp mqp = new Mqp();
//        Email e = new Email();
//        Movimentacao m = new Movimentacao();
//        Status s = new Status();
//        UorPos u = new UorPos();
//
//        m.setIdMovimentacao(movimentacaoController.getSelected().getMovimentacao().getIdMovimentacao());
//        mqp.setMovimentacao(m);
//        s.setIdStatus(movimentacaoController.getSelected().getStatus().getIdStatus());
//        u.setMatricula(movimentacaoController.getSelected().getMatriculaSolicitante().getMatricula());
//
//        e.setMovimentacao(mqp);
//        e.setStatus(s);
//        e.setDestino(movimentacaoController.getSelected().getMatricula().getMatricula());
//        e.setCc("uop.geadesp@bb.com.br");
//        e.setCo(u.getMatricula());
//        e.setAssunto("#interna - Movimentação no Quadro de Pessoal nº " + movimentacaoController.getSelected().getId().toString() + ".");
//        e.setMensagem(movimentacaoController.mensagemEmail());
//        e.setMatriculaEnvioManual(u);
//        e.setDataEnvio(movimentacaoController.getCurrentDate());
//
//        this.getSelected().setMovimentacao(e.getMovimentacao());
//        this.getSelected().setStatus(e.getStatus());
//        this.getSelected().setDestino(e.getDestino());
//        this.getSelected().setCc(e.getCc());
//        this.getSelected().setCo(e.getCo());
//        this.getSelected().setAssunto(e.getAssunto());
//        this.getSelected().setMensagem(e.getMensagem());
//        this.getSelected().setMatriculaEnvioManual(e.getMatriculaEnvioManual());
//        this.getSelected().setDataEnvio(e.getDataEnvio());
//
//        System.out.println(e.getMovimentacao());
//        System.out.println(e.getStatus());
//        System.out.println(e.getDestino());
//        System.out.println(e.getCc());
//        System.out.println(e.getCo());
//        System.out.println(e.getAssunto());
//        System.out.println(e.getMensagem());
//        System.out.println(e.getMatriculaEnvioManual());
//        System.out.println(e.getDataEnvio());
//
//        super.saveEmail();
//
//    }

}
