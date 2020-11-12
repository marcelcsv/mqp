package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Situacao;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.SituacaoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "situacaoController")
@ViewScoped
public class SituacaoController extends AbstractController<Situacao> {

    // Flags to indicate if child collections are empty
    private boolean isTelefoneCollectionEmpty;

    public SituacaoController() {
        // Inform the Abstract parent controller of the concrete Situacao Entity
        super(Situacao.class);
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
        Situacao selected = this.getSelected();
        if (selected != null) {
            SituacaoFacade ejbFacade = (SituacaoFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from Situacao and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        Situacao selected = this.getSelected();
        if (selected != null) {
            SituacaoFacade ejbFacade = (SituacaoFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

}
