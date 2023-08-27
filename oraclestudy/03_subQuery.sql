--HR 계정

-- 1. location_id가 1000~1500 사이인 국가의 country_id, country_name 조회하기
SELECT COUNTRY_ID, COUNTRY_NAME
FROM COUNTRIES
WHERE COUNTRY_ID IN ( SELECT COUNTRY_ID FROM LOCATIONS WHERE LOCATION_ID BETWEEN 1000 AND 1500 );

-- 2. MANAGER가 아닌 사원들의 EMPLOYEE_ID, FIRST_NAME 조회
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID NOT IN ( SELECT MANAGER_ID FROM EMPLOYEES WHERE MANAGER_ID IS NOT NULL );

select department_id
from employees
order by department_id nulls first;

-- 3. 근무하는 city가 southlake인 사원의 id, f_name
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES E
WHERE DEPARTMENT_ID IN ( SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE LOCATION_ID IN ( SELECT LOCATION_ID FROM LOCATIONS WHERE CITY = 'Southlake' ) ); 

-- 4. 가장 많은 사원이 근무 중인 부서의 department_id와 수 조회
select b.cnt, b.department_id
  from (select a.cnt, a.department_id
          from ( select department_id, count(*) over(partition by department_id) as cnt 
                   from employees ) a 
         order by a.cnt desc) b
where rownum = 1;

select department_id, count(*)
from employees
group by department_id
having count(*) = (select max(count(*)) from employees group by department_id);

-- 5. 전체 사원 중 최대 연봉을 받는 사원의 id, name, sal 조회
-- 연봉 내림차순으로 정렬한 테이블 a
-- 테이블 a에 rowunm으로 전체 행에 번호를 매긴 테이블 b
-- 테이블 b에서 rnum이 1인 데이터의 emp_id, name, sal 조회
/* rownum 사용 */
select employee_id, first_name, salary
from(select rownum as rnum, employee_id, first_name, salary
       from (select employee_id, first_name, salary
               from employees 
              order by salary desc) a) b
where b.rnum = 6;

/* row_number() over() 사용 */
select a.employee_id, a.first_name, a.salary
from(select row_number() over(order by salary desc) as rn, employee_id, first_name, salary from employees) a
where a.rn = 6;

-- 6. 연봉 top 11 ~ 20 사원 조회
/* rownum 사용 */
select employee_id, first_name, salary
from (select rownum as rnum, employee_id, first_name, salary
        from (select employee_id, first_name, salary from employees order by salary desc) a ) b
       where b.rnum between 11 and 20
;

/* row_number() over() 사용 */
select employee_id, first_name, salary
from ( select row_number() over(order by salary desc) as rnum, employee_id, first_name, salary from employees ) 
where rnum between 11 and 20
;
