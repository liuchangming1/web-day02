package cn.kgc.dao;

import cn.kgc.domain.User;

import java.util.List;

/**
 * dao：database  access Object
 * 使用技术:JDBC
 */
public interface UserDao {
    /**
     * 保存对象
     * @param user 要添加的用户信息
     * @return 添加语句受影响的行数
     */
    public abstract int insert(User user);

    /**
     * 修改用户信息
     * @param user 修改后的用户信息
     * @return 修改语句受影响的行数
     */
    int update(User user);

    /**
     * 根据主键uid删除唯一一个用户信息
     * @param uId 要删除的用户编号
     * @return 删除的行数
     */
    int delete(String uId);

    /**
     * 查询全部
     * @return user表的所有的用户信息
     */
    List<User> selectAll();

    /**
     * 返回单个对象：对应数据库术语：查询结果是单行多列请查看
     * @param userName
     * @param password
     * @return
     */
    User selectBy(String userName, String password);

    /**
     * 查询count()聚合运算结果
     * @return count()计算结果
     */
    Long selectCount();
}
