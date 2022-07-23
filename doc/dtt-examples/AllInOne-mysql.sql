DROP TABLE IF EXISTS `db_demo`.`express_kdyb_data`;
CREATE TABLE IF NOT EXISTS `db_demo`.`express_kdyb_data`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `time`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `ftime`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `status`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `area_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `area_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `context`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='';


DROP TABLE IF EXISTS `db_demo`.`order_local_delivery`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_local_delivery`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '订单商品id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `deliveryman_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送员姓名',
    `deliveryman_tel`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送员电话',
    `delivery_time`  datetime                                                  DEFAULT NULL COMMENT '发货时间',
    `receiver_time`  datetime                                                  DEFAULT NULL COMMENT '收货时间',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `delivery_service_provider`  int                                                  DEFAULT NULL COMMENT '配送服务方：0 商户，1 美团',
    `delivery_service_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送服务包code',
    `delivery_status`  int                                                  DEFAULT NULL COMMENT '配送状态：0 待商家接单，1 待骑手接单，2 待骑手取货，3 配送中，4 已完成，5 订单异常，6 已取消',
    `delivery_exception`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送异常信息',
    `predict_delivery_time`  time                                                  DEFAULT NULL COMMENT '预计送达时间',
    `delivery_num`  bigint                                                  DEFAULT NULL COMMENT '配送单号',
    `delivery_outer_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送外部订单id',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 同城配送信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_card_record`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_card_record`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `assets_card_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '卡号',
    `use_amount`  decimal                                                  DEFAULT NULL COMMENT '使用金额',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单礼品卡记录表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_operation_log`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_operation_log`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `operation_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `operation_content`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作内容',
    `template_id`  int                                                  DEFAULT NULL COMMENT '模板id',
    `before_change`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '变更前',
    `after_change`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '变更后',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 运费模板操作日志
 </p>';


DROP TABLE IF EXISTS `db_demo`.`rx_inquiry_log`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_inquiry_log`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_ids`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单id',
    `consult_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '咨询单号',
    `consult_status`  int                                                  DEFAULT NULL COMMENT '问诊单状态:0,待接诊;4,超时;5,交流中;6,处方已开出且正常结束;100,未开处方且医生主动结束订单 101：用户退款，问诊单关闭',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊请求url',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊异常备注',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 问诊记录日志表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_audiologist_remark`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_audiologist_remark`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `doctor_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生姓名',
    `audiologist_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '听力师姓名',
    `configuration_location`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配置地点',
    `shipper`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '发货方',
    `accessories_details`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配件详情',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 听力师订单备注表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_template`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_template`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '运费模板名称',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 商家后台',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
    `free_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '免运费阈值',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `create_userid`  int                                                  DEFAULT NULL COMMENT '创建者id',
    `create_username`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建者',
    `template_type`  int                                                  DEFAULT NULL COMMENT '模板类型 1:云药房模板 2:O2O配送 3:物流配送',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志 1 已删除 0 未删除',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 运费模板
 </p>';


DROP TABLE IF EXISTS `db_demo`.`log_outer_reqst`;
CREATE TABLE IF NOT EXISTS `db_demo`.`log_outer_reqst`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `outer_code`  int                                                  DEFAULT NULL COMMENT '外部渠道code 1：京东',
    `outer_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部渠道名称',
    `request_uri`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '请求地址(去掉域名和请求参数)',
    `request_params`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '请求参数',
    `response_result`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '返回参数',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 外部请求日志记录
 </p>';


DROP TABLE IF EXISTS `db_demo`.`rx_compliance_switch_log`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_compliance_switch_log`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `switch_id`  int                                                  DEFAULT NULL COMMENT '开关id',
    `switch_type`  int                                                  DEFAULT NULL COMMENT '合规开关类型 1: 终端 2：业务 3:用户灰度  4:sku白名单',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作描述',
    `create_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 强合规开关日志表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_refund`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_refund`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `refund_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单号',
    `refund_type`  int                                                  DEFAULT NULL COMMENT '1 退款 2 退货 3 退货退款',
    `status`  int                                                  DEFAULT NULL COMMENT '1 待退款 2 退款关闭 3 商家审核 4 商品寄回 5 商家确认退款 6 退款成功 7 退货待审核',
    `channel`  int                                                  DEFAULT NULL COMMENT '1 线下E端 2 线上C端 3 线下B端',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `refund_amount`  decimal                                                  DEFAULT NULL COMMENT '退款金额',
    `refund_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '运费退款金额',
    `refund_pay_dis_amount`  decimal                                                  DEFAULT NULL COMMENT '非现金支付退款金额',
    `address`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货地址合并省市区',
    `buyer_id`  int                                                  DEFAULT NULL COMMENT '买家用户ID',
    `buyer_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者用户名',
    `buyer_tel`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者电话',
    `item_id`  int                                                  DEFAULT NULL COMMENT 'item id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `goods_id`  int                                                  DEFAULT NULL COMMENT 'goods id',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
    `supplier_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商名称',
    `chain_shop_id`  int                                                  DEFAULT NULL COMMENT '连锁店id',
    `chain_shop_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '连锁店名称',
    `retail_shop_id`  int                                                  DEFAULT NULL COMMENT '门店id',
    `retail_shop_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '门店名称',
    `supplier_full_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商全称',
    `pay_way_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付代码（支付类型代码）',
    `pay_way_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付名称（支付类型名称）',
    `finished_time`  datetime                                                  DEFAULT NULL COMMENT '退单完成时间',
    `cancel_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单原因',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `pay_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '支付交易单号',
    `third_transaction_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '三方流水号',
    `supplement_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '补充原因',
    `rejective_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '拒绝原因',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
    `out_member_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大会员系统的会员id',
    `return_deduction_amount`  decimal                                                  DEFAULT NULL COMMENT '退单归还抵扣金额',
    `return_deduction_score_amount`  decimal                                                  DEFAULT NULL COMMENT '退单归还抵扣金额（优医币，邦指数）',
    `return_deduction_card_amount`  decimal                                                  DEFAULT NULL COMMENT '退单归还抵扣金额（礼品卡）',
    `return_health_coin`  int                                                  DEFAULT NULL COMMENT '退单归还抵扣优医币',
    `return_bang_coin`  int                                                  DEFAULT NULL COMMENT '退单归还抵扣邦指数',
    `express_method`  int                                                  DEFAULT NULL COMMENT '退货物流方式 1.无退货物流 2.原运单退回 3.新运单退回',
    `invoice_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `express_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司code',
    `picture_url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退款图片凭证',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 退单主表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_template_shop`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_template_shop`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_id`  int                                                  DEFAULT NULL COMMENT '运费模板id',
    `distance`  decimal                                                  DEFAULT NULL COMMENT '距离',
    `base_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '基本运费额',
    `start_time`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '开始配送时间',
    `end_time`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '最后结束时间',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `delivery_service_provider`  int                                                  DEFAULT NULL COMMENT '配送服务方：0 商户，1 美团',
    `delivery_service_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '配送服务包code',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 o2o运费模板
 </p>';


