package com.hotelapi.repository;

import com.hotelapi.model.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
    @Query("""
    Select i from ImageEntity i inner join RoomEntity r on i.roomEntity.id = r.id where r.id = :roomId
    """)
    List<ImageEntity> findAllByRoomId(Integer roomId);

    @Query("""
    Select n from ImageEntity n where n.name = :fileName
    """)
    Optional<ImageEntity> findByName(String fileName);
}
