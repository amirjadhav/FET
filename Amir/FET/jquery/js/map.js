$(document).ready(() => {
  $("button").click(() => {
    console.log("button clicked");
    $("p")
      .append(
        $("input").map(() => {
          console.log($(this).val());
          return $(this).val();
        })
      .get()
      .join(", "));
  });
});


// instead of this use below
//$.map(inputs,()=>{});
