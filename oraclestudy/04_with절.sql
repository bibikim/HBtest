SELECT deptno, COUNT(*) as dept_cnt FROM emp GROUP BY deptno;

SELECT empno, ename, deptno, COUNT(deptno) OVER(PARTITION BY deptno) from emp;

SELECT deptno, COUNT(*) OVER(ORDER BY deptno) as cnt from emp;


/* 서브쿼리(인라인뷰)를 WITH절로 변경하기 */
SELECT e.ename, dc.dept_cnt
FROM emp e, (SELECT deptno, COUNT(*) dept_cnt FROM emp GROUP BY deptno) dc
WHERE e.deptno = dc.deptno;

SELECT deptno, COUNT(*) dept_cnt FROM emp GROUP BY deptno;

-- ▼

with dpt_cnt as
(
    select deptno, count(*) dpt_cnt
    from emp
    group by deptno
)
select e.ename, c.dpt_cnt
from emp e, dpt_cnt c
where e.deptno = c.deptno;

--

WITH BASE1 as
(
 SELECT deptno, dname
 FROM dept
)
SELECT E.ename, b1.dname, b1.deptno, ROUND ( RATIO_TO_REPORT(E.sal) OVER(PARTITION BY E.deptno), 2 ) * 100 as 부서별연봉백분율
FROM emp e, base1 b1
WHERE e.deptno = b1.deptno;


/* 서브쿼리(인라인뷰)를 WITH절로 변경하고 반복 재사용 */
select e.ename as 사원, d1.d_cnt as emp카운트, m.ename as 매니저, d2.d_cnt as mgr카운트
from emp e, (select deptno, count(*) as d_cnt from emp group by deptno) d1,
     emp m, (select deptno, count(*) as d_cnt from emp group by deptno) d2
where e.deptno = d1.deptno
and   e.mgr = m.empno
and   m.deptno = d2.deptno;

-- ▼

with base as 
(
    select /*+INLINE*/ deptno, count(*) as d_cnt from emp group by deptno
)
select e.ename, b1.d_cnt, m.ename, b2.d_cnt
from emp e, base b1, emp m, base b2
where e.deptno = b1.deptno
and e.mgr = m.empno
and m.deptno = b2.deptno;


/* rownum과 row_number() 쓰임새 */
SELECT ROWNUM , a.* FROM emp a ORDER BY a.ename;  -- ename 오름차순 정렬이 제일 마지막에 이루어지기 때문에 rownum이 뒤죽박죽으로 나옴
SELECT ROWNUM , x.* FROM ( SELECT a.* FROM emp a ORDER BY a.ename ) x;  -- 따라서 서브쿼리로 ename을 정렬 후에 rownum을 조회해야 순서대로 나옴
SELECT ROW_NUMBER() OVER(ORDER BY a.ename) rnum, a.* from emp a;  -- 서브쿼리로 써주는 것이 비효율적이므로 이런 경우 row_number() over()을 사용하면 좋음
SELECT ROW_NUMBER() OVER(PARTITION BY a.job ORDER BY a.ename) rnum, a.* from emp a;  -- partition by까지 써주면 직업별 그룹 내의 순번을 따로 붙일 수 있음

