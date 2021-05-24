package cn.kgc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * 工具类：读懂、会应用
 * 1.加载配置文件 注册驱动  获取数据库连接
 * 2.释放JDBC的核心对象
 */
public class JdbcUtils {
    //新增一行代码，获取一个C3P0数据库连接池对象即可
//    private DataSource  myDataSource=new ComboPooledDataSource("oracle-config");
    private static final DataSource  myDataSource=new ComboPooledDataSource();//默认读取default-config

    /**
     * 获取数据库连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return myDataSource;
    }
}
