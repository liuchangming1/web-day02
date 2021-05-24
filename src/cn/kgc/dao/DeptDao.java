package cn.kgc.dao;

import cn.kgc.domain.Dept;

import java.util.List;

/**
 * 使用jdbc处理CRUD
 */
public interface DeptDao {
    /**
     * 添加：新增一行数据，对应java中一个对象
     */
    public abstract void insert(Dept dept);

    public abstract void update(Dept dept);

    /**
     * 根据主键删除
     * @param deptNo 部门编号
     */
    public abstract void delete(int deptNo);

    /**
     * 查询所有部门信息
     * @return 保存了部门信息的List
     */
    public abstract List<Dept> selectAll();


}
