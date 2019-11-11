import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }




  public addUser(user) {
    return this.httpClient.post<any>("http://localhost:8085/api/register", user);
  }

  public requestPublicPage() {
    return this.httpClient.get("http://localhost:8085/api/public");
  }

  public loadAllData() {
    return this.httpClient.get<any>("http://localhost:8085/api/listall");
  }

  public batchTask() {
    return this.httpClient.get<any>("http://localhost:8085/api/load");
  }




}