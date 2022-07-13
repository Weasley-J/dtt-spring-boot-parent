CREATE TABLE IF NOT EXISTS `dtt_person`
(
    `id`                    bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `open_id`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                      DEFAULT NULL COMMENT '用户openId',
    `nickname`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                      DEFAULT NULL COMMENT '用户昵称',
    `is_enable`             tinyint                                                                                                                           DEFAULT NULL COMMENT '是否启用, 默认：1',
    `balance`               decimal                                                                                                                           DEFAULT NULL COMMENT '用户积分余额, 默认：0.00',
    `birthday`              datetime                                                                                                                          DEFAULT NULL COMMENT '出生日期，格式：yyyy-MM-dd HH:mm:ss',
    `member_type`           enum ('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '会员类型，默认：ORDINARY',
    `status`                int                                                                                                                               DEFAULT NULL COMMENT '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
    `deleted`               int                                                                                                                               DEFAULT NULL COMMENT '账户注销状态；0 未注销（默认），1 已销户',
    `registrar_date`        date                                                                                                                              DEFAULT NULL COMMENT '注册时间，格式: yyyy-MM-dd',
    `accelerate_begin_time` time                                                                                                                              DEFAULT NULL COMMENT '会员加速开始时间, 格式：HH:mm:ss',
    `accelerate_end_time`   time                                                                                                                              DEFAULT NULL COMMENT '会员加速结束时间, 格式：HH:mm:ss',
    `update_time`           datetime                                                                                                                          DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息';
