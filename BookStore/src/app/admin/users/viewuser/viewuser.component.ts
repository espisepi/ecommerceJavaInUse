import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent implements OnInit {

  @Input()
  user: User;

  constructor(
    private httpClientService: HttpClientService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  deleteUser() {
    this.httpClientService.deleteUser(this.user.id).subscribe(
      (user) => {
        this.router.navigate(['admin', 'users']);
      }
    );
  }

}
