import { Routes } from '@angular/router';

export const ARTICLES_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () => import('./articles.component').then(m => m.ArticlesComponent)
  },
  {
    path: 'create',
    loadComponent: () => import('./create-article/create-article.component').then(m => m.CreateArticleComponent)
  },
  {
    path: ':id',
    loadComponent: () => import('./article-detail/article-detail.component').then(m => m.ArticleDetailComponent)
  }
]