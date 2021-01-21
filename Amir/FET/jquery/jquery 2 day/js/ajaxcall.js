$(document).ready(function () {
  $("#b2").click(function (e) {
    $.ajax({
      url: "https://reqres.in/api/users",
      method: "POST",
      data: {
        name: "Amir",
        job: "SD",
      },
      success: function (x) {
        alert(x.name + "  user created...");
        console.log(x);
      },
      error: (x) => {
        alert("error!! " + x);
      },
    });
  });

  $("#b1").click(function (e) {
    $.ajax({
      method: "GET",
      url: "https://reqres.in/api/users/2",
      success: function (x) {
        console.log(x);
        $("span#id1").append(x.data.first_name + " " + x.data.last_name);
        $("span#id2").append(x.data.email);
        var img = x.data.avatar;
        console.log(img);
        var drawing = `<img src="${img}">`;
        $("div#img1").append(drawing);
      },
      error: (e) => {
        alert("Error" + e);
      },
    });
  });

  $("#b3").click(function (e) {
    $.ajax({
      type: "DELETE",
      url: "https://reqres.in/api/users/2",
      success: function (x) {
        console.log(x);
        alert(x);
      },
      error: (x) => {
        console.log("inside error");
        alert(x);
      },
    });
  });

  $("#b5").click(function (e) {
    $.ajax({
      url: "https://reqres.in/api/users",
      method: "POST",
      data: {
        name: "Amir",
        job: "SD",
      },
      success: function (x) {
        alert(x.name + "  user created...");
        console.log(x);
      },
      error: (x) => {
        alert("error!! " + x);
      },
    });
  });

  $("#b4").click(function (e) {
    $.ajax({
      type: "PUT",
      url: "https://reqres.in/api/users/2",
      data: {
        name: "morpheus",
        job: "zion resident",
      },
      success: function (x) {
        console.log(x);
        alert(x);
      },
      error: (x) => {
        console.log("inside error");
        alert(x);
      },
    });
  });
});
