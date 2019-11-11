import { Component, OnInit, Input } from '@angular/core';
import { HttpClientService } from '../service/httpclient.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  result = 'Click Above Links';
  constructor(public httpClientService: HttpClientService) { }

  ngOnInit() {
  }



  getPublicPageFromApi() {
    this.httpClientService.requestPublicPage().subscribe(
      data => this.result = JSON.stringify(data),

      err => this.result = 'Network Error'

    );
  }
  showRecordsFromApi() {
    this.httpClientService.loadAllData().subscribe(data => this.result = JSON.stringify(data),

      err => this.result = 'Please Log in first');
  }
  runBatchTask() {
    this.httpClientService.batchTask().subscribe(data => this.result = JSON.stringify(data),

      err => this.result = 'You must be admin to perform this task');
  }


}
