function Person(name) {

    //Static Variables
    this.constructor.population++;
    //Privelged Variables
    this._variables = {
        name: name,
        a: "test",
        b: "test",
    };

    this._initialize = function() {

        //Using Call method and passing Object reference
        privateFunctions.call(this);
    };
    
    this._functions = {
        
        more : function(){
            alert("More");
        }
        
    };
    
    //Private Variables
    var privateProperties = {
        pTest: "pTest",
    };

    //Private Functions
    var privateFunctions = function() {
        alert(this);
        alert(privateProperties.pTest);
        alert(this._variables.a);
    };
    //Priveleged Functions



}
;
Person.population = 1;
alert(Person.population);
//Create New Person
var sundeep = new Person("Sundeep");
alert(Person.population);
alert(sundeep._variables.name);
//sundeep._initialize();

//sundeep._functions();

sundeep._functions.more();