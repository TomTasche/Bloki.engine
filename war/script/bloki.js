/**
 * More information at http://bloki.tomtasche.at/
 * 
 * @author Thomas Taschauer - tomtasche.at
 */

/**
 * @author Thomas Jirout - tomweb.at
 */
(function(){
	var box = document.createElement('div');
	box.setAttribute('style', 'position:fixed; right:10px; bottom: 0; box-shadow: 0 0 10px #666; padding:10px; background-color:#333; color:#FFF; font-family: Arial;');
	box.innerHTML = "Bloki - Fix typos";
	box.onmousedown = sendText;
	document.getElementsByTagName('body')[0].appendChild(box);
})();

/**
 * @author codetoad.com - http://www.codetoad.com/javascript_get_selected_text.asp
 * @returns {String}
 */
function getSelectedText() {
	var text = '';

	if (window.getSelection) {
		text = window.getSelection();
	} else if (document.getSelection) {
		text = document.getSelection();
	} else if (document.selection) {
		text = document.selection.createRange().text;
	}

	return text;
}

/**
 * @author Thomas Taschauer - tomtasche.at
 * @param mistake
 */
function sendSelectedText(mistake, correction) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {

		if (request.readyState == 4) {
			if (request.status == 200) {
				// alert("Thanks for the heads up!");
			} else {
				alert("I couldn't reach the server. Are you really connected to the internet? If so, feel free to contact me about this error. :)");
			}
		}
	};

	request.open("POST", "http://002.bloki-engine.appspot.com/submit", true);
	request.send({"mistake": mistake, "correction": correction, "url": document.location});
}

/**
 * @author Thomas Taschauer - tomtasche.at
 * @author sharkysoft.com - http://sharkysoft.com/tutorials/jsa/content/008.html
 */
function sendText() {
	var mistake = getSelectedText();

	if (mistake == "") {
		window.open("http://bloki.tomtasche.at/", "_blank");

		return;
	}

	var correction = prompt("Do you have any suggestions how to improve '" + mistake + "'?");

	sendSelectedText(mistake, correction);
}