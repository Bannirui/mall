package com.example.mall.user.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.user.dal.model.UserVerify;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户验证表 Mapper 接口
 * </p>
 *
 * @author dingrui
 * @since 2021-02-20
 */
@Mapper
public interface UserVerifyMapper extends BaseMapper<UserVerify> {

}
