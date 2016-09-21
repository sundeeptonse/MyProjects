define(function() {
	var commonUtils = {
		printCurrentFileName : function(count) {
			var scripts = document.getElementsByTagName('script');
			console.log(scripts[scripts.length - (count + 1)].src);
			for (var i = 0; i < scripts.length; i++) {
				// console.log(scripts[i].src);
			}
		},
		isNotNullObject : function(object) {
			return ((object != null && (object instanceof Object)));
		},
		getObjectProperties : function(object) {
			var properties = null
			if (this.isNotNullObject(object)) {
				properties = Object.keys(object);
			}
			return properties;
		}

	};
	return commonUtils;
});
