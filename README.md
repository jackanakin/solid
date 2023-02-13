# SOLID, Design Patterns

## 1 - Single Responsability Principle
`There should never have more than one reason for a class to change`

* A class should have a focused, single functionality or address a specific concern. Ideally, each responsability should be in a separate class.

[Java Example](https://github.com/jackanakin/solid/tree/main/java/1%20-%20Single%20Responsability%20Principle)

## 2 - Open-Closed Principle
`Classes, Modules, Methods etc should be open for extension, but closed for modification`

* We should be able to extend some functionality without changing the existing code

[Java Example](https://github.com/jackanakin/solid/tree/main/java/2%20-%20Open-Closed%20Principle)

## 3 - Liskov Substitution Principle
`We should be able to substitute base class objects with child class objects and this should not change the behavior of the program`

* Subclasses should behave the same way as the objects of our superclass (Square Rectangle Example)

[Java Example](https://github.com/jackanakin/solid/tree/main/java/3%20-%20Liskov%20Substitution%20Principle)

## 4 - Interface Segregation Principle
`Classes should not depend on interfaces that they do not use (Interface Pollution: Large interfaces, unrelated methods)`

[Java Example](https://github.com/jackanakin/solid/tree/main/java/4%20-%20Interface%20Segregation%20Principle)

## 5 - Dependency Inversion Principle
`High level modules should not deppend upon low level modules. Both should depend upon abstraction`

`Abstractions should not depend upon details. Details should depend upon abstractions`

Example: Spring @Autowire annotation

[Java Example](https://github.com/jackanakin/solid/tree/main/java/5%20-%20Dependency%20Inversion%20Principle)

## 6 - Creational Design Patterns
`Deal with the creation of objects of classes`

### 6.1 Builder 
`Allows to construct complex objects step by step and to produce different types and representations of an object using the same construction code`

Usefull when:<br/>
* There is a complex process to construct an object.<br/>
* Allows immutable class creation.<br/>
* Have to construct Composite trees or other complex objects.

Examples: StringBuilder and Calendar<br/>
[Conceptual Example (ts)](https://github.com/jackanakin/solid/tree/main/typescript/6%20-%20Creational%20Design%20Patterns/6.1%20Builder/ConceptualExample)<br/>
[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.1%20Builder)

### 6.2 Simple Factory
`Method that separate and encapsulate the instantiation of an object, commonly to a static method`

* Simple factory uses a criteria to choose which object to initialize.<br/>
* Simply moves instantiation logic away from main code avoiding importing unrelated classes.<br/>
* Knows about all classes objects it can create.<br/>
* May be combined to use Builder pattern to create and object.<br/>

Examples: NumberFormat

[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.2%20Simple%20Factory)

### 6.3 Factory Method aka Virtual Constructor
`Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created`

* Moves object creation logic from main code to separate class.<br/>
* The creator can be concrete class and provide a default implementation.<br/>
* Don't need to know which class to instantiate and allows new classes to be added without affecting main code.<br/>
* Subclasses decide which object to instantiate by overriding factory method.<br/>
* May be combined with Simple Factory.<br/>

Examples: AbstractCollection<E> has an abstract method called iterator()<br/>
[Conceptual Example (ts)](https://github.com/jackanakin/solid/tree/main/typescript/6%20-%20Creational%20Design%20Patterns/6.3%20Factory%20Method/ConceptualExample)<br/>
[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.3%20Factory%20Method)

### 6.4 Prototype
`Allows to make copies of existing object avoiding having to recreate objects from scratch`

* Copies an existing object to create a separate new object.<br/>
* While implementing, attention to the requirement of deep or shallow copy of object state.<br/>

Usefull when:<br/>
* A complex object that is costly to create may be re-created using and existing instance.<br/>
* When code shouldn’t depend on the concrete classes of objects that you need to copy.<br/>

Examples: Object.clone()

[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.4%20Prototype)

### 6.5 Abstract Factory
`Allows to produce families of related objects without specifying their concrete classes`

* Factories can be singletons.<br/>
* Client code is unaware of the concrete factory class that it is using as well as the products. Client code works with interface or abstract class references.<br/>
* A product family has classes whose objects work with each other to achieve some functionality. These classes can belong to different inheritance hierachy.<br/>

Usefull when:<br/>
* Have to work with sets or kits of related classes that are related to produce something.<br/>
* Have to constraint object creation so that they all work together.<br/>

Examples: DocumentBuilderFactory (not 100%)

[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.5%20Abstract%20Factory)

### 6.6 Singleton
`Ensures that a class has only one instance, while providing a global access point to this instance`

* Any mutable state of a singleton is a global state.<br/>
* Simply declare the constructor private and provide a getInstance method for global access.<br/>
* Instances are held by class loader and not per JVM.<br/>

Best option of type is Lazy with Initialization Holder Class.<br/>
Types:<br/>
* Eager - Creates the instance ASAP.<br/>
* Lazy with Double Checked Locking (Classic) - Creates the instance only when needed, must aquire thread lock and deal with sync. problems.<br/>
* Lazy with Initialization Holder Class - Creates an inner holder to avoid having sync. and threadlock issues.<br/>
* Enum - Deals with serealization problems.<br/>

Examples: java.lang.Runtime

[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.6%20Singleton)

### 6.7 Object Pool
`Usefull when the cost of creating an instance of a class is high and a large number of objects of this class is needed for a short duration`

* Create a class for object pool with a thread-safe caching of objects and add a method to acquire and release objects, pool should also reset the object before giving it out.<br/>
* Must choose an aproach when there aren't more objects available to give out: create a new instance of the object or wait for one to be available.<br/>
* Must execute a reset method on the object before returning it to the cache.<br/>

Usefull when:<br/>
* Object creation cost is very high and each object is used for a short duration as well as large number of such objects are needed.<br/>
* Object Pool can improve application performance.<br/>
* An object represents an external resource which is limited, like database connections.

Example: ThreadPoolExecutor, apache BasicDataSource

[Java Example](https://github.com/jackanakin/solid/tree/main/java/6%20-%20Creational%20Design%20Patterns/6.7%20Object%20Pool)

## 7 - Structural Design Patterns
`Deal with how classes and objects are arranged or composed`

### 7.1 Adapter aka Wrapper
`Allows objects with incompatible interfaces to collaborate`

Types:<br/>
* Class adapter (two-way) - AVOID CLASS ADAPTERS! - Uses inheritance: the adapter inherits interfaces from both objects at the same time.<br/>
They extend from the original class and also inherit from the target interface, so they can be used where either of those interface/class is expected.<br/>
* Object adapter - Uses the object composition principle: the adapter implements the interface of one object and wraps the other one.<br/>

Usefull when:<br/>
* Have to use some existing class, but its interface isn’t compatible with the rest of the code.<br/>
* Have to reuse several existing subclasses that lack some common functionality that can’t be added to the superclass.<br/>

Examples: InputStreamReader, OutputStreamWriter

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.1%20Adapter)

### 7.2 Bridge
`Allows to split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation which can be developed independently of each other`

* It allows to change "how" a functionality is implemented without modifying classes used by the client.<br/>
* It uses composition to connect two inheritance hierachy.<br/>

Usefull when:<br/>
* Have to divide and organize a monolithic class that has several variants of some functionality (for example, if the class can work with various database servers).
* Have to extend a class in several orthogonal (independent) dimensions.<br/>
* Have to be able to switch implementations at runtime.<br/>

Examples: java.sql.Driver

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.2%20Bridge)

### 7.3 Decorator aka Wrapper
`Allows to attach new behaviors to objects by placing these objects inside special wrapper objects that contain the new behaviors`

* It allows to add new functionality on top of what already exist in the existing object.<br/>
* A decorator can be wrapped with another and derive some functionality which builds on top of what is provided.<br/>

Usefull when:<br/>
* Have to be able to assign extra behaviors to objects at runtime without breaking the code that uses these objects.<br/>
* It’s awkward or not possible to extend an object’s behavior using inheritance.<br/>
* It inherits from same interface/class from which the object it decorates inherits.<br/>

Examples: BufferedOutputStream decorates any OutputStream object and adds buffering to file writing operation

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.3%20Decorator)

### 7.4 Composite aka Object Tree
`Allows to compose objects into tree structures and then work with these structures as if they were individual objects`

* Allows to treat them all the same via the common interface, when a method is called, the objects themselves pass the request down the tree.<br/>
* The pattern allows the client code to treat both simple and complex elements uniformly.<br/>
* Once a tree structure is created the client code does not need to worry about whether an object is a leaf node or not.<br/>
* Two basic element types that share a common interface: simple leaves and complex containers. A container can be composed of both leaves and other containers. This lets you construct a nested recursive object structure that resembles a tree<br/>
* Without Composite pattern client code will have to write different code to handle object which has children. Composite pattern allows client to call a method on object and pattern takes care of handling children if present<br/>

Usefull when:<br/>
* Have to implement a tree-like object structure.<br/>
* Have to treat both simple and complex elements uniformly.<br/>

Examples: UI Frameworks, JSF UIViewRoot

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.4%20Composite)

### 7.5 Facade
`Provides a simplified interface to a library, a framework, or any other complex set of classes`

* Simplify the usage of a subsystem and to decouple client code from other subsystem classes as much as possible. Client code gets a simplified API.<br/>
* Provides simple methods that represent a use-case functionality provided by subsystem, so each method ideally should correspond to a use-case.<br/>
* Minimize the complexity of subsystems and provide usable interface.<br/>

Usefull when:<br/>
* Have need of a limited but straightforward interface to a complex subsystem.<br/>
* Have to structure a subsystem into layers.<br/>

Example: java.net.URL

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.5%20Facade)

### 7.6 Flyweight aka Cache
`Allows to fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object`

* Object itself only stores shared state so one instance is shared, client code maintains part of the state that is specific to context.<br/>

States:<br/>
* Intrinsic - Stored in the Flyweight object itself and is shared in every context.<br/>
* Extrinsic - Stored by client code and is a context specific state.<br/>

Usefull when:<br/>
* Have to support a huge number of objects which barely fit into available RAM.<br/>
* Application needs to spawn a huge number of similar objects and they contain duplicate states which can be extracted and shared between multiple objects.<br/>

Example: java.lang.Integer.valueOf uses this pattern to cache Integers

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.6%20Flyweight)

### 7.7 Proxy
`Allows to provide a substitute or placeholder for another object`

* Java can create dynamic proxy for a class which implements at least one interface

Usefull for:<br/>
* Lazy initialization (virtual proxy).<br/>
* Access control (protection proxy).<br/>
* Local execution of a remote service (remote proxy).<br/>
* Logging requests (logging proxy).<br/>
* Caching request results (caching proxy).<br/>
* Smart reference (dismiss heavyweight object).<br/>

Examples: Lazy loading of collections by Hibernate

[Java Example](https://github.com/jackanakin/solid/tree/main/java/7%20-%20Structural%20Design%20Pattern/7.7%20Proxy)

## 8 - Behavioral Design Patterns
`Deals with algorithms and the assignment of responsibilities between objects`

### 8.1 Chain of Responsibility aka CoR, Chain of Command
`Allows to pass requests along a chain of handlers, then each handler decides either to process the request or to pass it to the next handler in the chain`

* Chain of Responsibility passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.<br/>
* A request may go unprocessed and client may not know it.<br/>
* Each handler knows the next one and passes the request object.<br/>

Usefull when:<br/>
* Have to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand.<br/>
* It’s essential to execute several handlers in a particular order or when the set of handlers and their order are supposed to change at runtime.<br/>

Examples: javax.servlet.Filter

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.1%20Chain%20of%20Responsibility)

### 8.2 Command aka Action, Transaction
`Turns a request into a stand-alone object that contains all information about the request, allowing you to pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations`

* Allows to represent an operation/request/method-call as object and/or send requests to other parts of the application where they can be executed later.<br/>
* Makes easy to implement reversible operations, queue operations, schedule their execution, or execute them remotely.<br/>
* Command establishes unidirectional connections between senders and receivers.<br/>

Usefull when:<br/>
* Have to parametrize objects with operations.<br/>
* Have to queue operations, schedule their execution, or execute them remotely.<br/>
* Have to implement reversible operations.<br/>

Examples: Runnable

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.2%20Command)

### 8.3 Interpreter
`Allows to process a simple language or grammar rules`

* Allows to represent rules in a data structure and then interpret sentences in the language/grammar.<br/>
* Each class represents a rule in the language, they also provide a method to interpret an expression.<br/>
* A non-terminal expression contains other expressions and calls interpret on them.<br/>

Usefull when:<br/>
* "Interpreting" grammer rules.<br/>

Example: regex.Pattern

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.3%20Interpreter)

