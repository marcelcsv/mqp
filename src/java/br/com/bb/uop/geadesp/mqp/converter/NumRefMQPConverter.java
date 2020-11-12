package br.com.bb.uop.geadesp.mqp.converter;

import br.com.bb.uop.geadesp.mqp.entities.NumRefMQP;
import br.com.bb.uop.geadesp.mqp.facade.NumRefMQPFacade;
import br.com.bb.uop.geadesp.mqp.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "numRefMQPConverter")
public class NumRefMQPConverter implements Converter {

    private NumRefMQPFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK getKey(String value) {
        br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK();
        key.setNumRef(Integer.parseInt(values[0]));
        key.setIdMQP(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(br.com.bb.uop.geadesp.mqp.entities.NumRefMQPPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getNumRef());
        sb.append(SEPARATOR);
        sb.append(value.getIdMQP());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof NumRefMQP) {
            NumRefMQP o = (NumRefMQP) object;
            return getStringKey(o.getNumRefMQPPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NumRefMQP.class.getName()});
            return null;
        }
    }

    private NumRefMQPFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(NumRefMQPFacade.class).get();
        return this.ejbFacade;
    }
}
