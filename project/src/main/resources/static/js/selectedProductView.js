function addProductToBasket() {
			var basketSize = $(".body").attr('data-basketsize');
			basketSize++;
			var productid = $(".item").attr('data-productID');
			console.log("Basket Size: " + basketSize);
			console.log("Item added to basket, ID " + productid);
		$.ajax({
			  url: "/addProductToBasket",
			  method: "POST",
			  data: {'productID':productid},
			}).done(function(data) {
				$('#basket').text("Basket ("+ (basketSize) + ")");
				$(".body").attr('data-basketsize', basketSize)
			});
		}
