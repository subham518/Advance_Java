# Java Servlet + Tomcat Setup — Problems and Solutions (Detailed Explanation)

## Overview

This document explains the complete troubleshooting journey of configuring and deploying a Java Servlet application using:

- IntelliJ IDEA Community Edition
- Smart Tomcat plugin
- Apache Tomcat 10.1
- Jakarta Servlet API

It covers the technical problems encountered, their root causes, and how each issue was resolved.

---

# 1. Servlet Not Compiling

## Symptoms

- `HttpServlet` imports not resolving
- Servlet classes not recognized
- External Libraries did not show Servlet API
- Compilation errors

## Root Cause

The Servlet API was not added to the project’s compile-time classpath.

Important concept:

- Tomcat provides Servlet API at runtime.
- IntelliJ requires Servlet API at compile time.

Since Smart Tomcat does not automatically configure dependencies, it had to be added manually.

## Solution

Add the following file manually:

```
apache-tomcat-10.1.52/lib/servlet-api.jar
```

In IntelliJ:

```
Project Structure → Modules → Dependencies → + → JARs or Directories
```

Set dependency scope to:

```
Provided
```

### Why "Provided"?

- Required for compilation.
- Already available in Tomcat at runtime.
- Prevents classloader conflicts.

---

# 2. IOException Compilation Error

## Error

```
unreported exception java.io.IOException; must be caught or declared to be thrown
```

## Root Cause

When overriding `doGet()` or `doPost()`, Java requires the method signature to match the parent class.

`HttpServlet#doGet()` declares:

```
throws ServletException, IOException
```

If not declared, compilation fails.

## Solution

Correct method signature:

```java
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {
```

---

# 3. Incorrect Folder Structure

Incorrect structure at one stage:

```
src
 ├── servlets
 │    ├── TestServlet.java
 │    └── web   ❌
```

## Why This Failed

- `servlets` → Java source files
- `web` → Web resources (HTML/JSP)
- Tomcat serves only from the configured deployment directory

If `form.html` is inside `servlets`, Tomcat does not deploy it.

## Correct Structure

```
src
 ├── servlets
 │     └── TestServlet.java
 └── web
       └── form.html
```

Smart Tomcat configuration:

```
Deployment directory = src/web
```

---

# 4. Using Wrong Server Port (63342)

Accessing:

```
http://localhost:63342/...
```

Port 63342 is IntelliJ’s internal static file server.

It does NOT support:

- Servlets
- JSP
- Tomcat execution

## Solution

Always test using Tomcat port:

```
http://localhost:8080/Training/...
```

---

# 5. Context Path Confusion (Major Issue)

Smart Tomcat configuration:

```
Context path = /Training
```

Servlet mapping:

```java
@WebServlet("/TestServlet")
```

Final URL structure:

```
http://localhost:8080/Training/TestServlet
```

## What Went Wrong

Form originally used:

```html
<form action="/TestServlet" method="post">
```

Leading `/` means:

```
http://localhost:8080/TestServlet
```

This ignores the context path `/Training` → 404 error.

## Final Working Version

```html
<form action="/Training/TestServlet" method="post">
```

Now the request goes to:

```
http://localhost:8080/Training/TestServlet
```

Which matches the deployed servlet.

---

# 6. URL Structure Rule (Very Important)

General pattern:

```
http://localhost:PORT/{context-path}/{servlet-mapping}
```

In this case:

- Context path → `/Training`
- Servlet mapping → `/TestServlet`

Final URL:

```
http://localhost:8080/Training/TestServlet
```

If either part is missing → 404.

---

# Final Working Configuration

## Project Structure

```
Training
 └── src
      ├── servlets
      │     └── TestServlet.java
      └── web
            └── form.html
```

## Smart Tomcat Settings

- Deployment directory: `src/web`
- Context path: `/Training`
- Port: 8080

## Servlet Annotation

```java
@WebServlet("/TestServlet")
```

## HTML Form

```html
<form action="/Training/TestServlet" method="post">
    <input type="submit" value="Send POST">
</form>
```

---

# Core Concepts Learned

- Compile-time vs runtime dependencies
- Jakarta namespace in Tomcat 10 (`jakarta.servlet.*`)
- Proper separation of source code and web resources
- How Smart Tomcat deploys applications
- How context path affects URL mapping
- How servlet container resolves requests
- Why absolute vs relative URLs matter

---

# Conclusion

All problems were caused by:

1. Missing Servlet API dependency
2. Incorrect project structure
3. Using wrong server (port 63342)
4. Context path misunderstanding
5. Incorrect form action URL

After fixing these issues, the servlet application worked correctly.

This setup now represents a properly configured Java web application using:

- IntelliJ Community Edition
- Smart Tomcat
- Tomcat 10
- Jakarta Servlet API  
