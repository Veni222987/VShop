-- function===========================================================
-- 检测bitmap对应位数是否为1的函数,index从0开始
DROP FUNCTION IF EXISTS `check_bit`;
CREATE FUNCTION `check_bit`(`bitmap` blob, `index` int) RETURNS int
    (11)
    DETERMINISTIC
BEGIN
    DECLARE
`byte` int;
    DECLARE
`bit` int;
    SET
`byte` = FLOOR(`index` / 8) + 1;
    SET
`bit` = `index` % 8;
RETURN (ORD(SUBSTRING(`bitmap`, `byte`, 1)) & POW(2, `bit`)) > 0;
END;
