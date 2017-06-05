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
		isUndefined : function(object) {
			return (typeof object == "undefined") ? true : false;
		},
		getObjectProperties : function(object) {
			var properties = null
			if (this.isNotNullObject(object)) {
				properties = Object.keys(object);
			}
			return properties;
		},
		hasPrototypeProperty : function(object, name) {
			return name in object && !object.hasOwnProperty(name);
		},

		/*-
		 * Mixins occur when one Object Acquires the Properties of another
		 * w/o modifying the prototype chain.
		 * The first object(a receiver) receives the properties of the second object
		 * */
		mixin : function(receiver, supplier) {
			// Since for in --> All the enumerable properties from the supplier
			// are copied
			for ( var property in supplier) {
				if (supplier.hasOwnProperty(property)) {
					receiver[property] = supplier[property];
				}
			}
			return receiver;
		}

	};
	return commonUtils;
});
