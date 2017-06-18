import { BrowserModule } from '@angular/platform-browser';
import {ProjectDetailService} from './developer/project/project-detail/project-detail.service'
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {BaseRequestOptions, HttpModule, JsonpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { NewsDetailComponent } from './developer/news-detail/news-detail.component';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './developer/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import {AuthGuard} from './auth/_guards/auth.guard';
import {AuthenticationService} from './_services/authentication.service';
import {UserService} from './_services/user.service';
import { ProjectDetailComponent } from './developer/project/project-detail/project-detail.component';
import { AccountMainComponent } from './developer/account-main/account-main.component';
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
import {AlertService} from './_services/alert.service';
import {AlertComponent} from './auth/_directives/alert.component';
import {RegisterComponent} from './auth/register/register.component';
import { MessageComponent } from './developer/project/message/message.component';
import {componentModuleUrl} from '@angular/compiler';
import { MarkdownComponent } from './developer/project/markdown/markdown.component';
import { FilesComponent } from './developer/project/files/files.component';
import { UserComponent } from './auth/user/user.component';
import {SecurityService} from './_services/security.service';

const appRoutes : Routes = [



  {path: 'news', component: NewsComponent},
  {path: 'news/:id', component: NewsDetailComponent},

  {path: 'account', component: AccountMainComponent},

  {path: 'projects', component: ProjectComponent},
  {path: 'projects/:id', component: ProjectDetailComponent},
  {path: 'projects/:id/files',component: FilesComponent},
  {path: 'projects/:id/message',component: MessageComponent},
  {path: 'projects/:id/markdown',component: MessageComponent},

  {path:'login',component:LoginComponent,canActivate:[AuthGuard]},
  {path:'register',component:RegisterComponent},

  // {path:'',component:HomeComponent,canActivate:[AuthGuard]},
  {path: '**',redirectTo:''},

  //admin
  {path: 'admin/projects', component: AdminProjectComponent},
  {path: 'admin/news', component: AdminNewsComponent},
  {path: 'admin/project_messages', component: AdminProjectMessageComponent},
  {path: 'admin/roles', component: AdminRolesComponent},
  {path: 'admin/tags',component: AdminTagsComponent},
  {path: 'admin/users',component:AdminUsersComponent}
];
@NgModule({
  declarations:   [AppComponent,NewsDetailComponent,HomeComponent, LoginComponent,
                  ProjectDetailComponent, AccountMainComponent, NewsComponent,
                  ProjectComponent, AdminUsersComponent, AdminProjectComponent,
                  AdminNewsComponent, AdminProjectMessageComponent, AdminTagsComponent,
                  AdminRolesComponent,AlertComponent,LoginComponent,RegisterComponent, MessageComponent, MarkdownComponent, FilesComponent, UserComponent],
  imports:        [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes), JsonpModule],
  providers:      [AuthGuard,ProjectDetailService,AuthenticationService,UserService,
                  BaseRequestOptions,NewsService,ProjectService,AlertService,UserService,SecurityService],
  bootstrap:      [AppComponent]
})
export class AppModule { }
