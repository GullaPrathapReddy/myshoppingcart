$(function() {
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		console.log(menu);
		break;
	case 'Service':
		$('#service').addClass('active');
		break;
	case 'List Products':
		$('#listproducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

})