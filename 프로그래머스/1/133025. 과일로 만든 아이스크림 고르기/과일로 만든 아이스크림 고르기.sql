-- 코드를 입력하세요
SELECT f.FLAVOR as FLAVOR
from first_half f join icecream_info ice on f.flavor = ice.flavor
where f.total_order > 3000 and ice.ingredient_type = "fruit_based"
order by total_order desc;
