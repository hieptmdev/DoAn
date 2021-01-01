export class Student {
    id: number;
    code: string;
    fullName: string;
    dob: string;
    address: string;
    email: string;
    phoneNumber: string;
    nationId = 0; // quốc tịch
    provinceId = 0; // tỉnh
    districtId = 0; // quận/thành phố/huyện
    wardId = 0; // phường/xã
    numberIdentityCard: string; // số cmmd/cccd/hộ chiếu
    licenseDate: string; // ngày cấp
    provinceLicensePlaceId = 0; // nơi cấp (tỉnh)
    districtLicensePlaceId = 0; // nơi cấp(quận/thành phố/huyện)
    motherName: string;
    motherDob: string;
    motherJob: string;
    motherNumberPhone: string;
    fatherName: string;
    fatherDob: string;
    fatherJob: string;
    fatherNumberPhone: string;
    status = 1; // 0: nghỉ học; 1: đang học; 2: đã hoàn thành
    statusName: string;
    gender = 0;
    currentAddress: string;
    courseId = 0;
    courseName: string;
    courseNumber: number;
    unitId = 0;
    unitName: string;
    className: string;
    gpa: number;
}
