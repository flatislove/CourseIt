import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {BaseRequestOptions, HttpModule, JsonpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { NewsMainComponent } from './developer/news-main/news-main.component';
import { NewsDetailComponent } from './developer/news-detail/news-detail.component';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './developer/home/home.component';
import { LoginComponent } from './login/login.component';
import {AuthGuard} from './_guards/auth.guard';
import {AuthenticationService} from './_services/authentication.service';
import {UserService} from './_services/user.service';
import { ProjectMainComponent } from './developer/project-main/project-main.component';
import { ProjectDetailComponent } from './developer/project-detail/project-detail.component';
import { AccountMainComponent } from './account-main/account-main.component';
import { NewsComponent } from './developer/news/news.component';
import {NewsService} from './developer/news/news.service';
import { ProjectComponent } from './developer/project/project.component';
import {ProjectService} from './developer/project/project.service';
import { AdminUsersComponent } from './admin/admin-users/admin-users.component';
import { AdminProjectComponent } from './admin/admin-project/admin-project.component';
import { AdminNewsComponent } from './admin/admin-news/admin-news.component';
import { AdminProjectMessageComponent } from './admin/admin-project-message/admin-project-message.component';
import { AdminTagsComponent } from './admin/admin-tags/admin-tags.component';
import { AdminRolesComponent } from './admin/admin-roles/admin-roles.component';

const appRoutes : Routes = [
  {path: 'news', component: NewsMainComponent},
  {path: 'news/:id', component: NewsDetailComponent},

  {path: 'account', component: AccountMainComponent},

  {path: 'projects', component: ProjectComponent},
  {path: 'projects/:id', component: ProjectDetailComponent},

  {path:'login',component:LoginComponent},

  {path:'',component:HomeComponent,canActivate:[AuthGuard]},
  {path: '**',redirectTo:''}
];

@NgModule({
  declarations:   [AppComponent, NewsMainComponent, NewsDetailComponent,
                  HomeComponent, LoginComponent, ProjectMainComponent,
                  ProjectDetailComponent, AccountMainComponent, NewsComponent, ProjectComponent, AdminUsersComponent, AdminProjectComponent, AdminNewsComponent, AdminProjectMessageComponent, AdminTagsComponent, AdminRolesComponent],
  imports:        [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes), JsonpModule],
  providers:      [AuthGuard,AuthenticationService,UserService,
                  BaseRequestOptions,NewsService,ProjectService],
  bootstrap:      [AppComponent]
})
export class AppModule { }
