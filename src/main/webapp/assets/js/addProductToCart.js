// 이벤트 소스에 이벤트 리스너 등록
document.querySelector('#cart').addEventListener('click', event => {
	resultRequest();
});

// 로그인 상태정보 알아오기
function loginStatusRequest() {
  const url = `/mall/check-login-status`;
	return fetch(url).then(response => response.json());
}

// 페이지 이동없이 /cart에 pkey값을 보내주기
function sendPkeyToServer(pkey) {
  const url = `/mall/cart?pkey=${pkey}`;
  fetch(url)
    .then((response) => {
      if (response.ok) {
        // 서버가 요청을 성공적으로 처리한 경우
        // console.log('pkey sent to server:', pkey);
      } else {
        // 서버가 요청을 실패로 처리한 경우
        // console.error('Failed to send pkey to server.');
      }
    })
    .catch((error) => {
      // 네트워크 오류 등 예외 처리
      // console.error('An error occurred while sending data to the server:', error);
    });
}

/* 객체나 복잡한 데이터 포스트방식으로 보낼 때
async function sendDataToServer(pkey) {
  try {
    const response = await fetch('/cart', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ pkey }), // Sending pkey as JSON data
    });

    if (response.ok) {
      // Data sent successfully
      console.log('pkey sent to server:', pkey);
    } else {
      // Handle server error or other response status
      console.error('Failed to send pkey to server.');
    }
  } catch (error) {
    console.error('An error occurred while sending data to the server:', error);
  }
}
*/

// 로그인 상태에 따른 버튼의 기능변환
async function resultRequest() {
  const exist = await loginStatusRequest();
  const pkey = document.querySelector('#pkey').textContent;
  const url = `cart?pkey=${pkey}`;
  if (exist === true) {
	await sendPkeyToServer(pkey);
    // true일 경우
    Swal.fire({
      icon: 'success',
      title: '장바구니에 추가되었습니다.',
      showCancelButton: true,
      confirmButtonColor: '#12322C', // 확인 버튼 색상
  	  cancelButtonColor: '#000',  
      confirmButtonText: '장바구니로 이동',
      cancelButtonText: '쇼핑 계속하기'
    }).then((result) => {
      if (result.isConfirmed) {
		  
        window.location.href = url;
        
      } else {
        // 쇼핑을 계속
        // 현재 페이지에 남도록 처리
      }
    });
  } else {
        // false일 경우
    // 로그인 화면으로 이동
    window.location.href = 'login';
}
}