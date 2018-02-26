const retrieveImage = (function() {

	/* DECLARING VARIABLES */
	var $citySearched, $imageCity, $imageWeb,
		$imageMobile, $window;

	const RESTURL = "/rest/images";

	/* CACHING VARIABLES */

	function _setup() {

		$citySearched = $(".city");
		$imageCity = $(".imageCity");
		$window = $(window);
	}
	;

	/* PRIVATE BUSINESS FUNCTIONS */

	const printImage = function(data) {

		$imageMobile = data.photos[0].image.mobile;
		$imageWeb = data.photos[0].image.web;
		restartImage();
	}

	const restartImage = function() {

		if ($window.width() < 1000) {

			$imageCity.attr("src", $imageMobile);
		}
		else {

			$imageCity.attr("src", $imageWeb);
		}
	}

	const _getImageData = function(citySearched) {

		$.ajax({
			url : RESTURL,
			type : "GET",
			dataType : 'json',
			cache : false,
			data : {
				city : citySearched.text().toLowerCase()
			},
			success : function(data) {
				printImage(data);
			}
		});
	}
	/* END PRIVATE BUSINESS FUNCTIONS */

	/* DECLARING EVENT HANDLER */

	function _setObserver() {

		_getImageData($citySearched);

		$window.on("resize", function() {

			restartImage();
		});
	}
	;

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
		start : _init
	};

})();
