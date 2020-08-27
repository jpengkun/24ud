CREATE TABLE `sequence` (
                            `name` varchar(50) NOT NULL, -- 序列名称
                            `current_val` int(11) NOT NULL, -- 当前值
                            `increment_val` int(11) NOT NULL DEFAULT '1', -- 步长(跨度)
                            `desc` varchar(255) DEFAULT NULL -- 描述
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='序列表';

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('zc_no', '0', '1', '找仓审核流水号序列');
INSERT INTO `sequence` VALUES ('zs_no', '0', '1', '招商审核流水号序列');
INSERT INTO `sequence` VALUES ('co_no', '0', '1', '合作仓审核流水号序列');
INSERT INTO `sequence` VALUES ('yy_no', '0', '1', '预约管理流水号序列');


DROP FUNCTION IF EXISTS `currval`;
CREATE FUNCTION currval (seq_name VARCHAR(50))
    RETURNS integer(11)
BEGIN
    DECLARE VALUE INTEGER;
    SET VALUE = 0;
    SELECT current_val into value from sequence where name = seq_name;
    RETURN VALUE;
END;


DROP FUNCTION IF EXISTS `nextval`;
CREATE FUNCTION nextval (seq_name VARCHAR(50))
    RETURNS integer(11)
BEGIN
    UPDATE sequence SET current_val = current_val + increment_val where name = seq_name;
    RETURN currval(seq_name);
END;