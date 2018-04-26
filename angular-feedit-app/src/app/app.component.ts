import { Component } from '@angular/core';
import { FeeditService } from './feedit.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'Feedit';
	
	constructor(private feedit: FeeditService, private http: HttpClient, private router: Router) {
      this.feedit.authenticate(undefined, undefined);
    }
	
    logout() {
      this.http.post('logout', {}).finally(() => {
          this.feedit.authenticated = false;
          this.router.navigateByUrl('/login');
      }).subscribe();
    }

}
