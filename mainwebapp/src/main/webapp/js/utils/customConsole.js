define([ "utils/commonUtils" ], function(commonUtils) {
	var customConsole = {
		imp : function() {
			if (arguments.length > 0) {
				console.log('%c' + arguments[0],
						"background: red; color: white;");
			}
		},
		highlight : function() {
			if (arguments.length > 0) {
				console.log('%c' + arguments[0],
						"background: yellow; color: black;");
			}
		},
		printObj : function(text, object) {
			if (commonUtils.isNotNullObject(object)) {
				console.log(text + ":" + JSON.stringify(object));
			}
		},
		printObjProperties : function(object) {
			this.highlight("printObjProperties");
			if (commonUtils.isNotNullObject(object)) {
				for ( var property in object) {
					console.log("Name:" + property);
					console.log("Value:" + object[property]);
				}
			}
		},
		printObjPropertiesObjectKeys : function(object) {
			var properties = commonUtils.getObjectProperties(object);
			this.highlight("printObjPropertiesObjectKeys");
			if (properties != null) {
				for (var i = 0; i < properties.length; i++) {
					console.log("Name:" + properties[i]);
					console.log("Value:" + object[properties[i]]);
				}
			}
		}
	};
	return customConsole;
});
