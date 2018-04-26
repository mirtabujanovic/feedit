import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class FeeditService {
	
	authenticated = false;

	constructor(private http: HttpClient) {
	}
	
	authenticate(credentials, callback) {
		//ako postoje credentialsi stavi ih u header, ako ne, prazan objekt
		const headers = new HttpHeaders( credentials ? {
			authorization: 'Basic' + btoa(credentials.username + ':' + credentials.password)
		} : {});
		
		//zovem GET na mapping "/user"
		this.http.get('api/korisnik', {headers: headers}).subscribe(response => {
			if (response['name']) {
				this.authenticated = true;
			} 
			else {
				this.authenticated = false;
			}
			return callback && callback();//u callback() možemo napraviti nešto ako je uspješna autentifikacija
		});
	}

}
