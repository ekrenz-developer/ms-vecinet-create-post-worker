package com.vecinet.createpostworker.application.dto;

import com.vecinet.createpostworker.domain.entity.PostEntity;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreatePostCommandDto {
    @NonNull
    private PostEntity postEntity;
}
