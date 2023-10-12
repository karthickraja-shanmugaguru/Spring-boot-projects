package com.example.demoimage.repo;

import com.example.demoimage.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<ImageData,Long> {

    Optional<ImageData> findByName(String fileName);
//    Optional<ImageData> findById(Long fileId);

    Optional<ImageData> findById(Long fileID);
}
