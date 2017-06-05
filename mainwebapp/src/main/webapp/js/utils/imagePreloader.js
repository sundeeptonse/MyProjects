var preloadFiles = function(frame,type, location, files, defer) {
	var frameDocument = document.getElementById(frame).contentDocument;
	var frameWindow = document.getElementById(frame).contentWindow;
	var arrayLength = files.length;
	if (location !== null && arrayLength > 0) {
		for (var i = 0; i < arrayLength; i++) {
			var newLocation = location + files[i];
			if(type === "js"){
				basicAjaxCall(newLocation);
				/*
				var script = frameDocument.createElement("script");
				script.type = "text/javascript";
				script.src = newLocation;
				script.defer = defer;
				frameDocument.getElementsByTagName("body")[0].appendChild(script);
				*/
				
			}else if (type === "css"){
				var link = frameDocument.createElement('link');
				link.setAttribute('rel', 'stylesheet');
				link.setAttribute('type', 'text/css');
				link.setAttribute('href', newLocation);;
				frameDocument.getElementsByTagName("head")[0].appendChild(link);
			}
		}
	}
};


var preloadImages = function(location, imageArr) {
	var arrayLength = imageArr.length;
	if (location !== null && arrayLength > 0) {
		if (document.images) {
			for (var i = 0; i < arrayLength; i++) {
				var image = new Image();
				image.src = location + imageArr[i];
			}
		}
	}
};