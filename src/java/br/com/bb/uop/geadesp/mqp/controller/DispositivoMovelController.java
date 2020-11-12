package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.DispositivoMovelFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "dispositivoMovelController")
@ViewScoped
public class DispositivoMovelController extends AbstractController<DispositivoMovel> {

    @Inject
    private CategoriaDispositivoController categoriaController;

    // Flags to indicate if child collections are empty
    private boolean isTelefoneCollectionEmpty;

    public DispositivoMovelController() {
        // Inform the Abstract parent controller of the concrete DispositivoMovel Entity
        super(DispositivoMovel.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        categoriaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTelefoneCollectionEmpty();
    }

    public boolean getIsTelefoneCollectionEmpty() {
        return this.isTelefoneCollectionEmpty;
    }

    private void setIsTelefoneCollectionEmpty() {
        DispositivoMovel selected = this.getSelected();
        if (selected != null) {
            DispositivoMovelFacade ejbFacade = (DispositivoMovelFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from DispositivoMovel and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        DispositivoMovel selected = this.getSelected();
        if (selected != null) {
            DispositivoMovelFacade ejbFacade = (DispositivoMovelFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

    /**
     * Sets the "selected" attribute of the CategoriaDispositivo controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategoria(ActionEvent event) {
        DispositivoMovel selected = this.getSelected();
        if (selected != null && categoriaController.getSelected() == null) {
            categoriaController.setSelected(selected.getCategoria());
        }
    }

}