DROP TABLE IF EXISTS `db_demo`.`lottery_meeting_winner`;
CREATE TABLE IF NOT EXISTS `db_demo`.`lottery_meeting_winner`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `batch_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '抽奖批次号',
    `oa_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'OAID,如018513',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志',
    `created_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 年会抽奖中将表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_jd_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_jd_item`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '电商订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '电商订单号',
    `jd_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东订单号(order_jd_info中jd_order_id)',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东sku',
    `mall_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商城sku',
    `category`  int                                                  DEFAULT NULL COMMENT '京东3级类目id',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '购买商品数量(原始购买数量)',
    `goods_type`  int                                                  DEFAULT NULL COMMENT '商品类型  0 普通、1 附件、2 赠品、3延保',
    `goods_oid`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '主商品ID',
    `goods_price`  decimal                                                  DEFAULT NULL COMMENT '商品价格',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 京东订单商品信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_template_region`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_template_region`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_id`  int                                                  DEFAULT NULL COMMENT '运费模板id',
    `region_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大区名称',
    `base_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '基本运费金额',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 区域模板内容
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_bang_log`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_bang_log`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `doctor_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生ID',
    `buyer_id`  int                                                  DEFAULT NULL COMMENT '买家用户ID',
    `status`  int                                                  DEFAULT NULL COMMENT '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    `goods_info`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '处方商品明细',
    `mq`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '消息topic',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 邦指数日志表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_payment_line`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_payment_line`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `payment_status`  int                                                  DEFAULT NULL COMMENT '支付状态: 1 待支付，2 支付成功 3 支付失败',
    `payment_date`  datetime                                                  DEFAULT NULL COMMENT '付款时间',
    `order_transaction_number`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单交易流水号',
    `transaction_number`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '交易流水号',
    `pay_type`  int                                                  DEFAULT NULL COMMENT '收付类型0现金，1虚拟',
    `pay_trade_type`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付子类型',
    `pay_way_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付代码（支付类型代码）',
    `pay_way_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付名称（支付类型名称）',
    `pay_amount`  decimal                                                  DEFAULT NULL COMMENT '本次支付金额',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `pos_sn`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'POS机设备号',
    `combine_amount`  decimal                                                  DEFAULT NULL COMMENT '付款总金额',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单支付
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_assets_relation_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_assets_relation_item`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '权益包订单号/权益卡订单号',
    `order_id`  int                                                  DEFAULT NULL COMMENT '权益包订单id/权益卡订单id',
    `order_item_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '服务包拆分后订单号/权益卡绑定权益包订单号',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '服务包拆分后订单id/权益卡绑定权益包订单id',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单权益商品订单关联表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_jd_info`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_jd_info`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '电商订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '电商订单号',
    `p_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东父单id',
    `jd_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东订单id',
    `freight`  decimal                                                  DEFAULT NULL COMMENT '运费',
    `order_price`  decimal                                                  DEFAULT NULL COMMENT '订单总金额（不包含运费）',
    `order_tax_price`  decimal                                                  DEFAULT NULL COMMENT '订单税额',
    `order_state`  int                                                  DEFAULT NULL COMMENT '订单状态。0为取消订单  1为有效。',
    `state`  int                                                  DEFAULT NULL COMMENT '物流状态。0 是新建  1是妥投   2是拒收',
    `submit_state`  int                                                  DEFAULT NULL COMMENT '预占确认状态。0没确认预占;1已确认预占',
    `jd_order_state`  int                                                  DEFAULT NULL COMMENT '京东订单状态 1.新单;2.等待支付;3.等待支付确认;4.延迟付款确认;5.订单暂停;6.店长最终审核;7.等待打印;8.等待出库;9.等待打包;10.等待发货;11.自提途中;12.上门提货;13.自提退货;14.确认自提;16.等待确认收货;17.配送退货;18.货到付款确认;19.已完成;21.收款确认;22.锁定;29.等待三方出库;30.等待三方发货;31.等待三方发货完成',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `finish_time`  datetime                                                  DEFAULT NULL COMMENT '订单完成时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 京东订单信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_jd_refund`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_jd_refund`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `jd_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东订单id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `refund_id`  int                                                  DEFAULT NULL COMMENT '退单id',
    `refund_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单号',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '订单商品id',
    `mall_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商城sku',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东sku',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `finished_time`  datetime                                                  DEFAULT NULL COMMENT '退单完成时间',
    `customer_expect`  int                                                  DEFAULT NULL COMMENT '10退货，20换货，30维修',
    `status`  int                                                  DEFAULT NULL COMMENT '退单状态 10申请中待审核；20审核完成待收货；30收货完成待处理；40处理完成（如需退款则等待退款）；50待用户确认，60用户确认完成，70取消',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `refund_amount`  decimal                                                  DEFAULT NULL COMMENT '退款金额',
    `address`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货地址合并省市区',
    `buyer_id`  int                                                  DEFAULT NULL COMMENT '买家用户ID',
    `buyer_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者用户名',
    `buyer_tel`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者电话',
    `cancel_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单原因',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 京东退单主表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_inquiry`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_inquiry`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `inquiry_type`  int                                                  DEFAULT NULL COMMENT '处方类型：0后置，1前置，2后置IM 3汉利康',
    `roam_status`  int                                                  DEFAULT NULL COMMENT '处方实际审核流：0 一审，1 二审，2 中宝二审',
    `pres_number`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '处方编号',
    `inquiry_sign`  int                                                  DEFAULT NULL COMMENT '处方标记：0 默认处方，1 主处方',
    `check_flow`  int                                                  DEFAULT NULL COMMENT '审核流：0 默认一审，1 二审，2 中宝二审 3 国大 4 三方',
    `relevance_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '处方关联编号（主处方对应订单关联编号一致，默认处方按订单号存储）',
    `doctor_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生id',
    `doctor_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生名字',
    `prescription_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '处方id',
    `prescription_date`  datetime                                                  DEFAULT NULL COMMENT '处方创建时间',
    `prescribe_result`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊开处方调用结果',
    `original_prescription_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '原处方id',
    `check_status`  int                                                  DEFAULT NULL COMMENT '处方审核状态 0：待审核 1：成功 -1：失败 2：审核中 3：拆方中 4:流转中',
    `check_msg`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '审核消息',
    `second_check_status`  int                                                  DEFAULT NULL COMMENT '处方二审状态：0 无需二审，1 待二审，2 二审中，3 二审成功，4 二审失败',
    `second_check_msg`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '二审消息',
    `result_img`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊结果(图片)',
    `result_pdf`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊结果(pdf)',
    `patient_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人档案id(对接互联网医院的)',
    `patient_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人姓名',
    `patient_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人身份证',
    `patient_photo`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人图片信息',
    `birthday`  date                                                  DEFAULT NULL COMMENT '出生日期',
    `gender`  int                                                  DEFAULT NULL COMMENT '性别 0：未知 1：男，2：女',
    `guard_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '监护人姓名',
    `guard_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '监护人身份证',
    `relation`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '与本人关系（直接存字符串）',
    `medical_history`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '其他病史,多个逗号分隔',
    `illness_offline`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '线下确诊疾病,多个逗号分隔',
    `illness_offline_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '线下确诊疾病id,多个逗号分隔',
    `used_before`  int                                                  DEFAULT NULL COMMENT '曾用过本次药品 0：否 1：是',
    `adverse_reaction`  int                                                  DEFAULT NULL COMMENT '有不良反应 0：否 1：是',
    `treatment_offline`  int                                                  DEFAULT NULL COMMENT '是否复诊/线下医院就诊过 0：否 1：是',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `consult_order_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '互联网医院咨询单号',
    `consult_status`  int                                                  DEFAULT NULL COMMENT '互联网医院问诊单状态:0,无;1,待接诊;2,超时;3,正常结束问诊;4,交流中;5,未开处方且医生主动结束问诊;6,用户退款,关闭问诊单',
    `consult_date`  datetime                                                  DEFAULT NULL COMMENT '互联网医院问诊单创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单问诊记录
 </p>';


