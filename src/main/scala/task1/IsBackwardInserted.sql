CREATE TABLE Some_dates (Id INT, Timestamp DATE);

-- INSERT INTO Some_dates (Id, Timestamp)
-- VALUES
--     (1, '2016-09-17'),
--     (2, '2016-09-22'),
--     (3, '2016-09-18'),
--     (4, '2016-09-19'),
--     (5, '2016-09-21'),
--     (6, '2016-09-20'),
--     (7, '2016-09-23'),
--     (8, '2016-09-26'),
--     (9, '2016-09-24'),
--     (10, '2016-09-25'),
--     (11, '2016-09-27');

INSERT INTO Some_dates (Id, Timestamp)
VALUES
    (1, '2016-09-11'),
    (2, '2016-09-12'),
    (3, '2016-09-13'),
    (4, '2016-09-14'),
    (5, '2016-09-09'),
    (6, '2016-09-08'),
    (7, '2016-09-15')
;

SELECT Id
FROM (SELECT Id, Timestamp,
          CASE
          WHEN MAX(Timestamp) OVER (
          ORDER BY Id
          ) > Timestamp
          THEN 'Y' ELSE 'N'
          END "Is_bacward_inserted"
      FROM Some_dates)
WHERE "Is_bacward_inserted" = 'Y';

-- DROP TABLE Some_dates;
