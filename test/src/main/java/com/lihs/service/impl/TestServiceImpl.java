package com.lihs.service.impl;

import com.lihs.dao.TestDao;
import com.lihs.entity.TestEntity;
import com.lihs.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author hsli
 * @Date 2018/6/21 14:11:10
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    public List<TestEntity> list() throws Exception{
        return testDao.list();
    }

    public TestEntity get(TestEntity testEntity) throws Exception{
        return testDao.get(testEntity);
    }
    @Transactional
    public int add(TestEntity testEntity) throws Exception{
        return testDao.add(testEntity);
    }

    @Transactional
    public int delete(TestEntity testEntity) throws Exception{
        return testDao.delete(testEntity);
    }


}
