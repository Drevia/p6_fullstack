import { Routes } from '@angular/router';

export const AUTH_ROUTES: Routes = [
  {
    title: 'Login',
    path: 'login',
    loadComponent: () => import('../../component/login/login.component').then(m => m.LoginComponent)
  },
  {
    title: 'Register',
    path: 'register',
    loadComponent: () => import('../../component/register/register.component').then(m => m.RegisterComponent)
  }
];