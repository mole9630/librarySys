# librarySys
基于JSP+MySQL开发的图书馆前后端系统

### 目前已实现及将要实现的功能(TODO)
* [x] 登录注册功能
* [ ] 用户后台
* [ ] 管理员后台
* [ ] 用户端-借阅列表及续借功能

```
librarySys
├─ .htaccess
├─ bootstrap-4.6.1-dist  Bootstrap框架
├─ css
│  ├─ footer.css  页脚样式
│  ├─ header.css  页首样式
│  ├─ index.css  首页样式
│  ├─ login.css  登录样式
│  └─ register.css  注册样式
├─ footer.jsp  页脚页
├─ header.jsp  页首页
├─ img
│  ├─ head_bg.png  导航栏背景
│  ├─ login
│  │  └─ user_img.jpg  登录页头像
│  └─ logo.png  Logo
├─ index.jsp  首页
├─ java
│  └─ db
│     ├─ DBConnection.java  数据库连接
│     └─ DBUtil.java  数据库操作
├─ LICENSE  许可证
├─ login.jsp  登录页
├─ README.md
├─ register.jsp  注册页
├─ studentManagement.jsp  学生管理页
├─ test.jsp  测试文件
└─ userAdministration.jsp  用户管理页

```

### 网站状态码及日志类型码
#### 状态码
|状态码|说明|备注|
|:-:|:-:|:-:|
|1001|||

#### 日志类型码
|类型码|说明|备注|
|:-:|:-:|:-:|
|5001|登录成功||
|5005|注册成功||