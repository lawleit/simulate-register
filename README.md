# Simulate Register Module By Servlet

## Description

本项目主要通过模拟注册功能模块，来回顾Java Web开发中Servlet。

其中使用c3po作为数据库连接池。使用commons-dbutils、commons-beanutils来装载实体类，同时操作JDBC。

## Required

1. c3p0
2. commons-dbutils
3. commons-beanutils
4. mysql-connector-java

## Resources

>c3p0.properties  
c3p0可以自动解析该文件，并配置到数据源中  
**NOTE:** 属性名和文件名一定要固定，且该文件最后应在classpath下

```properties
c3p0.driverClass=com.mysql.jdbc.Driver
c3p0.jdbcUrl=jdbc:mysql://localhost:3306/simulate
c3p0.user=root
c3p0.password=mypassword
```

## Util

```java
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
```

```java
new ComboPooledDataSource(String configName)
//指定具体配置文件 若配置的名字找不到,使用默认的配置
```

## Reference

1. [C3P0的三种配置方式以及基本配置项详解](https://blog.csdn.net/u012506661/article/details/53548083)
2. [DataSourceUtils（使用C3P0连接池的工具类）](https://www.cnblogs.com/NEWHOM/p/6679272.html#commentform)


