# COVID-19 self-assessment application
## Problem Statement
Create a COVID-19 self-assessment android app that allows a user to enter the symptoms that the user is facing. Then the app should say whether the user should get himself/herself checked by conducting RT-PCR. Design in this way: first activity have a form containing TextViews and EditText boxes asking user to enter his/her name, and show a symptom name (Fever), ask the user to select yes or no (have yes and no Button). There is a next button to go the next symptom. There again the user selects if he is having that symptom or not. Some of the examples are (fever, runny nose, scratchy throat, body and head ache). It should also contain Submit and Clear buttons, with Submit Button it will show the entered information in the second activity.  Now, with Clear Button it will allow the user to clear the form in the first activity. In the second activity, there will be a button to check whether the user should get him tested (if for more than 3 symptoms the user had said yes). Make sure that the app is robust across rotations.

For each change in the state of the Activities, it should LOG in type INFO and provide a Toast showing the change in the state. For example, if the state of first activity the changes from Resumed to Paused, the log should contain INFO statement saying “State of activity <name_of_the_activity> changed from Resumed to Paused”, similarly for the Toast. The app should LOG and provide Toast for all possible state transitions for each activity.


Note: Develop the App following MVC architecture.
