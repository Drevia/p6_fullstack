import { HttpInterceptorFn } from "@angular/common/http";
import { SessionService } from "../services/session.services";
import { inject } from "@angular/core";
import { catchError, throwError } from "rxjs";
import { Router } from "@angular/router";

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  const sessionService = inject(SessionService);
  const router = inject(Router);

  if (sessionService.isLogged) {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${sessionService.sessionInformation?.token}`,
      },
    });
  }

  return next(req).pipe(
    catchError((error) => {
      if(error.status === 401) {
        sessionService.logOut();
        router.navigate(['/login']);
      }
      return throwError(() => error);
    })
  );
};