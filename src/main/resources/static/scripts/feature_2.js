var forecastScript = (function () {

  /* DECLARING VARIABLES */


  var $imageCitys , day, id, $li, $ul;

  var URL5DAYS;
  /* CACHING VARIABLES */
  function _setup() {
    URL5DAYS = "/rest/forecast";
    $imageCitys = $(".city");
    id = $(".ul").attr("data-id");
    $ul = $('.ul');
    $li = $('<li class="succ_date"> <h2 class="data"> </h2><i class="icon" > </i> <h2 class="temperatura"> </h2> </li>');
  };

  var aggiungiGiorno= function(data, i){
    var $cloneLi = $li.clone();
    $ul.append($cloneLi);
    $cloneLi.addClass("giorno" + i + "");
    var temperature = parseInt(data.mediaMin[i], 10) + "° " + parseInt(data.mediaMax[i], 10)+ "° ";
    $cloneLi.find('.temperatura').text(temperature);
    }

  var inserisciTemp = function(data) {
    var min = data.mediaMin;
    var max = data.mediaMax;
    for(var i = 0; i < min.length; i++){
      aggiungiGiorno(data, i);
    }

  }

  var inserisciIcone = function(data){
    var icona = data.iconeDefinitive;
    for(var i = 0; i < icona.length; i++){
      $('.giorno' + i + '').find(".icon").addClass("icon-"+ icona[i]+ "");
    }
  }

  var inserisciData = function(data){
    var giorno = data.arrayGiorni;
    for(var i = 0; i < giorno.length; i++){
      $('.giorno' + i + '').find(".data").text(giorno[i]);
    }
  }

   /* PRIVATE BUSINESS FUNCTIONS */
   var _getItemData = function() {
     $.ajax({
       url: URL5DAYS,
       type: "GET",
       dataType: 'json',
       data: {
         id: id
       },
       cache: false,
       success: function(data) {
        inserisciTemp(data);
        inserisciIcone(data);
        inserisciData(data);
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
