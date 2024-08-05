package com.course.hsa.client.ga;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = GoogleAnalyticsClient.class)
public class GoogleAnalyticsClientConfig {
}
