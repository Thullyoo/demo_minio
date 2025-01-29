package br.thullyoo.demo_minio.service;

import br.thullyoo.demo_minio.model.Image;
import br.thullyoo.demo_minio.repository.ImageRepository;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class MinioService {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private ImageRepository imageRepository;

    public void uploadImage(MultipartFile file) throws Exception {

        InputStream inputStream = file.getInputStream();
        String objectId = UUID.randomUUID().toString();

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket("images")
                        .object(objectId)
                        .stream(inputStream, inputStream.available(), -1)
                        .contentType("image/png")
                        .build()

        );

        imageRepository.save(new Image(UUID.fromString(objectId)));
    }

    public byte[] getImage(String objectId) throws Exception{
        InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket("images")
                        .object(objectId)
                        .build()
        );

        return IOUtils.toByteArray(stream);
    }

}
