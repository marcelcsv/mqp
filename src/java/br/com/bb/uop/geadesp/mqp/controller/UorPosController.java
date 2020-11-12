package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.UorPos;
import br.com.bb.uop.geadesp.mqp.entities.Email;
import br.com.bb.uop.geadesp.mqp.entities.Telefone;
import br.com.bb.uop.geadesp.mqp.entities.Gdp;
import br.com.bb.uop.geadesp.mqp.entities.Treinamentos;
import br.com.bb.uop.geadesp.mqp.entities.TagEstacionamento;
import br.com.bb.uop.geadesp.mqp.entities.CartaoCorporativo;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.MqpInit;
import br.com.bb.uop.geadesp.mqp.entities.Equipamentos;
import br.com.bb.uop.geadesp.mqp.entities.CartaoMultibeneficios;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Mqp;
import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.entities.PrestacaoDeContas;
import java.util.Collection;
import br.com.bb.uop.geadesp.mqp.facade.UorPosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "uorPosController")
@ViewScoped
public class UorPosController extends AbstractController<UorPos> {

    @Inject
    private NivelAcessoController nivelAcessoController;

    // Flags to indicate if child collections are empty
    private boolean isEmailCollectionEmpty;
    private boolean isTelefoneCollectionEmpty;
    private boolean isGdpCollectionEmpty;
    private boolean isTreinamentosCollectionEmpty;
    private boolean isTagEstacionamentoCollectionEmpty;
    private boolean isCartaoCorporativoCollectionEmpty;
    private boolean isMqpInitCollectionEmpty;
    private boolean isMqpInitCollection1Empty;
    private boolean isEquipamentosCollectionEmpty;
    private boolean isCartaoMultibeneficiosCollectionEmpty;
    private boolean isMqpCollectionEmpty;
    private boolean isMqpCollection1Empty;
    private boolean isServicosCollectionEmpty;
    private boolean isPrestacaoDeContasCollectionEmpty;

