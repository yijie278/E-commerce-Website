<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>home page</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="header">

   <div class="flex">
      <a href="html/admin_page.html" class="logo">Jom Makan<span>.</span></a>
      <nav class="navbar">
         <a href="home.jsp">home</a>
         <a href="shop-servlet">shop</a>
         <a href="order.jsp">orders</a>
         <a href="about.jsp">about</a>
         <a href="html/contact.html">contact</a>
      </nav>
      <div class="icons">
         <div id="menu-btn" class="fas fa-bars"></div>
         <div id="user-btn" class="fas fa-user"></div>
         <a href="html/search_page.html" class="fas fa-search"></a>
         <a href="cart.jsp"><i class="fas fa-shopping-cart"></i><span>${not empty cart ? cart.itemCount : 0}</span></a>
      </div>
      <div class="profile">
         <img src="uploaded_img" alt="">
         <p>Guest</p>
         <a href="user_profile_update.jsp" class="btn">update profile</a>
         <a href="login.jsp" class="delete-btn">logout</a>
         <div class="flex-btn">
            <a href="login.jsp" class="option-btn">login</a>
            <a href="register.jsp" class="option-btn">register</a>
         </div>
      </div>
   </div>
</header>

<div class="home-bg">
   <section class="home">
      <div class="content">
         <span>Jom Makan, Malaysia's Taste</span>
         <h3>Spice Up Your Life with Malaysian Flavors</h3>
         <p>Discover the natural essence of Malaysian cuisine with our wide selection of fresh, organic spices and ingredients.</p>
         <a href="about.jsp" class="btn">about us</a>
      </div>
   </section>
</div>

<section class="home-category">
   <h1 class="title">shop by category</h1>
   <div class="box-container">
      <div class="box">
         <!-- CATEGORY 1 - AROMATIC SPICES -->
         <img src="images/cat1.png" alt="">
         <h3>Aromatic Spices</h3>
         <p>Enhance your dishes with the irresistible fragrance of aromatic spices like cinnamon, cardamom, and cloves.</p>
         <!-- jump to category page when click on 'See More' button. -->
         <a href="category-servlet?category=spices" class="btn">See More</a>
      </div>
      <div class="box">
         <!-- CATEGORY 2 - SPICY -->
         <img src="images/cat2.png" alt="">
         <h3>Hot and Spicy</h3>
         <p>Turn up the heat with our selection of chilies, pepper, and ginger.</p>
         <!-- jump to category page when click on 'Shop Now' button. -->
         <a href="category-servlet?category=spicy" class="btn">Shop Now</a>
      </div>
      <div class="box">
         <!-- CATEGORY 3 - NUT -->
         <img src="images/cat3.png" alt="">
         <h3>Sweet and Nutty</h3>
         <p>Indulge in the warm, comforting flavors of nutmeg, fennel, and anise.</p>
         <a href="category-servlet?category=nutty" class="btn">See More</a>
      </div>
      <div class="box">
         <!-- CATEGORY 4 - HERBAL -->
         <img src="images/cat4.png" alt="">
         <h3>Herbal</h3>
         <p>Discover the natural goodness of herbal flavors with lemongrass, pandan, and curry leaves.</p>
         <a href="category-servlet?category=herbal" class="btn">Shop Now</a>
      </div>
   </div>
</section>

<footer class="footer">
   <section class="box-container">
      <div class="box">
         <h3>quick links</h3>
         <a href="home-servlet"> <i class="fas fa-angle-right"></i> home</a>
         <a href="shop-servlet"> <i class="fas fa-angle-right"></i> shop</a>
         <a href="about.jsp"> <i class="fas fa-angle-right"></i> about</a>
         <a href="html/contact.html"> <i class="fas fa-angle-right"></i> contact</a>
      </div>
      <div class="box">
         <h3>extra links</h3>
         <a href="html/cart.html"> <i class="fas fa-angle-right"></i> cart</a>
         <a href="html/wishlist.html"> <i class="fas fa-angle-right"></i> wishlist</a>
         <a href="login.jsp"> <i class="fas fa-angle-right"></i> login</a>
         <a href="register.jsp"> <i class="fas fa-angle-right"></i> register</a>
      </div>
      <div class="box">
         <h3>contact info</h3>
         <p> <i class="fas fa-phone"></i> +03-111-2222 </p>
         <p> <i class="fas fa-phone"></i> +03-222-3333 </p>
         <p> <i class="fas fa-envelope"></i> jommakan@gmail.com </p>
         <p> <i class="fas fa-map-marker-alt"></i> Penang, Malaysia - 10150 </p>
      </div>
      <div class="box">
         <h3>follow us</h3>
         <a href="#"> <i class="fab fa-facebook-f"></i> facebook </a>
         <a href="#"> <i class="fab fa-twitter"></i> twitter </a>
         <a href="#"> <i class="fab fa-instagram"></i> instagram </a>
         <a href="#"> <i class="fab fa-tiktok"></i> tiktok </a>
      </div>
   </section>
   <p class="credit"> &copy; CAT201 Project 2024 by <span>Team YumYum</span> | Jom Makan </p>
</footer>

<script src= "js/script.js"></script>

</body>
</html>
