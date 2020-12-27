package com.datn.app.service;

import com.datn.app.dao.idao.DistrictDao;
import com.datn.app.dao.idao.NationDao;
import com.datn.app.dao.idao.ProvinceDao;
import com.datn.app.dao.idao.WardDao;
import com.datn.app.dto.DistrictDto;
import com.datn.app.dto.NationDto;
import com.datn.app.dto.ProvinceDto;
import com.datn.app.dto.WardDto;
import com.datn.app.entity.District;
import com.datn.app.entity.Nation;
import com.datn.app.entity.Province;
import com.datn.app.entity.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    @Autowired
    private NationDao nationDao;
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private DistrictDao districtDao;
    @Autowired
    private WardDao wardDao;

    public List<NationDto> findAllNation(){
        return nationDao.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(Nation::convertToDto).collect(Collectors.toList());
    }

    public List<ProvinceDto> findAllProvince() {
        return provinceDao.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(Province::convertToDto).collect(Collectors.toList());
    }

    public List<DistrictDto> findAllDistrict(){
        return districtDao.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(District::convertToDto).collect(Collectors.toList());
    }

    public List<DistrictDto> findAllDistrictByProvinceId(Long provinceId) {
        return districtDao.findAllByProvinceId(provinceId, Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(District::convertToDto).collect(Collectors.toList());
    }

    public List<WardDto> findAllWard(){
        return wardDao.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(Ward::convertToDto).collect(Collectors.toList());
    }

    public List<WardDto> findAllWardByProvinceIdAndDistrictId(Long provinceId, Long districtId) {
        return wardDao.findAllByProvinceIdAndAndDistrictId(provinceId, districtId, Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(Ward::convertToDto).collect(Collectors.toList());
    }
}
