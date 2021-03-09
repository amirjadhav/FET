import { Injectable } from '@angular/core';

@Injectable()
export class GobalErrorHandlerService {

  constructor() { }
  handleError(err: Error) {
    alert("error handling done here..." + err.message);
  }
}
