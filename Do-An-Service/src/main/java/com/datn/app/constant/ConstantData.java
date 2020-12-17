package com.datn.app.constant;

import java.util.Arrays;

public class ConstantData {
    public static final int ROLE_SYSADMIN = 1;
    public static final int ROLE_ADEDU = 2;
    public static final int ROLE_ADPOLITIC = 3;
    public static final String SERVER_LOCATION_FILE = "/file";

    public enum Gender{
        GENDER_Male(0, "Nam"),
        GENDER_Female(1, "Nữ"),
        GENDER_Other(2, "Khác");

        int code;
        String name;

        Gender(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getGenderNameByCode(int code){
            return Arrays.stream(Gender.values())
                    .filter(g -> g.code == code)
                    .findFirst().orElse(GENDER_Other).name;
        }
    }

    public enum StudentsStatus{
        LEAVE_SCHOOL(0, "Nghỉ học"),
        STUDYING(1, "Đang học"),
        STUDY_COMPLETED(2, "Đã hoàn thành");

        int code;
        String name;

        StudentsStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getStatusNameByCode(int code){
            return Arrays.stream(StudentsStatus.values())
                    .filter(ss -> ss.code == code)
                    .findFirst().orElse(null).name;
        }
    }

    public enum Qualifications{
        ENGINEER(0, "Kỹ sư / Cử nhân"),
        MASTER(1, "Thạc sĩ"),
        DOCTOR(2, "Tiến sĩ"),
        ASSOCIATE_PROFESSOR(3, "Phó Giáo sư"),
        PROFESSOR(4, "Giáo sư");

        int code;
        String name;

        Qualifications(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getQualificationsNameByCode(int code){
            return Arrays.stream(Qualifications.values())
                    .filter(q -> q.code == code)
                    .findFirst().orElse(null).name;
        }
    }
}
