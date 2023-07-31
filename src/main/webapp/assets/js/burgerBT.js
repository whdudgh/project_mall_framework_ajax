const hamburgerBtn = document.querySelector('.hamburger-btn');
const sidebar = document.querySelector('.sidebar');
const closeBtn = document.querySelector('.close-btn');
//const category1 = document.querySelector('.category[data-category="1"]');
//const category2 = document.querySelector('.category[data-category="2"]');
//const category3 = document.querySelector('.category[data-category="3"]');

hamburgerBtn.addEventListener('click', () => {
  sidebar.classList.toggle('active');
  document.querySelector('.overlay').style.display='block';
});

closeBtn.addEventListener('click', () => {
  sidebar.classList.remove('active');
  document.querySelector('.overlay').style.display='none';
});

/*
category1.addEventListener('click', () => {
  showProductsForCategory(1);
});
*/

/*
category2.addEventListener('click', () => {
  showProductsForCategory(2);
});

category3.addEventListener('click', () => {
  showProductsForCategory(3);
});
*/

const productList = document.querySelector('.product-list');

function showProductsForCategory(categoryNumber) {
  productList.innerHTML = '';

  for (let i = 1; i <= 4; i++) {
    const productItem = document.createElement('li');
    productItem.textContent = `카테고리${categoryNumber} 상품 ${i}`;
    productList.appendChild(productItem);
  }
}