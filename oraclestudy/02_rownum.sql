SELECT empno, ename, sal FROM emp ORDER BY sal DESC;

/* 정렬 후 rownum 붙이고 rownum이 2인 경우 조회 */
-- 인라인뷰A를 통해 정렬을 한 후, 임시 A테이블에 rownum으로 번호를 붙여준 임시 B테이블을 만들고
-- B테이블에서 rnum이 2인 경우를 조회
SELECT rnum, b.empno, b.ename, b.sal 
FROM ( SELECT ROWNUM as rnum, a.empno, a.ename, a.sal
         FROM ( SELECT empno, ename, sal
                  FROM emp
                 ORDER BY sal DESC) A ) B
WHERE rnum = 2;

-- rownum이 2인 경우 조회하는 쿼리의 잘못된 예
-- 정렬한 테이블 a로부터 바로 rownum이 2인 조건을 준 행의 조회는 불가능
SELECT ROWNUM, a.empno, a.ename, a.sal
FROM ( SELECT empno, ename, sal FROM emp ORDER BY sal DESC ) a
WHERE ROWNUM = 2;

-- ROW_NUMBER() OVER() 활용해서 rownum이 2인 경우 조회
-- row_number() 함수는 정렬(over 활용)과 행 번호 추가를 동시에 진행하기 때문에 인라인뷰 2개 사용이 필요 없음
-- 중복된 값(동점, 동일한 값)이라도 순서대로 번호를 부여함.
SELECT num, a.empno, a.ename, a.sal
FROM ( SELECT ROW_NUMBER() OVER(ORDER BY sal DESC) AS num, empno, ename, sal
         FROM emp ) a
WHERE num = 2;

-- 부서별 연봉 순위 매기기
SELECT num, a.deptno, a.empno, a.ename, a.sal
FROM ( SELECT ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal DESC) AS num, deptno, empno, ename, sal
         FROM emp ) a;


-- RANK()
-- 중복된 값(동점, 동일한 값)이 있다면 해당 개수만큼 건너 뛰고 다음 번호를 부여함.
-- ex) 1 1 3 4 5 5 7  따라서 rank() over() as num 으로 num이 5인 경우를 조회할 시, 2개의 값을 가져오게 됨
SELECT num, a.empno, a.ename, a.sal
FROM ( SELECT RANK() OVER(ORDER BY sal DESC) AS num, empno, ename, sal
         FROM emp ) a
WHERE num = 9;

SELECT RANK() OVER(ORDER BY sal DESC) AS num, empno, ename, sal
         FROM emp;

SELECT DENSE_RANK() OVER(ORDER BY sal DESC) AS num, empno, ename, sal
         FROM emp;
