# CleanMovie
CleanMovie is a functional Android app built entirely with Kotlin and Jetpack Compose. It
follows Android design and development best practices.
### Libraries and Tools

- Jetpack Compose
- Hilt
- Retrofit (with a deserializer for another API)
- Coroutines
- Coil
- Detekt
- GitHub Actions
- Material 3
- Compose Navigation
  
## Architecture
Uses concepts of the notorious Uncle Bob's architecture called [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).</br>

* Better separation of concerns. Each module has a clear API., Feature related classes life in different modules and can't be referenced without explicit module dependency.
* Features can be developed in parallel eg. by different teams
* Each feature can be developed in isolation, independently from other features
* faster compile time
<img src="art/app_architecture.png">
