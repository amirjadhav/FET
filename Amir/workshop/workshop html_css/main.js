function addbook()
{
   // document.getElementById("contentheading").innerHTML = "Add a Book";
    document.getElementById("content").innerHTML = '<h3>Add Book</h3> Book Name: <input type="text"><br><br> Auther: <input type="text"><br><br> date of issue: <input type="date"><br><br> student id: <input type="number"><br><br> <button type="submit"> Save</button>';
}
function searchbook()
{
    document.getElementById("content").innerHTML = '<h3>Search book</h3><input type="search" name="" id=""> &nbsp &nbsp <button>Search</button>';
}
function requestbook()
{
    document.getElementById("content").innerHTML = ' <h3>Request new Book</h3>Book Name: <input type="text"><br><br>Auther: <input type="text"><br><br>student id: <input type="number"><br><br><button type="submit">Request</button>';
}
function fineCalculate()
{
    document.getElementById("content").innerHTML = '<div><h3>Add a Book</h3>Book Name: <input type="text"><br><br>Auther: <input type="text"><br><br>price: <input type="number"><br><br>date of issue: <input type="date"><br><br>student id: <input type="number"><br><br><button type="submit">Calculate</button></div>';
}