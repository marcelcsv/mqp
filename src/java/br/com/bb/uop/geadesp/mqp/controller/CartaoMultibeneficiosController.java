package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.CartaoMultibeneficiosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cartaoMultibeneficiosController")
@ViewScoped
public class CartaoMultibeneficiosController extends AbstractController<CartaoMultibeneficios> {

    @Inject
    private StatusController statusController;
    @Inject
    private UorPosController matriculaController;

    // Flags to indicate if child collections are empty
    private boolean isNumRefMQPCollectionEmpty;

    public CartaoMultibeneficiosController() {
        // Inform the Abstract parent controller of the concrete CartaoMultibeneficios Entity
        super(CartaoMultibeneficios.class);
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
        CartaoMultibeneficios selected = this.getSelected();
        if (selected != null) {
            CartaoMultibeneficiosFacade ejbFacade = (CartaoMultibeneficiosFacade) this.getFacade();
            this.isNumRefMQPCollectionEmpty = ejbFacade.isNumRefMQPCollectionEmpty(selected);
        } else {
            this.isNumRefMQPCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumRefMQP entities that
     * are retrieved from CartaoMultibeneficios and returns the navigation
     * outcome.
     *
     * @return navigation outcome for NumRefMQP page
     */
    public String navigateNumRefMQPCollection() {
        CartaoMultibeneficios selected = this.getSelected();
        if (selected != null) {
            CartaoMultibeneficiosFacade ejbFacade = (CartaoMultibeneficiosFacade) this.getFacade();
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
        CartaoMultibeneficios selected = this.getSelected();
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
        CartaoMultibeneficios selected = this.getSelected();
        if (selected != null && matriculaController.getSelected() == null) {
            matriculaController.setSelected(selected.getMatricula());
        }
    }

}
