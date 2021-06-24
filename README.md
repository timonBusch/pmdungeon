title: "PM-Dungeon: Overview"
author: "André Matutat"
lang: en-EN
...

# PM-Dungeon Overview

- Framework for 2D Games in Java
- Based on [libGDX](https://libgdx.com/)
- Uses [Edgar-DotNet](https://github.com/OndrejNepozitek/Edgar-DotNet) (v1.06) levels
- Build for teaching purposes



## Requirements

- JDK 11 or higher
- One of the following build tools:
  - Ant
  - Maven
  - Gradle

## Usage

TODO

### ANT
- Download and unzip Ant, set the Windows system path variables for Ant (see [here](https://ant.apache.org/manual/install.html), set at least `ANT_HOME` and `%ANT_HOME%\bin`),
- add or modify your main class in the `build.xml` file at line 17,
- run `ant init-ivy` once in your project folder, to initialize ivy,
- use `ant compile-run` to compile your sources and to start the game.

### Maven
- Download and unzip Maven, set the Windows system path variables for Maven (see [here](https://maven.apache.org/install.html), set at least `MAVEN_HOME` and `%MAVEN_HOME%\bin`),
- run `mvn clean compile` in your project folder, to compile your sources,
- use `mvn exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"` to start the game,
- you can optionally call all goals at once: `mvn clean compile exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"`.

### Gradle
- Use the delivered Gradle wrapper,
- add or modify your main class in the `build.gradle` file at line 9,
- run `gradlew build` in your project folder, to compile your sources,
- use `gradlew run` to start the game.

### Eclipse integration
- Open Eclipse/your workspace,
- right click in project explorer and choose `Import...`,
- choose `Existing Maven Projects`,
- choose the root directory and pick the `pom.xml`,
- click `Finish`.

### IntelliJ IDEA integration
- TODO

This manual helps you to set up a basic implementation using this project.
- [German Manual](./docs/manual_DE.md)
- [English Manual](./docs/manual_EN.md)


## Structure and Framework

If you need more information about the structure of this framework see the [Framework Guide](./docs/framework_EN.md)

## FAQ
*Q: Can I use this project in my lessons*?`
*A: Yes. This project is build for teaching purposes.*

## Contributors

<a href="https://github.com/AMatutat/pmdungeon/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=AMatutat/pmdungeon" />
</a> <br>
Made with [contributors-img](https://contrib.rocks).


TODO: How to contribute


## License

All files are published under the MIT license by their respective authors. See [LICENSE](./LICENSE.md) for details.
