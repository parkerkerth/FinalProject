# FinalProject
GOALS /  PROBLEMS / STEPS ECT

First, figure out how to convert json to java
Then load JSON data into java 
Parse the data based on star rating, review, user id, business id, review id, useful votes
Make new database for business and reviewers
Link the reviews to business and reviewers

CHALLENGES

  - parsing the data
  - passing it correctly into the database
  - using the database with such a large amount of data
  - figuring out what to do with the data / how to rank reviews
   - linking the data to businesses and reviewers
   
   USEFUL LINKS:
   
   https://www.techiedelight.com/how-to-read-file-using-inputstream-java/
   input stream
   
   https://www.oracle.com/technical-resources/articles/java/json.html
   JSON to JAVA
   
   https://www.brentozar.com/archive/2013/02/disabling-vs-dropping-indexes/
   https://blog.sqlauthority.com/2007/05/17/sql-server-disable-index-enable-index-alter-index/
   Altering indexes
   
   QUESTIONS FOR BEN
   Database disk image is malformed
   
   
   
   NOTES 5 / 8 FRIDAY
   File reader, then pass new file reader into a buffer reader
   Do on buffer reader, reader.readline, assign it to a var and pass the string into json parser.parse
   
   First start thinking about quereies
   If takes to much time, think about what other tables to add
   
   Skip every other line
   
   
   TODO:
   Filter reviews by fans, then implement interface for person to search for resturant and order review by fans
   Filter restruants by number of reviews
  
  Multiple indexes

…?



