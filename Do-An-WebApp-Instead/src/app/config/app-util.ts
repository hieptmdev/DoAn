import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

export class AppUtil{
  private static router: Router;
  private static toastr: ToastrService;

  constructor() {}

  public static errorHandle(error): void{
    if (error.status === 401){
      this.router.navigate(['login']).then(null);
    }else if (error.status === 500){
      this.router.navigate(['error/500']).then(null);
    } else {
      this.toastr.error('Có lỗi xảy ra!', 'Notification', {timeOut: 3000});
    }
  }
}
