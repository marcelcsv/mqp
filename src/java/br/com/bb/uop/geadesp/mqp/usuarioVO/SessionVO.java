/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
package br.com.bb.uop.geadesp.mqp.usuarioVO;

import br.com.bb.customizacao.gerenciadores.GerenciadorUsuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f6750699
 */
@ManagedBean(name = "usuariosLogados")
@SessionScoped
public class SessionVO implements Serializable {

    private Integer usuariosLogados;

    public Integer getUsuariosLogados() {
        return GerenciadorUsuarios.getInstancia().obterQuantUsuarios();
    }

    public void setUsuariosLogados(Integer usuariosLogados) {
        this.usuariosLogados = usuariosLogados;
    }

    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    //HttpSession session = request.getSession(false);
//        if(session!=null)
//            session.invalidate();
}
