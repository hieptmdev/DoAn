package com.datn.app.util;

import com.datn.app.constant.ConstantData;
import io.jsonwebtoken.Jwts;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

    public static String generateCode(){
        Random rand = new Random();
        int code = rand.nextInt(999999);
        return String.format("%06d", code);
    }

    public static String generateStudentCode() {
        Random rand = new Random();
        int code = rand.nextInt(999);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYMMdd");

        StringBuilder sb = new StringBuilder();
        sb.append(simpleDateFormat.format(date));
        sb.append(String.format("%03d",code));
        return sb.toString();
    }

    public static String generateEmpCode(){
        Random rand = new Random();
        int code = rand.nextInt(999);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        StringBuilder sb = new StringBuilder();
        sb.append("UTC");
        sb.append(simpleDateFormat.format(date));
        sb.append(String.format("%03d",code));
        return sb.toString();
    }

    public static double convertScore(double score){
        double a = 0;
        if (score < 4)  a = 0;
        if (score >= 4 && score < 5.5)  a = 1;
        if (score >= 5.5 && score < 7)  a = 2;
        if (score >= 7 && score < 8.5)  a = 3;
        if (score >= 8.5)   a = 4;
        return a;
    }
}
