/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
package br.com.bb.uop.geadesp.mqp.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author f6750699
 */
public class FactoryConnection_SQL_SERVER {

    public static Connection getConnection(String Bd) throws SQLException {
        Connection Con = null;
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("upb");
            ds.setPassword("");
            ds.setServerName("172.29.14.223");
            ds.setPortNumber(1433);
            ds.setDatabaseName(Bd);
            Con = ds.getConnection();
            return Con;
        } catch (SQLServerException e) {
            throw new SQLException(e.getMessage());

        }
    }
}
