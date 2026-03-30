import { Component } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { RegisterRequest } from "src/app/features/auth/model/registerRequest.interface";
import { AuthService } from "src/app/features/auth/service/auth.service";

@Component({
  selector: 'app-register',
  imports:[ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent{

    public onError = false;

    public form = this.fb.group({
        username: ['', Validators.required, Validators.minLength(3), Validators.maxLength(20)],
        email: ['', Validators.required, Validators.email],
        password: ['', 
            [
                Validators.required,
                Validators.minLength(8),
                Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$')
            ]
        ]
    });

    constructor(
        private fb: FormBuilder,
        private router: Router,
        private authService: AuthService
    ) {}

    public submit(): void {
        const registerRequest = this.form.value as RegisterRequest;
        this.authService.register(registerRequest).subscribe({
            next: () => this.router.navigate(['/login']),
            error: () => this.onError = true,
        })
    }

    public goBack(): void {
        this.router.navigate(['/home']);
    }
}