DROP TABLE IF EXISTS `db_demo`.`record_jd_msg`;
CREATE TABLE IF NOT EXISTS `db_demo`.`record_jd_msg`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `jd_msg_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东消息id',
    `jd_msg`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '京东消息',
    `msg_type`  int                                                  DEFAULT NULL COMMENT '消息类型',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 京东消息信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`car_shopping`;
CREATE TABLE IF NOT EXISTS `db_demo`.`car_shopping`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `member_id`  int                                                  DEFAULT NULL COMMENT '会员id',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）',
    `count`  int                                                  DEFAULT NULL COMMENT '用户购物车已存放的商品数，限制最大99',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '连锁店ID',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 购物车主表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`rx_compliance_switch_endpoint`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_compliance_switch_endpoint`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `endpoint`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '终端类型 小程序-h5InWx，h5，app-wxMiniApp',
    `endpoint_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '终端名称 小程序-h5InWx，h5，app-wxMiniApp',
    `switch_status`  int                                                  DEFAULT NULL COMMENT '强合规开关：0 关闭，1 开启',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `create_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `update_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 终端强合规开关控制表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`express_subscribe`;
CREATE TABLE IF NOT EXISTS `db_demo`.`express_subscribe`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `sub_platform`  int                                                  DEFAULT NULL COMMENT '订阅平台 1:快递网 2快递100',
    `com_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递公司code(与平台相关)',
    `exp_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `sub_info`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订阅信息',
    `sub_result`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订阅返回值',
    `result_status`  int                                                  DEFAULT NULL COMMENT '是否订阅成功 1成功 0:失败',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 快递订阅记录
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_vaccines_extend`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_vaccines_extend`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `cancel_duration`  int                                                  DEFAULT NULL COMMENT '取消时长',
    `out_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部订单号',
    `out_goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部商品名称',
    `out_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部商品id',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志 1 已删除 0 未删除',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单疫苗扩展表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_region_province`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_region_province`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `province`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '省名称',
    `region_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大区名称',
    `region_id`  int                                                  DEFAULT NULL COMMENT '区域id',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 区域省映射关系
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_template_platform`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_template_platform`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_id`  int                                                  DEFAULT NULL COMMENT '运费模板id',
    `province_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '省份名称',
    `base_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '基本运费⾦额',
    `free_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '免运费阈值',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 平台物流运费模板
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_operation_log`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_operation_log`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `log_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '日志编号',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `refund_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单编号',
    `url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '接口url',
    `trace_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'traceId',
    `operation_channel`  int                                                  DEFAULT NULL COMMENT '操作渠道 1.C端 2.E端 3.B端',
    `operation_type`  int                                                  DEFAULT NULL COMMENT '操作类型 1.发货 2.创建退单 3.同意退货申请 4.确认退单 5.拒绝退单 6.订单列表导出',
    `operation_req`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作入参',
    `operation_result`  int                                                  DEFAULT NULL COMMENT '操作结果 1.成功 2.失败',
    `creator`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单操作日志
 </p>';


DROP TABLE IF EXISTS `db_demo`.`lottery_meeting_user`;
CREATE TABLE IF NOT EXISTS `db_demo`.`lottery_meeting_user`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `oa_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'OAID,如018513',
    `mobile`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '手机号',
    `user_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用户名称',
    `qualification_flag`  int                                                  DEFAULT NULL COMMENT '抽奖资格',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志',
    `created_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 年会抽奖用户表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_batch_ship_req`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_batch_ship_req`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `invoice_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `com_code_kdyb`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递100物流公司ID',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='延迟发货';


DROP TABLE IF EXISTS `db_demo`.`rx_compliance_switch_user`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_compliance_switch_user`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `switch_status`  int                                                  DEFAULT NULL COMMENT '强合规开关：0 关闭，1 开启',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    `tel_phone`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '手机号',
    `create_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `update_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 用户强合规开关控制表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_three_import_fail_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_three_import_fail_item`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `batch_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '批次号',
    `channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道',
    `channel_store_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道店铺名称',
    `channel_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道订单号',
    `channel_product_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道商品名称',
    `channel_product_price`  decimal                                                  DEFAULT NULL COMMENT '渠道售价',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星skuId',
    `order_quantity`  int                                                  DEFAULT NULL COMMENT '下单数量',
    `nick_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '下单人昵称',
    `phone`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '下单人手机号',
    `order_amount`  decimal                                                  DEFAULT NULL COMMENT '订单金额',
    `payment_amount`  decimal                                                  DEFAULT NULL COMMENT '实付金额',
    `order_time`  datetime                                                  DEFAULT NULL COMMENT '下单时间',
    `payment_method`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '支付方式',
    `business_type`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务类型',
    `line_no`  int                                                  DEFAULT NULL COMMENT '行数',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `fail_message`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '失败原因',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星订单号',
    `fosun_goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星商品名称',
    `fosun_supplier_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星供应商名称',
    `fosun_good_kind`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品分类',
    `fosun_goods_spec`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品规格',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '最后修改时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 三方订单批次失败详细表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_share_detail`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_share_detail`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `usage_type`  int                                                  DEFAULT NULL COMMENT '使用类型 0 下单，1 退款',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `refund_order_id`  int                                                  DEFAULT NULL COMMENT '退单id',
    `refund_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单号',
    `pay_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '支付交易单号',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '子订单id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'skuid',
    `sku_num`  int                                                  DEFAULT NULL COMMENT '实购/实退商品数量',
    `share_type`  int                                                  DEFAULT NULL COMMENT '0 商品分摊 1 运费分摊',
    `share_bill_type`  int                                                  DEFAULT NULL COMMENT '分摊费用类型 2 礼品卡 3 优医币 4 邦指数 5 星喜积分 6 永城保险 7 国大保险 18 权益抵扣',
    `share_amount`  decimal                                                  DEFAULT NULL COMMENT '分摊金额',
    `share_quantity`  decimal                                                  DEFAULT NULL COMMENT '分摊主体数量 （如优医币数量，帮指数数量）',
    `share_domain_key`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '分摊主体, 礼品卡卡号',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单抵扣分摊明细
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_global_buy`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_global_buy`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `customs_bill_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '海关清单编号',
    `bill_status`  int                                                  DEFAULT NULL COMMENT '单据状态: 0 默认，1 处理中，2 已放行，3 清关异常',
    `pay_custom_status`  int                                                  DEFAULT NULL COMMENT '支付通关状态 0 未提交 1 未申报，2 申报中，3 申报成功， 4 申报失败',
    `out_status_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部业务单据状态code',
    `out_status_desc`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部业务单据状态描述',
    `out_status_date`  datetime                                                  DEFAULT NULL COMMENT '外部业务单据状态时间',
    `out_dist_status_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部核放单据状态code',
    `out_dist_status_desc`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部核放单据状态描述',
    `out_dist_status_date`  datetime                                                  DEFAULT NULL COMMENT '外部核放单据状态时间',
    `first_push_date`  datetime                                                  DEFAULT NULL COMMENT '首次推送时间',
    `last_push_date`  datetime                                                  DEFAULT NULL COMMENT '最后推送时间',
    `receiver_real_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货人实名',
    `receiver_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货人身份证',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `link_status`  int                                                  DEFAULT NULL COMMENT '链路状态 0 -未执行支付  1-支付推送   2-支付推送失败 3- 支付查询 4-查询失败  5- 物流单号获取  6-物流单号获取失败
 7- 物流单推送海关  8-物流单推送海关失败   9-订单推送  10-订单推送失败 11-订单查询  12- 订单查询失败
 100-推送成功',
    `link_content`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '链路入参数据',
    `link_service_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '当前链路服务名称',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 全球购订单信息表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_express`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_express`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '订单商品id',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `invoice_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `express_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司code',
    `express_company`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司名称',
    `delivery_time`  datetime                                                  DEFAULT NULL COMMENT '发货时间',
    `receiver_time`  datetime                                                  DEFAULT NULL COMMENT '收货时间',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `create_user_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '发货创建人名称',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单物流
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_three_import_success_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_three_import_success_item`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `batch_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '批次号',
    `channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道',
    `channel_store_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道店铺名称',
    `channel_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道订单号',
    `channel_product_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道商品名称',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星skuId',
    `channel_product_price`  decimal                                                  DEFAULT NULL COMMENT '渠道售价',
    `order_quantity`  int                                                  DEFAULT NULL COMMENT '下单数量',
    `nick_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '下单人昵称',
    `phone`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '下单人手机号',
    `order_amount`  decimal                                                  DEFAULT NULL COMMENT '订单金额',
    `payment_amount`  decimal                                                  DEFAULT NULL COMMENT '实付金额',
    `order_time`  datetime                                                  DEFAULT NULL COMMENT '下单时间',
    `payment_method`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '支付方式',
    `business_type`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务类型',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `line_no`  int                                                  DEFAULT NULL COMMENT '行数',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星订单号',
    `status`  int                                                  DEFAULT NULL COMMENT '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    `refund_flag`  int                                                  DEFAULT NULL COMMENT '退款标识 0.无退款 1.有退款',
    `fosun_goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星商品名称',
    `fosun_supplier_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '复星供应商名称',
    `fosun_good_kind`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品分类',
    `fosun_goods_spec`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品规格',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '最后修改时间',
    `match_flag`  int                                                  DEFAULT NULL COMMENT '是否匹配为正式订单是否匹配为正式订单，0未匹配，1匹配，2全部作废，3部分作废',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `order_import_status`  int                                                  DEFAULT NULL COMMENT '订单导入状态0未导入，1导入',
    `refund_amount`  decimal                                                  DEFAULT NULL COMMENT '退款金额',
    `sms_flag`  int                                                  DEFAULT NULL COMMENT '短信发送标识 0 否 1 是',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 三方订单批次成功详细表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_promotion`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_promotion`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_id`  int                                                  DEFAULT NULL COMMENT 'order表id',
    `promotion_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部促销id，由促销系统提供',
    `promotion_type`  int                                                  DEFAULT NULL COMMENT '促销类型，由促销系统提供0优惠券，1活动，2国大保险，3永诚保险，4积分，5优惠码',
    `promotion_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '促销名称，由促销系统提供',
    `promotion_discount_amount`  decimal                                                  DEFAULT NULL COMMENT '促销优惠金额',
    `promotion_description`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '促销描述信息，由促销系统提供',
    `promotion_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '促销券码，由促销系统提供',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '促销平台',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志 1 已删除 0 未删除',
    `coupon_platform`  int                                                  DEFAULT NULL COMMENT '优惠券平台类型 默认1:店铺券，2:平台券',
    `promotion_sub_type`  int                                                  DEFAULT NULL COMMENT '促销子类型 优惠券类型 1 满减劵 2 折扣券 3 现金券, 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 0国大保险 12永诚保险 13健康积分 14优惠码',
    `promotion_sub_type_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '促销子类型名称',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单关联促销表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`lottery_batchno_generator`;
