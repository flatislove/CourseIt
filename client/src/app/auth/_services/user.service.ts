import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import {User} from '../../developer/account-main/user';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {
  constructor(private http: Http) {
  }

  getAll() {
    return this.http.get('http://localhost:8080/api/users', this.jwt()).map((response: Response) => response.json());
  }

  getById(id: number) {
    return this.http.get('http://localhost:8080/api/users/' + id, this.jwt()).map((response: Response) => response.json());
  }

  create(user: User) {
    return this.http.post('http://localhost:8080/api/users', user).map((response: Response) => response.json());
  }

  update(user: User) {
    return this.http.put('http://localhost:8080/api/users/' + user.id, user, this.jwt()).map((response: Response) => response.json());
  }

  delete(id: number) {
    return this.http.delete('http://localhost:8080/api/users/' + id, this.jwt()).map((response: Response) => response.json());
  }

  private jwt() {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({'Authorization': 'Bearer ' + currentUser.token});
      return new RequestOptions({headers: headers});
    }
  }
}
