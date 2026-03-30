import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { unauthGuard } from './guards/unauth.guard';
import { AuthGuard } from './guards/auth.guards';

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
export const appRoutes: Routes = [
  { 
    path: '', 
    canActivate: [unauthGuard],
    loadChildren: () => import('./features/auth/auth.routes').then(m => m.AUTH_ROUTES)
  },
  { 
    path: 'home', 
    canActivate: [unauthGuard],
    loadComponent: () => import('./component/home/home.component').then(m => m.HomeComponent)
  },
  {
    path: 'me',
    canActivate: [AuthGuard],
    loadComponent: () => import('./component/me/me.component').then(m => m.MeComponent)
  },
  {
    path: 'articles',
    canActivate: [AuthGuard],
    loadChildren: () => import('./component/articles/articles.routes').then(m => m.ARTICLES_ROUTES)
  },
  {
    path: 'themes',
    canActivate: [AuthGuard],
    loadChildren: () => import('./component/themes/themes.routes').then(m => m.THEMES_ROUTES)
  }
];
