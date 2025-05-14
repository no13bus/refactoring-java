# Movie Rental System Refactoring Project

This is a Java implementation of a movie rental system for generating customer rental statements. This project demonstrates how to refactor existing code to improve code quality and maintainability.

## Refactoring Report

### Preliminary Work

1. **Maven Project Structure Conversion**

   - Converted the project to Maven structure for automated dependency management
   - Established foundation for CI/CD pipelines and Docker deployment
   - Standardized project structure for better developer understanding and collaboration

2. **Continuous Integration Setup**

   - Configured CI workflow on GitHub to ensure each commit passes tests
   - Set up failure notification mechanisms for quick issue discovery
   - Created a safety net for the refactoring process to prevent regression issues

3. **Test Coverage Enhancement**
   - Added comprehensive test cases, including basic functionality and boundary conditions
   - Ensured existing functionality has clear validation criteria
   - Used tests to confirm actual system behavior and guide refactoring decisions

### Refactoring Implementation Process

1. **Domain Model Clarification**

   - Identified relationships between core models: Customer, MovieRental, and Movie
   - Defined clear responsibility boundaries for each class according to the Single Responsibility Principle
   - Redesigned data flow paths to avoid unnecessary data transformations

2. **Magic Constant Elimination**

   - Replaced string constants with strongly-typed MovieType enumeration to enhance type safety
   - Improved code readability and maintainability while reducing potential errors
   - Provided better IDE support for code completion and checking

3. **Evolution of Calculation Logic Refactoring**

   - Initial approach: Moved calculation logic to MovieRental class since calculations only depend on movie type and rental days
   - Further consideration: As movie types and calculation rules increase, MovieRental would take on too many responsibilities
   - Issue insight: This would bloat the MovieRental data class, making unit testing difficult
   - Final decision: Applied Strategy pattern to separate calculation logic, maintaining the purity of data models

4. **Strategy Pattern Implementation**

   - Abstracted pricing and points calculation logic for different movie types into strategy interfaces
   - Implemented a strategy factory to manage different calculation strategy implementations
   - Made the system more easily extensible for new movie types without modifying core business logic

5. **Core Business Logic Optimization**

   - Refactored the statement method in RentalInfo class to clearly separate data retrieval and presentation logic
   - Removed unnecessary data assembly code, directly obtaining required information from the Customer model
   - Optimized output format to improve statement readability and professionalism

6. **Project Layer Optimization**
   - Naturally formed clearer project layering through the application of the Strategy pattern
   - Identified Customer, Movie, and MovieRental as pure data models, placing them in the model package
   - Reorganized code into three layers: model, service, and strategy based on responsibilities
   - Established clear dependency relationships and call directions

## Project Structure

```
src/
├── main/java/movierental/
│   ├── model/             # Data model classes
│   │   ├── Customer.java
│   │   ├── Movie.java
│   │   ├── MovieRental.java
│   │   └── MovieType.java
│   ├── service/           # Service layer
│   │   └── RentalInfo.java
│   └── strategy/          # Strategy pattern implementation
│       ├── RentalStrategy.java
│       ├── RegularMovieStrategy.java
│       ├── NewReleaseMovieStrategy.java
│       ├── ChildrenMovieStrategy.java
│       └── RentalStrategyFactory.java
└── test/java/movierental/  # Test classes
    └── RentalInfoTest.java
```

## How to Run

### Prerequisites

- Java 21 or higher
- Maven 3.6.0 or higher

### Running Tests

```bash
mvn test
```

## Tech Stack

- Java 21
- JUnit 5
- Maven
- GitHub Actions (CI/CD)
