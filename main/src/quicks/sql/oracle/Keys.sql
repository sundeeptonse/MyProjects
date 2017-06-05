SELECT a.table_name, a.column_name, a.constraint_name, c.owner, 
       -- referenced pk
       c.r_owner, c_pk.table_name r_table_name, c_pk.constraint_name r_pk
  FROM all_cons_columns a
  JOIN all_constraints c ON a.owner = c.owner
                        AND a.constraint_name = c.constraint_name
  JOIN all_constraints c_pk ON c.r_owner = c_pk.owner
                           AND c.r_constraint_name = c_pk.constraint_name
 WHERE c.constraint_type = 'R'
   and c_pk.table_name='${TABLENAME}'
   and a.column_name='${COLNAME}';
   
select table_name, constraint_name, status, owner
from all_constraints
where r_owner = '${SCHEMA}'
--and constraint_type = 'R'
and r_constraint_name in
 (
   select constraint_name from all_constraints
   where
   table_name = '${TABLE}'
   and owner = '${SCHEMA}'
   and CONSTRAINT_NAME='${CONSTRAINT_NAME}'
 )
order by table_name, constraint_name;




select constraint_name from all_constraints
where 
--constraint_type in ('P', 'U') and 
table_name = '${TABLE}'
and owner = '${SCHEMA}';