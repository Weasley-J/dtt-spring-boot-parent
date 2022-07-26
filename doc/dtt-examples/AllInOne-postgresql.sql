DROP TABLE IF EXISTS "dtt_demo"."public"."order_payment_line";
CREATE TABLE "dtt_demo"."public"."order_payment_line"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "payment_status"    INTEGER DEFAULT NULL,
    "payment_date"    TIMESTAMP DEFAULT NULL,
    "order_transaction_number"    VARCHAR(64) DEFAULT NULL,
    "transaction_number"    VARCHAR(64) DEFAULT NULL,
    "pay_type"    INTEGER DEFAULT NULL,
    "pay_trade_type"    VARCHAR(256) DEFAULT NULL,
    "pay_way_code"    VARCHAR(64) DEFAULT NULL,
    "pay_way_name"    VARCHAR(64) DEFAULT NULL,
    "pay_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "pos_sn"    VARCHAR(256) DEFAULT NULL,
    "combine_amount"    money DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_payment_line" IS '<p>
 订单支付
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."payment_status" IS '支付状态: 1 待支付，2 支付成功 3 支付失败';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."payment_date" IS '付款时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."order_transaction_number" IS '订单交易流水号';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."transaction_number" IS '交易流水号';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pay_type" IS '收付类型0现金，1虚拟';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pay_trade_type" IS '收付子类型';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pay_way_code" IS '收付代码（支付类型代码）';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pay_way_name" IS '收付名称（支付类型名称）';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pay_amount" IS '本次支付金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."pos_sn" IS 'POS机设备号';
COMMENT ON COLUMN "dtt_demo"."public"."order_payment_line"."combine_amount" IS '付款总金额';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_vaccines_extend";
CREATE TABLE "dtt_demo"."public"."order_vaccines_extend"
(
    "id"      bigserial   PRIMARY KEY,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "cancel_duration"    INTEGER DEFAULT NULL,
    "out_order_no"    VARCHAR(64) DEFAULT NULL,
    "out_goods_name"    VARCHAR(64) DEFAULT NULL,
    "out_sku_id"    VARCHAR(64) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."order_vaccines_extend" IS '<p>
 订单疫苗扩展表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."cancel_duration" IS '取消时长';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."out_order_no" IS '外部订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."out_goods_name" IS '外部商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."out_sku_id" IS '外部商品id';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."delete_flag" IS '删除标志 1 已删除 0 未删除';
COMMENT ON COLUMN "dtt_demo"."public"."order_vaccines_extend"."update_time" IS '更新时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."express_record";
CREATE TABLE "dtt_demo"."public"."express_record"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "com_code"    VARCHAR(64) DEFAULT NULL,
    "com_name"    VARCHAR(64) DEFAULT NULL,
    "exp_no"    VARCHAR(64) DEFAULT NULL,
    "state"    INTEGER DEFAULT NULL,
    "return_status"    VARCHAR(256) DEFAULT NULL,
    "return_msg"    VARCHAR(512) DEFAULT NULL,
    "return_result"    VARCHAR(256) DEFAULT NULL,
    "record"    VARCHAR(256) DEFAULT NULL,
    "sign_time"    TIMESTAMP DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."express_record" IS '<p>
 快递记录信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."com_code" IS '快递公司code';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."com_name" IS '快递公司名称';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."exp_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."state" IS '快递单当前签收状态，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转单，10待清关，11清关中，12已清关，13清关异常，14收件人拒签';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."return_status" IS '返回快递单监控状态 polling:监控，shutdown:结束（已签收），abort:中止，updateall:重新推送';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."return_msg" IS '返回msg';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."return_result" IS '返回的结果';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."record" IS '物流轨迹信息';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."sign_time" IS '签收时间';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."express_record"."update_time" IS '更新时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_item_assorted_detail";
CREATE TABLE "dtt_demo"."public"."order_item_assorted_detail"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "item_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "goods_id"    INTEGER DEFAULT NULL,
    "goods_item_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "son_sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "goods_spec"    VARCHAR(256) DEFAULT NULL,
    "goods_unit"    VARCHAR(256) DEFAULT NULL,
    "main_pic"    VARCHAR(256) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "retail_price"    money DEFAULT NULL,
    "purchase_price"    money DEFAULT NULL,
    "total_amount"    money DEFAULT NULL,
    "share_amount"    money DEFAULT NULL,
    "assorted_flag"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_item_assorted_detail" IS '<p>
 订单商品-组合商品明细
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."id" IS '编号；主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."order_id" IS '订单唯一编号；订单主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."item_id" IS '商品唯一编号；订单商品主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."order_no" IS '订单号；订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_id" IS 'SPU编号；goods id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_item_id" IS '商品系统item_id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."sku_id" IS '主品SKUID';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."son_sku_id" IS '子品sku id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_name" IS '名称；商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_spec" IS '规格；商品规格';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_unit" IS '单位；商品单位：盒、袋';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."main_pic" IS '主图；列表的主图';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."goods_num" IS '数量；商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."retail_price" IS '零售价；零售价';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."purchase_price" IS '进货价；进货价';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."total_amount" IS '总金额；商品金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."share_amount" IS '分摊金额；商品分摊金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."assorted_flag" IS '是否主品；是否主品 0否,1是';
COMMENT ON COLUMN "dtt_demo"."public"."order_item_assorted_detail"."create_time" IS '创建时间；创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_refund_payment_line";
CREATE TABLE "dtt_demo"."public"."order_refund_payment_line"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "refund_no"    VARCHAR(64) DEFAULT NULL,
    "refund_payment_status"    INTEGER DEFAULT NULL,
    "refund_payment_date"    TIMESTAMP DEFAULT NULL,
    "order_transaction_number"    VARCHAR(64) DEFAULT NULL,
    "transaction_number"    VARCHAR(64) DEFAULT NULL,
    "pay_type"    INTEGER DEFAULT NULL,
    "pay_way_code"    VARCHAR(64) DEFAULT NULL,
    "pay_way_name"    VARCHAR(64) DEFAULT NULL,
    "pay_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_refund_payment_line" IS '<p>
 退单支付
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."refund_no" IS '退单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."refund_payment_status" IS '支付状态: 1 待支付，2 支付成功 3 支付失败';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."refund_payment_date" IS '付款时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."order_transaction_number" IS '订单交易流水号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."transaction_number" IS '交易流水号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."pay_type" IS '收付类型 0现金，1虚拟';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."pay_way_code" IS '收付代码（支付类型代码）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."pay_way_name" IS '收付名称（支付类型名称）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."pay_amount" IS '本次支付金额(退款)';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_payment_line"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_yaofang_split";
CREATE TABLE "dtt_demo"."public"."order_yaofang_split"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "original_order_id"    INTEGER DEFAULT NULL,
    "original_order_no"    VARCHAR(64) DEFAULT NULL,
    "split_order_no"    VARCHAR(64) DEFAULT NULL,
    "inquiry_type"    INTEGER DEFAULT NULL,
    "goods_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "out_sku_id"    VARCHAR(64) DEFAULT NULL,
    "invoice_no"    VARCHAR(64) DEFAULT NULL,
    "express_code"    VARCHAR(64) DEFAULT NULL,
    "express_company"    VARCHAR(256) DEFAULT NULL,
    "delivery_time"    TIMESTAMP DEFAULT NULL,
    "receiver_time"    TIMESTAMP DEFAULT NULL,
    "prescription_id"    VARCHAR(64) DEFAULT NULL,
    "check_status"    INTEGER DEFAULT NULL,
    "check_msg"    VARCHAR(512) DEFAULT NULL,
    "result_img"    VARCHAR(256) DEFAULT NULL,
    "result_pdf"    VARCHAR(256) DEFAULT NULL,
    "patient_id"    VARCHAR(64) DEFAULT NULL,
    "doctor_name"    VARCHAR(64) DEFAULT NULL,
    "doctor_id"    VARCHAR(64) DEFAULT NULL,
    "patient_name"    VARCHAR(64) DEFAULT NULL,
    "patient_id_card"    VARCHAR(64) DEFAULT NULL,
    "patient_photo"    VARCHAR(256) DEFAULT NULL,
    "birthday"    DATE DEFAULT NULL,
    "gender"    INTEGER DEFAULT NULL,
    "guard_name"    VARCHAR(64) DEFAULT NULL,
    "guard_id_card"    VARCHAR(64) DEFAULT NULL,
    "relation"    VARCHAR(256) DEFAULT NULL,
    "medical_history"    VARCHAR(256) DEFAULT NULL,
    "illness_offline"    VARCHAR(256) DEFAULT NULL,
    "illness_offline_id"    VARCHAR(64) DEFAULT NULL,
    "used_before"    INTEGER DEFAULT NULL,
    "adverse_reaction"    INTEGER DEFAULT NULL,
    "treatment_offline"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "prescribe_result"    VARCHAR(256) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_yaofang_split" IS '<p>
 药房网订单分单表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."original_order_id" IS '原订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."original_order_no" IS '原订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."split_order_no" IS '分单订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."inquiry_type" IS '处方类型：0后置，1前置';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."goods_id" IS 'goods id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."out_sku_id" IS '外部skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."invoice_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."express_code" IS '物流公司code';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."express_company" IS '物流公司名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."delivery_time" IS '发货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."receiver_time" IS '收货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."prescription_id" IS '处方id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."check_status" IS '处方审核状态 0：待审核 1：成功 -1：失败 2：审核中';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."check_msg" IS '审核消息';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."result_img" IS '问诊结果(图片)';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."result_pdf" IS '问诊结果(pdf)';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."patient_id" IS '用药人档案id(对接互联网医院的)';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."doctor_name" IS '医生名字';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."doctor_id" IS '医生id';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."patient_name" IS '用药人姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."patient_id_card" IS '用药人身份证';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."patient_photo" IS '用药人图片信息';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."birthday" IS '出生日期';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."gender" IS '性别 0：未知 1：男，2：女';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."guard_name" IS '监护人姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."guard_id_card" IS '监护人身份证';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."relation" IS '与本人关系（直接存字符串）';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."medical_history" IS '其他病史,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."illness_offline" IS '线下确诊疾病,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."illness_offline_id" IS '线下确诊疾病id,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."used_before" IS '曾用过本次药品 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."adverse_reaction" IS '有不良反应 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."treatment_offline" IS '线下医院就诊过 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."prescribe_result" IS '问诊开处方调用结果';
COMMENT ON COLUMN "dtt_demo"."public"."order_yaofang_split"."goods_num" IS '商品数量';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_goods_statistics";
CREATE TABLE "dtt_demo"."public"."order_goods_statistics"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "goods_id"    INTEGER DEFAULT NULL,
    "sale_amount"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_goods_statistics" IS '<p>
 订单商品销售量
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_goods_statistics"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_goods_statistics"."goods_id" IS 'goods id';
COMMENT ON COLUMN "dtt_demo"."public"."order_goods_statistics"."sale_amount" IS '销售量';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_item";
CREATE TABLE "dtt_demo"."public"."order_item"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "goods_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_item_id"    INTEGER DEFAULT NULL,
    "out_sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "common_name"    VARCHAR(64) DEFAULT NULL,
    "goods_spec"    VARCHAR(256) DEFAULT NULL,
    "goods_unit"    VARCHAR(256) DEFAULT NULL,
    "otc_type"    INTEGER DEFAULT NULL,
    "goods_kind"    INTEGER DEFAULT NULL,
    "org_goods_kind"    INTEGER DEFAULT NULL,
    "goods_type"    INTEGER DEFAULT NULL,
    "stock"    INTEGER DEFAULT NULL,
    "medicine_standard"    VARCHAR(256) DEFAULT NULL,
    "retail_price"    money DEFAULT NULL,
    "purchase_price"    money DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "supplier_name"    VARCHAR(64) DEFAULT NULL,
    "supplier_full_name"    VARCHAR(64) DEFAULT NULL,
    "enable_rx"    INTEGER DEFAULT NULL,
    "rx_type"    INTEGER DEFAULT NULL,
    "show_type"    INTEGER DEFAULT NULL,
    "drug_name"    VARCHAR(64) DEFAULT NULL,
    "wb_drug"    INTEGER DEFAULT NULL,
    "drug_id"    INTEGER DEFAULT NULL,
    "commission"    money DEFAULT NULL,
    "main_pic"    VARCHAR(256) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "total_amount"    money DEFAULT NULL,
    "share_amount"    money DEFAULT NULL,
    "discount_amount"    money DEFAULT NULL,
    "pay_dis_amount"    money DEFAULT NULL,
    "carriage_amount"    money DEFAULT NULL,
    "category_one"    INTEGER DEFAULT NULL,
    "category_one_name"    VARCHAR(64) DEFAULT NULL,
    "category_two"    INTEGER DEFAULT NULL,
    "category_two_name"    VARCHAR(64) DEFAULT NULL,
    "one_category_id"    INTEGER DEFAULT NULL,
    "one_category_name"    VARCHAR(64) DEFAULT NULL,
    "two_category_id"    INTEGER DEFAULT NULL,
    "two_category_name"    VARCHAR(64) DEFAULT NULL,
    "three_category_id"    INTEGER DEFAULT NULL,
    "three_category_name"    VARCHAR(64) DEFAULT NULL,
    "goods_onshelf_id"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "item_internal_type"    INTEGER DEFAULT NULL,
    "gift_flag"    INTEGER DEFAULT NULL,
    "gift_status"    INTEGER DEFAULT NULL,
    "buy_flag"    INTEGER DEFAULT NULL,
    "merchant_type"    INTEGER DEFAULT NULL,
    "self_flag"    INTEGER DEFAULT NULL,
    "business_flag"    INTEGER DEFAULT NULL,
    "barcode"    VARCHAR(64) DEFAULT NULL,
    "insure_pay_sign"    VARCHAR(256) DEFAULT NULL,
    "share_discount_code_amount"    money DEFAULT NULL,
    "department_channel"    VARCHAR(256) DEFAULT NULL,
    "distribution_activity_id"    VARCHAR(64) DEFAULT NULL,
    "distribution_out_member_id"    VARCHAR(64) DEFAULT NULL,
    "assorted_flag"    INTEGER DEFAULT NULL,
    "warehouse_code"    VARCHAR(64) DEFAULT NULL,
    "warehouse_name"    VARCHAR(64) DEFAULT NULL,
    "send_supplier_code"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_item" IS '<p>
 订单商品表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_id" IS 'goods id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_item_id" IS '商品系统item_id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."out_sku_id" IS '外部skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."common_name" IS '通用名';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_spec" IS '商品规格';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_unit" IS '商品单位：盒、袋';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."otc_type" IS 'OTC类别 1 甲类OTC 2 乙类OTC';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_kind" IS '商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."org_goods_kind" IS '原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通 21:疫苗（新）22:核酸检测';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_type" IS '商品类型:0 默认，1 全球购，2医生端权益，3消费端权益，4 疫苗';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."stock" IS '库存';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."medicine_standard" IS '国药准字';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."retail_price" IS '零售价';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."purchase_price" IS '进货价';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."supplier_id" IS '供应商id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."supplier_name" IS '供应商名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."supplier_full_name" IS '供应商全称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."enable_rx" IS '医生开处方 1 可以开处方 0 不可以开处方';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."rx_type" IS '处方药类型';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."show_type" IS '显示方式 0 不显示 1 线上';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."drug_name" IS '药品名';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."wb_drug" IS '是否万邦药 0 不是， 1 是';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."drug_id" IS '药品id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."commission" IS '佣金点数';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."main_pic" IS '列表的主图';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."total_amount" IS '商品金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."share_amount" IS '商品分摊金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."discount_amount" IS '优惠金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."pay_dis_amount" IS '支付通道扣减金额（非现金）';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."carriage_amount" IS '分摊运费，计最后一个商品';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."category_one" IS '一级类目';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."category_one_name" IS '一级类目名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."category_two" IS '二级类目';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."category_two_name" IS '二级类目名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."one_category_id" IS '后台一级类目id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."one_category_name" IS '后台一级类目名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."two_category_id" IS '后台二级类目id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."two_category_name" IS '后台二级类目名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."three_category_id" IS '后台三级类目id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."three_category_name" IS '后台三级类目名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."goods_onshelf_id" IS '商品上架的id';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."item_internal_type" IS 'item内部项类型：0默认商品，1运费';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."gift_flag" IS '赠品标识 默认0 否，1加购，2赠品';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."gift_status" IS '赠品状态 默认0 满足赠送条件，1 不满足赠送条件';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."buy_flag" IS '商详也是否可购买 0 否 1 是';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."merchant_type" IS '商家类型 0 其他  1 MP  2 入仓  3 DSV';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."self_flag" IS '是否自营供应商 0 非自营 1 自营';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."business_flag" IS '业务标识 1保险 2云DTP 3一体化DTP';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."barcode" IS '商品条形码';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."insure_pay_sign" IS '摘要签名';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."share_discount_code_amount" IS '虚拟优惠码分摊金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."department_channel" IS '渠道部门';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."distribution_activity_id" IS '分销活动编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."distribution_out_member_id" IS '所属分销员编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."assorted_flag" IS '是否组合商品 0否 1是';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."warehouse_code" IS '发货仓库编码';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."warehouse_name" IS '发货仓库名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_item"."send_supplier_code" IS '代发供应商编码';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_template";
CREATE TABLE "dtt_demo"."public"."carriage_template"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_name"    VARCHAR(64) DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "free_carriage_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "create_userid"    INTEGER DEFAULT NULL,
    "create_username"    VARCHAR(64) DEFAULT NULL,
    "template_type"    INTEGER DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_template" IS '<p>
 运费模板
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."template_name" IS '运费模板名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."platform_id" IS '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 商家后台';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."supplier_id" IS '供应商id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."free_carriage_amount" IS '免运费阈值';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."create_userid" IS '创建者id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."create_username" IS '创建者';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."template_type" IS '模板类型 1:云药房模板 2:O2O配送 3:物流配送';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template"."delete_flag" IS '删除标志 1 已删除 0 未删除';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_batch_ship_req";
CREATE TABLE "dtt_demo"."public"."order_batch_ship_req"
(
    "id"        bigserial   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "invoice_no"    VARCHAR(64) DEFAULT NULL,
    "com_code_kdyb"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_batch_ship_req" IS '延迟发货';
COMMENT ON COLUMN "dtt_demo"."public"."order_batch_ship_req"."id" IS '自增主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_batch_ship_req"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_batch_ship_req"."invoice_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_batch_ship_req"."com_code_kdyb" IS '快递100物流公司ID';

DROP TABLE IF EXISTS "dtt_demo"."public"."express_kdyb_data";
CREATE TABLE "dtt_demo"."public"."express_kdyb_data"
(
    "id"        bigserial   PRIMARY KEY NOT NULL,
    "time"    VARCHAR(256) DEFAULT NULL,
    "ftime"    VARCHAR(256) DEFAULT NULL,
    "status"    VARCHAR(256) DEFAULT NULL,
    "area_code"    VARCHAR(64) DEFAULT NULL,
    "area_name"    VARCHAR(64) DEFAULT NULL,
    "context"    VARCHAR(768) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."express_kdyb_data" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."id" IS '自增主键id';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."time" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."ftime" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."status" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."area_code" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."area_name" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."express_kdyb_data"."context" IS '';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_template_platform";
CREATE TABLE "dtt_demo"."public"."carriage_template_platform"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_id"    INTEGER DEFAULT NULL,
    "province_name"    VARCHAR(64) DEFAULT NULL,
    "base_carriage_amount"    money DEFAULT NULL,
    "free_carriage_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_template_platform" IS '<p>
 平台物流运费模板
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."template_id" IS '运费模板id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."province_name" IS '省份名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."base_carriage_amount" IS '基本运费⾦额';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."free_carriage_amount" IS '免运费阈值';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_platform"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_extend";
CREATE TABLE "dtt_demo"."public"."order_extend"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "insurance_service_id"    VARCHAR(64) DEFAULT NULL,
    "insurance_service_code"    VARCHAR(64) DEFAULT NULL,
    "insurance_service_name"    VARCHAR(64) DEFAULT NULL,
    "pay_url"    VARCHAR(128) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "self_lifting_code"    VARCHAR(64) DEFAULT NULL,
    "self_lifting_code_status"    INTEGER DEFAULT NULL,
    "third_order_no"    VARCHAR(64) DEFAULT NULL,
    "audiologist_out_member_id"    VARCHAR(64) DEFAULT NULL,
    "order_audiologist_type"    INTEGER DEFAULT NULL,
    "third_code"    VARCHAR(64) DEFAULT NULL,
    "area_code"    VARCHAR(64) DEFAULT NULL,
    "day_serial_number"    INTEGER DEFAULT NULL,
    "inquiry_review"    INTEGER DEFAULT NULL,
    "reserved_mobile"    VARCHAR(256) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_extend" IS '<p>
 订单附加信息表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."insurance_service_id" IS '保障服务id';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."insurance_service_code" IS '保障服务code';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."insurance_service_name" IS '保障服务名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."pay_url" IS '支付跳转链接';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."self_lifting_code" IS '核销码';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."self_lifting_code_status" IS '1 已核销，0为核销';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."third_order_no" IS '三方订单号(复联)';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."audiologist_out_member_id" IS '听力师id';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."order_audiologist_type" IS '听力师订单类型 0推荐订单 1代下订单';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."third_code" IS '三方商户编码';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."area_code" IS '区域编码';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."day_serial_number" IS '店铺每日订单序号';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."inquiry_review" IS '处方是否需要二审 0:不需要  1：需要';
COMMENT ON COLUMN "dtt_demo"."public"."order_extend"."reserved_mobile" IS '自提预留手机号';

DROP TABLE IF EXISTS "dtt_demo"."public"."goods_carriage_template";
CREATE TABLE "dtt_demo"."public"."goods_carriage_template"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_name"    VARCHAR(64) DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "carriage_type"    INTEGER DEFAULT NULL,
    "carriage_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "create_userid"    INTEGER DEFAULT NULL,
    "create_username"    VARCHAR(64) DEFAULT NULL,
    "template_type"    INTEGER DEFAULT NULL,
    "template_status"    INTEGER DEFAULT NULL,
    "start_distance"    FLOAT DEFAULT NULL,
    "end_distance"    FLOAT DEFAULT NULL,
    "start_time"    TIME DEFAULT NULL,
    "end_time"    TIME DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."goods_carriage_template" IS '<p>
 商品运费模板
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."template_name" IS '运费模板名称';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."supplier_id" IS '供应商id';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."carriage_type" IS '配送类型 0:自定义配送 1:全国配送';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."carriage_amount" IS '全国默认运费';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."create_userid" IS '创建者id';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."create_username" IS '创建者';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."template_type" IS '模板类型 1:b2c 2:O2O配送 3:自提';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."template_status" IS '有效状态 0:无效';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."start_distance" IS '起始距离(单位 米)';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."end_distance" IS '结束距离(单位 米)';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."start_time" IS '开始配送时间';
COMMENT ON COLUMN "dtt_demo"."public"."goods_carriage_template"."end_time" IS '最后结束时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_comment";
CREATE TABLE "dtt_demo"."public"."order_comment"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "comment_content"    VARCHAR(768) DEFAULT NULL,
    "create_user_name"    VARCHAR(64) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_user_name"    VARCHAR(64) DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_comment" IS '<p>
 订单备注表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."comment_content" IS '备注内容';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."create_user_name" IS '创建人名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."update_user_name" IS '修改人名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_comment"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."car_shopping";
CREATE TABLE "dtt_demo"."public"."car_shopping"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "member_id"    INTEGER DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "count"    INTEGER DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."car_shopping" IS '<p>
 购物车主表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."member_id" IS '会员id';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."platform_id" IS '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."count" IS '用户购物车已存放的商品数，限制最大99';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."supplier_id" IS '连锁店ID';
COMMENT ON COLUMN "dtt_demo"."public"."car_shopping"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_three_import_fail_item";
CREATE TABLE "dtt_demo"."public"."order_three_import_fail_item"
(
    "id"      bigserial   PRIMARY KEY,
    "batch_no"    VARCHAR(64) DEFAULT NULL,
    "channel"    VARCHAR(256) DEFAULT NULL,
    "channel_store_name"    VARCHAR(64) DEFAULT NULL,
    "channel_order_no"    VARCHAR(64) DEFAULT NULL,
    "channel_product_name"    VARCHAR(64) DEFAULT NULL,
    "channel_product_price"    money DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "order_quantity"    INTEGER DEFAULT NULL,
    "nick_name"    VARCHAR(64) DEFAULT NULL,
    "phone"    VARCHAR(16) DEFAULT NULL,
    "order_amount"    money DEFAULT NULL,
    "payment_amount"    money DEFAULT NULL,
    "order_time"    TIMESTAMP DEFAULT NULL,
    "payment_method"    VARCHAR(256) DEFAULT NULL,
    "business_type"    VARCHAR(256) DEFAULT NULL,
    "line_no"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "fail_message"    VARCHAR(512) DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "fosun_goods_name"    VARCHAR(64) DEFAULT NULL,
    "fosun_supplier_name"    VARCHAR(64) DEFAULT NULL,
    "fosun_good_kind"    VARCHAR(256) DEFAULT NULL,
    "fosun_goods_spec"    VARCHAR(256) DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_three_import_fail_item" IS '<p>
 三方订单批次失败详细表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."batch_no" IS '批次号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."channel" IS '渠道';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."channel_store_name" IS '渠道店铺名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."channel_order_no" IS '渠道订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."channel_product_name" IS '渠道商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."channel_product_price" IS '渠道售价';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."sku_id" IS '复星skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."order_quantity" IS '下单数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."nick_name" IS '下单人昵称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."phone" IS '下单人手机号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."order_amount" IS '订单金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."payment_amount" IS '实付金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."order_time" IS '下单时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."payment_method" IS '支付方式';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."business_type" IS '业务类型';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."line_no" IS '行数';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."fail_message" IS '失败原因';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."order_no" IS '复星订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."fosun_goods_name" IS '复星商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."fosun_supplier_name" IS '复星供应商名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."fosun_good_kind" IS '商品分类';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."fosun_goods_spec" IS '商品规格';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."update_time" IS '最后修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_fail_item"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_assets_extend";
CREATE TABLE "dtt_demo"."public"."order_assets_extend"
(
    "id"      bigserial   PRIMARY KEY,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "assets_package_id"    BIGINT DEFAULT NULL,
    "assets_card_template_id"    INTEGER DEFAULT NULL,
    "assets_card_no"    VARCHAR(64) DEFAULT NULL,
    "patient_id"    INTEGER DEFAULT NULL,
    "patient_name"    VARCHAR(64) DEFAULT NULL,
    "patient_id_card"    VARCHAR(64) DEFAULT NULL,
    "patient_phone_no"    VARCHAR(64) DEFAULT NULL,
    "doctor_id"    VARCHAR(64) DEFAULT NULL,
    "doctor_name"    VARCHAR(64) DEFAULT NULL,
    "original_package_instance_id"    VARCHAR(64) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "assets_package_name"    VARCHAR(64) DEFAULT NULL,
    "goods_type"    INTEGER DEFAULT NULL,
    "group_id"    VARCHAR(64) DEFAULT NULL,
    "activate_begin_time"    TIMESTAMP DEFAULT NULL,
    "activate_end_time"    TIMESTAMP DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_assets_extend" IS '<p>
 订单权益扩展表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."assets_package_id" IS '权益包id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."assets_card_template_id" IS '权益卡模板id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."assets_card_no" IS '权益卡号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."patient_id" IS '患者id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."patient_name" IS '患者姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."patient_id_card" IS '患者身份证号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."patient_phone_no" IS '患者手机号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."doctor_id" IS '医生id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."doctor_name" IS '医生姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."original_package_instance_id" IS '源服务包实例id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."delete_flag" IS '删除标志 1 已删除 0 未删除';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."update_time" IS '更新时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."assets_package_name" IS '权益包名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."goods_type" IS '2 医生端服务包，3 运营创建服务包';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."group_id" IS '组id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."activate_begin_time" IS '权益创建0元包的时候传入的有效期开始时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."activate_end_time" IS '权益创建0元包的时候传入的有效期退款时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."sku_id" IS 'skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_extend"."order_item_id" IS '详情订单信息';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_three_refund";
CREATE TABLE "dtt_demo"."public"."order_three_refund"
(
    "id"      bigserial   PRIMARY KEY,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "channel_order_no"    VARCHAR(64) DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "refund_amount"    money DEFAULT NULL,
    "refund_reason"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "create_name"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_three_refund" IS '<p>
 三方订单退款记录表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."channel_order_no" IS '三方渠道订单';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."sku_id" IS '退款skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."refund_amount" IS '单次退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."refund_reason" IS '退款原因';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_refund"."create_name" IS '创建人名称';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_refund_voucher";
CREATE TABLE "dtt_demo"."public"."order_refund_voucher"
(
    "id"      bigserial   PRIMARY KEY,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "refund_voucher_url"    VARCHAR(128) DEFAULT NULL,
    "refund_no"    VARCHAR(64) DEFAULT NULL,
    "system_id"    VARCHAR(64) DEFAULT NULL,
    "service_platform"    VARCHAR(256) DEFAULT NULL,
    "service_channel"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."order_refund_voucher" IS '<p>
 订单退款凭证关联表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."refund_voucher_url" IS '退款凭证管理';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."refund_no" IS '退单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."system_id" IS '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."service_platform" IS '业务平台（jd，tm,zy）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."service_channel" IS '业务渠道（渠道id）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."delete_flag" IS '删除标志 1 已删除 0 未删除';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund_voucher"."update_time" IS '更新时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."record_jd_msg";
CREATE TABLE "dtt_demo"."public"."record_jd_msg"
(
    "id"      bigserial   PRIMARY KEY,
    "jd_msg_id"    VARCHAR(64) DEFAULT NULL,
    "jd_msg"    VARCHAR(512) DEFAULT NULL,
    "msg_type"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."record_jd_msg" IS '<p>
 京东消息信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."record_jd_msg"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."record_jd_msg"."jd_msg_id" IS '京东消息id';
COMMENT ON COLUMN "dtt_demo"."public"."record_jd_msg"."jd_msg" IS '京东消息';
COMMENT ON COLUMN "dtt_demo"."public"."record_jd_msg"."msg_type" IS '消息类型';
COMMENT ON COLUMN "dtt_demo"."public"."record_jd_msg"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_compliance_switch";
CREATE TABLE "dtt_demo"."public"."rx_compliance_switch"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "switch_status"    INTEGER DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "system_id"    VARCHAR(64) DEFAULT NULL,
    "system_name"    VARCHAR(64) DEFAULT NULL,
    "create_user"    VARCHAR(16) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "update_user"    VARCHAR(16) DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_compliance_switch" IS '<p>
 强合规开关控制表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."switch_status" IS '强合规开关：0 关闭，1 开启';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."platform_id" IS '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."system_id" IS '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."system_name" IS '系统来源名称0 商城，1疫苗，2三方订单，3DTP，4复联，5国大，6听力师';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."create_user" IS '创建人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."update_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_promotion";
CREATE TABLE "dtt_demo"."public"."order_promotion"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "promotion_id"    VARCHAR(64) DEFAULT NULL,
    "promotion_type"    INTEGER DEFAULT NULL,
    "promotion_name"    VARCHAR(64) DEFAULT NULL,
    "promotion_discount_amount"    money DEFAULT NULL,
    "promotion_description"    VARCHAR(256) DEFAULT NULL,
    "promotion_no"    VARCHAR(64) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "coupon_platform"    INTEGER DEFAULT NULL,
    "promotion_sub_type"    INTEGER DEFAULT NULL,
    "promotion_sub_type_name"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_promotion" IS '<p>
 订单关联促销表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."id" IS 'id';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."order_id" IS 'order表id';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_id" IS '外部促销id，由促销系统提供';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_type" IS '促销类型，由促销系统提供0优惠券，1活动，2国大保险，3永诚保险，4积分，5优惠码';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_name" IS '促销名称，由促销系统提供';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_discount_amount" IS '促销优惠金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_description" IS '促销描述信息，由促销系统提供';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_no" IS '促销券码，由促销系统提供';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."platform_id" IS '促销平台';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."delete_flag" IS '删除标志 1 已删除 0 未删除';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."coupon_platform" IS '优惠券平台类型 默认1:店铺券，2:平台券';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_sub_type" IS '促销子类型 优惠券类型 1 满减劵 2 折扣券 3 现金券, 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 0国大保险 12永诚保险 13健康积分 14优惠码';
COMMENT ON COLUMN "dtt_demo"."public"."order_promotion"."promotion_sub_type_name" IS '促销子类型名称';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_template_content";
CREATE TABLE "dtt_demo"."public"."carriage_template_content"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_id"    INTEGER DEFAULT NULL,
    "region_name"    VARCHAR(64) DEFAULT NULL,
    "base_carriage_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_template_content" IS '<p>
 运费模板内容
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_content"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_content"."template_id" IS '运费模板id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_content"."region_name" IS '大区名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_content"."base_carriage_amount" IS '基本运费金额';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_content"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_template_region";
CREATE TABLE "dtt_demo"."public"."carriage_template_region"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_id"    INTEGER DEFAULT NULL,
    "region_name"    VARCHAR(64) DEFAULT NULL,
    "base_carriage_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_template_region" IS '<p>
 区域模板内容
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_region"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_region"."template_id" IS '运费模板id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_region"."region_name" IS '大区名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_region"."base_carriage_amount" IS '基本运费金额';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_region"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."trade_order";
CREATE TABLE "dtt_demo"."public"."trade_order"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "parent_order_no"    VARCHAR(64) DEFAULT NULL,
    "status"    INTEGER DEFAULT NULL,
    "order_type"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "total_amount"    money DEFAULT NULL,
    "discount_amount"    money DEFAULT NULL,
    "pay_dis_amount"    money DEFAULT NULL,
    "carriage_amount"    money DEFAULT NULL,
    "payment_amount"    money DEFAULT NULL,
    "buyer_id"    INTEGER DEFAULT NULL,
    "buyer_name"    VARCHAR(64) DEFAULT NULL,
    "buyer_tel"    VARCHAR(16) DEFAULT NULL,
    "receiver_name"    VARCHAR(64) DEFAULT NULL,
    "receiver_tel"    VARCHAR(16) DEFAULT NULL,
    "receiver_time"    TIMESTAMP DEFAULT NULL,
    "province"    VARCHAR(256) DEFAULT NULL,
    "city"    VARCHAR(256) DEFAULT NULL,
    "area"    VARCHAR(256) DEFAULT NULL,
    "address"    VARCHAR(256) DEFAULT NULL,
    "evaluation_status"    INTEGER DEFAULT NULL,
    "evaluation_time"    TIMESTAMP DEFAULT NULL,
    "delivery_time"    TIMESTAMP DEFAULT NULL,
    "finished_time"    TIMESTAMP DEFAULT NULL,
    "anonymous"    INTEGER DEFAULT NULL,
    "postscript"    VARCHAR(256) DEFAULT NULL,
    "cancel_reason"    VARCHAR(256) DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "supplier_name"    VARCHAR(64) DEFAULT NULL,
    "chain_shop_id"    INTEGER DEFAULT NULL,
    "chain_shop_name"    VARCHAR(64) DEFAULT NULL,
    "retail_shop_id"    INTEGER DEFAULT NULL,
    "retail_shop_name"    VARCHAR(64) DEFAULT NULL,
    "supplier_full_name"    VARCHAR(64) DEFAULT NULL,
    "original_system"    INTEGER DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "deduction_amount"    money DEFAULT NULL,
    "deduction_score_amount"    money DEFAULT NULL,
    "deduction_card_amount"    money DEFAULT NULL,
    "health_coin"    INTEGER DEFAULT NULL,
    "bang_coin"    INTEGER DEFAULT NULL,
    "out_member_id"    VARCHAR(64) DEFAULT NULL,
    "channel_source"    VARCHAR(256) DEFAULT NULL,
    "endpoint"    VARCHAR(256) DEFAULT NULL,
    "external_value"    VARCHAR(256) DEFAULT NULL,
    "refund_flag"    INTEGER DEFAULT NULL,
    "cancel_time"    TIMESTAMP DEFAULT NULL,
    "system_id"    VARCHAR(64) DEFAULT NULL,
    "service_platform"    VARCHAR(256) DEFAULT NULL,
    "service_channel"    VARCHAR(256) DEFAULT NULL,
    "order_comment"    VARCHAR(256) DEFAULT NULL,
    "comment_time"    TIMESTAMP DEFAULT NULL,
    "global_activity_id"    VARCHAR(64) DEFAULT NULL,
    "global_channel_id"    VARCHAR(64) DEFAULT NULL,
    "assets_type"    INTEGER DEFAULT NULL,
    "delivery_type"    INTEGER DEFAULT NULL,
    "merchant_type"    INTEGER DEFAULT NULL,
    "self_flag"    INTEGER DEFAULT NULL,
    "business_flag"    INTEGER DEFAULT NULL,
    "receiver_lat"    money DEFAULT NULL,
    "receiver_lng"    money DEFAULT NULL,
    "org_code"    VARCHAR(64) DEFAULT NULL,
    "org_name"    VARCHAR(64) DEFAULT NULL,
    "wms_warehouse_id"    VARCHAR(64) DEFAULT NULL,
    "wms_warehouse_name"    VARCHAR(64) DEFAULT NULL,
    "client_type"    INTEGER DEFAULT NULL,
    "device_name"    VARCHAR(64) DEFAULT NULL,
    "distribution_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."trade_order" IS '<p>
 订单主表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."order_no" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."parent_order_no" IS '父单号（多订单提交生成新父单号，单订单提交与订单号一致）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."status" IS '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."order_type" IS '订单类型0 默认，1 全球购，2 权益包，3 疫苗，4 o2o，5 连锁，6 云药房 7 连锁供应链';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."total_amount" IS '订单总金额';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."discount_amount" IS '优惠总金额';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."pay_dis_amount" IS '支付通道扣减金额（非现金）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."carriage_amount" IS '运费';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."payment_amount" IS '订单应付金额';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."buyer_id" IS '买家用户ID';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."buyer_name" IS '购买者用户名';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."buyer_tel" IS '购买者电话';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."receiver_name" IS '收货人姓名';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."receiver_tel" IS '收货人电话';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."receiver_time" IS '订单收货时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."province" IS '省';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."city" IS '市';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."area" IS '区';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."address" IS '收货人详细地址';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."evaluation_status" IS '评价状态 0 未评价 1 已评价';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."evaluation_time" IS '评价时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."delivery_time" IS '发货时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."finished_time" IS '订单完成时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."anonymous" IS '是否匿名';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."postscript" IS '订单留言';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."cancel_reason" IS '取消订单原因';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."platform_id" IS '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."supplier_id" IS '供应商id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."supplier_name" IS '供应商名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."chain_shop_id" IS '连锁店id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."chain_shop_name" IS '连锁店名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."retail_shop_id" IS '门店id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."retail_shop_name" IS '门店名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."supplier_full_name" IS '供应商全称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."original_system" IS '是否老系统：1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."deduction_amount" IS '抵扣金额';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."deduction_score_amount" IS '抵扣金额（优医币，邦指数）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."deduction_card_amount" IS '抵扣金额（礼品卡）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."health_coin" IS '抵扣优医币';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."bang_coin" IS '抵扣邦指数';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."out_member_id" IS '大会员系统的会员id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."channel_source" IS '渠道来源';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."endpoint" IS '终端类型 h5InWx，h5，wxMiniApp';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."external_value" IS '外部参数（根据外部需求放入）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."refund_flag" IS '退款标识 0.无退款 1.有退款';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."cancel_time" IS '订单取消时间';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."system_id" IS '系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."service_platform" IS '业务平台 0 星苗自营、1天猫、2京东、3百度、4腾讯、5其他、7快手、6抖音、8网易严选、9口碑、10 医鹿';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."service_channel" IS '业务渠道（渠道id）';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."order_comment" IS '订单备注，仅供后台使用，无业务交互';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."comment_time" IS '订单备注时间，编辑备注覆盖';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."global_activity_id" IS '全局活动id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."global_channel_id" IS '全局渠道id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."assets_type" IS '权益订单子类型：0 默认，1 普通权益包，2 实体卡，3 电子卡，4 实体卡激活权益包，
 5 电子卡激活权益包 6 礼品卡电子卡 7 礼品卡实体卡   8 权益包升级，9三方权益订单  100006.基因检测发放 100007.体检发放 100008.苏可欣发放';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."delivery_type" IS '0默认物流，1o2o在线配送，2自提';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."merchant_type" IS '商家类型 0 其他  1 MP  2 入仓  3 DSV';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."self_flag" IS '是否自营供应商 0 非自营 1 自营';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."business_flag" IS '业务标识 1保险 2云DTP 3一体化DTP';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."receiver_lat" IS '收货地址纬度';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."receiver_lng" IS '收货地址经度';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."org_code" IS '机构编码';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."org_name" IS '机构名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."wms_warehouse_id" IS '仓库id';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."wms_warehouse_name" IS '仓库名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."client_type" IS '终端类型
 1.小程序原生页面 2.ios原生的页面 3.android原生的页面 4.h5页面在微信小程序里打开 5.h5页面在微信浏览器中打开，不包括微信小程序 6.不在上述情况下的值';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."device_name" IS '应用名称';
COMMENT ON COLUMN "dtt_demo"."public"."trade_order"."distribution_flag" IS '是否参与分销 0否,1是 （分销信息见order_extend）';

DROP TABLE IF EXISTS "dtt_demo"."public"."near_pharmacy_dto";
CREATE TABLE "dtt_demo"."public"."near_pharmacy_dto"
(
    "id"        bigserial   PRIMARY KEY NOT NULL,
    "abbr_name"    VARCHAR(64) DEFAULT NULL,
    "full_name"    VARCHAR(64) DEFAULT NULL,
    "distance"    FLOAT DEFAULT NULL,
    "logo_url"    VARCHAR(128) DEFAULT NULL,
    "template_type"    VARCHAR(256) DEFAULT NULL,
    "lng"    FLOAT DEFAULT 0.0,
    "lat"    FLOAT DEFAULT 0.0,
    "start_distance"    money DEFAULT NULL,
    "end_distance"    money DEFAULT NULL,
    "start_time"    TIME DEFAULT NULL,
    "end_time"    TIME DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."near_pharmacy_dto" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."id" IS '自增主键id';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."abbr_name" IS '简称';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."full_name" IS '全称';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."distance" IS '距离';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."logo_url" IS 'logo图片';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."template_type" IS '1:b2c 2:O2O配送 3:自提';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."lng" IS '店铺经度';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."lat" IS '店铺纬度';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."start_distance" IS '起始距离(单位 米)';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."end_distance" IS '结束距离(单位 米)';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."start_time" IS '开始配送时间';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."end_time" IS '最后结束时间';
COMMENT ON COLUMN "dtt_demo"."public"."near_pharmacy_dto"."supplier_id" IS '供应商id';

DROP TABLE IF EXISTS "dtt_demo"."public"."express_subscribe";
CREATE TABLE "dtt_demo"."public"."express_subscribe"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "sub_platform"    INTEGER DEFAULT NULL,
    "com_code"    VARCHAR(64) DEFAULT NULL,
    "exp_no"    VARCHAR(64) DEFAULT NULL,
    "sub_info"    VARCHAR(256) DEFAULT NULL,
    "sub_result"    VARCHAR(256) DEFAULT NULL,
    "result_status"    INTEGER DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."express_subscribe" IS '<p>
 快递订阅记录
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."sub_platform" IS '订阅平台 1:快递网 2快递100';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."com_code" IS '快递公司code(与平台相关)';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."exp_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."sub_info" IS '订阅信息';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."sub_result" IS '订阅返回值';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."result_status" IS '是否订阅成功 1成功 0:失败';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."express_subscribe"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_express";
CREATE TABLE "dtt_demo"."public"."order_express"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "invoice_no"    VARCHAR(64) DEFAULT NULL,
    "express_code"    VARCHAR(64) DEFAULT NULL,
    "express_company"    VARCHAR(256) DEFAULT NULL,
    "delivery_time"    TIMESTAMP DEFAULT NULL,
    "receiver_time"    TIMESTAMP DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "create_user_name"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_express" IS '<p>
 订单物流
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."order_item_id" IS '订单商品id';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."invoice_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."express_code" IS '物流公司code';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."express_company" IS '物流公司名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."delivery_time" IS '发货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."receiver_time" IS '收货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_express"."create_user_name" IS '发货创建人名称';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_audiologist_remark";
CREATE TABLE "dtt_demo"."public"."order_audiologist_remark"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "doctor_name"    VARCHAR(64) DEFAULT NULL,
    "audiologist_name"    VARCHAR(64) DEFAULT NULL,
    "configuration_location"    VARCHAR(256) DEFAULT NULL,
    "shipper"    VARCHAR(256) DEFAULT NULL,
    "accessories_details"    VARCHAR(256) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_audiologist_remark" IS '<p>
 听力师订单备注表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."doctor_name" IS '医生姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."audiologist_name" IS '听力师姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."configuration_location" IS '配置地点';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."shipper" IS '发货方';
COMMENT ON COLUMN "dtt_demo"."public"."order_audiologist_remark"."accessories_details" IS '配件详情';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_compliance_switch_user";
CREATE TABLE "dtt_demo"."public"."rx_compliance_switch_user"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "switch_status"    INTEGER DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "tel_phone"    VARCHAR(16) DEFAULT NULL,
    "create_user"    VARCHAR(16) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "update_user"    VARCHAR(16) DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_compliance_switch_user" IS '<p>
 用户强合规开关控制表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."switch_status" IS '强合规开关：0 关闭，1 开启';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."platform_id" IS '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."tel_phone" IS '手机号';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."create_user" IS '创建人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."update_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_user"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_operation_log";
CREATE TABLE "dtt_demo"."public"."order_operation_log"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "log_no"    VARCHAR(64) DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "refund_no"    VARCHAR(64) DEFAULT NULL,
    "url"    VARCHAR(128) DEFAULT NULL,
    "trace_id"    VARCHAR(64) DEFAULT NULL,
    "operation_channel"    INTEGER DEFAULT NULL,
    "operation_type"    INTEGER DEFAULT NULL,
    "operation_req"    VARCHAR(256) DEFAULT NULL,
    "operation_result"    INTEGER DEFAULT NULL,
    "creator"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_operation_log" IS '<p>
 订单操作日志
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."log_no" IS '日志编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."refund_no" IS '退单编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."url" IS '接口url';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."trace_id" IS 'traceId';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."operation_channel" IS '操作渠道 1.C端 2.E端 3.B端';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."operation_type" IS '操作类型 1.发货 2.创建退单 3.同意退货申请 4.确认退单 5.拒绝退单 6.订单列表导出';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."operation_req" IS '操作入参';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."operation_result" IS '操作结果 1.成功 2.失败';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."creator" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."order_operation_log"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_global_buy";
CREATE TABLE "dtt_demo"."public"."order_global_buy"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "customs_bill_no"    VARCHAR(64) DEFAULT NULL,
    "bill_status"    INTEGER DEFAULT NULL,
    "pay_custom_status"    INTEGER DEFAULT NULL,
    "out_status_code"    VARCHAR(64) DEFAULT NULL,
    "out_status_desc"    VARCHAR(256) DEFAULT NULL,
    "out_status_date"    TIMESTAMP DEFAULT NULL,
    "out_dist_status_code"    VARCHAR(64) DEFAULT NULL,
    "out_dist_status_desc"    VARCHAR(256) DEFAULT NULL,
    "out_dist_status_date"    TIMESTAMP DEFAULT NULL,
    "first_push_date"    TIMESTAMP DEFAULT NULL,
    "last_push_date"    TIMESTAMP DEFAULT NULL,
    "receiver_real_name"    VARCHAR(64) DEFAULT NULL,
    "receiver_id_card"    VARCHAR(64) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "del_flag"    INTEGER DEFAULT NULL,
    "link_status"    INTEGER DEFAULT NULL,
    "link_content"    VARCHAR(768) DEFAULT NULL,
    "link_service_name"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_global_buy" IS '<p>
 全球购订单信息表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."customs_bill_no" IS '海关清单编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."bill_status" IS '单据状态: 0 默认，1 处理中，2 已放行，3 清关异常';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."pay_custom_status" IS '支付通关状态 0 未提交 1 未申报，2 申报中，3 申报成功， 4 申报失败';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_status_code" IS '外部业务单据状态code';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_status_desc" IS '外部业务单据状态描述';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_status_date" IS '外部业务单据状态时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_dist_status_code" IS '外部核放单据状态code';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_dist_status_desc" IS '外部核放单据状态描述';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."out_dist_status_date" IS '外部核放单据状态时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."first_push_date" IS '首次推送时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."last_push_date" IS '最后推送时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."receiver_real_name" IS '收货人实名';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."receiver_id_card" IS '收货人身份证';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."link_status" IS '链路状态 0 -未执行支付  1-支付推送   2-支付推送失败 3- 支付查询 4-查询失败  5- 物流单号获取  6-物流单号获取失败
 7- 物流单推送海关  8-物流单推送海关失败   9-订单推送  10-订单推送失败 11-订单查询  12- 订单查询失败
 100-推送成功';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."link_content" IS '链路入参数据';
COMMENT ON COLUMN "dtt_demo"."public"."order_global_buy"."link_service_name" IS '当前链路服务名称';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_inquiry";
CREATE TABLE "dtt_demo"."public"."order_inquiry"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "inquiry_type"    INTEGER DEFAULT NULL,
    "roam_status"    INTEGER DEFAULT NULL,
    "pres_number"    VARCHAR(64) DEFAULT NULL,
    "inquiry_sign"    INTEGER DEFAULT NULL,
    "check_flow"    INTEGER DEFAULT NULL,
    "relevance_no"    VARCHAR(64) DEFAULT NULL,
    "doctor_id"    VARCHAR(64) DEFAULT NULL,
    "doctor_name"    VARCHAR(64) DEFAULT NULL,
    "prescription_id"    VARCHAR(64) DEFAULT NULL,
    "prescription_date"    TIMESTAMP DEFAULT NULL,
    "prescribe_result"    VARCHAR(256) DEFAULT NULL,
    "original_prescription_id"    VARCHAR(64) DEFAULT NULL,
    "check_status"    INTEGER DEFAULT NULL,
    "check_msg"    VARCHAR(512) DEFAULT NULL,
    "second_check_status"    INTEGER DEFAULT NULL,
    "second_check_msg"    VARCHAR(512) DEFAULT NULL,
    "result_img"    VARCHAR(256) DEFAULT NULL,
    "result_pdf"    VARCHAR(256) DEFAULT NULL,
    "patient_id"    VARCHAR(64) DEFAULT NULL,
    "patient_name"    VARCHAR(64) DEFAULT NULL,
    "patient_id_card"    VARCHAR(64) DEFAULT NULL,
    "patient_photo"    VARCHAR(256) DEFAULT NULL,
    "birthday"    DATE DEFAULT NULL,
    "gender"    INTEGER DEFAULT NULL,
    "guard_name"    VARCHAR(64) DEFAULT NULL,
    "guard_id_card"    VARCHAR(64) DEFAULT NULL,
    "relation"    VARCHAR(256) DEFAULT NULL,
    "medical_history"    VARCHAR(256) DEFAULT NULL,
    "illness_offline"    VARCHAR(256) DEFAULT NULL,
    "illness_offline_id"    VARCHAR(64) DEFAULT NULL,
    "used_before"    INTEGER DEFAULT NULL,
    "adverse_reaction"    INTEGER DEFAULT NULL,
    "treatment_offline"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "consult_order_id"    VARCHAR(64) DEFAULT NULL,
    "consult_status"    INTEGER DEFAULT NULL,
    "consult_date"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_inquiry" IS '<p>
 订单问诊记录
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."inquiry_type" IS '处方类型：0后置，1前置，2后置IM 3汉利康';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."roam_status" IS '处方实际审核流：0 一审，1 二审，2 中宝二审';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."pres_number" IS '处方编号';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."inquiry_sign" IS '处方标记：0 默认处方，1 主处方';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."check_flow" IS '审核流：0 默认一审，1 二审，2 中宝二审 3 国大 4 三方';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."relevance_no" IS '处方关联编号（主处方对应订单关联编号一致，默认处方按订单号存储）';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."doctor_id" IS '医生id';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."doctor_name" IS '医生名字';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."prescription_id" IS '处方id';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."prescription_date" IS '处方创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."prescribe_result" IS '问诊开处方调用结果';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."original_prescription_id" IS '原处方id';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."check_status" IS '处方审核状态 0：待审核 1：成功 -1：失败 2：审核中 3：拆方中 4:流转中';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."check_msg" IS '审核消息';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."second_check_status" IS '处方二审状态：0 无需二审，1 待二审，2 二审中，3 二审成功，4 二审失败';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."second_check_msg" IS '二审消息';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."result_img" IS '问诊结果(图片)';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."result_pdf" IS '问诊结果(pdf)';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."patient_id" IS '用药人档案id(对接互联网医院的)';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."patient_name" IS '用药人姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."patient_id_card" IS '用药人身份证';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."patient_photo" IS '用药人图片信息';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."birthday" IS '出生日期';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."gender" IS '性别 0：未知 1：男，2：女';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."guard_name" IS '监护人姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."guard_id_card" IS '监护人身份证';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."relation" IS '与本人关系（直接存字符串）';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."medical_history" IS '其他病史,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."illness_offline" IS '线下确诊疾病,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."illness_offline_id" IS '线下确诊疾病id,多个逗号分隔';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."used_before" IS '曾用过本次药品 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."adverse_reaction" IS '有不良反应 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."treatment_offline" IS '是否复诊/线下医院就诊过 0：否 1：是';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."consult_order_id" IS '互联网医院咨询单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."consult_status" IS '互联网医院问诊单状态:0,无；1,待接诊；2,超时；3,正常结束问诊；4,交流中；5,未开处方且医生主动结束问诊；6,用户退款,关闭问诊单';
COMMENT ON COLUMN "dtt_demo"."public"."order_inquiry"."consult_date" IS '互联网医院问诊单创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_assets_relation_item";
CREATE TABLE "dtt_demo"."public"."order_assets_relation_item"
(
    "id"      bigserial   PRIMARY KEY,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_item_no"    VARCHAR(64) DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."order_assets_relation_item" IS '<p>
 订单权益商品订单关联表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."order_no" IS '权益包订单号/权益卡订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."order_id" IS '权益包订单id/权益卡订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."order_item_no" IS '服务包拆分后订单号/权益卡绑定权益包订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."order_item_id" IS '服务包拆分后订单id/权益卡绑定权益包订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_assets_relation_item"."update_time" IS '更新时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_compliance_switch_endpoint";
CREATE TABLE "dtt_demo"."public"."rx_compliance_switch_endpoint"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "endpoint"    VARCHAR(256) DEFAULT NULL,
    "endpoint_name"    VARCHAR(64) DEFAULT NULL,
    "switch_status"    INTEGER DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "create_user"    VARCHAR(16) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "update_user"    VARCHAR(16) DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_compliance_switch_endpoint" IS '<p>
 终端强合规开关控制表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."endpoint" IS '终端类型 小程序-h5InWx，h5，app-wxMiniApp';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."endpoint_name" IS '终端名称 小程序-h5InWx，h5，app-wxMiniApp';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."switch_status" IS '强合规开关：0 关闭，1 开启';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."create_user" IS '创建人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."update_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_endpoint"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."region_province_mapping";
CREATE TABLE "dtt_demo"."public"."region_province_mapping"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "province"    VARCHAR(256) DEFAULT NULL,
    "region_name"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."region_province_mapping" IS '<p>
 区域省的映射关系
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."region_province_mapping"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."region_province_mapping"."province" IS '省名称';
COMMENT ON COLUMN "dtt_demo"."public"."region_province_mapping"."region_name" IS '大区名称';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_card_record";
CREATE TABLE "dtt_demo"."public"."order_card_record"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "assets_card_no"    VARCHAR(64) DEFAULT NULL,
    "use_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_card_record" IS '<p>
 订单礼品卡记录表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."assets_card_no" IS '卡号';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."use_amount" IS '使用金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_card_record"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_compliance_switch_sku";
CREATE TABLE "dtt_demo"."public"."rx_compliance_switch_sku"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "item_id"    INTEGER DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "create_user"    VARCHAR(16) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "update_user"    VARCHAR(16) DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_compliance_switch_sku" IS '<p>
 sku强合规开关控制表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."platform_id" IS '平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."item_id" IS 'itemid';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."create_user" IS '创建人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."update_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_sku"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."log_outer_reqst";
CREATE TABLE "dtt_demo"."public"."log_outer_reqst"
(
    "id"      bigserial   PRIMARY KEY,
    "outer_code"    INTEGER DEFAULT NULL,
    "outer_name"    VARCHAR(64) DEFAULT NULL,
    "request_uri"    VARCHAR(768) DEFAULT NULL,
    "request_params"    VARCHAR(768) DEFAULT NULL,
    "response_result"    VARCHAR(768) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."log_outer_reqst" IS '<p>
 外部请求日志记录
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."outer_code" IS '外部渠道code 1：京东';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."outer_name" IS '外部渠道名称';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."request_uri" IS '请求地址(去掉域名和请求参数)';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."request_params" IS '请求参数';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."response_result" IS '返回参数';
COMMENT ON COLUMN "dtt_demo"."public"."log_outer_reqst"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_jd_refund";
CREATE TABLE "dtt_demo"."public"."order_jd_refund"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "jd_order_id"    VARCHAR(64) DEFAULT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "refund_id"    INTEGER DEFAULT NULL,
    "refund_no"    VARCHAR(64) DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL,
    "mall_sku_id"    VARCHAR(64) DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "finished_time"    TIMESTAMP DEFAULT NULL,
    "customer_expect"    INTEGER DEFAULT NULL,
    "status"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "refund_amount"    money DEFAULT NULL,
    "address"    VARCHAR(256) DEFAULT NULL,
    "buyer_id"    INTEGER DEFAULT NULL,
    "buyer_name"    VARCHAR(64) DEFAULT NULL,
    "buyer_tel"    VARCHAR(16) DEFAULT NULL,
    "cancel_reason"    VARCHAR(256) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_jd_refund" IS '<p>
 京东退单主表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."jd_order_id" IS '京东订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."refund_id" IS '退单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."refund_no" IS '退单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."order_item_id" IS '订单商品id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."mall_sku_id" IS '商城sku';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."sku_id" IS '京东sku';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."finished_time" IS '退单完成时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."customer_expect" IS '10退货，20换货，30维修';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."status" IS '退单状态 10申请中待审核；20审核完成待收货；30收货完成待处理；40处理完成（如需退款则等待退款）；50待用户确认，60用户确认完成，70取消';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."refund_amount" IS '退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."address" IS '收货地址合并省市区';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."buyer_id" IS '买家用户ID';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."buyer_name" IS '购买者用户名';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."buyer_tel" IS '购买者电话';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_refund"."cancel_reason" IS '退单原因';

DROP TABLE IF EXISTS "dtt_demo"."public"."lottery_batchno_generator";
CREATE TABLE "dtt_demo"."public"."lottery_batchno_generator"
(
    "id"      bigserial   PRIMARY KEY,
    "created_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."lottery_batchno_generator" IS '<p>
 年会抽奖批次号生成
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_batchno_generator"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_batchno_generator"."created_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_region_province";
CREATE TABLE "dtt_demo"."public"."carriage_region_province"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "province"    VARCHAR(256) DEFAULT NULL,
    "region_name"    VARCHAR(64) DEFAULT NULL,
    "region_id"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_region_province" IS '<p>
 区域省映射关系
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_region_province"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_region_province"."province" IS '省名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_region_province"."region_name" IS '大区名称';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_region_province"."region_id" IS '区域id';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_refund";
CREATE TABLE "dtt_demo"."public"."order_refund"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "refund_no"    VARCHAR(64) DEFAULT NULL,
    "refund_type"    INTEGER DEFAULT NULL,
    "status"    INTEGER DEFAULT NULL,
    "channel"    INTEGER DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "refund_amount"    money DEFAULT NULL,
    "refund_carriage_amount"    money DEFAULT NULL,
    "refund_pay_dis_amount"    money DEFAULT NULL,
    "address"    VARCHAR(256) DEFAULT NULL,
    "buyer_id"    INTEGER DEFAULT NULL,
    "buyer_name"    VARCHAR(64) DEFAULT NULL,
    "buyer_tel"    VARCHAR(16) DEFAULT NULL,
    "item_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_id"    INTEGER DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "supplier_name"    VARCHAR(64) DEFAULT NULL,
    "chain_shop_id"    INTEGER DEFAULT NULL,
    "chain_shop_name"    VARCHAR(64) DEFAULT NULL,
    "retail_shop_id"    INTEGER DEFAULT NULL,
    "retail_shop_name"    VARCHAR(64) DEFAULT NULL,
    "supplier_full_name"    VARCHAR(64) DEFAULT NULL,
    "pay_way_code"    VARCHAR(64) DEFAULT NULL,
    "pay_way_name"    VARCHAR(64) DEFAULT NULL,
    "finished_time"    TIMESTAMP DEFAULT NULL,
    "cancel_reason"    VARCHAR(256) DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "pay_no"    VARCHAR(64) DEFAULT NULL,
    "third_transaction_no"    VARCHAR(64) DEFAULT NULL,
    "supplement_reason"    VARCHAR(256) DEFAULT NULL,
    "rejective_reason"    VARCHAR(256) DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "out_member_id"    VARCHAR(64) DEFAULT NULL,
    "return_deduction_amount"    money DEFAULT NULL,
    "return_deduction_score_amount"    money DEFAULT NULL,
    "return_deduction_card_amount"    money DEFAULT NULL,
    "return_health_coin"    INTEGER DEFAULT NULL,
    "return_bang_coin"    INTEGER DEFAULT NULL,
    "express_method"    INTEGER DEFAULT NULL,
    "invoice_no"    VARCHAR(64) DEFAULT NULL,
    "express_code"    VARCHAR(64) DEFAULT NULL,
    "picture_url"    VARCHAR(128) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_refund" IS '<p>
 退单主表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."refund_no" IS '退单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."refund_type" IS '1 退款 2 退货 3 退货退款';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."status" IS '1 待退款 2 退款关闭 3 商家审核 4 商品寄回 5 商家确认退款 6 退款成功 7 退货待审核';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."channel" IS '1 线下E端 2 线上C端 3 线下B端';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."platform_id" IS '平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."refund_amount" IS '退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."refund_carriage_amount" IS '运费退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."refund_pay_dis_amount" IS '非现金支付退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."address" IS '收货地址合并省市区';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."buyer_id" IS '买家用户ID';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."buyer_name" IS '购买者用户名';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."buyer_tel" IS '购买者电话';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."item_id" IS 'item id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."goods_id" IS 'goods id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."supplier_id" IS '供应商id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."supplier_name" IS '供应商名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."chain_shop_id" IS '连锁店id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."chain_shop_name" IS '连锁店名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."retail_shop_id" IS '门店id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."retail_shop_name" IS '门店名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."supplier_full_name" IS '供应商全称';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."pay_way_code" IS '收付代码（支付类型代码）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."pay_way_name" IS '收付名称（支付类型名称）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."finished_time" IS '退单完成时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."cancel_reason" IS '退单原因';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."pay_no" IS '支付交易单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."third_transaction_no" IS '三方流水号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."supplement_reason" IS '补充原因';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."rejective_reason" IS '拒绝原因';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."update_time" IS '更新时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."out_member_id" IS '大会员系统的会员id';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."return_deduction_amount" IS '退单归还抵扣金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."return_deduction_score_amount" IS '退单归还抵扣金额（优医币，邦指数）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."return_deduction_card_amount" IS '退单归还抵扣金额（礼品卡）';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."return_health_coin" IS '退单归还抵扣优医币';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."return_bang_coin" IS '退单归还抵扣邦指数';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."express_method" IS '退货物流方式 1.无退货物流 2.原运单退回 3.新运单退回';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."invoice_no" IS '快递单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."express_code" IS '物流公司code';
COMMENT ON COLUMN "dtt_demo"."public"."order_refund"."picture_url" IS '退款图片凭证';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_inquiry_log";
CREATE TABLE "dtt_demo"."public"."rx_inquiry_log"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_ids"    VARCHAR(64) DEFAULT NULL,
    "consult_order_id"    VARCHAR(64) DEFAULT NULL,
    "consult_status"    INTEGER DEFAULT NULL,
    "platform_id"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "url"    VARCHAR(128) DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_inquiry_log" IS '<p>
 问诊记录日志表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."order_ids" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."consult_order_id" IS '咨询单号';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."consult_status" IS '问诊单状态:0,待接诊；4,超时；5,交流中；6,处方已开出且正常结束；100,未开处方且医生主动结束订单 101：用户退款，问诊单关闭';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."platform_id" IS '平台：1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."url" IS '问诊请求url';
COMMENT ON COLUMN "dtt_demo"."public"."rx_inquiry_log"."remark" IS '问诊异常备注';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_jd_info";
CREATE TABLE "dtt_demo"."public"."order_jd_info"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "p_order_id"    VARCHAR(64) DEFAULT NULL,
    "jd_order_id"    VARCHAR(64) DEFAULT NULL,
    "freight"    money DEFAULT NULL,
    "order_price"    money DEFAULT NULL,
    "order_tax_price"    money DEFAULT NULL,
    "order_state"    INTEGER DEFAULT NULL,
    "state"    INTEGER DEFAULT NULL,
    "submit_state"    INTEGER DEFAULT NULL,
    "jd_order_state"    INTEGER DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "finish_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_jd_info" IS '<p>
 京东订单信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."order_id" IS '电商订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."order_no" IS '电商订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."p_order_id" IS '京东父单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."jd_order_id" IS '京东订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."freight" IS '运费';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."order_price" IS '订单总金额（不包含运费）';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."order_tax_price" IS '订单税额';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."order_state" IS '订单状态。0为取消订单  1为有效。';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."state" IS '物流状态。0 是新建  1是妥投   2是拒收';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."submit_state" IS '预占确认状态。0没确认预占；1已确认预占';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."jd_order_state" IS '京东订单状态 1.新单；2.等待支付；3.等待支付确认；4.延迟付款确认；5.订单暂停；6.店长最终审核；7.等待打印；8.等待出库；9.等待打包；10.等待发货；11.自提途中；12.上门提货；13.自提退货；14.确认自提；16.等待确认收货；17.配送退货；18.货到付款确认；19.已完成；21.收款确认；22.锁定；29.等待三方出库；30.等待三方发货；31.等待三方发货完成';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_info"."finish_time" IS '订单完成时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."express_company";
CREATE TABLE "dtt_demo"."public"."express_company"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "express_code"    VARCHAR(64) DEFAULT NULL,
    "express_company"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "com_code_kdw"    VARCHAR(64) DEFAULT NULL,
    "com_code_kdyb"    VARCHAR(64) DEFAULT NULL,
    "default_flag"    INTEGER DEFAULT NULL,
    "oms_express_company_id"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."express_company" IS '<p>
 物流公司
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."express_code" IS '物流公司code';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."express_company" IS '物流公司名称';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."com_code_kdw" IS '快递网物流公司code';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."com_code_kdyb" IS '快递100物流公司ID';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."default_flag" IS '是否默认 0默认 1 不默认(用于第三方模糊匹配重复的场景)';
COMMENT ON COLUMN "dtt_demo"."public"."express_company"."oms_express_company_id" IS 'oms快递公司id';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_three_import_batch";
CREATE TABLE "dtt_demo"."public"."order_three_import_batch"
(
    "id"      bigserial   PRIMARY KEY,
    "batch_no"    VARCHAR(64) DEFAULT NULL,
    "channel"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "success_number"    INTEGER DEFAULT NULL,
    "import_total_number"    INTEGER DEFAULT NULL,
    "fail_number"    INTEGER DEFAULT NULL,
    "order_import_status"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_three_import_batch" IS '<p>
 三方订单导入批次表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."batch_no" IS '批次号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."channel" IS '渠道';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."create_time" IS '批次导入时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."success_number" IS '校验成功数';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."import_total_number" IS '导入总数';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."fail_number" IS '校验失败数';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."order_import_status" IS '订单导入状态0未导入，1导入';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."update_time" IS '修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_batch"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."rx_compliance_switch_log";
CREATE TABLE "dtt_demo"."public"."rx_compliance_switch_log"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "switch_id"    INTEGER DEFAULT NULL,
    "switch_type"    INTEGER DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "create_user"    VARCHAR(16) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."rx_compliance_switch_log" IS '<p>
 强合规开关日志表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."switch_id" IS '开关id';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."switch_type" IS '合规开关类型 1: 终端 2：业务 3:用户灰度  4:sku白名单';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."remark" IS '操作描述';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."create_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."rx_compliance_switch_log"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_three_import_success_item";
CREATE TABLE "dtt_demo"."public"."order_three_import_success_item"
(
    "id"      bigserial   PRIMARY KEY,
    "batch_no"    VARCHAR(64) DEFAULT NULL,
    "channel"    VARCHAR(256) DEFAULT NULL,
    "channel_store_name"    VARCHAR(64) DEFAULT NULL,
    "channel_order_no"    VARCHAR(64) DEFAULT NULL,
    "channel_product_name"    VARCHAR(64) DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "channel_product_price"    money DEFAULT NULL,
    "order_quantity"    INTEGER DEFAULT NULL,
    "nick_name"    VARCHAR(64) DEFAULT NULL,
    "phone"    VARCHAR(16) DEFAULT NULL,
    "order_amount"    money DEFAULT NULL,
    "payment_amount"    money DEFAULT NULL,
    "order_time"    TIMESTAMP DEFAULT NULL,
    "payment_method"    VARCHAR(256) DEFAULT NULL,
    "business_type"    VARCHAR(256) DEFAULT NULL,
    "remark"    VARCHAR(512) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "line_no"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "status"    INTEGER DEFAULT NULL,
    "refund_flag"    INTEGER DEFAULT NULL,
    "fosun_goods_name"    VARCHAR(64) DEFAULT NULL,
    "fosun_supplier_name"    VARCHAR(64) DEFAULT NULL,
    "fosun_good_kind"    VARCHAR(256) DEFAULT NULL,
    "fosun_goods_spec"    VARCHAR(256) DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
    "match_flag"    INTEGER DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "order_import_status"    INTEGER DEFAULT NULL,
    "refund_amount"    money DEFAULT NULL,
    "sms_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_three_import_success_item" IS '<p>
 三方订单批次成功详细表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."batch_no" IS '批次号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."channel" IS '渠道';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."channel_store_name" IS '渠道店铺名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."channel_order_no" IS '渠道订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."channel_product_name" IS '渠道商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."sku_id" IS '复星skuId';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."channel_product_price" IS '渠道售价';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."order_quantity" IS '下单数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."nick_name" IS '下单人昵称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."phone" IS '下单人手机号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."order_amount" IS '订单金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."payment_amount" IS '实付金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."order_time" IS '下单时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."payment_method" IS '支付方式';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."business_type" IS '业务类型';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."remark" IS '备注';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."line_no" IS '行数';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."order_no" IS '复星订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."status" IS '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."refund_flag" IS '退款标识 0.无退款 1.有退款';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."fosun_goods_name" IS '复星商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."fosun_supplier_name" IS '复星供应商名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."fosun_good_kind" IS '商品分类';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."fosun_goods_spec" IS '商品规格';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."update_time" IS '最后修改时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."match_flag" IS '是否匹配为正式订单是否匹配为正式订单，0未匹配，1匹配，2全部作废，3部分作废';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."order_import_status" IS '订单导入状态0未导入，1导入';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."refund_amount" IS '退款金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_three_import_success_item"."sms_flag" IS '短信发送标识 0 否 1 是';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_local_delivery";
CREATE TABLE "dtt_demo"."public"."order_local_delivery"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "deliveryman_name"    VARCHAR(64) DEFAULT NULL,
    "deliveryman_tel"    VARCHAR(16) DEFAULT NULL,
    "delivery_time"    TIMESTAMP DEFAULT NULL,
    "receiver_time"    TIMESTAMP DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL,
    "delivery_service_provider"    INTEGER DEFAULT NULL,
    "delivery_service_code"    VARCHAR(64) DEFAULT NULL,
    "delivery_status"    INTEGER DEFAULT NULL,
    "delivery_exception"    VARCHAR(256) DEFAULT NULL,
    "predict_delivery_time"    TIME DEFAULT NULL,
    "delivery_num"    BIGINT DEFAULT NULL,
    "delivery_outer_id"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_local_delivery" IS '<p>
 同城配送信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."order_item_id" IS '订单商品id';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."deliveryman_name" IS '配送员姓名';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."deliveryman_tel" IS '配送员电话';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_time" IS '发货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."receiver_time" IS '收货时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."del_flag" IS '是否删除  1 是  0  否';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_service_provider" IS '配送服务方：0 商户，1 美团';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_service_code" IS '配送服务包code';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_status" IS '配送状态：0 待商家接单，1 待骑手接单，2 待骑手取货，3 配送中，4 已完成，5 订单异常，6 已取消';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_exception" IS '配送异常信息';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."predict_delivery_time" IS '预计送达时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_num" IS '配送单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_local_delivery"."delivery_outer_id" IS '配送外部订单id';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_share_detail";
CREATE TABLE "dtt_demo"."public"."order_share_detail"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "usage_type"    INTEGER DEFAULT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "refund_order_id"    INTEGER DEFAULT NULL,
    "refund_order_no"    VARCHAR(64) DEFAULT NULL,
    "pay_no"    VARCHAR(64) DEFAULT NULL,
    "order_item_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "sku_num"    INTEGER DEFAULT NULL,
    "share_type"    INTEGER DEFAULT NULL,
    "share_bill_type"    INTEGER DEFAULT NULL,
    "share_amount"    money DEFAULT NULL,
    "share_quantity"    money DEFAULT NULL,
    "share_domain_key"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "del_flag"    INTEGER DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_share_detail" IS '<p>
 订单抵扣分摊明细
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."usage_type" IS '使用类型 0 下单，1 退款';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."order_id" IS '订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."refund_order_id" IS '退单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."refund_order_no" IS '退单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."pay_no" IS '支付交易单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."order_item_id" IS '子订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."sku_id" IS 'skuid';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."sku_num" IS '实购/实退商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."share_type" IS '0 商品分摊 1 运费分摊';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."share_bill_type" IS '分摊费用类型 2 礼品卡 3 优医币 4 邦指数 5 星喜积分 6 永城保险 7 国大保险 18 权益抵扣';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."share_amount" IS '分摊金额';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."share_quantity" IS '分摊主体数量 （如优医币数量，帮指数数量）';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."share_domain_key" IS '分摊主体, 礼品卡卡号';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."order_share_detail"."del_flag" IS '是否删除  1 是  0  否';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_jd_item";
CREATE TABLE "dtt_demo"."public"."order_jd_item"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_id"    INTEGER DEFAULT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "jd_order_id"    VARCHAR(64) DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "mall_sku_id"    VARCHAR(64) DEFAULT NULL,
    "category"    INTEGER DEFAULT NULL,
    "goods_name"    VARCHAR(64) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "goods_type"    INTEGER DEFAULT NULL,
    "goods_oid"    VARCHAR(256) DEFAULT NULL,
    "goods_price"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_jd_item" IS '<p>
 京东订单商品信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."id" IS '自增id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."order_id" IS '电商订单id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."order_no" IS '电商订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."jd_order_id" IS '京东订单号(order_jd_info中jd_order_id)';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."sku_id" IS '京东sku';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."mall_sku_id" IS '商城sku';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."category" IS '京东3级类目id';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."goods_name" IS '商品名称';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."goods_num" IS '购买商品数量(原始购买数量)';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."goods_type" IS '商品类型  0 普通、1 附件、2 赠品、3延保';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."goods_oid" IS '主商品ID';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."goods_price" IS '商品价格';
COMMENT ON COLUMN "dtt_demo"."public"."order_jd_item"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."letter_box";
CREATE TABLE "dtt_demo"."public"."letter_box"
(
    "id"      bigserial   PRIMARY KEY,
    "letter_type"    INTEGER DEFAULT NULL,
    "letter_status"    INTEGER DEFAULT NULL,
    "service_name"    VARCHAR(64) DEFAULT NULL,
    "content"    VARCHAR(768) DEFAULT NULL,
    "message_id"    VARCHAR(64) DEFAULT NULL,
    "update_date"    TIMESTAMP DEFAULT NULL,
    "create_date"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."letter_box" IS '<p>
 消息投递
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."id" IS '主键，自增长，步长＝1';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."letter_type" IS '类型 0 普通信件';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."letter_status" IS '0 未处理（默认）；1 处理失败；2 处理成功';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."service_name" IS '回调服务名称';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."content" IS '消息体';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."message_id" IS '消息id';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."update_date" IS '更新时间';
COMMENT ON COLUMN "dtt_demo"."public"."letter_box"."create_date" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."order_bang_log";
CREATE TABLE "dtt_demo"."public"."order_bang_log"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "doctor_id"    VARCHAR(64) DEFAULT NULL,
    "buyer_id"    INTEGER DEFAULT NULL,
    "status"    INTEGER DEFAULT NULL,
    "goods_info"    VARCHAR(256) DEFAULT NULL,
    "mq"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."order_bang_log" IS '<p>
 邦指数日志表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."order_no" IS '订单号';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."doctor_id" IS '医生ID';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."buyer_id" IS '买家用户ID';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."status" IS '1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."goods_info" IS '处方商品明细';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."mq" IS '消息topic';
COMMENT ON COLUMN "dtt_demo"."public"."order_bang_log"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."promotion_order_goods";
CREATE TABLE "dtt_demo"."public"."promotion_order_goods"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "order_no"    VARCHAR(64) DEFAULT NULL,
    "activity_type"    INTEGER DEFAULT NULL,
    "activity_id"    INTEGER DEFAULT NULL,
    "coupon_id"    INTEGER DEFAULT NULL,
    "coupon_no"    VARCHAR(64) DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "goods_num"    INTEGER DEFAULT NULL,
    "retail_price"    money DEFAULT NULL,
    "activity_price"    money DEFAULT NULL,
    "discount_amount"    money DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."promotion_order_goods" IS '<p>
 订单关联的促销活动的商品信息
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."order_no" IS '';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."activity_type" IS '活动类型,1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."activity_id" IS '活动表id';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."coupon_id" IS '优惠券活动表id';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."coupon_no" IS '优惠券号';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."goods_num" IS '商品数量';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."retail_price" IS '零售价';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."activity_price" IS '促销价';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."discount_amount" IS '促销优惠总金额';
COMMENT ON COLUMN "dtt_demo"."public"."promotion_order_goods"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."lottery_meeting_winner";
CREATE TABLE "dtt_demo"."public"."lottery_meeting_winner"
(
    "id"      bigserial   PRIMARY KEY,
    "batch_no"    VARCHAR(64) DEFAULT NULL,
    "oa_id"    VARCHAR(64) DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "created_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."lottery_meeting_winner" IS '<p>
 年会抽奖中将表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_winner"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_winner"."batch_no" IS '抽奖批次号';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_winner"."oa_id" IS 'OAID,如018513';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_winner"."delete_flag" IS '删除标志';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_winner"."created_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."lottery_meeting_user";
CREATE TABLE "dtt_demo"."public"."lottery_meeting_user"
(
    "id"      bigserial   PRIMARY KEY,
    "oa_id"    VARCHAR(64) DEFAULT NULL,
    "mobile"    VARCHAR(256) DEFAULT NULL,
    "user_name"    VARCHAR(64) DEFAULT NULL,
    "qualification_flag"    INTEGER DEFAULT NULL,
    "delete_flag"    INTEGER DEFAULT NULL,
    "created_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."lottery_meeting_user" IS '<p>
 年会抽奖用户表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."oa_id" IS 'OAID,如018513';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."mobile" IS '手机号';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."user_name" IS '用户名称';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."qualification_flag" IS '抽奖资格';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."delete_flag" IS '删除标志';
COMMENT ON COLUMN "dtt_demo"."public"."lottery_meeting_user"."created_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_operation_log";
CREATE TABLE "dtt_demo"."public"."carriage_operation_log"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "operation_user"    VARCHAR(16) DEFAULT NULL,
    "operation_content"    VARCHAR(768) DEFAULT NULL,
    "template_id"    INTEGER DEFAULT NULL,
    "before_change"    VARCHAR(256) DEFAULT NULL,
    "after_change"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_operation_log" IS '<p>
 运费模板操作日志
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."operation_user" IS '操作人';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."operation_content" IS '操作内容';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."template_id" IS '模板id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."before_change" IS '变更前';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."after_change" IS '变更后';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_operation_log"."create_time" IS '创建时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."car_item";
CREATE TABLE "dtt_demo"."public"."car_item"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "car_id"    INTEGER DEFAULT NULL,
    "sku_id"    VARCHAR(64) DEFAULT NULL,
    "number"    INTEGER DEFAULT NULL,
    "supplier_id"    INTEGER DEFAULT NULL,
    "activity_id"    INTEGER DEFAULT NULL,
    "goods_type"    INTEGER DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."car_item" IS '<p>
 购物车商品表
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."car_id" IS '购物车id';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."sku_id" IS 'sku id';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."number" IS '数量';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."supplier_id" IS '门店ID';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."activity_id" IS '活动id';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."goods_type" IS '商品类型 0:普通商品 1：加购商品';
COMMENT ON COLUMN "dtt_demo"."public"."car_item"."update_time" IS '最后修改时间';

DROP TABLE IF EXISTS "dtt_demo"."public"."carriage_template_shop";
CREATE TABLE "dtt_demo"."public"."carriage_template_shop"
(
    "id"        INTEGER   PRIMARY KEY NOT NULL,
    "template_id"    INTEGER DEFAULT NULL,
    "distance"    money DEFAULT NULL,
    "base_carriage_amount"    money DEFAULT NULL,
    "start_time"    VARCHAR(256) DEFAULT NULL,
    "end_time"    VARCHAR(256) DEFAULT NULL,
    "create_time"    TIMESTAMP DEFAULT NULL,
    "delivery_service_provider"    INTEGER DEFAULT NULL,
    "delivery_service_code"    VARCHAR(64) DEFAULT NULL
);
COMMENT ON TABLE "dtt_demo"."public"."carriage_template_shop" IS '<p>
 o2o运费模板
 </p>';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."id" IS '主键';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."template_id" IS '运费模板id';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."distance" IS '距离';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."base_carriage_amount" IS '基本运费额';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."start_time" IS '开始配送时间';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."end_time" IS '最后结束时间';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."create_time" IS '创建时间';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."delivery_service_provider" IS '配送服务方：0 商户，1 美团';
COMMENT ON COLUMN "dtt_demo"."public"."carriage_template_shop"."delivery_service_code" IS '配送服务包code';

DROP TABLE IF EXISTS "dtt_demo"."public"."dtt_member";
CREATE TABLE "dtt_demo"."public"."dtt_member"
(
    "id"      bigserial   PRIMARY KEY,
    "open_id"    VARCHAR(64) DEFAULT NULL,
    "nickname"    VARCHAR(64) DEFAULT NULL,
    "is_enable"    BOOLEAN DEFAULT true,
    "balance"    money DEFAULT 0.00,
    "birthday"    TIMESTAMP DEFAULT NULL,
    "member_type"    VARCHAR(256) DEFAULT 'ORDINARY',
    "status"    INTEGER DEFAULT 3,
    "deleted"    INTEGER DEFAULT 0,
    "registrar_date"    DATE DEFAULT NULL,
    "accelerate_begin_time"    TIME DEFAULT NULL,
    "accelerate_end_time"    TIME DEFAULT NULL,
    "update_time"    TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE "dtt_demo"."public"."dtt_member" IS '用户信息';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."id" IS '主键id';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."open_id" IS '用户openId';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."nickname" IS '用户昵称';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."is_enable" IS '是否启用, 默认：1';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."balance" IS '用户积分余额, 默认：0.00';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."birthday" IS '出生日期，格式：yyyy-MM-dd HH:mm:ss';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."member_type" IS '会员类型，默认：ORDINARY, Enum type:ORDINARY,STUDENT,GUNMETAL,SILVER,GOLD,DIAMOND,SPORTS,PLUS';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."status" IS '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."deleted" IS '账户注销状态；0 未注销（默认），1 已销户';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."registrar_date" IS '注册时间，格式: yyyy-MM-dd';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."accelerate_begin_time" IS '会员加速开始时间, 格式：HH:mm:ss';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."accelerate_end_time" IS '会员加速结束时间, 格式：HH:mm:ss';
COMMENT ON COLUMN "dtt_demo"."public"."dtt_member"."update_time" IS '修改时间';
