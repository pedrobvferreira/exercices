# Exercices
## 1) Remove duplicates
* Given a string S, the task is to remove all the duplicates in the given string
* Sort a single String
---------------
## 2) Smallest positive number
* Given an unsorted array arr[] with both positive and negative elements, the task is to find the smallest positive number missing from the array.
---------------
## 3) BinaryGap
* Find longest sequence of zeros in binary representation of an integer.
--------------
## 4) Lexicografic sort
We have an application that process documents based on a list. Every document in the list can be identified with a space limited string composed by an ID + metadata.  
The next month we are introducing a new type of document that we need to process first. The new ID are defined exclusivetely with numbers whereas the old ones by letters or letters and number.  
New: 123 abc aasd  
Old: abc qwe qqwe  
"123" and "abc" are the document's ids.  
You have been tasked with sorting a list of all identifier. They should be sorted according to the following order  
1.New identifiers should be returned first, sorted by lexicografic sort of the alphabetic metadata.  
2.Only in case of ties, the ID should be used as a backup sort  
3.The old identifiers must all come after in the original order they were given in the input.  
Write a function or method to sort the identifiers according to this system.  

Input:  
documentList: A list of strings representing each document.  

Output:  
Return a list of strings representing the correct prioritization.  

Note:  
Identifiers consist of only lower case English character and numbers.  


Examples:
* Input:
documentList=
[zld 93 12]
[fp alpha xls]
[125 echo doc]
[17g 122252]
[563 alpha omx]
[120 echo doc]

* Output:
[563 alpha omx]
[120 echo doc]
[125 echo doc]
[zld 93 12]
[fp alpha xls]
[17g 122252]
