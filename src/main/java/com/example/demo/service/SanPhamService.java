package com.example.demo.service;

import com.example.demo.dto.SanPhamDto;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepo repo;

    public List<SanPhamDto> getALL() {
        return repo.getAllSanPham();
    }

    public Page<SanPham> getALL(Integer page) {
        Pageable p = PageRequest.of(page, 5);
        return repo.findAll(p);
    }

    public SanPham add(SanPham sp) {
        return repo.save(sp);
    }

    public SanPham delete(Integer id) {
        Optional<SanPham> optional = repo.findById(id);
        return optional.map(o -> {
            repo.delete(o);
            return o;
        }).orElse(null);
    }

    public SanPham Detail(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public SanPham update(SanPham sp, Integer id) {
        Optional<SanPham> optional = repo.findById(id);
        return optional.map(o -> {
            o.setTen(sp.getTen());
            o.setGiaBan(sp.getGiaBan());
            o.setMa(sp.getMa());
            o.setSoLuong(sp.getSoLuong());
            o.setLoaiSanPham(sp.getLoaiSanPham());
            return repo.save(o);
        }).orElse(null);
    }

    public List<SanPham> GiaBanASC() {
        return repo.findAllByOrderByGiaBanAsc();
    }
    public List<SanPham> SoLuongDesc(){
        return repo.findAllByOrderBySoLuongDesc();
    }
    public List<SanPham> searchTen(String ten){
        return repo.findByTenContainingIgnoreCase(ten);
    }
}
