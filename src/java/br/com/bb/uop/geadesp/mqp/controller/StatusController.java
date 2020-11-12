package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.Status;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.StatusFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "statusController")
@ViewScoped
public class StatusController extends AbstractController<Status> {

    // Flags to indicate if child collections are empty
    private boolean isEmailCollectionEmpty;
    private boolean isTelefoneCollectionEmpty;
    private boolean isGdpCollectionEmpty;
    private boolean isTreinamentosCollectionEmpty;
    private boolean isTagEstacionamentoCollectionEmpty;
    private boolean isCartaoCorporativoCollectionEmpty;
    private boolean isMqpInitCollectionEmpty;
    private boolean isEquipamentosCollectionEmpty;
    private boolean isCartaoMultibeneficiosCollectionEmpty;
    private boolean isMqpCollectionEmpty;
    private boolean isServicosCollectionEmpty;
    private boolean isPrestacaoDeContasCollectionEmpty;

    public StatusController() {
        // Inform the Abstract parent controller of the concrete Status Entity
        super(Status.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmailCollectionEmpty();
        this.setIsTelefoneCollectionEmpty();
        this.setIsGdpCollectionEmpty();
        this.setIsTreinamentosCollectionEmpty();
        this.setIsTagEstacionamentoCollectionEmpty();
        this.setIsCartaoCorporativoCollectionEmpty();
        this.setIsMqpInitCollectionEmpty();
        this.setIsEquipamentosCollectionEmpty();
        this.setIsCartaoMultibeneficiosCollectionEmpty();
        this.setIsMqpCollectionEmpty();
        this.setIsServicosCollectionEmpty();
        this.setIsPrestacaoDeContasCollectionEmpty();
    }

    public boolean getIsEmailCollectionEmpty() {
        return this.isEmailCollectionEmpty;
    }

    private void setIsEmailCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isEmailCollectionEmpty = ejbFacade.isEmailCollectionEmpty(selected);
        } else {
            this.isEmailCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Email entities that are
     * retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Email page
     */
    public String navigateEmailCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Email> selectedEmailCollection = ejbFacade.findEmailCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Email_items", selectedEmailCollection);
        }
        return "/app/email/index";
    }

    public boolean getIsTelefoneCollectionEmpty() {
        return this.isTelefoneCollectionEmpty;
    }

    private void setIsTelefoneCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

    public boolean getIsGdpCollectionEmpty() {
        return this.isGdpCollectionEmpty;
    }

    private void setIsGdpCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isGdpCollectionEmpty = ejbFacade.isGdpCollectionEmpty(selected);
        } else {
            this.isGdpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Gdp entities that are
     * retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Gdp page
     */
    public String navigateGdpCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Gdp> selectedGdpCollection = ejbFacade.findGdpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Gdp_items", selectedGdpCollection);
        }
        return "/app/gdp/index";
    }

    public boolean getIsTreinamentosCollectionEmpty() {
        return this.isTreinamentosCollectionEmpty;
    }

    private void setIsTreinamentosCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isTreinamentosCollectionEmpty = ejbFacade.isTreinamentosCollectionEmpty(selected);
        } else {
            this.isTreinamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Treinamentos entities
     * that are retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Treinamentos page
     */
    public String navigateTreinamentosCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Treinamentos> selectedTreinamentosCollection = ejbFacade.findTreinamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Treinamentos_items", selectedTreinamentosCollection);
        }
        return "/app/treinamentos/index";
    }

    public boolean getIsTagEstacionamentoCollectionEmpty() {
        return this.isTagEstacionamentoCollectionEmpty;
    }

    private void setIsTagEstacionamentoCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isTagEstacionamentoCollectionEmpty = ejbFacade.isTagEstacionamentoCollectionEmpty(selected);
        } else {
            this.isTagEstacionamentoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TagEstacionamento
     * entities that are retrieved from Status and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TagEstacionamento page
     */
    public String navigateTagEstacionamentoCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<TagEstacionamento> selectedTagEstacionamentoCollection = ejbFacade.findTagEstacionamentoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TagEstacionamento_items", selectedTagEstacionamentoCollection);
        }
        return "/app/tagEstacionamento/index";
    }

    public boolean getIsCartaoCorporativoCollectionEmpty() {
        return this.isCartaoCorporativoCollectionEmpty;
    }

    private void setIsCartaoCorporativoCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isCartaoCorporativoCollectionEmpty = ejbFacade.isCartaoCorporativoCollectionEmpty(selected);
        } else {
            this.isCartaoCorporativoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CartaoCorporativo
     * entities that are retrieved from Status and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CartaoCorporativo page
     */
    public String navigateCartaoCorporativoCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<CartaoCorporativo> selectedCartaoCorporativoCollection = ejbFacade.findCartaoCorporativoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CartaoCorporativo_items", selectedCartaoCorporativoCollection);
        }
        return "/app/cartaoCorporativo/index";
    }

    public boolean getIsMqpInitCollectionEmpty() {
        return this.isMqpInitCollectionEmpty;
    }

    private void setIsMqpInitCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isMqpInitCollectionEmpty = ejbFacade.isMqpInitCollectionEmpty(selected);
        } else {
            this.isMqpInitCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MqpInit entities that are
     * retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for MqpInit page
     */
    public String navigateMqpInitCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<MqpInit> selectedMqpInitCollection = ejbFacade.findMqpInitCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MqpInit_items", selectedMqpInitCollection);
        }
        return "/app/mqpInit/index";
    }

    public boolean getIsEquipamentosCollectionEmpty() {
        return this.isEquipamentosCollectionEmpty;
    }

    private void setIsEquipamentosCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isEquipamentosCollectionEmpty = ejbFacade.isEquipamentosCollectionEmpty(selected);
        } else {
            this.isEquipamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipamentos entities
     * that are retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Equipamentos page
     */
    public String navigateEquipamentosCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Equipamentos> selectedEquipamentosCollection = ejbFacade.findEquipamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipamentos_items", selectedEquipamentosCollection);
        }
        return "/app/equipamentos/index";
    }

    public boolean getIsCartaoMultibeneficiosCollectionEmpty() {
        return this.isCartaoMultibeneficiosCollectionEmpty;
    }

    private void setIsCartaoMultibeneficiosCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isCartaoMultibeneficiosCollectionEmpty = ejbFacade.isCartaoMultibeneficiosCollectionEmpty(selected);
        } else {
            this.isCartaoMultibeneficiosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CartaoMultibeneficios
     * entities that are retrieved from Status and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CartaoMultibeneficios page
     */
    public String navigateCartaoMultibeneficiosCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<CartaoMultibeneficios> selectedCartaoMultibeneficiosCollection = ejbFacade.findCartaoMultibeneficiosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CartaoMultibeneficios_items", selectedCartaoMultibeneficiosCollection);
        }
        return "/app/cartaoMultibeneficios/index";
    }

    public boolean getIsMqpCollectionEmpty() {
        return this.isMqpCollectionEmpty;
    }

    private void setIsMqpCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isMqpCollectionEmpty = ejbFacade.isMqpCollectionEmpty(selected);
        } else {
            this.isMqpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection = ejbFacade.findMqpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection);
        }
        return "/app/mqp/index";
    }

    public boolean getIsServicosCollectionEmpty() {
        return this.isServicosCollectionEmpty;
    }

    private void setIsServicosCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isServicosCollectionEmpty = ejbFacade.isServicosCollectionEmpty(selected);
        } else {
            this.isServicosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Servicos entities that
     * are retrieved from Status and returns the navigation outcome.
     *
     * @return navigation outcome for Servicos page
     */
    public String navigateServicosCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<Servicos> selectedServicosCollection = ejbFacade.findServicosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicos_items", selectedServicosCollection);
        }
        return "/app/servicos/index";
    }

    public boolean getIsPrestacaoDeContasCollectionEmpty() {
        return this.isPrestacaoDeContasCollectionEmpty;
    }

    private void setIsPrestacaoDeContasCollectionEmpty() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            this.isPrestacaoDeContasCollectionEmpty = ejbFacade.isPrestacaoDeContasCollectionEmpty(selected);
        } else {
            this.isPrestacaoDeContasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of PrestacaoDeContas
     * entities that are retrieved from Status and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PrestacaoDeContas page
     */
    public String navigatePrestacaoDeContasCollection() {
        Status selected = this.getSelected();
        if (selected != null) {
            StatusFacade ejbFacade = (StatusFacade) this.getFacade();
            Collection<PrestacaoDeContas> selectedPrestacaoDeContasCollection = ejbFacade.findPrestacaoDeContasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PrestacaoDeContas_items", selectedPrestacaoDeContasCollection);
        }
        return "/app/prestacaoDeContas/index";
    }

}
