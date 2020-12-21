$(document).ready(

    () =>{
        var findP = $('section').find('p')
        console.log(findP)

        var childP = $('section').children();

        console.log("Child Method",childP)
    }
);