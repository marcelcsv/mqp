package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.TipoInsercao;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.TipoInsercaoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoInsercaoController")
@ViewScoped
public class TipoInsercaoController extends AbstractController<TipoInsercao> {

    // Flags to indicate if child collections are empty
    private boolean isMqpCollectionEmpty;

    public TipoInsercaoController() {
        // Inform the Abstract parent controller of the concrete TipoInsercao Entity
        super(TipoInsercao.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMqpCollectionEmpty();
    }

    public boolean getIsMqpCollectionEmpty() {
        return this.isMqpCollectionEmpty;
    }

    private void setIsMqpCollectionEmpty() {
        TipoInsercao selected = this.getSelected();
        if (selected != null) {
            TipoInsercaoFacade ejbFacade = (TipoInsercaoFacade) this.getFacade();
            this.isMqpCollectionEmpty = ejbFacade.isMqpCollectionEmpty(selected);
        } else {
            this.isMqpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from TipoInsercao and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection() {
        TipoInsercao selected = this.getSelected();
        if (selected != null) {
            TipoInsercaoFacade ejbFacade = (TipoInsercaoFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection = ejbFacade.findMqpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection);
        }
        return "/app/mqp/index";
    }

}
