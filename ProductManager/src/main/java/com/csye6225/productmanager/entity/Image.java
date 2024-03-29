package com.csye6225.productmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

/*
Image{
image_id	integer($int64)
example: 1
readOnly: true
product_id	integer($int64)
example: 1
readOnly: true
file_name	string
readOnly: true
date_created	string($datetime)
example: 2016-08-29T09:12:33.001Z
readOnly: true
s3_bucket_path	string
readOnly: true
}
 */
//@JsonIgnoreProperties({"image_product"})
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer image_id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "file_name", updatable = false)
    private String file_name;

    @Column(name = "date_created", updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Timestamp date_added;

    @Column(name = "s3_bucket_path",columnDefinition = "TEXT")
    private String s3_bucket_path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_product")
    private Product image_product;

    public Product getProduct() {
        return image_product;
    }

    public void setProduct(Product product) {
        this.image_product = product;
        this.product_id = product.getId();
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Product getImage_product() {
        return image_product;
    }

    public void setImage_product(Product image_product) {
        this.image_product = image_product;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer productId) {
        this.product_id = productId;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Timestamp getDate_added() {
        return date_added;
    }

    public void setDate_added(Timestamp date_added) {
        this.date_added = date_added;
    }

    public String getS3_bucket_path() {
        return s3_bucket_path;
    }

    public void setS3_bucket_path(String s3_bucket_path) {
        this.s3_bucket_path = s3_bucket_path;
    }
}