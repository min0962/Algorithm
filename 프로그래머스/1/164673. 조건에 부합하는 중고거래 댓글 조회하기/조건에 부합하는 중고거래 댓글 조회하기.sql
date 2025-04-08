-- 코드를 입력하세요
SELECT ugb.TITLE,ugb.BOARD_ID,ugs.REPLY_ID,ugs.WRITER_ID,ugs.CONTENTS,date_format(ugs.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD ugb join USED_GOODS_REPLY ugs
on ugb.BOARD_ID = ugs.BOARD_ID
WHERE YEAR(ugb.CREATED_DATE) = '2022' AND MONTH(ugb.CREATED_DATE)='10'
order by ugs.CREATED_DATE asc, ugb.TITLE asc;