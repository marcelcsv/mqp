package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.CategoriaDispositivo;
import br.com.bb.uop.geadesp.mqp.entities.DispositivoMovel;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.CategoriaDispositivoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "categoriaDispositivoController")
@ViewScoped
public class CategoriaDispositivoController extends AbstractController<CategoriaDispositivo> {

    // Flags to indicate if child collections are empty
    private boolean isDispositivoMovelCollectionEmpty;

    public CategoriaDispositivoController() {
        // Inform the Abstract parent controller of the concrete CategoriaDispositivo Entity
        super(CategoriaDispositivo.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDispositivoMovelCollectionEmpty();
    }

    public boolean getIsDispositivoMovelCollectionEmpty() {
        return this.isDispositivoMovelCollectionEmpty;
    }

    private void setIsDispositivoMovelCollectionEmpty() {
        CategoriaDispositivo selected = this.getSelected();
        if (selected != null) {
            CategoriaDispositivoFacade ejbFacade = (CategoriaDispositivoFacade) this.getFacade();
            this.isDispositivoMovelCollectionEmpty = ejbFacade.isDispositivoMovelCollectionEmpty(selected);
        } else {
            this.isDispositivoMovelCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of DispositivoMovel entities
     * that are retrieved from CategoriaDispositivo and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DispositivoMovel page
     */
    public String navigateDispositivoMovelCollection() {
        CategoriaDispositivo selected = this.getSelected();
        if (selected != null) {
            CategoriaDispositivoFacade ejbFacade = (CategoriaDispositivoFacade) this.getFacade();
            Collection<DispositivoMovel> selectedDispositivoMovelCollection = ejbFacade.findDispositivoMovelCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DispositivoMovel_items", selectedDispositivoMovelCollection);
        }
        return "/app/dispositivoMovel/index";
    }

}
