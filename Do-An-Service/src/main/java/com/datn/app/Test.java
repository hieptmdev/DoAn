package com.datn.app;

import com.datn.app.constant.ConstantData;
import com.datn.app.util.AppUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = new BCryptPasswordEncoder().encode("abc@123456");
        System.out.println(s);
//
//        System.out.println(ConstantData.Gender.getGenderNameByCode(4));


        // System.out.println(solution("abc").toString());


        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//
//        list.removeAll(list1);
//        System.out.println(list.toString());
        //System.out.println(list.get(0));

        System.out.println(AppUtil.generateStudentCode());
    }

    public static String[] solution(String s) {
        if(s.length()%2==1) s+="_";
        int n=s.length()/2;


        String[] sub=new String[n];
        for(int i=0;i<n;++i)
            sub[i]=""+s.charAt(i*2)+s.charAt(1+i*2);

        return sub;
    }

    public static String whoLikesIt(String... names) {
        String message = null;
        if (names.length == 0) message = "no one likes this";
        else if (names.length > 3) message = names[0] + ", " + names[1] + " and " + (names.length - 2) + " like this";
        else for (int i = 0; i < names.length; i++){
            
        }
        return message;
    }
}
