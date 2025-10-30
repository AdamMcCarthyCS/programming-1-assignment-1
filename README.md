
Name :              Adam McCarthy
Student Number:     XXXXXXXX (redacted for Github version)

Brief description of piece (1 or 2 sentences MAX):
===================================================
This program provides the user with calculations of the monthly cost of buying a car through a
hire-purchase agreement or a personal contract plan. It also has the functionality to 
calculate a projected weekly fuel estimate and provides a car purchase recommendation based 
on the user's lifestyle.



Instructions:
=============

How to run the program and state how to use any features of it

To run the program:
1) Open the folder AdamMcCarthy in intelliJ
2) Open the Driver.java file in the editor
3) Navigate to the Run menu of the menu bar
4) Select Run "Driver.java"

To navigate the main menu:
1) Select the menu items by entering the integer displayed to their left (i.e for "Calculate HP" 
enter 1 and press return.)
2) Follow on screen prompts for further values to be entered. Note that all data requested from the
user by the program is numerical data, except in the case of option 5 "Recommend Car Type", where 
the user is asked to enter a lifestyle choice as a text string.


Known bugs/problems:
====================
The main bug/problem of the program is in terms of validation of numerical input. I have not
added functionality for exiting calculations when users enter negative values. For instance if the
user said the cars value was -€30000 or the term was -24 months. I had the idea of storing the 
values in an array and having an extra method for looping over these values and returning a true/
false depending on whether the input the user gave was valid or not. The reason i did not do this
was I felt it would make the program workings more obscure and coupled for others to read and 
understand. There is also an issue if the user is to enter text when numerical values are expected.
I would have solved this by using the instanceOf method to check the user has entered an Integer or Double
but, we have not yet covered this in the course, and I was trying to stick to using what is expected.
    I did provide some functionality to validate that the user made the correct choices in 
the main looping menu, and also entering the string in the car recommendation method. This was 
to cover the inevitable typos that happen when people interact with a UI.

Another problem of the program is that I have used the format method of the string class to round 
the numerical values within the string returned from the car recommendation method of the 
CarPurchaserHelper class. I had to round the same calculations in the driver class where the user 
chooses other menu options such as Calclate HP, and Calculate PCP. This was to ensure output would 
match in how it was formated everywhere in the program. This feels like violating 
DRY (Don't Repeat Yourself). I could have gotten around this by using this rounding method I found 
at (1) to round the outputs of the methods to two decimal places: 
    value rounded to 2 dp = Math.round(a * 100.0) / 100.0;
Math.round rounds a double to the nearest long value (2) so by multiplying by 100 you move the decimal
place two digits to the right (e.g 23.445 -> 2344.5) then round it (2345) the divide by 100 to get
(23.45). Casting this back to a double is fine when the long value is not very large.
    In the end I chose to use the String method as it comes from one of the few Classes that has
been covered in the course to date, and it also forced me to learn how to format numbers in text 
with that ugly C % sign syntax. Aside: (Oh, how I miss you Python f-strings!)

(1) https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
(2) https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html - The static round method with a double parameter


Sources used/refernced:
=======================

Failure to fully  reference such material used may result in plagiarism process being brought into play. 

