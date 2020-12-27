export class Course {
    id: number;
    code: string;
    name: string;
    startDate: Date;
    endDate: Date;
    targets: number; //chỉ tiêu số lượng tuyển sinh
    reality: number; //thực tế tuyển sinh
    description: string;
    number: number;
}
