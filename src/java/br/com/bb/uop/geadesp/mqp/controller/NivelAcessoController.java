package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.NivelAcesso;
import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.NivelAcessoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "nivelAcessoController")
@ViewScoped
public class NivelAcessoController extends AbstractController<NivelAcesso> {

    // Flags to indicate if child collections are empty
    private boolean isUorPosCollectionEmpty;

    public NivelAcessoController() {
        // Inform the Abstract parent controller of the concrete NivelAcesso Entity
        super(NivelAcesso.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUorPosCollectionEmpty();
    }

    public boolean getIsUorPosCollectionEmpty() {
        return this.isUorPosCollectionEmpty;
    }

    private void setIsUorPosCollectionEmpty() {
        NivelAcesso selected = this.getSelected();
        if (selected != null) {
            NivelAcessoFacade ejbFacade = (NivelAcessoFacade) this.getFacade();
            this.isUorPosCollectionEmpty = ejbFacade.isUorPosCollectionEmpty(selected);
        } else {
            this.isUorPosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of UorPos entities that are
     * retrieved from NivelAcesso and returns the navigation outcome.
     *
     * @return navigation outcome for UorPos page
     */
    public String navigateUorPosCollection() {
        NivelAcesso selected = this.getSelected();
        if (selected != null) {
            NivelAcessoFacade ejbFacade = (NivelAcessoFacade) this.getFacade();
            Collection<UorPos> selectedUorPosCollection = ejbFacade.findUorPosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UorPos_items", selectedUorPosCollection);
        }
        return "/app/uorPos/index";
    }

}
