import { inject, Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";
import { SessionService } from "../services/session.services";

export const AuthGuard = () => {
    const sessionService = inject(SessionService);
    const router = inject(Router);

    if(!sessionService.isLogged){
        router.navigate(['/login']);
        return false;
    }
    return true;
}