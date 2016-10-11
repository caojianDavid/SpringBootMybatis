package com.cj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cj.po.User;


public interface UserMapper {
	public List<User> findUserInfo();

	@Select("select id,name, age,password from user WHERE id = #{id}")
	public User findUserInfoById(@Param("id") Long id);
}
