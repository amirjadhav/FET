$(document).ready(() => {
  console.log("Previous");
  console.log($("#myDiv").prev());

  console.log("siblings");
  console.log($("#myDiv").siblings());

  console.log("nexts")
  console.log($("#myDiv").next());

  console.log("children")
  console.log($("#myDiv").children());

  console.log("Parent")
  console.log($("#myDiv").parent());
});
