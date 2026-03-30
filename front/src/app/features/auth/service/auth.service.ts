import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SessionInformation } from "src/app/interfaces/sessionInformatin.interface";
import { LoginRequest } from "../model/loginRequest.interface";
import { RegisterRequest } from "../model/registerRequest.interface";
import { environment } from "src/app/environment/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private pathService = `${environment.apiUrl}/api/auth`;

  constructor(private httpClient: HttpClient) { }

  public register(registerRequest: RegisterRequest): Observable<void> {
    return this.httpClient.post<void>(`${this.pathService}/register`, registerRequest);
  }

  public login(loginRequest: LoginRequest): Observable<SessionInformation> {
    return this.httpClient.post<SessionInformation>(`${this.pathService}/login`, loginRequest);
  }
}