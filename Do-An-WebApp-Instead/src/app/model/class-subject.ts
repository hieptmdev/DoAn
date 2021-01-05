export class ClassSubject{
  id: number;
  code: string;
  name: string;
  subjectsCode: string; // môn học
  subjectsId: number;
  teacherName: string; // giảng viên phụ trách
  userId: number;
  courseName: string; // khóa học
  courseId: number;
  startDate: string;
  endDate: string;
  calendar: string; // lịch học
  status = 0; // 0: chuẩn bị, 1: đang học, 2: kết thúc
  statusName: string;
  classDetails: any;
}
