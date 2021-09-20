import { BreakpointObserver, BreakpointState } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

const SMALL_WIDTH_BREAKPOINT = 720;

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  public isScreenSmall: boolean | undefined;

  users: Observable<User[]> | any;
  isDarkTheme: boolean = false;
  dir: any = 'ltr';

  constructor(
    private breakpointObserver: BreakpointObserver,
    private userService: UserService,
    private router: Router) { }

  @ViewChild(MatSidenav) sidenav: MatSidenav | any;

  toggleTheme() {
    this.isDarkTheme = !this.isDarkTheme;
  }
  
  toggleDir() {
    this.dir = this.dir == 'ltr' ? 'rtl' : 'ltr';
  }
  ngOnInit(): void {
    this.breakpointObserver
      // .observe([ Breakpoints.XSmall])
      .observe([ `(max-width: ${SMALL_WIDTH_BREAKPOINT}px)` ])
      .subscribe((state: BreakpointState) => {
        this.isScreenSmall = state.matches;
      });

      this.users = this.userService.users;
      this.userService.loadAll();

      // this.users.subscribe((data: any) => {
      //   if (data.length > 0) this.router.navigate(['/contactmanager', data[0].id]);
      // })

      this.router.events.subscribe(() => {
        if (this.isScreenSmall) {
          this.sidenav.close();
        }
      })
    }

}
