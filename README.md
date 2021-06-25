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
- Download and unzip Ant, set the Windows system path variables for Ant (see [here](https://ant.apache.org/manual/install.html), set at least `ANT_HOME` and `%ANT_HOME%\bin`)
- Add or modify your main class in the `build.xml` file at line 17
- Run `ant init-ivy` once in your project folder, to initialize ivy
- Use `ant compile-run` to compile your sources and to start the game

### Maven
- Download and unzip Maven, set the Windows system path variables for Maven (see [here](https://maven.apache.org/install.html), set at least `MAVEN_HOME` and `%MAVEN_HOME%\bin`)
- Run `mvn clean compile` in your project folder, to compile your sources
- Use `mvn exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"` to start the game
- You can optionally call all goals at once: `mvn clean compile exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"`

### Gradle
- You don't need to install Gradle because you can use the delivered Gradle wrapper
- Add or modify your main class in the `build.gradle` file at line 9
- Run `gradlew build` in your project folder, to compile your sources
- Use `gradlew run` to start the game

### Eclipse integration
- Open Eclipse/your workspace
- Right click in project explorer and choose `Import...`
- Choose `Existing Maven Projects`
- Choose the root directory and pick the `pom.xml`
- Click `Finish`

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
