$(document).ready(function () {
  $("#searchtext").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#table1 tr").filter(function () {
        console.log($(this).text().toLowerCase().toString())
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});
