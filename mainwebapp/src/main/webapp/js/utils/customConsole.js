define(function () {
    	var customConsole = {
    			imp : function(){
    				if(arguments.length > 0 ){
    					console.log('%c'+arguments[0], "background: red; color: white;");
    				}
    			},
    			printobj : function(text, object){
    				if(object != null &&  (object instanceof Object)){
    					console.log(text + ":" + JSON.stringify(object));
    				}
    			}
    	};
    	return customConsole;
});
