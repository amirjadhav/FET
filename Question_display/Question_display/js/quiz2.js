var currentQuestion = 0;
var correctAnswers = 0;
var quizOver = false;
var iSelectedAnswer = [];
var qlength = 0;
var c = 10 * 60;
var t;
var category_name;

var questions = [];

//var modal = document.getElementById('submitModal');

$(document).ready(function () {
  category_name = window.location.search.split("?")[1].split("=")[1];
  //console.log(codeid);
  $(this).find(".preButton").attr("disabled", "disabled");
  // $(".h1").text(codeid)

  clickEvent(category_name);
  $(".quizContainer").show();
  timedCount();
  hideScore();

  //Ajax method to get json data
  function clickEvent(id) {
    $.ajax({
      method: "GET",
      url: " http://localhost:3000/" + id,
      success: function (x) {
        x.forEach((items) => {
          questions.push(items);
        });
        qlength = questions.length;
      },
      complete: function (data) {
        displayCurrentQuestion(currentQuestion);
      },
      error: (e) => {
        alert("Error" + e);
      },
    });
  }

  //  click on previous Question button
  $(this)
    .find(".preButton")
    .on("click", function () {
      if (!quizOver) {
        if (currentQuestion == 1) {
          $(".preButton").attr("disabled", "disabled");
        }
        if (currentQuestion + 2 != qlength) {
          $(".nextButton").prop("disabled", false);
        }

        currentQuestion--;
        if (currentQuestion < questions.length) {
          displayCurrentQuestion(currentQuestion);
        }
      }
      if ($(".preButton").text() == "View Answer") {
        currentQuestion = 0;
        $(".question").text("");
        $(".choiceList").hide();
        viewResults();
      }
    });

  // click on next button
  $(this)
    .find(".nextButton")
    .on("click", function () {
      if (!quizOver) {
        if (currentQuestion + 2 == qlength) {
          $(".nextButton").prop("disabled", true);
        }

        currentQuestion++;
        if (currentQuestion >= 1) {
          $(".preButton").prop("disabled", false);
        }

        if (currentQuestion < questions.length) {
          displayCurrentQuestion(currentQuestion);
        } else {
          c = 185;
        }
      }
    });

  //update correct answers after select choice
  $(document).on("click", ".quizContainer > .choiceList ", function () {
    var val = $("input[type='radio']:checked").val();
    if (val == questions[currentQuestion].correct_option) {
      correctAnswers++;
    }
    console.log("val" + val);
    iSelectedAnswer[currentQuestion] = val;
  });

  $(".submitbtn").click(function (e) {
    displayScore();
    c = 185;
    $("#iTimeShow").hide();
    $(".question").hide();
    $(".choiceList").hide();
    $(document).find(".preButton").text("View Answer");
    $(".preButton").prop("disabled", false);
    $(".submit").hide();

    $(".nextButton").hide();
    quizOver = true;
    return false;
  });
});

// update time
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
    $(document).find(".preButton").text("View Answer");
    $(".preButton").prop("disabled", false);
    $(".submit").hide();

    $(".nextButton").hide();
    $("#iTimeShow").html("Quiz Time Completed!");

    c = 185;

    quizOver = true;
    return false;
  }

  c = c - 1;
  t = setTimeout(function () {
    timedCount();
  }, 1000);
}

// Display question
function displayCurrentQuestion(currentQuestion) {
  if (c == 185) {
    c = 180;
    timedCount();
  }

  var question = questions[currentQuestion].question;

  var questionClass = $(document).find(".quizContainer > .question");
  $(questionClass).text(currentQuestion + 1 + " . " + question);
  var choiceList = $(document).find(".quizContainer > .choiceList");

  $(choiceList).find("li").remove();

  choice1 = [];
  var option_1 = questions[currentQuestion].option_1;
  var option_2 = questions[currentQuestion].option_2;
  var option_3 = questions[currentQuestion].option_3;
  var option_4 = questions[currentQuestion].option_4;
  choice1.push(option_1);
  choice1.push(option_2);
  choice1.push(option_3);
  choice1.push(option_4);

  for (var i = 0; i < 4; i++) {
    $(
      '<li><input type="radio" class="radio-inline" value=' +
        (i + 1) +
        ' name="dynradio" />' +
        " " +
        choice1[i] +
        "</li>"
    ).appendTo(choiceList);
  }
}

// view result
function viewResults() {
  if (currentQuestion == 10) {
    currentQuestion = 0;
    return false;
  }
  $("#iTimeShow").hide();
  $("#timer").hide();
  $(".question").show();
  $(".preButton").hide();
  // $(document).find(".preButton").text("close");
  hideScore();

  console.log("qlength" + qlength);
  for (var j = 0; j < qlength; j++) {
    var question = questions[currentQuestion].question;
    choice = [];
    var option_1 = questions[currentQuestion].option_1;
    var option_2 = questions[currentQuestion].option_2;
    var option_3 = questions[currentQuestion].option_3;
    var option_4 = questions[currentQuestion].option_4;
    choice.push(option_1);
    choice.push(option_2);
    choice.push(option_3);
    choice.push(option_4);

    $(".question").append(
      "<div>" + question + '</div><ul id="result_ul" style="list-style:none;">'
    );
    for (var i = 0; i < 4; i++) {
      if (iSelectedAnswer[currentQuestion] == i + 1) {
        if (questions[currentQuestion].correct_option == i + 1) {
          $(".question").append(
            '<li style="border:2px solid green;margin-top:10px;">' +
              " " +
              choice[i] +
              "</li>"
          );
        } else {
          $(".question").append(
            '<li style="border:2px solid red;margin-top:10px;">' +
              " " +
              choice[i] +
              "</li>"
          );
        }
      } else {
        if (questions[currentQuestion].correct_option == i + 1) {
          $(".question").append(
            '<li style="border:2px solid green;margin-top:10px;">' +
              " " +
              choice[i] +
              "</li>"
          );
        } else {
          $(".question").append("<li>" + " " + choice[i] + "</li>");
        }
      }
    }

    $(".question").append("</ul><hr>");
    currentQuestion++;
  }
  $(".question").append("<button class='close'>Close</button");
}

//show score after submit score
function displayScore() {
  $(document)
    .find(".quizContainer > .result")
    .text("You scored: " + correctAnswers + " out of: " + questions.length);
  $(document).find(".quizContainer > .result").show();
}

//hide score
function hideScore() {
  $(document).find(".result").hide();
}

//post score data in user array of json

$(document).on("click", ".close", function (e) {
  var email = sessionStorage.getItem("userid");

  var today = new Date();
  var dd = String(today.getDate()).padStart(2, "0");
  var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
  var yyyy = today.getFullYear();
  today = dd + "/" + mm + "/" + yyyy;

  email = "xyz@gmail.com";
 

  $.ajax({
    method: "GET",
    url: "http://localhost:3000/user",
    async: false,
    success: function (result) {
      result.forEach(function (userData) {
        if (email === userData.email) {
          var $categoryData = JSON.parse(userData.category);

          if ($categoryData[category_name] == undefined) {
            $categoryData[category_name] = [];
          }

          $categoryData[category_name][$categoryData[category_name].length] = {
            score: correctAnswers,
            date: today,
          };
          userData["category"] = JSON.stringify($categoryData);
          e.preventDefault();
          $.ajax({
            method: "PUT",
            async: false,
            url: "http://localhost:3000/user/" + userData.id,
            data: userData,
          });
        }
      });
    },
    complete:()=>{
      window.open("http://127.0.0.1:5500/home_page/homepage.html","_self")
    }
  });
  e.preventDefault();
});
