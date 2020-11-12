package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.TelefoneFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "telefoneController")
@ViewScoped
public class TelefoneController extends AbstractController<Telefone> {

    @Inject
    private AcaoController acaoController;
    @Inject
    private DispositivoMovelController dispositivoController;
    @Inject
    private OperadoraTelefoneController operadoraController;
    @Inject
    private SituacaoController situacaoController;
    @Inject
    private StatusController statusController;
    @Inject
    private TipoLinhaController tipoLinhaController;
    @Inject
    private TipoMovimentoPendenteController movimentoPendenteController;
    @Inject
    private UorPosController matriculaController;

    // Flags to indicate if child collections are empty
    private boolean isNumRefMQPCollectionEmpty;

    public TelefoneController() {
        // Inform the Abstract parent controller of the concrete Telefone Entity
        super(Telefone.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        acaoController.setSelected(null);
        dispositivoController.setSelected(null);
        operadoraController.setSelected(null);
        situacaoController.setSelected(null);
        statusController.setSelected(null);
        tipoLinhaController.setSelected(null);
        movimentoPendenteController.setSelected(null);
        matriculaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsNumRefMQPCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Acao controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAcao(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && acaoController.getSelected() == null) {
            acaoController.setSelected(selected.getAcao());
        }
    }

    /**
     * Sets the "selected" attribute of the DispositivoMovel controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDispositivo(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && dispositivoController.getSelected() == null) {
            dispositivoController.setSelected(selected.getDispositivo());
        }
    }

    /**
     * Sets the "selected" attribute of the OperadoraTelefone controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOperadora(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && operadoraController.getSelected() == null) {
            operadoraController.setSelected(selected.getOperadora());
        }
    }

    /**
     * Sets the "selected" attribute of the Situacao controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSituacao(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && situacaoController.getSelected() == null) {
            situacaoController.setSelected(selected.getSituacao());
        }
    }

    /**
     * Sets the "selected" attribute of the Status controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStatus(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && statusController.getSelected() == null) {
            statusController.setSelected(selected.getStatus());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoLinha controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoLinha(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && tipoLinhaController.getSelected() == null) {
            tipoLinhaController.setSelected(selected.getTipoLinha());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoMovimentoPendente controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMovimentoPendente(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && movimentoPendenteController.getSelected() == null) {
            movimentoPendenteController.setSelected(selected.getMovimentoPendente());
        }
    }

    /**
     * Sets the "selected" attribute of the UorPos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMatricula(ActionEvent event) {
        Telefone selected = this.getSelected();
        if (selected != null && matriculaController.getSelected() == null) {
            matriculaController.setSelected(selected.getMatricula());
        }
    }

    public boolean getIsNumRefMQPCollectionEmpty() {
        return this.isNumRefMQPCollectionEmpty;
    }

    private void setIsNumRefMQPCollectionEmpty() {
        Telefone selected = this.getSelected();
        if (selected != null) {
            TelefoneFacade ejbFacade = (TelefoneFacade) this.getFacade();
            this.isNumRefMQPCollectionEmpty = ejbFacade.isNumRefMQPCollectionEmpty(selected);
        } else {
            this.isNumRefMQPCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumRefMQP entities that
     * are retrieved from Telefone and returns the navigation outcome.
     *
     * @return navigation outcome for NumRefMQP page
     */
    public String navigateNumRefMQPCollection() {
        Telefone selected = this.getSelected();
        if (selected != null) {
            TelefoneFacade ejbFacade = (TelefoneFacade) this.getFacade();
            Collection<NumRefMQP> selectedNumRefMQPCollection = ejbFacade.findNumRefMQPCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NumRefMQP_items", selectedNumRefMQPCollection);
        }
        return "/app/numRefMQP/index";
    }

}
