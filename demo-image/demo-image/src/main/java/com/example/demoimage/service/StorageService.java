package com.example.demoimage.service;

import com.example.demoimage.entity.ImageData;
import com.example.demoimage.repo.StorageRepository;
import com.example.demoimage.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository repository;
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData= repository.save(ImageData.builder()
                 .name(file.getOriginalFilename())
                 .type(file.getContentType())
                 .imageData(ImageUtils.compressImage(file.getBytes())).build());
            if(imageData!=null){
                return "file uploaded successfully : "+file.getOriginalFilename();
            }
            return null;
    }
    public byte[] downloadImage(Long fileId){
        Optional<ImageData> dbimageData = repository.findById(fileId);//findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbimageData.get().getImageData());
        return images;
    }
}
