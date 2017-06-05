define(
		[ "utils/customConsole", "utils/commonUtils" ],
		function(customConsole, commonUtils) {

			function EventTarget() {

			}

			EventTarget.prototype = {
				constructor : EventTarget,
				addListener : function(type, listener) {
					if (!this.hasOwnProperty("_listeners")) {
						this._listeners = [];
					}
					if (commonUtils.isUndefined(this.listeners[type])) {
						this._listeners[type] = [];
					}
					this._listeners[type].push(listener);
				},
				fire : function(event) {
					if (!event.target) {
						event.target = this;
					}

					if (!event.type) {
						throw new Error("Event object missing 'type' property.");
					}

					if (this._listeners
							&& this._listeners[event.type] instanceof Array) {
						var listeners = this._listeners[event.type];
						for (var i = 0; len = listeners.length, i < len; i++) {
							listeners[i].call(this, event);
						}
					}
				}

			}

		});