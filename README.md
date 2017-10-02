Tasks for Java Core course attendee
=

**How to use it?**

- Fork this repository by clicking "Fork" button on the top of this page.
- Clone this repository to your local environment
- Connect your branch to my repository by executing the following command:
 
```
git remote add -t master epam http://github.com/aabarmin/epam-java-cources/
```

You can watch list of remotes using `git remote show` command. The result should be like the following:

```
# git remote show

epam
origin
```

**Task execution**

Before you started, pull changes from my repository

```
git pull epam master
```

If your repository is behind the remote master, you should rebase changes from my repository to your master. 
You can do it by executing the following command:

```
git rebase epam/master master
```

Send changes from your local repository to remote:

```
git push origin master
```

The following step is to switch to your private branch:

```
git checkout <PRIVATE_BRANCH_NAME>
```

After it you can create branch for task execution:

```
git checkout -b <TASK_BRANCH>
```

Open your favourite IDE and write some code and don't forget to commit when you finished.

```
git add .
git commit
```

When your work with task is completely done, you should merge changes from task branch to your private branch:

```
git checkout <PRIVATE_BRANCH_NAME>
git rebase <TASK_BRANCH>
```

Now you can push your changes to your own remote repository:
 
```
git push origin <PRIVATE_BRANCH_NAME>
```

When your changes are pushed to your own fork, you should create a pull-request. It's better to add `Excercise` label
to your pull request.

**How to contribute**

You can contribute by writing and fixing tests. Create tests and send me a pull request with `Tests` label. 

Large cross-topic project
=

You also could implement project in accordance with the following [requirements](https://docs.google.com/document/d/1JLeqArnQ5cfkPF1jbj4Wd-mqrTnj-0OVE8v9bJ0u15s/edit?usp=sharing).