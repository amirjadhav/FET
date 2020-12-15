const reading = document.getElementById('reading')
const movies = document.getElementById('movies')
const photo = document.getElementById('photo')
var count =0;
var x = document.getElementById("writer");


x.style.display = "none"
x.setAttribute("type", "hidden");

reading.addEventListener('change', (event) => {
  if (event.target.checked) {
    x.style.display = "block"
    count++;
  } else {
      count--;
    x.style.display = "none"
  }
})
movies.addEventListener('change', (event) => {  
  if (event.target.checked) {
    count++;

  } else {
    count--;

  }
})
photo.addEventListener('change', (event) => {
  if (event.target.checked) {
    count++;

  } else {
    count--;

  }
})


function checkValidation(){
    if(count > 0){
        console.log("truee");
        return true;
    }
    else{
        console.log("false");
        return false;
    }
}

(function() {
  const form = document.querySelector('#check');
  const checkboxes = form.querySelectorAll('input[type=checkbox]');
  const checkboxLength = checkboxes.length;
  const firstCheckbox = checkboxLength > 0 ? checkboxes[0] : null;

  function init() {
      if (firstCheckbox) {
          for (let i = 0; i < checkboxLength; i++) {
              checkboxes[i].addEventListener('change', checkValidity);
          }

          checkValidity();
      }
  }


  $(".dateid").on("change", function() {
    this.setAttribute(
        "data-date",
        moment(this.value, "YYYY-MM-DD")
        .format( this.getAttribute("data-date-format") )
    )
}).trigger("change")



  function isChecked() {
      for (let i = 0; i < checkboxLength; i++) {
          if (checkboxes[i].checked) return true;
      }

      return false;
  }

  function checkValidity() {
      const errorMessage = !isChecked() ? 'At least one checkbox must be selected.' : '';
      firstCheckbox.setCustomValidity(errorMessage);
  }

  init();
})();


document.getElementById("appname").innerHTML = detectBrowser();




//gets the type of browser
function detectBrowser() { 
  if((navigator.userAgent.indexOf("Opera") || navigator.userAgent.indexOf('OPR')) != -1 ) {
      return 'Opera';
  } else if(navigator.userAgent.indexOf("Chrome") != -1 ) {
      return 'Chrome';
  } else if(navigator.userAgent.indexOf("Safari") != -1) {
      return 'Safari';
  } else if(navigator.userAgent.indexOf("Firefox") != -1 ){
      return 'Firefox';
  } else if((navigator.userAgent.indexOf("MSIE") != -1 ) || (!!document.documentMode == true )) {
      return 'IE';//crap
  } else {
      return 'Unknown';
  }
} 