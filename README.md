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
- You have to add or modify your main class in the `build.xml` file at line 17. Run `ant init-ivy` once in your project folder, to initialize ivy, then use `ant compile-run` to compile your sources and to start the game.

### Maven
- First run `mvn clean compile` in your project folder, then use `mvn exec:java -Dexec.mainClass="de.pmdungeon.PACKAGE.MAIN"` to start the game.

### Gradle
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
