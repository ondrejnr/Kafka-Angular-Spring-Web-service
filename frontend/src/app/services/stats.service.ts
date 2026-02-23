import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class StatsService {
  // Use the Backend's EXTERNAL-IP here
  private apiUrl = 'http://35.246.186.99:8080/api/stats/status';
  constructor(private http: HttpClient) { }
  getBackendStatus(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
