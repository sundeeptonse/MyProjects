/*-
 * Object Creation 
 *  - New
 * 
 * Object Dereferencing 
 * 	- Mark it as null
 * 
 * Some Build In Reference Types
 * Array Date, Error, Function, Object, RegExp 
 * 
 */

define([ "utils/customConsole" ], function(customConsole) {

	customConsole.imp("*******");

	/*
	 * Simple Object creation To Deference it, make it null, available for GC
	 * Helps in Large Applications
	 */

	var object1 = new Object();
	var object2 = object1;

	object1.text = "Hello";

	customConsole.printObj("Object1", object1);
	customConsole.printObj("Object2", object2);
	

	/*
	 * Ways of Instantiating an Object Using New Operator Using Literal Notation
	 */

	//New
	var book = new Object();
	book.name = "The Principles of";
	book.year = "2014";

	customConsole.printObj("Book", book);

	//Literal
	var book2 = {
		name : "HPJ",
		year : "2015"
	}
	
	customConsole.printObj("Book2", book2);
	
	
	
	/*
	 * Property Access
	 * Properties are name/value pairs.
	 * Dot Notation an Bracket Notations can be used.
	 * */
	
	
	var array = [];
	array.push(12345);
	array["push"](111);
	console.log("Array"+array);
	console.log(Array.isArray(array));
	
	
	
	/*Primitive Wrappers*/
	
});
