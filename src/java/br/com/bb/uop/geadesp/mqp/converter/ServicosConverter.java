package br.com.bb.uop.geadesp.mqp.converter;

import br.com.bb.uop.geadesp.mqp.entities.Servicos;
import br.com.bb.uop.geadesp.mqp.facade.ServicosFacade;
import br.com.bb.uop.geadesp.mqp.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "servicosConverter")
public class ServicosConverter implements Converter {

    private ServicosFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Servicos) {
            Servicos o = (Servicos) object;
            return getStringKey(o.getIdServico());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Servicos.class.getName()});
            return null;
        }
    }

    private ServicosFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(ServicosFacade.class).get();
        return this.ejbFacade;
    }
}