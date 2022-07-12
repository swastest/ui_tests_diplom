package connectBD;

import config.ConfigurationCenter;
import config.DataBaseInterface;
import org.aeonbits.owner.ConfigFactory;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public enum DataSourceProvider {
    INSTANCE;

    private PGSimpleDataSource dataSource;

    public DataSource getDataSource() {
        if (dataSource == null){
            dataSource = new PGSimpleDataSource();
            dataSource.setServerName(ConfigurationCenter.configBD.serverName());
            dataSource.setPortNumber(ConfigurationCenter.configBD.portNumber());
            dataSource.setUser(ConfigurationCenter.configBD.user());
            dataSource.setDatabaseName(ConfigurationCenter.configBD.databaseName());
            dataSource.setPassword(ConfigurationCenter.configBD.password());
        }
        return dataSource;
    }
}
