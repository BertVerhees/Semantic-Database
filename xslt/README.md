# XSLT

This directory is part of the code, but not part of the compilable project.
It generates java-code from the openEhr html-specifications, which you can find:
[OpenEhr-specifications](https://specifications.openehr.org/)

You find in this directory the xslt-file, and a few html-files which are used for this purpose.
Beforte you can start generating code (on new downloaded specifications) you may nmeed to repair the html-files.
Many tags are not closed wel, the img-tags are not, the col-tags are not, and some more.

The generated code is not part of github-repository. 
When you run the xslt, it will create a directory called generated_source

It generates per class an interface in which the pojo-, and other function-declarations, and also the constants.
In the interfaces the inheritance is arranged.

It generates per interface an implementation class in which the function bodies are partly worked out.
It contains exceptions for cardinality-errors.
And in the implementations are the private-fields for which declaration-pojo's are in the interfaces
It will also contain a builder pattern.

Please Note:
The generated code is not fit to use.

It is just helping generating the code, and taking away the necessity to write lot of boilerplate.
