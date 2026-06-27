package org.zhaoxu.springstudy.config.nacosConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "test")
public class SpringStudyConfig {
    private String msg;
    private String version;
}
