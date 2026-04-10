import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleDetailDto } from 'src/app/dto/articleDetailDto';
import { NavbarComponent } from '../../navbar/navbar.component';
import { ArticlesServices } from 'src/app/services/articles.service';
import { SessionService } from 'src/app/services/session.services';
import { CommentaireDto } from 'src/app/dto/commentaire.dto';

@Component({
  selector: 'app-article-detail',
  standalone: true,
  imports: [CommonModule, FormsModule, NavbarComponent],
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.scss']
})
export class ArticleDetailComponent implements OnInit {

  public article: ArticleDetailDto | null = null;
  public newComment: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private articlesService: ArticlesServices,
    private sessionService: SessionService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.articlesService.getArticle(id).subscribe({
      next: (article) => {
        console.log('Article chargé', article);
        this.article = article;
      },
      error: (err) => console.error('Erreur chargement article', err)
    });
  }

  public goBack(): void {
    this.router.navigate(['/articles']);
  }

  public sendComment(): void {
    if (!this.newComment.trim() || !this.article) return;

    const commentaire: CommentaireDto = {
      contenu: this.newComment.trim()
    };

    const articleId = this.article.id;

    this.articlesService.addCommentaire(articleId, commentaire).subscribe({
      next: (newCommentaire) => {
        this.article!.commentaires.push(newCommentaire);
        this.newComment = '';
      },
      error: (err) => console.error('Erreur ajout commentaire', err)
    });
  }
}