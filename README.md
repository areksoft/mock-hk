# mock-hk

# Steps to setup and run the project 
1. Clone the repository 
2. After maven updates run as a spring boot app.
3. Access the 'http://localhost:8080/authuser' with post method in postman by passing  'user' & 'password'
4. After successful response copy the jwt token
5. To get users, 'http://localhost:8080/users' GET method  by adding Authorization as key and paste jwt value.
6. To get posts, 'http://localhost:8080/posts' GET method  by adding Authorization as key and paste jwt value.
7. To get comments, 'http://localhost:8080/comments' GET method  by adding Authorization as key and paste jwt value
