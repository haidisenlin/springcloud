package com.lihs.dao;

import com.lihs.entity.TestEntity;
import com.lihs.script.TestSql;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

/**
 * @author hsli
 * @Date 2018/6/21 14:08:10
 */
public interface TestDao{

    //@SelectProvider(type = TestSql.class,method = "getSelect")
    @Select("select * from TEST")
    public List<TestEntity> list() throws Exception;

    public TestEntity get(TestEntity testEntity) throws Exception;

    public int add(TestEntity testEntity) throws Exception;

    public int delete(TestEntity testEntity) throws Exception;


}
