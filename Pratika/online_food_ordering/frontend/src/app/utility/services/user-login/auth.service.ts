import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  getDataFromSessionStorage(key:string) {
    return sessionStorage.getItem(key);
  }

  setDataInSessionStorage(variableName: any, data: any) {
    sessionStorage.setItem(variableName, data);
  }

  clearStorage() {
    sessionStorage.clear();
  }
}
