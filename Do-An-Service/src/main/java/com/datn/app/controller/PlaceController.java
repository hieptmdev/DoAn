package com.datn.app.controller;

import com.datn.app.dto.DistrictDto;
import com.datn.app.dto.NationDto;
import com.datn.app.dto.ProvinceDto;
import com.datn.app.dto.WardDto;
import com.datn.app.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/nations")
    public ResponseEntity<List<NationDto>> findAllNation() {
        return new ResponseEntity(placeService.findAllNation(), HttpStatus.OK);
    }

    @GetMapping("/provinces")
    public ResponseEntity<List<ProvinceDto>> findAllProvince() {
        return new ResponseEntity(placeService.findAllProvince(), HttpStatus.OK);
    }

    @GetMapping("/districts")
    public ResponseEntity<List<DistrictDto>> findAllDistrict(){
        return new ResponseEntity(placeService.findAllDistrict(), HttpStatus.OK);
    }

    @GetMapping("/districts/{provinceId}")
    public ResponseEntity<List<DistrictDto>> findAllDistrictByProvinceId(@PathVariable Long provinceId) {
        return new ResponseEntity(placeService.findAllDistrictByProvinceId(provinceId), HttpStatus.OK);
    }

    @GetMapping("/wards")
    public ResponseEntity<List<DistrictDto>> findAllWard(){
        return new ResponseEntity(placeService.findAllWard(), HttpStatus.OK);
    }

    @GetMapping("/wards/{provinceId}/{districtId}")
    public ResponseEntity<List<WardDto>> findAllWard(@PathVariable Long provinceId, @PathVariable Long districtId) {
        return new ResponseEntity(placeService.findAllWardByProvinceIdAndDistrictId(provinceId, districtId), HttpStatus.OK);
    }
}
