package br.com.bb.uop.geadesp.mqp.beans.cdi;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author f6750699
 */
@RequestScoped
public class BeanCDI implements Serializable {

    private final String sessionChave = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("chave");
    private final String sessionComissao = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("codCargo");
    private final String sessionPrefDep = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("codDependencia");
    private final String sessionUorPos = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("uorPos");
    private final String sessionNomeUorPos = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomeUorPos");
    private final String sessionNivelAcesso = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nivelAcesso");

    @Produces
    @SessionChave
    public String SessionChave() {
        return sessionChave;
    }

    @Produces
    @SessionPrefDep
    public String SessionPrefDep() {
        return sessionPrefDep;
    }

    @Produces
    @SessionComissao
    public String SessionComissao() {
        return sessionComissao;
    }

    @Produces
    @SessionUorPos
    public String SessionUorPos() {
        return sessionUorPos;
    }

    @Produces
    @SessionNomeUorPos
    public String SessionNomeUorPos() {
        return sessionNomeUorPos;
    }

    @Produces
    @SessionNivelAcesso
    public String SessionNivelAcesso() {
        return sessionNivelAcesso;
    }

}
