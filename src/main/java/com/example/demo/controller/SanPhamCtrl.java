package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sanpham")
public class SanPhamCtrl {
    @Autowired
    private SanPhamService service;

    @GetMapping()
    public ResponseEntity<?> getALL() {
        return ResponseEntity.ok(service.getALL());
    }

    @GetMapping("/getpage")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "page") Integer a) {
        return ResponseEntity.ok(service.getALL(a));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SanPham sp) {
        return ResponseEntity.ok(service.add(sp));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        SanPham xoasp = service.delete(id);
        if (xoasp != null) {
            return ResponseEntity.ok("xoa thanh cong");
        } else {
            return ResponseEntity.ok("xoa that bai");
        }
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id){
        SanPham sp = service.Detail(id);
        if(sp != null){
            return ResponseEntity.ok(sp);
        }else {
            return ResponseEntity.ok("ko tim thay sp");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody SanPham sp){
        return ResponseEntity.ok(service.update(sp,id));
    }
    @GetMapping("/giabantang")
    public ResponseEntity<List<SanPham>> GiaAsc(){
        List<SanPham> a = service.GiaBanASC();
        return ResponseEntity.ok(a);
    }
    @GetMapping("/soluonggiam")
    public ResponseEntity<List<SanPham>> SoLuongDesc(){
        List<SanPham> b = service.SoLuongDesc();
        return ResponseEntity.ok(b);
    }
    @GetMapping("/locten")
    public ResponseEntity<List<SanPham>> search(@RequestParam (value = "ten", defaultValue = "")String ten){
        List<SanPham> c = service.searchTen(ten);
      return ResponseEntity.ok(c);

    }
}
