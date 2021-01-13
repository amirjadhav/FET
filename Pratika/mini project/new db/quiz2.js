var currentQuestion = 0;
var viewingAns = 0;
var correctAnswers = 0;
var quizOver = false;
var iSelectedAnswer = [];
var qlength=0;
var c = 10*60;
var t;

var questions = [];

$(document).ready(function () {
  $(".preButton").click(function (e) {
    if ($(".preButton").text() == "View Answer") {
      currentQuestion=0;
      alert("view answer clicked");

      viewResults();
    }
    e.preventDefault();
  });

  $("#js").click(function (e) {
    var id = this.id;
    clickEvent(id);
    $(".quizContainer").show();
    e.preventDefault();
  });

  $("#c").click(function (e) {
    var id = this.id;
    clickEvent(id);
    e.preventDefault();
  });

  $(".submit").click(function (e) {
    displayScore();
    c = 185;
    $(document).find(".preButton").text("View Answer");
   // $(document).find(".nextButton").text("Play Again?");
    $(".nextButton").hide();
    quizOver = true;
    return false;
    //e.preventDefault();
  });

  function clickEvent(id) {
    $.ajax({
      method: "GET",
      url: "db.json",
      success: function (x) {
        console.log(id);
        x[id].forEach((items) => {
          console.log("items" + JSON.stringify(items));
          questions.push(items);
         // console.log(questions);
        });
        qlength=questions.length;
        console.log("question"+qlength);
      },
      complete: function (data) {
        console.log(data);
        displayCurrentQuestion(currentQuestion);
      },
      error: (e) => {
        alert("Error" + e);
      },
    });
  }

  // $(this).find(".quizMessage").hide();
  $(this).find(".preButton").attr("disabled", "disabled");

  timedCount();
  hideScore();

  $(this)
    .find(".preButton")
    .on("click", function () {
      if (!quizOver) {
        if (currentQuestion == 0) {
          return false;
        }

        if (currentQuestion == 1) {
          $(".preButton").attr("disabled", "disabled");
        }
        if (currentQuestion+2 != qlength) {
          $(".nextButton").prop("disabled", false);
        }

        currentQuestion--; // Since we have already displayed the first question on DOM ready
        if (currentQuestion < questions.length) {
          displayCurrentQuestion(currentQuestion);
        }
      } else {
        if (viewingAns == 3) {
          return false;
        }
        // currentQuestion = 0;
        viewingAns = 3;
        // viewResults();
      }
    });

  // On clicking next, display the next question
  $(this)
    .find(".nextButton")
    .on("click", function () {
      if (!quizOver) {
        var val = $("input[type='radio']:checked").val();
        console.log("val"+val)
        iSelectedAnswer[currentQuestion] = val;

        // TODO: Remove any message -> not sure if this is efficient to call this each time....
       // $(document).find(".quizMessage").hide();
        if (val == questions[currentQuestion].correct_option) {
          correctAnswers++;
        }
        if (currentQuestion+2 == qlength) {
          $(".nextButton").prop("disabled", true);
        }
        
        currentQuestion++; // Since we have already displayed the first question on DOM ready
        if (currentQuestion >= 1) {
          $(".preButton").prop("disabled", false);
        }

        if (currentQuestion < questions.length) {
          displayCurrentQuestion(currentQuestion);
        } else {
          //   displayScore();
      //    $("#iTimeShow").html("Quiz Time Completed!");
          /* $("#timer").html(
            "You scored: " + correctAnswers + " out of: " + questions.length
          );*/
          c = 185;
          //    $(document).find(".preButton").text("View Answer");
          //   $(document).find(".nextButton").text("Play Again?");
          // quizOver = true;
          //return false;
        //  alert("quiz completed");
        }
      } else {
        // quiz is over and clicked the next button (which now displays 'Play Again?'
        quizOver = false;
        $("#iTimeShow").html("Time Remaining:");
        iSelectedAnswer = [];
        $(document).find(".nextButton").text("Next Question");
        $(document).find(".preButton").text("Previous Question");
        $(".preButton").attr("disabled", "disabled");
        resetQuiz();
        viewingAns = 1;
        displayCurrentQuestion();
        hideScore();
      }
    });
});

function timedCount() {
  if (c == 185) {
    return false;
  }

  var hours = parseInt(c / 3600) % 24;
  var minutes = parseInt(c / 60) % 60;
  var seconds = c % 60;
  var result =
    (hours < 10 ? "0" + hours : hours) +
    ":" +
    (minutes < 10 ? "0" + minutes : minutes) +
    ":" +
    (seconds < 10 ? "0" + seconds : seconds);
  $("#timer").html(result);

  if (c == 0) {
    displayScore();
    $("#iTimeShow").html("Quiz Time Completed!");
    /*  $("#timer").html(
      "You scored: " + correctAnswers + " out of: " + questions.length
    );*/
    c = 185;
    $(document).find(".preButton").text("View Answer");
    $(document).find(".nextButton").text("Play Again?");
    quizOver = true;
    return false;
  }

  c = c - 1;
  t = setTimeout(function () {
    timedCount();
  }, 1000);
}

