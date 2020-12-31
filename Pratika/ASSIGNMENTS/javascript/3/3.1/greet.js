var datetoday = new Date();
document.write(datetoday + "<br>");

var timenow = new Date().getHours();
if (timenow < 12) {
  document.write("Good Morning");
} else if (timenow >= 12 && timenow <= 17) {
  document.write("Good Afternoon");
} else if (timenow <= 24) {
  document.write("Good Evening");
}
