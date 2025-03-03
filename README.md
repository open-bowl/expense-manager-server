# Expense Manager Server

**Expense Manager Server** is a backend application designed to manage and track expenses efficiently. This server-side application provides APIs to handle various expense-related operations, ensuring seamless integration with client-side applications.

## Features

- **Expense Tracking**: Record and manage expenses with details such as amount, category, and date.
- **Category Management**: Organize expenses into categories for better analysis.
- **Reporting**: Generate reports to analyze spending patterns over time.

## Technologies Used

- **Java**: Core programming language.
- **Gradle**: Build automation tool.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK installed. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Gradle**: Used for building the project. [Installation Guide](https://gradle.org/install/).

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/open-bowl/expense-manager-server.git
   cd expense-manager-server
   ```

2. **Build the Project**:

   Use the Gradle wrapper included in the repository to build the project:

   ```bash
   ./gradlew build
   ```

   This command will compile the project and run any tests.

3. **Run the Application**:

   After a successful build, you can run the application using:

   ```bash
   ./gradlew bootRun
   ```

   The server will start, and you can access the APIs at `http://localhost:8080/`.

## Usage

Once the server is running, you can interact with the APIs using tools like [Postman](https://www.postman.com/) or [curl](https://curl.se/). Below are some example endpoints:

- **Add an Expense**:

  ```bash
  POST /api/expenses
  {
    "amount": 50.0,
    "category": "Food",
    "date": "2025-03-03"
  }
  ```

- **Get All Expenses**:

  ```bash
  GET /api/expenses
  ```

- **Get Expenses by Category**:

  ```bash
  GET /api/expenses?category=Food
  ```

- **Delete an Expense**:

  ```bash
  DELETE /api/expenses/{id}
  ```

  *Note: Replace `{id}` with the actual expense ID.*

## Contributing

Contributions are welcome! Please follow these steps:

1. **Fork the Repository**: Click on the 'Fork' button at the top right corner of this page.

2. **Create a New Branch**:

   ```bash
   git checkout -b feature/YourFeatureName
   ```

3. **Commit Your Changes**:

   ```bash
   git commit -m 'Add some feature'
   ```

4. **Push to the Branch**:

   ```bash
   git push origin feature/YourFeatureName
   ```

5. **Create a Pull Request**: Navigate to your forked repository and click on 'New Pull Request'.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the contributors:
  - [DharanBro (Giridharan Rengarajan)](https://github.com/DharanBro)
  - [manikandanvengatesan (Manikandan Venkatesan)](https://github.com/manikandanvengatesan)
  - [pragathi-mani](https://github.com/pragathi-mani)

- Inspired by various open-source expense management systems.

