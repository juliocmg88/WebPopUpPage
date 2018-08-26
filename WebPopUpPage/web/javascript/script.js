/**
 * 
 * @param url
 */
function windowOpen(url, fullScreen, options) {
	
	if (typeof options === 'undefined') {
		options = ['toolbar=no', 
		           'location=no', 
		           'directories=no', 
		           'status=no', 
		           'menubar=no', 
		           'scrollbars=no', 
		           'resizable=yes',
		           'top=0',
		           'left=0'];
	}
	
	if(fullScreen){
		options.push('fullscreen=yes');
		options.push('height='+screen.height);
		options.push('width='+screen.width);
	}
	
	var targetWin = window.open(url, this.target, options);
	if (window.focus) {targetWin.focus();}
	
	return true;
}

function windowOpenReport(htmlReport, params) {
	
	var options = ['toolbar=no', 
		           'location=no', 
		           'directories=no', 
		           'status=no', 
		           'menubar=no', 
		           'scrollbars=yes', 
		           'resizable=yes',
		           'top=0',
		           'left=0',
		           'height=500',
		           'width=800'
		           ];
	
	var htmlHeader='<html><head><title>Report Panel</title><link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">';
	var htmlContent='<div class="panel panel-default"><div class="panel-body">'+htmlReport+'</div></div></body></html>';

	var targetWin = window.open('', this.target, options);
	var doc = targetWin.document;
    doc.open();
    doc.write(htmlHeader + htmlContent);
    doc.close();
	if (window.focus) {targetWin.focus();}
	
	return true;
}

/**
* Repdroduccion de archivos de audio
 * @param id - identificador del elemento para reproduccion
 */
function play(id) {
	var filename = $('#audiofile'+id).val();
	var idContainer="audioContainer"+id;
	
	// limpia reproduccion anterior
	$("div[name='audioDiv']" ).html("");
	
	// verifica si el navegador es IE u otro
	if(navigator.userAgent.indexOf(".NET")>0 ){
		playAudioEmbed(idContainer,filename);
	}else{
		playAudioControl(idContainer,filename);
	}
}

/**
 * Para navegadores distintos distintos de IE
 * @param idContainer - identificador del elemento para control
 * @param pAudio - archivo para reproduccion
 */
function playAudioControl(idContainer,pAudio) {
	$('#'+idContainer).html('<audio controls id="myaudio" mastersound></audio>');
	
	if (window.HTMLAudioElement) {
		try {
			var oAudio = document.getElementById('myaudio');
			oAudio.src = pAudio;
			currentFile = pAudio;
			oAudio.play();
			if (oAudio.paused) {
				oAudio.play();
			} 

		} catch (e) {
			BootstrapDialog.alert({
				message: 'playAudio Exception. '+e,
				type: BootstrapDialog.TYPE_WARNING,
				closable: true, draggable: true
			});// BootstrapDialog
		}
	}
}

/**
 * para navegadores IE
 * @param idContainer - identificador del elemento para control
 * @param pAudio - archivo para reproduccion
 */
function playAudioEmbed(idContainer,pAudio){
	try {
		$('#'+idContainer).html("<embed src='"+pAudio+"' loop='false' controls='console' AUTOSTART='true' width='300' height='15'>");
	} catch (e) {
		BootstrapDialog.alert({
			message: 'playAudioEmbed Exception: Your browser does not support the audio element. '+e,
			type: BootstrapDialog.TYPE_WARNING,
			closable: true, draggable: true
		});// BootstrapDialog
	}
}

/**
 * 
 * @param pAudio
 */
function playOnModal(pAudio){
	 var $message =$('<audio src="'+pAudio+'" controls autoplay style="width: 100%"></audio>');
	 
	// verifica si el navegador es IE
	if(navigator.userAgent.indexOf(".NET")>0 ){
		$message =$('<embed src="'+pAudio+'" loop="false" controls="console" autoplay="true" autostart="true" type="audio/wav" width="100%" height="50">');
	}
	 var dialog = new BootstrapDialog({
         message: function(dialogRef){
             var $button = $('<button class="btn btn-primary btn-lg btn-block">Close</button>');
             $button.on('click', {dialogRef: dialogRef}, function(event){
                 event.data.dialogRef.close();
             });
             
             var $htm=$('<div></div>');
             $htm.append($message);
             $htm.append($button);
             return $htm;
         },
         closable: false
     });
	 
     dialog.realize();
     dialog.getModalHeader().hide();
     dialog.getModalFooter().hide();
     dialog.getModalBody().css('background-color', '#0088cc');
     dialog.getModalBody().css('color', '#fff');
     dialog.open(); 
}

