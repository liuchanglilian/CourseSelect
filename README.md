# CourseSelect
Course select system with Restful API using AWS SNS service and DynamoDB service together with lambda. Students register for courses online and receives email for the course they registered when announcements for that course are published. Please notice each student is only available for three courses.

## Domain: liuchanglilianassignment3.us-east-2.elasticbeanstalk.com

### Add Course

Every time a course is added,a SNS topic will be created automatically for this course, and the arn will be stored in the DynamoDB database. 

Post -> .../webapi/courses
put in the body:

      {
        "boardId": "129",
        "courseId": "Is5108",
        "department": "Information Systems",
        "professorId": "123",
        "taId": "123",
       }

### Register Student for Course

Post -> ../webapi/student/{studentId}/register
( A student could only be registered with at most three courses, other attempt for registration will be ignored!)
put the course information in the body:

      {
        "boardId": "129",
        "courseId": "Is5108",
        "department": "Information Systems",
        "professorId": "123",
        "taId": "123",
       }
