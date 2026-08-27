// *
console.log( "INDEX.JS 열림")

// [1] 전체조회
async function waitingFindAll(){
    console.log( "waitingFindAll 열림");
    let tbody = document.querySelector('.waitingList');
    let html = "";
    const 응답결과 = await axios.get( "http://127.0.0.1:8080/waiting/findall" )
    const 대기리스트 = 응답결과.data;
        for( let index = 0 ; index <= 대기리스트.length-1 ; index++){
            const 대기객체 = 대기리스트[ index ];
            html += `<tr>
                    <td> ${ 대기객체.phone} </td> <td> ${ 대기객체.headcount} </td>
                    <td> 
                    <button onclick="waitingUpdate('${ 대기객체.phone }')">수정</button> 
                        <button onclick="waitingDelete('${ 대기객체.phone }')">삭제</button>
                        </td>
                    </tr>`
        }
    tbody.innerHTML = html;                          
} // f end
waitingFindAll();

// [2] 등록
async function waitingSave(){
    const phone = document.querySelector('.phone').value;
    const headcount = document.querySelector('.headcount').value;
    const response = await axios.post( `/waiting/save?phone=${ phone }&headcount=${ headcount }` );
    if( response.data == true ){ 
        alert('저장성공');
        waitingFindAll();
    }
    else{ alert('저장실패');}
}

// [3] 수정
async function waitingUpdate( phone ){
    const headcount = prompt('수정할 인원수: ');
    const response = await axios.put( `/waiting/update?phone=${ phone }&headcount=${ headcount }`);
    if( response.data == true ){
        alert('수정 성공');
        waitingFindAll();
    }else{ alert('수정 실패'); }
}

// [4] 삭제
async function waitingDelete( phone ){
    const response = await axios.delete( `/waiting/delete?phone=${ phone }` );
    if( response.data == true ){
        alert('삭제 성공');
        waitingFindAll();
    }else{
        alert('삭제 실패');
    }
}