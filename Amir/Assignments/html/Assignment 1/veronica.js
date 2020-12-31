function isValid() {
  var x = document.getElementById("referral").value;
  var dis = document.getElementById("discount");
  if (x <= 2000 && x >= 1000) {
    dis.value = "1200 $"
  } else {
    dis.innerHTML = "2000 $"
  }
}
