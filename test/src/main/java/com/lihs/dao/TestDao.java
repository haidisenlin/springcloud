package com.lihs.dao;

import com.lihs.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hsli
 * @Date 2018/6/21 14:08:10
 */
public interface TestDao{

    public List<TestEntity> list() throws Exception;

    public TestEntity get(TestEntity testEntity) throws Exception;

    public int add(TestEntity testEntity) throws Exception;

    public int delete(TestEntity testEntity) throws Exception;


}
