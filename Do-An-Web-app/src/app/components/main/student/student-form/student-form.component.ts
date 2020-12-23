import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/model/course';
import { District } from 'src/app/model/district';
import { Nation } from 'src/app/model/nation';
import { Province } from 'src/app/model/province';
import { Student } from 'src/app/model/student';
import { Unit } from 'src/app/model/unit';
import { User } from 'src/app/model/user';
import { Ward } from 'src/app/model/ward';
import { CourseService } from 'src/app/services/course.service';
import { PlaceService } from 'src/app/services/place.service';
import { StorageService } from 'src/app/services/storage.service';
import { StudentService } from 'src/app/services/student.service';
import { UnitService } from 'src/app/services/unit.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  currentUser: User;
  units: Unit[];
  selectedUnit: Unit;
  courses: Course[];
  selectedCourse: Course;
  student: Student = new Student();
  nations: Nation[];
  selectedNation: Nation = new Nation();
  provinces: Province[];
  selectedProvince: Province;
  selectedProvinceLicense: Province;
  districts: District[];
  selectedDistrict: District;
  selectedDistrictLicense: District;
  wards: Ward[];
  selectedWard: Ward;
  editOrAdd = false;
  code: any;

  constructor(private courseService: CourseService,
              private unitService: UnitService,
              private storageService: StorageService,
              private placeService: PlaceService,
              private studentService: StudentService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.code = params.get('code');
    });
    this.importDataSelectBox();
    if (this.code == null) {
      this.editOrAdd = true;
    }else{
      this.loadData(this.code);
    }
  }

  loadData(code){
    this.studentService.findByCode(code).subscribe(
      data => {
        this.student = data.body;

        this.student.dob = new Date(this.student.dob);
        this.student.licenseDate = new Date(this.student.licenseDate);
        this.student.motherDob = new Date(this.student.motherDob);
        this.student.fatherDob = new Date(this.student.fatherDob);

        this.selectedCourse = this.courses.filter((c: Course ) => c.id === this.student.courseId)[0];
        this.selectedUnit = this.units.filter((u: Unit) => u.id === this.student.unitId)[0];
        this.selectedNation = this.nations.filter((n: Nation) => n.id === this.student.nationId)[0];
        if (this.selectedNation.code == 'VN'){
          this.selectedProvince = this.provinces.filter((p: Province) => p.id === this.student.provinceId)[0];
          this.selectedProvinceLicense = this.provinces.filter((p: Province) => p.id === this.student.provinceLicensePlaceId)[0];
          this.selectedDistrict = this.districts.filter((d: District) => d.id === this.student.districtId)[0];
          this.selectedDistrictLicense = this.districts.filter((d: District) => d.id === this.student.districtLicensePlaceId)[0];
          this.selectedWard = this.wards.filter((w: Ward) => w.id === this.student.wardId)[0];
        }
      }, error => console.log(error));
  }

  importDataSelectBox(){
    this.courseService.getAll()
      .subscribe(data => {
        this.courses = data.body;
      }, error => console.log(error));
    
    this.unitService.findAllForStudent(Number(this.storageService.getUnit()))
      .subscribe(data => {
        this.units = data.body;
      }, error => console.log(error));

    this.placeService.getAllNation()
      .subscribe(data => {
        this.nations = data.body;
      }, error => console.log(error));

    this.placeService.getAllProvince()
      .subscribe(data => {
        this.provinces = data.body;
      }, error => console.log(error));

    this.placeService.getAllDistrict()
      .subscribe(data => {
        this.districts = data.body;
      }, error => console.log(error));

    this.placeService.getAllWard()
      .subscribe(data => {
        this.wards = data.body;
      }, error => console.log(error));
    
  }

  back() {
    this.router.navigate(['home/students']).then(null);
  }

  saveOrUpdate() {
    this.student.courseId = this.selectedCourse.id;
    this.student.unitId = this.selectedUnit.id;
    this.student.nationId = this.selectedNation.id;
    this.student.provinceId = this.selectedProvince.id;
    this.student.provinceLicensePlaceId = this.selectedProvinceLicense.id;
    this.student.districtId = this.selectedDistrict.id;
    this.student.districtLicensePlaceId = this.selectedDistrictLicense.id;
    this.student.wardId = this.selectedWard.id;7
    if(this.student.id == null)
    {
      this.studentService.save(this.student)
        .subscribe(data => {
          console.log(data);
        }, error => console.log(error));
    } else {
      this.studentService.update(this.student)
        .subscribe(data => {
          console.log(data);
        }, error => console.log(error));
    }
  }
}
