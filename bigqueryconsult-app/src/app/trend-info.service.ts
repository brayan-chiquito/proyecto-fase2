import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TrendInfo } from './trend-info';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrendInfoService {

  private urlBase ="http://localhost:8080/api/v1/requests/query"

  constructor(private clientHttp: HttpClient) { }

  getTrendInfo(): Observable<TrendInfo[]> {
    return this.clientHttp.get<TrendInfo[]>(this.urlBase);
  } 
}
