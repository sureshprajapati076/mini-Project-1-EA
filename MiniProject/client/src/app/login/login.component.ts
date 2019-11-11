import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        console.log(JSON.stringify(data));
        this.router.navigate([''])
        this.invalidLogin = false
      },
      error => {
        //this.router.navigate(['/errorpage'])
        this.invalidLogin = true

      }
    )


  }

}
/*this.userService.register(this.registerForm.value)
        .pipe(map((res: Response) => res.json()))
        .subscribe(
            data => {
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']);
            },
            (error:HttpErrorResponse) => {
                let errorPayload = JSON.parse(error.message);
                //ToDo: apply your handling logic e.g.:
                //console.log(errorPayload[0].description
                console.log(error.error);
            }); */