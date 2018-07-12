package com.lihs.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.property.SpringValueRegistry;
import com.ctrip.framework.apollo.spring.util.SpringInjector;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.stream.events.Namespace;

/**
 * @version V2.0.0
 * @author hsli
 * @date 2018/6/26
 */
@Component
public class SpringBootApolloRefreshConfig {
  private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

  @Autowired
  private RefreshScope refreshScope;

  @Resource
  Environment environment ;

  private  SpringValueRegistry springValueRegistry = SpringInjector.getInstance(SpringValueRegistry.class);

  @ApolloConfigChangeListener({"TEST1.jdbcurl"})
  public void onChange(ConfigChangeEvent changeEvent) {
    System.out.println("来过了");
    boolean datasource = false;
    for (String changedKey : changeEvent.changedKeys()) {
      if (changedKey.startsWith("spring.datasource")) {
          datasource = true;
        break;
      }
    }
    refreshScope.refreshAll();
  }
}
