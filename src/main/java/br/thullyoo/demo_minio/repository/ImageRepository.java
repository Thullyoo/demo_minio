package br.thullyoo.demo_minio.repository;

import br.thullyoo.demo_minio.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