### 8.4 Mediator aka Intermediary, Controller
`Reduce chaotic dependencies between objects, restricts direct communications between the objects and forces them to collaborate only via a mediator object`

* Many to many communication/interaction.<br/>
* Encapsulate complex interaction between objects.<br/>
* Mediator eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.<br/>
* Objects talk to mediator and mediator takes care of passing the message to other objects thus de-coupling them.<br/>

Usefull when:<br/>
* It’s hard to change some of the classes because they are tightly coupled to a bunch of other classes.<br/>
* We can’t reuse a component in a different program because it’s too dependent on other components.<br/>
* Have to create tons of component subclasses just to reuse some basic behavior in various contexts.<br/>

Examples: javax.swing.ButtonGroup

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.4%20Mediator)

### 8.5 Iterator
`Allows to traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.)`

* Many Iterators maintain internal state to remember the current position so if collection changes then this instance becomes invalid.<br/>
* Some special Iterators take a snapshot of collection when they are created and can work even if collection changes.<br/>

Usefull when:<br/>
* Collection has a complex data structure under the hood and it's complexity must be hidden from the client.<br/>
* Have to reduce duplication of the traversal code across the app.<br/>
* Have to be able to traverse different data structures or when types of these structures are unknown beforehand.<br/>

Examples: java.util.Iterator, Scanner

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.5%20Iterator)

