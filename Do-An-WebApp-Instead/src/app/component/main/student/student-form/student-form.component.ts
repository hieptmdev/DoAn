import {Component, OnInit, TemplateRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {StudentService} from '../../../../service/student.service';
import {Student} from '../../../../model/student';
import {formatDate} from '@angular/common';
import {UnitService} from '../../../../service/unit.service';
import {CourseService} from '../../../../service/course.service';
import {PlaceService} from '../../../../service/place.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  student: Student = new Student();

  courses: any;
  units: any;
  nations: any;
  provinces: any;
  provincesLicense: any;
  districts: any;
  districtsLicense: any;
  wards: any;

  studentCode: any;
  isSaveOrUpdate = false;

  constructor(private router: Router,
              private toastr: ToastrService,
              private route: ActivatedRoute,
              private studentService: StudentService,
              private unitService: UnitService,
              private courseService: CourseService,
              private placeService: PlaceService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.importCourse();
    this.importUnit();
    this.importPlace();
    this.route.paramMap.subscribe(param => {
      if (param.get('code') == null){
        this.isSaveOrUpdate = true;
        this.studentCode = null;
      }else {
        this.studentCode = param.get('code');
        this.getStudentByCode(this.studentCode);
      }
    });
  }

  saveOrUpdate(): void{
    this.studentService.saveOrUpdate(this.student)
      .subscribe(data => {
        this.modalService.dismissAll();
        this.router.navigate(['home/students']).then(() => {
            this.toastr.success('Thực hiện thêm/sửa thành công!', 'Notification', {timeOut: 3000});
          });
      }, error => {
        this.errorHandle(error);
      });
  }

  getStudentByCode(code): void{
    this.studentService.findStudentByCode(code)
      .subscribe(data => {
        this.student = data.body;
        this.student.dob = formatDate(this.student.dob, 'yyyy-MM-dd', 'vi');
        this.student.licenseDate = formatDate(this.student.licenseDate, 'yyyy-MM-dd', 'vi');
        this.student.fatherDob = formatDate(this.student.fatherDob, 'yyyy-MM-dd', 'vi');
        this.student.motherDob = formatDate(this.student.motherDob, 'yyyy-MM-dd', 'vi');
      }, error => {
        this.errorHandle(error);
      });
  }

  changeNation(): void {
    if (this.student.nationId !== 232){
      this.student.provinceId = 0;
      this.student.provinceLicensePlaceId = 0;
      this.student.districtId = 0;
      this.student.districtLicensePlaceId = 0;
      this.student.wardId = 0;
    }
  }

  changeProvince(): void{
    this.placeService.findAllDistrictByProvince(this.student.provinceId)
      .subscribe(data => {
        this.districts = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  changeProvinceLicense(): void{
    this.placeService.findAllDistrictByProvince(this.student.provinceLicensePlaceId)
      .subscribe(data => {
        this.districtsLicense = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  changeDistrict(): void{
    this.placeService.findAllWardByProvinceAndDistrict(this.student.provinceId, this.student.districtId)
      .subscribe(data => {
        this.wards = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  cancel(): void {
    if (this.studentCode) {
      this.isSaveOrUpdate = false;
    }
    location.reload();
  }

  back(): void {
    this.router.navigate(['home/students']).then(null);
  }

  importCourse(): void{
    this.courseService.findAll()
      .subscribe(data => {
        this.courses = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  importUnit(): void{
    this.unitService.findAllUnit()
      .subscribe(data => {
        this.units = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  importPlace(): void{
    this.placeService.findAllNation()
      .subscribe(data => {
        this.nations = data.body;
      }, error => {
        this.errorHandle(error);
      });

    this.placeService.findAllProvince()
      .subscribe(data => {
        this.provinces = data.body;
        this.provincesLicense = data.body;
      }, error => {
        this.errorHandle(error);
      });

    this.placeService.findAllDistrict()
      .subscribe(data => {
        this.districts = data.body;
        this.districtsLicense = data.body;
      }, error => {
        this.errorHandle(error);
      });

    this.placeService.findAllWard()
      .subscribe(data => {
        this.wards = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  score(): void {
    this.router.navigate(['score'], {relativeTo: this.route}).then(null);
  }

  openModalSave(modal: TemplateRef<any>): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
  }

  public errorHandle(error): void{
    if (error.status === 401){
      this.router.navigate(['login']).then(null);
    }else if (error.status === 500){
      this.router.navigate(['error/500']).then(null);
    } else {
      this.toastr.error('Có lỗi xảy ra!', 'Notification', {timeOut: 3000});
    }
  }
}
