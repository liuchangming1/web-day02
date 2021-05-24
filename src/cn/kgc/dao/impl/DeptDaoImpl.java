package cn.kgc.dao.impl;

import cn.kgc.dao.DeptDao;
import cn.kgc.domain.Dept;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    //1.创建一个Sql语句执行器
    QueryRunner qr=new QueryRunner();

    @Override
    public void insert(Dept dept) {
        //2.定义要执行的sql
        String sql="insert into dept (deptno,dname,loc) values(?,?,?)";
        //3.借助qr提供的方法执行
        /*try {

            qr.update(JdbcUtils.getConnection(),sql,dept.getDeptno(),dept.getDname(),dept.getLoc());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void update(Dept dept) {

    }

    @Override
    public void delete(int deptNo) {

    }

    @Override
    public List<Dept> selectAll() {
        //1.sql
        String sql="select * from dept";

        List<Dept> list = null;
        /*try {
            list = qr.query(JdbcUtils.getConnection(),sql, new BeanListHandler<Dept>(Dept.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        return list;

    }
}
