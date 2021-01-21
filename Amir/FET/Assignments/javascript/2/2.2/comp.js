function calculate() {
  var p = document.getElementById("p").value
  var r = document.getElementById("r").value
  var n = document.getElementById("n").value

  var resultelement = document.getElementById("result")

  var result =  (p * Math.pow((1 + (r/100)),n)) - p
  resultelement.innerHTML = result
}
