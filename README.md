# Tasks for Java Core course attendee

# Table of Contents

* [How to use this repository](#how-to-use-this-repository)
* [Large cross-topic project](#large-cross-topic-project)
* [Contribution](#contribution)
* [How to check tasks automatically](#how-to-check-tasks-automatically)

# How to use this repository

It's recommended creating a fork of this repository to work on tasks independently. In this case you'll have your own
copy of the repository and all your implementations will stay in your own repository. Of course, this approach
has both benefits and drawbacks:

* Benefit - nobody sees your code except yourself.
* Drawback - nobody sees your code expect yourself.

## How to make a fork of this repository

To create a fork of this repository press a `Fork` button on the top right of this page. GitHub will ask you about
the location of a newly created repository and next you'll be able to clone the repository to your local machine:

```shell script
$ git clone https://github.com/your-account-name/epam-java-cources
``` 

As a result, you'll have a folder called `epam-java-courses` locally. 

## How to get updates of a remote repository

When the fork is created it'll not receive updates automatically, it's necessary making some manual configuration 
for your local repository - you need add a new remote to your local repository. To do it, execute the following
command:

```shell script
$ git remote add -t master epam http://github.com/aabarmin/epam-java-cources/
```

This command will associate your local repository with one additional remote repository - mine repository. In means
that you can send and receive updates from both remote locations - from mine and from your. 

The following command will show what remotes are associated with your local repository:

```shell script
$ git remote show

epam
origin
```  

`origin` is a default name for your remote (`https://github.com/your-account-name/epam-java-cources`), the `epam` 
remote is an association with my remote repository (`https://github.com/aabarmin/epam-java-cources`).

The next step is to create a branch that will get updates from my repository. The following command will create
such kind of branch:

```shell script
$ git checkout -b epam_master --track epam/master
```

This command will create a new branch called `epam_master` that receives updates from my repository. You can see the
list of all your branches by executing the following command:

```shell script
$ git branch -a

epam_master
master
```

When you would like to get updates, you need to pull updates from my repository:

```shell script
$ git checkout epam_master
$ git pull
```

And next merge my changes to your `master` branch:

```shell script
$ git checkout master
$ git pull
$ git merge epam_master
```

As a result, your `master` branch will receive updates and new tasks if they're present. 

## What is the task

Any task in this repository consists of three parts:
1. Description.
2. An interface for the implementation. 
3. Tests for the task. 

The first part, the description is in JavaDoc of the interface, but anyway it's important to mention it here. The second
part is the interface that declares a contract between a task and the solution. All the interfaces are in the 
`src/main/java` folder and look like this:

```java
/**
 * Calculator.
 * <p>
 *     Implementing ordinary calculator which checks input data.
 * </p>
 */
public interface Task001 {
    /**
     * Execute addition operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of addition operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    double addition(String firstNumber, String secondNumber);
}
``` 

The most important part of the task is a collection of tests that checks your implementation. Tests are stored in the
`src/test/java` folder and has a name like the task name plus `Test` like `Task001Test`. 

Tests are ordinary JUnit tests:

```java
public class Task001Test {
    public static final double DELTA = 0.0000001;

    private Task001 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void additionNullBothArguments() throws Exception {
        instance.addition(null, null);
    }
}
```

## How to solve a task

First of all, it's better working on the separate task in its own branch. To create a separate branch, execute
the following command:

```shell script
$ git checkout master
$ git checkout -b <task-number>
```

In order to solve the task, it's necessary writing an implementation class that is in the same package as the interface
and has a name with `Impl` at the end. This implementation should implement the interface of the task. 

```java
public class Task001Impl implements Task001 {
  @Override
  double addition(String firstNumber, String secondNumber) {
    // TODO, your implementation goes here
  }
}
```

When all the tests are passed, don't forget to create a commit and push your changes to the remote repository:

```shell script
$ git commit
$ git push --set-upstream <task-number>
```

The last one step is to go to the GitHub page of your repository and create a merge request from your task branch
to the master branch of your repository. It'll allow you to send your code for review to your colleagues or friends 
on the one hand and on the other hand you'll be able to take one more look into your code later. When the code is
completed, you'll merge the task branch to the `master` branch. 

Updates from your remote `master` branch can be received using the following command:

```shell script
$ git checkout master
$ git pull
```

Git looks quite complicated but the following resources will help you be familiar with it shortly:
* [ProGit](https://git-scm.com/book/en/v2)
* [Git Cheat Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)

## How to check all the tasks at once

Of course, you can run tests from your favourite IDE but it's also possible checking all of them at once using Gradle
and the following command:

```shell script
$ ./gradlew test
```

# Large cross-topic project

You also could implement project in accordance with the following [requirements](https://docs.google.com/document/d/1JLeqArnQ5cfkPF1jbj4Wd-mqrTnj-0OVE8v9bJ0u15s/edit?usp=sharing).

# Contribution

If you see you can make this repository better - don't hesitate to contribute. Any kind of contributions are desired:

* Bug reports
* Bug fixes
* New tasks
* New tests

## How to raise a bug report

If you see an error, don't hesitate to raise a bug report just by clicking direct 
[New issue](https://github.com/aabarmin/epam-java-cources/issues/new) link or using the 
[Issues](https://github.com/aabarmin/epam-java-cources/issues) link on the top of the page and next by clicking the
[New issue](https://github.com/aabarmin/epam-java-cources/issues/new) button on the top right. 

Your contribution is very appreciated. 

## How to add a new task or test

In order to add a new task or test you need to create a fork of this repository using 
[How to use this repository](#how-to-use-this-repository) guide and create a branch from the `epam_master` branch. 

```shell script
$ git checkout epam_master
$ git pull
$ git checkout -b <new-task-branch>
```

When the branch is created, write your code in the branch and then commit and push:

```shell script
$ git commit
$ git push --set-upstream <new-task-branch>
```

And the last one step is to create a pull request into the `master` branch of my repository. 

# How to check tasks automatically

## Jenkins in Docker

There is an automated way to check all the tasks at once and build a meaningful report - run a
series of Jenkins jobs and get a CSV file. 

To run a Jenkins instance, it's recommended using a Docker container, a special Docker image with
all the necessary scripts a prepared in the `/src/main/docker/jenkins/Dockerfile`. To start a Jenkins
instance execute the following command:

```shell script
$ cd ./src/main/docker/jenkins
$ docker-compose up -d
``` 

As a result, a docker stack with one single instance will be started and Jenkins will be available
using the following URL: `http://localhost:8080`.

## Configuring Jenkins

It's recommended installing the following plugins:

* AdoptOpenJDK installer
* Config File Provider Plugin

## Jenkins jobs

The next step is to create two following jobs:

| Jobs name    | Job pipeline file                            |
|--------------|----------------------------------------------|
| BUILD_REPORT | `/src/main/jenkins/BUILD_REPORT/Jenkinsfile` |
| BUILD_SINGLE | `/src/main/jenkins/BUILD_SINGLE/Jenkinsfile` |

## Jobs configuration files

Jenkins jobs require a configuration file called `STUDENT_REPOS`. This file should be created
using the Config File Provider plugin. The file should contain a list of Git repos to clone
and then build. 

## Jenkins tools

It's necessary having a tool of type JDK with name `JDK_11`. I've used AdoptOpenJDK plugin to install
the necessary JDK version. 
