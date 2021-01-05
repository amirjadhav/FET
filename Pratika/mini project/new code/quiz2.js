

  var resultsContainer;
  var submitButton;
  var previousButton;
var nextButton;
var slides;
$(document).ready(function(){

  function buildQuiz()
  {
                // variable to store the HTML output
                const output = [];

                // for each question...
                myQuestions.forEach(
                (currentQuestion, questionNumber) => {
                  console.log("current question"+currentQuestion);
                  console.log("question no"+questionNumber);
                    // variable to store the list of possible answers
                    const answers = [];

               

                    // and for each available answer...
                    for(letter in currentQuestion.answers){

                    // ...add an HTML radio button
                    answers.push(
                        `<label>
                        <input type="radio" name="question${questionNumber}" value="${letter}">
                        ${letter} :
                        ${currentQuestion.answers[letter]}
                        </label>`
                    );
                    console.log("answers"+answers)
                    }

                    // add this question and its answers to the output
                    output.push(
            `<div class="slide">
            <div class="question"> ${currentQuestion.question} </div>
            <div class="answers"> ${answers.join("")} </div>
            </div>`
            );
                }
                );

                // finally combine our output list into one string of HTML and put it on the page
                quizContainer.innerHTML = output.join('');
  }

  function showResults()
  {

            // gather answer containers from our quiz
            const answerContainers = quizContainer.querySelectorAll('.answers');

            // keep track of user's answers
            let numCorrect = 0;

            // for each question...
            myQuestions.forEach( (currentQuestion, questionNumber) => {

            // find selected answer
            const answerContainer = answerContainers[questionNumber];
            const selector = `input[name=question${questionNumber}]:checked`;
            const userAnswer = (answerContainer.querySelector(selector) || {}).value;

            // if answer is correct
            if(userAnswer === currentQuestion.correctAnswer){
                // add to the number of correct answers
                numCorrect++;

                // color the answers green
                answerContainers[questionNumber].style.color = 'lightgreen';
            }
            // if answer is wrong or blank
            else{
                // color the answers red
                answerContainers[questionNumber].style.color = 'red';
            }
            });

            // show number of correct answers out of total
            resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length}`;
  }

var myQuestions2= [
    {
      question: "Who invented JavaScript?",
      answers: {
        a: "Douglas Crockford",
        b: "Sheryl Sandberg",
        c: "Brendan Eich"
      },
      correctAnswer: "c"
    },
    {
      question: "Which one of these is a JavaScript package manager?",
      answers: {
        a: "Node.js",
        b: "TypeScript",
        c: "npm"
      },
      correctAnswer: "c"
    },
    {
      question: "Which tool can you use to ensure code quality?",
      answers: {
        a: "Angular",
        b: "jQuery",
        c: "RequireJS",
        d: "ESLint"
      },
      correctAnswer: "d"
    }
  ];
  console.log("Questons1"+myQuestions);

  var myQuestions = [];
  $.ajax({
    method: "GET",
    url: "db.json",
    success: function (x) {
     
      
      x.forEach((items) => {
        console.log("items"+items);
        myQuestions.push(items);
      });
      console.log("question"+myQuestions);
  
      
    },
    complete: function (data) {
      buildQuiz(); 
      setdata();
  showSlide(0);
     },
    error: (e) => {
      alert("Error" + e);
    },
  });
 

    
  

  function showSlide(n) {
    console.log("slide")
    slides[currentSlide].classList.remove('active-slide');
    slides[n].classList.add('active-slide');
    currentSlide = n;
    if(currentSlide === 0){
    previousButton.style.display = 'none';
    }
    else{
    previousButton.style.display = 'inline-block';
    }
    if(currentSlide === slides.length-1){
    nextButton.style.display = 'none';
    submitButton.style.display = 'inline-block';
    }
    else{
    nextButton.style.display = 'inline-block';
    submitButton.style.display = 'none';
    }
    }
    

    function showNextSlide() {
        showSlide(currentSlide + 1);
        }

        function showPreviousSlide() {
            showSlide(currentSlide - 1);
            }





            const quizContainer = document.getElementById('quiz');


  // Kick things off
  //buildQuiz();

function setdata(){

   resultsContainer = document.getElementById('results');
  submitButton = document.getElementById('submit');
   previousButton = document.getElementById("previous");
 nextButton = document.getElementById("next");
 slides = document.querySelectorAll(".slide");
currentSlide = 0;


 // showSlide(currentSlide);

 

  // Event listeners
  submitButton.addEventListener('click', showResults);
  previousButton.addEventListener("click", showPreviousSlide);
nextButton.addEventListener("click", showNextSlide);
}
      

});