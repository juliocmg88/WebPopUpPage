/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery(document).ready(function() {
			   $("html").niceScroll({styler:"fb",cursorcolor:"#424a5d", cursorwidth: '8', cursorborderradius: '10px', background: '#fff', spacebarenabled:false,  cursorborder: '', zindex: '1000'});

			    $.backstretch("css/images/bg-welcome.jpg");
			    
			    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
			    	$(this).removeClass('input-error');
			    });
			    
			    $('.login-form').on('submit', function(e) {
			    	
			    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
			    		if( $(this).val() == "" ) {
			    			e.preventDefault();
			    			$(this).addClass('input-error');
			    		}
			    		else {
			    			$(this).removeClass('input-error');
			    		}
			    	});
			    });
			    
			    $('input:text:first').focus();
			});