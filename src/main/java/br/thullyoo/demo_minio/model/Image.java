package br.thullyoo.demo_minio.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID objectId;

    public Image() {
    }

    public Image(UUID objectId) {
        this.objectId = objectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }
}
