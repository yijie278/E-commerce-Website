let navbar = document.querySelector('.header .flex .navbar');

document.querySelector('#menu-btn').onclick = () => {
   navbar.classList.toggle('active');
   profile.classList.remove('active');
}

let profile = document.querySelector('.header .flex .profile');

document.querySelector('#user-btn').onclick = () => {
   profile.classList.toggle('active');
   navbar.classList.remove('active');
}

window.onscroll = () => {
   profile.classList.remove('active');
   navbar.classList.remove('active');
}

products.forEach(product => {
   const productCard = `
      <div class="box">
         <img src="${product.image}" alt="${product.name}">
         <h3>${product.name}</h3>
         <div class="price">${product.price}</div>
         <a href="product_details.jsp?productId=${product.id}" class="btn">View Details</a>
      </div>
   `;
   container.innerHTML += productCard;
});
