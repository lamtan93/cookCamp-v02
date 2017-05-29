
$(document).ready(function () {
    $("#titre").click(function () {
        $("#divBDD").slideToggle("slow");
    });
    $("#divBDD").hide();

    $("#lesTables").hide();
    $("#affichagePanierServeur").hide();
    $("#affichagePanierServeur").hide();
//    $("#interfaceProduit").hide();
    $(".inputNote").hide();

    $("#problemePanier").delay(6000).fadeOut("slow");

    $("#lesTablesClient").hide();
    $("#affichagePanierClient").hide();
    $("#elementsMenu").hide();
    $("#messageEnvoyePanier").hide();
    $("#messageEnvoyePanierServeur").hide();


    $("#boutonAjax").click(function () {

        var loginAjax = $("#loginAjax").val();
        $.ajax({
            type: 'POST',
//            async: false,
            url: "ControleurMain?section=authentification",
            dataType: 'text',
            data:
                    {
                        loginAjax: loginAjax,
                    },
            success: function (response) {
                var serveur = "/WEB-INF/jsp/serveur.jsp";
                var responsable = "/WEB-INF/jsp/responsable.jsp";
                $("#displayAjax").html(response);
                $("#bodyServeur").hide();
                $("#coverCache").hide();
                $("#footer").hide();

            },
        });
    });

    $("#choisirTable").click(function () {
        $("#interfaceProduit").hide();
        $("#affichagePanier").hide("slow");//

        $("#lesTables").slideToggle("slow");
    });

    $("#choisirTableClient").click(function () {



        $("#lesTablesClient").slideToggle("slow");
    });

    $("#choisirProduit").click(function () {

        $("#lesTables").hide();
        $("#affichagePanier").hide("slow");//
        $("#interfaceProduit").slideToggle("slow");

    });

    $("#clickerPanier").click(function () {
//        $("#lesTables").hide("slow");//
//        $("#interfaceProduit").hide("slow");// important ! à ne pas faire !
        $("#affichagePanierServeur").slideToggle("slow");
        $("#affichagePanierClient").slideToggle("slow");
    });

    $("#clickerPanierClient").click(function () {

        $("#affichagePanierClient").slideToggle("slow");
        $("#affichagePanierServeur").slideToggle("slow");
    });

    $("#iconNote").click(function () {
        $(".inputNote").slideToggle();
    })

    $("#clickHidePanierClient").click(function () {
        $("#affichagePanierClient").hide();
        $("#messageEnvoyePanier").show("slow").delay(800).fadeOut(4000);
    })

    $("#clickHidePanierServeur").click(function () {
         $("#messageEnvoyePanierServeur").show("slow").delay(800).fadeOut(4000);
    })
    
    var urlNavig = window.location.href;
    var urlNavig02 = window.location.search;
//    alert(urlNavig02);
//    alert(url);
    var urlAppli01 = "http://localhost:8080/cookCamp-v02-war/ControleurMain?section=serveur";
    var urlAppli02 = "http://localhost:8080/cookCamp-v02-war/ControleurMain?section=authentification";
    var urlAppli03 = "http://localhost:8080/cookCamp-v02-war/ControleurMain";
    var urlAppli04 = "http://localhost:8080/cookCamp-v02-war/ControleurMain?section=interfaceClient";
    var urlAppli05 = "http://localhost:8080/cookCamp-v02-war/ControleurMain?section=interfaceClient";
//   var  valCheck = [];
//    $("classRadio").click(function(){
////        var  valCheck = [];
//        valCheck.push($(".classRadio").val());
//        
//    })
//    
//   $("#boutonGetRadio").click(function(){
//       
//        alert(valCheck);
//   })




});




