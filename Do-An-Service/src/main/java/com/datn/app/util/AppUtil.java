package com.datn.app.util;

import com.datn.app.constant.ConstantData;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class AppUtil {
    public static <D> D mapToDtoAndEnt(Object source, Class<D> typeClass) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(source, typeClass);
    }

    public static Pageable getPageable(String page, String limit) {
        if (page == null || "".equals(page)) page = "0";
        if (limit == null || "".equals(limit)) limit = "10";
        return PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
    }
}
