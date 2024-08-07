package com.java.Oracle;

public class Test {

    /*
    Write a query to increase the salary of employees by 10% who are working in the 'Sales' department.

    *UPDATE employees
SET salary = salary * 1.10
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'Sales');


Write a query to find the top 3 highest-paid employees in the company.
SELECT employee_id, first_name, last_name, salary
FROM employees
ORDER BY salary DESC
FETCH FIRST 3 ROWS ONLY;


Write a query to find the average salary of employees for each department.
SELECT d.department_name, AVG(e.salary) AS average_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name
ORDER BY d.department_name;


Write a query to find the employees who were hired in the last 6 months.
SELECT employee_id, first_name, last_name, hire_date
FROM employees
WHERE hire_date >= ADD_MONTHS(SYSDATE, -6)
ORDER BY hire_date DESC;



Write a query to find the department with the highest number of employees.
SELECT department_name, COUNT(*) AS num_employees
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY department_name
ORDER BY num_employees DESC
FETCH FIRST 1 ROW ONLY;

 */
}
