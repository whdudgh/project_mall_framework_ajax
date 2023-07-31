document.querySelector("#order_btn").addEventListener('click', (event) => {
  const totalPrice = document.querySelector('#cal_total_inner').textContent;
  const url = `order?totalPrice=${totalPrice}`
  window.location.href = url;
});
goods_check();

//🔴천단이 콤마 붙은 숫자 정수로 변경하는 함수
function stringNumberToInt(stringNumber) {
  return parseInt(stringNumber.replace(/,/g, ''));
}

function cal() {
  let priceAllTag = document.querySelectorAll(".amt");
  let cal_total = document.querySelector("#cal_total_inner");
  let amt = 0;
  for (i = 0; i < priceAllTag.length; i++) {
    amt = amt + stringNumberToInt(priceAllTag[i].innerHTML);
  }
  cal_totalAll = amt;
  cal_total.innerHTML = cal_totalAll.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}

//🔴페이지 로드되면 상품이 하나라도 있는지 확인
function goods_check() {
  let list = document.querySelectorAll("#list li")
  let listbox = document.querySelector("#list");
  let ship_fee = document.querySelector("#ship_fee");
  if (list.length == 0) {
    listbox.innerHTML = "장바구니에 상품이 없습니다."
    listbox.classList.add("list_null");
    cal();
  }
}

//🔴버튼으로 수량 조절 기능
function plusbutton(obj) {
  const productId = obj.value;
  let qty = obj.previousElementSibling;
  let price = obj.parentElement.previousElementSibling;
  let totalPrice = obj.parentElement.nextElementSibling;
  qtyInner = qty.innerHTML
  qtyInner = parseInt(qtyInner);
  qtyInner++;
  qty.innerHTML = qtyInner;
  priceInner = parseInt(price.innerHTML);
  totalPrice1 = priceInner * qtyInner;
  //천단위 콤마 붙이기
  totalPrice.innerHTML = totalPrice1.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
  cal();
  // 서버에  증가량 전송\
  sendMount(productId, qtyInner);
  
}

async function sendMount(productId, productMount) {
    let replys = await requestReplys(productId, productMount);
    console.log(replys);
}

function requestReplys(productId, productMount) {
    const url = `/mall/cart/update?productId=${productId}&productMount=${productMount}`;
    return fetch(url).then(response => response.json());
}


function minusbutton(obj) {
  const productId = obj.value;
  let qty = obj.nextElementSibling;
  let price = obj.parentElement.previousElementSibling;
  let totalPrice = obj.parentElement.nextElementSibling;
  qtyInner = qty.innerHTML
  qtyInner = parseInt(qtyInner);
  if (qtyInner > 1) {
    qtyInner--;
    qty.innerHTML = qtyInner;
    priceInner = parseInt(price.innerHTML);
    totalPrice1 = priceInner * qtyInner;
    //천단위 콤마 붙이기
    totalPrice.innerHTML = totalPrice1.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
  } else {
    alert("한 개 이상 선택해주세요")
  }
  cal();
  sendMount(productId, qtyInner);
}

//🔴리스트 삭제 기능
function remove() {
  let checkbox = document.querySelectorAll(".check");
  for (let i = 0; i < checkbox.length; i++) {
    if (checkbox[i].checked == true) {
      checkbox[i].parentElement.remove();
    }
  }
  cal();
  goods_check();
}
//🔴전체선택 기능
function checkAll() {
  let checkbox = document.querySelectorAll(".check");
  let checkAll = document.querySelector("#checkAll")
  if (checkAll.checked == true) {
    for (let i = 0; i < checkbox.length; i++) {
      checkbox[i].checked = true;
    }
  } else {
    for (let i = 0; i < checkbox.length; i++) {
      checkbox[i].checked = false;
    }
  }
}