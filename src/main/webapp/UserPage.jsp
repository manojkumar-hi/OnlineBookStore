<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
    <link rel="stylesheet" href="css/HomePage.css">
    <link rel="shortcut icon" href="assets/images/favicon.png" type="image/x-icon">
    <title>User Page</title>
</head>
<body>
   <div class="container">
      <nav id="header">
        <div class="nav-logo">
            <p class="nav-name">Online Book Store</p>
            <span>.</span>
        </div>
        <div class="nav-menu" id="myNavMenu">
            <ul class="nav_menu_list">
                <li class="nav_list">
                    <a href="HomePage.jsp" class="nav-link active-link">Home</a>
                    <div class="circle"></div>
                </li>
                <li class="nav_list">
                   <a href="Books.jsp?username=<%= session.getAttribute("username") %>" class="nav-link">View Books</a>
                    <div class="circle"></div>
                </li>
                <li class="nav_list">
                    <a href="Viewcart.jsp?username=<%= session.getAttribute("username") %>" class="nav-link">View Cart</a>
                    <div class="circle"></div>
                </li>
               
                 <li class="nav_list">
                    <a href="HomePage.jsp" class="nav-link">Logout</a>
                    <div class="circle"></div>
                </li>
               
            </ul>
        </div>
        
        <div class="nav-menu-btn">
            <i class="uil uil-bars" onclick="myMenuFunction()"></i>
        </div>
      </nav>


    <!-- -------------- MAIN ---------------- -->
    <main class="wrapper">
       <!-- -------------- FEATURED BOX ---------------- -->
       <section class="featured-box" id="home">
          <div class="featured-text">
            <div class="featured-text-card">
                <span>Welcome to the User Panel</span>
            </div>
            <div class="featured-name">
                <p>Unleash Your Reading Journey: <span class="typedText"></span></p>
                 <p>Welcome, <%= session.getAttribute("username") %>!</p>
            </div>
            <div class="featured-text-info">
                <p>  "Discover a world of literature at your fingertips. Happy reading!"

                
                </p>
            </div>
           
          </div>
          <div class="featured-image">
            <div class="image">
                <img src="assets/images/avatar.png" alt="avatar">
            </div>
          </div>
       </section>
      
      

       

      

  

    </div>




    
</body>
</html>