import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';

import { CustomerService } from 'src/app/services/customer.service';
import {BankAccount} from "../model/account.model";

@Component({
  selector: 'app-customer-accounts',
  templateUrl: './customer-accounts.component.html',
  styleUrls: ['./customer-accounts.component.css'],
})
export class CustomerAccountsComponent implements OnInit {
  customerId!: number;
  BankAccounts!: Observable<Array<BankAccount>>;
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['id'];
    this.getBankAccounts();
  }

  getBankAccounts() {
    this.BankAccounts = this.customerService
      .getAccountsofCustomer(this.customerId)
      .pipe(
        catchError((err) => {
          this.errorMessage = err.message;
          return throwError(() => err);
        })
      );
  }

  checkoperation(account: BankAccount) {
    this.router.navigateByUrl("/accounts",{state :account});
  }


}
