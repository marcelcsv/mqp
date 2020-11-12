package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Categorias;
import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.CategoriasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "categoriasController")
@ViewScoped
public class CategoriasController extends AbstractController<Categorias> {

    // Flags to indicate if child collections are empty
    private boolean isNumRefMQPCollectionEmpty;

    public CategoriasController() {
        // Inform the Abstract parent controller of the concrete Categorias Entity
        super(Categorias.class);
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
        Categorias selected = this.getSelected();
        if (selected != null) {
            CategoriasFacade ejbFacade = (CategoriasFacade) this.getFacade();
            this.isNumRefMQPCollectionEmpty = ejbFacade.isNumRefMQPCollectionEmpty(selected);
        } else {
            this.isNumRefMQPCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumRefMQP entities that
     * are retrieved from Categorias and returns the navigation outcome.
     *
     * @return navigation outcome for NumRefMQP page
     */
    public String navigateNumRefMQPCollection() {
        Categorias selected = this.getSelected();
        if (selected != null) {
            CategoriasFacade ejbFacade = (CategoriasFacade) this.getFacade();
            Collection<NumRefMQP> selectedNumRefMQPCollection = ejbFacade.findNumRefMQPCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NumRefMQP_items", selectedNumRefMQPCollection);
        }
        return "/app/numRefMQP/index";
    }

}
