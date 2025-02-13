# DataFaker Handlebars Helper

A Java library that provides a Handlebars helper for generating fake data using DataFaker. This helper allows you to easily integrate fake data generation into your Handlebars templates.

## Features

- Seamless integration with Handlebars templates
- Access to all DataFaker providers and methods
- Simple syntax for generating fake data
- Flexible configuration options

## Installation

### Using Maven

First, clone the repository and install to your local Maven repository:
```bash
mvn clean install
```

Then add the following dependency to your project's `pom.xml`:
```xml
<dependency>
    <groupId>com.cariad</groupId>
    <artifactId>datafaker-handlebar-helper</artifactId>
    <version>${version}</version>
</dependency>
```

## Usage

### Basic Setup

```java
// Create a new Handlebars instance
Handlebars handlebars = new Handlebars();

// Register the DataFaker helper
Helper<String> dataFakerHelper = new FakerTemplateHelper();
handlebars.registerHelper("faker", dataFakerHelper);
```

### Template Examples

Generate fake names:
```handlebars
{{faker 'name' 'firstName'}}     // Generates a random first name
{{faker 'name' 'lastName'}}      // Generates a random last name
```

Generate internet-related data:
```handlebars
{{faker 'internet' 'emailAddress'}}  // Generates a random email address
```

### Complete Example

```java
Handlebars handlebars = new Handlebars();
handlebars.registerHelper("faker", new FakerTemplateHelper());

String templateString = "Hello {{faker 'name' 'firstName'}}!";
Template template = handlebars.compileInline(templateString);
String result = template.apply(null);
// Output: "Hello John!" (with random name)
```

## Error Handling

The helper will throw a `HandlebarsException` if:
- An invalid provider name is specified
- An invalid method name is specified
- Any other runtime error occurs during fake data generation

## Requirements

- Java 17 or higher
- Dependencies:
    - DataFaker 2.4.2
    - Handlebars 4.4.0

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

TODO

## Dependencies

- [DataFaker](https://github.com/datafaker-net/datafaker)
- [Handlebars.java](https://github.com/jknack/handlebars.java)