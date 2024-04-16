package com.vecinet.createpostworker.application.usecase;

import com.vecinet.createpostworker.application.dto.CreatePostCommandDto;
import com.vecinet.createpostworker.domain.entity.PostEntity;
import com.vecinet.createpostworker.domain.port.UseCasePort;
import com.vecinet.createpostworker.infrastructure.persistence.mongo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCase implements UseCasePort<CreatePostCommandDto, Void> {
    private final PostRepository postRepository;

    public CreatePostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Void execute(CreatePostCommandDto command) {
        PostEntity postEntity = command.getPostEntity();
        this.postRepository.create(postEntity);
        return null;
    }
}
