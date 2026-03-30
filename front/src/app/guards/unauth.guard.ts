import { inject, Injectable } from "@angular/core";
import { CanActivate, Router } from "@angular/router";
import { SessionService } from "../services/session.services";

export const unauthGuard = () => {
  const sessionService = inject(SessionService);
  const router = inject(Router);

  if (sessionService.isLogged) {
    router.navigate(['/articles']);
    return false;
  }
  return true;
};