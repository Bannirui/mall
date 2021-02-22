package com.example.mall.user.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.user.dal.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 数据库测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testMemberMapper() {
        List<Member> members = memberMapper.selectList(new LambdaQueryWrapper<Member>());
        System.out.println();
    }
}