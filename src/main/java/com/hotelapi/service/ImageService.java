package com.hotelapi.service;

import com.hotelapi.model.entity.ImageEntity;
import com.hotelapi.repository.ImageRepository;
import com.hotelapi.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    public byte[] downloadAllRoomImages(Integer roomId){
        System.out.println("before downloadImage dbImageData fileName-------------" );

        List<ImageEntity> dbImageData = imageRepository.findAllByRoomId(roomId);
//        Optional<ImageEntity> img = imageRepository.findByName("warning.png");

        List<byte[]> images2 = new ArrayList<>();

        for (ImageEntity img : dbImageData) {
            images2.add(ImageUtils.decompressImage(img.getImageData()));
        }

        byte[] images = ImageUtils.decompressImage(dbImageData.get(0).getImageData());
//        byte[] images = ImageUtils.decompressImage(img.get().getImageData());

        return images;
    }
}
