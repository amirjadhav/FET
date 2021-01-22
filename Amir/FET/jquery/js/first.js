$(document).ready(
    ()=>{
        console.log($('div'))
        console.log($('div#div1'))

        console.log($(".para"))

        console.log($(".even.odd"))

        console.log($('div:even'))

        console.log($('div:nth-of-type(1)'))

        console.log($('div >div'))


        console.log("Links without google:\n")
        console.log($('a[href!="www.google.com"]'))


        console.log("input end with NAME:\n")
        console.log($('input[name$="NAME"]'))

        console.log("input start with PAYOR:\n")
        console.log($('input[name^="PAYOR"]'))
    }
);

