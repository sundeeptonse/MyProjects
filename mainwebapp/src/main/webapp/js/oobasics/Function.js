/**
 * Function Differ from other objects, it has a [call] property
 * 
 * 2 Ways to Define a function
 * 1) New Operator
 * 2) Literal
 *     --> Declaration
 *     --> Expression 
 */


define([ "utils/customConsole" ], function(customConsole) {
	
	/**
	 * New Operator
	 */
	var printlog = new Function("console.log('Hi');console.log('Bye')");
	printlog();
	
	/**
	 * Literal - Declaration
	 * Allows for Function Hoisting --> Function being Hoisted to the top the global context
	 * You can call add before the function gets called
	 */
	add(5,2);
	function add(x,y){
		z = x + y;
		console.log(z);
		return z;
	}
	
	

	/**
	 * Literal - Expression
	 * 
	 */
	//Can't be called before
	//add2(5,2);
	
	var add2 = function (x,y){
		z = x + y;
		console.log(z);
		return z;
	}
	add2(10,2);
	
	
	
});
