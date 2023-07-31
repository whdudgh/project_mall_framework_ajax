// 이벤트 소스에 이벤트 리스너 등록
document.querySelector('#login').addEventListener('click', event => {
  resultRequest();
});

// 로그인 상태정보 알아오기
function loginStatusRequest(umail, upwd) {
  const url = `/mall/check-login-status?username=${umail}&password=${upwd}`;
  return fetch(url).then(response => response.json());
}

// 로그인 상태에 따른 버튼의 기능변환
/*
async function resultRequest() {
  const umail = document.querySelector('#username').value;
  const upwd = document.querySelector('#password').value;

  const exist = await loginStatusRequest(umail,upwd);
  console.log(exist);
   if (exist === true) {
    Swal.fire({
         icon: 'success',
         title: 'Oops...',
         text: '로그인을 성공하셨습니다!',
       })
   } else {
    Swal.fire({
         icon: 'error',
         title: 'Oops...',
         text: '로그인에 실패하셨습니다!',
     })
     window.location.href = 'login';
 }
}
*/

function redirectToIndex() {
  location.href('/mall/cart');
}

async function resultRequest() {
  const umail = document.querySelector('#username').value;
  const upwd = document.querySelector('#password').value;

  try {
    const exist = await loginStatusRequest(umail, upwd);

    if (exist === true) {
      Swal.fire({
        icon: 'success',
        title: 'Good...',
        text: '로그인을 성공하셨습니다!',
      });
      setTimeout(() => {
        redirectToIndex()
      }, 300000); // 3초 후에 로그인 페이지로 이동 (3000 밀리초 = 3초)
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: '로그인에 실패하셨습니다!',
      });
      setTimeout(() => {
        window.location.href = 'login';
      }, 300000); // 3초 후에 로그인 페이지로 이동 (3000 밀리초 = 3초)
    }
  } catch (error) {
    console.error('Error:', error);
  }
}



// async function resultRequest() {
//   const exist = await loginStatusRequest();
//   const pkey = document.querySelector('#pkey').textContent;
//   const url = `cart?pkey=${pkey}`;
//   if (exist === true) {
//    await sendPkeyToServer(pkey);
//     // true일 경우
//     Swal.fire({
//       icon: 'success',
//       title: '장바구니에 추가되었습니다.',
//       showCancelButton: true,
//       confirmButtonColor: '#12322C', // 확인 버튼 색상
//        cancelButtonColor: '#000',  
//       confirmButtonText: '장바구니로 이동',
//       cancelButtonText: '쇼핑 계속하기'
//     }).then((result) => {
//       if (result.isConfirmed) {
        
//         window.location.href = url;
        
//       } else {
//         // 쇼핑을 계속
//         // 현재 페이지에 남도록 처리
//       }
//     });
//   } else {
//         // false일 경우
//     // 로그인 화면으로 이동
//     window.location.href = 'login';
// }
// }

// async function login_check() {
// 	if(){
//  Swal.fire({
//   icon: 'success',
//   title: 'Oops...',
//   text: '로그인을 성공하셨습니다!',
// })
// }
// else(){
//   Swal.fire({
//   icon: 'error',
//   title: 'Oops...',
//   text: '로그인에 실패하셨습니다!',
// })
// }
// }