package com.example.mall.user.dal.service.impl;

import com.example.mall.user.dal.model.Address;
import com.example.mall.user.dal.mapper.AddressMapper;
import com.example.mall.user.dal.service.AddressDalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址表 服务实现类
 * </p>
 *
 * @author dingrui
 * @since 2021-02-23
 */
@Service
public class AddressDalServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressDalService {

}
