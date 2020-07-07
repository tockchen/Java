package work.ccpw.mapper;

import org.apache.ibatis.annotations.Select;
import work.ccpw.domain.Role;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-07 15:12
 **/
public interface RoleMapper {

    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{id}")
    public List<Role> findByUid(int id);
}
