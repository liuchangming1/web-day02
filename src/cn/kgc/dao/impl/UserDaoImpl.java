package cn.kgc.dao.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.domain.User;
import cn.kgc.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用JDBC技术：找DBUtils
 */
public class UserDaoImpl implements UserDao {
    //1.执行语句的对象,自己找数据库连接
    QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public int insert(User user) {
        //2.定义sql
        String sql="insert user values(?,?,?);";
        int row = 0;
        try {
            //3.执行sql,一定要问问自己：你这代码如果执行成功，插入的是什么对象呢？？
            row = qr.update(sql,user.getuId(),user.getUserName(),user.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    @Override
    public int update(User user) {
        String sql="UPDATE `user` SET username =?,`PASSWORD` =? WHERE uid =?;";
        try {
            return qr.update(sql,user.getUserName(),user.getPassword(),user.getuId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(String uId) {
        String sql="DELETE FROM `user` WHERE uid = ?;";
        try {
            return qr.update(sql,uId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> selectAll() {
        String sql="SELECT uid, username, `PASSWORD` FROM `user`";
        try {
            //执行select语句，指定ResultSet转换的目标是List<User>类型？
//            BeanListHandler<User> handler=new BeanListHandler<>(User.class);
            return qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectBy(String userName, String password) {
        String sql="SELECT uid, username, `PASSWORD` FROM `user` WHERE username=? AND `password`=?";
        try {
            return  qr.query(sql, new BeanHandler<>(User.class), userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long selectCount() {
        String sql="SELECT COUNT(*) FROM `user`";
        long count=0;
        try {
            Object obj = qr.query(sql, new ScalarHandler<>());//ScalarHandler将集合函数的运算结果转换
            if(obj instanceof Number){
                Number number=(Number)obj;
                count= number.longValue();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
