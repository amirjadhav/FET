function buttonSelectedFirstOddRow_click(){
    var select_row = document.querySelector('li.odd');
    select_row.style.color ="red";
    var x = document.getElementById("status");
    x.innerHTML="First Odd is Selected";
}
function buttonSelectedFirstEvenRow_click(){
    var select_row = document.querySelector('li.even');
    select_row.style.color ="green";
    var x = document.getElementById("status");
    x.innerHTML="First Even is selected";
}
function buttonSelectedAllOddRows_click(){
    var select_row = document.querySelectorAll('li.odd');
    for(var i= 0;i<select_row.length;i++)
    select_row[i].style.color ="red";
    var x = document.getElementById("status");
    x.innerHTML="All odd are Selected";
}
function buttonSelectedAllEvenRows_click(){
    var select_row = document.querySelectorAll('li.even');
    for(var i= 0;i<select_row.length;i++)
    select_row[i].style.color ="green";
    var x = document.getElementById("status");
    x.innerHTML="All even are selected";
}
function buttonSelectedAllRows_click(){
    var select_row = document.querySelectorAll('li.odd, li.even');
    for(var i= 0;i<select_row.length;i++)
    select_row[i].style.color ="pink";
    var x = document.getElementById("status");
    x.innerHTML="All rows are selected";
}