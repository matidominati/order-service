package com.matidominati.orderservice.orderservice.utils;

import com.matidominati.orderservice.orderservice.exception.DataNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RepositoryUtils {

    public static <T> T findByIdOrThrow(Long id, MongoRepository<T, Long> mongoRepository, Class<T> entityName) {
        Optional<T> entity = mongoRepository.findById(id);
        if (entity.isEmpty()) {
            throw new DataNotFoundException(entityName.getSimpleName() + " with the provided ID does not exist.");
        }
        return entity.get();
    }
}

