/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        var par;
        function ShowMenu(parent,control, e) {
            var posx = e.clientX +window.pageXOffset +'px'; //Left Position of Mouse Pointer
            var posy = e.clientY + window.pageYOffset + 'px'; //Top Position of Mouse Pointer
            document.getElementById(control).style.position = 'absolute';
            document.getElementById(control).style.display = 'inline';
            document.getElementById(control).style.left = posx;
            document.getElementById(control).style.top = posy;   
            par = document.getElementById(parent);
        }
        function HideMenu(control) { 
            document.getElementById(control).style.display = 'none'; 
        }
        function alertaName(control){
            HideMenu(control);
            var children = Array.from(par.getElementsByTagName("td"));
            var telefono="";
            var i;
            for(i=0;i<children.length;i++){
                if (children[i].id==="contact_info"){
                    telefono=children[i].innerHTML;
                }
            }
            alert("El telefono es "+telefono);
        }