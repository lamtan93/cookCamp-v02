
$(function () {
var theHREF;
//    var valCheck = new Array();
    valCheck = [];
    envoi = [];

//        console.log("chargement jQuery ");
//        var isCheck= new Array();
//    var compterRows = $(".maLigne").length;
//    alert(compterRows);

//    $('#check:checkbox:checked').each(function() {
////        var val = $("#check").val();
////       valCheck.push(this.value);
////        alert(valCheck);
//        alert(this.value);
//     });
    var contains = function (val) {
        for (var i = 0; i < valCheck.length; i++) {
            if (valCheck[i] === val) {
                return true;
            }
        }
        return false;
    };
    $(".check").click(function () {
        valCheck = [];
        valCheck.push($(this).val());
        
      

    });
    $(".diviser").click(function(){
        alert("fonction diviser ");
        
    });


    $("#yoann").click(function () {
        
        $.ajax({
            type: 'POST',
            async: false,
            url: "Controleur?section=repartir",
            dataType: 'text',
            data:
                    {
                        listeProduits: (valCheck).toString(),
                    },
            success: function (response) {
                var contenu = $(".division").html();

                $(".divison").html(contenu).append(response);




            },
        });
        
        envoi = [];


    });



//            console.log("dans la fonction compterCheck()");
//           isCheck.push($("#check").val()) ; 



    function LireCheck() {

        console.log("dans la fonction LireCheck()");
        alert(" liste des produits " + isCheck);

    }
    ;
$("#dialog-confirm").dialog({
    
    resizable: false,
        height:160,
        width:500,
        autoOpen: false,
        modal: true,
        buttons: {
            "Oui": function() {
                $( this ).dialog( "close" );
                window.location.href =theHREF;
            },
            "Annuler": function() {
                $( this ).dialog( "close" );
            }
         }
    
});
 $("#confirm").click(function(e) {
        e.preventDefault();
        theHREF = $(this).attr("href");
        $("#dialog-confirm").dialog("open");
    });


//    $(".maLigne").click(function () {
//        var b=$("#idligne").val();
//        alert("bonjour ! valeur "+b);
//      //  $("#repartition").append("<tr>").append($(this).html()).append("</tr>");
//      
//      $.ajax({
//            type: 'POST',
//            async: false,
//            dataType: 'text',
//            url: "Controleur?section",
//        data:{
//            
//        },
//            success: function (response) {
//                $("#repartiton").append("<tr>").append().append("</tr>");
//            }
//      });
});





