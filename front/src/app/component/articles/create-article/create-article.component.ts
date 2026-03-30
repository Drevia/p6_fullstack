import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../../navbar/navbar.component';
import { ArticlesServices } from 'src/app/services/articles.service';
import { ArticleRequest } from 'src/app/interfaces/articleRequest.interface';
import { ThemesDto } from 'src/app/dto/themes.dto';
import { ThemesService } from 'src/app/services/themes.service';
 
@Component({
  selector: 'app-create-article',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NavbarComponent],
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit {
 
  public themes: ThemesDto[] = [];
  public onError = false;
 
  public form = this.fb.group({
    themeTitre: ['', Validators.required],
    titre: ['', [Validators.required, Validators.minLength(3)]],
    contenu: ['', [Validators.required, Validators.minLength(10)]]
  });
 
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private articlesService: ArticlesServices,
    private themesService: ThemesService
  ) {}
 
  ngOnInit(): void {
    this.themesService.getAllThemes().subscribe({
      next: (themes) => this.themes = themes,
      error: (err) => console.error('Erreur chargement thèmes', err)
    });
  }
 
  public goBack(): void {
    this.router.navigate(['/articles']);
  }
 
  public submit(): void {
    const articleRequest = this.form.value as ArticleRequest;
    this.articlesService.createArticle(articleRequest).subscribe({
      next: (article) => this.router.navigate(['/articles', article.id]),
      error: () => this.onError = true
    });
  }
}