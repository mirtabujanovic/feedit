import { Component, OnInit } from '@angular/core';
import { FeeditService } from '../feedit.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
	
	title = 'Feedit';
	
	constructor(private feedit: FeeditService) { 
	}

	authenticated() { return this.feedit.authenticated;}

}
