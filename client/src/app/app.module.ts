import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NewsListComponent } from './news-list/news-list.component';
import { RoleListComponent } from './role-list/role-list.component';
import { NavigationComponent } from './navigation/navigation.component';
import { NewsDetailComponent } from './news-detail/news-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsListComponent,
    RoleListComponent,
    NavigationComponent,
    NewsDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
