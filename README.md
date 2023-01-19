# Rides
Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

.Android studio
.Kotlin

Base requirement 
Screen 1

1. Added Display an input field and a button.

2. When the button is pressed retrieve a list of vehicles.

3.Display the retrieved list sorted by vin below the input field and button

Screen 2

Vehicle Details 

1. Allow items on the Vehicle List screen to be clickable and when pressed navigate to a Vehicle Details screen 

2. On the Vehicle Details screen display the following returned from the API.



Additional Requirement

Using git, create a new branch named additional_requirements from base_requirements and implement the following: 

1. Implement validation for the input field on the Vehicle List screen 

• value must be an integer in the range 1 to 100 
• when the value is in range, proceed with the API call 
• when the value is not in range, do not make an API call and notify the user to make a correction 
• add unit test(s) for the validation logic 
 

2. Display a button on the Vehicle Details screen and when pressed: 

• Display a bottom sheet 
• On the bottom sheet display an estimated carbon emissions based on the vehicles kilometrage returned from the API,
