var Module = (function(){
    var x = 89;
    function privateMethod(){
        //do something
        console.log('inside private method')
    }

    return{
        publicMethod: function(){
            //can call privateMethod()

            privateMethod();
            console.log(x);
            return "From public method"
        }
    };
})();

// console.log(Module.privateMethod()) // Gives error 
console.log(Module.publicMethod())