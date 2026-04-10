import { Component, OnInit } from "@angular/core";
import { Router, RouterModule } from "@angular/router";
import { ArticleDto } from "src/app/dto/articles.dto";
import { ArticlesServices } from "src/app/services/articles.service";
import { NavbarComponent } from "../navbar/navbar.component";
import { CommonModule } from "@angular/common";

@Component({
    selector: 'app-articles',
    templateUrl: './articles.component.html',
    styleUrls: ['./articles.component.scss'],
    imports: [NavbarComponent, CommonModule, RouterModule]
})
export class ArticlesComponent implements OnInit {

    public articles: ArticleDto[] = [];
    public sortAsc = false;

    constructor(
        private router: Router,
        private articleService: ArticlesServices
    ) {}


    ngOnInit(): void {
        this.articleService.getFeed().subscribe({
            next: (articles) => {
            console.log("articles trouves:",articles);
            this.articles = articles;
        },
        error: (err) => console.error('Erreur chargement articles', err)
        });
    }

    public toggleSort(): void {
        this.sortAsc = !this.sortAsc;
        this.articles.sort((a, b) => {
            const dateA = new Date(a.datePublication).getTime();
            const dateB = new Date(b.datePublication).getTime();
            return this.sortAsc ? dateA - dateB : dateB - dateA;
        });
    }

    public goToArticle(id: number): void {
        this.router.navigate(['/articles', id]);
    }
    
    
}