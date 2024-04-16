package com.vecinet.createpostworker.infrastructure.mq.rabbit.consumer;

import com.vecinet.createpostworker.application.dto.CreatePostCommandDto;
import com.vecinet.createpostworker.application.event.CreatePostEvent;
import com.vecinet.createpostworker.application.usecase.CreatePostUseCase;
import com.vecinet.createpostworker.domain.entity.PostEntity;
import com.vecinet.createpostworker.domain.port.EventConsumerPort;
import com.vecinet.createpostworker.domain.port.PostRespositoryPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CreatePostEventConsumer implements EventConsumerPort<CreatePostEvent> {
    private final CreatePostUseCase createPostUseCase;

    public CreatePostEventConsumer(CreatePostUseCase createPostUseCase) {
        this.createPostUseCase = createPostUseCase;
    }

    @RabbitListener(queues = "#{createPostConfig.createPostQueue().getName()}")
    @Override
    public void handleReceivedAsyncEvent(CreatePostEvent event) {
        PostEntity postEntity = event.getData();
        this.createPostUseCase.execute(new CreatePostCommandDto(postEntity));
    }
}
