package com.gmcc.autotest.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.skyfront.util.Crypto;

public class ConnectionPool {
    private DataSource ds;

    private static ConnectionPool mySelf;

    private ConnectionPool(DataSource ds) {
        this.ds = ds;
    }

    private static void init(DataSource ds) {
        mySelf = new ConnectionPool(ds);
    }

    public static ConnectionPool getInstance() {
            if (mySelf == null) {
                ConnectionPool.init();
            }

            return mySelf;
    }

    private static void init()  {
        	BasicDataSource ds = new BasicDataSource();
        	ds.setRemoveAbandoned(true);
        	ds.setMaxWait(1000*60*60*8);
        	ds.setValidationQuery("select 1");
        	ds.setDriverClassName(DbSet.driverClass);
            ds.setUrl(DbSet.url);
            ds.setMaxActive(Integer.parseInt(DbSet.maxCount));
//            ds.setDefaultAutoCommit(true);
//            String pwd=new String(Crypto.decrypt(Crypto.parseHexStr2Byte(DbSet.passwd), Crypto.class.toString()));
            String pwd= DbSet.passwd;
            ds.setPassword(pwd);
            ds.setUsername(DbSet.user);
            ConnectionPool.init(ds);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}