package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Prefixos;
import br.com.bb.uop.geadesp.mqp.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.PrefixosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "prefixosController")
@ViewScoped
public class PrefixosController extends AbstractController<Prefixos> {

    // Flags to indicate if child collections are empty
    private boolean isJurisdicionadasCollectionEmpty;
    private boolean isMqpCollectionEmpty;

    public PrefixosController() {
        // Inform the Abstract parent controller of the concrete Prefixos Entity
        super(Prefixos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsJurisdicionadasCollectionEmpty();
        this.setIsMqpCollectionEmpty();
    }

    public boolean getIsJurisdicionadasCollectionEmpty() {
        return this.isJurisdicionadasCollectionEmpty;
    }

    private void setIsJurisdicionadasCollectionEmpty() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            this.isJurisdicionadasCollectionEmpty = ejbFacade.isJurisdicionadasCollectionEmpty(selected);
        } else {
            this.isJurisdicionadasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Jurisdicionadas entities
     * that are retrieved from Prefixos and returns the navigation outcome.
     *
     * @return navigation outcome for Jurisdicionadas page
     */
    public String navigateJurisdicionadasCollection() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            Collection<Jurisdicionadas> selectedJurisdicionadasCollection = ejbFacade.findJurisdicionadasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Jurisdicionadas_items", selectedJurisdicionadasCollection);
        }
        return "/app/jurisdicionadas/index";
    }

    public boolean getIsMqpCollectionEmpty() {
        return this.isMqpCollectionEmpty;
    }

    private void setIsMqpCollectionEmpty() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            this.isMqpCollectionEmpty = ejbFacade.isMqpCollectionEmpty(selected);
        } else {
            this.isMqpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from Prefixos and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection() {
        Prefixos selected = this.getSelected();
        if (selected != null) {
            PrefixosFacade ejbFacade = (PrefixosFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection = ejbFacade.findMqpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection);
        }
        return "/app/mqp/index";
    }

}
