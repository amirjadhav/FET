function setupSomeGlobals(){
    var num = 666
    gAlertNumber = function(){alert(num) }
    gIncreaseNumber = function() {num++}
    gSetNumber = function(x) { num = x }
}

setupSomeGlobals()

gAlertNumber()

gIncreaseNumber()

gAlertNumber()

gSetNumber(600)
gAlertNumber()


// * after calling setupSomeGlobals() then only inner methods are available