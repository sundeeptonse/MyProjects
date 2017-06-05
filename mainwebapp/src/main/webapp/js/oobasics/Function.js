/**
 * Function Differ from other objects, it has a [call] property
 * 
 * 2 Ways to Define a function 1) New Operator 2) Literal --> Declaration -->
 * Expression
 */

define([ "utils/customConsole" ], function(customConsole) {

	/**
	 * New Operator
	 */
	var printlog = new Function("console.log('Hi');console.log('Bye')");
	printlog();

	/**
	 * Literal - Declaration Allows for Function Hoisting --> Function being
	 * Hoisted to the top the global context You can call add before the
	 * function gets called
	 */
	add(5, 2);
	function add(x, y) {
		z = x + y;
		console.log(z);
		return z;
	}

	/**
	 * Literal - Expression
	 * 
	 */
	// Can't be called before
	// add2(5,2);
	var add2 = function(x, y) {
		z = x + y;
		console.log(z);
		return z;
	}
	add2(10, 2);

	/**
	 * Self - Invoking Functions Closures = (function(){})()
	 * 
	 */
	(function() {
		var x = "Hello!!";
		// I will invoke myself
		console.log("Bye Bye")

	})();

	/*-
	 * Javascript Nested Functions 
	 * All Functions have access to the global scope. 
	 * Nested Functions have access to the scope above them.
	 * 
	 * Function Definition is hoisted to the top of the Scope
	 */

	function add3() {
		
		var counter = 0;
		plus();
		function plus() {
			counter += 1;
		}
		return counter;
		
	}
	var add3Value = add3();

	console.log("Add3:" + add3Value);

	/*-
	 * Self - Invoking Functions 
	 *  (function(variable){})(variable)
	 * arguments.callee --> Deprecated in ECMA5
	 */
	(function(message) {
		console.log("Bye Bye::" + arguments[0]);
		console.log("Bye Bye2::" + message);
		console.log(arguments.callee);
	})("Hello");

	/*-
	 * Self - Invoking Functions in Recursion 
	 * (function(variable){})(variable) arguments.callee --> Deprecated in ECMA5
	 * 
	 */
	console.log("Factorial:" + (function(n) {
		return !(n > 1) ? 1 : arguments.callee(n - 1) * n;
	})(7));

	/*-
	 * 
	 * The variable add is assigned the return value of a self-invoking
	 * function. The self-invoking function only runs once. 
	 * It sets the counter
	 * to zero (0), and returns a function expression. 
	 * This way add becomes a
	 * function. The "wonderful" part is that it can access the counter in the
	 * parent scope. This is called a JavaScript closure.
	 * It makes it possible for a function to have "private" variables. The counter is protected by
	 * the scope of the anonymous function, and can only be changed using the
	 * add function.
	 * A closure is a function having access to the parent scope,
	 * even after the parent function has closed.
	 */

	var addC = (function() {
		var counter = 0;
		return function() {
			return counter += 1;
		};
	})();

	console.log(addC());
	console.log(addC());
	console.log(addC());

	/*-
	 * Passing a Function as a variable to another function
	 */

	var numbers = [ 1, 4, 2, 3, 10, 2 ];
	var customSort = function(a, b) {
		return a - b;
	}
	var customSort2 = function() {
		return 0;
	}
	console.log(numbers);
	numbers.sort(function(first, second) {
		return first - second;
	});
	console.log("Inline Sort:" + numbers);
	numbers.sort();
	console.log("Basic Sort:" + numbers);
	numbers.sort(customSort);
	console.log("Custom Sort:" + numbers);
	numbers.sort();
	console.log("Basic Sort:" + numbers);
	numbers.sort(customSort2);
	console.log("Custom Sort2:" + numbers);

	/*-
	 * Passing a Function as a variable to another function
	 * There must be a better way
	 */

	var person = {
		name : "SS",
		year : "YYY",
		printName : function() {
			if (arguments.length != 0 && (typeof arguments[0] === "function")) {
				arguments[0].call(this);
			} else {
				console.log("This:" + this.name + ":" + this.year);
			}

		}
	}

	person.printName();
	// person.printName(function(name,year){console.log("XX:" + name+ ":this:" +
	// year)})
	person.printName(function() {
		console.log("CustomPrint:This:" + this.name + ":" + this.year)
	})
});
