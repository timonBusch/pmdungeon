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

### Ant
- OS-dependent prerequisites:
  - See [here](https://ant.apache.org/manual/install.html)
- General prerequisites:
  - Adapt settings in `build.xml` (property `main-class`) to reflect your main class
  - Run `ant init-ivy` once in your project folder to download and install ivy
- Use `ant compile-run` to compile your sources and to start the game

### Maven
- OS-dependent prerequisites:
  - See [here](https://maven.apache.org/install.html)
- Run `mvn clean compile` in your project folder to clean old builds and to compile your sources 
- Use `mvn exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"` to start the game (replace `PACKAGE.MAIN` with your main class)
- You can optionally call all goals at once: `mvn clean compile exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"`

### Gradle
- General prerequisites:
  - You don't need to install Gradle because you can use the Gradle wrapper provided in this project/repo
  - Adapt settings in `build.gradle` (property `mainClassName`) to reflect your main class
- Use `gradlew run` to compile your sources and to start the game

### Eclipse integration
- Maven project integration:
  - Open Eclipse and your workspace
  - Right click in project explorer and choose `Import...`
  - Choose `Existing Maven Projects`
  - Choose the root directory and pick the `pom.xml`
  - Click `Finish`
- Gradle project integration:
  - Open Eclipse and your workspace
  - Right click in project explorer and choose `Import...`
  - Choose `Existing Gradle Project`
  - Skip Welcome
  - Choose the project root directory
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
