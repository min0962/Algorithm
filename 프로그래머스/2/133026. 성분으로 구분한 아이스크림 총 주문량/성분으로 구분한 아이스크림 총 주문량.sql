SELECT i.INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF f join ICECREAM_INFO i on f.flavor = i.flavor
group by i.INGREDIENT_TYPE
order by f.TOTAL_ORDER;


