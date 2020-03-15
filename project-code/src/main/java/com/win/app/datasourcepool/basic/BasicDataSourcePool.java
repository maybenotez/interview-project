package com.win.app.datasourcepool.basic;

import com.win.app.datasourcepool.DataSourcePool;
import com.win.app.datasourcepool.source.DataSource;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BasicDataSourcePool implements DataSourcePool {

    private final List<Connection> connectionList;

    private final int size;


    public BasicDataSourcePool(int size) {
        this.connectionList = new ArrayList<>();
        this.size = size;
    }

    @Override
    public Connection getConnection() {
        if (connectionList.size() > 0) {
            return connectionList.get(0);
        }
        return DataSource.getConnection();
    }

    @Override
    public void close(Connection connection) {
        if (connectionList.size() < size) {
            connectionList.add(connection);
        }else {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
