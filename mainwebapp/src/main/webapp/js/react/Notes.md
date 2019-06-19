
a) MVC didn't scale at FaceBook -- Why ?
If more models and views, it gets complicated and can lead to infinite loops, as views can send back data to the model and back to the view

Action -> Controller --> Model --> View
					 --> Model --> View
					 --> Model --> View	 

Flux :: Using Single Directional Data Flow
Action -> Dispatcher -> Store(Data Layer) -> View (Can send an action into the dispatcher)

React :: Declarative Views
Virtual DOM and makes code predictable

 Questions* :: 
	When does it decide to merge the Virtual DOM with the core DOM and what are scaling implications on the browser mobile web or otherwise


b) Immutable Data Structures:
	Copying not very efficient especially if size gets big , so sharing would be better option
	Structural Sharing
	Example :: Mori, Immutable JS


Thoughts* ::
	Functional vs Imperative vs OOP
	Trie :: 	
	Bitmap Vectored Trie :: ~32 branches per Level to reduce to get to the value you are interested in  
	HashArray Map Trie
	
	
	
c) Architecture 	
Immutable User Interfaces ::

Memoization :: Re-use prev function
		
	 
	 
Come back :
	CQRS:https://martinfowler.com/bliki/CQRS.html
	Event Sourcing : https://martinfowler.com/eaaDev/EventSourcing.html
	Flux/MVC 
	https://jaysoo.ca/2015/02/06/what-the-flux/	 