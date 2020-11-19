# XSLT

This directory is part of the code, but not part of the compilable project.
It generates java-code from the openEhr html-specifications, which you can find:
[OpenEhr-specifications](https://specifications.openehr.org/)

These Openehr specifications are as structure, the bease of the semantic database.

You find in this directory the xslt-file, and a few html-files which are used for this purpose.
Beforte you can start generating code (on new downloaded specifications) you may need to repair the html-files.
Many tags are not closed wel, the img-tags are not, the col-tags are not, the meta-tags are not, the link-tags are not maybe and some more.

You will run against them while executing the xslt.

And you will find some errors spread around, the script is not perfectly handling all situations.
But still it does 99% good, and it is very usable.

The generated code is not part of github-repository. 
When you run the xslt, it will create a directory called generated_source

It generates per class an interface in which the pojo-, and other function-declarations, and also the constants.
In the interfaces the multiple inheritance is arranged. The rest is in classes.

It also creates per class a builder-pattern for convenience, and it adds utility-functions for container-types.

