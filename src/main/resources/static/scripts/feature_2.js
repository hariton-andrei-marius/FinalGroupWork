const forecastScript = (function() {

	/* DECLARING VARIABLES */

	var $imageCitys, day, id, $li, $ul;

	const URL5DAYS = "/rest/forecast";

	/* CACHING VARIABLES */

	function _setup() {

		$imageCitys = $(".city");
		id = $(".ul").attr("data-id");
		$ul = $('.ul');
		$li = $('<li class="succ_date"> <h2 class="data"> </h2><i class="icon" > </i> <h2 class="temperatura"> </h2> </li>');
	}
	;

	const aggiungiGiorno = function(data, i) {

		var $cloneLi = $li.clone();
		
		$ul.append($cloneLi);
		$cloneLi.addClass("giorno" + i + "");
		
		var temperature = parseInt(data.mediaMin[i], 10) + "° "
				+ parseInt(data.mediaMax[i], 10) + "° ";
		
		$cloneLi.find('.temperatura').text(temperature);
	}

	const inserisciTemp = function(data) {
		
		let min = data.mediaMin;
		let max = data.mediaMax;
		
		for (var i = 0; i < min.length; i++) {
			aggiungiGiorno(data, i);
		}

	}

	const inserisciIcone = function(data) {
		
		let icona = data.iconeDefinitive;
		
		for (var i = 0; i < icona.length; i++) {
			
			$('.giorno' + i + '').find(".icon").addClass(
					"icon-" + icona[i] + "");
		}
	}

	const inserisciData = function(data) {
		
		let giorno = data.arrayGiorni;
		
		for (var i = 0; i < giorno.length; i++) {
			
			$('.giorno' + i + '').find(".data").text(giorno[i]);
		}
	}

	/* PRIVATE BUSINESS FUNCTIONS */
	
	const _getItemData = function() {
		
		$.ajax({
			url : URL5DAYS,
			type : "GET",
			dataType : 'json',
			data : {
				id : id
			},
			cache : false,
			success : function(data) {
				inserisciTemp(data);
				inserisciIcone(data);
				inserisciData(data);
			}
		});
	}

	/* DECLARING EVENT HANDLER */
	
	function _setObserver() {
		
		_getItemData();
	};

	function _init() {
		
		try {
			_setup();
			_setObserver();
		}
		catch (e) {
			console.log('%c ' + e.message, 'color:red');
			console.log('%c ' + e.stack, 'background: #222; color: #bada55');
		}
	}

	return {
		start : _init,
	};

})();
