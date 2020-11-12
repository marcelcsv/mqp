package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.beans.cdi.SessionChave;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "mqpInitController")
@ViewScoped
public class MqpInitController extends AbstractController<MqpInit> {

    @Inject
    private MovimentacaoController movimentacaoController;
    @Inject
    private StatusController statusController;
    @Inject
    private UorPosController matrMqpController;
    @Inject
    private UorPosController matrSolicitanteController;
    @Inject
    @SessionChave
    private String iSessionChave;

    //String sessionChave;
    Date currentDate = new Date();

    public MqpInitController() {
        // Inform the Abstract parent controller of the concrete MqpInit Entity
        super(MqpInit.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        movimentacaoController.setSelected(null);
        statusController.setSelected(null);
        matrMqpController.setSelected(null);
        matrSolicitanteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Movimentacao controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMovimentacao(ActionEvent event) {
        MqpInit selected = this.getSelected();
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
        MqpInit selected = this.getSelected();
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
    public void prepareMatrMqp(ActionEvent event) {
        MqpInit selected = this.getSelected();
        if (selected != null && matrMqpController.getSelected() == null) {
            matrMqpController.setSelected(selected.getMatrMqp());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatrSolicitante(ActionEvent event) {
        MqpInit selected = this.getSelected();
        if (selected != null && matrSolicitanteController.getSelected() == null) {
            matrSolicitanteController.setSelected(selected.getMatrSolicitante());
        }
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    //save http session attributes
    @Override
    public void saveNew(ActionEvent event) {
        UorPos u = new UorPos();
        Status s = new Status();
        u.setMatricula(iSessionChave);
        s.setIdStatus(1);
        this.getSelected().setMatrSolicitante(u);
        this.getSelected().setStatus(s);
        this.getSelected().setDtref(currentDate); // as date here would never change

        super.saveNew(event);
    }

//    @PostConstruct
//    public void init() {
//        sessionChave = iSessionChave;
//    }

}
