<%@page import="java.awt.Toolkit"%>
<%@page import="java.awt.Dimension"%>
<%@page language="java" import="java.sql.*,java.lang.*,java.util.*,java.text.*,br.com.bb.customizacao.vos.UsuarioVO"%>

<%
    String nome = (String) session.getAttribute("nome");
    String chave = (String) session.getAttribute("chave");
    String acessos = (String) session.getAttribute("acessos");
    String codCargo = (String) session.getAttribute("codCargo");
    String codDependencia = (String) session.getAttribute("codDependencia");
    String codInstituicao = (String) session.getAttribute("codInstituicao");
    String codDiretoria = (String) session.getAttribute("codDiretoria");
    String grupamento = (String) session.getAttribute("grupamento");
    String pilar = (String) session.getAttribute("pilar");
    String uf = (String) session.getAttribute("uf");
    String tipoDependencia = (String) session.getAttribute("tipoDependencia");
    String superEstadual = (String) session.getAttribute("superEstadual");
    Timestamp timestampLogin = (Timestamp) session.getAttribute("timestampLogin");
    String nomeReduzido = (String) session.getAttribute("nomeReduzido");
    String rf = (String) session.getAttribute("rf");
    String ip = (String) session.getAttribute("ip");
    String idSessao = (String) session.getAttribute("idSessao");
    String idLink = (String) session.getAttribute("idLink");
    String nomeBrowser = (String) session.getAttribute("nomeBrowser");
    String uorPos = (String) session.getAttribute("uorPos");
    //UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuarioVO");
    //------Verifica se tem um Usuário logado
    if (session.getAttribute("usuarioVO") == null) {
        response.sendRedirect("/mqp/login?pag=" + request.getRequestURL());%>
k<%=request.getContextPath()%><br/>
<%=request.getPathInfo()%><br/>   
<%=request.getRequestURI()%><br/>
<%=request.getRequestURL()%><br/>
<%=request.getRemoteHost()%><br/>                  

<%} else {
%>

<%= ("Session attributes:")%><br /><br />
<%= ("nome: ") + nome%><br/>
<%= ("chave: ") + chave%><br/>        
<%= ("acessos: ") + acessos%><br/>
<%= ("codCargo: ") + codCargo%><br/>
<%= ("codDependencia: ") + codDependencia%><br/>
<%= ("codInstituicao: ") + codInstituicao%><br/>
<%= ("codDiretoria: ") + codDiretoria%><br/>
<%= ("grupamento: ") + grupamento%><br/>
<%= ("pilar: ") + pilar%><br/>
<%= ("uf: ") + uf%><br/>
<%= ("tipoDependencia: ") + tipoDependencia%><br/>
<%= ("superEstadual: ") + superEstadual%><br/>
<%= ("timestampLogin: ") + timestampLogin%><br/>
<%= ("nomeReduzido: ") + nomeReduzido%><br/>
<%= ("rf: ") + rf%><br/>
<%= ("ip: ") + ip%><br/>
<%= ("idSessao: ") + idSessao%><br/>
<%= ("idLink: ") + idLink%><br/>
<%= ("nomeBrowser: ") + nomeBrowser%><br/>
<%= ("uorPos: ") + uorPos%><br/>
<br>
<%= ("request.getContextPath(): ") + request.getContextPath()%><br/>
<%=("request.getPathInfo(): ") + request.getPathInfo()%><br/>   
<%=("request.getRequestURI(): ") + request.getRequestURI()%><br/>
<%=("request.getRequestURL(): ") + request.getRequestURL()%><br/>
<%=("request.getRemoteHost(): ") + request.getRemoteHost()%><br/>                  



<% String browser = request.getHeader("User-Agent");
    if (browser.indexOf("MSIE") > 0) {
        response.sendRedirect("/mqp/errors/ieSucks.html");
    } else {
        response.sendRedirect("/mqp/index.jsf");
    }%>
<br/> 

<a href="/servlet/br.com.bb.customizacao.servlets.ServletEncerraSessao?paginaInicialSistema=https://geadesp.intranet.bb.com.br/mqp" >Sair</a>

<%}%>
