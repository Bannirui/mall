package com.example.mall;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author dingrui
 * @date 2021-02-20
 * @description mybatis代码生成器
 */
public class SqlGeneratorUtil {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 输出文件路径
        gc.setOutputDir(System.getProperty("user.dir"));
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        // 作者
        gc.setAuthor("dingrui");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sDalController");
        gc.setServiceName("%sDalService");
        gc.setServiceImplName("%sDalServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("19920308");
        dsc.setUrl("jdbc:mysql://localhost:3306/mall?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        strategy.setSuperServiceClass("");
        strategy.setSuperServiceImplClass("");
        strategy.setSuperMapperClass("");
        strategy.setInclude("comment,comment_picture,comment_reply".split(","));

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.mall.user");
        pc.setController("controller");
        pc.setService("dal.service");
        pc.setServiceImpl("dal.service.impl");
        pc.setMapper("dal.mapper");
        pc.setEntity("dal.model");
        pc.setXml("dal.mapper");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }
}
