> LV.2 가격이 제일 비싼 식품의 정보 출력하기

```sql
SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT )
```

> LV.1 가장 비싼 상품 구하기

```sql
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT
```

> LV.1 최대값 구하기

```sql
SELECT MAX(DATETIME) AS 시간
FROM ANIMAL_INS
```

> LV.2 최솟값 구하기

```sql
SELECT MIN(DATETIME) AS 시간
FROM ANIMAL_INS
```

> LV.2 동물 수 구하기

```sql
SELECT COUNT(*) AS count
FROM ANIMAL_INS
```

> LV.2 중복 제거하기

```sql
SELECT COUNT(DISTINCT(NAME)) AS count
FROM ANIMAL_INS
```

> LV.2 조건에 맞는 아이템들의 가격의 총합 구하기

```sql
SELECT SUM(PRICE) AS TOTAL_PRICE
FROM ITEM_INFO
WHERE RARITY = 'LEGEND'
```

> LV.3 물고기 종류 별 대어 찾기

```sql
SELECT F.ID, N.FISH_NAME, F.LENGTH
FROM FISH_INFO F
JOIN FISH_NAME_INFO N ON F.FISH_TYPE = N.FISH_TYPE
WHERE (F.FISH_TYPE, F.LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    WHERE LENGTH IS NOT NULL
    GROUP BY FISH_TYPE
)
ORDER BY F.ID ASC
```

> LV.1 잡은 물고기 중 가장 큰 물고기의 길이 구하기

```sql
SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH
FROM FISH_INFO;
```

> LV.2 연도별 대장균 크기의 편차 구하기 

```sql
WITH MAX_SIZE_TABLE AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, 
           MAX(SIZE_OF_COLONY) AS MAX
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE) 
)

SELECT M.YEAR,
    (M.MAX - E.SIZE_OF_COLONY) AS YEAR_DEV
    , E.ID
FROM ECOLI_DATA E
JOIN MAX_SIZE_TABLE M ON YEAR(E.DIFFERENTIATION_DATE) = M.YEAR
ORDER BY M.YEAR ASC, YEAR_DEV
```
