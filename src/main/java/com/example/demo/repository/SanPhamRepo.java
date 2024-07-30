package com.example.demo.repository;

import com.example.demo.dto.SanPhamDto;
import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
    @Query(value = " SELECT sp.Ma, sp.Ten, sp.GiaBan, sp.SoLuong, sp.NgaySX, lsp.Ten AS TenLoaiSanPham\n" +
            "FROM SanPham sp\n" +
            "JOIN LoaiSP lsp ON sp.IdLoaiSP = lsp.Id;", nativeQuery = true)
    List<SanPhamDto> getAllSanPham();

    List<SanPham> findAllByOrderByGiaBanAsc(); // Sắp xếp theo giá bán tăng dần


    List<SanPham> findAllByOrderBySoLuongDesc();//   sắp xếp theo số lượng giảm dần


    List<SanPham> findByTenContainingIgnoreCase(String ten); //lọc theo tên
}
