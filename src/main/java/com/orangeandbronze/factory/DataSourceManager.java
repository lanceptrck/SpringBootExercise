package com.orangeandbronze.factory;

import java.io.*;
import java.util.*;
import javax.sql.*;
import org.postgresql.ds.*;

public class DataSourceManager {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
    	if (dataSource == null) {
            Properties prop = new Properties();
            String propFileName = "pg.datasource.properties";
            try (Reader reader = new BufferedReader(
                    new InputStreamReader(
                            DataSourceManager.class.getClassLoader()
                            .getResourceAsStream(propFileName)))) {
                prop.load(reader);
            } catch (IOException e) {
                throw new RuntimeException("problem reading file "
                        + propFileName, e);
            }
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setServerName(prop.getProperty("servername"));
            ds.setDatabaseName(prop.getProperty("database"));
            ds.setUser(prop.getProperty("user"));
            ds.setPassword(prop.getProperty("password"));
            dataSource = ds;
        }
        return dataSource;
    }
}
