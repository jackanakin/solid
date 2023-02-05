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