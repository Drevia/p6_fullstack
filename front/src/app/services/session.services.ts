import { Injectable } from "@angular/core";
import { SessionInformation } from "../interfaces/sessionInformatin.interface";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({providedIn: "root"})
export class SessionService{

    private readonly STORAGE_KEY = 'session';

    public isLogged: boolean = false;
    public sessionInformation: SessionInformation | null = null;

    private isLoggedSubject = new BehaviorSubject<boolean>(false);

    constructor() {
        this.loadFromStorage();
    }

    public $isLogged(): Observable<boolean> {
        return this.isLoggedSubject.asObservable();
    }

    public logIn(user: SessionInformation): void {
        this.isLogged = true;
        this.sessionInformation = user;
        localStorage.setItem(this.STORAGE_KEY, JSON.stringify(user));
        this.next();
    }

    public logOut(): void {
        this.isLogged = false;
        this.sessionInformation = null;
        localStorage.removeItem(this.STORAGE_KEY);
        this.next();
    }

    private loadFromStorage(): void {
        const stored = localStorage.getItem(this.STORAGE_KEY);
        if(stored) {
            this.sessionInformation = JSON.parse(stored) as SessionInformation;
            this.isLogged = true;
            this.next();
        }
    }

    private next(): void {
        this.isLoggedSubject.next(this.isLogged);
    }
}