CREATE TABLE IF NOT EXISTS `db_demo`.`lottery_batchno_generator`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `created_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 年会抽奖批次号生成
 </p>';


DROP TABLE IF EXISTS `db_demo`.`carriage_template_content`;
CREATE TABLE IF NOT EXISTS `db_demo`.`carriage_template_content`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_id`  int                                                  DEFAULT NULL COMMENT '运费模板id',
    `region_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大区名称',
    `base_carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '基本运费金额',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 运费模板内容
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_goods_statistics`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_goods_statistics`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `goods_id`  int                                                  DEFAULT NULL COMMENT 'goods id',
    `sale_amount`  int                                                  DEFAULT NULL COMMENT '销售量',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单商品销售量
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_refund_payment_line`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_refund_payment_line`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `refund_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单号',
    `refund_payment_status`  int                                                  DEFAULT NULL COMMENT '支付状态: 1 待支付，2 支付成功 3 支付失败',
    `refund_payment_date`  datetime                                                  DEFAULT NULL COMMENT '付款时间',
    `order_transaction_number`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单交易流水号',
    `transaction_number`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '交易流水号',
    `pay_type`  int                                                  DEFAULT NULL COMMENT '收付类型 0现金，1虚拟',
    `pay_way_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付代码（支付类型代码）',
    `pay_way_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收付名称（支付类型名称）',
    `pay_amount`  decimal                                                  DEFAULT NULL COMMENT '本次支付金额(退款)',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 退单支付
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_three_refund`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_three_refund`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `channel_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '三方渠道订单',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退款skuId',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `refund_amount`  decimal                                                  DEFAULT NULL COMMENT '单次退款金额',
    `refund_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退款原因',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `create_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人名称',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 三方订单退款记录表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`trade_order`;