/**
 * display alert messages
 * @param errorMessage
 * @param displayInDialog
 * 			true - display message into BootstrapDialog
 * 			false - display message into element id=alertMessageDiv
 */
function displayAlertMessage(alertMessage, displayInDialog){
	var htmlMessage='';
	if(typeof alertMessage=='object'){
		if(alertMessage.Result=='OK'){
			htmlMessage='<div class="alert alert-success alert-dismissible fade in">'
				+'<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>'
				+alertMessage.Message+'</div>';
		}else{
			htmlMessage='<div class="alert alert-danger alert-dismissible fade in">'
				+'<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>'
				+alertMessage.Message+'</div>';
		}
	}else{
		htmlMessage='<div class="alert alert-danger alert-dismissible fade in">'
			+'<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>'
			+alertMessage+'</div>';
	}
	 
	if(displayInDialog){
		BootstrapDialog.alert({
			message: htmlMessage,
			type: BootstrapDialog.TYPE_WARNING,
			closable: true, 
			draggable: true
		});// BootstrapDialog
	}else{
		$('#alertMessageDiv').html(htmlMessage);
	}
}

/**
 * Module for displaying "Waiting for..." dialog using Bootstrap
 *
 * @author Eugene Maslovich <ehpc@em42.ru>
 */
var waitingDialog = waitingDialog || (function ($) {
    'use strict';

	// Creating modal dialog's DOM
	var $dialog = $(
		'<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="999" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;z-index: 9999;">' +
		'<div class="modal-dialog modal-m">' +
		'<div class="modal-content">' +
			'<div class="modal-body">' +
				'<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>' +
			'</div>' +
		'</div></div></div>');

	return {
		/**
		 * Opens our dialog
		 * @param message Custom message
		 * @param options Custom options:
		 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
		 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
		 */
		show: function (message, options) {
			// Assigning defaults
			if (typeof options === 'undefined') {
				options = {dialogSize: 'sm'};
			}
			if (typeof message === 'undefined') {
				message = 'Por favor espere...';
			}
			var settings = $.extend({
				dialogSize: 'm',
				progressType: '',
				onHide: null // This callback runs after the dialog was hidden
			}, options);

			// Configuring dialog
			$dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
			$dialog.find('.progress-bar').attr('class', 'progress-bar');
			if (settings.progressType) {
				$dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
			}
			$dialog.find('label').val(message);
			// Adding callbacks
			if (typeof settings.onHide === 'function') {
				$dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
					settings.onHide.call($dialog);
				});
			}
			// Opening dialog
			$dialog.modal();
		},
		/**
		 * Closes dialog
		 */
		hide: function () {
			$dialog.modal('hide');
		}
	};// return

})(jQuery);

/**
 * envia POST con formulario y archivos multipart/form-data
 * @param htmlContent
 * @returns
 */
function sendPostFormData(form){
	// var form=htmlContent.find('form');
	if(form==undefined) return;
	if(form.valid()==false) return;
	$.ajax({
		type : "POST",
		beforeSend: function() { waitingDialog.show();},
	    complete: function() { waitingDialog.hide();},
		processData: false,
	    contentType: false,
		enctype: 'multipart/form-data',
		url : $(form).attr('action'),
		dataType: 'json',
		data : new FormData($(form)[0]),
		success: function(data) {
			displayAlertMessage(data);
		},
		error: function(xhr,textStatus,errorThrown) {
			displayAlertMessage(xhr.responseText);
		}
	});// .ajax	
}// sendPostFormData

/**
 * envia POST con formulario 
 * @param htmlContent
 * @returns
 */
function sendPostFormSerialize(form){
	// var form=htmlContent.find('form');
	if(form==undefined) return;
	if(form.valid()==false) return;
	$.ajax({
		type : "POST",
		beforeSend: function() { waitingDialog.show();},
	    complete: function() { waitingDialog.hide();},
		url : $(form).attr('action'),
		dataType: 'json',
		data : $(form).serialize(),
		success: function(result) {
			displayAlertMessage(result);
		},
		error: function(xhr) {
			displayAlertMessage(xhr.responseText);
		}
	});// .ajax
}// sendPostFormSerialize

