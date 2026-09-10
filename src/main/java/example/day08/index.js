// .js 파일은 .html 파일내 <script src="index.js"></script> 코드로 포함된다.
// 즉 js코드는 html내 포함된다.

// 1. 변수와 상수
let count = 10;         // let 변수선언 키워드
    count = 3;          // 변수는 수정가능
const count2 = 20;      // const 상수선언 키워드
    // count2 =4;       // 상수는 수정 불가능 

// 2. 문자열 템플릿 , ``백틱
console.log( `hello $(count)` );
let html = `<div> hello $(count2) </div> `
console.log( html )

// 3. 조건문 , if
const point = 85;
if( point >= 90 ){ console.log('A학점'); } // 만약에 point변수가 90이상이면 A학점
else if( point >= 90 ){ console.log(`B학점`);} // 만약에 point변수가 80이상이면 B학점
else{ console.log(`C학점`);} // 그외 C학점
// 3-2 : 삼항연산자 ,       조건 ? 참 : 거짓 ,      조건1 ? 참1 : 조건2 ? 참2 : 거짓