### 8.6 Memento aka Snapshot
`Allows to save and restore the previous state of an object without revealing the details of its implementation`

* State is sealed except for originator, it does not "leak" any stored state to outside world.<br/>
* Needs a "caretaker" to store it's states snapshots.<br/>

Usefull when:<br/>
* Have to produce snapshots of the object’s state to be able to restore a previous state.<br/>
* Direct access to the object’s fields/getters/setters violates its encapsulation.<br/>

Examples:

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.6%20Memento)

### 8.7 Observer aka Event-Subscriber, Listener
`Allows to define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing`

* One to many communication/interaction.<br/>
* Allows receivers to dynamically subscribe and unsubscribe from receiving requests.<br/>
* Can notify other objects not only when its state changes but also on some other event occurs like a method is called on the object.

Usefull when:<br/>
* Changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.<br/>
* Some objects in the app must observe others, but only for a limited time or in specific cases.<br/>

Examples: HttpServletListener

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.7%20Observer)

### 8.8 State
`Allows to an object alter its behavior when its internal state changes. It appears as if the object changed its class`

* Encapsulate different behaviors of objects in separate classes based on its current state.<br/>
* Same methods of object behave differently based on object's current state.<br/>
* State pattern is about behavior and separating that behavior in a nice organized classes, effect of calling a method depends on current of the object.<br/>
* State object represents current state of our context object.<br/>

