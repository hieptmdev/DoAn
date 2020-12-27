export class Student {
    id: number;
    code: string;
    fullName: string;
    dob: Date;
    address: string;
    email: string;
    phoneNumber: string;
    nationId: number; //quốc tịch
    provinceId: number; //tỉnh
    districtId: number; //quận/thành phố/huyện
    wardId: number; //phường/xã
    numberIdentityCard: string; //số cmmd/cccd/hộ chiếu
    licenseDate: Date; //ngày cấp
    provinceLicensePlaceId: number; //nơi cấp (tỉnh)
    districtLicensePlaceId: number; //nơi cấp(quận/thành phố/huyện)
    motherName: string;
    motherDob: Date;
    motherJob: string;
    motherNumberPhone: string;
    fatherName: string;
    fatherDob: Date;
    fatherJob: string;
    fatherNumberPhone: string;
    status: number; //0: nghỉ học; 1: đang học; 2: đã hoàn thành
    statusName: string;
    gender: number;
    currentAddress: string;
    courseId: number;
    courseName: string;
    courseNumber: number;
    unitId: number;
    unitName: string;
    className: string;
    gpa: number;
}