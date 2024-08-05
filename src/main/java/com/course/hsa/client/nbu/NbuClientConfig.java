package com.course.hsa.client.nbu;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = NbuClient.class)
public class NbuClientConfig {
}
