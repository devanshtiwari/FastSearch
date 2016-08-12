# FastSearch Java Lib

Easy and simple Searching Directories and Sub directories for a file or folder name multiple times.

The utility contains a class FastSearch. Object of this class can be used for Searching names in Directories and subdirectories. 
At times, there are specific application which requires repetitve search of files, and this can be very time taking if the directory contain many subdirectories and files.
  
This utility will help in such issues in the following way:
  
* **init(String)**

Parameter String will take Directory (Main) and index all the subfolders and files. This will take some time depending upon the number of files. After successfuly execution of init function, one can search for files.

* **Fsearch(String,boolean)** or **Fsearch(String)**
  
Parameter String takes the Full File or folder name to search. The boolean values indicates whether the file is directory or not. If is it directory one is searching for it will be true. If no boolean parameter is passed then it is by default considered false.
  
After the usage of init function, there's no need to index it once again. Searching files again and again in the same directory will be fast and easy just by using Fsearch. 

**Example Code App.java**
  
App.java is example code which can show the functional utility. Make sure Jar file is included in your external library.
