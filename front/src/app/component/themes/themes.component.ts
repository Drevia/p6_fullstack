import { Component, OnInit } from "@angular/core";
import { ThemesDto } from "src/app/dto/themes.dto";
import { ThemesService } from "src/app/services/themes.service";
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
    selector: 'app-themes',
    templateUrl: './themes.component.html',
    styleUrls: ['./themes.component.scss'],
    imports: [NavbarComponent]
})
export class ThemesComponent implements OnInit {

    public themes: ThemesDto[] = [];
    public subscribedIds: Set<number> = new Set();

    constructor(private themesService: ThemesService) {}

    ngOnInit(): void {
        this.themesService.getAllThemes().subscribe({
            next: (themes) => this.themes = themes,
            error: (err) => console.error('Erreur chargement thèmes', err)
        });

        this.themesService.getAbonnements().subscribe({
            next: (abonnements) => {
                this.subscribedIds = new Set(abonnements.map(theme => theme.id));
            },
            error: (err) => console.error('Erreur chargement abonnements', err)
        });
    }

    public isSubscribed(themeId: number): boolean {
        return this.subscribedIds.has(themeId);
    }

    public subscribe(themeId: number): void {
        this.themesService.subscribe(themeId).subscribe({
            next: () => {
                this.subscribedIds.add(themeId);
            },
            error: (err) => console.error('Erreur abonnement', err)
        });
    }

    public unsubscribe(themeId: number): void {
        this.themesService.unsubscribe(themeId).subscribe({
            next: () => {
                this.subscribedIds.delete(themeId);
            },
            error: (err) => console.error('Erreur désabonnement', err)
        });
    }

}