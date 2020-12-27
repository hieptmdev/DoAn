export class User{
  id: number;
  code: string;
  username: string;
  password: string;
  userInforId: number;
  firstName: string;
  lastName: string;
  gender: number; // 0: nam, 1: nữ, 2: khác
  genderString: string;
  dob: Date;
  address: string;
  email: string;
  numberPhone: string;
  roleId: number;
  roleName: string;
  unitId: number;
  unitName: string;
  currentPosition: string;
  workStartDate: Date;
  workEndDate: Date;
  qualifications: string;
  nationId: number;
  nationName: string;
  provinceId: number;
  provinceName: string;
  districtId: number;
  districtName: string;
  wardId: number;
  wardName: string;
  accountNonLocked: boolean;
}
