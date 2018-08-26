/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function checkPasswordMatch() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("password2").value;

    if (password !== confirmPassword){
        $("#divCheckPasswordMatch").html("✕ El Password no coincide");
        $("#divCheckPasswordMatch").css({color:"red",fontSize:"small"});
        $("#saveUser").prop('disabled', true);
    }
    else{
        $("#divCheckPasswordMatch").html("✓ El Password coincide");
        $("#divCheckPasswordMatch").css({color:"green",fontSize:"small"});
        $("#saveUser").prop('disabled', false);
    }
}

$(document).ready(function () {
    $.fn.scrollView = function () {
  return this.each(function () {
    $('html, body').animate({
      scrollTop: $(this).offset().top
    }, 1000);
  });
}
$("#form-title").scrollView();
   $("#saveUser").prop('disabled', true);    
   //$("#password2").keyup(checkPasswordMatch);
   $("#firstname, #middlename, #lastname, #lastname2").on("keyup change",function (){
   var normalize = (function() {
     var from = "ÃÀÁÄÂÈÉËÊÌÍÏÎÒÓÖÔÙÚÜÛãàáäâèéëêìíïîòóöôùúüûÑñÇç",
      to   = "AAAAAEEEEIIIIOOOOUUUUaaaaaeeeeiiiioooouuuuNnCc",
      mapping = {};
 
  for(var i = 0, j = from.length; i < j; i++ )
      mapping[ from.charAt( i ) ] = to.charAt( i );
 
  return function( str ) {
      var ret = [];
      for( var i = 0, j = str.length; i < j; i++ ) {
          var c = str.charAt( i );
          if( mapping.hasOwnProperty( str.charAt( i ) ) )
              ret.push( mapping[ c ] );
          else
              ret.push( c );
      }
      return ret.join( '' ).replace( /[^-A-Za-z]+/g, '_' );
  }
 
})();
      var al = $(this).val();
      var clean = normalize(al);            
      $(this).val(clean);
   });
   $("#anexo").on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
    });    
    $("#firstname, #rut, #lastname, #anexo, #password, #password2").on("keyup change",function(){
        if($(this).val().length>0){
            $("#saveUser").prop('disabled', false);            
        }else{
            $("#saveUser").prop('disabled', true);            
        }
    });    
    $("#password, #password2").on("keyup change",function(){
        if($(this).val().length>8 || $(this).val().length<5){
            $("#saveUser").prop('disabled', true);
            $("#divCheckPasswordMatch").html("!!! El Password debe tener entre 5 y 8 caracteres");
            $("#divCheckPasswordMatch").css({color:"yellow",fontSize:"small"});            
        }else{
            checkPasswordMatch();         
        }
    });
    $("#backLink").click(function(event) {
    event.preventDefault();
    history.back(1);
});
});






