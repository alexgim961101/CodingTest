-- 코드를 입력하세요
select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
from member_profile
where gender = 'W' AND TLNO IS NOT NULL AND MONTH(DATE_OF_BIRTH) = 3
order by MEMBER_ID ASC



