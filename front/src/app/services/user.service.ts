import { Injectable } from "@angular/core";
import { environment } from "../environment/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserDto } from "../dto/user.dto";

@Injectable({providedIn: 'root'})
export class UserService {

    private pathService =  `${environment.apiUrl}/api/user`;

    constructor(private http: HttpClient) {}

    public getProfil(): Observable<UserDto> {
        return this.http.get<UserDto>(`${this.pathService}/me`);
    }

    public updateProfil(userDto: UserDto): Observable<UserDto> {
        return this.http.put<UserDto>(`${this.pathService}/me`, userDto);
    }


}