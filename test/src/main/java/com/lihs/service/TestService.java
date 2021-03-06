package com.lihs.service;

import com.lihs.entity.TestEntity;

import java.util.List;

/**
 * @author hsli
 * @Date 2018/6/21 14:10:52
 */
public interface TestService {

    public List<TestEntity> list() throws Exception;

    public TestEntity get(TestEntity testEntity) throws Exception;

    public int add(TestEntity testEntity) throws Exception;

    public int delete(TestEntity testEntity) throws Exception;
}
