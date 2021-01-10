var currentQuestion = 0;
var viewingAns = 0;
var correctAnswers = 0;
var quizOver = false;
var iSelectedAnswer = [];
var c = 180;
var t;

var questions = [];

$(document).ready(function () {
  $(".preButton").click(function (e) {
    if ($(".preButton").text() == "View Answer") {
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
    $(document).find(".nextButton").text("Play Again?");
    quizOver = true;
    return false;
    e.preventDefault();
  });

  function clickEvent(id) {
    $.ajax({
      method: "GET",
      url: "db.json",
      success: function (x) {
        console.log(id);
        x[id].forEach((items) => {
          console.log("items" + items);
          questions.push(items);
          console.log(questions);
        });
        // console.log("question"+myQuestions);
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

        // TODO: Remove any message -> not sure if this is efficient to call this each time....
        $(document).find(".quizMessage").hide();
        if (val == questions[currentQuestion].correctAnswer) {
          correctAnswers++;
        }
        iSelectedAnswer[currentQuestion] = val;

        currentQuestion++; // Since we have already displayed the first question on DOM ready
        if (currentQuestion >= 1) {
          $(".preButton").prop("disabled", false);
        }
        if (currentQuestion < questions.length) {
          displayCurrentQuestion(currentQuestion);
        } else {
          //   displayScore();
          $("#iTimeShow").html("Quiz Time Completed!");
          /* $("#timer").html(
            "You scored: " + correctAnswers + " out of: " + questions.length
          );*/
          c = 185;
          //    $(document).find(".preButton").text("View Answer");
          //   $(document).find(".nextButton").text("Play Again?");
          // quizOver = true;
          //return false;
          alert("quiz completed");
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
      $(
        '<li><input type="radio" class="radio-inline" checked="checked"  value=' +
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

function resetQuiz() {
  currentQuestion = 0;
  correctAnswers = 0;
  hideScore();
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
function viewResults1() {
  // if (currentQuestion == 10) {
  //   currentQuestion = 0;
  //   return false;
  // }
  // if (viewingAns == 1) {
  //   return false;
  // }
  currentQuestion = 0;

  //var question = questions[currentQuestion].question;
  var questionClass = $(document).find(".quizContainer > .question");
  var choiceList = $(document).find(".quizContainer > .choiceList");
 // var numChoices = questions[currentQuestion].choices.length;
  // Set the questionClass text to the current question
 // $(".view_result").append("hello");
  console.log("questions length" + questions.length)

  for (var j = 0; j< questions.length; j++) {
  //  console.log("hiiiiii");
  //  alert("hiiiiii");
  ///  $(".view_result").append(i);
    var question = questions[currentQuestion].question;
    var numChoices = questions[currentQuestion].choices.length;
    $(".view_result").append($(questionClass).text(question));

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
    $(".view_result").append(choiceList);

    currentQuestion++;
  }

  // setTimeout(function () {
  //   viewResults();
  // }, 3000);
}


function viewResults() {
  console.log("in view result");
  
  // variable to store the HTML output
  const output = [];

  // for each question...
  questions.forEach(
    (currentQuestion, questionNumber) => {
      console.log("current question"+currentQuestion);
      console.log("current question no"+questionNumber);

      // variable to store the list of possible answers
      const answers = [];
       console.log("ans"+currentQuestion.choices)
      // and for each available answer...
      for(letter in currentQuestion.choices){

        // ...add an HTML radio button
        answers.push(
          `<label>
            <input type="radio" name="question${questionNumber}" value="${letter}">
            ${letter} :
            ${currentQuestion.choices[letter]}
          </label>`
        );
      }
      console.log("answers"+answers);

      // add this question and its answers to the output
     // $(".view_result").append(i);
      $(".view_result").append(
        `<div class="question"> ${currentQuestion.question} </div>
        <div class="answers"> ${answers.join('')} </div>`
      );
    }
  );
}
