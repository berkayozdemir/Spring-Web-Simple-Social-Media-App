# Spring Web Social Media App 
## _What does this project include?_



- Spring Web
- Spring Data JDBC
-  MySQL
-  Spring Security
- Besides login, logout and sign up 
-  Thymeleaf

For more open source projects you can visit [my repository][dill] on GitHub.

## Summary of Project

Firstly, you are facing with a login screen. If you dont have an account you can sign up with button on the top of login screen. 

After logging in, you can see the flow of posts has been shared by other users on your homepage. In left, you can show your username and count of how many post you have shared. If you want to share a post, you can click the share a post button on the left panel.

After sharing a post, you redirected to homepage and you can see your post too in your screen. Posts are sorted by date in descending order so your post located at the top of flow container. After you are done, you can logout from button on the top of screen.

Except those, there is a rest controller class so you can make add, post, update etc. with api's. 

##### What's incomplete and will be added?
- Validations(checking an field empty or two password are same in signup page etc.)
- User will will be able to delete a post he/she owns and admin will be able to delete every post.
- Some html-css bugs (in some environments logo at the login and signup page cannot be displayed)
- A demo video of program on youtube and a few narrator images.
- Databases  will moved to aws or i will share sql codes of tables.


## HOW TO RUN

You can open the project from a java ide. You should edit application.properties according to your database.
After, you should run main method of the class at the path of "com/example/demo/DemoApplication.java" .

_For educational reasons, i used local databases. As mentioned you should create databases from my sql code on next version of project._
 





   [dill]: <https://github.com/berkayozdemir?tab=repositories>
  
