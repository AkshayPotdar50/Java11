package com.java.java8;

public class SqlOracle {

    /*
    * 1.Basic SELECT and WHERE Clause:

Retrieve all employees from the EMPLOYEES table who were hired after January 1, 2020.
*
* SELECT employee_name
FROM EMPLOYEES
WHERE HIRING_DATE > TO_DATE('01-JAN-2020', 'DD-MON-YYYY');
*
*
* SELECT employee_name FROM EMPLOYEES WHERE HIRING_DATE < TO_DATE('01-JAN-2020, 'DD-MON-YYYY');

*
*
* 2.Aggregate Functions and GROUP BY:

Find the average salary of employees in each department from the EMPLOYEES table.
*
* SELECT department_id, AVG(salary) AS average_salary
FROM EMPLOYEES
GROUP BY department_id;

*
* 3.JOINs (INNER JOIN):

List all orders from the ORDERS table along with the corresponding customer names from the CUSTOMERS table.
*
* SELECT O.order_id, O.order_date, C.customer_name
FROM ORDERS O
INNER JOIN CUSTOMERS C ON O.customer_id = C.customer_id;

*
*
* 4.LEFT JOIN:

Retrieve all customers and their orders, including customers who haven't placed any orders yet.
           SELECT C.customer_id, C.customer_name, O.order_id, O.order_date FROM CUSTOMERS c
            LEFT JOIN ORDER O ON C.customer_id=O.Customer_id;
    *
    * */
}
