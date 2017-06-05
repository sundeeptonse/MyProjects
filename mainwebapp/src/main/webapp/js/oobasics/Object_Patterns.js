/**
 * 
 */

define
{

	/*-
	 * Module Pattern - Is an Object Creation Pattern to create Singleton Objects with Private Data
	 * Basic Approach is to use an IIFE - Immediately Invoked Function Expression.
	 * Because the returned Object is defined within that function, the object method's have access to the the data
	 * These methods are called Priveleged Methods
	 * 
	 * The Module Pattern allows you to use regular variables as de facto object Propeties that aren't exposed publicly.
	 * You can accomplish this by creating closure functions as object methods.
	 * Closures are simply functions that access data outside their own scope. 
	 * Example any function trying to access the window object.
	 * 
	 * The difference with module function is that the variables are declared within the IIFE 
	 * and a function that is also declared within the IIFE accesses those variables
	 * */

	/*
	 * Template
	 */
	var yourObject = function() {
		// Private Data Variables
		//

		return {
		// public methods and properties
		}
	}();

	/*
	 * Extra Brackets - Don't know why, works well w/o
	 */
	var yourObject2 = (function() {
		// Private Data Variables
		//

		return {
		// public methods and properties
		}
	}());

	var person = (function() {
		var age = 25;

		return {
			name : "Nicholas",
			getAge : function() {
				return age;
			},
			growOlder : function() {
				age++;
			}
		};
	}());

	console.log("Person Name:" + person.name);
	console.log("Person Age:" + person.getAge());
	// Can't override
	person.age = 100;
	console.log("Person Age:" + person.getAge());
	person.growOlder();
	console.log("Person Age:" + person.getAge());

	/*-
	 * Revealing module patterns, 
	 *  - Which arranges all the Variables and methods at the top of the IIFE and assigns thme to the returned Object literaiotn
	 * 
	 * */

	var person = (function() {
		var age = 25;
		function getAge() {
			return age;
		}
		function growOlder() {
			age++;
		}
		return {
			name : "Nicholas",
			getAge : getAge,
			growOlder : growOlder
		};
	}());

	/*- Private Members for Constructors
	 *  Module Pattern is great for defining individual objects that have private properties - 
	 *  i.e Object Literals which you don't want to create instances of  
	 *  But for Custom Types private Members are better
	 *  
	 */

	console.log("****Private Members for Constructors");
	function Person(name) {
		var age = 25;
		this.name = name;
		this.getAge = function() {
			return age;
		};
		this.growOlder = function() {
			age++;
		};
		return age;
	}

	var person = new Person("Sundeep");
	console.log(person);
	console.log("Person Name:" + person.name);
	console.log("Person Age:" + person.getAge());
	// Can't override
	person.age = 100;
	console.log("Person Age:" + person.getAge());
	person.growOlder();
	console.log("Person Age:" + person.getAge());

	/*- The above works, but placing methods on the Object Instance is less efficient
	 *  You can use prototype, this doesn't work, as this.age is not associated via age and hence returns undefined
	 *  Also setting person.age adds a instance property directly to the instance
	 */

	function Person2(name) {
		// Private
		var age = 25;
		// Public
		this.name = name;
	}

	Person2.prototype.getAge = function() {
		return this.age;
	};

	Person2.prototype.growOlder = function() {
		this.age++;
	};

	var person = new Person2("Sundeep");
	console.log(person);
	console.log("Person Name:" + person.name);
	console.log("Person Age:" + person.getAge());
	// Can't override
	person.age = 100;
	console.log("Person Age:" + person.getAge());
	person.growOlder();
	console.log("Person Age:" + person.getAge());

	/*- To fix, we can use the hybrid approach
	 *  The below utilizes a hybrid approach, so everything is defined inside one area and return another Object which has access to the variable inside
	 */

	var Person3 = (function() {
		var age = 25;
		function InnerPerson(name) {
			if (this instanceof InnerPerson) {
				this.name = name;
			} else {
				return new InnerPerson(name);
			}
		}
		;
		InnerPerson.prototype.getAge = function() {
			return age;
		};
		InnerPerson.prototype.growOlder = function() {
			age++;
		};
		return InnerPerson;
	}());

	var person = new Person3("Sundeep");
	console.log(person);
	console.log("Person Name:" + person.name);
	console.log("Person Age:" + person.getAge());
	// Can't override
	person.age = 100;
	console.log("Person Age:" + person.getAge());
	person.growOlder();
	console.log("Person Age:" + person.getAge());

	/*-
	 * Scope Safe Constructors
	 * Because all constructors are functions, you can call them without using the new Operator, therefore affecting the value of this
	 * */

	function Person4(name) {
		this.name = name;
	}
	;

	Person.prototype.sayName = function() {
		console.log(this.name);
	};

	var person1 = Person("Sundeep");

	// Basically since, new wasn't used, the this is the scope where it was
	// invoked.
	// in this case, the window object.

	console.log(person1 instanceof Person);// false
	console.log(typeof person1);// undefined
	console.log(person1.name) // Undefined

	console.log(name);// Sundeep
	console.log(this.name);// Sundeep --> This refers to the current Window
							// Object

	// To fix
	function Person5(name) {
		if (this instanceof Person) {
			this.name = name;
		} else {
			return new Person(name);
		}
	}

	/*
	 * Mixins
	 */

};
