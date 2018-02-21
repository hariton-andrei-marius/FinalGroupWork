var retrievImage = (function () {

  /* DECLARING VARIABLES */
  var $citySearched, $imageCity;

  var RESTURL = "/rest/images";
  /* CACHING VARIABLES */
  function _setup() {
    $citySearched = $(".city").find($("h1"));
    $imageCity = $(".imageCity");
  };

   /* PRIVATE BUSINESS FUNCTIONS */

   var stampImage = function(data){
     if($( window ).width() < 768){
     $imageCity.attr("src",data.photos[0].image.mobile);
     console.log(data.photos[0].image.mobile);
      } else {
     $imageCity.attr("src",data.photos[0].image.web);
     console.log(data.photos[0].image.web);
    }
   }

   var _getImageData = function(citySearched) {

     $.ajax({
       url: RESTURL,
       type: "GET",
       dataType: 'json',
       cache: false,
       data : {
         city: citySearched.text()
       },
       success: function(data) {
          stampImage(data);
       }
     });
   }
  /* END PRIVATE BUSINESS FUNCTIONS */

   /* DECLARING EVENT HANDLER */
  function _setObserver() {
    $( document ).ready(function() {
      _getImageData($imageCity);
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
