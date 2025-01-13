package com.java.Oracle;

public class Test1 {


    /*CREATE TABLE STUDENT(ID NUMBER(10), NAME VARCHAR2(30), AGE NUMBER, GENDER VARCHAR2(6), MARKS NUMBER, SEM NUMBER);
    *
    *INSERT INTO STUDENT VALUES(52, "AMAN", 26, "MALE", 98, 8);
    *
    *
    *
    * ORACLE PRACTICE
    * CREATE TABLE Employee(
    * EmployeeID number(10),
    * Name varchar2(30),
    * Age number,
    * Address varchar2(30),
    * Salary number,
    * Department number,
    * Experience number);
    *
    *
    *
    *
    *
    *
    * INSERT INTO Employee VALUES(2,'AKSHAY',25,'Kolar',21000,2542,5);
    * INSERT INTO Employee VALUES(3, 'ASHISH', 26, 'DC', 25000, 2658, 6);
    * INSERT INTO Employee VALUES(4, 'GIRISH', 20, 'DC', 25845, 2658, 2);
    * INSERT INTO Employee VALUES(5, 'KALPESH', 21, 'DC', 26528, 2542, 3);
    * INSERT INTO Employee VALUES(6, 'AVADUT', 29, 'DC', 21458, 2789, 3);
    * INSERT INTO Employee VALUES(7, 'SWAPNIL', 35, 'DC', 29254, 2789, 9);
    *
    *
    *
    *
    *
    * Write a query to display NAME and USN of the student whose age is greater than 21.
    * SELECT AGE, MARKS, FROM STUDENT WHERE AGE>21;
    *
    *
    * Write a query to display all the information of student named “KAVITHA”.
    * SELECT * FROM STUDENT WHERE NAME='KAVITHA';
    *
    *  Write a query to display NAME, GENDER and USN of student named “RAVI”
    * SELECT NAME, GENDER, USN WHERE NAME='RAVI';
    *
    * COLUMN AS EXAMPLE
    * SELECT USN AS REGISTRATION_NUMBER, NAME, GENDER, AGE AS YEARS_OLD, MARKS AS SCORE FROM STUDENT;
    *
    *
    * DISTINCT KEYWORD FOR UNIQUE RECORD
    * SELECT DISTINCT AGE FROM STUDENT;
    *
    * DUEL TABLE
    * SELECT SYSDATE FROM DUAL;
    * SELECT 18+52-7*4/9 FROM DUAL;
    *
    * USING RELATIONAL OPERATORS AS KEYWORDS
    *
    * Q1. Write a query to display USN, NAME and AGE of all the students whose age is equal to 22.
    * SELECT USN, NAME, AGE FROM STUDENT WHERE AGE=22;
    *
    * Write a query to display USN, NAME and AGE of all the students whose age is greater than 20.
    * SELECT USN, NAME, AGE FROM STUDENT WHERE AGE>20;
    *
    * Write a query to display USN, NAME and AGE of all the students whose age is lesser than 22.
    *SELECT USN, NAME, AGE FROM STUDENT WHERE AGE<22;
    *
    * Write a query to display USN, NAME and AGE of all the students whose age is greater than and equal to 20.
    * SELECT USN, NAME, AGE FROM STUDENT WHERE AGE>=20;
    *
    * Write a query to display USN, NAME and AGE of all the students whose age is lesser than or equal to 22.
    * SELECT USN, NAME, AGE FROM STUDENT WHERE AGE<=22;
    *
    * Write a query to display USN, NAME and AGE of all the students whose age is not equal to 20.
    * SELECT USN, NAME, AGE WHERE AGE !=20;
    *
    *
    * BETWEEN AND OPERATOR
    * SELECT* FROM STUDENT WHERE MARKS BETWEEN 80 AND 90;
    *
    * SELECT* FROM STUDENT WHERE MARKS NOT BETWEEN 80 AND 90;
    *
    *
    * IN OPERATOR
    * Write a query to display all the information of the students whose AGE is 20 and 22 from the STUDENT table.
    *SELECT *FROM STUDENT WHERE AGE IN (20,22);
    *
    * NULL OPERATOR
    * SELECT * FROM STUDENT WHERE AGE IS NULL;
    *
    *
    * FUNCTIONS
    *  Write a query to display NAME of all the students in lowercase letters from the table STUDENT.
    * SELECT LOWER(NAME) FROM STUDENT;
    *
    *COUNT FUNCTION
    * SELECT COUNT(*) FROM STUDENT;
    * SELECT COUNT(AGE) FROM STUDENT;
    *
    * SELECT MIN(AGE) FROM STUDENT;
    * SELECT MAX(AGE) FROM STUDENT;
    *
    * SELECT SUM(MARKS) FROM STUDENT;
    * SELECT AVG(MARKS) FROM STUDENT;
    *
    * CLAUSES
    *  Write a query to display all the details of all the students in the order of AGE from STUDENT table.
    * SELECT* FROM STUDENT ORDER BY AGE;
    *
    * GROUP BY CLAUSE
    * SELECT AGE, MIN(MARKS) FROM STUDENT GROUP BY AGE;
    * SELECT GENDER, MIN(MARKS) FROM STUDENT GROUP BY GENDER;
    *
    * SELECT GENDER, MAX(MARKS) FROM STUDENT GROUP BY GENDER;
    *
    * SELECT AGE, COUNT(AGE) FROM STUDENT WHERE AGE=21 GROUP BY AGE;
    *
    * SELECT AGE, MAX(MARKS) FROM STUDENT GROUP BY AGE;
    *
    * SELECT AGE, MAX(MARKS) FROM STUDENT HAVING MAX(MARKS)>85 GROUP BY AGE;
    *
    *
    * HAVING CLAUSE
    * SELECT AGE, MAX(SALARY) FROM EMPLOYEE WHERE AGE>19 GROUP BY AGE HAVING MAX(SALARY)>12000 ORDER BY AGE;
    *
    *
    * NESTED QUERY
    * Write a query to display USN, NAME and GENDER of all students whose marks is more than RAVI’s marks from the table STUDENT
    *SELECT USN, NAME, GENDER FROM STUDENT WHERE MARKS>(SELECT MARKS FROM STUDENT WHERE NAME='RAVI');
    *
    *
    *  Write a query to display NAME, AGE whose age is equal to student named RAM and marks is greater than student named ANJUNA from the table STUDENT.
    *  SELECT NAME, AGE FROM STUDENT WHERE AGE=(SELECT AGE FROM STUDENT WHERE NAME='RAM')AND MARKS>(SELECT MARKS FROM STUDENT WHERE NAME='ARJUNA');
    *
    * SELECT DEPT_ID FROM STU_DEPT WHERE USN IN(SELECT USN FROM STUDENT);
    *
    *SELECT DEPT_ID FROM STU_DEPT WHERE STU_DEPT.USN=STUDENT_USN;
    *
    *
    *
    * //JOINS//
    *
    * 1.INNER JOIN
    *  Write a query to display all the details from EMPLOYEE and EMP_DEPT where the value of EMP_ID in EMPLOYEE is equal to the value Of EMP_ID in EMP_DEPT.
    * SELECT * FROM EMPLOYEE E1 JOIN EMP_DEPT E2 ON E1.EMP_ID=E2.EMP_ID;
    * SELECT * FROM EMPLOYEE E1 JOIN EMP_DEPT E2 ON E1.EMP_ID=E2.EMP_ID;
    *
    *
    * 2.LEFT JOIN OR LEFT OUTER JOIN
    * SELECT * FROM EMPLOYEE E1 LEFT OUTER JOIN EMP_DEPT E2 ON E1.EMP_ID=E2.EMP_ID;
    *
    *
    * 3.RIGHT JOIN OR RIGHT OUTER JOIN
    * SELECT * FROM EMPLOYEE E1 RIGHT OUTER JOIN EMP_DEPT E2 ON E1.EMP_ID=E2.EMP_ID;
    *
    *
    *
    * selecting from multiple tables
    * SELECT * FROM EMPLOYEE E1, EMP_DEPT E2 WHERE E1.EMP_ID=E2.EMP_ID;
    *
    *
    * JOIN MULTIPLE TABLES BY USING JOINS
    * SELECT E1.SALARY, E1.EMP_ID, E2.DEPARTMENT, E2.CITY FROM EMPLOYEE E1
    * INNER JOIN EMP_DEPT E2 ON E1.EMP_ID=E2.EMP_ID WHERE E1.SALARY >40000;
    *
    *
    *
    *
    *
    * STORED PROCEDURE
    * CREATE OR REPLACE PROCEDURE increase_salary(
    p_employee_id IN NUMBER,
    p_increment_percent IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_increment_percent / 100)
    WHERE employee_id = p_employee_id;

    COMMIT;
END increase_salary;

    *
    *
    *
    * TRIGGERS
    * CREATE OR REPLACE TRIGGER log_salary_changes
AFTER UPDATE OF salary ON employees
FOR EACH ROW
BEGIN
    INSERT INTO salary_audit (employee_id, old_salary, new_salary, change_date)
    VALUES (:OLD.employee_id, :OLD.salary, :NEW.salary, SYSDATE);
END;

    *
    *
    *
    * INDEXES
    * CREATE INDEX idx_employees_last_name ON employees(last_name);
    *
    *
    *
    * //indexes and stored procedures
    *
    *
    * CREATE INDEX idx_email ON customers(email);
    * special data structure
    * created on table column to enhance query performance
    *
    *
    * example
    * CREATE INDEX idx_last_name ON employee(last_name);
    *
    * SELECT employee_id, first_name, last_name, department, salary
    * FROM employee
    * WHERE last_name='Smith';
    *
    *
    *
    * SELECT * FROM Employee ORDER BY Salary ASC;
    *
    * SELECT * FROM Employee ORDER BY Salary DESC;
    *
    * //SECOND LARGEST
    * SELECT MAX(Salary) FROM Employee where Salary <(SELECT MAX(Salary) FROM Employee);
    *
    * SECOND SMALLEST
    * SELECT MIN(Salary) FROM Employee WHERE Salary >(SELECT MIN(Salary) FROM Employee);
    *
    * THIRD LARGEST
    * SELECT Salary
    * FROM (SELECT Salary FROM Employee ORDER BY Salary DESC)
    * WHERE ROWNUM=3;
    *
    * THIRD SMALLEST
    * SELECT Salary
    * FROM (SELECT Salary FROM Employee ORDER BY Salary ASC)
    * WHERE ROWNUM=3;
    *
    *
    *
    *
    *
    *
    *
    *
*/
}
