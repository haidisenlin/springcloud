package com.lihs.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

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

  @ApolloConfigChangeListener
  public void onChange(ConfigChangeEvent changeEvent) {
    boolean redisCacheKeysChanged = false;
    for (String changedKey : changeEvent.changedKeys()) {
      if (changedKey.startsWith("a")) {
        redisCacheKeysChanged = true;
        break;
      }
    }
    if (!redisCacheKeysChanged) {
      return;
    }
    refreshScope.refresh("dataSource");
    refreshScope.refresh("sqlSessionFactory");
    refreshScope.refresh("platformTransactionManager");
    refreshScope.refresh("sqlSessionTemplate");
  }
}