CREATE TABLE IF NOT EXISTS `db_demo`.`trade_order`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `parent_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '父单号（多订单提交生成新父单号，单订单提交与订单号一致）',
    `status`  int                                                  DEFAULT NULL COMMENT '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    `order_type`  int                                                  DEFAULT NULL COMMENT '订单类型0 默认，1 全球购，2 权益包，3 疫苗，4 o2o，5 连锁，6 云药房 7 连锁供应链',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `total_amount`  decimal                                                  DEFAULT NULL COMMENT '订单总金额',
    `discount_amount`  decimal                                                  DEFAULT NULL COMMENT '优惠总金额',
    `pay_dis_amount`  decimal                                                  DEFAULT NULL COMMENT '支付通道扣减金额（非现金）',
    `carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '运费',
    `payment_amount`  decimal                                                  DEFAULT NULL COMMENT '订单应付金额',
    `buyer_id`  int                                                  DEFAULT NULL COMMENT '买家用户ID',
    `buyer_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者用户名',
    `buyer_tel`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '购买者电话',
    `receiver_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货人姓名',
    `receiver_tel`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货人电话',
    `receiver_time`  datetime                                                  DEFAULT NULL COMMENT '订单收货时间',
    `province`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '省',
    `city`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '市',
    `area`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '区',
    `address`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '收货人详细地址',
    `evaluation_status`  int                                                  DEFAULT NULL COMMENT '评价状态 0 未评价 1 已评价',
    `evaluation_time`  datetime                                                  DEFAULT NULL COMMENT '评价时间',
    `delivery_time`  datetime                                                  DEFAULT NULL COMMENT '发货时间',
    `finished_time`  datetime                                                  DEFAULT NULL COMMENT '订单完成时间',
    `anonymous`  int                                                  DEFAULT NULL COMMENT '是否匿名',
    `postscript`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单留言',
    `cancel_reason`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '取消订单原因',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
    `supplier_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商名称',
    `chain_shop_id`  int                                                  DEFAULT NULL COMMENT '连锁店id',
    `chain_shop_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '连锁店名称',
    `retail_shop_id`  int                                                  DEFAULT NULL COMMENT '门店id',
    `retail_shop_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '门店名称',
    `supplier_full_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商全称',
    `original_system`  int                                                  DEFAULT NULL COMMENT '是否老系统：1 是  0  否',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `deduction_amount`  decimal                                                  DEFAULT NULL COMMENT '抵扣金额',
    `deduction_score_amount`  decimal                                                  DEFAULT NULL COMMENT '抵扣金额（优医币，邦指数）',
    `deduction_card_amount`  decimal                                                  DEFAULT NULL COMMENT '抵扣金额（礼品卡）',
    `health_coin`  int                                                  DEFAULT NULL COMMENT '抵扣优医币',
    `bang_coin`  int                                                  DEFAULT NULL COMMENT '抵扣邦指数',
    `out_member_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大会员系统的会员id',
    `channel_source`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道来源',
    `endpoint`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '终端类型 h5InWx，h5，wxMiniApp',
    `external_value`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部参数（根据外部需求放入）',
    `refund_flag`  int                                                  DEFAULT NULL COMMENT '退款标识 0.无退款 1.有退款',
    `cancel_time`  datetime                                                  DEFAULT NULL COMMENT '订单取消时间',
    `system_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    `service_platform`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务平台 0 星苗自营、1天猫、2京东、3百度、4腾讯、5其他、7快手、6抖音、8网易严选、9口碑、10 医鹿',
    `service_channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务渠道（渠道id）',
    `order_comment`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单备注，仅供后台使用，无业务交互',
    `comment_time`  datetime                                                  DEFAULT NULL COMMENT '订单备注时间，编辑备注覆盖',
    `global_activity_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '全局活动id',
    `global_channel_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '全局渠道id',
    `assets_type`  int                                                  DEFAULT NULL COMMENT '权益订单子类型：0 默认，1 普通权益包，2 实体卡，3 电子卡，4 实体卡激活权益包，
 5 电子卡激活权益包 6 礼品卡电子卡 7 礼品卡实体卡   8 权益包升级，9三方权益订单  100006.基因检测发放 100007.体检发放 100008.苏可欣发放',
    `delivery_type`  int                                                  DEFAULT NULL COMMENT '0默认物流，1o2o在线配送，2自提',
    `merchant_type`  int                                                  DEFAULT NULL COMMENT '商家类型 0 其他  1 MP  2 入仓  3 DSV',
    `self_flag`  int                                                  DEFAULT NULL COMMENT '是否自营供应商 0 非自营 1 自营',
    `business_flag`  int                                                  DEFAULT NULL COMMENT '业务标识 1保险 2云DTP 3一体化DTP',
    `receiver_lat`  decimal                                                  DEFAULT NULL COMMENT '收货地址纬度',
    `receiver_lng`  decimal                                                  DEFAULT NULL COMMENT '收货地址经度',
    `org_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '机构编码',
    `org_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '机构名称',
    `wms_warehouse_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '仓库id',
    `wms_warehouse_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '仓库名称',
    `client_type`  int                                                  DEFAULT NULL COMMENT '终端类型
 1.小程序原生页面 2.ios原生的页面 3.android原生的页面 4.h5页面在微信小程序里打开 5.h5页面在微信浏览器中打开，不包括微信小程序 6.不在上述情况下的值',
    `device_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '应用名称',
    `distribution_flag`  int                                                  DEFAULT NULL COMMENT '是否参与分销 0否,1是 （分销信息见order_extend）',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单主表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_extend`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_extend`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `insurance_service_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '保障服务id',
    `insurance_service_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '保障服务code',
    `insurance_service_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '保障服务名称',
    `pay_url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '支付跳转链接',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `self_lifting_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '核销码',
    `self_lifting_code_status`  int                                                  DEFAULT NULL COMMENT '1 已核销，0为核销',
    `third_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '三方订单号(复联)',
    `audiologist_out_member_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '听力师id',
    `order_audiologist_type`  int                                                  DEFAULT NULL COMMENT '听力师订单类型 0推荐订单 1代下订单',
    `third_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '三方商户编码',
    `area_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '区域编码',
    `day_serial_number`  int                                                  DEFAULT NULL COMMENT '店铺每日订单序号',
    `inquiry_review`  int                                                  DEFAULT NULL COMMENT '处方是否需要二审 0:不需要  1：需要',
    `reserved_mobile`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '自提预留手机号',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单附加信息表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_item_assorted_detail`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_item_assorted_detail`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '编号;主键',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单唯一编号;订单主键',
    `item_id`  int                                                  DEFAULT NULL COMMENT '商品唯一编号;订单商品主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号;订单号',
    `goods_id`  int                                                  DEFAULT NULL COMMENT 'SPU编号;goods id',
    `goods_item_id`  int                                                  DEFAULT NULL COMMENT '商品系统item_id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '主品SKUID',
    `son_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '子品sku id',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '名称;商品名称',
    `goods_spec`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '规格;商品规格',
    `goods_unit`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '单位;商品单位：盒、袋',
    `main_pic`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '主图;列表的主图',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '数量;商品数量',
    `retail_price`  decimal                                                  DEFAULT NULL COMMENT '零售价;零售价',
    `purchase_price`  decimal                                                  DEFAULT NULL COMMENT '进货价;进货价',
    `total_amount`  decimal                                                  DEFAULT NULL COMMENT '总金额;商品金额',
    `share_amount`  decimal                                                  DEFAULT NULL COMMENT '分摊金额;商品分摊金额',
    `assorted_flag`  int                                                  DEFAULT NULL COMMENT '是否主品;是否主品 0否,1是',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间;创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单商品-组合商品明细
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_comment`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_comment`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `comment_content`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注内容',
    `create_user_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人名称',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_user_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '修改人名称',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单备注表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`letter_box`;
CREATE TABLE IF NOT EXISTS `db_demo`.`letter_box`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增长，步长＝1',
    `letter_type`  int                                                  DEFAULT NULL COMMENT '类型 0 普通信件',
    `letter_status`  int                                                  DEFAULT NULL COMMENT '0 未处理（默认）；1 处理失败；2 处理成功',
    `service_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '回调服务名称',
    `content`  varchar(768) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '消息体',
    `message_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '消息id',
    `update_date`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
    `create_date`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 消息投递
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_refund_voucher`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_refund_voucher`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `refund_voucher_url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退款凭证管理',
    `refund_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '退单号',
    `system_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    `service_platform`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务平台（jd，tm,zy）',
    `service_channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '业务渠道（渠道id）',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志 1 已删除 0 未删除',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单退款凭证关联表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`rx_compliance_switch_sku`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_compliance_switch_sku`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    `item_id`  int                                                  DEFAULT NULL COMMENT 'itemid',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `create_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `update_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 sku强合规开关控制表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`car_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`car_item`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `car_id`  int                                                  DEFAULT NULL COMMENT '购物车id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `number`  int                                                  DEFAULT NULL COMMENT '数量',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '门店ID',
    `activity_id`  int                                                  DEFAULT NULL COMMENT '活动id',
    `goods_type`  int                                                  DEFAULT NULL COMMENT '商品类型 0:普通商品 1：加购商品',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '最后修改时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 购物车商品表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`rx_compliance_switch`;
CREATE TABLE IF NOT EXISTS `db_demo`.`rx_compliance_switch`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `switch_status`  int                                                  DEFAULT NULL COMMENT '强合规开关：0 关闭，1 开启',
    `remark`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '备注',
    `platform_id`  int                                                  DEFAULT NULL COMMENT '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    `system_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    `system_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '系统来源名称0 商城，1疫苗，2三方订单，3DTP，4复联，5国大，6听力师',
    `create_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建人',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `update_user`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '操作人',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 强合规开关控制表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_yaofang_split`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_yaofang_split`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `original_order_id`  int                                                  DEFAULT NULL COMMENT '原订单id',
    `original_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '原订单号',
    `split_order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '分单订单号',
    `inquiry_type`  int                                                  DEFAULT NULL COMMENT '处方类型：0后置，1前置',
    `goods_id`  int                                                  DEFAULT NULL COMMENT 'goods id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `out_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部skuId',
    `invoice_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `express_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司code',
    `express_company`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司名称',
    `delivery_time`  datetime                                                  DEFAULT NULL COMMENT '发货时间',
    `receiver_time`  datetime                                                  DEFAULT NULL COMMENT '收货时间',
    `prescription_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '处方id',
    `check_status`  int                                                  DEFAULT NULL COMMENT '处方审核状态 0：待审核 1：成功 -1：失败 2：审核中',
    `check_msg`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '审核消息',
    `result_img`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊结果(图片)',
    `result_pdf`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊结果(pdf)',
    `patient_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人档案id(对接互联网医院的)',
    `doctor_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生名字',
    `doctor_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生id',
    `patient_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人姓名',
    `patient_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人身份证',
    `patient_photo`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用药人图片信息',
    `birthday`  date                                                  DEFAULT NULL COMMENT '出生日期',
    `gender`  int                                                  DEFAULT NULL COMMENT '性别 0：未知 1：男，2：女',
    `guard_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '监护人姓名',
    `guard_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '监护人身份证',
    `relation`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '与本人关系（直接存字符串）',
    `medical_history`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '其他病史,多个逗号分隔',
    `illness_offline`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '线下确诊疾病,多个逗号分隔',
    `illness_offline_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '线下确诊疾病id,多个逗号分隔',
    `used_before`  int                                                  DEFAULT NULL COMMENT '曾用过本次药品 0：否 1：是',
    `adverse_reaction`  int                                                  DEFAULT NULL COMMENT '有不良反应 0：否 1：是',
    `treatment_offline`  int                                                  DEFAULT NULL COMMENT '线下医院就诊过 0：否 1：是',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `prescribe_result`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '问诊开处方调用结果',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 药房网订单分单表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`express_company`;
CREATE TABLE IF NOT EXISTS `db_demo`.`express_company`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `express_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司code',
    `express_company`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流公司名称',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `com_code_kdw`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递网物流公司code',
    `com_code_kdyb`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递100物流公司ID',
    `default_flag`  int                                                  DEFAULT NULL COMMENT '是否默认 0默认 1 不默认(用于第三方模糊匹配重复的场景)',
    `oms_express_company_id`  int                                                  DEFAULT NULL COMMENT 'oms快递公司id',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 物流公司
 </p>';


