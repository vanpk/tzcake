import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { NotificationType } from '../enum/notification-type.enum';
import { CustomHttpRespone } from '../model/custom-http-response';
import { NotificationService } from '../service/notification.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public showLoading: boolean;

  constructor(private userService: UserService, private notificationService: NotificationService) { }

  ngOnInit(): void {
  }

  public onForgotPassword(emailForm: NgForm): void {
    this.showLoading = true;
    const emailAddress = emailForm.value['forgot-password-email'];
    this.subscriptions.push(
      this.userService.forgotPassword(emailAddress).subscribe(
        (response: CustomHttpRespone) => {
          this.showLoading = false;
          this.sendNotification(NotificationType.SUCCESS, response.message);
        },
        (errorResponse: HttpErrorResponse) => {
          this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
          this.showLoading = false;
        }
      )
    );
  }
  private sendNotification(notificationType: NotificationType, message: string): void {
    if (message) {
      this.notificationService.notify(notificationType, message);
    } else {
      this.notificationService.notify(notificationType, 'An error occurred. Please try again.');
    }
  }

}
