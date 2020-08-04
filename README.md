# Spring Overview

- Bean is an object
- IOC with XML config - when object is created, no need to be hard-coded
- DI with XML config - imagine you order a car (object) that is produced by a car factory (Bean factory) and put parts together 

- Bean scope - singleton (by default), prototype
- Singleton 
    1. creates only one instance of he bean
    2. cached in memory
    3. All requests for the bean will return a shared reference to the same Bean
    
- Bean LifeCycle - Container created -> bean instantiated -> custom init -> bean used -> container destroyed -> custom destroy

- Component classes - spring will scan java classes and automatically register the bean in spring container
    1. register component in xml
    2. add component annotation with bean Id in java class
    3. retrieve bean from container
    
- Component default id ((className)TennisCoach -> (id)tennisCoach)

- Inject dependency with autowiring
    1. spring can use auto wiring
    2. spring will look for a class that matches the property
    3. spring will inject automatically

- Spring injection types
    1. constructor injection
    2. setter injection
    3. field injection
    
- Spring Qualifier
    Need to use when there are several implementations of a dependency
    
- 3 ways of configuring spring container
    1. full xml config
    2. xml component scan
    3. java configuration class (no xml)

# Spring MVC
Web browser -> Front controller(dispatcherServlet) -> Controller -> View template 

Model objects : contain data
 - database,web service
 - place your data in the model
 - put anything (strings, objects, info from db)
 - JSP can access data from the modal
 
View templates : Jsp page
 - most common is JSP + JSTL
 - display data

Controller classes : business logic
 - handle request
 - store/retrieve data
 - place data in model
 
 - Controller Request Mapping is relative to method mapping
 
# Spring MVC form tags and data binding
form:form, input, textarea, checkbox, radiobutton, select ...
form:option - value(code) label(display)

# Object To Relational Mapping (ORM)
 - can be possible using by Hibernate (by Java annotation or XML)
 - Java class uses camel case and data table uses _(underscore)
 - minimize the code JDBC (manually set value and sequal query statement)
 - Hibernate is on top of JDBC for communicating with the DB

Entity class : Java class that is mapped to a DB table
Java Annotation - Map class to DB table and Map fields to DB col

##### Hibernate
SessionFactory : read the hibernate config file, create session obj, heavy-weight object, only create once in your app
Session : wraps a JDBC connection, main obj used to save/retrieve obj, short-lived object, retrieved from sessionFactory
Custom generation strategy can be made thru IndentifierGenerator

Retriving a obj from Hibernate needs ID or can be queryed

##### Hibernate Advaned Mapping
OneToOne, OneToMany, ManyToOne, ManyToMany
Cascade is used for associating objects; if objects with PK is deleted, others that has an identical value of FK will be deleted as well
Bi-directional / Uni-directional 

Fetch type: eager vs lazy (retrieve everything vs retrieve on request) 
Eager loading will load all dependent entties - load instructor and all of their courses at once 
If we are searching for a course by keyword, it will load eveyrthing
- ** only laod data when absoultely needed; prefer lazy loading over eager loading **
Lazy loading will load the main entity on demand
- In master view, use lazy loading
- In detail view, retrieve entity and detail entity
