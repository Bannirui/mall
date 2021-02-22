package com.example.mall.user.dal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.user.dal.mapper.MemberMapper;
import com.example.mall.user.dal.model.Member;
import com.example.mall.user.dal.service.MemberDalService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dingrui
 * @since 2021-02-20
 */
@Service
public class MemberDalServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberDalService {

}
