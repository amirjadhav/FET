function sayHello(lang){
    var text = "Talk " + lang

    var sayAlert = function(fluency){
        if(fluency===1){
            console.log("Biginner " + text)
        }
        else
        {
            console.log("Expert " + text);
        }
    }
    return sayAlert
}

var talkHindi = sayHello('Hindi')
talkHindi(1);
talkHindi(2)
talkHindi(34)

var talkMarathi = sayHello('Marathi')
talkMarathi(2)
