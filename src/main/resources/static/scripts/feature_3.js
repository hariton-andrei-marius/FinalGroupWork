var getInput= (function () {

  /* DECLARING VARIABLES */
  var $input, $listaCitta, $nomiCitta;
  var RESTURL = "/rest/city_details";
  var RESTINDEX ="/index";



  /* CACHING VARIABLES */
  function _setup() {
    $input = $(".input");
    $listaCitta = $(".listaCitta");
    $nomiCitta = $(".nomiCitta");
    };

   /* PRIVATE BUSINESS FUNCTIONS */

   var _controlloCaratteri = function(){
     if($input.val().length > 2){
       _ajaxCall($input.val());
     }
     else{
       $listaCitta.empty();
     }
   }

   var _aggiungiCitta = function(element){
     $listaCitta.append("<li class='nomiCitta' data-url='" + element._links["city:item"].href + "'> " + element.matching_full_name + "</li>");
   }

  var _filteringData = function(data){
    $listaCitta.empty();
      data._embedded["city:search-results"].forEach(function(element) {
        _aggiungiCitta(element);
      });
  }

  var _ajaxCall = function(data) {
    $.ajax({
      url:RESTURL,
      type:"GET",
      dataType:'json',
      cache:false,
      data: {city: data},
      success: function(data){
        _filteringData(data)
      }
    });
  }

  var _ajaxCall_id = function(url) {
    $.ajax({
      url:url,
      type:"GET",
      dataType:'json',
      cache:false,
      success: function(data){
        var geoname = data.geoname_id;
        $.ajax({
          url:RESTINDEX,
          type:"GET",
          dataType:'json',
          cache:false,
          data: {id: geoname},
          success: function(data){

          }
        });
      }
    });
  }

  var _bloccoInvio = function(e){
      e.preventDefault();
  }

  /* END PRIVATE BUSINESS FUNCTIONS */


   /* DECLARING EVENT HANDLER */
  function _setObserver() {

    $input.keyup(function(){
      _controlloCaratteri();
    });

    $listaCitta.on("click",  "li", function(e){
        _ajaxCall_id($(this).data("url"));
         $input.submit(function(){
           debugger;
          console.log("prova");
         });
        _bloccoInvio(e);
    });


  };

  function _init() {
    try {
      _setup();
      _setObserver();
    }
    catch(e) {
        console.log('%c ' + e.message, 'color:red');
        console.log('%c ' + e.stack, 'background: #222; color: #bada55');
    }
  }

  return {
    start: _init
  };

})();
