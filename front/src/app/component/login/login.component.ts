import { Component } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { LoginRequest } from "src/app/features/auth/model/loginRequest.interface";
import { AuthService } from "src/app/features/auth/service/auth.service";
import { SessionInformation } from "src/app/interfaces/sessionInformatin.interface";
import { SessionService } from "src/app/services/session.services";

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
    public hide = true;
    public onError = false;

    constructor(
        private authService: AuthService,
        private fb: FormBuilder,
        private router: Router,
        private sessionService: SessionService
    ) {}

    public form = this.fb.group({
        email: ['', [Validators.required]], //aussi username
        password: ['', [Validators.required, Validators.minLength(8)]]
    });

    public submit(): void {
        const loginRequest = this.form.value as LoginRequest;

        this.authService.login(loginRequest).subscribe({
            next: (response: SessionInformation) => {
                this.sessionService.logIn(response);
                this.router.navigate(['/articles']);
            },
            error: () => this.onError = true,
        });
    }

    public goBack(): void {
        this.router.navigate(['/home']);
    }
}