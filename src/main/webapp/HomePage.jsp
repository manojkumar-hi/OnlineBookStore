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
    <title>Home Page</title>
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
                    <a href="#home" class="nav-link active-link">Home</a>
                    <div class="circle"></div>
                </li>
                <li class="nav_list">
                    <a href="AdminRegistration.jsp" class="nav-link">Admin</a>
                    <div class="circle"></div>
                </li>
                <li class="nav_list">
                    <a href="UserRegistration.jsp" class="nav-link">User</a>
                    <div class="circle"></div>
                </li>
                 <li class="nav_list">
                    <a href="#about" class="nav-link">About Us</a>
                    <div class="circle"></div>
                </li>
                 <li class="nav_list">
                    <a href="#projects" class="nav-link">Uses</a>
                    <div class="circle"></div>
                </li>
                <li class="nav_list">
                    <a href="#contact" class="nav-link">Contact</a>
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
                <span>Value Your Life Book</span>
            </div>
            <div class="featured-name">
                <p>Book is the <span class="typedText"></span></p>
            </div>
            <div class="featured-text-info">
                <p>Books: portals to distant realms,
Words weave tales, enchanting helms.
Infinite knowledge within bound realms
                </p>
            </div>
            <div class="featured-text-btn">
                <a href="#"><button class="btn blue-btn">Start A Journey</button></a>
                <button class="btn">Follow Us</i></button>
            </div>
            <div class="social_icons">
                <div class="icon"><i class="uil uil-instagram"></i></div>
                <div class="icon"><i class="uil uil-twitter-alt"></i></div>
                <div class="icon"><i class="uil uil-facebook-f"></i></div>
                <div class="icon"><i class="uil uil-linkedin-alt"></i></div>
            </div>
          </div>
          <div class="featured-image">
            <div class="image">
                <img src="assets/images/avatar.png" alt="avatar">
            </div>
          </div>
       </section>
       <!-- -------------- ABOUT BOX ---------------- -->
       <section class="section" id="about">
          <div class="top-header">
            <h1>About Us</h1>
          </div>
          <div class="row">
            <div class="col">
                <div class="about-info">
                    <h3>Online Book Store</h3>
                    <p>In the digital realm where pixels dance and sway,
An online bookstore emerges to light the way.
No brick or mortar, just servers in flight,
Where words transcend, igniting the night.

From timeless classics to contemporary trends,
Every genre thrives, as imagination blends.
Scrolling through shelves, a bibliophile's delight,
A universe of stories, day and night.

E-books whisper softly, their pages evergreen,
While audiobooks narrate, in voices unseen.
Convenience reigns supreme, with just a click,
Access to literature, no longer a trick.

Global connections, readers unite,
In this boundless library, their hearts take flight.
Authors find refuge, in this cybernetic sphere,
Their tales reaching far, dispelling fear.

An online bookstore, a beacon of light,
Guiding seekers of knowledge, through the digital night.
In the labyrinth of bytes, stories find their home,
In this virtual haven, where readers roam.
                    </p>
                    <div class="about-btn">
                        <button class="btn">Download About E-Book Store<i class="uil uil-import"></i></button>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="skills-box">
                    <div class="skills-header">
                        <h3>Why Choose Online Book Store?</h3>
                    </div>
                    <div class="skills-list">
                        <span>Conveinience</span>
                        <span>Security</span>
                        <span>Accessibility</span>
                        <span>Faster Results</span>
                        <span>Features</span>
                        <span>Accuracy</span>
                        <span>Efficiency</span>
                    </div>
                </div>
                </div>
                <div class="skills-box">
                    <div class="skills-header">
                        <h3>Join Us</h3>
                    </div>
                    <div class="skills-list">
                        <span><i class="uil uil-instagram"></i></span>
                        <span><i class="uil uil-twitter"></i></span>
                        <span><i class="uil uil-facebook-f"></i></span>
                        <span><i class="uil uil-linkedin"></i></span>
                    </div>
                </div>
            </div>
          </div>
       </section>

       <!-- -------------- PROJECT BOX ---------------- -->

       <section class="section" id="projects">
          <div class="top-header">
              <h1>Uses</h1>
          </div>
          <div class="project-container">
            <div class="project-box">
                <i class="uil uil-briefcase-alt"></i>
                <h3>Convenience</h3>
                <label>Making things easier, like Online Book Store.</label>
            </div>
            <div class="project-box">
                <i class="uil uil-users-alt"></i>
                <h3>Accuracy</h3>
                <label>Getting it right as you Selected Book.</label>
            </div>
            <div class="project-box">
                <i class="uil uil-award"></i>
                <h3>Efficiency</h3>
                <label>Doing it faster delivery with less time</label>
            </div>
          </div>
       </section>

       <!-- -------------- CONTACT BOX ---------------- -->

       <section class="section" id="contact">
          <div class="top-header">
            <h1>Get in touch</h1>
            <span>Do you have anything to say in your mind, contact me here</span>
          </div>
          <form action="https://formspree.io/f/xgejpqjw" method="POST">
          <div class="row">
             <div class="col">
                <div class="contact-info">
                    <h2>Find Me <i class="uil uil-corner-right-down"></i></h2>
                    <p><i class="uil uil-envelope"></i> Email:suradasri@gmail.com</p>
                    <p><i class="uil uil-phone"></i> Tel: +91 6304497524</p>
                </div>
             </div>
             <div class="col">
                <div class="form-control">
                    <div class="form-inputs">
                        <input type="text" class="input-field" name="name" placeholder="Name">
                        <input type="text" class="input-field" name="email" placeholder="Email">
                    </div>
                    <div class="text-area">
                        <textarea placeholder="Message" name="message"></textarea>
                    </div>
                    <div class="form-button">
                        <button tyepe="submit" class="btn">Send <i class="uil uil-message"></i></button>   
                    </div>
                </div>
             </div>
         
          </div>
   </form>
       </section>

    </main>


    <!-- --------------- FOOTER --------------- -->
   
    </div>




    <!-- ----- TYPING JS Link ----- -->
    <script src="https://unpkg.com/typed.js@2.0.16/dist/typed.umd.js"></script>

       <!-- ----- SCROLL REVEAL JS Link----- -->
    <script src="https://unpkg.com/scrollreveal"></script>

    <!-- ----- MAIN JS ----- -->
    <script src="js/HomePage.js"></script>
</body>
</html>