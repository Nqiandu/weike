package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {

    List<User> selectAll(User user, RowBounds rowBounds);
    List<User> selechar();
    int insertUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    int count(User user);
    User selectbyid(int id);
    int shrz(User user);
    List<User> selectByUserid(int user_id);

    int updatemoney(@Param("userid")Integer userid,@Param("money") Double money);

}
