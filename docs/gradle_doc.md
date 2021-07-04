title: "PM-Dungeon: Gradle"
author: "Timon Buschendorf"
lang: en-EN
...

## Gradle Documentation

Gradle is an open-source build automation tool which runs on the JVM. The
Java Development Kit (JDK) needs to be installed to use it for development
purposes. The build scripts are written in Groovy or Kotlin.\
*[Official Gradle Documentation](https://docs.gradle.org/current/userguide/userguide.html)*

Using an existing project there is no need to install anything because
Gradle uses a wrapper, so the project can be build via `gradlew` or `gradlew.bat`,
which are included in the repository.
It can be very useful to determine the project structure before working one
the project, this can be done using the command `gradlew projects`. Examining
all available tasks `gradlew tasks` or `gradlew <path_to_project>:tasks` will
give a complete list of all tasks. Run `gradlew <task>` to use a task.

The PM-Dungeon project has the following structure:
```groovy
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── build.gradle
└── src
    └── de
        └── pmdungeon
            ├── desktop
            ├── dungeonCreator
            ├── game
            ├── graphic
            ├── interfaces
            └── tools
```

## Plugins

To be able to compile a Java project the plugin `java` is
added to the project. The `java-library` plugin extends the `java`
plugin. To create an executable application from our source files
the `application` plugin has also been included.
Plugins can also be added like this:
```groovy
plugins {
   id 'java'
}
```

# Preconditions (Configuring Plugins)

The `sourceCompatibility` is a value that is used by the
`java` plugin to define the `java` version for the project.
A `sourceSet` represents a logical group of `java` source and
resource files. To be able to start the application we must
define the entry point with the key word `mainClassName`.

## Extra Properties

Via the `ext` object multiple properties can be added at once,
such as version numbers for dependencies or the name of the application.

## Dependencies

The `dependencies` task adds additional APIs that are
needed in the project. The ID which is written after the key
word `api` can be found in public-available repositories like
`mavenCentral()`.

## Repositories

The `repositories` object declares which public-available
repositories should be used to resolve the dependencies.

# Additional tasks

The `jar` task is implemented to create a `java` archive, so it can
be used as API in other projects.