    public UorPosController() {
        // Inform the Abstract parent controller of the concrete UorPos Entity
        super(UorPos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        nivelAcessoController.setSelected(null);
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
        this.setIsMqpInitCollection1Empty();
        this.setIsEquipamentosCollectionEmpty();
        this.setIsCartaoMultibeneficiosCollectionEmpty();
        this.setIsMqpCollectionEmpty();
        this.setIsMqpCollection1Empty();
        this.setIsServicosCollectionEmpty();
        this.setIsPrestacaoDeContasCollectionEmpty();
    }

    public boolean getIsEmailCollectionEmpty() {
        return this.isEmailCollectionEmpty;
    }

    private void setIsEmailCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isEmailCollectionEmpty = ejbFacade.isEmailCollectionEmpty(selected);
        } else {
            this.isEmailCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Email entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Email page
     */
    public String navigateEmailCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Email> selectedEmailCollection = ejbFacade.findEmailCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Email_items", selectedEmailCollection);
        }
        return "/app/email/index";
    }

    public boolean getIsTelefoneCollectionEmpty() {
        return this.isTelefoneCollectionEmpty;
    }

    private void setIsTelefoneCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isTelefoneCollectionEmpty = ejbFacade.isTelefoneCollectionEmpty(selected);
        } else {
            this.isTelefoneCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Telefone entities that
     * are retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Telefone page
     */
    public String navigateTelefoneCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Telefone> selectedTelefoneCollection = ejbFacade.findTelefoneCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefone_items", selectedTelefoneCollection);
        }
        return "/app/telefone/index";
    }

    public boolean getIsGdpCollectionEmpty() {
        return this.isGdpCollectionEmpty;
    }

    private void setIsGdpCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isGdpCollectionEmpty = ejbFacade.isGdpCollectionEmpty(selected);
        } else {
            this.isGdpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Gdp entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Gdp page
     */
    public String navigateGdpCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Gdp> selectedGdpCollection = ejbFacade.findGdpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Gdp_items", selectedGdpCollection);
        }
        return "/app/gdp/index";
    }

    public boolean getIsTreinamentosCollectionEmpty() {
        return this.isTreinamentosCollectionEmpty;
    }

    private void setIsTreinamentosCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isTreinamentosCollectionEmpty = ejbFacade.isTreinamentosCollectionEmpty(selected);
        } else {
            this.isTreinamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Treinamentos entities
     * that are retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Treinamentos page
     */
    public String navigateTreinamentosCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Treinamentos> selectedTreinamentosCollection = ejbFacade.findTreinamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Treinamentos_items", selectedTreinamentosCollection);
        }
        return "/app/treinamentos/index";
    }

    public boolean getIsTagEstacionamentoCollectionEmpty() {
        return this.isTagEstacionamentoCollectionEmpty;
    }

    private void setIsTagEstacionamentoCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isTagEstacionamentoCollectionEmpty = ejbFacade.isTagEstacionamentoCollectionEmpty(selected);
        } else {
            this.isTagEstacionamentoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TagEstacionamento
     * entities that are retrieved from UorPos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TagEstacionamento page
     */
    public String navigateTagEstacionamentoCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<TagEstacionamento> selectedTagEstacionamentoCollection = ejbFacade.findTagEstacionamentoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TagEstacionamento_items", selectedTagEstacionamentoCollection);
        }
        return "/app/tagEstacionamento/index";
    }

    public boolean getIsCartaoCorporativoCollectionEmpty() {
        return this.isCartaoCorporativoCollectionEmpty;
    }

    private void setIsCartaoCorporativoCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isCartaoCorporativoCollectionEmpty = ejbFacade.isCartaoCorporativoCollectionEmpty(selected);
        } else {
            this.isCartaoCorporativoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CartaoCorporativo
     * entities that are retrieved from UorPos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CartaoCorporativo page
     */
    public String navigateCartaoCorporativoCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<CartaoCorporativo> selectedCartaoCorporativoCollection = ejbFacade.findCartaoCorporativoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CartaoCorporativo_items", selectedCartaoCorporativoCollection);
        }
        return "/app/cartaoCorporativo/index";
    }

    /**
     * Sets the "selected" attribute of the NivelAcesso controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNivelAcesso(ActionEvent event) {
        UorPos selected = this.getSelected();
        if (selected != null && nivelAcessoController.getSelected() == null) {
            nivelAcessoController.setSelected(selected.getNivelAcesso());
        }
    }

    public boolean getIsMqpInitCollectionEmpty() {
        return this.isMqpInitCollectionEmpty;
    }

    private void setIsMqpInitCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isMqpInitCollectionEmpty = ejbFacade.isMqpInitCollectionEmpty(selected);
        } else {
            this.isMqpInitCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MqpInit entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for MqpInit page
     */
    public String navigateMqpInitCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<MqpInit> selectedMqpInitCollection = ejbFacade.findMqpInitCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MqpInit_items", selectedMqpInitCollection);
        }
        return "/app/mqpInit/index";
    }

    public boolean getIsMqpInitCollection1Empty() {
        return this.isMqpInitCollection1Empty;
    }

    private void setIsMqpInitCollection1Empty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isMqpInitCollection1Empty = ejbFacade.isMqpInitCollection1Empty(selected);
        } else {
            this.isMqpInitCollection1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MqpInit entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for MqpInit page
     */
    public String navigateMqpInitCollection1() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<MqpInit> selectedMqpInitCollection1 = ejbFacade.findMqpInitCollection1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MqpInit_items", selectedMqpInitCollection1);
        }
        return "/app/mqpInit/index";
    }

    public boolean getIsEquipamentosCollectionEmpty() {
        return this.isEquipamentosCollectionEmpty;
    }

    private void setIsEquipamentosCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isEquipamentosCollectionEmpty = ejbFacade.isEquipamentosCollectionEmpty(selected);
        } else {
            this.isEquipamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipamentos entities
     * that are retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Equipamentos page
     */
    public String navigateEquipamentosCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Equipamentos> selectedEquipamentosCollection = ejbFacade.findEquipamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipamentos_items", selectedEquipamentosCollection);
        }
        return "/app/equipamentos/index";
    }

    public boolean getIsCartaoMultibeneficiosCollectionEmpty() {
        return this.isCartaoMultibeneficiosCollectionEmpty;
    }

    private void setIsCartaoMultibeneficiosCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isCartaoMultibeneficiosCollectionEmpty = ejbFacade.isCartaoMultibeneficiosCollectionEmpty(selected);
        } else {
            this.isCartaoMultibeneficiosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CartaoMultibeneficios
     * entities that are retrieved from UorPos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CartaoMultibeneficios page
     */
    public String navigateCartaoMultibeneficiosCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<CartaoMultibeneficios> selectedCartaoMultibeneficiosCollection = ejbFacade.findCartaoMultibeneficiosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CartaoMultibeneficios_items", selectedCartaoMultibeneficiosCollection);
        }
        return "/app/cartaoMultibeneficios/index";
    }

    public boolean getIsMqpCollectionEmpty() {
        return this.isMqpCollectionEmpty;
    }

    private void setIsMqpCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isMqpCollectionEmpty = ejbFacade.isMqpCollectionEmpty(selected);
        } else {
            this.isMqpCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection = ejbFacade.findMqpCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection);
        }
        return "/app/mqp/index";
    }

    public boolean getIsMqpCollection1Empty() {
        return this.isMqpCollection1Empty;
    }

    private void setIsMqpCollection1Empty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isMqpCollection1Empty = ejbFacade.isMqpCollection1Empty(selected);
        } else {
            this.isMqpCollection1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Mqp entities that are
     * retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Mqp page
     */
    public String navigateMqpCollection1() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Mqp> selectedMqpCollection1 = ejbFacade.findMqpCollection1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mqp_items", selectedMqpCollection1);
        }
        return "/app/mqp/index";
    }

    public boolean getIsServicosCollectionEmpty() {
        return this.isServicosCollectionEmpty;
    }

    private void setIsServicosCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isServicosCollectionEmpty = ejbFacade.isServicosCollectionEmpty(selected);
        } else {
            this.isServicosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Servicos entities that
     * are retrieved from UorPos and returns the navigation outcome.
     *
     * @return navigation outcome for Servicos page
     */
    public String navigateServicosCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<Servicos> selectedServicosCollection = ejbFacade.findServicosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicos_items", selectedServicosCollection);
        }
        return "/app/servicos/index";
    }

    public boolean getIsPrestacaoDeContasCollectionEmpty() {
        return this.isPrestacaoDeContasCollectionEmpty;
    }

    private void setIsPrestacaoDeContasCollectionEmpty() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            this.isPrestacaoDeContasCollectionEmpty = ejbFacade.isPrestacaoDeContasCollectionEmpty(selected);
        } else {
            this.isPrestacaoDeContasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of PrestacaoDeContas
     * entities that are retrieved from UorPos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PrestacaoDeContas page
     */
    public String navigatePrestacaoDeContasCollection() {
        UorPos selected = this.getSelected();
        if (selected != null) {
            UorPosFacade ejbFacade = (UorPosFacade) this.getFacade();
            Collection<PrestacaoDeContas> selectedPrestacaoDeContasCollection = ejbFacade.findPrestacaoDeContasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PrestacaoDeContas_items", selectedPrestacaoDeContasCollection);
        }
        return "/app/prestacaoDeContas/index";
    }

}
