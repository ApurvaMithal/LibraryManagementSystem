# LibraryManagementSystem

READ ME:

Language: Java, JavaScript, MySQL

Operating System: Windows 10

Platform: Eclipse

Software Libraries: 
- gson-2.2.2
- javax.json-1.0.2
- mysql-connector-java-5.1.45-bin
- org.json

Server: apache-tomcat-7.0.85-windows-x64

This project uses JSP for the front-end and MySql database at the back-end.

SHARED FILES
- Project War file (LibraryManagementSystem.war)
- Eclipse project folder consisting all the source code files, web.xml, jsp pages.
- DDL file
- SQL/CSV files (book.csv, borrower.csv, authors.csv, book_authors.csv)


HOW TO COMPILE:

- Install mysql.
- Start mysql server.
o Open command prompt in administrator mode.
o Type command > mysqld –console
o Once service gets started, open another command prompt terminal.
o Type command > mysql -u root -p
o Enter password
o Connect to library_system database by giving command > use library_system.
- Extract the WAR file from the eLearning folder.
- Install Tomcat 7.0.85 version.
- Go to the path where tomcat is installed. (say D:\setups\Tomcat\apache-tomcat-7.0.85-windows-x64\apache-tomcat-7.0.85)
- Go to D:\setups\Tomcat\apache-tomcat-7.0.85-windows-x64\apache-tomcat-7.0.85\webapps folder and paste the LibraryManagementSystem.WAR file. (Delete the   existing LibraryManagementSystem folder if any)
- Go to D:\setups\Tomcat\apache-tomcat-7.0.85-windows-x64\apache-tomcat-7.0.85\lib folder and paste mysql-connector-java-5.1.45-bin.jar
- Go to D:\setups\Tomcat\apache-tomcat-7.0.85-windows-x64\apache-tomcat-7.0.85\bin folder and double click startup batch file
- Once the tomcat server is up and running, go to the browser (say chrome) and open the link localhost:8080/LibraryManagementSystem/index.jsp
- Now we are ready to work on library management system.

