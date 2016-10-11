package com.cj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cj.dao.UserMapper;
import com.cj.po.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> getUserInfo() {
		return userMapper.findUserInfo();
	}

	public User getUserInfoById(@Param("id") Long id) {
		return userMapper.findUserInfoById(id);
	}

	@SuppressWarnings("rawtypes")
	public Page getUserInfoByPage() {
		// 获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(1, 10);
		List<User> list = userMapper.findUserInfo();
		System.out.println(list.get(0).getId());
	    System.out.println(list.size());
	    //分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，
	    //或者使用PageInfo类（下面的例子有介绍）
	    System.out.println(((Page) list).getTotal());
	    return ((Page) list);
	}
}
