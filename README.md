# Arsenal Management System
Contents
Project Requirements	
Purpose of the Project:
Expected Outcomes:	
Specific Constraints or Limitations:	
Project Plan	
Scope of the Project:	
Source Code:	
Database Schema:	
Table Definitions:	
User Documentation:	
Application Access:	
Login Credentials:	
Navigation:	
Technical Documentation:	
Architecture:	
Implementation:	
Relevant Technical Details:	



Project Requirements

Purpose of the Project:
The purpose of this project is to create a comprehensive arsenal management system tailored for military use. The application will centralize the management of weapons inventory, soldier records, and weapon requests, providing a secure and efficient platform for military personnel.

Expected Outcomes:
1.	Streamlined Operations: Automation of weapon tracking and soldier management processes.
2.	Improved Accountability: Accurate recording of weapon transactions and soldier details.
3.	Enhanced Security: Implementation of a robust authentication system to ensure data integrity.
4.	User-Friendly Interface: An intuitive interface for easy navigation and use by military personnel.

Specific Constraints or Limitations:
-	Time Limitations: Completion is expected within 3 weeks.
-	Technology Constraints: The application will be developed using Java, Spring Boot, Thymeleaf, and MySQL.

Project Plan

Scope of the Project:
1. Weapon Management:
   - Addition of new weapons with details.
   - Handling returns of weapons.
   
2. Soldier Management:
   - Registration of new soldiers.
   - Editing soldier information.

3. Request Tracking:
   - Managing requests for weapons.

Source Code:

The source code for the project is hosted on GitHub: [Insert Link].

Key Files:
- `GunController.java`: Handles HTTP requests related to guns.
- `SoldierController.java`: Manages soldier-related operations.
- `RequestController.java`: Handles weapon request transactions.
- `ReturnsController.java`: Handles weapon return transactions.

Database Schema:

Table Definitions:

1. Gun Table:
   - gun_id (Primary Key)
   - manufacturer
   - model
   - gun_type
   - serial_number
   - purchase_date
   - registration_number

2. Soldier Table:
   - soldier_id (Primary Key)
   - username
   - email
   - rank
   - military_number
   - password

3. Request Table:
   - request_id (Primary Key)
   - gun_id (Foreign Key referencing Gun Table)
   - soldier_id (Foreign Key referencing Soldier Table)
   - request_date
3. Return Table:
   - request_id (Primary Key)
   - returnbullet
   - returnmagazine
   - request_date
   - request_id (Foreign Key referencing Request Table)

Relationships:
 
User Documentation:

Application Access:
The application is accessible at [Insert URL]. Use the provided login credentials to access the system.

Login Credentials:
- Username: [sample username]
- Password: [sample password]

Navigation:

1. Add New Soldier
   - Navigate to "Add New Soldier."
   - Fill in Username, Email, Rank, Military Number and Password.
   - Click "Save" to add a new soldier.
Note: Email will be sent to the Soldier with the login info as the body of the email.
Password will be provided if he/she is allowed to access the system.
If Soldier is not given the password, he/she is only allowed to search on the index page of the system using his/her military number to get the information about his/her request and returns and he/she if needed can download the information.

1. Add New Weapons:
   - Navigate to "Add New Weapons."
   - Fill in manufacturer, model, type, serial number, purchase date, and registration number.
   - Click "Save" to add a new weapon.
Note: Added a Combo box of information mostly common to all guns to make the task easy for the users.
1. Assign Weapons:
   - Navigate to "Assign Weapons."
   - Select Gun and Soldier then select the date.
   - Click "Save" to add a new request.
Note: Now the soldier can search and see that he/she has been assigned a weapon.

2. Return Weapons:
   - Go to "Return Weapons."
   - Select the request and specify the number of bullets and magazines to return.
   - Click "Submit" to complete the return process.
2. Search:
   - Go to "Search" on the index or on Navbar on the Dashboard
   - Enter Military number the search the information and will display all information related to that military number 
   - Go to "Download Data" to download the data

Technical Documentation:

Architecture:

The application follows a three-tier architecture:
1. Front-end: Thymeleaf for server-side rendering.
2. Back-end: Java and Spring Boot for RESTful APIs.
3. Database: MySQL for data storage.

Implementation:

1. Back-end:
   - Spring Security for user authentication.

2. Front-end:
   - Bootstrap for responsive and user-friendly design.

3. Database:
   - MySQL for data storage.
   - Foreign key relationships ensure data integrity.

Relevant Technical Details:

- Security: Spring Security ensures secure user authentication.
- Front-end Styling: Bootstrap provides a responsive and visually appealing design.
- Communication: RESTful APIs enable seamless communication between front-end and back-end.
## Screens
<img width="700" alt="Screenshot 2023-12-16 184317" src="https://github.com/user-attachments/assets/ca020ee9-3f81-4dac-bf98-3bab388b9854" />
<img width="700" src="https://github.com/user-attachments/assets/07056ab5-0246-4249-ac39-efa446996055" />
<br>
<img width="700" src="https://github.com/user-attachments/assets/302bc0ef-1b58-45cd-9631-74059f9c43f3" />
<img width="700" src="https://github.com/user-attachments/assets/08013aa5-7689-4578-8142-f871dc96da36" />
<img width="700" src="https://github.com/user-attachments/assets/2ec0753a-3d7f-481a-b3f5-68994c9c25c8" />
<img width="700" src="https://github.com/user-attachments/assets/15810bbd-168b-4c8d-8b2a-afb40ce76a72" />
<img width="700" src="https://github.com/user-attachments/assets/f78e6876-04a3-4354-a564-076b7d0ddd08" />
<img width="700" src="https://github.com/user-attachments/assets/bc84f502-975c-42c0-830b-c4416eb81786" />
<img width="700" alt="Screenshot 2023-12-16 185117" src="https://github.com/user-attachments/assets/3050a8b3-183c-4de8-8d02-718af3c4b98a" />
<img width="700" alt="Screenshot 2023-12-16 185145" src="https://github.com/user-attachments/assets/865385c9-dd55-4158-96b6-eac94f9d01a3" />
<img width="700" alt="Screenshot 2023-12-16 184819" src="https://github.com/user-attachments/assets/b16ef039-690a-4433-821b-47b89e1af59f" />
<img width="700" alt="Screenshot 2023-12-16 184855" src="https://github.com/user-attachments/assets/0473d187-b30d-43e5-a843-d969986faafa" />
