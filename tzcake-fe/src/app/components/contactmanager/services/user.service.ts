import { resolve } from '@angular-devkit/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private _user: BehaviorSubject<User[]> | any;

  private dataStore: {
    users: User[];
  } | any

  constructor(private http: HttpClient) { 
    this.dataStore = { users: [] };
    this._user = new BehaviorSubject<User[]>([]);
  }

  get users(): Observable<User[]> {
    return this._user.asObservable();
  }

  getUserById(id: number){
    return this.dataStore.users.find((x: { id: number; }) => x.id == id);
  }

  loadAll() {
    const userUrl = 'https://angular-material-api.azurewebsites.net/users';
    return this.http.get(userUrl)
    .subscribe( data => { 
      this.dataStore.users = data; 
      this._user.next(Object.assign({}, this.dataStore).users);
    }, error => {
      console.log("Failed to fetch users");
    });
  }

    
  addUser(user: User) {
    return new Promise((resolver, reject) => {
      user.id = this.dataStore.users.length + 1;
      this.dataStore.users.push(user);
      this._user.next(Object.assign({}, this.dataStore).users);
      resolver(user);
    })
  }

}
