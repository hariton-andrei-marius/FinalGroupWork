var retrievImage = (function () {

  /* DECLARING VARIABLES */
  var $citySearched, $imageCity, $imageWeb, $imageMobile, $window;

  var RESTURL = "/rest/images";
  /* CACHING VARIABLES */
  function _setup() {
    $citySearched = $(".city").find($("h1"));
    $imageCity = $(".imageCity");
    $window = $( window );
  };

   /* PRIVATE BUSINESS FUNCTIONS */

   var stampImage = function(data){
     $imageMobile = data.photos[0].image.mobile;
     $imageWeb = data.photos[0].image.web;
     restartImage();
   }

   var restartImage = function (){
     if($window.width() < 1000){
     $imageCity.attr("src",$imageMobile);
      } else {
     $imageCity.attr("src",$imageWeb);
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
    _getImageData($imageCity);
    $window.on("resize",function() {
      restartImage();
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
