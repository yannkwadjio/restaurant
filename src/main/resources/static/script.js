let state=true;
(setInterval(()=>{
    if(state){
        $('.header__div').css('display','none');
        state=false;
    }else{
        $('.header__div').css('display','block');
        state=true;  
    }
   
},500))();

