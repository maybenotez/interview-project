package com.win.app.pool;

import java.sql.Connection;

public interface DataSourcePool {

    /**
     * 获取连接
     * @return
     */
    Connection getConnection();

    /**
     * 关闭连接
     * @param connection
     */
    void close(Connection connection);
}
