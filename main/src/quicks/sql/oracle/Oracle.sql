--Version
select * from  v$version;

--SQLFullText
select sql_fulltext from v$sqlarea where sql_id='${SQL}';

--TempTable
select column_value 
from table(sys.dbms_debug_vc2coll('One', 'Two', 'Three', 'Four'));

select column_value 
from table(sys.dbms_debug_vc2coll(1,2,3,4));


--Locks
SELECT sid,
  sql_text,
  blocking_session,
  serial#,
  wait_class,
  seconds_in_wait
FROM v$session s,
  v$sql q
WHERE sid IN
  (SELECT sid
  FROM v$session
  WHERE state    IN ('WAITING')
  AND wait_class != 'Idle'
  AND event       ='enq: TX - row lock contention'
  AND (q.sql_id   = s.sql_id
  OR q.sql_id     = s.prev_sql_id)
  );



select blocking_session, sid, serial#, wait_class, seconds_in_wait 
from v$session where blocking_session 
is not NULL order by blocking_session;

select b.MACHINE, count(*) 
from v$session b
GROUP BY b.MACHINE order by b.MACHINE;
