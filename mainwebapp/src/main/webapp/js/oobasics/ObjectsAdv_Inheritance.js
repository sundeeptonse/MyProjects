/**
 * Inheritance --> Javascript's Build In Approach for Inheritance is called
 * Prototype Chaining or Prototypal Inheritance
 */

define([ "utils/customConsole", "utils/commonUtils" ], function(customConsole,
		commonUtils) {

	commonUtils.printCurrentFileName(arguments.length);

	/*-
	 * All Objects automatically inherit from Object, unless specified otherwise
	 * 
	 * Methods Inherited from Object.Prototype
	 * --> hasOwnProperty
	 * --> propertyIsEnumerable
	 * --> isPrototypeOf
	 * --> valueOf
	 * --> toString
	 * 		--> This is called as a fallback in case valueOf returns a reference value instead of a primitive value
	 * 		--> It is called on a primitive whenever JS is expecting a String
	 */

	var book = {
		title : "The Principles of OOJ",
	}

	var prototype = Object.getPrototypeOf(book);
	console.log(prototype === Object.prototype);

	/*-
	 * --> valueOf 
	 * 		--> Returns the Object Instance by default, The Primitive Wrapper Types override value of , so it returns a String 
	 * 		--> Example Date returns the epoch time in seconds, when the > or < is used .valueOf is called, comes in handy when comparing objects
	 */
	var now = new Date();
	var earlier = new Date(2010, 1, 1);
	// Date in String
	console.log("Now:" + now);

	console.log("now > earlier:" + now > earlier);

	function Person(age) {
		this.age = age;
	}

	Person.prototype = {
		constructor : Person,
		toString : function() {
			return "Hello ::: My Person's age is " + this.age;
		},
		valueOf : function() {
			return this.age;
		}
	}

	var person1 = new Person(10);
	var person2 = new Person(20);

	console.log(person1);
	console.log(person1.toString());
	console.log(person1 < person2);

	/*-
	 * --> toString 
	 * 		--> This is called as a fallback in case valueOf returns a reference value instead of a primitive value 
	 * 		--> It is called on a primitive whenever JS is expecting a String
	 */

	var message = "Book=" + book;
	console.log(message);
	book.toString = function() {
		return "[Book:" + this.title + "]";
	};

	message = "Book=" + book;
	console.log(message);

	/*-
	 * Note : Don't add/modify Object.prototype Properties/Functions, unintended consequences
	 */

	/*-
	 * Object Inheritance
	 * 
	 * Object Literals have Object.prototype set as their [[Prototype]] implicitly, but you can override using Object.create() method
	 * 
	 */

	var book = {
		title : "The Priciples of OOJ"
	}
	// is the same as

	var book = Object.create(Object.prototype, {
		title : {
			configurable : true,
			enumerable : true,
			value : "The Priciples of OOJ",
			writable : true
		}
	})

	var person1 = {
		name : "Sundeep",
		sayName : function() {
			console.log(this.name);
		}
	}

	var person2 = Object.create(person1, {
		name : {
			configurable : true,
			enumerable : true,
			value : "Lib",
			writable : true
		}
	});

	person1.sayName();
	person2.sayName();

	console.log(person1.isPrototypeOf(person2));
	console.log(Object.prototype.isPrototypeOf(person1));
	console.log(Object.prototype.isPrototypeOf(person2));

	/*
	 * You can also create and object with null [Prototype]
	 */

	var nakedObject = Object.create(null);
	console.log("toString in NakedObject:" + ("toString" in nakedObject));
	console.log("valueOf in NakedObject:" + ("valueOf" in nakedObject));

	/*
	 * Constructor Inheritance Each Prototype has a constructor value
	 */
	function YourConstructor() {

	}

	// Javascript does this behind the scenes
	YourConstructor.prototype = Object.create(Object.prototype, {
		constructor : {
			configurable : true,
			enumerable : true,
			value : YourConstructor,
			writable : true
		}
	});

	/*
	 * Because Prototype Property is writable, you can chain the prototype chain
	 * by modifying it
	 */

	function Rectangle(length, width) {
		this.length = length;
		this.width = width;
		this.name = "Blah"
	}

	Rectangle.prototype.getArea = function() {
		return this.length * this.width;
	}
	Rectangle.prototype.toString = function() {
		return "[Rectangle" + this.length + "x:" + this.width + "]";
	}

	function Square(size) {
		this.length = size;
		this.width = size;
	}

	// Square.prototype = new Rectangle();
	// Square.prototype.constructor = Square;
	// or
	// Square.prototype = Rectangle.prototype;
	// Square.prototype.constructor = Square;
	// or

	Square.prototype = Object.create(Rectangle.prototype, {
		constructor : {
			configurable : true,
			enumerable : true,
			value : Square,
			writable : true
		}
	})

	Square.prototype.toString = function() {
		return "[Square" + this.length + "x:" + this.width + "]";
	}

	var rect = new Rectangle(5, 10);
	var square = new Square(6);

	console.log("SquareArea:" + square.getArea());
	console.log("RectangleArea:" + rect.getArea());
	
	console.log("square.hasOwnProperty('blah')" + square.hasOwnProperty("blah"));

	/*
	 * Constructor Stealing. Since Inheritance is accomplished via Prototype
	 * Chains, you don't need to call an object's supertype Constructor. If you
	 * do want to call the supertype constructor from the subtype constructor,
	 * then you need to take adv of how JS Functions work
	 * 
	 * This is known as pseudoclassical inheritance 
	 * 
	 * To Inherit Own properties, use Constructor Stealing.
	 * By Setting the Constructor Prototype to Another Vale, you create inheritance
	 */

	function Rectangle(length, width) {
		this.length = length;
		this.width = width;
	}

	Rectangle.prototype.getArea = function() {
		return this.length * this.width;
	}
	Rectangle.prototype.toString = function() {
		return "[Rectangle] " + this.length + " x [" + this.width + "]";
	}

	function Square(size) {
		Rectangle.call(this, size, size);
		// Add new properties
	}

	Square.prototype = Object.create(Rectangle.prototype, {
		constructor : {
			configurable : true,
			enumerable : true,
			value : Square,
			writable : true
		}
	});

	Square.prototype.toString = function() {
		var text = Rectangle.prototype.toString.call(this);
		return text.replace("Rectangle", "Square");
	}

	var square = new Square(6);
	console.log("Length:" + square.length + ":Width:" + square.width
			+ ":Area: " + square.getArea());
	console.log(square.toString());
	//Since you are adding the value to this in the rectangle
	console.log(square.hasOwnProperty("length"));
	Object.keys(square);

});
