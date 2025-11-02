
Name :              Adam McCarthy
Student Number:     XXXXXXXX (redacted for GitHub version)

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
1) Select the menu items by entering the integer displayed to their left (i.e. for "Calculate HP" 
enter 1 and press return.)
2) Follow on screen prompts for further values to be entered. Note that all data requested from the
user by the program is numerical data, except in the case of option 5 "Recommend Car Type", where 
the user is asked to enter a lifestyle choice as a text string.

NOTE: SEE THE VERY END OF README FOR JAVADOC AND GIT/GITHUB INSTRUCTIONS

Known bugs/problems:
====================
The main bug/problem of the program is in terms of validation of numerical input. I have not
added functionality for exiting calculations when users enter negative values. For instance if the
user said the cars value was -€30000 or the term was -24 months. I had the idea of storing the 
values in an array and having an extra method for looping over these values and returning a true/
false depending on whether the input the user gave was valid or not. The reason I did not do this
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
chooses other menu options such as Calculate HP, and Calculate PCP. This was to ensure output would 
match in how it was formated everywhere in the program. This feels like violating 
DRY (Don't Repeat Yourself). I could have gotten around this by using this rounding method I found 
at (1) to round the outputs of the methods to two decimal places: 
    value rounded to 2 dp = Math.round(a * 100.0) / 100.0;
Math.round rounds a double to the nearest long value (2) so by multiplying by 100 you move the decimal
place two digits to the right (e.g. 23.445 -> 2344.5) then round it (2345) the divide by 100 to get
(23.45). Casting this back to a double is fine when the long value is not very large.
    In the end I chose to use the String method as it comes from one of the few Classes that has
been covered in the course to date, and it also forced me to learn how to format numbers in text 
with that older C % sign syntax. Aside: (Oh, how I miss you Python f-strings!)

(1) https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
(2) https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html - The static round method with a double parameter


Sources used/referenced:
=======================

Volkswagen T-Roc price:
https://www.volkswagen.ie/en/new-cars/t-roc.html?adchan=sem&campaign=10171028_BR_AO_LAO_CPC_AOP_ABE_BRD_EV_IRL_SEAH_PSEAC_TEAD_NU_GAD_GADW_CPC_NU_NU_MULTI_NU_NU_EN_NU_MXED_10257434_MODEL_TROC&adgroup=T-Roc+%7C+Sport+%5BExact%5D&publisher=GOOGLE&adcr=volkswagen+t+roc&adpl=GOOGLE&adlid=914582357&country=IE&language=EN&gclsrc=aw.ds&gad_source=1&gad_campaignid=914582357&gbraid=0AAAAADkuwy_BCvod0o4Ts5Bvu4Jlv76KY&gclid=Cj0KCQjwvJHIBhCgARIsAEQnWlAri958ium5RbeYUpxnKC37smFMWbsFFSUgSHaHNpCutAR14DrYkoEaAjmTEALw_wcB
BMW i4 eDrive35 M Sport price
https://discover.bmw.ie/bmwoffers/bmw-i4-edrive35-m-sport/#:~:text=Here's%20some%20information%20about%20the%20BMW%20i4,of%20credit%20%E2%82%AC5%2C610%20*%20Term%20(months)%2037
Land Rover Defender Octa price
https://buildyour.landrover.com/lr/en_ie/l663_k26/4chw1/ipr/inspire?f-bodystyle=A-SV-110
HP APR example annual percentage rate: (0.9%)
https://www.volkswagen.ie/en/offers-and-products/new-car-offers.html (section 2)
HP Deposit Requirement: (35%)
https://www.volkswagen.ie/en/offers-and-products/new-car-offers.html (section 2)
PCP APR example annual percentage rate: (5.9%)
https://www.volkswagen.ie/en/offers-and-products/new-car-offers.html (section 3)
PCP Deposit Requirement: (31%)
https://www.volkswagen.ie/en/offers-and-products/new-car-offers.html (section 3)
Formatting a string in Java
(1) https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#format-java.util.Locale-java.lang.String-java.lang.Object...-:~:text=static%20String-,format,-(String%C2%A0format%2C%20Object
(2) https://www.w3schools.com/java/ref_string_format.asp
Escaping a percent sign in String.format
https://stackoverflow.com/questions/1708444/java-literal-percent-sign-in-printf-statement
Conversion character to represent integer in String.format (scroll to first table)
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html#syntax

Using the project Javadocs:
===========================
(If you do not have the javadocs directory in the AdamMcCarthy folder)
1) Navigate to the Tools menu in the IntelliJ menu bar
2) Select Generate Javadoc...
3) Tick Whole Project
4) Select a directory to create Javadocs in
5) Tick @author and @version and unselect any other @ option (ie deprecated etc.)
6) Optionally select open in browser at bottom if you want to view immediately

(Otherwise, If you are working with the AdamMcCarthy folder that includes the javadocs directory)
1) Navigate to the javadocs folder in the Project window
2) Inside there are two folders, one is the interactive Javadocs (like you would find on
the oracle website) and the other folder is the printed Javadocs, which are a pdf file.
3) If you want the printed Javadocs open the folder "printed javadocs" and select the class you
want to view
4) If you want the interactive Javadocs open the folder "interactive javadocs"
5) Right-click on the file "allclasses-index.html"
6) Navigate to "open in" > "Browser" > "Chrome"
7) This will open the javadocs in the Chrome browser. You can now navigate around the 
Javadocs using the hyperlinks

Using the project Git Repository
================================
I have uploaded the folder to moodle with the project on its main branch (if this is not the case
enter git switch main in the terminal)

There are several branches in the repository which I used when adding features as a 
failsafe. Feel free to explore these using "git switch branch-name":
dev
dev-balloon-payment
dev-car-recommendation
dev-docs
dev-driver-refactor
dev-learnings-marking
dev-write-up
main

You can also look at my many Git mistakes, rebases, reset --mixed, and reset --hard, amends
throughout my work using "git reflog". 

Using the project GitHub Repository:
The project GitHub repository can be found at:
https://github.com/AdamMcCarthyCS/programming-1-assignment-1

The repository can be cloned (HTTPS) using:
https://github.com/AdamMcCarthyCS/programming-1-assignment-1.git

If you've gotten this far thanks for taking the time to look at my project! Any comments or
feedback are welcome at adammccarthycs@gmail.com. Also feel free to visit my GitHub profile at:
https://github.com/AdamMcCarthyCS