// This displays the current question AND the choices
function displayCurrentQuestion(currentQuestion) {
  if (c == 185) {
    c = 180;
    timedCount();
  }
  //console.log("In display current Question");
  var question = questions[currentQuestion].question;
  

  //console.log("question"+question);
  //console.log("questions"+JSON.stringify(questions[currentQuestion].option_1))
  var questionClass = $(document).find(".quizContainer > .question");
  $(questionClass).text((currentQuestion+1)+"  "+question);
  var choiceList = $(document).find(".quizContainer > .choiceList");
 // var numChoices = questions[currentQuestion].choices.length;
  // Set the questionClass text to the current question
 
  // Remove all current <li> elements (if any)
  $(choiceList).find("li").remove();
  //var choice="hii";
  var option_1=questions[currentQuestion].option_1;
  var option_2=questions[currentQuestion].option_2;
  var option_3=questions[currentQuestion].option_3;
  var option_4=questions[currentQuestion].option_4;
  //console.log("option1"+option_1)
  //console.log("option2"+option_2)
  //console.log("option3"+option_3)
  //console.log("option4"+option_4)
  


    //choice = questions[currentQuestion].choices[i];

    
      $(
        '<li><input type="radio" class="radio-inline" value=' +
        (1)  +
        ' name="dynradio" />' +
        " " +
        (option_1)+
        "</li>"
      ).appendTo(choiceList);

      $(
        '<li><input type="radio" class="radio-inline" value=' +
        (2)  +
        ' name="dynradio" />' +
        " " +
        (option_2)+
        "</li>"
      ).appendTo(choiceList);
    
      $(
        '<li><input type="radio" class="radio-inline" value=' +
        (3)  +
        ' name="dynradio" />' +
        " " +
        (option_3)+
        "</li>"
      ).appendTo(choiceList);
    
      $(
        '<li><input type="radio" class="radio-inline" value=' +
        (4)  +
        ' name="dynradio" />' +
        " " +
        (option_4)+
        "</li>"
      ).appendTo(choiceList);
    
    
  
}



function displayScore() {
  $(document)
    .find(".quizContainer > .result")
    .text("You scored: " + correctAnswers + " out of: " + questions.length);
  $(document).find(".quizContainer > .result").show();
}

function hideScore() {
  $(document).find(".result").hide();
}







// This displays the current question AND the choices
function viewResults() {
  if (currentQuestion == 10) {
    currentQuestion = 0;
    return false;
  }
  if (viewingAns == 1) {
    return false;
  }

  hideScore();
  //currentQuestion=0;
  var question = questions[currentQuestion].question;
  var questionClass = $(document).find(".quizContainer > .question");
  var choiceList = $(document).find(".quizContainer > .choiceList");
  var numChoices = questions[currentQuestion].choices.length;
  // Set the questionClass text to the current question
  $(questionClass).text(question);
  // Remove all current <li> elements (if any)
  $(choiceList).find("li").remove();
  var choice;

  for (i = 0; i < numChoices; i++) {
    choice = questions[currentQuestion].choices[i];

    if (iSelectedAnswer[currentQuestion] == i) {
      if (questions[currentQuestion].correctAnswer == i) {
        $(
          '<li style="border:2px solid green;margin-top:10px;"><input type="radio" class="radio-inline" checked="checked"  value=' +
            i +
            ' name="dynradio" />' +
            " " +
            choice +
            "</li>"
        ).appendTo(choiceList);
      } else {
        $(
          '<li style="border:2px solid red;margin-top:10px;"><input type="radio" class="radio-inline" checked="checked"  value=' +
            i +
            ' name="dynradio" />' +
            " " +
            choice +
            "</li>"
        ).appendTo(choiceList);
      }
    } else {
      if (questions[currentQuestion].correctAnswer == i) {
        $(
          '<li style="border:2px solid green;margin-top:10px;"><input type="radio" class="radio-inline" value=' +
            i +
            ' name="dynradio" />' +
            " " +
            choice +
            "</li>"
        ).appendTo(choiceList);
      } else {
        $(
          '<li><input type="radio" class="radio-inline" value=' +
            i +
            ' name="dynradio" />' +
            " " +
            choice +
            "</li>"
        ).appendTo(choiceList);
      }
    }
  }

  currentQuestion++;

  setTimeout(function () {
    viewResults();
  }, 3000);
}
