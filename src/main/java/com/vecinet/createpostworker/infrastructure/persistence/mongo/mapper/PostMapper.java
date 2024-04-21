package com.vecinet.createpostworker.infrastructure.persistence.mongo.mapper;

import com.vecinet.createpostworker.domain.entity.PostEntity;
import com.vecinet.createpostworker.infrastructure.persistence.mongo.model.PostModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Date;

@Mapper(componentModel = "spring", implementationName = "PersistencePostMapper")
public interface PostMapper {

    default PostModel toPersistence(PostEntity postEntity) {
        return PostModel.builder()
                .id(postEntity.getId())
                .username(postEntity.getUsername())
                .latitude(postEntity.getLatitude())
                .longitude(postEntity.getLongitude())
                .content(postEntity.getContent())
                .location(new GeoJsonPoint(postEntity.getLongitude(), postEntity.getLatitude()))
                .createdAt( dateToLong(postEntity.getCreatedAt()) )
                .updatedAt( dateToLong(postEntity.getUpdatedAt()) )
                .build();
    }

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "longToDate")
    @Mapping(target = "updatedAt", source = "updatedAt", qualifiedByName = "longToDate")
    @Mapping(target = "deletedAt", source = "deletedAt", qualifiedByName = "longToDate")
    PostEntity toDomain(PostModel postModel);

    @Named("dateToLong")
    default Long dateToLong(Date date) {
        return date != null ? date.getTime() : null;
    }

    @Named("longToDate")
    default Date longToDate(Long timestamp) {
        return timestamp != null ? new Date(timestamp) : null;
    }
}