DROP TABLE IF EXISTS `db_demo`.`promotion_order_goods`;
CREATE TABLE IF NOT EXISTS `db_demo`.`promotion_order_goods`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
    `activity_type`  int                                                  DEFAULT NULL COMMENT '活动类型,1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券',
    `activity_id`  int                                                  DEFAULT NULL COMMENT '活动表id',
    `coupon_id`  int                                                  DEFAULT NULL COMMENT '优惠券活动表id',
    `coupon_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '优惠券号',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `retail_price`  decimal                                                  DEFAULT NULL COMMENT '零售价',
    `activity_price`  decimal                                                  DEFAULT NULL COMMENT '促销价',
    `discount_amount`  decimal                                                  DEFAULT NULL COMMENT '促销优惠总金额',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单关联的促销活动的商品信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_assets_extend`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_assets_extend`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '订单号',
    `assets_package_id`  bigint                                                  DEFAULT NULL COMMENT '权益包id',
    `assets_card_template_id`  int                                                  DEFAULT NULL COMMENT '权益卡模板id',
    `assets_card_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '权益卡号',
    `patient_id`  int                                                  DEFAULT NULL COMMENT '患者id',
    `patient_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '患者姓名',
    `patient_id_card`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '患者身份证号',
    `patient_phone_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '患者手机号',
    `doctor_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生id',
    `doctor_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '医生姓名',
    `original_package_instance_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '源服务包实例id',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `delete_flag`  int                                                  DEFAULT NULL COMMENT '删除标志 1 已删除 0 未删除',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
    `assets_package_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '权益包名称',
    `goods_type`  int                                                  DEFAULT NULL COMMENT '2 医生端服务包，3 运营创建服务包',
    `group_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '组id',
    `activate_begin_time`  datetime                                                  DEFAULT NULL COMMENT '权益创建0元包的时候传入的有效期开始时间',
    `activate_end_time`  datetime                                                  DEFAULT NULL COMMENT '权益创建0元包的时候传入的有效期退款时间',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'skuId',
    `order_item_id`  int                                                  DEFAULT NULL COMMENT '详情订单信息',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单权益扩展表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`express_record`;
CREATE TABLE IF NOT EXISTS `db_demo`.`express_record`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `com_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递公司code',
    `com_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递公司名称',
    `exp_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '快递单号',
    `state`  int                                                  DEFAULT NULL COMMENT '快递单当前签收状态，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转单，10待清关，11清关中，12已清关，13清关异常，14收件人拒签',
    `return_status`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '返回快递单监控状态 polling:监控，shutdown:结束（已签收），abort:中止，updateall:重新推送',
    `return_msg`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '返回msg',
    `return_result`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '返回的结果',
    `record`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '物流轨迹信息',
    `sign_time`  datetime                                                  DEFAULT NULL COMMENT '签收时间',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 快递记录信息
 </p>';


