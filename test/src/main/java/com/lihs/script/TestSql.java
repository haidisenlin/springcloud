package com.lihs.script;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author hsli
 * @Date 2018/6/26 14:32:09
 */
@Data
@Configuration
@RefreshScope
public class TestSql {

    @Value("${selectsql}")
    private String selectsql;

    public String getSelect() {
        return selectsql;
    }

}
