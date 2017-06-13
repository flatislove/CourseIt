import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {BaseRequestOptions, HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { NewsMainComponent } from './news-main/news-main.component';
import { NewsDetailComponent } from './news-detail/news-detail.component';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {AuthGuard} from './_guards/auth.guard';
import {AuthenticationService} from './_services/authentication.service';
import {UserService} from './_services/user.service';
import {fakeBackendProvider} from './_helpers/fake-backend';
import {MockBackend} from '@angular/http/testing';
import { ProjectMainComponent } from './project-main/project-main.component';
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { AccountMainComponent } from './account-main/account-main.component';

const appRoutes : Routes = [
  {path: 'news', component: NewsMainComponent},
  {path: 'projects', component: ProjectMainComponent},
  {path: 'news/:id', component: NewsDetailComponent},
  {path:'login',component:LoginComponent},
  {path:'',component:HomeComponent,canActivate:[AuthGuard]},
  {path: '**',redirectTo:''}
];

@NgModule({
  declarations:   [AppComponent, NewsMainComponent, NewsDetailComponent,
                  HomeComponent, LoginComponent, ProjectMainComponent,
                  ProjectDetailComponent,
                  AccountMainComponent],
  imports:        [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes)],
  providers:      [AuthGuard,AuthenticationService,UserService,fakeBackendProvider,MockBackend,
                  BaseRequestOptions],
  bootstrap:      [AppComponent]
})
export class AppModule { }
