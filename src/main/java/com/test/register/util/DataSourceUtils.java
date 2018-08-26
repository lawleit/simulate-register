package com.test.register.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 操纵数据源工具类
 * @author zhiqiang.liu02
 *
 */
public class DataSourceUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	/**
	 * 获取数据源
	 * 
	 * @return DataSource 数据源
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 释放资源
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void closeResource(Connection con, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(con);
	}

	/**
	 * 获取连接
	 * 
	 * @return Connection 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 释放连接
	 * 
	 * @param con 连接
	 */
	public static void closeConnection(Connection con) {
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con = null;
			}
		}
	}

	/**
	 * 释放语句执行
	 * @param st 语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (null != st) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
	}
	
	/**
	 * 释放结果集
	 * @param rs 结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs=null;
			}
		}
	}

}
