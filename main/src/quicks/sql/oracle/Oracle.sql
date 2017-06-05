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





Imp SQL:

select * from (
select * from 
(select count(*) as used_process_count from  v$process),
(select VALUE as max_process_count from v$PARAMETER where name in ('processes'))),
(
select * from 
(select count(*) as used_session_count from  v$session),
(select VALUE as max_session_count from v$PARAMETER where name in ('sessions')));



select
b.machine,
  count (substr(b.machine,1,50)) 
from v$session b, v$process a
where
b.paddr = a.addr
and type='USER'
group by b.machine
order by  count (substr(b.machine,1,50))   desc

select sid, sql_text from v$session s, v$sql q where sid in (select sid from v$session where state in ('WAITING') and wait_class != 'Idle' and event='enq: TX - row lock contention' and (q.sql_id = s.sql_id or q.sql_id = s.prev_sql_id));
select blocking_session, sid, serial#, wait_class, seconds_in_wait from v$session where blocking_session is not NULL order by blocking_session;


select * from all_OBJECTS where object_id in (select object_id from V$LOCKED_OBJECT) order by object_name

SELECT lo.session_id AS sid,
       s.serial#,
       NVL(lo.oracle_username, '(oracle)') AS username,
       o.owner AS object_owner,
       o.object_name,
       Decode(lo.locked_mode, 0, 'None',
                             1, 'Null (NULL)',
                             2, 'Row-S (SS)',
                             3, 'Row-X (SX)',
                             4, 'Share (S)',
                             5, 'S/Row-X (SSX)',
                             6, 'Exclusive (X)',
                             lo.locked_mode) locked_mode,
       lo.os_user_name
FROM   v$locked_object lo
       JOIN all_objects o ON o.object_id = lo.object_id
       JOIN v$session s ON lo.session_id = s.sid
ORDER BY 1, 2, 3, 4;


