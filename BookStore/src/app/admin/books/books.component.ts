import { Component, OnInit } from '@angular/core';
import { Book } from '../../model/Book';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Array<Book>;

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.refreshData();
  }

  refreshData() {
    this.httpClientService.getBooks().subscribe(
      response => this.handleSuccessfulResponse(response)
    );
  }

  handleSuccessfulResponse(response) {
    this.books = response;
  }

}
