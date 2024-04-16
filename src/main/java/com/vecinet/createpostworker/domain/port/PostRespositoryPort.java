package com.vecinet.createpostworker.domain.port;

import com.vecinet.createpostworker.domain.entity.PostEntity;

public interface PostRespositoryPort {
    PostEntity create(PostEntity entity);
}
