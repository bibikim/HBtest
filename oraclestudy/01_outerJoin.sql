
/* outer join */

-- 1. 모든 사원들의 EMPLOYEE_ID, LAST_NAME, DEPARTMENT_NAME을 조회하시오.
--    부서번호(DEPARTMENT_ID)가 없는 사원도 조회하고, EMPLOYEE_ID순으로 오름차순 정렬하시오.
--    부서번호(DEPARTMENT_ID)가 없는 사원의 부서명(DEPARTMENT_NAME)은 'None'으로 조회하시오.
--      부서(PK)                 사원(FK)
-- 일치하는정보포함(+)         모든정보포함
-- 오른쪽에 있는 사원 테이블의 모든 정보 포함을 위해 오른쪽 외부 조인
select e.employee_id, e.last_name, nvl(d.department_name, 'None')
from employees e left outer join departments d
on e.department_id = d.department_id
order by e.employee_id;

-- 조인 없이
SELECT E.EMPLOYEE_ID, E.LAST_NAME, NVL(D.DEPARTMENT_NAME, 'None')
  FROM DEPARTMENTS D, EMPLOYEES E
 WHERE D.DEPARTMENT_ID(+) = E.DEPARTMENT_ID
 ORDER BY E.EMPLOYEE_ID;

-- 2. 부서별 근무하는 사원수를 조회하시오.
--    단, 근무하는 사원이 없으면 0으로 조회하시오.
select d.department_id, d.department_name, count(employee_id) 사원수
from employees e, departments d
where e.department_id(+) = d.department_id
group by d.department_name, d.department_id
order by 사원수 desc;

