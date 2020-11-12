package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.TipoLinha;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.TipoLinhaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoLinhaController")
@ViewScoped
public class TipoLinhaController extends AbstractController<TipoLinha> {

    // Flags to indicate if child collections are empty
    private boolean isTelefoneCollectionEmpty;

    public TipoLinhaController() {
        // Inform the Abstract parent controller of the concrete TipoLinha Entity
        super(TipoLinha.class);
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
        TipoLinha selected = this.getSelected();
        if (selected != null) {
            TipoLinhaFacade ejbFacade = (TipoLinhaFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from TipoLinha and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        TipoLinha selected = this.getSelected();
        if (selected != null) {
            TipoLinhaFacade ejbFacade = (TipoLinhaFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

}
