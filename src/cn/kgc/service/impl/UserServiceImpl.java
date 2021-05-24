package cn.kgc.service.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.domain.User;
import cn.kgc.service.UserService;

import java.util.List;

/**
 * service扮演角色：承担承上启下的功能
 * 乘上：对接html/JSP
 * 启下：对接dao层
 * 代码特点：一定没有jdbc代码
 * 每一个serviceImpl一定会创建一个对应表的dao层对象，每一个方法，
 * 涉及数据库crud一定通过dao的方法实现
 */
public class UserServiceImpl implements UserService {
    UserDao dao=new UserDaoImpl();
    @Override
    public boolean register(User user) {
        int row = dao.insert(user);
        return row==1;
    }

    @Override
    public void edit(User user) {
        dao.update(user);
    }

    @Override
    public void logout(String uId) {
        dao.delete(uId);
    }

    @Override
    public List<User> findAll() {
        return dao.selectAll();
    }

    @Override
    public boolean login(String userName, String password) {
        return dao.selectBy(userName,password)!=null;
    }

    @Override
    public Long getUserCount() {
        return dao.selectCount();
    }
}
