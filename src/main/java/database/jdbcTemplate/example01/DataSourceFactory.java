package database.jdbcTemplate.example01;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public final class DataSourceFactory {

  public static DataSource dataSourceFor(String poolName) {
    HikariConfig dataConfig = new HikariConfig();

    dataConfig.setUsername("postgres");
    dataConfig.setPassword("docker");
    dataConfig.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
    dataConfig.addDataSourceProperty("URL", "jdbc:postgresql://127.0.0.1:5432/starwarslocal");
    dataConfig.setPoolName(poolName);
    dataConfig.setAutoCommit(true);

    dataConfig.setMaximumPoolSize(1);

    return new HikariDataSource(dataConfig);
  }

  private DataSourceFactory() {
  }
}