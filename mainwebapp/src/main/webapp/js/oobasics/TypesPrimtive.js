/**
 * Covers Primitive Types Equals Operator Primitive Methods
 */

/*-
 * Primitive Types
 * Boolean 		--> True or False
 * Number 		--> Any Integer of Floating Point numeric Value
 * String 		--> A character or Sequence of Characters
 * Null 		--> a Primitive type that has only one value Null
 * Undefined 	--> A primitive type that has only one value undefined
 */

// Strings
var name = "Sundeep";
console.log("name:" + typeof name);
var selection = "a";
console.log("selection:" + typeof selection);

// Numbers
var x = 5;
var y = 3.14;

console.log("selection:" + typeof x);

// Boolean
var found = true;
console.log("found:" + typeof found);

// null
var object = null;
// This is a known error
console.log("object:" + typeof object);

// undefined
var flag = undefined;
var ref;
console.log("flag:" + typeof flag);
console.log("=================");

/*-
 * === vs ==
 */

// == converts "5" to 5 and compares, while === doesn't
console.log("'5' == 5:" + ("5" == 5));
console.log("'5' === 5:" + ("5" === 5));

console.log("undefined == null:" + (undefined == null));// true
console.log("undefined === null" + (undefined === null));// false



/*-
 * Primitive Methods
 * Treats Primitve like Objects to provide a consistent experience
 */

var name = "Nicholas";
var lowerCaseName = name.toLowerCase();

var count = 10;
var fixedCount = count.toFixed(2);

var flag = true;
console.log(typeof flag.valueOf());
