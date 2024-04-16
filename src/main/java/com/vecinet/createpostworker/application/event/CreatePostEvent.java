package com.vecinet.createpostworker.application.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vecinet.createpostworker.domain.entity.PostEntity;
import com.vecinet.createpostworker.domain.port.EventPort;

public class CreatePostEvent implements EventPort {
    private final PostEntity postEntity;

    @JsonCreator
    public CreatePostEvent(@JsonProperty("data") PostEntity postEntity) {
        this.postEntity = postEntity;
    }

    @Override
    public PostEntity getData() {
        return this.postEntity;
    }
}
