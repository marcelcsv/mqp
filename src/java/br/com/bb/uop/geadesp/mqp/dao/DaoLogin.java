/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
package br.com.bb.uop.geadesp.mqp.dao;

import br.com.bb.uop.geadesp.mqp.usuarioVO.BeanUsuarioVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f6750699
 */
public class DaoLogin {

    public boolean GravaAcesso(BeanUsuarioVO beanUsuarioVO) {
        PreparedStatement state;

        boolean ok = false;

        try {

            state = FactoryConnection_SQL_SERVER.getConnection("LOGS").prepareStatement("insert into ace.Acessos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            state.setString(1, beanUsuarioVO.getId());
            state.setString(2, beanUsuarioVO.getNome());
            state.setString(3, beanUsuarioVO.getChave());
            state.setString(4, beanUsuarioVO.getAcessos() + "#MQP" + beanUsuarioVO.getNivelAcesso());
            state.setString(5, beanUsuarioVO.getCodCargo());
            state.setString(6, beanUsuarioVO.getCodDependencia());
            state.setString(7, beanUsuarioVO.getCodInstituicao());
            state.setString(8, beanUsuarioVO.getCodDiretoria());
            state.setString(9, beanUsuarioVO.getGrupamento());
            state.setString(10, beanUsuarioVO.getPilar());
            state.setString(11, beanUsuarioVO.getUf());
            state.setString(12, beanUsuarioVO.getTipoDependencia());
            state.setString(13, beanUsuarioVO.getSuperEstadual());
            state.setTimestamp(14, beanUsuarioVO.getTimestampLogin());
            state.setString(15, beanUsuarioVO.getNomeReduzido());
            state.setString(16, beanUsuarioVO.getRf());
            state.setString(17, beanUsuarioVO.getIp());
            state.setString(18, beanUsuarioVO.getIdSessao());
            state.setString(19, beanUsuarioVO.getIdLink());
            state.setString(20, beanUsuarioVO.getNomeBrowser());
            state.setString(21, beanUsuarioVO.getUorPos());

            ok = !state.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;

    }

    public BeanUsuarioVO LoadUorPos(BeanUsuarioVO beanUsuarioVO) {
        PreparedStatement state = null;
        PreparedStatement stateNivelAcesso = null;
        PreparedStatement stateUorPos = null;

        ResultSet rs = null;
        ResultSet rsNivelAcesso = null;
        ResultSet rsUorPos = null;

        try {
            state = FactoryConnection_SQL_SERVER.getConnection("DIAGE").prepareStatement(
                    "SELECT nomeUorPos FROM DIAGE.mqp.UorPos WHERE (matricula = ?)");
            stateNivelAcesso = FactoryConnection_SQL_SERVER.getConnection("DIAGE").prepareStatement(
                    "SELECT nivelAcesso FROM DIAGE.mqp.UorPos WHERE (matricula = ?)");
            stateUorPos = FactoryConnection_SQL_SERVER.getConnection("DIAGE").prepareStatement(
                    "SELECT uorPos FROM DIAGE.mqp.UorPos WHERE (matricula = ?)");

            state.setString(1, beanUsuarioVO.getChave());
            stateNivelAcesso.setString(1, beanUsuarioVO.getChave());
            stateUorPos.setString(1, beanUsuarioVO.getChave());

            rs = state.executeQuery();
            rsNivelAcesso = stateNivelAcesso.executeQuery();
            rsUorPos = stateUorPos.executeQuery();

            while (rs.next()) {
                beanUsuarioVO.setNomeUorPos(rs.getString("nomeUorPos"));
            }

            while (rsNivelAcesso.next()) {
                beanUsuarioVO.setNivelAcesso(rsNivelAcesso.getString("nivelAcesso"));
            }

            while (rsUorPos.next()) {
                beanUsuarioVO.setUorPos(rsUorPos.getString("uorPos"));
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        } finally {
            try {
                FactoryConnection_SQL_SERVER.getConnection("DIAGE").close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
            }
            try {
                state.close();
                stateNivelAcesso.close();
                stateUorPos.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
            }
        }
        return beanUsuarioVO;
    }

}
