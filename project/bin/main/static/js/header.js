function logout() {
	$.ajax({
	  	url: "/logout",
	  	method: "POST"
	}).done(function() {
		$("#basket").text("Basket (0)");
		$(".header").attr('data-basketsize', 0);
		console.log("Successful Logout");
	});
}