package cn.kgc.dao;

import cn.kgc.domain.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * 保存对象
     * @param e 要添加的员工信息
     * @return 添加语句受影响的行数
     */
    int insert(Emp e);

    /**
     * 修改员工信息
     * @param e 修改后的员工信息
     * @return 修改语句受影响的行数
     */
    int update(Emp e);

    /**
     * 根据主键empno删除唯一一个员工信息
     * @param empno 要删除的用户编号
     * @return 删除的行数
     */
    int delete(int empno);

    /**
     * 查询全部
     * @return emp表的所有的员工信息
     */
    List<Emp> selectAll();

    /**
     * 支持模糊查询，sql语句时：
     * select * from emp where ename like '%用户条件%' and sal>=minSal and sal<maxsal
     * @param name 员工姓名的模糊查询
     * @param minSal  最低薪资
     * @param maxSal 最高薪资
     * @return 符合条件的员工信息
     */
    List<Emp> selectBy(String name, double minSal, double maxSal);

    /**
     * 根据主键empNo查询唯一的员工对象
     * @param empno
     * @return
     */
    Emp selectByEmpNo(int empno);

    /**
     * 查询count()聚合运算获取员工总数
     * @return count()计算结果
     */
    Long selectCount();
}
