function checkFail(fail){
    for(var i of fail) if (i==="") return false;
    return true;
 }
 function check(){
    $("input[type=password").each(function(i,j){
       arr.push($(j).val());
       var result = checkFail(arr);//데이터 확인하려고 반환값 저장
       console.log(result);
       if($(this).val()===""){
          alert("빈칸을 채워주세요.");
       
          event.preventDefault(); //다른 페이지로 이동하지 못 하도록 방지
       }
    })
    console.log(arr);//배열 데이터 확인
 }
 $(document).ready(function(){
    $("[type=submit]").click(function(){
       check();
    })
 })