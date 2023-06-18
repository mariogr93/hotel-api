package com.hotelapi.service;

import com.hotelapi.model.entity.ImageEntity;
import com.hotelapi.repository.ImageRepository;
import com.hotelapi.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageEntity img = ImageEntity.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build();
        System.out.println(img.toString());
        ImageEntity imageData = imageRepository.save(img);
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(){
        System.out.println("before downloadImage dbImageData fileName-------------" );

        List<ImageEntity> dbImageData = imageRepository.findAll();
        System.out.println(dbImageData);
        Optional<ImageEntity> img = imageRepository.findByName("warning.png");
        System.out.println("after downloadImage dbImageData-------------" + img.get().toString());
        byte[] images = ImageUtils.decompressImage(dbImageData.get(0).getImageData());
        return images;
    }
}
