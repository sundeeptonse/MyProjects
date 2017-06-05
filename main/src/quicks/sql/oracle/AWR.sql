SET ECHO OFF;
SET FEEDBACK OFF;
SET SERVEROUTPUT ON buffer 2560000;
SET VERIFY OFF;
SET PAGES 0;
SET HEAD OFF;
set lines 8000;

--ALTER SESSION SET NLS_DATE_FORMAT='DD-MON-YYYY HH24:MI:SS'; 
SPOOL /Users/Blah/Desktop/AWR.html;
select output from table(select perfdba.gsd_sudo_awr.generate_awr_html(1,'22-MAR-2017 11:00:00 PM','23-MAR-2017 02:00:00 AM') from dual);
SPOOL OFF;
