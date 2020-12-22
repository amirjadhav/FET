$(document).ready(function () {
  $.ajax({
    type: "method",
    method:"GET",
    url: "https://jsonplaceholder.typicode.com/photos",
    success: function (response) { 
      for(let i=0; i<response.length;i++){
       // console.log(response[i].title)
       // console.log(response[i].thumbnailUrl)
        var name =response[i].title;
        var url=response[i].thumbnailUrl;
        var card = ` <div class="card1">
        <img
          src="${url}"
          alt=""
          height="100px"
          width="100px"
        />
        <p>${name.substring(0, 25)}</p>
        <button>Add to cart</button>
      </div>`;

        $('#cards').append(card);

      }
    }
  });
});