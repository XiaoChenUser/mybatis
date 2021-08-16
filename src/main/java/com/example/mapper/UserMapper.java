package com.example.mapper;

import com.example.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper {
    int insert(UserDTO user);

    int updateById(UserDTO user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    UserDTO selectById(@Param("id") Integer id);

    UserDTO selectByUsername(@Param("username") String username);

    List<UserDTO> selectByIds(@Param("ids") Collection<Integer> ids);

}
