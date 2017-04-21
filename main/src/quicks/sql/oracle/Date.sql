SELECT 
current_timestamp + INTERVAL '10' MINUTE,
current_timestamp,
current_timestamp - INTERVAL '10' MINUTE
FROM dual;

SELECT * FROM $TABLE WHERE $DATE < (current_timestamp - INTERVAL '10' MINUTE);


select * from $TABLE where $DATE >= TO_DATE('10-18-2014','MM-DD-YYYY')


--Blob

select *
from $TABLE
where 
utl_raw.cast_to_varchar2(dbms_lob.substr($COLUMN_NAME)) like '%***%';
