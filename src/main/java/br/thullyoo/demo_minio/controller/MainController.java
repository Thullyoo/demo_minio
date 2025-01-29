package br.thullyoo.demo_minio.controller;

import br.thullyoo.demo_minio.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class MainController {

    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam MultipartFile file) {
        try {
            minioService.uploadImage(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/{objectId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("objectId") String objectId){
        try {
            return minioService.getImage(objectId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
