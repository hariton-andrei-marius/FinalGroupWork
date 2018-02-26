const getInput = (function() {

	/* DECLARING VARIABLES */
	
	var $input, $listaCitta, $nomiCitta, $form, $insert, $idForm;
	var RESTURL = "/rest/city_details";

	/* CACHING VARIABLES */
	
	function _setup() {
		
		$input = $(".input");
		$listaCitta = $(".listaCitta");
		$nomiCitta = $(".nomiCitta");
		$form = $(".blockIn");
		$insert = $('.insert');
		$idForm = $('#idForm');
	};

	/* PRIVATE BUSINESS FUNCTIONS */

	const _controlloCaratteri = function() {
		
		if ($input.val().length > 2) {
			
			_ajaxCall($input.val());
		}
		else {
			
			$listaCitta.empty();
		}
	}

	const _aggiungiCitta = function(element) {
		
		$listaCitta.append("<li class='nomiCitta' data-url='"
				+ element._links["city:item"].href + "'> "
				+ element.matching_full_name + "</li>");
	}

	const _filteringData = function(data) {
		
		$listaCitta.empty();
		data._embedded["city:search-results"].forEach(function(element) {
			_aggiungiCitta(element);
		});
	}

	const _ajaxCall = function(data) {
		
		$.ajax({
			url : RESTURL,
			type : "GET",
			dataType : 'json',
			cache : false,
			data : {
				city : data
			},
			success : function(data) {
				_filteringData(data)
			}
		});
	}

	const _ajaxCall_id = function(url) {
		
		$.ajax({
			url : url,
			type : "GET",
			dataType : 'json',
			cache : false,
			success : function(data) {
				var geoname = data.geoname_id;
				_funcSubmit(geoname);
			}
		});
	}

	const _funcSubmit = function(geoname) {

		$insert.val(geoname);
		$idForm.submit();
	}

	/* DECLARING EVENT HANDLER */
	
	function _setObserver() {

		// INPUT EVENTS
		
		$input.on("keypress", function() {
			
			_controlloCaratteri();
		});

		$idForm.on('keypress', function(e) {
			
			return e.which !== 13;
		});

		// RESULTS EVENTS
		
		$listaCitta.on("click", "li", function(e) {
			
			_ajaxCall_id($(this).data("url"));
		});
	};

	function _init() {
		try {
			_setup();
			_setObserver();
		} catch (e) {
			console.log('%c ' + e.message, 'color:red');
			console.log('%c ' + e.stack, 'background: #222; color: #bada55');
		}
	}

	return {
		start : _init,
		checkCharacters: _controlloCaratteri
	};

})();
