package com.vecinet.createpostworker.infrastructure.mongo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
public abstract class BaseModel {
    @Id
    @NonNull
    protected UUID id;

    @Field("created_at")
    @Indexed
    @NonNull
    private Long createdAt;

    @Field("updated_at")
    @NonNull
    private Long updatedAt;

    @Field("deleted_at")
    private Long deletedAt;
}
