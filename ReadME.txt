# Assignmet-CME

This assignment is developed using spring boot for backend and react js and material UI for frontend.
The restaurants are inserted manually to postgreSQL(Queries found in folder queries.sql)

#Page1 (Restaurants)
The restaurants presented have checkbox that dedicate if it is checkedd or not.
This feature has a problem that when you refresh it assign checked and non-checked randomly.

When ypu click on the restaurant image a dialog will show containing the image and restaurant's information.
The restaurants images are stored on server (172.0.0.1:5500) because react can't read from local resources. Open the images folder in vs code and run "Open with Live Server"

Filter feature will not work with the first choice since react can't read the value of filter chosen unless it render.

Search feature is set in form that will take the entered value on submit and return the result. (The function will take the search value and change it to upper case using toUpperCase() function from react.

#Page2 (Visited Restaurants)
All the restaurants that are checked to true are added to the table with the visited time that is generated in the backend in the updateRestaurantById function.

