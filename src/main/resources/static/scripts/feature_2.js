var forecastScript = (function () {

  /* DECLARING VARIABLES */


  var $imageCitys , day;

  var URL5DAYS;
  /* CACHING VARIABLES */
  function _setup() {
    URL5DAYS = "/rest/forecast";
    $imageCitys = $(".city").find("h1");
  };

  var _getData = function(data){
    var dataCorrente = "null";
    for(var i = 1, cont = 1 ; i <= 5 ; i++ , cont+=7){
      while(dataCorrente != data.list[cont].dt_txt.substring(0,11)){
        dataCorrente = data.list[cont].dt_txt.substring(0,11);
      }
      $(".giorno"+i+"").text(dataCorrente);
      }
    }

    var checkDate = function () {

    }



   /* PRIVATE BUSINESS FUNCTIONS */
   var _getItemData = function() {
     $.ajax({
       url: URL5DAYS,
       type: "GET",
       dataType: 'json',
       data: {
         name: $imageCitys.text()
       },
       cache: false,
       success: function(data) {
         _getData(data)
       }
     });
   }
  /* END PRIVATE BUSINESS FUNCTIONS */

   /* DECLARING EVENT HANDLER */
  function _setObserver() {
    _getItemData();
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
    start: _init,
  };

})();
