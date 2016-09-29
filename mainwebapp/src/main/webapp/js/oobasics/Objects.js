/**
 * 
 */

define([ "utils/customConsole", "utils/commonUtils" ], function(customConsole,
		commonUtils) {

	commonUtils.printCurrentFileName(arguments.length);

	/*-
	 *  Defining/Adding Properties
	 *  When a property is first add the [[Put]] Method is called on a Object
	 *  [[Put]] will create a spot in the Object to store the property.
	 *  Result is creation on an <i>"own property"</i> 
	 *  Own Property is different from Prototype Properties 
	 *  
	 *  When a new Value is assigned the [[Set]] Method is called
	 */

	/*
	 * Put is Called
	 */
	var person1 = {
		name : "Sundeep",
		sayName : function() {
			console.log(this.name);
		}
	};

	var person2 = new Object();
	person2.name = "Sundeep";

	customConsole.printObj("person1", person1);
	customConsole.printObj("person2", person2);

	person1.age = "11";
	person2.age = "23";
	// customConsole.printObj("person1", person1);
	// customConsole.printObj("person2", person2);

	/*
	 * Set is Called
	 */

	person1.age = "44";
	person2.age = "44";

	// customConsole.printObj("person1", person1);
	// customConsole.printObj("person2", person2);

	/*-
	 *  Detecting Properties Properties
	 *  Unreliable, since it the value can be null, undefined, 0, false, NaN, or an Empty String
	 *  <code>
	 *  if(person.age){
	 *  }
	 *  </code>
	 *  
	 *  Best way to use "in"  Operator, can be used for any property - inclusive of methods
	 *  Syntax :: "property" in [[Object]]
	 *  In Operator checks own properties as well as Prototype Properties
	 *  
	 *  To check only OwnProperty only, use the Object method --> hasOwnProperty();
	 *  
	 */

	console.log("In:Age:" + ("age" in person1));
	console.log("HasOwn:Age:" + person1.hasOwnProperty("age"));
	console.log("In Name:" + ("name" in person1));
	console.log("HasOwn:Name:" + person1.hasOwnProperty("name"));
	console.log("title" in person1);
	console.log("HasOwn:Title:" + person1.hasOwnProperty("title"));
	console.log("In SayName:" + ("sayName" in person1));
	console.log("HasOwn:sayName:" + person1.hasOwnProperty("sayName"));
	console.log("HasOwn:toString:" + person1.hasOwnProperty("toString"));

	/*-
	 *  Removing Properties
	 * 	Setting a value to null only calls the set Method.
	 *  To remove a value call the delete operator
	 *  This calls an internal operation called [[Delete]]
	 */

	console.log("Before Delete:HasOwn:Age:" + person1.hasOwnProperty("age"));
	delete person1.age;
	console.log("After Delete:HasOwn:Age:" + person1.hasOwnProperty("age"));
	console.log("Person1 Age:" + person1.age);

	/*-
	 *  Enumeration 
	 *  Enumerable properties have their internal [[Enumerable]] attributes set to true
	 *  
	 *  By Default all Properties you add to an object are Enumerable
	 *  
	 * 
	 * For in is to Enumerate Prototype values as well as opposed to Object.keys(Introduced in ECMA5 Using Object.Keys) which is only for own Prototypes
	 * 
	 * Not all properties are Enumerable, the [Enumerable] attribute is set to false, example : toString() and most other Native Properties
	 * 
	 *  */
	customConsole.printObjProperties(person1);
	customConsole.printObjPropertiesObjectKeys(person1);

	console.log("isNameEnumerable:" + person1.propertyIsEnumerable("name"));
	console.log("isToStringEnumerable:"
			+ person1.propertyIsEnumerable("toString"));

	var properties = commonUtils.getObjectProperties(person1);
	console.log("isLengthProperty:" + ("length" in properties));
	console.log("isLengthEnumerable:"
			+ properties.propertyIsEnumerable("length"));
	
	
	/*-
	 * Two type of Properties
	 * Data and Accessor
	 * 	Data contains a value like a name , default behavior of [Put] is to create a data Property
	 * 	Accessor properties don't contain a value, instead they contain a function to get the value of the property
	 *  "set" and "get" keywords are used , this is similar to function w/o a function keyword .
	 *  
	 *  If Set is not defined, it is read-only
	 *  If Get is not defined, it is write-only.
	 *  
	 *  Note: This can be overridden easily by the using the variable directly
	 * */
	
	var person = {
		_name : "Sundeep", 
		_age : 25,
		set name(value){
			this._name = value;
			console.log("Setting name to %s",value);
		}, 
		get name(){
			console.log("Reading Name:");
			return this._name;
		},
		get name2(){
			console.log("Reading Name2:");
			return this._name;
		},
		test : function(){
			console.log("Name: %s",this.name);
		}
	};
	
	// Calls the Get name()
	console.log(person.name);
	// Calls the Set name()
	person.name = "Tonse";
	// Calls the Get name()
	console.log(person.name);
	console.log(person.name2);
	// Direct Invocation of the _name
	console.log("Direct Invocation:" + person._name);
	
	console.log("_name" in person);
	
	// This Prints the function
	console.log(person.test);
	// This calls the function
	console.log(person.test());
	
	
	/*- Property Attributes
	 * 
	 * Common Attributes
	 * --> Enumerable/Configurable
	 * [Configurable] --> Once you set the Configurable as false, it can be reset or any other property be changed, inclusive of its value
	 * Object.defineProperty() --> To Define 1 property
	 * Object.defineProperties() --> To Define Multiple Properties
	 * Important to set all Attributes, else it be set of false;
	 * 
	 * Data Property Attributes:: 
	 * [[Value]] --> Stores the Value
	 * [[Writable]] --> Indicates if it can be written to
	 * 
	 */
	
		
	
	var person1 = {
			name:"Sundeep"
	}
	
	Object.defineProperty(person1, "name", {
		enumerable:false
	});
	
	console.log("name" in person1); // True
	console.log(person1.propertyIsEnumerable("name"));// False
	
	Object.defineProperty(person1,name,{
		configurable : false
	});
	
	delete person1.name;// False//Errors out in Strict mode
	
	try{
	// Errors out, you can can't modify a property where the Configurable is set
	// to false;
	Object.defineProperty(person1,name,{
		enumerable : true
	});
	}catch(err){
		console.log("Person1 Error : %s",err.message);
	}
	
	
	/*
	 * By Default all properties will be false
	 */
	var person2 = {};
	Object.defineProperty(person2, "name", {
		value:"Sundeep"
	});
	
	try{
		// Errors out, you can can't modify a property where the Configurable is
		// set
		// to false;
		Object.defineProperty(person2,"name",{
			enumerable : true
		});
	}catch(err){
		console.log("Person2 Error : %s",err.message);
	}
	
	/*
	 * Accessor Property Attributes
	 * 
	 * set/get
	 * 
	 */
	
	var person3 = {
			_name : "Nicholas"
	};
	Object.defineProperty(person3, "name",{
		get : function(){
			console.log("Reading Name:");
			return this._name;
		},
		set : function(value){
			this._name = value;
			console.log("Setting name to %s",value);
		},
		enumerable: true,
		configurable: true
	});
	
	
	/*
	 * Get the Property Attributes
	 * */
	
	console.log(Object.getOwnPropertyDescriptor(person3,"_name"));
	console.log(Object.getOwnPropertyDescriptor(person3,"name"));
	
	
	/*
	 * Preventing Object Modification
	 * 
	 * Objects just like Properties have internal attributes that govern their behavior 
	 * [Extensible] --> Defines if a object can be modified
	 * 
	 * 
	 * Object.isExtensible --> Checks if Extensible
	 * 
	 * Preventing Extension
	 * 1) Object.preventExtensions() --> Makes the Object Non extensible --> Doesn't allow any more properties to be added
	 * 2) Object.seal()              --> Makes the Object Non extensible and makes all the properties non-configurable (you can read and write)
	 * 3) Object.freeze()			 --> Makes the Object Sealed and makes all the properties non-writable (you can read, but not write)
	 * */
	
	
});
