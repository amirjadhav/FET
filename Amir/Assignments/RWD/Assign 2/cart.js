var price = 0
$(document).ready(function () {
  for (let i = 0; i < 20; i++) {
    var card = ` <div class="card1">
                        <img
                            src="eshop.png"
                            alt=""
                            height="100px"
                            width="100px"
                        />
                        <p>Product <br>
                        Price ${i * 2 + 100} <br>
                        This is description
                        </p>
                        <button name="${i * 2 + 100}">Add to cart</button>
                        </div>`;

    $("#cards").append(card);
  }

  $("button").click(function (e) {
      price = this.name
    $("#dialog").dialog();
    $("#price").attr("value", `${this.name}`);
  });
  $('input[name=itemcount]').change(function() {
     // console.log("onchange")
      console.log($('#itemcount').val())
      item_count = $('#itemcount').val()
      let final_price = price * item_count 
    $("#price").attr("value", `${final_price}`);
  });
});
