import { ViewCompileResult } from '@angular/compiler/src/view_compiler/view_compiler';
import { Component, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

index:number=0;
correctAnswer:number=0;
  selectedAnswer: string[]=[];

  questions  = [
    {
      questionId: 1,
      questionText: 'What is the objective of dependency injection?',
      option1:'Pass the service to the client.',
      option2:'Allow the client to find service.',
      option3:'Allow the client to build service.',
      option4:'Give the client part service.',
     answer: '1',
    },
    {
      questionId: 2,
      questionText: 'Which of the following benefit from dependency injection?',
      option1:'Programming',
      option2:'Testability',
      option3:'Software design',
      option4:'All of the above.',
      answer: '4',
    },
    {
      questionId: 3,
      questionText: 'Which of the following is the first step in setting up dependency injection?',
      option1:'Require in the component.',
      option2:'Provide in the module.',
      option3:'Mark dependency as @Injectable().',
      option4:'Declare an object.',
      answer: '3',
    },
    {
      questionId: 4,
      option1:'@Injectable()',
      option2:'constructor',
      option3:'function',
      option4:'NgModule',
      questionText: 'In which of the following does dependency injection occur?',
      answer: '2',
    }
 ];

 answerSelected(choice:string){
  this.selectedAnswer[parseInt(choice)-1]=choice;
  console.log("selected answer"+this.selectedAnswer[parseInt(choice)-1])
  
// console.log(choice);
 //console.log(this.correctAnswer)

 }

 viewResult(){
   for(var i=0;i<4;i++){
  console.log("correct ans"+this.questions[this.index].answer);
  console.log("selected answer"+this.selectedAnswer[i])

    if(this.questions[this.index].answer===this.selectedAnswer[i]){
        this.correctAnswer++;
    }
   }
   alert(this.correctAnswer);

}
 nextQuestion(){
  if(this.index<this.questions.length-1){
    this.index +=1;
   }
   
 }
 previousQuestion(){
  if(this.index>0){
    this.index -=1;
  }
}

  constructor() { }

  ngOnInit(): void {
   
  }

}
