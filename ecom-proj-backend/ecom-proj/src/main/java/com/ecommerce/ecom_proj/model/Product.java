package com.ecommerce.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageTypes;

    @Lob
    private byte[] imageData;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTypes() {
        return imageTypes;
    }

    public void setImageTypes(String imageTypes) {
        this.imageTypes = imageTypes;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public Product(String imageName, String imageTypes, byte[] imageData) {
        this.imageName = imageName;
        this.imageTypes = imageTypes;
        this.imageData = imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Product{" +
                "imageName='" + imageName + '\'' +
                ", imageTypes='" + imageTypes + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }

}


