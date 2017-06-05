/**
 * 
 */

define([ "utils/customConsole", "utils/commonUtils" ], function(customConsole,
		commonUtils) {

	commonUtils.printCurrentFileName(arguments.length);

	/*-
	 * A constructor is nothing but a function
	 * Nothing different syntactically 
	 * Only starts with Capital Case
	 * */

	function Person() {

	}

	/*-
	 * Using New Keyword to return object of the tpe and returns it 
	 * [Even though the function doesn't explicitly return anything]
	 * If there are no Parameters it can be called with ();
	 * instanceof operator can be used to deduce the type
	 * 
	 * It can also be checked using the constructor property.
	 * Every Object instance is automatically created with a constructor property that contains a reference to the constructor function that created it.
	 * 
	 * For Generic Objects (those created via object literal or the Object Constructor), the constructor is set to Object
	 * Note: Constructor Property can be overridden, hence it is better to use instanceOf
	 * */
	var person1 = new Person();
	var person2 = new Person;
	var person3 = {
		name : "Sundeep"
	};

	console.log("Person1 instanceof:" + (person1 instanceof Person));
	console.log("Person2 instanceof:" + (person2 instanceof Person));

	// Prints the Function
	console.log("Person1 constructor:" + (person1.constructor));
	console.log("Person2 constructor:" + (person2.constructor));
	console.log("Person3 constructor:" + (person3.constructor));

	console.log("Person1 constructor:" + (person1.constructor === Person));
	console.log("Person2 constructor:" + (person2.constructor === Person));

	function Person(name) {
		this.name = name;
		this.sayName = function() {
			console.log(this.name);
		}
	}

	var person1 = new Person("Sundeep");
	var person1 = new Person("Roop");

	console.log("Person1 Name:" + person1.name);
	console.log("Person2 Name:" + person2.name);

	person1.sayName();
	person2.sayName();

	// Function can be overridden --> Object Property
	person1.sayName = function() {
		console.log(this.name + "ss");
	}
	person1.sayName();
	console.log("Print Name");

	/*
	 * You can also explicitly call return inside a constructor. If the returned
	 * value is an object, it will be returned instead of the newly created
	 * object instance. If the returned value is a primitive, the newly created
	 * object is used and the returned value is ignored
	 */

	function Person2() {
		this.sayName = function() {
			console.log("Person2 SayName");
		}
		return 1;
	}

	function Person3() {
		this.sayName = function() {
			console.log("Person3 SayName");
		}
		return new Person2();
	}

	var person2 = new Person2;
	var person3 = new Person3;

	console.log("Is Person2 instance of person2:"
			+ (person2 instanceof Person2));
	person2.sayName();
	// Since the Object was returned
	console.log("Is Person3 instance of person2:"
			+ (person3 instanceof Person2));
	person3.sayName();

	/*
	 * You can set all the Properties using Define Property
	 */

	function Person(name, age) {

		/*
		 * Readable accessor Property
		 */
		Object.defineProperty(this, "name", {
			get : function() {
				console.log("Reading Name:");
				return name;
			},
			enumerable : true,
			configurable : true
		});

		/*
		 * Readable Data property
		 */
		Object.defineProperty(this, "age", {
			enumerable : true,
			value : age
		});

		this.sayName = function() {
			console.log(this.name);
		}

	}

	var person1 = new Person("Sundeep", 25);
	console.log(person1);
	person1.age = 26;
	console.log(person1);

	/*
	 * If you call w/o new, then the global object is modified instead of the
	 * person object, since this is assigned In Strict Mode, it fails since this
	 * isn't assigned to global object
	 */

	var person1 = Person("Roop");
	console.log(name);

	/*-
	 * Constructors Allows you to configure Instances with the same properties,
	 * but the code redundancy is there. Example: 100 copies of a function are
	 * created, which is not efficient.
	 */
});
