import { Injectable } from "@angular/core";
import { environment } from "../environment/environment";
import { HttpClient } from "@angular/common/http";
import { ThemesDto } from "../dto/themes.dto";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class ThemesService {
    private pathService =  `${environment.apiUrl}/api/themes`;

    constructor(private httpClient: HttpClient) {}

    public getAllThemes(): Observable<ThemesDto[]> {
        return this.httpClient.get<ThemesDto[]>(this.pathService);
    }

    public subscribe(themeId: number): Observable<ThemesDto[]> {
        return this.httpClient.post<ThemesDto[]>(`${this.pathService}/${themeId}/subscribe`, {});
    }

    public unsubscribe(themeId: number): Observable<void> {
        return this.httpClient.delete<void>(`${this.pathService}/${themeId}/unsubscribe`, {});
    }

    public getAbonnements(): Observable<ThemesDto[]> {
        return this.httpClient.get<ThemesDto[]>(`${this.pathService}/abonnements`);
    }
}