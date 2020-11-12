/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
package br.com.bb.uop.geadesp.mqp.servlets;

import br.com.bb.customizacao.util.IntranetAutenticacao;
import br.com.bb.customizacao.vos.UsuarioVO;
import br.com.bb.uop.geadesp.mqp.dao.DaoLogin;
import br.com.bb.uop.geadesp.mqp.usuarioVO.BeanUsuarioVO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author f6750699
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        String requisicao = request.getParameter("pag");

        int ferramenta = 16; //String url = request.getContextPath();
        String nomeBrowser = request.getHeader("User-Agent");

        IntranetAutenticacao intranetAutenticacao = new IntranetAutenticacao();
        //ServletUsuariosLogados s = new ServletUsuariosLogados();
        //GerenciadorUsuarios g = new GerenciadorUsuarios();
        if (!intranetAutenticacao.isAutenticado(request, response)) {
            response.sendRedirect(intranetAutenticacao.urlPaginaLogin);
        }

        UsuarioVO usuarioVO = intranetAutenticacao.usuarioVO;

        if (intranetAutenticacao.isAutenticado(request, response, requisicao, requisicao)) {

            BeanUsuarioVO beanUsuarioVO = new BeanUsuarioVO();

            //AlimentaBeanLogin res = new AlimentaBeanLogin();
            DaoLogin dao = new DaoLogin();
            //Alimenta bean login para consultas de demais informacoes
            beanUsuarioVO.setId(usuarioVO.getId());
            beanUsuarioVO.setNome(usuarioVO.getNome());
            beanUsuarioVO.setChave(usuarioVO.getChave());
            beanUsuarioVO.setAcessos(usuarioVO.getAcessos());
            beanUsuarioVO.setCodCargo(usuarioVO.getCodCargo());
            beanUsuarioVO.setCodDependencia(usuarioVO.getCodDependencia());
            beanUsuarioVO.setCodInstituicao(usuarioVO.getCodInstituicao());
            beanUsuarioVO.setCodDiretoria(usuarioVO.getCodDiretoria());
            beanUsuarioVO.setGrupamento(usuarioVO.getGrupamento());
            beanUsuarioVO.setPilar(usuarioVO.getPilar());
            beanUsuarioVO.setUf(usuarioVO.getUf());
            beanUsuarioVO.setTipoDependencia(usuarioVO.getTipoDependencia());
            beanUsuarioVO.setSuperEstadual(usuarioVO.getSuperEstadual());
            beanUsuarioVO.setTimestampLogin(usuarioVO.getTimestampLogin());
            beanUsuarioVO.setNomeReduzido(usuarioVO.getNomeReduzido());
            beanUsuarioVO.setRf(usuarioVO.getRf());
            beanUsuarioVO.setIp(usuarioVO.getIp());
            beanUsuarioVO.setIdSessao(request.getSession().getId());
            beanUsuarioVO.setIdLink(String.valueOf(ferramenta));
            beanUsuarioVO.setNomeBrowser(nomeBrowser);
            dao.LoadUorPos(beanUsuarioVO);
            beanUsuarioVO.setUorPos(beanUsuarioVO.getUorPos());
            beanUsuarioVO.setNomeUorPos(beanUsuarioVO.getNomeUorPos());
            beanUsuarioVO.setNivelAcesso(beanUsuarioVO.getNivelAcesso());
            //System.out.print("++++++++++++++++++++++ beanUsuarioVO.getNomeUorPos(): " + beanUsuarioVO.getNomeUorPos());
            //dao.AlimentaDadosFunci(b_login); --> find a way to get uorPos...
            dao.GravaAcesso(beanUsuarioVO);

            // Alimenta variaveis de sessao
            request.getSession().setAttribute("id", beanUsuarioVO.getId());
            request.getSession().setAttribute("nome", beanUsuarioVO.getNome());
            request.getSession().setAttribute("chave", beanUsuarioVO.getChave());
            request.getSession().setAttribute("acessos", beanUsuarioVO.getAcessos());
            request.getSession().setAttribute("codCargo", beanUsuarioVO.getCodCargo());
            request.getSession().setAttribute("codDependencia", beanUsuarioVO.getCodDependencia());
            request.getSession().setAttribute("codInstituicao", beanUsuarioVO.getCodInstituicao());
            request.getSession().setAttribute("codDiretoria", beanUsuarioVO.getCodDiretoria());
            request.getSession().setAttribute("grupamento", beanUsuarioVO.getGrupamento());
            request.getSession().setAttribute("pilar", beanUsuarioVO.getPilar());
            request.getSession().setAttribute("uf", beanUsuarioVO.getUf());
            request.getSession().setAttribute("tipoDependencia", beanUsuarioVO.getTipoDependencia());
            request.getSession().setAttribute("superEstadual", beanUsuarioVO.getSuperEstadual());
            request.getSession().setAttribute("timestampLogin", beanUsuarioVO.getTimestampLogin());
            request.getSession().setAttribute("nomeReduzido", beanUsuarioVO.getNomeReduzido());
            request.getSession().setAttribute("rf", beanUsuarioVO.getRf());
            request.getSession().setAttribute("ip", beanUsuarioVO.getIp());
            request.getSession().setAttribute("idSessao", beanUsuarioVO.getIdSessao());
            request.getSession().setAttribute("idLink", beanUsuarioVO.getIdLink());
            request.getSession().setAttribute("nomeBrowser", beanUsuarioVO.getNomeBrowser());
            request.getSession().setAttribute("uorPos", beanUsuarioVO.getUorPos());
            request.getSession().setAttribute("nomeUorPos", beanUsuarioVO.getNomeUorPos());
            request.getSession().setAttribute("usuarioVO", beanUsuarioVO);
            request.getSession().setAttribute("nivelAcesso", beanUsuarioVO.getNivelAcesso());
            response.sendRedirect(requisicao);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para login...";
    }
}
