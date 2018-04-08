## junit-runif

[![Build Status](https://travis-ci.org/mjeanroy/junit-runif.svg?branch=master)](https://travis-ci.org/mjeanroy/junit-runif)

### Introduction

Run your test conditionally!

### Why?

On some project, I need to run the entire test suite at least on the JDK 7 and JDK 8.
But if some dependencies require JDK 8, you need to ignore some unit tests conditionally, that is why I wrote this library.

### Installation

**Maven**

```xml
<dependency>
  <groupId>com.github.mjeanroy</groupId>
  <artifactId>junit-runif</artifactId>
  <version>0.1.0</version>
  <scope>test</scope>
</dependency>
```

### How to use

Run your test with `RunIfRunner` and add `RunIf` annotation where you need!

For example, here a unit test that will run only on Windows:

```java
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.mjeanroy.junit4.runif.RunIf;
import com.github.mjeanroy.junit4.runif.RunIfRunner;

@RunWith(RunIfRunner.class)
public class MyUnitTest {
    @Test
    @RunIf(WindowdCondition.class)
    public void it_should_run_on_windows_only() {
        // Do your test
    }
}
```

Here is the condition implementation:

```java
import com.github.mjeanroy.junit4.runif.RunIfCondition;

public class WindowsCondition implements RunIfCondition {
    @Override
    public boolean apply() {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }
}
```

### Why a runner and not a junit Rule?

This library use a custom JUnit rule since using a Runner will allow you to not load a class if it is ignored.
This is especially important if you want to run unit test that use JDK 8 API but you execute your build with a JDK7.

For example:

```java
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.mjeanroy.junit4.runif.RunIf;
import com.github.mjeanroy.junit4.runif.RunIfRunner;
import com.github.mjeanroy.junit4.runif.conditions.AtLeastJava8Condition;

@RunWith(RunIfRunner.class)
@RunIf(AtLeastJava8Condition.class)
public class MyUnitTest {
    @Test
    public void it_should_run_on_windows_only() {
        // Do your test with JDK 8 API
    }
}
```

It is really **important** to add the `RunIf` annotation on the class and not on the method, otherwise the class will have to be loaded and your test will fail on JDK 7.

### Available Conditions

Out of the box, following conditions are available:

- `Java7Condition`: ensure that the (runtime) java version is exactly java 7.
- `Java8Condition`: ensure that the (runtime) java version is exactly java 8.
- `AtLeastJava7Condition`: ensure that the (runtime) java version is greater than or equal to java 7.
- `AtLeastJava8Condition`: ensure that the (runtime) java version is greater than or equal to java 8.

### License

MIT License.

### Contributing

If you found a bug or you thing something is missing, feel free to contribute and submit an issue or a pull request.
