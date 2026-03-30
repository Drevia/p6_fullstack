import { Injectable } from "@angular/core";
import { environment } from "../environment/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ArticleDto } from "../dto/articles.dto";
import { ArticleDetailDto } from "../dto/articleDetailDto";
import { CommentaireDto } from "../dto/commentaire.dto";
import { ArticleRequest } from "../interfaces/articleRequest.interface";

@Injectable({
    providedIn: 'root'
})
export class ArticlesServices {

    private pathService =  `${environment.apiUrl}/api/articles`;

    constructor(private httpClient: HttpClient) {}

    public getAllArticles(): Observable<ArticleDto[]> {
    return this.httpClient.get<ArticleDto[]>(this.pathService);
  }

  public getArticle(id: number): Observable<ArticleDetailDto> {
    return this.httpClient.get<ArticleDetailDto>(`${this.pathService}/${id}`);
  }

  public createArticle(article: ArticleRequest): Observable<ArticleDetailDto> {
    return this.httpClient.post<ArticleDetailDto>(this.pathService, article);
  }

  public getCommentaires(articleId: number): Observable<CommentaireDto[]> {
    return this.httpClient.get<CommentaireDto[]>(`${this.pathService}/${articleId}/comments`);
  }

  public addCommentaire(articleId: number, commentaire: CommentaireDto): Observable<CommentaireDto> {
    return this.httpClient.post<CommentaireDto>(`${this.pathService}/${articleId}/comments`, commentaire);
  }
}