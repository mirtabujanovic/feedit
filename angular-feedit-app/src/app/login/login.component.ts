import { Component, OnInit, Input } from '@angular/core';
import { FeeditService } from '../feedit.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

	@Input() credentials = { username: '', password: ''};

	constructor(private feedit: FeeditService, private http: HttpClient, private router: Router) {
	}

	login() {
		this.feedit.authenticate(this.credentials, () => {
			//callback on success
			this.router.navigateByUrl('/');
		});
		return false;
	}
}
