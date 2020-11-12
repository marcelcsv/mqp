package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.PrestacaoDeContasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "prestacaoDeContasController")
@ViewScoped
public class PrestacaoDeContasController extends AbstractController<PrestacaoDeContas> {

    @Inject
    private StatusController statusController;
    @Inject
    private UorPosController matriculaController;

    // Flags to indicate if child collections are empty
    private boolean isNumRefMQPCollectionEmpty;

    public PrestacaoDeContasController() {
        // Inform the Abstract parent controller of the concrete PrestacaoDeContas Entity
        super(PrestacaoDeContas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        statusController.setSelected(null);
        matriculaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsNumRefMQPCollectionEmpty();
    }

    public boolean getIsNumRefMQPCollectionEmpty() {
        return this.isNumRefMQPCollectionEmpty;
    }

    private void setIsNumRefMQPCollectionEmpty() {
        PrestacaoDeContas selected = this.getSelected();
        if (selected != null) {
            PrestacaoDeContasFacade ejbFacade = (PrestacaoDeContasFacade) this.getFacade();
            this.isNumRefMQPCollectionEmpty = ejbFacade.isNumRefMQPCollectionEmpty(selected);
        } else {
            this.isNumRefMQPCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumRefMQP entities that
     * are retrieved from PrestacaoDeContas and returns the navigation outcome.
     *
     * @return navigation outcome for NumRefMQP page
     */
    public String navigateNumRefMQPCollection() {
        PrestacaoDeContas selected = this.getSelected();
        if (selected != null) {
            PrestacaoDeContasFacade ejbFacade = (PrestacaoDeContasFacade) this.getFacade();
            Collection<NumRefMQP> selectedNumRefMQPCollection = ejbFacade.findNumRefMQPCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NumRefMQP_items", selectedNumRefMQPCollection);
        }
        return "/app/numRefMQP/index";
    }

    /**
     * Sets the "selected" attribute of the Status controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStatus(ActionEvent event) {
        PrestacaoDeContas selected = this.getSelected();
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
    public void prepareMatricula(ActionEvent event) {
        PrestacaoDeContas selected = this.getSelected();
        if (selected != null && matriculaController.getSelected() == null) {
            matriculaController.setSelected(selected.getMatricula());
        }
    }

}
