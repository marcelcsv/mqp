package br.com.bb.uop.geadesp.mqp.controller;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.facade.NumRefMQPFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "numRefMQPController")
@ViewScoped
public class NumRefMQPController extends AbstractController<NumRefMQP> {

    @Inject
    private CartaoCorporativoController cartaoCorporativoController;
    @Inject
    private CartaoMultibeneficiosController cartaoMultibeneficiosController;
    @Inject
    private CategoriasController categoriaController;
    @Inject
    private EquipamentosController equipamentosController;
    @Inject
    private GdpController gdpController;
    @Inject
    private PrestacaoDeContasController prestacaoDeContasController;
    @Inject
    private ServicosController servicosController;
    @Inject
    private TagEstacionamentoController tagEstacionamentoController;
    @Inject
    private TelefoneController telefoneController;
    @Inject
    private TreinamentosController treinamentosController;

    public NumRefMQPController() {
        // Inform the Abstract parent controller of the concrete NumRefMQP Entity
        super(NumRefMQP.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNumRefMQPPK().setNumRef(this.getSelected().getTreinamentos().getIdTreinamento());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNumRefMQPPK(new br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cartaoCorporativoController.setSelected(null);
        cartaoMultibeneficiosController.setSelected(null);
        categoriaController.setSelected(null);
        equipamentosController.setSelected(null);
        gdpController.setSelected(null);
        prestacaoDeContasController.setSelected(null);
        servicosController.setSelected(null);
        tagEstacionamentoController.setSelected(null);
        telefoneController.setSelected(null);
        treinamentosController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CartaoCorporativo controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCartaoCorporativo(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && cartaoCorporativoController.getSelected() == null) {
            cartaoCorporativoController.setSelected(selected.getCartaoCorporativo());
        }
    }

    /**
     * Sets the "selected" attribute of the CartaoMultibeneficios controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCartaoMultibeneficios(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && cartaoMultibeneficiosController.getSelected() == null) {
            cartaoMultibeneficiosController.setSelected(selected.getCartaoMultibeneficios());
        }
    }

    /**
     * Sets the "selected" attribute of the Categorias controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategoria(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && categoriaController.getSelected() == null) {
            categoriaController.setSelected(selected.getCategoria());
        }
    }

    /**
     * Sets the "selected" attribute of the Equipamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEquipamentos(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && equipamentosController.getSelected() == null) {
            equipamentosController.setSelected(selected.getEquipamentos());
        }
    }

    /**
     * Sets the "selected" attribute of the Gdp controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGdp(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && gdpController.getSelected() == null) {
            gdpController.setSelected(selected.getGdp());
        }
    }

    /**
     * Sets the "selected" attribute of the PrestacaoDeContas controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrestacaoDeContas(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && prestacaoDeContasController.getSelected() == null) {
            prestacaoDeContasController.setSelected(selected.getPrestacaoDeContas());
        }
    }

    /**
     * Sets the "selected" attribute of the Servicos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareServicos(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && servicosController.getSelected() == null) {
            servicosController.setSelected(selected.getServicos());
        }
    }

    /**
     * Sets the "selected" attribute of the TagEstacionamento controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTagEstacionamento(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && tagEstacionamentoController.getSelected() == null) {
            tagEstacionamentoController.setSelected(selected.getTagEstacionamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Telefone controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTelefone(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && telefoneController.getSelected() == null) {
            telefoneController.setSelected(selected.getTelefone());
        }
    }

    /**
     * Sets the "selected" attribute of the Treinamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTreinamentos(ActionEvent event) {
        NumRefMQP selected = this.getSelected();
        if (selected != null && treinamentosController.getSelected() == null) {
            treinamentosController.setSelected(selected.getTreinamentos());
        }
    }

}
