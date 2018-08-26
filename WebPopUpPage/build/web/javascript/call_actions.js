/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var par; 
var globalControl="hoy_record_0";
var globalDetail="hoy_client_detail_0";
function rowSelected(control,detail){    
            globalControl=control;
            globalDetail=detail;
            var clase = document.getElementById(control).className;
            var parent = document.getElementById(control).parentNode;            
            var children = Array.from(parent.getElementsByTagName("tr"));
            var divDetail = document.getElementById(detail);
            var divParent = document.getElementsByClassName("class_detail");  
            var divChildren = Array.from(divParent);
            for (j=0;j<divChildren.length;j++){
                divChildren[j].style.display = 'none';
            }
            for(i=0;i<children.length;i++){
                if (i%2===0){
                    children[i].className="odd";
                }else{
                    children[i].className="even";                    
                }
            }
            if(clase==="odd"){
                document.getElementById(control).className="odd selected";
            }else{
                document.getElementById(control).className="even selected";                
            }
            divDetail.style.display = 'inline';
            $("#save_button").prop("disabled", true);
            document.getElementById('myField').value=control;
        }

$(document).ready(function(){
    
        
    $('.scrollHere')[0].scrollIntoView( true );   
    /*var hoyBtn = document.getElementById("hoyBtn");
    var schBtn = document.getElementById("schBtn");*/
    $("#hoyBtn").click(function(){
         $("#todayList").css({display:"inline"});
         $("#schedList").css({display:"none"});
         /*$("#hoy_client_detail_0").css({display:"inline"});
         $("#sch_client_detail_0").css({display:"none"});*/
        $(".class_detail").css({display:"none"});
        $("#"+globalDetail).css({display:"inline"});
    });
    $("#schBtn").click(function(){
         $("#todayList").css({display:"none"});
         $("#schedList").css({display:"inline"});
         /*$("#hoy_client_detail_0").css({display:"none"});
         $("#sch_client_detail_0").css({display:"inline"});*/
        $(".class_detail").css({display:"none"});
        $("#"+globalDetail).css({display:"inline"});
        
     });
    
    /*$("tr").contextmenu(function(e){
        e.preventDefault();
        var posx = e.clientX +window.pageXOffset +'px'; //Left Position of Mouse Pointer
        var posy = e.clientY + window.pageYOffset + 'px'; //Top Position of Mouse Pointer
        $("#contextMenu").css({position:"absolute",display:"inline",left:posx,top:posy});
        par = this; 
    });         
        $(".ContextItem").click(function(){
            $("#contextMenu").css({display:"none"});
            var dataTable = Array.from(document.getElementsByClassName("dataTableBody"));
            var anexo = dataTable[0].id;
            var children = Array.from(par.getElementsByTagName("td"));
            var telefono="";
            var i;
            for(i=0;i<children.length;i++){
                if (children[i].id==="contact_info"){
                    telefono=children[i].innerHTML;
                }
            }
            //alert(event.target.id);
            $.ajax({
                    url: "http://192.168.1.2:8088/asterisk/mxml",
                    type:"GET",
                    //headers:{"Access-Control-Allow-Origin":"*"},
                    xhrFields: {
                                withCredentials: true
                    },
                    crossDomain: true,
                    data: {action:"login",username:"outcall",secret:"call1248"},
                    dataType: "json",
                    success: function(){
                            $.ajax({
                                    url: "http://192.168.1.2:8088/asterisk/mxml",
                                    type:"GET",
                                    xhrFields: {
                                                withCredentials: true
                                               },
                                    crossDomain: true,
                                    data: {
                                            action:"originate",
                                            channel: "SIP/"+anexo,
                                            priority: "1",
                                            exten: "8"+telefono,
                                            context: "from-wurth"
                                          },
                                    dataType: "json"
                            });  
                    },
                     error: function () {
                            $.ajax({
                                    url: "http://192.168.1.2:8088/asterisk/mxml",
                                    type:"GET",
                                    xhrFields: {
                                                withCredentials: true
                                    },
                                    crossDomain: true,
                                    data: {
                                            action:"originate",
                                            channel: "SIP/"+anexo,
                                            priority: "1",
                                            exten: "8"+telefono,
                                            context: "to-pstn"
                                          },
                                    dataType: "json"
                            });
                    }
            });
        });*/
        
        $("#call_button").click(function(){
            var dataTable = Array.from(document.getElementsByClassName("dataTableBody"));      
            var anexo = dataTable[0].id;            
            var fonoParent = document.getElementsByClassName("fono");  
            var nClientParent = document.getElementsByClassName("numclient"); 
            var nomClientParent = document.getElementsByClassName("nomclient"); 
            var recordidParent = document.getElementsByClassName("recordid");  
            var agentdnParent = document.getElementsByClassName("agentdn");  
            var importidParent = document.getElementsByClassName("importid");  
            var telefono="";
            var ncliente="";
            var recordid="";
            var nomcliente="";
            var agentdn="";
            var importid="";
            for (j=0;j<fonoParent.length;j++){
                var parent = fonoParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    telefono = fonoParent[j].value;                    
                }
            }
            for (j=0;j<nClientParent.length;j++){
                var parent = nClientParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    ncliente = nClientParent[j].value;                    
                }
            }
            for (j=0;j<recordidParent.length;j++){
                var parent = recordidParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    recordid = recordidParent[j].value;                    
                }
            }
            for (j=0;j<nomClientParent.length;j++){
                var parent = nomClientParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    nomcliente = nomClientParent[j].value;                    
                }
            }
            for (j=0;j<agentdnParent.length;j++){
                var parent = agentdnParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    agentdn = agentdnParent[j].value;                    
                }
            }
            for (j=0;j<importidParent.length;j++){
                var parent = importidParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    importid = importidParent[j].value;                    
                }
            }
            $("#tipFono").val(telefono);            
            $("#tipNClient").val(ncliente);          
            $("#tipNomClient").val(nomcliente);         
            $("#tipRecordId").val(recordid);      
            $("#tipAgentDn").val(agentdn);      
            $("#tipImportId").val(importid);
            $.ajax({
                    url: "http://192.168.1.2:8088/asterisk/mxml",
                    type:"GET",
                    //headers:{"Access-Control-Allow-Origin":"*"},
                    xhrFields: {
                                withCredentials: true
                    },
                    crossDomain: true,
                    data: {action:"login",username:"outcall",secret:"call1248"},
                    dataType: "json",
                    success: function(){
                            $.ajax({
                                    url: "http://192.168.1.2:8088/asterisk/mxml",
                                    type:"GET",
                                    xhrFields: {
                                                withCredentials: true
                                               },
                                    crossDomain: true,
                                    data: {
                                            action:"originate",
                                            channel: "SIP/"+anexo,
                                            priority: "1",
                                            exten: "8"+telefono,
                                            context: "from-wurth"
                                          },
                                    dataType: "json"
                            });  
                    },
                     error: function () {
                            $.ajax({
                                    url: "http://192.168.1.2:8088/asterisk/mxml",
                                    type:"GET",
                                    xhrFields: {
                                                withCredentials: true
                                    },
                                    crossDomain: true,
                                    data: {
                                            action:"originate",
                                            channel: "SIP/"+anexo,
                                            priority: "1",
                                            exten: "8"+telefono,
                                            context: "to-pstn"
                                          },
                                    dataType: "json"
                            });
                    }
            });                  
            var oddSelected = Array.from(document.getElementsByClassName("odd selected"));            
            var evenSelected = Array.from(document.getElementsByClassName("even selected"));
            
            for (j=0;j<oddSelected.length;j++){
                var children = Array.from(oddSelected[j].childNodes);
                for (k=0;k<children.length;k++){
                    if (children[k].className === 'col-md-2'){
                        children[k].innerHTML="🔵";                    
                    }                    
                }
            }
            
            for (j=0;j<evenSelected.length;j++){
                var children = Array.from(evenSelected[j].childNodes);
                for (k=0;k<children.length;k++){
                    if (children[k].className === 'col-md-2'){
                        children[k].innerHTML="🔵";                    
                    }                    
                }
            }
            $(".fullscreen-container").fadeTo(200, 1);
        });
        
        $("#edit_button").click(function(){       
            var divParent = document.getElementsByClassName("class_detail");  
            for (j=0;j<divParent.length;j++){
                var parent = divParent[j];
                if (parent.style.display === 'inline'){
                    var inputChildren = Array.from(parent.getElementsByTagName("input"));
                    //var textAreaChildren = Array.from(parent.getElementsByTagName("textarea"));
                    //textAreaChildren[0].readOnly = false;
                    for(k=0;k<inputChildren.length;k++){
                        inputChildren[k].readOnly = false;
                    }
                }
            }
            $("#save_button").prop("disabled", false);
            
        });
        
        $("#observacionInfo").on("change",function() {
            var largo =this.value.length;
            var minlength = 10;
            if(largo >= minlength) {
                $("#obsv_button").prop("disabled", false);
            } else {
                $("#obsv_button").prop("disabled", true);            
            }
        });
        $('input[type=radio][name=sched]').change(function() {
            if (this.value === 'no') {
                $("#schedDateTime").css({display:"none"});
            }
            else if (this.value === 'si') {
            $("#schedDateTime").css({display:"inline"});
            }
        });
        
        $("#hist_button").click(function(){
            var nClientParent = document.getElementsByClassName("numclient");            
            var ncliente="";            
            for (j=0;j<nClientParent.length;j++){
                var parent = nClientParent[j].parentNode;
                if (parent.style.display === 'inline'){
                    ncliente = nClientParent[j].value;                    
                }
            }
            window.open("/WebPopUpPage/CallHistoryServlet?histCliente="+ncliente,'mywindow','width=400,height=200,toolbar=no,location=no');
        });
        
        $("#close_button").click(function(){
            window.close();
        });
        
        
});