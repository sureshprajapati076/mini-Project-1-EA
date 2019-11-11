import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { HttpClientService } from '../service/httpclient.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {




  //  user;
  constructor(public router: Router, public loginService: AuthenticationService) { }
  ngOnInit() {
    //   this.user = localStorage.getItem('username')
  }
  logOut() {
    localStorage.removeItem('username')
    this.router.navigate(['login'])
  }





}
