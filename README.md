# CSRF Vulnerable Application

This project is a CSRF (Cross-Site Request Forgery) vulnerable web application, designed to help you understand, practice, and perform CSRF attacks. By using this application, you will learn how to exploit CSRF vulnerabilities and test various mitigation techniques.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Mitigation Techniques](#mitigation-techniques)
    - [SameSite Cookie Attribute for Session ID Cookies](#samesite-cookie-attribute-for-session-id-cookies)
    - [Synchronizer Token Pattern (CSRF Token)](#synchronizer-token-pattern-csrf-token)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Cross-Site Request Forgery (CSRF) is a type of security vulnerability that allows attackers to perform unwanted actions on a web application in the context of an authenticated user. This application intentionally contains CSRF vulnerabilities to help you learn how to exploit and mitigate them in a safe and controlled environment.

## Getting Started

To get started, follow these steps:

- Use docker container to run the application:

    ```bash
    docker run -p 8080:8080 -t skryvets/csrf-vulnerable-spring-application
    ```
   
- Alternatively clone this repository and run in your IDE:

    ```bash
    git clone https://github.com/skryvets/csrf-vulnerable-spring-application.git
    ```

## Mitigation Techniques

### SameSite Cookie Attribute for Session ID Cookies
- To enable SameSite Cookie Attribute for Session ID Cookies, follow instructions of the comments that starts with --1-- (you can do a global search in your IDE for --1--)

### Synchronizer Token Pattern (CSRF Token)
- Undo Everything for step above
- To implement Synchronizer Token Pattern, follow instructions of the comments that starts with --2-- (you can do a global search in your IDE for --2--)

## Contributing
If you'd like to contribute to this project, open issue/submit PR.

## License
This project is licensed under the MIT License.


