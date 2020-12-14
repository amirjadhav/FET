var href = location.href;
var pathname = location.pathname;
var protocol = location.protocol;

document.getElementById('href').innerHTML = href
document.getElementById('path').innerHTML = pathname
document.getElementById('protocol').innerHTML = protocol

function goBack() {
    window.history.back();
  }
// console.log(href);
// console.log(pathname);
// console.log(protocol);

