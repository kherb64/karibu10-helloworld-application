[![Build Status](https://travis-ci.org/mvysny/karibu10-helloworld-application.svg?branch=master)](https://travis-ci.org/mvysny/karibu-helloworld-application)

# Vaadin 10 Karibu-DSL Example App / Archetype

This project can be used as a starting point to create your own Vaadin Flow application. It has the necessary dependencies and files to get you started.
Just clone this repo and start experimenting! Import it to the IDE of your choice as a Gradle project.
                                              
Uses [Karibu-DSL](https://github.com/mvysny/karibu-dsl); for more information about the
Karibu-DSL framework please see https://github.com/mvysny/karibu-dsl .
For more information on Vaadin please see https://vaadin.com/docs/-/part/framework/tutorial.html

# Getting Started

To quickly start the app, make sure that you have Java 8 JDK installed. Then, just type this into your terminal:

```bash
git clone https://github.com/mvysny/karibu10-helloworld-application
cd karibu10-helloworld-application
./gradlew appRun
```

The app will be running on http://localhost:8080/

This is a port of [Skeleton Starter Flow](https://github.com/vaadin/skeleton-starter-flow) to Kotlin+Gradle.

For a Flow application example, please see the Beverage Buddy App Starter for Flow instead, which is the `example-v10`
app of the [Karibu-DSL](https://github.com/mvysny/karibu-dsl) project.

# More Resources

* The DSL technique is used to allow you to nest your components in a structured code. This is provided by the
  Karibu-DSL library; please visit the [Karibu-DSL home page](https://github.com/mvysny/karibu-dsl) for more information.
* The serverless testing is demonstrated in the [MyUITest.kt](src/test/kotlin/org/test/MyUITest.kt) file.
  Please read [Serverless Web Testing](http://mavi.logdown.com/posts/3147601) for more information.
* For more complex example which includes multiple pages, please see the [Karibu-DSL example-v10 app](https://github.com/mvysny/karibu-dsl#quickstart-vaadin-10-flow).
  It is a port of the [Beverage Buddy App Starter](https://github.com/vaadin/beverage-starter-flow) to Kotlin + Karibu DSL.
* For information on how to connect the UI to the database backend please visit [Vaadin-on-Kotlin](http://www.vaadinonkotlin.eu/)
  You can find a complete CRUD example at [Vaadin-on-Kotlin vok-example-flow-sql2o](https://github.com/mvysny/vaadin-on-kotlin#vaadin-10-flow-example-project).
