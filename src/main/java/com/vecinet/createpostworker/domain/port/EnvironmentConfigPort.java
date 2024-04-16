package com.vecinet.createpostworker.domain.port;

public interface EnvironmentConfigPort {
    String getMongoUsername();
    String getMongoPassword();
    String getMongoCluster();
    String getMongoDatabase();
    String getRabbitMQHost();
    int getRabbitMQPort();
    String getRabbitMQUsername();
    String getRabbitMQPassword();
}
