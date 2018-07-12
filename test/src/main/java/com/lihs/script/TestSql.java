package com.lihs.script;

import com.lihs.test.TestApplication;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author hsli
 * @Date 2018/6/26 14:32:09
 */
public class TestSql {

    //
    public String getSelect() {
        return TestApplication.context.getEnvironment().getProperty("selectsql");
    }

}
