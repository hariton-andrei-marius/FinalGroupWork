const speechInput = (function() {

	/* DECLARING VARIABLES */
	
	var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
	var recognition, $speechIcon, $text;
	var CLICK;

	/* CACHING VARIABLES */
	
	function _setup() {
		
		CLICK = false;
		recognition = new SpeechRecognition();
		recognition.lang = 'it';
		recognition.interimResults = false;
		recognition.maxAlternatives = 1;
		$speechIcon = $('FORM .mic');
		$text = $('FORM #inputCity');
	}

	/* PRIVATE BUSINESS FUNCTIONS */

	const speechStart = function() {
		
		recognition.start();
		$speechIcon.css('color', 'red');
		
		document.getElementById("inputCity").placeholder = "Listening ...";
	};

	const speechResult = function(e) {
		
		let last = e.results.length - 1;
		let word = e.results[last][0].transcript;
		
		$text.val(word);
		
		// Extern call to feature_3.js
		getInput.checkCharacters();
	};

	const speechEnd = function() {
		
		recognition.stop();
		$speechIcon.css('color', 'grey');
		document.getElementById("inputCity").placeholder = "Insert your city";
	};

	const speechError = function(e) {
		
		$speechIcon.css('color', 'grey');
		document.getElementById("inputCity").placeholder = "Insert your city";
	};

	/* DECLARING EVENT HANDLER */
	
	function _setObserver() {
		
		$speechIcon.on('touchstart click', function() {
			speechStart();
		});

		recognition.onresult = function(event) {
			speechResult(event);
		};

		$speechIcon.on('touchend', function() {
			speechEnd();
		});

		recognition.onspeechend = function() {
			speechEnd();
		};

		recognition.onerror = function(event) {
			speechError(event);
		};
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
		start : _init
	};

})();
