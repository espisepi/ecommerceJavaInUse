import { Component, OnInit } from '@angular/core';
import { User } from '../../model/User';
import { HttpClientService } from '../../service/http-client.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: Array<User>;
  selectedUser: User;
  action: string;

  constructor(
    private httpClientService: HttpClientService,
    private router: Router,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit() {
    this.refreshData();
  }

  refreshData() {
    this.httpClientService.getUsers().subscribe(
      response => this.handleSuccessfulResponse(response),
    );

    this.activatedRouter.queryParams.subscribe(
      (params) => {
        this.action = params.action;
      }
    );
  }

  handleSuccessfulResponse(response) {
    this.users = response;
  }

  addUser() {
    this.selectedUser = new User();
    this.router.navigate(['admin', 'users'], { queryParams: {action: 'add'}});
  }

}
