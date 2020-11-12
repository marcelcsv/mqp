package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Acao;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.AcaoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "acaoController")
@ViewScoped
public class AcaoController extends AbstractController<Acao> {

    // Flags to indicate if child collections are empty
    private boolean isTelefoneCollectionEmpty;

    public AcaoController() {
        // Inform the Abstract parent controller of the concrete Acao Entity
        super(Acao.class);
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
        Acao selected = this.getSelected();
        if (selected != null) {
            AcaoFacade ejbFacade = (AcaoFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from Acao and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        Acao selected = this.getSelected();
        if (selected != null) {
            AcaoFacade ejbFacade = (AcaoFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

}
