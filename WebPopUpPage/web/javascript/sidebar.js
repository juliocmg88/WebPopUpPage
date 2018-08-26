

var Script = function () {

//    sidebar dropdown menu auto scrolling
    jQuery('#sidebar .sub-menu > a').click(function () {
        var o = ($(this).offset());
        diff = 250 - o.top;
        if(diff>0)
            $("#sidebar").scrollTo("-="+Math.abs(diff),500);
        else
            $("#sidebar").scrollTo("+="+Math.abs(diff),500);
    });


//    sidebar toggle
    $(function() {
        function responsiveView() {
            var wSize = $(window).width();
            if (wSize <= 768) {
                $('#container').addClass('sidebar-close');
                $('#sidebar > ul').hide();
            }

            if (wSize > 768) {
                $('#container').removeClass('sidebar-close');
                $('#sidebar > ul').show();
            }
        }
        $(window).on('load', responsiveView);
        $(window).on('resize', responsiveView);
    });

	// oculta o muestra sidebar
    $('.fa-bars').click(function () {
        if ($('#sidebar > ul').is(":visible") === true) {
            $('#main-content').css({
                'margin-left': '0px'
            });
            $('#sidebar').css({
                'margin-left': '-210px'
            });
            $('#sidebar > ul').hide();
            $("#container").addClass("sidebar-closed");
        } else {
            $('#main-content').css({
                'margin-left': '210px'
            });
            $('#sidebar > ul').show();
            $('#sidebar').css({
                'margin-left': '0'
            });
            $("#container").removeClass("sidebar-closed");
        }
    });
	
	// $('.tooltips').tooltip();
	
	// manejador eventos onclick del menu
	$('#jquery-accordion-menu .submenu a').on('click', function(e) {
			e.preventDefault();
			clearInterval(hdlInterval1);
			clearInterval(hdlInterval2);
			
			var href = $(this).attr('href');
			if(href != '#'){
				 $.ajax({  
					method:'POST',
					beforeSend: function() { waitingDialog.show();},
				    complete: function() { waitingDialog.hide();},
					url: href,  
					success: function(data) {  
						$('#page-content').empty();
						$('#page-content').html(data);  
					},
					error: function(xhr) {  
						BootstrapDialog.alert({
							title:'Error',
							message: xhr.responseText,
							type: BootstrapDialog.TYPE_DANGER,
							closable: true, draggable: true
						});// BootstrapDialog
					}
				});  
				var wSize = $(window).width();
				if (wSize <= 768) { // en vista responsive oculta menu
					$('#container').addClass('sidebar-close');
					$('#sidebar > ul').hide();
				}
				e.stopPropagation();
			}
	});

}();