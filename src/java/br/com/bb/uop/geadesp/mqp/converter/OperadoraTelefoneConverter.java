package br.com.bb.uop.geadesp.mqp.converter;

import br.com.bb.uop.geadesp.mqp.entities.OperadoraTelefone;
import br.com.bb.uop.geadesp.mqp.facade.OperadoraTelefoneFacade;
import br.com.bb.uop.geadesp.mqp.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "operadoraTelefoneConverter")
public class OperadoraTelefoneConverter implements Converter {

    private OperadoraTelefoneFacade ejbFacade;

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
        if (object instanceof OperadoraTelefone) {
            OperadoraTelefone o = (OperadoraTelefone) object;
            return getStringKey(o.getIdOperadora());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OperadoraTelefone.class.getName()});
            return null;
        }
    }

    private OperadoraTelefoneFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(OperadoraTelefoneFacade.class).get();
        return this.ejbFacade;
    }
}