DROP TABLE IF EXISTS `db_demo`.`goods_carriage_template`;
CREATE TABLE IF NOT EXISTS `db_demo`.`goods_carriage_template`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `template_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '运费模板名称',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
    `carriage_type`  int                                                  DEFAULT NULL COMMENT '配送类型 0:自定义配送 1:全国配送',
    `carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '全国默认运费',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `create_userid`  int                                                  DEFAULT NULL COMMENT '创建者id',
    `create_username`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '创建者',
    `template_type`  int                                                  DEFAULT NULL COMMENT '模板类型 1:b2c 2:O2O配送 3:自提',
    `template_status`  int                                                  DEFAULT NULL COMMENT '有效状态 0:无效',
    `start_distance`  double                                                  DEFAULT NULL COMMENT '起始距离(单位 米)',
    `end_distance`  double                                                  DEFAULT NULL COMMENT '结束距离(单位 米)',
    `start_time`  time                                                  DEFAULT NULL COMMENT '开始配送时间',
    `end_time`  time                                                  DEFAULT NULL COMMENT '最后结束时间',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 商品运费模板
 </p>';


DROP TABLE IF EXISTS `db_demo`.`order_item`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_item`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`  int                                                  DEFAULT NULL COMMENT '订单id',
    `goods_id`  int                                                  DEFAULT NULL COMMENT 'goods id',
    `sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'sku id',
    `goods_item_id`  int                                                  DEFAULT NULL COMMENT '商品系统item_id',
    `out_sku_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '外部skuId',
    `goods_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品名称',
    `common_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '通用名',
    `goods_spec`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品规格',
    `goods_unit`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品单位：盒、袋',
    `otc_type`  int                                                  DEFAULT NULL COMMENT 'OTC类别 1 甲类OTC 2 乙类OTC',
    `goods_kind`  int                                                  DEFAULT NULL COMMENT '商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品',
    `org_goods_kind`  int                                                  DEFAULT NULL COMMENT '原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通 21:疫苗（新）22:核酸检测',
    `goods_type`  int                                                  DEFAULT NULL COMMENT '商品类型:0 默认，1 全球购，2医生端权益，3消费端权益，4 疫苗',
    `stock`  int                                                  DEFAULT NULL COMMENT '库存',
    `medicine_standard`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '国药准字',
    `retail_price`  decimal                                                  DEFAULT NULL COMMENT '零售价',
    `purchase_price`  decimal                                                  DEFAULT NULL COMMENT '进货价',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
    `supplier_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商名称',
    `supplier_full_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '供应商全称',
    `enable_rx`  int                                                  DEFAULT NULL COMMENT '医生开处方 1 可以开处方 0 不可以开处方',
    `rx_type`  int                                                  DEFAULT NULL COMMENT '处方药类型',
    `show_type`  int                                                  DEFAULT NULL COMMENT '显示方式 0 不显示 1 线上',
    `drug_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '药品名',
    `wb_drug`  int                                                  DEFAULT NULL COMMENT '是否万邦药 0 不是， 1 是',
    `drug_id`  int                                                  DEFAULT NULL COMMENT '药品id',
    `commission`  decimal                                                  DEFAULT NULL COMMENT '佣金点数',
    `main_pic`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '列表的主图',
    `goods_num`  int                                                  DEFAULT NULL COMMENT '商品数量',
    `total_amount`  decimal                                                  DEFAULT NULL COMMENT '商品金额',
    `share_amount`  decimal                                                  DEFAULT NULL COMMENT '商品分摊金额',
    `discount_amount`  decimal                                                  DEFAULT NULL COMMENT '优惠金额',
    `pay_dis_amount`  decimal                                                  DEFAULT NULL COMMENT '支付通道扣减金额（非现金）',
    `carriage_amount`  decimal                                                  DEFAULT NULL COMMENT '分摊运费，计最后一个商品',
    `category_one`  int                                                  DEFAULT NULL COMMENT '一级类目',
    `category_one_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '一级类目名称',
    `category_two`  int                                                  DEFAULT NULL COMMENT '二级类目',
    `category_two_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '二级类目名称',
    `one_category_id`  int                                                  DEFAULT NULL COMMENT '后台一级类目id',
    `one_category_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '后台一级类目名称',
    `two_category_id`  int                                                  DEFAULT NULL COMMENT '后台二级类目id',
    `two_category_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '后台二级类目名称',
    `three_category_id`  int                                                  DEFAULT NULL COMMENT '后台三级类目id',
    `three_category_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '后台三级类目名称',
    `goods_onshelf_id`  int                                                  DEFAULT NULL COMMENT '商品上架的id',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '创建时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
    `item_internal_type`  int                                                  DEFAULT NULL COMMENT 'item内部项类型：0默认商品，1运费',
    `gift_flag`  int                                                  DEFAULT NULL COMMENT '赠品标识 默认0 否，1加购，2赠品',
    `gift_status`  int                                                  DEFAULT NULL COMMENT '赠品状态 默认0 满足赠送条件，1 不满足赠送条件',
    `buy_flag`  int                                                  DEFAULT NULL COMMENT '商详也是否可购买 0 否 1 是',
    `merchant_type`  int                                                  DEFAULT NULL COMMENT '商家类型 0 其他  1 MP  2 入仓  3 DSV',
    `self_flag`  int                                                  DEFAULT NULL COMMENT '是否自营供应商 0 非自营 1 自营',
    `business_flag`  int                                                  DEFAULT NULL COMMENT '业务标识 1保险 2云DTP 3一体化DTP',
    `barcode`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '商品条形码',
    `insure_pay_sign`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '摘要签名',
    `share_discount_code_amount`  decimal                                                  DEFAULT NULL COMMENT '虚拟优惠码分摊金额',
    `department_channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道部门',
    `distribution_activity_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '分销活动编号',
    `distribution_out_member_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '所属分销员编号',
    `assorted_flag`  int                                                  DEFAULT NULL COMMENT '是否组合商品 0否 1是',
    `warehouse_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '发货仓库编码',
    `warehouse_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '发货仓库名称',
    `send_supplier_code`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '代发供应商编码',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 订单商品表
 </p>';


DROP TABLE IF EXISTS `db_demo`.`region_province_mapping`;
CREATE TABLE IF NOT EXISTS `db_demo`.`region_province_mapping`
(
    `id`  int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `province`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '省名称',
    `region_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '大区名称',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 区域省的映射关系
 </p>';


