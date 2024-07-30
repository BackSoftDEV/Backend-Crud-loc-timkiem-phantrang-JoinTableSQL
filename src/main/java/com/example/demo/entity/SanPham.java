package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySX")
    private Date ngaySX;

    @Column(name = "GiaBan")
    private Double giaBan;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "IdLoaiSP")
    private LoaiSanPham loaiSanPham;

    @PrePersist
    protected void onCreate() {
        if (ngaySX == null) {
            ngaySX = new Date();
        }
    }
}
