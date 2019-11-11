import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientService } from '../service/httpclient.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {
  createAcc: FormGroup;

  constructor(private router: Router,
    private httpClientService: HttpClientService, private fb: FormBuilder) {
    this.createAcc = this.fb.group({
      "id": [''],
      "email": ['', Validators.required],
      "password": ['', Validators.required],
      "name": ['', Validators.required],
      "phone": ['', Validators.required],
      "address": ['', Validators.required],
      "roles": ['', Validators.required]


    });


  }

  ngOnInit() {
  }

  createAccount() {




    this.httpClientService.addUser(this.createAcc.value)
      .subscribe(data => {

        if (data === null) {

          this.router.navigate(['signup'])

          return false;
        }
        this.router.navigate(['login']);

        return true;
      })


  }



}