DROP TABLE IF EXISTS `db_demo`.`near_pharmacy_dto`;
CREATE TABLE IF NOT EXISTS `db_demo`.`near_pharmacy_dto`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
    `abbr_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '简称',
    `full_name`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '全称',
    `distance`  double                                                  DEFAULT NULL COMMENT '距离',
    `logo_url`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT 'logo图片',
    `template_type`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '1:b2c 2:O2O配送 3:自提',
    `lng`  double                                                  DEFAULT 0.0 COMMENT '店铺经度',
    `lat`  double                                                  DEFAULT 0.0 COMMENT '店铺纬度',
    `start_distance`  decimal                                                  DEFAULT NULL COMMENT '起始距离(单位 米)',
    `end_distance`  decimal                                                  DEFAULT NULL COMMENT '结束距离(单位 米)',
    `start_time`  time                                                  DEFAULT NULL COMMENT '开始配送时间',
    `end_time`  time                                                  DEFAULT NULL COMMENT '最后结束时间',
    `supplier_id`  int                                                  DEFAULT NULL COMMENT '供应商id',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='';


DROP TABLE IF EXISTS `db_demo`.`order_three_import_batch`;
CREATE TABLE IF NOT EXISTS `db_demo`.`order_three_import_batch`
(
    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `batch_no`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '批次号',
    `channel`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '渠道',
    `create_time`  datetime                                                  DEFAULT NULL COMMENT '批次导入时间',
    `success_number`  int                                                  DEFAULT NULL COMMENT '校验成功数',
    `import_total_number`  int                                                  DEFAULT NULL COMMENT '导入总数',
    `fail_number`  int                                                  DEFAULT NULL COMMENT '校验失败数',
    `order_import_status`  int                                                  DEFAULT NULL COMMENT '订单导入状态0未导入，1导入',
    `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
    `del_flag`  int                                                  DEFAULT NULL COMMENT '是否删除  1 是  0  否',
PRIMARY KEY (`id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci COMMENT ='<p>
 三方订单导入批次表
 </p>';

