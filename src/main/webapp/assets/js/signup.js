// // 이벤트 소스에 이벤트 리스너 등록
// document.querySelector('#uEmail').addEventListener('input', event => {
//   emailCheck(event);
// });

// async function emailCheck(event) {
//   let inputEmail = event.target.value;
//   // 유효 이메일 체크
//   if(Validator.isId(inputEmail)){
//      const exist = await httpRequest(inputEmail);
//      if(exist){
//         showMessage(false, "이미 사용중인 이메일입니다.");   
//      }else {
//         showMessage(true, "사용 가능한 이메일입니다.");
//      }
//   }else{
//      showMessage(false, "맞지않는 이메일 형식입니다.");      
//   }
// }

// function httpRequest(inputEmail) {
//   const url = `/mall/customer/emailcheck?email=${inputEmail}`;
//   return fetch(url).then(response => response.json());
// }

// // 이메일 중복 결과 출력
// function showMessage(valid, message) {
//   const view = document.querySelector("#???");
//   if (view) {
//      if (valid) {
//         view.innerHTML = message;
//         view.className = "text-primary";
//      } else {
//         view.innerHTML = message;
//         view.className = "text-danger";
//      }
//   }
// }


// 가입버튼 제약 함수

function submitForm() {

  let uname = document.querySelector("#name") //이름 입력
  let uem = document.querySelector("#fEmail") //이메일 입력
  let uemm = document.querySelector("#bEmail") //이메일 입력
  let upw = document.querySelector("#pw") //비밀번호 입력
  let pwPattern = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
  let pwErrorMsg = document.querySelector("#pw") // 비밀번호 양식 오류
  let unn = document.querySelector("#checkpw") //비밀번호 확인 입력
  let uph = document.querySelector("#phone") //올바른 핸드폰번호 입력
  let phonePattern = /01[016789][^0][0-9]{2,3}[0-9]{3,4}/; //핸드폰패턴 유효성
  let phoneErrorMsg = document.querySelector("#phonecheck"); // 핸드폰 양식 오류
  let ubir = document.querySelector("#birth") //생일 입력
  let birthPattern = /^(19[0-9][0-9]|20\d{2})(0[0-9]|0[0-9])(0[1-9]|[1-2][0-9]|3[0-1])$/; //생일패턴 유효성
  let birthErrorMsg = document.querySelector("#birth") // 생일 양식 오류
  let checkBox = document.getElementById("checkBox"); //체크박스 입력
  let name = document.querySelector('#name').value;
  let fEmail = document.querySelector('#fEmail').value;
  let bEmail = document.querySelector('#bEmail').value;
  let pw = document.querySelector('#pw').value;
  let phone = document.querySelector('#phone').value;
  let birth = document.querySelector('#birth').value;

  if (uname.value == "") {
    Swal.fire('이름을 입력하세요')
    uid.focus();
  } else if (uem.value == "") {
    Swal.fire('이메일 아이디를 입력하세요')
    uem.focus();
  } else if (uemm.value == "") {
    Swal.fire('이메일 주소를 입력하세요')
    uemm.focus();
  } else if (upw.value == "") {
    Swal.fire('비밀번호를 입력하세요')
    upw.focus();
  } else if (unn.value == "") {
    Swal.fire('비밀번호를 한번더 입력하세요')
    unn.focus();
  } else if (upw.value != unn.value) {
    Swal.fire('비밀번호가 동일하지 않습니다')
    upw.focus();
  }  else if (!pwPattern.test(upw.value)) {
    Swal.fire('비밀번호를 영문, 숫자 혼합하여 6~20자리 이내로 해주세요')
    pwErrorMsg.focus();
  } else if (uph.value == "") {
    Swal.fire('핸드폰번호 입력해주세요')
    uph.focus();
  } else if (!phonePattern.test(uph.value)) {
    Swal.fire('핸드폰번호를 올바르게 입력해주세요(예. 01012341234)')
    phoneErrorMsg.focus();
  } else if (ubir.value == "") {
    Swal.fire('생년월일을 입력해주세요')
    ubir.focus();
  }else if (!birthPattern.test(ubir.value)) {
    Swal.fire('생일을 올바르게 입력해주세요(예.20020115)')
    phoneErrorMsg.focus();
  } else if (!checkBox.checked) {
    Swal.fire('개인정보 수집 및 이용 동의에 체크해주세요')
    checkBox.focus();
  } else {
    Swal.fire({
      icon: 'success',
      title: '가입을 축하드립니다',
      text: '회원가입 완료',
    })
      .then((result) => {
        if (result.isConfirmed) {
        window.location.href = `/mall/customer/signup?name=${name}&fEmail=${fEmail}&bEmail=${bEmail}&pw=${pw}&phone=${phone}&birth=${birth}`;
        }
      });
  }
}

//이메일 셀렉트
function em(ems) { 
  let email = ems.previousSibling.previousSibling;
  email.value = ems.value;
}

//돌아가기 버튼 함수

function back() {
  location.href = "bi.html"
}

function toggleTable() {
  let table = document.getElementById("dropdownContent");
  if (table.style.display === "none") {
    table.style.display = "block";
  } else {
    table.style.display = "none";
  }
}

// 체크박스 함수a

function checkBox() {
  document.getElementById("checkBox").checked = true;
}

async function sweetAlert(title, text) {
  const { value: accept } = await Swal.fire({
    imageUrl: '/assets/image/약관.png',
    imageWidth: 550,
    imageHeight: 200,
    imageAlt: 'Custom image',
    // footer: '<a href="">동의하시나요?</a>'
    input: 'checkbox',
    inputValue: 1,
    inputPlaceholder:
      '나는 개인정보 수집 및 이용약관에 동의합니다.',
    confirmButtonText:
      '동의 <i class="fa fa-arrow-right"></i>',
    inputValidator: (result) => {
      return !result && '약관에 동의하셔야 이용이 가능합니다.'
    }
  })
  if (accept) {
    Swal.fire('이용약관에 동의하셨습니다 :)')
    checkBox();
  }


}