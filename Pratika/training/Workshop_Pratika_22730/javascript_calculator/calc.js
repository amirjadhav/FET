	/* backspace function */ 
    function backspace(calc) {											 
        size = calc.display.value.length; 
        calc.display.value = calc.display.value.substring(0, size-1); 
    } 
    
     
    function calculate(calc) { 
        
        
        
          /* calculate square*/ 
        if(calc.display.value.includes("^")) { 
            
            size = calc.display.value.length; 
            n = Number(calc.display.value.substring(0, size-1)); 
            calc.display.value = Math.pow(n,2); 
        } 



            /* calculate square root*/ 
        else if(calc.display.value.includes("√")){
            size = calc.display.value.length; 
           
            n = Number(calc.display.value.substring(1, size)); 
           
            calc.display.value = Math.sqrt(n); 
        }
        

            /* calculate cube*/ 
        if(calc.display.value.includes(":")) { 
            
            size = calc.display.value.length; 
            n = Number(calc.display.value.substring(0, size-2)); 
            calc.display.value = Math.pow(n,3); 
        } 


        else	 
            /*for + ,-, mul, div */ 
            calc.display.value = eval(calc.display.value); 
    } 



         
          /*toggle for scientific*/ 
           function displaymore() {
                    
            var x = document.getElementById("more");
            if (x.style.display === "none") {
                x.style.display= "inline";
            } else {
                x.style.display = "none";
            }
            }