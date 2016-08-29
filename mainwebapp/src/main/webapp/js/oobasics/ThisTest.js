/**
 * This represents the global Object, in case of Browsers, it is the window object.
 * When a function is called while attached to an object, this is to equal to the object by default
 */

/**
 * Simple Test1
 */
var person = {
	name : "Nicholas",
	sayName : function() {
		
		console.log("PersonName:" + person.name);
	},
	sayNameThis : function(){
		console.log("This is:"  + this +  ":This Name:" + this.name);
	}
}

person.sayName();
person.sayNameThis();


/**
 * Simple Test2
 */


function sayNameForAll(label){
	console.log(label + ":" + this.name);
}

var person1 = {
		name : "Nicholas",
		sayName : sayNameForAll
}

var person2 = {
		name : "Greg",
		sayName : sayNameForAll
}

var name = "Sundeep";

person1.sayName("person1");//Prints Nicholas
person2.sayName("person2");//Prints Greg
sayNameForAll("this");//Prints Sundeep



/**
 * Changing this.
 * call() --> Executes the Function with the Object you would like to call it for.
 * apply() --> Similar to call, but an array of Objects can be passed
 * bind()  --> Binds an function to an object and returns a function, which can then be called w/o every changing the value of this. 
 */

/**
 * call()
 */
sayNameForAll.call(this,"call:global");
sayNameForAll.call(person1,"call:person1");
sayNameForAll.call(person2,"call:person2");
//null is overridden to this.
sayNameForAll.call(null,"call:null");

/**
 * apply()
 */

sayNameForAll.apply(this,["apply:global","Blah"]);
sayNameForAll.apply(person1,["apply:person1"]);
sayNameForAll.apply(person2,["apply:person2"]);
//null is overridden to this.
sayNameForAll.apply(null,["apply:null"]);


/**
 * bind()
 * 
 */

var sayNameForPerson1 = sayNameForAll.bind(person1);
sayNameForPerson1("person1");

var sayNameForPerson2 = sayNameForAll.bind(person2, "person2");
sayNameForPerson2();

//Adding a Function to the person2 and assigning the value sayNameForPerson1, doesn't change the value of this.
person2.sayName = sayNameForPerson1
person2.sayName("person2");

