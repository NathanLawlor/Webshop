function removeProductFromBasket(e) {		
	var itemContainer = $(".item-container")[0];
	var item = e.target.parentNode.parentNode.parentNode;
	
	itemContainer.removeChild(item);
	
	var basketSize = $(".header").attr('data-basketsize');
	var productid = $(item.childNodes[1]).attr('data-productid');
	productid = parseInt(productid);
	var productName = $(item.childNodes[1].childNodes[1]).text();
			
	$.ajax({
	  	url: "/removeProductFromBasket",
	  	method: "POST",
	  	data: {'productID':productid},
	}).done( function() {
		basketSize -= 1;
		$("#basket").text("Basket (" + basketSize + ")");
		$(".basketSizeInfo").text("You have " + basketSize + " items in your basket");
		$(".header").attr('data-basketsize', basketSize)
			
		console.log(productName + " removed from basket");
	});
}