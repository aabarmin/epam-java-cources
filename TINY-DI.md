# Tiny Dependency Injection Container

In software engineering, Dependency Injection is a technique in which an object receives other objects it depends on.
[An article about Dependency Injection on Wikipedia](https://en.wikipedia.org/wiki/Dependency_injection)
 
So, this task is about implementation of a tiny dependency injection container using all the knowledge gathered
while solving other tasks included into this collection of exercises. 

## Project goals

The main goal of this project is to make you aware of dependency inversion principle and dependency injection in common.
The following things need to be implemented:

* A service that is responsible for loading component definitions described in the XML file - so, it should be 
something like a bean-definition reader. 
* Another service that is responsible for creating instances of described components. There should be possible getting
an instance based on its name, class or interface names. 

## Recommended technologies

You may follow next ideas to simplify the development:

* Use JAXB for reading bean definitions. 
* Use Reflection API to create instances. 

## Starting points  

The following points can be considered as good starting points: 

* An `ApplicationContext` interface can be used as an entry point to the whole container - it can delegate reading
of bean definitions from resource files to the separate component and on the other hand delegate creation of the
instances to another component. 