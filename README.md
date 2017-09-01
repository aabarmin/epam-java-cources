Tasks for Java Core course attendee
=

**How to use it?**

- Fork this repository by clicking "Fork" button on the top of this page.
- Clone this repository to your local environment
- Connect your branch to my repository by executing the following command:
 
`git remote add -t master epam http://github.com/aabarmin/epam-java-cources/`

**Task execution**

Before you started, pull changes from my repository

`git pull epam master`

If your repository is behind the remote master, you should rebase changes from my repository to your master. 
You can do it by executing the following command:

`git rebase epam/master master`

Send changes from your local repository to remote:

`git push origin master`

The following step is to switch to new branch:

`git checkout -b <BRANCH_NAME>`

Open your favourite IDE and write some code and don't forget to commit when you finished.

```
git add .
git commit
git push origin <BRANCH_NAME>
```

When your work with task is completely done, you can create pull request on GitHub to merge changes from your
task branch to master. It's better to attach a label `Excercise` to your pull request. 

**How to contribute**

You can contribute by writing and fixing tests. Create tests and send me a pull request. 