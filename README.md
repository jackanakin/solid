# SOLID, Design Patterns

## 1 - Single Responsability Principle
`There should never have more than one reason for a class to change`

A class should have a focused, single functionality or address a specific concern. Ideally, each responsability should be in a separate class.

[Java Example](https://github.com/jackanakin/solid/tree/main/java/1%20-%20Single%20Responsability%20Principle)

## 2 - Open-Closed Principle
`Classes, Modules, Methods etc should be open for extension, but closed for modification`

We should be able to extend some functionality without changing the existing code

[Java Example](https://github.com/jackanakin/solid/tree/main/java/2%20-%20Open-Closed%20Principle)

## 3 - Liskov Substitution Principle
`We should be able to substitute base class objects with child class objects and this should not change the behavior of the program`

Subclasses should behave the same way as the objects of our superclass (Square Rectangle Example)

[Java Example](https://github.com/jackanakin/solid/tree/main/java/3%20-%20Liskov%20Substitution%20Principle)

## 4 - Interface Segregation Principle
`Classes should not depend on interfaces that they do not use (Interface Pollution: Large interfaces, unrelated methods)`

`Signs: classes have empty methods implementations, throw NotImplementedException(or similar) or return null default/dummies values`

[Java Example](https://github.com/jackanakin/solid/tree/main/java/4%20-%20Interface%20Segregation%20Principle)

## 5 - Dependency Inversion Principle
`High level modules should not deppend upon low level modules. Both should depend upon abstraction`

`Abstractions should not depend upon details. Details should depend upon abstractions`

Example: Spring @Autowire annotation

[Java Example](https://github.com/jackanakin/solid/tree/main/java/5%20-%20Dependency%20Inversion%20Principle)

## 6 - Creational Design Patterns
`Deal with the creation of objects of classes`

### 6.1 Builder 
`Usefull when there is a complex process to construct an object, also, abstracts logic related to the object and allows immutable class creation`

Examples: StringBuilder (not 100%) and Calendar

### 6.2 Simple Factory
`Method that separate and encapsulate the instantiation of an object, commonly to a static method`

Simply moves instantiation logic away from main code avoiding importing unrelated classes

Knows about all classes objects it can create

May combined to use Builder pattern to create and object

Examples: NumberFormat

### 6.3 Factory Method

Moves object creation logic from main code to separate class

The creator can be concrete class and provide a default implementation

Don't need to know which class to instantiate and allows new classes to be added withou affecting main code

Subclasses decide which object to instantiate by overriding factory method

May be combined with Simple Factory

Examples: AbstractCollection<E> has an abstract method called iterator()

### 6.4 Prototype
`Allow us to make copies of existing object avoiding having to recreate objects from scratch`

A complex object that is costly to create may be re-created using and existing instance

Should pay attention to the requirement of deep or shallow copy of object state

Examples: Object.clone()

### 6.5 Abstract Factory
`Allows to produce families of related objects without specifying their concrete classes`

Usefull when we need to work with sets or kits of related classes that are related to produce something or wish to constraint object creation so that they all work together

Factories can be singletons

Adding a new class type requires changes to the base factory

Examples: DocumentBuilderFactory (not 100%)

### 6.6 Singleton
`Ensures that a class has only one instance, while providing a global access point to this instance`

Declare constructor private, provide a getInstance method for global access

Are held by class loader and not per JVM

Eager - Creates the instance ASAP

Lazy with Double Checked Locking (Classic) - Creates the instance only when needed, must aquire thread lock and deal with sync. problems

Lazy with Initialization Holder Class - Creates an inner holder to avoid having sync. and threadlock issues

Enum - Deals with serealization problems

Examples: java.lang.Runtime

### 6.7 Object Pool
`Usefull when the cost of creating an instance of a class is high and a large number of objects of this class is needed for a short duration`

Create a class for object pool with a thread-safe caching of objects and add a method to acquire and release objects, pool should also reset the object before giving it out

We should choose an aproach when are no more objects available to give out, create a new instance of the object or wait for one to be available

Example: ThreadPoolExecutor, apache BasicDataSource

## 7 - Structural Design Patterns
`Deal with how classes and objects are arranged or composed`

### 7.1 Adapter aka Wrapper
`Allows objects with incompatible interfaces to collaborate`

Class adapter (two-way) - AVOID CLASS ADAPTERS! - Uses inheritance: the adapter inherits interfaces from both objects at the same time

Object adapter - Uses the object composition principle: the adapter implements the interface of one object and wraps the other one

Examples: InputStreamReader, OutputStreamWriter

### 7.2 Bridge
`Allows to split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation which can be developed independently of each other`

Using Bridge, we can change "how" a functionality is implemented without modifying classes used by the client<br/>
Bridge pattern uses composition to connect two inheritance hierachy

Examples: java.sql.Driver

### 7.3 Decorator
`Allows to attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors`

Add new functionality on top of what already exist in the existing object<br/>
We can wrap a decorator with another and derive some functionality which builds on top of what is provided

Examples: BufferedOutputStream decorates any OutputStream object and adds buffering to file writing operation

### 7.4 Composite
`Allows to compose objects into tree structures and then work with these structures as if they were individual objects`

Two basic element types that share a common interface: simple leaves and complex containers. A container can be composed of both leaves and other containers. This lets you construct a nested recursive object structure that resembles a tree<br/>
Use the pattern when you want the client code to treat both simple and complex elements uniformly

Without Composite pattern client code will have to write different code to handle object which has children. Composite pattern allows client to call a method on object and pattern takes care of handling children if present<br/>
You can treat them all the same via the common interface. When you call a method, the objects themselves pass the request down the tree

Examples: UI Frameworks, JSF UIViewRoot

### 7.5 Facade
`Provides a simplified interface to a library, a framework, or any other complex set of classes`

A facade should minimize the complexity of subsystems and provide usable interface.<br/>
Allows to have a weak coupling betweeb subsystems.<br/>
Provides simple methods that represent a use-case functionality provided by subsystem

Example: java.net.URL

### 7.6 Flyweight aka Cache
`Allows to fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object`

Intrinsic - state that is shared in every context<br/>
Extrinsic - context specific state

Object itself only stores shared state so one instance is shared, client code maintains part of the state that is specific to context

Example: java.lang.Integer.valueOf uses this pattern to cache Integers

### 7.7 Proxy
`Allows to provide a substitute or placeholder for another object`

Applicability: Lazy initialization (virtual proxy), Access control (protection proxy), Local execution of a remote service (remote proxy), Logging requests (logging proxy), Caching request results (caching proxy), Smart reference (dismiss heavyweight object).

Java can create dynamic proxy for a class which implements at least one interface

Examples: Lazy loading of collections by Hibernate

## 8 - Behavioral Design Patterns
`Deals with algorithms and the assignment of responsibilities between objects`

### 8.1 Chain of Responsibility
`Allows to pass requests along a chain of handlers, then each handler decides either to process the request or to pass it to the next handler in the chain`

Usefull when the program is expected to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand.<br/>
When it’s essential to execute several handlers in a particular order or when the set of handlers and their order are supposed to change at runtime.<br/>
Each handler knows the next one and passes the request object.<br/>
A request may go unprocessed and client may not know it<br/>

Examples: javax.servlet.Filter

### 8.2 Command aka Action, Transaction
`Turns a request into a stand-alone object that contains all information about the request, allowing you to pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations`

Allows to represent an operation/request/method-call as object and/or send requests to other parts of the application where they can be executed later.<br/>
Makes easy to implement reversible operations, queue operations, schedule their execution, or execute them remotely.

Examples: Runnable

### 8.3 Interpreter
`Allows to process a simple "language" with rules of grammar`

It allows us to represent the rules in a data strucutre and then interpret sentences in the language/grammar.<br/>
Each class represents a rule in the language, they also provide a method to interpret an expression.<br/>

Example: regex.Pattern