Usefull when:<br/>
* Have an object that behaves differently depending on its current state, the number of states is enormous, and the state-specific code changes frequently.<br/>
* Have a class polluted with massive conditionals that alter how the class behaves according to the current values of the class’s fields.<br/>
* Have a lot of duplicate code across similar states and transitions of a condition-based state machine.

Examples: JSF LifeCycle

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.8%20State)

### 8.9 Strategy
`Allows to define a family of algorithms, put each of them into a separate class, and make their objects interchangeable`

* Encapsulate one/many algorithms in classes allowing to change the algorithm used to perform an operation.<br/>
* One class per algorithm.<br/>

Usefull when:<br/>
* Have to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.<br/>
* Have a lot of similar classes that only differ in the way they execute some behavior.<br/>
* Have to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.<br/>
* Have a class with massive conditional statements that switches between different variants of the same algorithm.

Examples: java.util.Comparator

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.9%20Strategy)

### 8.10 Template Method
`Allows to define the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure`

* Steps are abstract methods in the base class, subclasses override them and provide diferent implementations.<br/>
* All subclasses must override the steps.<br/>

Usefull when:<br/>
* Need to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure.<br/>
* Have several classes that contain almost identical algorithms with some minor differences.<br/>

Examples: java.util.AbstractMap

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.10%20Template%20Method)

### 8.11 Visitor
`Allows to separate algorithms from the objects on which they operate`

* Visitor can work with objects of classes which do not have a common parent, they define class specific methods.<br/>
* Visitors often need access to internal state of objects.<br/>
* Adding new functionality is simple as adding a new visitor class.<br/>
* Visitor can also store state.<br/>
* All visitor subclasses provide possibly different functionalities from each other.<br/>

Usefull when:<br/>
* Have to perform an operation on all elements of a complex object structure (for example, an object tree).<br/>
* Have to clean up the business logic of auxiliary behaviors.<br/>
* A behavior makes sense only in some classes of a class hierarchy, but not in others.<br/>

Example: java.nio.file.FileVisitor

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.11%20Visitor)

### 8.12 Null Object
`Provide an alternative representation to indicate an absence of object`

* They never create/transform a real object.<br/>
* Method implementations of Null object should not cause any changes in application state, it's job is to do nothing<br/>

Usefull when:<br/>
* Treat absence of object transparently without null check.<br/>

Example: java.awt.event.MouseAdapter

[Java Example](https://github.com/jackanakin/solid/tree/main/java/8%20-%20Behavioral%20Design%20Patterns/8.12%20Null%20Object)
