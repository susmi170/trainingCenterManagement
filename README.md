# trainingCenterManagement
This is a spring boot project which contains codebase for CRUD APIs needed for a Training Center management system
This is a Project for "Training center Managemnet Application"  
    
  **Setup and run :-** 
  1.Please fork this repo and open the project in IDE.  
  2.Git clone to your local system and open in IDE/ or setup via git link directly to your IDE  
  3.DB used H2 in memory with DB name:trainingCenterManagement, username : susmita , no passwrod. (http://localhost:8082/h2-console/)  
  4.Run the TrainingCenterManagementApplication ( Spring boot application main class)  
  5. By default server will start at localhost 8082  
  6.You can now start using the apis ( details in Swagger ) in your postman (http://localhost:8082/swagger-ui/index.html)  
  7.Here TrainingCenter is the resouce, so all the apis are created keeping this is mind with just /trainingCenter endpoit   
  8.With keeping standard rset api in mind have developed the api endpoit accordingly   
  9.to save/create use /trainingCenter with POST Method  
  10.to get all use /trainingCenter/all with GET method  
    
  note : we shoud use the resource as it is and use Rest method to define them , should not create endpoint like createtrainingCenter  
  as POST is dedicated to create trainingCenter , GET for getting  
    
  **swagger url**:(http://localhost:8082/swagger-ui/index.html)  
  has all the details for each api and response code and all the details  
    
  **Tables:**  
    
  TRAINING_CENTER :  
  ID,CENTER_NAME,CENTER_CODE,STUDENT_CAPACITY,CONTACT_EMAIL,CONTACT_PHONE,COURSES,CREATED_ON,ADDRESS_ID  
    
  ADDRESS:  
  ID,FULL_ADDRESS,CITY,STATE,PIN  
  ID is the primary key ,will be automatcailly genarted by sequence for both the tables  
    
     
   **----Technology used:---**  
   Java 17 with Spring boot  
   Lombok for data generation(constructor and getter ,setter)  
   Mapstruct:(TrainingCenterMapper.java) For converting Dto to Entity pojo and vice versa . In this project using TrainingCenterDto for all api calls , and TrainingCenter entity for Database table  
   ControllerAdvice: As ExceptionHandler To handle all validation errors in a single expcetion class wrapper and display the same as API response  
  Open-API : for Swagger api documentation (http://localhost:8082/swagger-ui/index.html#/ )  
  Database: H2 inmemory DB with SPring data JPA  
  Junit for service layer method testing .(TrainingCenterServiceTest.java)  
  Build tool :Gradle  
     
     
     
  **-------API details:----**  
    
  1.Create TrainingCenter :-  
  Endpoint : http://localhost:8082/trainingCenter  
  Method: POST  
  Sample request:-  
  {  
       "centerName": "Test Center",  
       "centerCode": "TCM_00000001",  
       "studentCapacity": 100,  
       "address": {  
       "fullAddress": "Marathahalli,Bangalore",  
       "city": "Bangalore",  
       "state": "Karnataka",  
       "pinCode": 560037  
       },  
       "courses": [  
       "Java",  
       "Python",  
       "C++"  
       ],  
       "contactEmail": "test@gmail.COM",  
       "contactPhone":1234567890  
       }  
     
   Response:  
  {  
       "id": 1,  
       "centerName": "Test Center",  
       "centerCode": "TCM_00000001",  
       "studentCapacity": 100,  
       "address": {  
       "id": 1,  
       "fullAddress": "Marathahalli,Bangalore",  
       "city": "Bangalore",  
       "state": "Karnataka",  
       "pinCode": 560037  
       },  
       "courses": [  
       "Java",  
       " Python",  
       " C++"  
       ],  
       "contactEmail": "test@gmail.COM",  
       "contactPhone": "1234567890",  
       "createdOn": "2024-05-20"  
       }  
     
     
   Sample validation Error request and response:  
     
   Request:  
   {  
            
          "centerCode": "TCM_0000002",  
          "studentCapacity": 100,  
          "address": {  
              "fullAddress": "Marathahalli,Bangalore",  
              "city": "Bangalore",  
              "state": "Karnataka",  
              "pinCode": 560037  
          },  
          "courses": [  
              "Angular",  
              "Python",  
              "C++"  
          ],  
          "contactEmail": "testgmail",  
          "contactPhone":234567890  
      }  
    
  Response:  
  {  
      "errorMessage": "{contactEmail=Contact Email is not Valid,  
  	centerCode=Center Code should be exactly 12 characters,   
  	contactPhone=Contact Phone number is not Valid,  
  	centerName=Center name is mandatory}",  
      "requestedURI": "/trainingCenter"  
  }  
     
  2.Get all TrainingCenters  :  
    
    
  Endpoint :http://localhost:8082/trainingCenter/all  
  Method: GET  
     
   Response:  
   [  
          {  
              "id": 1,  
              "centerName": "Test Center",  
              "centerCode": "TCM_00000001",  
              "studentCapacity": 100,  
              "address": {  
                  "id": 1,  
                  "fullAddress": "Marathahalli,Bangalore",  
                  "city": "Bangalore",  
                  "state": "Karnataka",  
                  "pinCode": 560037  
              },  
              "courses": [  
                  "Java",  
                  " Python",  
                  " C++"  
              ],  
              "contactEmail": "test@gmail.COM",  
              "contactPhone": "1234567890",  
              "createdOn": "2024-05-20"  
          },  
          {  
              "id": 2,  
              "centerName": "Test Center 2",  
              "centerCode": "TCM_00000002",  
              "studentCapacity": 100,  
              "address": {  
                  "id": 2,  
                  "fullAddress": "Marathahalli,Bangalore",  
                  "city": "Bangalore",  
                  "state": "Karnataka",  
                  "pinCode": 560037  
              },  
              "courses": [  
                  "Angular",  
                  " Python",  
                  " C++"  
              ],  
              "contactEmail": "test@gmail.COM",  
              "contactPhone": "1234567890",  
              "createdOn": "2024-05-20"  
          }  
      ]  
   
 
