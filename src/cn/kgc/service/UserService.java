package cn.kgc.service;

import cn.kgc.domain.User;

import java.util.List;

/**
 * 业务逻辑层：方法名应该是用户提供的业务需求
 * 调用对应表的DAO的方法，简单粗暴理解：方法与dao层一样的
 * service层：编写流程控制语句来实现dao有逻辑的调用
 */
public interface UserService {
    /**
     * 注册功能
     * @param user 要注册的用户信息
     * @return true:注册功能成功 false：注册功能失败
     */
    boolean register(User user);

    /**
     * 更新用户信息
     * @param user 修改后的用户信息
     */
    void edit(User user);

    /**
     * 根据主键uid删除唯一一个用户信息
     * @param uId 要删除的用户编号
     * @return 删除的行数
     */
    void logout(String uId);

    /**
     * 查询全部
     * @return user表的所有的用户信息
     */
    List<User> findAll();

    /**
     * 返回单个对象：对应数据库术语：查询结果是单行多列请查看
     * @param userName
     * @param password
     * @return
     */
    boolean login(String userName, String password);

    /**
     * 查询count()聚合运算结果
     * @return count()计算结果
     */
    Long getUserCount();
}
