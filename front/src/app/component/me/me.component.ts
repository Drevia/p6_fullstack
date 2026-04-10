import { CommonModule } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { NavbarComponent } from "../navbar/navbar.component";
import { ThemesDto } from "src/app/dto/themes.dto";
import { ThemesService } from "src/app/services/themes.service";
import { SessionService } from "src/app/services/session.services";
import { UserService } from "src/app/services/user.service";
import { UserDto } from "src/app/dto/user.dto";
import { UpdateProfilRequest } from "src/app/interfaces/update-profil-request.interface";

@Component({
    selector: "app-me",
    imports:[CommonModule, ReactiveFormsModule, NavbarComponent],
    templateUrl: "./me.component.html",
    styleUrls: ["./me.component.scss"]
})
export class MeComponent implements OnInit {

    public abonnements: ThemesDto[] = [];
    public onError = false;
    public onSuccess = false;

    public form = this.fb.group({
        username: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$')]]
    });


    constructor(
        private fb: FormBuilder,
        private userService: UserService,
        private themesService: ThemesService,
        private sessionService: SessionService
    ){}


    ngOnInit(): void {
        this.userService.getProfil().subscribe({
            next: (user: UserDto) => {
            this.form.patchValue({
            username: user.username,
            email: user.email
        });
      },
      error: (err) => console.error('Erreur chargement profil', err)
    });
 
    this.themesService.getAbonnements().subscribe({
      next: (abonnements) => this.abonnements = abonnements,
      error: (err) => console.error('Erreur chargement abonnements', err)
    });
  }

  public submit(): void {
    this.onError = false;
    this.onSuccess = false;

    const request: UpdateProfilRequest = {
      username: this.form.value.username!,
      email: this.form.value.email!,
    };

    if (this.form.value.password) {
      request.password = this.form.value.password;
    }

    this.userService.updateProfil(request).subscribe({
      next: () => this.onSuccess = true,
      error: () => this.onError = true
    });
}

  public unsubscribe(themeId: number): void {
    this.themesService.unsubscribe(themeId).subscribe({
      next: () => {
        this.abonnements = this.abonnements.filter(t => t.id !== themeId);
      },
      error: (err) => console.error('Erreur désabonnement', err)
    });
}
    
}