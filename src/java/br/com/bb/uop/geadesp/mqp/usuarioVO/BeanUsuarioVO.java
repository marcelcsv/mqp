/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
package br.com.bb.uop.geadesp.mqp.usuarioVO;

import java.sql.Timestamp;

/**
 *
 * @author f6750699
 */
public class BeanUsuarioVO {

    private String id = null;
    private String nome = null;
    private String chave = null;
    private String acessos = null;
    private String codCargo = null;
    private String codDependencia = null;
    private String codInstituicao = null;
    private String codDiretoria = null;
    private String grupamento = null;
    private String pilar = null;
    private String uf = null;
    private String tipoDependencia = null;
    private String superEstadual = null;
    private Timestamp timestampLogin = null;
    private String nomeReduzido = null;
    private String rf = null;
    private String ip = null;
    //not in remote UsuarioVO:
    private String idSessao = null;
    private String idLink = "16";
    private String nomeBrowser = null;
    private String uorPos = null;
    private String nomeUorPos = null;
    private String nivelAcesso = null;

    public String getUorPos() {
        return uorPos;
    }

    public void setUorPos(String uorPos) {
        this.uorPos = uorPos;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getNomeUorPos() {
        return nomeUorPos;
    }

    public void setNomeUorPos(String nomeUorPos) {
        this.nomeUorPos = nomeUorPos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getAcessos() {
        return acessos;
    }

    public void setAcessos(String acessos) {
        this.acessos = acessos;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    public String getCodDependencia() {
        return codDependencia;
    }

    public void setCodDependencia(String codDependencia) {
        this.codDependencia = codDependencia;
    }

    public String getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(String codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    public String getCodDiretoria() {
        return codDiretoria;
    }

    public void setCodDiretoria(String codDiretoria) {
        this.codDiretoria = codDiretoria;
    }

    public String getGrupamento() {
        return grupamento;
    }

    public void setGrupamento(String grupamento) {
        this.grupamento = grupamento;
    }

    public String getPilar() {
        return pilar;
    }

    public void setPilar(String pilar) {
        this.pilar = pilar;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTipoDependencia() {
        return tipoDependencia;
    }

    public void setTipoDependencia(String tipoDependencia) {
        this.tipoDependencia = tipoDependencia;
    }

    public String getSuperEstadual() {
        return superEstadual;
    }

    public void setSuperEstadual(String superEstadual) {
        this.superEstadual = superEstadual;
    }

    public Timestamp getTimestampLogin() {
        return timestampLogin;
    }

    public void setTimestampLogin(Timestamp timestampLogin) {
        this.timestampLogin = timestampLogin;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
    }

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(String idSessao) {
        this.idSessao = idSessao;
    }

    public String getIdLink() {
        return idLink;
    }

    public void setIdLink(String idLink) {
        this.idLink = idLink;
    }

    public String getNomeBrowser() {
        return nomeBrowser;
    }

    public void setNomeBrowser(String nomeBrowser) {
        this.nomeBrowser = nomeBrowser;
    }

}
