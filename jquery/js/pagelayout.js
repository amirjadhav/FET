$(document).ready(()=>{
    $('header').html("<p>Changed page layout after button click</p>")

  

    $('button').click(()=>{
        console.log("Button Clicked")
        $('header').toggleClass('headerstyle')
        $('header').css('color','cyan')

        $('div #p1').height(300)
        $('div #p1').width(800)
        $('div #p1').css('background-color','lightblue')
        $('div #p1').css('text-align','center')
     
       $("#p2").toggleClass('divsecond')
    })
});

