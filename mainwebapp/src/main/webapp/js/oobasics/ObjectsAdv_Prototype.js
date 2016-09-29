/**
 * 
 */

define([ "utils/customConsole", "utils/commonUtils" ], function(customConsole,
		commonUtils) {

	commonUtils.printCurrentFileName(arguments.length);

	/*-
	 * A Prototype is a recipe for an object.
	 * Almost every function(with the exceptions of some build-in functions) has a prototype property.
	 * The Prototype is shared amongst all the Object Instances
	 * and the those instances can access properties of the prototype
	 * 
	 * For example, the hasOwnProperty() method is defined on the generic Object prototype
	 * 
	 * */

	var book = {
		title : "The Principles of OO Javascript"
	};

	// True
	console.log("title" in book);
	// True
	console.log(book.hasOwnProperty("title"));
	// True , since in checks (ownProperty and prototypes property)
	console.log("hasOwnProperty" in book);
	// False
	console.log(book.hasOwnProperty("hasOwnProperty"));
	// True
	console.log(Object.prototype.hasOwnProperty("hasOwnProperty"));

	/* Identifying a Prototype Property */
	console.log("HasProtototypeProperty:"
			+ commonUtils.hasPrototypeProperty(book, "toString"));

	/*
	 * Prototype Property An instance keeps track of its prototype through an
	 * internal property called [Prototype] When you create a new instance, the
	 * constructor's prototype is assigned to the [[Prototype]] property
	 * 
	 * Some JS Engines support a property called _proto_ on all objects.
	 * 
	 * You can delete Own Property, but can't delete Prototype Property You can
	 * override Prototype Property with Own Property
	 * 
	 * When a property is read on an Object the JS Engine first looks for an own
	 * property and then [Prototype] Object.
	 * 
	 * There is no direct link between an instance and a constructor.
	 * 
	 * instance --> Prototype --> constructor
	 * 
	 * Object.freeze has no impact on the prototype methods
	 */

	var object = {};

	var prototype = Object.getPrototypeOf(object);
	// True
	console.log(prototype === Object.prototype);

	var prototype = object.constructor.prototype;
	console.log("Prototype:" + prototype);

	console.log("Object.prototype.isPrototypeOf(object):"
			+ Object.prototype.isPrototypeOf(object));

	/*
	 * Using Prototypes with Constructors
	 */

	function Person(name) {
		this.name = name;
	}
	Person.prototype.sayName = function() {
		console.log(this.name);
	}
	var person1 = new Person("Sundeep");
	var person2 = new Person("Roop");

	console.log(person1.name);
	console.log(person2.name);
	person1.sayName();
	person2.sayName();

	Person.prototype = {
		/*-
		 * This needs to be added since we are overriding the Prototype
		 * property Directly
		 */
		constructor : Person,
		sayName : function() {
			console.log(this.name);
		},
		toString : function() {
			return "[Person" + this.name + "]";
		}
	}
});
