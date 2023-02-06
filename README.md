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