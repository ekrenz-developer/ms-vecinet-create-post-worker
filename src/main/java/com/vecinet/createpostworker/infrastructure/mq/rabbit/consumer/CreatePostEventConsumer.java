package com.vecinet.createpostworker.infrastructure.mq.rabbit.consumer;

import com.vecinet.createpostworker.application.dto.CreatePostCommandDto;
import com.vecinet.createpostworker.application.event.CreatePostEvent;
import com.vecinet.createpostworker.application.usecase.CreatePostUseCase;
import com.vecinet.createpostworker.domain.entity.PostEntity;
import com.vecinet.createpostworker.domain.port.EnvironmentConfigPort;
import com.vecinet.createpostworker.domain.port.EventConsumerPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CreatePostEventConsumer implements EventConsumerPort<CreatePostEvent> {
    private final CreatePostUseCase createPostUseCase;
    private final EnvironmentConfigPort environmentConfig;

    public CreatePostEventConsumer(CreatePostUseCase createPostUseCase, EnvironmentConfigPort environmentConfig) {
        this.createPostUseCase = createPostUseCase;
        this.environmentConfig = environmentConfig;
    }

    @RabbitListener(queues = "#{@environmentConfig.getRabbitMQCreatePostQueue()}")
    @Override
    public void handleReceivedAsyncEvent(CreatePostEvent event) {
        PostEntity postEntity = event.getData();
        this.createPostUseCase.execute(new CreatePostCommandDto(postEntity));
    }
}
