if (localStorage && sessionStorage) {
  var x = document.getElementById("detectfeatures");
  x.innerHTML = "Status :Your browser support both local and session storage";
} else {
  var x = document.getElementById("detectfeatures");
  x.innerHTML =
    "Status: Your browser does not support both local and session storage";
}

function showData() {
  var x = document.forms["myForm"]["key"].value;
  var y = document.forms["myForm"]["value"].value;

  console.log(x + "   " + y);
  SaveStorageData(x, y);
}

function SaveStorageData(x, y) {
  if (typeof (Storage !== "undefined")) {
    localStorage.setItem(x, y);
    sessionStorage.setItem(x, y);

    refreshTableLocal();
    refreshTableSession();
  } else {
  }
}
function refreshTableLocal() {
  var rowdata = ["Key", "value", "Action"];
  function tableCreate() {
    var body = document.body,
      tbl = document.createElement("table");
    tbl.style.position = "absolute";
    tbl.style.top = "250px";
    tbl.style.left = "100px";
    tbl.style.cssFloat = "left";
    tbl.style.width = "500px";
    tbl.style.border = "1px solid black";
    tbl.style.borderCollapse = "collapse";

    for (var i = 0; i < localStorage["length"] + 1; i++) {
      var tr = tbl.insertRow();
      for (var j = 0; j < 3; j++) {
        var td = tr.insertCell();
        if (i == 0) {
          td.appendChild(document.createTextNode(rowdata[j]));
          td.style.border = "1px solid black";
        } else {
          var key = localStorage.key(i - 1);
          if (j == 0) td.appendChild(document.createTextNode(key));
          if (j == 1)
            td.appendChild(document.createTextNode(localStorage.getItem(key)));
          if (j == 2){
            console.log("Value of key is :"+key)
            var r=key;
            console.log("r value"+r);
          td.innerHTML = `<input type="button" value="Clear key"  onclick="deletelocalitem(${r})"/>`;
          }
          td.style.border = "1px solid black";
        }
      }
      
    }
    body.appendChild(tbl);
  }
  tableCreate();
}
refreshTableLocal();  

function refreshTableSession() {
  var rowdata = ["Key", "value", "Action"];
  function tableCreate() {
    var body = document.body,
      tbl = document.createElement("table");
    tbl.style.position = "absolute";
    tbl.style.top = "250px";
    tbl.style.right = "100px";
    tbl.style.cssFloat = "right";
    tbl.style.width = "500px";
    tbl.style.border = "1px solid black";
    tbl.style.borderCollapse = "collapse";

    for (var i = 0; i < sessionStorage["length"] + 1; i++) {
      var tr = tbl.insertRow();
      for (var j = 0; j < 3; j++) {
        var td = tr.insertCell();
        if (i == 0) {
          td.appendChild(document.createTextNode(rowdata[j]));
          td.style.border = "1px solid black";
        } else {
          var key = sessionStorage.key(i - 1);
          if (j == 0) td.appendChild(document.createTextNode(key));
          if (j == 1)
            td.appendChild(document.createTextNode(sessionStorage.getItem(key)));
          if (j == 2){
             console.log("Value of key is :"+key)
             var r=key;
             console.log("r value"+r);
            td.innerHTML = `<input type="button" value="Clear key" name=${key} id=${key} onclick="deletesessionitem(${r})"/>`
          }
          td.style.border = "1px solid black";
          console.log(key);
        }
      }
    }
    body.appendChild(tbl);
  }
  tableCreate();
}
refreshTableSession();


function resetLocal(){
    console.log("resetting local storage");    
    localStorage.clear();
    window.location.reload();
}

function resetSession(){
    console.log("resetting session storage");
    sessionStorage.clear();
    window.location.reload();
}
function deletelocalitem(key){
  //console.log(key)
    console.log('delete item pressed');
   // var x = document.getElementById(key.value); 
    //var key =document.getElementsByName("key");
   // console.log(x);
    localStorage.removeItem(key.name);
}
function deletesessionitem(key){
    console.log("Hello")
    console.log("inside delete"+key.name)
    console.log('delete item pressed');
   // var x = document.getElementById(key); 
    //var key =document.getElementsByName("key");
  //  console.log(x);
    sessionStorage.removeItem(key.name);
}