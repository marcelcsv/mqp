package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Movimentacao;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.MovimentacaoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "movimentacaoController")
@ViewScoped
public class MovimentacaoController extends AbstractController<Movimentacao> {

    // Flags to indicate if child collections are empty
    private boolean isMqpInitCollectionEmpty;
    private boolean isMqpCollectionEmpty;

    public MovimentacaoController() {
        // Inform the Abstract parent controller of the concrete Movimentacao Entity
        super(Movimentacao.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMqpInitCollectionEmpty();
        this.setIsMqpCollectionEmpty();
    }

    public boolean getIsMqpInitCollectionEmpty() {
        return this.isMqpInitCollectionEmpty;
    }

    private void setIsMqpInitCollectionEmpty() {
        Movimentacao selected = this.getSelected();
        if (selected != null) {
            MovimentacaoFacade ejbFacade = (MovimentacaoFacade) this.getFacade();
            this.isMqpInitCollectionEmpty = ejbFacade.isMqpInitCollectionEmpty(selected);
        } else {
            this.isMqpInitCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MqpInit entities that are
     * retrieved from Movimentacao and returns the navigation outcome.
     *
     * @return navigation outcome for MqpInit page
     */
    public String navigateMqpInitCollection() {
        Movimentacao selected = this.getSelected();
        if (selected != null) {
            MovimentacaoFacade ejbFacade = (MovimentacaoFacade) this.getFacade();
            Collection<MqpInit> selectedMqpInitCollection = ejbFacade.findMqpInitCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MqpInit_items", selectedMqpInitCollection);
        }
        return "/app/mqpInit/index";
    }

    public boolean getIsMqpCollectionEmpty() {
        return this.isMqpCollectionEmpty;
    }

    private void setIsMqpCollectionEmpty() {
        Movimentacao selected = this.getSelected();
        if (selected != null) {
            MovimentacaoFacade ejbFacade = (MovimentacaoFacade) this.getFacade();
            this.isMqpCollectionEmpty = ejbFacade.isMqpCollectionEmpty(selected);
        } else {
            this.isMqpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from Movimentacao and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection() {
        Movimentacao selected = this.getSelected();
        if (selected != null) {
            MovimentacaoFacade ejbFacade = (MovimentacaoFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection = ejbFacade.findMqpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection);
        }
        return "/app/mqp/index";
    }

}
