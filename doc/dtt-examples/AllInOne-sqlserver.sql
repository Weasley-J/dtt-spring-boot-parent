IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[express_kdyb_data]')
            AND type IN ('U'))
    DROP TABLE [dbo].[express_kdyb_data]
GO
CREATE TABLE [dbo].[express_kdyb_data]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [time]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [ftime]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [status]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [area_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [area_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [context]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'ftime'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'area_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'area_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'express_kdyb_data',
    'COLUMN', N'context'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_assets_relation_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_assets_relation_item]
GO
CREATE TABLE [dbo].[order_assets_relation_item]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_id]    int DEFAULT NULL,
    [order_item_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_item_id]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单权益商品订单关联表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益包订单号/权益卡订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益包订单id/权益卡订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'服务包拆分后订单号/权益卡绑定权益包订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'order_item_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'服务包拆分后订单id/权益卡绑定权益包订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'order_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_relation_item',
    'COLUMN', N'update_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_assets_extend]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_assets_extend]
GO
CREATE TABLE [dbo].[order_assets_extend]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [assets_package_id]    bigint DEFAULT NULL,
    [assets_card_template_id]    int DEFAULT NULL,
    [assets_card_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id]    int DEFAULT NULL,
    [patient_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_phone_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [original_package_instance_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [assets_package_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_type]    int DEFAULT NULL,
    [group_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [activate_begin_time]    datetime2 DEFAULT NULL,
    [activate_end_time]    datetime2 DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_item_id]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单权益扩展表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益包id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'assets_package_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益卡模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'assets_card_template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益卡号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'assets_card_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'患者id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'patient_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'患者姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'patient_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'患者身份证号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'patient_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'患者手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'patient_phone_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'doctor_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'doctor_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'源服务包实例id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'original_package_instance_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志 1 已删除 0 未删除',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益包名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'assets_package_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'2 医生端服务包，3 运营创建服务包',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'goods_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'组id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'group_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益创建0元包的时候传入的有效期开始时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'activate_begin_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益创建0元包的时候传入的有效期退款时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'activate_end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'详情订单信息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_assets_extend',
    'COLUMN', N'order_item_id'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[lottery_batchno_generator]')
            AND type IN ('U'))
    DROP TABLE [dbo].[lottery_batchno_generator]
GO
CREATE TABLE [dbo].[lottery_batchno_generator]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [created_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 年会抽奖批次号生成
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_batchno_generator'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_batchno_generator',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_batchno_generator',
    'COLUMN', N'created_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[express_record]')
            AND type IN ('U'))
    DROP TABLE [dbo].[express_record]
GO
CREATE TABLE [dbo].[express_record]
(
    [id]    int PRIMARY KEY NOT NULL,
    [com_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [com_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [exp_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [state]    int DEFAULT NULL,
    [return_status]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [return_msg]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [return_result]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [record]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sign_time]    datetime2 DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 快递记录信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'com_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递公司名称',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'com_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'exp_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单当前签收状态，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转单，10待清关，11清关中，12已清关，13清关异常，14收件人拒签',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'state'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'返回快递单监控状态 polling:监控，shutdown:结束（已签收），abort:中止，updateall:重新推送',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'return_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'返回msg',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'return_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'返回的结果',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'return_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流轨迹信息',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'record'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'签收时间',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'sign_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'express_record',
    'COLUMN', N'update_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_item]
GO
CREATE TABLE [dbo].[order_item]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [goods_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_item_id]    int DEFAULT NULL,
    [out_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [common_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_spec]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_unit]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [otc_type]    int DEFAULT NULL,
    [goods_kind]    int DEFAULT NULL,
    [org_goods_kind]    int DEFAULT NULL,
    [goods_type]    int DEFAULT NULL,
    [stock]    int DEFAULT NULL,
    [medicine_standard]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [retail_price]    decimal DEFAULT NULL,
    [purchase_price]    decimal DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [supplier_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [supplier_full_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [enable_rx]    int DEFAULT NULL,
    [rx_type]    int DEFAULT NULL,
    [show_type]    int DEFAULT NULL,
    [drug_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [wb_drug]    int DEFAULT NULL,
    [drug_id]    int DEFAULT NULL,
    [commission]    decimal DEFAULT NULL,
    [main_pic]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [total_amount]    decimal DEFAULT NULL,
    [share_amount]    decimal DEFAULT NULL,
    [discount_amount]    decimal DEFAULT NULL,
    [pay_dis_amount]    decimal DEFAULT NULL,
    [carriage_amount]    decimal DEFAULT NULL,
    [category_one]    int DEFAULT NULL,
    [category_one_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [category_two]    int DEFAULT NULL,
    [category_two_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [one_category_id]    int DEFAULT NULL,
    [one_category_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [two_category_id]    int DEFAULT NULL,
    [two_category_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [three_category_id]    int DEFAULT NULL,
    [three_category_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_onshelf_id]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [item_internal_type]    int DEFAULT NULL,
    [gift_flag]    int DEFAULT NULL,
    [gift_status]    int DEFAULT NULL,
    [buy_flag]    int DEFAULT NULL,
    [merchant_type]    int DEFAULT NULL,
    [self_flag]    int DEFAULT NULL,
    [business_flag]    int DEFAULT NULL,
    [barcode]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [insure_pay_sign]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [share_discount_code_amount]    decimal DEFAULT NULL,
    [department_channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [distribution_activity_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [distribution_out_member_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [assorted_flag]    int DEFAULT NULL,
    [warehouse_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [warehouse_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [send_supplier_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单商品表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'goods id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品系统item_id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'out_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'通用名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'common_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品规格',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_spec'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品单位：盒、袋',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_unit'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'OTC类别 1 甲类OTC 2 乙类OTC',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'otc_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品分类: 1.大健康商品 2.OTC药品 3.医疗器械 4.处方药品',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_kind'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'原始商品分类: 2.OTC 3.械字号 4.RX 5：健字号  6：消字号  7：妆字号 8：食字号 9：其它 10:权益商品 11:疫苗 12:实物权益卡 13:电子权益卡 14:体检 15:检验检测 16:报告解读 17:医美服务 18:本地生活 19:宠物服务  20:绿通 21:疫苗（新）22:核酸检测',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'org_goods_kind'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品类型:0 默认，1 全球购，2医生端权益，3消费端权益，4 疫苗',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'库存',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'stock'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'国药准字',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'medicine_standard'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'零售价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'retail_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'进货价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'purchase_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'supplier_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商全称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'supplier_full_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生开处方 1 可以开处方 0 不可以开处方',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'enable_rx'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方药类型',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'rx_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'显示方式 0 不显示 1 线上',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'show_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'药品名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'drug_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否万邦药 0 不是， 1 是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'wb_drug'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'药品id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'drug_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'佣金点数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'commission'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'列表的主图',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'main_pic'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'total_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品分摊金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'share_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'优惠金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'discount_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付通道扣减金额（非现金）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'pay_dis_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊运费，计最后一个商品',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'一级类目',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'category_one'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'一级类目名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'category_one_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'二级类目',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'category_two'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'二级类目名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'category_two_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台一级类目id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'one_category_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台一级类目名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'one_category_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台二级类目id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'two_category_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台二级类目名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'two_category_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台三级类目id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'three_category_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'后台三级类目名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'three_category_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品上架的id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'goods_onshelf_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'item内部项类型：0默认商品，1运费',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'item_internal_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'赠品标识 默认0 否，1加购，2赠品',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'gift_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'赠品状态 默认0 满足赠送条件，1 不满足赠送条件',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'gift_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商详也是否可购买 0 否 1 是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'buy_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商家类型 0 其他  1 MP  2 入仓  3 DSV',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'merchant_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否自营供应商 0 非自营 1 自营',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'self_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务标识 1保险 2云DTP 3一体化DTP',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'business_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品条形码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'barcode'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'摘要签名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'insure_pay_sign'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'虚拟优惠码分摊金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'share_discount_code_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道部门',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'department_channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分销活动编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'distribution_activity_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'所属分销员编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'distribution_out_member_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否组合商品 0否 1是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'assorted_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货仓库编码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'warehouse_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货仓库名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'warehouse_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'代发供应商编码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item',
    'COLUMN', N'send_supplier_code'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_local_delivery]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_local_delivery]
GO
CREATE TABLE [dbo].[order_local_delivery]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_item_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [deliveryman_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [deliveryman_tel]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [delivery_time]    datetime2 DEFAULT NULL,
    [receiver_time]    datetime2 DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [delivery_service_provider]    int DEFAULT NULL,
    [delivery_service_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [delivery_status]    int DEFAULT NULL,
    [delivery_exception]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [predict_delivery_time]    time DEFAULT NULL,
    [delivery_num]    bigint DEFAULT NULL,
    [delivery_outer_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 同城配送信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单商品id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'order_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送员姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'deliveryman_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送员电话',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'deliveryman_tel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'receiver_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送服务方：0 商户，1 美团',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_service_provider'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送服务包code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_service_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送状态：0 待商家接单，1 待骑手接单，2 待骑手取货，3 配送中，4 已完成，5 订单异常，6 已取消',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送异常信息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_exception'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'预计送达时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'predict_delivery_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送外部订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_local_delivery',
    'COLUMN', N'delivery_outer_id'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_three_import_batch]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_three_import_batch]
GO
CREATE TABLE [dbo].[order_three_import_batch]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [batch_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [success_number]    int DEFAULT NULL,
    [import_total_number]    int DEFAULT NULL,
    [fail_number]    int DEFAULT NULL,
    [order_import_status]    int DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 三方订单导入批次表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'批次号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'batch_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'批次导入时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'校验成功数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'success_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'导入总数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'import_total_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'校验失败数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'fail_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单导入状态0未导入，1导入',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'order_import_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_batch',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[promotion_order_goods]')
            AND type IN ('U'))
    DROP TABLE [dbo].[promotion_order_goods]
GO
CREATE TABLE [dbo].[promotion_order_goods]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [activity_type]    int DEFAULT NULL,
    [activity_id]    int DEFAULT NULL,
    [coupon_id]    int DEFAULT NULL,
    [coupon_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [retail_price]    decimal DEFAULT NULL,
    [activity_price]    decimal DEFAULT NULL,
    [discount_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单关联的促销活动的商品信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'活动类型,1 满减 2 满打折 3 秒杀活动 4 满优 5 特价,10 券,11 平台券',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'activity_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'活动表id',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'activity_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'优惠券活动表id',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'coupon_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'优惠券号',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'coupon_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'零售价',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'retail_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销价',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'activity_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销优惠总金额',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'discount_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'promotion_order_goods',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_refund_voucher]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_refund_voucher]
GO
CREATE TABLE [dbo].[order_refund_voucher]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_id]    int DEFAULT NULL,
    [refund_voucher_url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [system_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [service_platform]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [service_channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单退款凭证关联表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款凭证管理',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'refund_voucher_url'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'refund_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'system_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务平台（jd，tm,zy）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'service_platform'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务渠道（渠道id）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'service_channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志 1 已删除 0 未删除',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_voucher',
    'COLUMN', N'update_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_three_refund]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_three_refund]
GO
CREATE TABLE [dbo].[order_three_refund]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_amount]    decimal DEFAULT NULL,
    [refund_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [create_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 三方订单退款记录表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'三方渠道订单',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'channel_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'单次退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'refund_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'refund_reason'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_refund',
    'COLUMN', N'create_name'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_audiologist_remark]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_audiologist_remark]
GO
CREATE TABLE [dbo].[order_audiologist_remark]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [doctor_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [audiologist_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [configuration_location]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [shipper]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [accessories_details]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 听力师订单备注表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'doctor_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'听力师姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'audiologist_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配置地点',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'configuration_location'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货方',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'shipper'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配件详情',
    'SCHEMA', N'dbo',
    'TABLE', N'order_audiologist_remark',
    'COLUMN', N'accessories_details'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_compliance_switch_log]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_compliance_switch_log]
GO
CREATE TABLE [dbo].[rx_compliance_switch_log]
(
    [id]    int PRIMARY KEY NOT NULL,
    [switch_id]    int DEFAULT NULL,
    [switch_type]    int DEFAULT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 强合规开关日志表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'开关id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'switch_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'合规开关类型 1: 终端 2：业务 3:用户灰度  4:sku白名单',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'switch_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作描述',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'create_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_log',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_global_buy]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_global_buy]
GO
CREATE TABLE [dbo].[order_global_buy]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [customs_bill_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [bill_status]    int DEFAULT NULL,
    [pay_custom_status]    int DEFAULT NULL,
    [out_status_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_status_desc]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_status_date]    datetime2 DEFAULT NULL,
    [out_dist_status_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_dist_status_desc]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_dist_status_date]    datetime2 DEFAULT NULL,
    [first_push_date]    datetime2 DEFAULT NULL,
    [last_push_date]    datetime2 DEFAULT NULL,
    [receiver_real_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [receiver_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [del_flag]    int DEFAULT NULL,
    [link_status]    int DEFAULT NULL,
    [link_content]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [link_service_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 全球购订单信息表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'海关清单编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'customs_bill_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'单据状态: 0 默认，1 处理中，2 已放行，3 清关异常',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'bill_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付通关状态 0 未提交 1 未申报，2 申报中，3 申报成功， 4 申报失败',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'pay_custom_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部业务单据状态code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_status_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部业务单据状态描述',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_status_desc'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部业务单据状态时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_status_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部核放单据状态code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_dist_status_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部核放单据状态描述',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_dist_status_desc'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部核放单据状态时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'out_dist_status_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'首次推送时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'first_push_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后推送时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'last_push_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货人实名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'receiver_real_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货人身份证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'receiver_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'链路状态 0 -未执行支付  1-支付推送   2-支付推送失败 3- 支付查询 4-查询失败  5- 物流单号获取  6-物流单号获取失败
 7- 物流单推送海关  8-物流单推送海关失败   9-订单推送  10-订单推送失败 11-订单查询  12- 订单查询失败
 100-推送成功',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'link_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'链路入参数据',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'link_content'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'当前链路服务名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_global_buy',
    'COLUMN', N'link_service_name'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_inquiry]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_inquiry]
GO
CREATE TABLE [dbo].[order_inquiry]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [inquiry_type]    int DEFAULT NULL,
    [roam_status]    int DEFAULT NULL,
    [pres_number]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [inquiry_sign]    int DEFAULT NULL,
    [check_flow]    int DEFAULT NULL,
    [relevance_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [prescription_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [prescription_date]    datetime2 DEFAULT NULL,
    [prescribe_result]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [original_prescription_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [check_status]    int DEFAULT NULL,
    [check_msg]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [second_check_status]    int DEFAULT NULL,
    [second_check_msg]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [result_img]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [result_pdf]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_photo]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [birthday]    date DEFAULT NULL,
    [gender]    int DEFAULT NULL,
    [guard_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [guard_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [relation]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [medical_history]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [illness_offline]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [illness_offline_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [used_before]    int DEFAULT NULL,
    [adverse_reaction]    int DEFAULT NULL,
    [treatment_offline]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [consult_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [consult_status]    int DEFAULT NULL,
    [consult_date]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单问诊记录
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方类型：0后置，1前置，2后置IM 3汉利康',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'inquiry_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方实际审核流：0 一审，1 二审，2 中宝二审',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'roam_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'pres_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方标记：0 默认处方，1 主处方',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'inquiry_sign'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'审核流：0 默认一审，1 二审，2 中宝二审 3 国大 4 三方',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'check_flow'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方关联编号（主处方对应订单关联编号一致，默认处方按订单号存储）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'relevance_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'doctor_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生名字',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'doctor_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'prescription_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'prescription_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊开处方调用结果',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'prescribe_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'原处方id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'original_prescription_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方审核状态 0：待审核 1：成功 -1：失败 2：审核中 3：拆方中 4:流转中',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'check_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'审核消息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'check_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方二审状态：0 无需二审，1 待二审，2 二审中，3 二审成功，4 二审失败',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'second_check_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'二审消息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'second_check_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊结果(图片)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'result_img'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊结果(pdf)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'result_pdf'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人档案id(对接互联网医院的)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'patient_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'patient_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人身份证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'patient_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人图片信息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'patient_photo'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'出生日期',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'birthday'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'性别 0：未知 1：男，2：女',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'gender'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'监护人姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'guard_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'监护人身份证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'guard_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'与本人关系（直接存字符串）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'relation'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'其他病史,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'medical_history'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'线下确诊疾病,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'illness_offline'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'线下确诊疾病id,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'illness_offline_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'曾用过本次药品 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'used_before'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'有不良反应 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'adverse_reaction'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否复诊/线下医院就诊过 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'treatment_offline'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'互联网医院咨询单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'consult_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'互联网医院问诊单状态:0,无;1,待接诊;2,超时;3,正常结束问诊;4,交流中;5,未开处方且医生主动结束问诊;6,用户退款,关闭问诊单',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'consult_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'互联网医院问诊单创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_inquiry',
    'COLUMN', N'consult_date'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[goods_carriage_template]')
            AND type IN ('U'))
    DROP TABLE [dbo].[goods_carriage_template]
GO
CREATE TABLE [dbo].[goods_carriage_template]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [supplier_id]    int DEFAULT NULL,
    [carriage_type]    int DEFAULT NULL,
    [carriage_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [create_userid]    int DEFAULT NULL,
    [create_username]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [template_type]    int DEFAULT NULL,
    [template_status]    int DEFAULT NULL,
    [start_distance]    float DEFAULT NULL,
    [end_distance]    float DEFAULT NULL,
    [start_time]    time DEFAULT NULL,
    [end_time]    time DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 商品运费模板
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板名称',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'template_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送类型 0:自定义配送 1:全国配送',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'carriage_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'全国默认运费',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建者id',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'create_userid'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建者',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'create_username'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'模板类型 1:b2c 2:O2O配送 3:自提',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'template_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'有效状态 0:无效',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'template_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'起始距离(单位 米)',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'start_distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'结束距离(单位 米)',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'end_distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'开始配送时间',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'start_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后结束时间',
    'SCHEMA', N'dbo',
    'TABLE', N'goods_carriage_template',
    'COLUMN', N'end_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_goods_statistics]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_goods_statistics]
GO
CREATE TABLE [dbo].[order_goods_statistics]
(
    [id]    int PRIMARY KEY NOT NULL,
    [goods_id]    int DEFAULT NULL,
    [sale_amount]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单商品销售量
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_goods_statistics'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_goods_statistics',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'goods id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_goods_statistics',
    'COLUMN', N'goods_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'销售量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_goods_statistics',
    'COLUMN', N'sale_amount'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_payment_line]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_payment_line]
GO
CREATE TABLE [dbo].[order_payment_line]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [payment_status]    int DEFAULT NULL,
    [payment_date]    datetime2 DEFAULT NULL,
    [order_transaction_number]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [transaction_number]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_type]    int DEFAULT NULL,
    [pay_trade_type]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_way_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_way_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [pos_sn]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [combine_amount]    decimal DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单支付
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付状态: 1 待支付，2 支付成功 3 支付失败',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'payment_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'付款时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'payment_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单交易流水号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'order_transaction_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'交易流水号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'transaction_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付类型0现金，1虚拟',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pay_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付子类型',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pay_trade_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付代码（支付类型代码）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pay_way_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付名称（支付类型名称）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pay_way_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'本次支付金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pay_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'POS机设备号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'pos_sn'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'付款总金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_payment_line',
    'COLUMN', N'combine_amount'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_compliance_switch_user]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_compliance_switch_user]
GO
CREATE TABLE [dbo].[rx_compliance_switch_user]
(
    [id]    int PRIMARY KEY NOT NULL,
    [switch_status]    int DEFAULT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [platform_id]    int DEFAULT NULL,
    [tel_phone]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [update_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 用户强合规开关控制表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'强合规开关：0 关闭，1 开启',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'switch_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'tel_phone'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'create_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'update_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_user',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[lottery_meeting_user]')
            AND type IN ('U'))
    DROP TABLE [dbo].[lottery_meeting_user]
GO
CREATE TABLE [dbo].[lottery_meeting_user]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [oa_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [mobile]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [user_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [qualification_flag]    int DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL,
    [created_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 年会抽奖用户表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'OAID,如018513',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'oa_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'mobile'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户名称',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'user_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抽奖资格',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'qualification_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_user',
    'COLUMN', N'created_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_share_detail]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_share_detail]
GO
CREATE TABLE [dbo].[order_share_detail]
(
    [id]    int PRIMARY KEY NOT NULL,
    [usage_type]    int DEFAULT NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_order_id]    int DEFAULT NULL,
    [refund_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_item_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_num]    int DEFAULT NULL,
    [share_type]    int DEFAULT NULL,
    [share_bill_type]    int DEFAULT NULL,
    [share_amount]    decimal DEFAULT NULL,
    [share_quantity]    decimal DEFAULT NULL,
    [share_domain_key]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单抵扣分摊明细
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'使用类型 0 下单，1 退款',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'usage_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'refund_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'refund_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付交易单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'pay_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'子订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'order_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'skuid',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'实购/实退商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'sku_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'0 商品分摊 1 运费分摊',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'share_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊费用类型 2 礼品卡 3 优医币 4 邦指数 5 星喜积分 6 永城保险 7 国大保险 18 权益抵扣',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'share_bill_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'share_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊主体数量 （如优医币数量，帮指数数量）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'share_quantity'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊主体, 礼品卡卡号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'share_domain_key'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_share_detail',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_operation_log]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_operation_log]
GO
CREATE TABLE [dbo].[order_operation_log]
(
    [id]    int PRIMARY KEY NOT NULL,
    [log_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [trace_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [operation_channel]    int DEFAULT NULL,
    [operation_type]    int DEFAULT NULL,
    [operation_req]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [operation_result]    int DEFAULT NULL,
    [creator]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单操作日志
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'日志编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'log_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单编号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'refund_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'接口url',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'url'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'traceId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'trace_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作渠道 1.C端 2.E端 3.B端',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'operation_channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作类型 1.发货 2.创建退单 3.同意退货申请 4.确认退单 5.拒绝退单 6.订单列表导出',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'operation_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作入参',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'operation_req'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作结果 1.成功 2.失败',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'operation_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'creator'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_operation_log',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_compliance_switch_endpoint]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_compliance_switch_endpoint]
GO
CREATE TABLE [dbo].[rx_compliance_switch_endpoint]
(
    [id]    int PRIMARY KEY NOT NULL,
    [endpoint]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [endpoint_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [switch_status]    int DEFAULT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [update_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 终端强合规开关控制表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'终端类型 小程序-h5InWx，h5，app-wxMiniApp',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'endpoint'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'终端名称 小程序-h5InWx，h5，app-wxMiniApp',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'endpoint_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'强合规开关：0 关闭，1 开启',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'switch_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'create_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'update_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_endpoint',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_extend]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_extend]
GO
CREATE TABLE [dbo].[order_extend]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [insurance_service_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [insurance_service_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [insurance_service_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [self_lifting_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [self_lifting_code_status]    int DEFAULT NULL,
    [third_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [audiologist_out_member_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_audiologist_type]    int DEFAULT NULL,
    [third_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [area_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [day_serial_number]    int DEFAULT NULL,
    [inquiry_review]    int DEFAULT NULL,
    [reserved_mobile]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单附加信息表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'保障服务id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'insurance_service_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'保障服务code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'insurance_service_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'保障服务名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'insurance_service_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付跳转链接',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'pay_url'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'核销码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'self_lifting_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 已核销，0为核销',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'self_lifting_code_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'三方订单号(复联)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'third_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'听力师id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'audiologist_out_member_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'听力师订单类型 0推荐订单 1代下订单',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'order_audiologist_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'三方商户编码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'third_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'区域编码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'area_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'店铺每日订单序号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'day_serial_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方是否需要二审 0:不需要  1：需要',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'inquiry_review'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自提预留手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_extend',
    'COLUMN', N'reserved_mobile'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[log_outer_reqst]')
            AND type IN ('U'))
    DROP TABLE [dbo].[log_outer_reqst]
GO
CREATE TABLE [dbo].[log_outer_reqst]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [outer_code]    int DEFAULT NULL,
    [outer_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [request_uri]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [request_params]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [response_result]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 外部请求日志记录
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部渠道code 1：京东',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'outer_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部渠道名称',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'outer_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'请求地址(去掉域名和请求参数)',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'request_uri'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'请求参数',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'request_params'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'返回参数',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'response_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'log_outer_reqst',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_express]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_express]
GO
CREATE TABLE [dbo].[order_express]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_item_id]    int DEFAULT NULL,
    [goods_num]    int DEFAULT NULL,
    [invoice_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_company]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [delivery_time]    datetime2 DEFAULT NULL,
    [receiver_time]    datetime2 DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [create_user_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单物流
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单商品id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'order_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'invoice_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'express_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'express_company'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'delivery_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'receiver_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货创建人名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_express',
    'COLUMN', N'create_user_name'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_yaofang_split]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_yaofang_split]
GO
CREATE TABLE [dbo].[order_yaofang_split]
(
    [id]    int PRIMARY KEY NOT NULL,
    [original_order_id]    int DEFAULT NULL,
    [original_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [split_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [inquiry_type]    int DEFAULT NULL,
    [goods_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [invoice_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_company]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [delivery_time]    datetime2 DEFAULT NULL,
    [receiver_time]    datetime2 DEFAULT NULL,
    [prescription_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [check_status]    int DEFAULT NULL,
    [check_msg]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [result_img]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [result_pdf]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [patient_photo]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [birthday]    date DEFAULT NULL,
    [gender]    int DEFAULT NULL,
    [guard_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [guard_id_card]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [relation]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [medical_history]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [illness_offline]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [illness_offline_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [used_before]    int DEFAULT NULL,
    [adverse_reaction]    int DEFAULT NULL,
    [treatment_offline]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [prescribe_result]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 药房网订单分单表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'原订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'original_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'原订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'original_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分单订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'split_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方类型：0后置，1前置',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'inquiry_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'goods id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'goods_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'out_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'invoice_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'express_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'express_company'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'delivery_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'receiver_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'prescription_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方审核状态 0：待审核 1：成功 -1：失败 2：审核中',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'check_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'审核消息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'check_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊结果(图片)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'result_img'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊结果(pdf)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'result_pdf'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人档案id(对接互联网医院的)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'patient_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生名字',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'doctor_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'doctor_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'patient_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人身份证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'patient_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用药人图片信息',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'patient_photo'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'出生日期',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'birthday'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'性别 0：未知 1：男，2：女',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'gender'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'监护人姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'guard_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'监护人身份证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'guard_id_card'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'与本人关系（直接存字符串）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'relation'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'其他病史,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'medical_history'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'线下确诊疾病,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'illness_offline'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'线下确诊疾病id,多个逗号分隔',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'illness_offline_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'曾用过本次药品 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'used_before'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'有不良反应 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'adverse_reaction'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'线下医院就诊过 0：否 1：是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'treatment_offline'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊开处方调用结果',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'prescribe_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_yaofang_split',
    'COLUMN', N'goods_num'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_refund]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_refund]
GO
CREATE TABLE [dbo].[order_refund]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_type]    int DEFAULT NULL,
    [status]    int DEFAULT NULL,
    [channel]    int DEFAULT NULL,
    [platform_id]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [refund_amount]    decimal DEFAULT NULL,
    [refund_carriage_amount]    decimal DEFAULT NULL,
    [refund_pay_dis_amount]    decimal DEFAULT NULL,
    [address]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_id]    int DEFAULT NULL,
    [buyer_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_tel]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [item_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_id]    int DEFAULT NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [supplier_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [chain_shop_id]    int DEFAULT NULL,
    [chain_shop_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [retail_shop_id]    int DEFAULT NULL,
    [retail_shop_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [supplier_full_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_way_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_way_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [finished_time]    datetime2 DEFAULT NULL,
    [cancel_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [del_flag]    int DEFAULT NULL,
    [pay_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [third_transaction_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [supplement_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [rejective_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [out_member_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [return_deduction_amount]    decimal DEFAULT NULL,
    [return_deduction_score_amount]    decimal DEFAULT NULL,
    [return_deduction_card_amount]    decimal DEFAULT NULL,
    [return_health_coin]    int DEFAULT NULL,
    [return_bang_coin]    int DEFAULT NULL,
    [express_method]    int DEFAULT NULL,
    [invoice_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [picture_url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 退单主表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'refund_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 退款 2 退货 3 退货退款',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'refund_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 待退款 2 退款关闭 3 商家审核 4 商品寄回 5 商家确认退款 6 退款成功 7 退货待审核',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 线下E端 2 线上C端 3 线下B端',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'refund_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'refund_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'非现金支付退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'refund_pay_dis_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货地址合并省市区',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'address'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'买家用户ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'buyer_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者用户名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'buyer_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者电话',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'buyer_tel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'item id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'goods id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'goods_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'supplier_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'连锁店id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'chain_shop_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'连锁店名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'chain_shop_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'门店id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'retail_shop_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'门店名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'retail_shop_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商全称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'supplier_full_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付代码（支付类型代码）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'pay_way_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付名称（支付类型名称）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'pay_way_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单完成时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'finished_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'cancel_reason'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付交易单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'pay_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'三方流水号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'third_transaction_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'补充原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'supplement_reason'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'拒绝原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'rejective_reason'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大会员系统的会员id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'out_member_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单归还抵扣金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'return_deduction_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单归还抵扣金额（优医币，邦指数）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'return_deduction_score_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单归还抵扣金额（礼品卡）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'return_deduction_card_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单归还抵扣优医币',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'return_health_coin'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单归还抵扣邦指数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'return_bang_coin'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退货物流方式 1.无退货物流 2.原运单退回 3.新运单退回',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'express_method'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'invoice_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'express_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款图片凭证',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund',
    'COLUMN', N'picture_url'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_promotion]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_promotion]
GO
CREATE TABLE [dbo].[order_promotion]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [promotion_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [promotion_type]    int DEFAULT NULL,
    [promotion_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [promotion_discount_amount]    decimal DEFAULT NULL,
    [promotion_description]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [promotion_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [platform_id]    int DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL,
    [coupon_platform]    int DEFAULT NULL,
    [promotion_sub_type]    int DEFAULT NULL,
    [promotion_sub_type_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单关联促销表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'order表id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部促销id，由促销系统提供',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销类型，由促销系统提供0优惠券，1活动，2国大保险，3永诚保险，4积分，5优惠码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销名称，由促销系统提供',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销优惠金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_discount_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销描述信息，由促销系统提供',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_description'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销券码，由促销系统提供',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销平台',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志 1 已删除 0 未删除',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'优惠券平台类型 默认1:店铺券，2:平台券',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'coupon_platform'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销子类型 优惠券类型 1 满减劵 2 折扣券 3 现金券, 活动类型：1 特价 2秒杀 3满减 4满折 5满赠 6加购 7分销 8积分 0国大保险 12永诚保险 13健康积分 14优惠码',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_sub_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'促销子类型名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_promotion',
    'COLUMN', N'promotion_sub_type_name'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_three_import_fail_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_three_import_fail_item]
GO
CREATE TABLE [dbo].[order_three_import_fail_item]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [batch_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_store_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_product_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_product_price]    decimal DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_quantity]    int DEFAULT NULL,
    [nick_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [phone]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_amount]    decimal DEFAULT NULL,
    [payment_amount]    decimal DEFAULT NULL,
    [order_time]    datetime2 DEFAULT NULL,
    [payment_method]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [business_type]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [line_no]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fail_message]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_supplier_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_good_kind]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_goods_spec]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 三方订单批次失败详细表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'批次号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'batch_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道店铺名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'channel_store_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'channel_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'channel_product_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道售价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'channel_product_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'order_quantity'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单人昵称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'nick_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单人手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'phone'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'order_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'实付金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'payment_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'order_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付方式',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'payment_method'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务类型',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'business_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'行数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'line_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'失败原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'fail_message'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'fosun_goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星供应商名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'fosun_supplier_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品分类',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'fosun_good_kind'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品规格',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'fosun_goods_spec'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_fail_item',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_template_content]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_template_content]
GO
CREATE TABLE [dbo].[carriage_template_content]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_id]    int DEFAULT NULL,
    [region_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [base_carriage_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 运费模板内容
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content',
    'COLUMN', N'template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大区名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content',
    'COLUMN', N'region_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'基本运费金额',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content',
    'COLUMN', N'base_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_content',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_bang_log]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_bang_log]
GO
CREATE TABLE [dbo].[order_bang_log]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [doctor_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_id]    int DEFAULT NULL,
    [status]    int DEFAULT NULL,
    [goods_info]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [mq]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 邦指数日志表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'医生ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'doctor_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'买家用户ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'buyer_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'处方商品明细',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'goods_info'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'消息topic',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'mq'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_bang_log',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[lottery_meeting_winner]')
            AND type IN ('U'))
    DROP TABLE [dbo].[lottery_meeting_winner]
GO
CREATE TABLE [dbo].[lottery_meeting_winner]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [batch_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [oa_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [delete_flag]    int DEFAULT NULL,
    [created_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 年会抽奖中将表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抽奖批次号',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner',
    'COLUMN', N'batch_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'OAID,如018513',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner',
    'COLUMN', N'oa_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'lottery_meeting_winner',
    'COLUMN', N'created_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_batch_ship_req]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_batch_ship_req]
GO
CREATE TABLE [dbo].[order_batch_ship_req]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [invoice_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [com_code_kdyb]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'延迟发货',
    'SCHEMA', N'dbo',
    'TABLE', N'order_batch_ship_req'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_batch_ship_req',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_batch_ship_req',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_batch_ship_req',
    'COLUMN', N'invoice_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递100物流公司ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_batch_ship_req',
    'COLUMN', N'com_code_kdyb'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_three_import_success_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_three_import_success_item]
GO
CREATE TABLE [dbo].[order_three_import_success_item]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [batch_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_store_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_product_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_product_price]    decimal DEFAULT NULL,
    [order_quantity]    int DEFAULT NULL,
    [nick_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [phone]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_amount]    decimal DEFAULT NULL,
    [payment_amount]    decimal DEFAULT NULL,
    [order_time]    datetime2 DEFAULT NULL,
    [payment_method]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [business_type]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [line_no]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [status]    int DEFAULT NULL,
    [refund_flag]    int DEFAULT NULL,
    [fosun_goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_supplier_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_good_kind]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [fosun_goods_spec]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [match_flag]    int DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [order_import_status]    int DEFAULT NULL,
    [refund_amount]    decimal DEFAULT NULL,
    [sms_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 三方订单批次成功详细表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'批次号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'batch_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道店铺名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'channel_store_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'channel_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'channel_product_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星skuId',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道售价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'channel_product_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'order_quantity'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单人昵称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'nick_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单人手机号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'phone'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'order_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'实付金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'payment_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'下单时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'order_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付方式',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'payment_method'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务类型',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'business_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'行数',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'line_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款标识 0.无退款 1.有退款',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'refund_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'fosun_goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'复星供应商名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'fosun_supplier_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品分类',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'fosun_good_kind'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品规格',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'fosun_goods_spec'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否匹配为正式订单是否匹配为正式订单，0未匹配，1匹配，2全部作废，3部分作废',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'match_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单导入状态0未导入，1导入',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'order_import_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'refund_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'短信发送标识 0 否 1 是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_three_import_success_item',
    'COLUMN', N'sms_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_compliance_switch]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_compliance_switch]
GO
CREATE TABLE [dbo].[rx_compliance_switch]
(
    [id]    int PRIMARY KEY NOT NULL,
    [switch_status]    int DEFAULT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [platform_id]    int DEFAULT NULL,
    [system_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [system_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [update_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 强合规开关控制表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'强合规开关：0 关闭，1 开启',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'switch_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'system_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'系统来源名称0 商城，1疫苗，2三方订单，3DTP，4复联，5国大，6听力师',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'system_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'create_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'update_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[region_province_mapping]')
            AND type IN ('U'))
    DROP TABLE [dbo].[region_province_mapping]
GO
CREATE TABLE [dbo].[region_province_mapping]
(
    [id]    int PRIMARY KEY NOT NULL,
    [province]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [region_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 区域省的映射关系
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'region_province_mapping'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'region_province_mapping',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'省名称',
    'SCHEMA', N'dbo',
    'TABLE', N'region_province_mapping',
    'COLUMN', N'province'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大区名称',
    'SCHEMA', N'dbo',
    'TABLE', N'region_province_mapping',
    'COLUMN', N'region_name'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[car_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[car_item]
GO
CREATE TABLE [dbo].[car_item]
(
    [id]    int PRIMARY KEY NOT NULL,
    [car_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [number]    int DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [activity_id]    int DEFAULT NULL,
    [goods_type]    int DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 购物车商品表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购物车id',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'car_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'数量',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'门店ID',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'活动id',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'activity_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品类型 0:普通商品 1：加购商品',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'goods_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'car_item',
    'COLUMN', N'update_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[express_company]')
            AND type IN ('U'))
    DROP TABLE [dbo].[express_company]
GO
CREATE TABLE [dbo].[express_company]
(
    [id]    int PRIMARY KEY NOT NULL,
    [express_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [express_company]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [com_code_kdw]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [com_code_kdyb]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [default_flag]    int DEFAULT NULL,
    [oms_express_company_id]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 物流公司
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'express_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流公司名称',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'express_company'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递网物流公司code',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'com_code_kdw'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递100物流公司ID',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'com_code_kdyb'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否默认 0默认 1 不默认(用于第三方模糊匹配重复的场景)',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'default_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'oms快递公司id',
    'SCHEMA', N'dbo',
    'TABLE', N'express_company',
    'COLUMN', N'oms_express_company_id'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_card_record]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_card_record]
GO
CREATE TABLE [dbo].[order_card_record]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [assets_card_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [use_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单礼品卡记录表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'卡号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'assets_card_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'使用金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'use_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_card_record',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_jd_refund]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_jd_refund]
GO
CREATE TABLE [dbo].[order_jd_refund]
(
    [id]    int PRIMARY KEY NOT NULL,
    [jd_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_id]    int DEFAULT NULL,
    [refund_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_item_id]    int DEFAULT NULL,
    [mall_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [finished_time]    datetime2 DEFAULT NULL,
    [customer_expect]    int DEFAULT NULL,
    [status]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [refund_amount]    decimal DEFAULT NULL,
    [address]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_id]    int DEFAULT NULL,
    [buyer_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_tel]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [cancel_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 京东退单主表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'jd_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'refund_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'refund_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单商品id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'order_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商城sku',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'mall_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东sku',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单完成时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'finished_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'10退货，20换货，30维修',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'customer_expect'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单状态 10申请中待审核；20审核完成待收货；30收货完成待处理；40处理完成（如需退款则等待退款）；50待用户确认，60用户确认完成，70取消',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'refund_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货地址合并省市区',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'address'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'买家用户ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'buyer_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者用户名',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'buyer_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者电话',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'buyer_tel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单原因',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_refund',
    'COLUMN', N'cancel_reason'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_compliance_switch_sku]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_compliance_switch_sku]
GO
CREATE TABLE [dbo].[rx_compliance_switch_sku]
(
    [id]    int PRIMARY KEY NOT NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [platform_id]    int DEFAULT NULL,
    [item_id]    int DEFAULT NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [update_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 sku强合规开关控制表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'remark'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'itemid',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'create_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'update_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_compliance_switch_sku',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_template_platform]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_template_platform]
GO
CREATE TABLE [dbo].[carriage_template_platform]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_id]    int DEFAULT NULL,
    [province_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [base_carriage_amount]    decimal DEFAULT NULL,
    [free_carriage_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 平台物流运费模板
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'省份名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'province_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'基本运费⾦额',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'base_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'免运费阈值',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'free_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_platform',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_vaccines_extend]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_vaccines_extend]
GO
CREATE TABLE [dbo].[order_vaccines_extend]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [cancel_duration]    int DEFAULT NULL,
    [out_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [out_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单疫苗扩展表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'取消时长',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'cancel_duration'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'out_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'out_goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部商品id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'out_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志 1 已删除 0 未删除',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'delete_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_vaccines_extend',
    'COLUMN', N'update_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[near_pharmacy_dto]')
            AND type IN ('U'))
    DROP TABLE [dbo].[near_pharmacy_dto]
GO
CREATE TABLE [dbo].[near_pharmacy_dto]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [abbr_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [full_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [distance]    float DEFAULT NULL,
    [logo_url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [template_type]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [lng]    float DEFAULT 0.0,
    [lat]    float DEFAULT 0.0,
    [start_distance]    decimal DEFAULT NULL,
    [end_distance]    decimal DEFAULT NULL,
    [start_time]    time DEFAULT NULL,
    [end_time]    time DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'简称',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'abbr_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'全称',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'full_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'距离',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'logo图片',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'logo_url'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1:b2c 2:O2O配送 3:自提',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'template_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'店铺经度',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'lng'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'店铺纬度',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'lat'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'起始距离(单位 米)',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'start_distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'结束距离(单位 米)',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'end_distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'开始配送时间',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'start_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后结束时间',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'near_pharmacy_dto',
    'COLUMN', N'supplier_id'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_template_region]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_template_region]
GO
CREATE TABLE [dbo].[carriage_template_region]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_id]    int DEFAULT NULL,
    [region_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [base_carriage_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 区域模板内容
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region',
    'COLUMN', N'template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大区名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region',
    'COLUMN', N'region_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'基本运费金额',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region',
    'COLUMN', N'base_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_region',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[car_shopping]')
            AND type IN ('U'))
    DROP TABLE [dbo].[car_shopping]
GO
CREATE TABLE [dbo].[car_shopping]
(
    [id]    int PRIMARY KEY NOT NULL,
    [member_id]    int DEFAULT NULL,
    [platform_id]    int DEFAULT NULL,
    [count]    int DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 购物车主表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员id',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'member_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户购物车已存放的商品数，限制最大99',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'count'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'连锁店ID',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'car_shopping',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[letter_box]')
            AND type IN ('U'))
    DROP TABLE [dbo].[letter_box]
GO
CREATE TABLE [dbo].[letter_box]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [letter_type]    int DEFAULT NULL,
    [letter_status]    int DEFAULT NULL,
    [service_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [content]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [message_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [update_date]    datetime2 DEFAULT NULL,
    [create_date]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 消息投递
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键，自增长，步长＝1',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'类型 0 普通信件',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'letter_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'0 未处理（默认）；1 处理失败；2 处理成功',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'letter_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'回调服务名称',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'service_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'消息体',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'content'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'消息id',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'message_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'更新时间',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'update_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'letter_box',
    'COLUMN', N'create_date'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_comment]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_comment]
GO
CREATE TABLE [dbo].[order_comment]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [comment_content]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_user_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [update_user_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [update_time]    datetime2(7) DEFAULT CURRENT_TIMESTAMP    NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单备注表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'备注内容',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'comment_content'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建人名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'create_user_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改人名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'update_user_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'update_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_comment',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_operation_log]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_operation_log]
GO
CREATE TABLE [dbo].[carriage_operation_log]
(
    [id]    int PRIMARY KEY NOT NULL,
    [operation_user]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [operation_content]    varchar(768) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [template_id]    int DEFAULT NULL,
    [before_change]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [after_change]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 运费模板操作日志
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作人',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'operation_user'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'操作内容',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'operation_content'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'变更前',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'before_change'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'变更后',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'after_change'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_operation_log',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[express_subscribe]')
            AND type IN ('U'))
    DROP TABLE [dbo].[express_subscribe]
GO
CREATE TABLE [dbo].[express_subscribe]
(
    [id]    int PRIMARY KEY NOT NULL,
    [sub_platform]    int DEFAULT NULL,
    [com_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [exp_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sub_info]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sub_result]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [result_status]    int DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 快递订阅记录
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订阅平台 1:快递网 2快递100',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'sub_platform'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递公司code(与平台相关)',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'com_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'快递单号',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'exp_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订阅信息',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'sub_info'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订阅返回值',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'sub_result'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否订阅成功 1成功 0:失败',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'result_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'express_subscribe',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_template]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_template]
GO
CREATE TABLE [dbo].[carriage_template]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [platform_id]    int DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [free_carriage_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [create_userid]    int DEFAULT NULL,
    [create_username]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [template_type]    int DEFAULT NULL,
    [delete_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 运费模板
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'template_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 商家后台',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'免运费阈值',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'free_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建者id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'create_userid'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建者',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'create_username'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'模板类型 1:云药房模板 2:O2O配送 3:物流配送',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'template_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'删除标志 1 已删除 0 未删除',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template',
    'COLUMN', N'delete_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_template_shop]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_template_shop]
GO
CREATE TABLE [dbo].[carriage_template_shop]
(
    [id]    int PRIMARY KEY NOT NULL,
    [template_id]    int DEFAULT NULL,
    [distance]    decimal DEFAULT NULL,
    [base_carriage_amount]    decimal DEFAULT NULL,
    [start_time]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [end_time]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [delivery_service_provider]    int DEFAULT NULL,
    [delivery_service_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 o2o运费模板
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费模板id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'template_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'距离',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'distance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'基本运费额',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'base_carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'开始配送时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'start_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'最后结束时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送服务方：0 商户，1 美团',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'delivery_service_provider'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'配送服务包code',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_template_shop',
    'COLUMN', N'delivery_service_code'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_jd_info]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_jd_info]
GO
CREATE TABLE [dbo].[order_jd_info]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [p_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [jd_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [freight]    decimal DEFAULT NULL,
    [order_price]    decimal DEFAULT NULL,
    [order_tax_price]    decimal DEFAULT NULL,
    [order_state]    int DEFAULT NULL,
    [state]    int DEFAULT NULL,
    [submit_state]    int DEFAULT NULL,
    [jd_order_state]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [finish_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 京东订单信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'电商订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'电商订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东父单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'p_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'jd_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'freight'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单总金额（不包含运费）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'order_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单税额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'order_tax_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单状态。0为取消订单  1为有效。',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'order_state'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'物流状态。0 是新建  1是妥投   2是拒收',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'state'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'预占确认状态。0没确认预占;1已确认预占',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'submit_state'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东订单状态 1.新单;2.等待支付;3.等待支付确认;4.延迟付款确认;5.订单暂停;6.店长最终审核;7.等待打印;8.等待出库;9.等待打包;10.等待发货;11.自提途中;12.上门提货;13.自提退货;14.确认自提;16.等待确认收货;17.配送退货;18.货到付款确认;19.已完成;21.收款确认;22.锁定;29.等待三方出库;30.等待三方发货;31.等待三方发货完成',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'jd_order_state'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单完成时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_info',
    'COLUMN', N'finish_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_item_assorted_detail]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_item_assorted_detail]
GO
CREATE TABLE [dbo].[order_item_assorted_detail]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [item_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_id]    int DEFAULT NULL,
    [goods_item_id]    int DEFAULT NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [son_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_spec]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_unit]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [main_pic]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [retail_price]    decimal DEFAULT NULL,
    [purchase_price]    decimal DEFAULT NULL,
    [total_amount]    decimal DEFAULT NULL,
    [share_amount]    decimal DEFAULT NULL,
    [assorted_flag]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单商品-组合商品明细
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'编号;主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单唯一编号;订单主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品唯一编号;订单商品主键',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号;订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'SPU编号;goods id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品系统item_id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_item_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主品SKUID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'子品sku id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'son_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'名称;商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'规格;商品规格',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_spec'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'单位;商品单位：盒、袋',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_unit'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主图;列表的主图',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'main_pic'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'数量;商品数量',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'零售价;零售价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'retail_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'进货价;进货价',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'purchase_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'总金额;商品金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'total_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'分摊金额;商品分摊金额',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'share_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否主品;是否主品 0否,1是',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'assorted_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间;创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_item_assorted_detail',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[record_jd_msg]')
            AND type IN ('U'))
    DROP TABLE [dbo].[record_jd_msg]
GO
CREATE TABLE [dbo].[record_jd_msg]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [jd_msg_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [jd_msg]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [msg_type]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 京东消息信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东消息id',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg',
    'COLUMN', N'jd_msg_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东消息',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg',
    'COLUMN', N'jd_msg'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'消息类型',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg',
    'COLUMN', N'msg_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'record_jd_msg',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[rx_inquiry_log]')
            AND type IN ('U'))
    DROP TABLE [dbo].[rx_inquiry_log]
GO
CREATE TABLE [dbo].[rx_inquiry_log]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_ids]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [consult_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [consult_status]    int DEFAULT NULL,
    [platform_id]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [url]    varchar(128) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [remark]    varchar(512) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 问诊记录日志表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'order_ids'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'咨询单号',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'consult_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊单状态:0,待接诊;4,超时;5,交流中;6,处方已开出且正常结束;100,未开处方且医生主动结束订单 101：用户退款，问诊单关闭',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'consult_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：1 商城 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊请求url',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'url'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'问诊异常备注',
    'SCHEMA', N'dbo',
    'TABLE', N'rx_inquiry_log',
    'COLUMN', N'remark'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_refund_payment_line]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_refund_payment_line]
GO
CREATE TABLE [dbo].[order_refund_payment_line]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_payment_status]    int DEFAULT NULL,
    [refund_payment_date]    datetime2 DEFAULT NULL,
    [order_transaction_number]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [transaction_number]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_type]    int DEFAULT NULL,
    [pay_way_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_way_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [pay_amount]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [del_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 退单支付
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'refund_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付状态: 1 待支付，2 支付成功 3 支付失败',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'refund_payment_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'付款时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'refund_payment_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单交易流水号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'order_transaction_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'交易流水号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'transaction_number'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付类型 0现金，1虚拟',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'pay_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付代码（支付类型代码）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'pay_way_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收付名称（支付类型名称）',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'pay_way_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'本次支付金额(退款)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'pay_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'order_refund_payment_line',
    'COLUMN', N'del_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[carriage_region_province]')
            AND type IN ('U'))
    DROP TABLE [dbo].[carriage_region_province]
GO
CREATE TABLE [dbo].[carriage_region_province]
(
    [id]    int PRIMARY KEY NOT NULL,
    [province]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [region_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [region_id]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 区域省映射关系
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_region_province'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_region_province',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'省名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_region_province',
    'COLUMN', N'province'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大区名称',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_region_province',
    'COLUMN', N'region_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'区域id',
    'SCHEMA', N'dbo',
    'TABLE', N'carriage_region_province',
    'COLUMN', N'region_id'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[order_jd_item]')
            AND type IN ('U'))
    DROP TABLE [dbo].[order_jd_item]
GO
CREATE TABLE [dbo].[order_jd_item]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_id]    int DEFAULT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [jd_order_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [mall_sku_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [category]    int DEFAULT NULL,
    [goods_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_num]    int DEFAULT NULL,
    [goods_type]    int DEFAULT NULL,
    [goods_oid]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [goods_price]    decimal DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 京东订单商品信息
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'自增id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'电商订单id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'电商订单号',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东订单号(order_jd_info中jd_order_id)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'jd_order_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东sku',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商城sku',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'mall_sku_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'京东3级类目id',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'category'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品名称',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'goods_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买商品数量(原始购买数量)',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'goods_num'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品类型  0 普通、1 附件、2 赠品、3延保',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'goods_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主商品ID',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'goods_oid'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商品价格',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'goods_price'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'order_jd_item',
    'COLUMN', N'create_time'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[trade_order]')
            AND type IN ('U'))
    DROP TABLE [dbo].[trade_order]
GO
CREATE TABLE [dbo].[trade_order]
(
    [id]    int PRIMARY KEY NOT NULL,
    [order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [parent_order_no]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [status]    int DEFAULT NULL,
    [order_type]    int DEFAULT NULL,
    [create_time]    datetime2 DEFAULT NULL,
    [total_amount]    decimal DEFAULT NULL,
    [discount_amount]    decimal DEFAULT NULL,
    [pay_dis_amount]    decimal DEFAULT NULL,
    [carriage_amount]    decimal DEFAULT NULL,
    [payment_amount]    decimal DEFAULT NULL,
    [buyer_id]    int DEFAULT NULL,
    [buyer_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [buyer_tel]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [receiver_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [receiver_tel]    varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [receiver_time]    datetime2 DEFAULT NULL,
    [province]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [city]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [area]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [address]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [evaluation_status]    int DEFAULT NULL,
    [evaluation_time]    datetime2 DEFAULT NULL,
    [delivery_time]    datetime2 DEFAULT NULL,
    [finished_time]    datetime2 DEFAULT NULL,
    [anonymous]    int DEFAULT NULL,
    [postscript]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [cancel_reason]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [platform_id]    int DEFAULT NULL,
    [supplier_id]    int DEFAULT NULL,
    [supplier_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [chain_shop_id]    int DEFAULT NULL,
    [chain_shop_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [retail_shop_id]    int DEFAULT NULL,
    [retail_shop_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [supplier_full_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [original_system]    int DEFAULT NULL,
    [del_flag]    int DEFAULT NULL,
    [deduction_amount]    decimal DEFAULT NULL,
    [deduction_score_amount]    decimal DEFAULT NULL,
    [deduction_card_amount]    decimal DEFAULT NULL,
    [health_coin]    int DEFAULT NULL,
    [bang_coin]    int DEFAULT NULL,
    [out_member_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [channel_source]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [endpoint]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [external_value]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [refund_flag]    int DEFAULT NULL,
    [cancel_time]    datetime2 DEFAULT NULL,
    [system_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [service_platform]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [service_channel]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [order_comment]    varchar(256) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [comment_time]    datetime2 DEFAULT NULL,
    [global_activity_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [global_channel_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [assets_type]    int DEFAULT NULL,
    [delivery_type]    int DEFAULT NULL,
    [merchant_type]    int DEFAULT NULL,
    [self_flag]    int DEFAULT NULL,
    [business_flag]    int DEFAULT NULL,
    [receiver_lat]    decimal DEFAULT NULL,
    [receiver_lng]    decimal DEFAULT NULL,
    [org_code]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [org_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [wms_warehouse_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [wms_warehouse_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [client_type]    int DEFAULT NULL,
    [device_name]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [distribution_flag]    int DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'<p>
 订单主表
 </p>',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'父单号（多订单提交生成新父单号，单订单提交与订单号一致）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'parent_order_no'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'1 待付款 2 交易取消 3 待发货 4 交易关闭 5 已发货 6 交易成功',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单类型0 默认，1 全球购，2 权益包，3 疫苗，4 o2o，5 连锁，6 云药房 7 连锁供应链',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'order_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'创建时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'create_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单总金额',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'total_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'优惠总金额',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'discount_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'支付通道扣减金额（非现金）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'pay_dis_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'运费',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'carriage_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单应付金额',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'payment_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'买家用户ID',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'buyer_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者用户名',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'buyer_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'购买者电话',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'buyer_tel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货人姓名',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'receiver_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货人电话',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'receiver_tel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单收货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'receiver_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'省',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'province'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'市',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'city'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'区',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'area'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货人详细地址',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'address'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'评价状态 0 未评价 1 已评价',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'evaluation_status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'评价时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'evaluation_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'发货时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'delivery_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单完成时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'finished_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否匿名',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'anonymous'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单留言',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'postscript'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'取消订单原因',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'cancel_reason'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'平台：0 无 1 普通会员 2 医生-优医邦 3 药店（邦甸园）4 药店云',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'platform_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'supplier_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'supplier_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'连锁店id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'chain_shop_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'连锁店名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'chain_shop_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'门店id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'retail_shop_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'门店名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'retail_shop_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'供应商全称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'supplier_full_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否老系统：1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'original_system'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否删除  1 是  0  否',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'del_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抵扣金额',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'deduction_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抵扣金额（优医币，邦指数）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'deduction_score_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抵扣金额（礼品卡）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'deduction_card_amount'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抵扣优医币',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'health_coin'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'抵扣邦指数',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'bang_coin'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'大会员系统的会员id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'out_member_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'渠道来源',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'channel_source'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'终端类型 h5InWx，h5，wxMiniApp',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'endpoint'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'外部参数（根据外部需求放入）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'external_value'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'退款标识 0.无退款 1.有退款',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'refund_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单取消时间',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'cancel_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'系统来源0 商城，1疫苗，2三方订单，3一体化DTP，4复联，5国大，6听力师，7永城，8 影像，9 慈丹，10 宝宝树，11 元气森林，12 星喜，13 老庙,14 汉利康',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'system_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务平台 0 星苗自营、1天猫、2京东、3百度、4腾讯、5其他、7快手、6抖音、8网易严选、9口碑、10 医鹿',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'service_platform'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务渠道（渠道id）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'service_channel'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单备注，仅供后台使用，无业务交互',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'order_comment'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'订单备注时间，编辑备注覆盖',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'comment_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'全局活动id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'global_activity_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'全局渠道id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'global_channel_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'权益订单子类型：0 默认，1 普通权益包，2 实体卡，3 电子卡，4 实体卡激活权益包，
 5 电子卡激活权益包 6 礼品卡电子卡 7 礼品卡实体卡   8 权益包升级，9三方权益订单  100006.基因检测发放 100007.体检发放 100008.苏可欣发放',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'assets_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'0默认物流，1o2o在线配送，2自提',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'delivery_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'商家类型 0 其他  1 MP  2 入仓  3 DSV',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'merchant_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否自营供应商 0 非自营 1 自营',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'self_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'业务标识 1保险 2云DTP 3一体化DTP',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'business_flag'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货地址纬度',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'receiver_lat'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'收货地址经度',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'receiver_lng'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'机构编码',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'org_code'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'机构名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'org_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'仓库id',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'wms_warehouse_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'仓库名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'wms_warehouse_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'终端类型
 1.小程序原生页面 2.ios原生的页面 3.android原生的页面 4.h5页面在微信小程序里打开 5.h5页面在微信浏览器中打开，不包括微信小程序 6.不在上述情况下的值',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'client_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'应用名称',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'device_name'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否参与分销 0否,1是 （分销信息见order_extend）',
    'SCHEMA', N'dbo',
    'TABLE', N'trade_order',
    'COLUMN', N'distribution_flag'
GO


IF EXISTS(SELECT *
          FROM sys.all_objects
          WHERE object_id = OBJECT_ID(N'[dbo].[dtt_member]')
            AND type IN ('U'))
    DROP TABLE [dbo].[dtt_member]
GO
CREATE TABLE [dbo].[dtt_member]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [open_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [nickname]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [is_enable]    tinyint DEFAULT 1,
    [balance]    decimal DEFAULT 0.00,
    [birthday]    datetime2 DEFAULT NULL,
    [member_type]    varchar(256) DEFAULT 'ORDINARY',
    [status]    int DEFAULT 3,
    [deleted]    int DEFAULT 0,
    [registrar_date]    date DEFAULT NULL,
    [accelerate_begin_time]    time DEFAULT NULL,
    [accelerate_end_time]    time DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户信息',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户openId',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'open_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户昵称',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'nickname'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否启用, 默认：1',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'is_enable'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户积分余额, 默认：0.00',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'balance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'出生日期，格式：yyyy-MM-dd HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'birthday'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员类型，默认：ORDINARY, Enum type:ORDINARY,STUDENT,GUNMETAL,SILVER,GOLD,DIAMOND,SPORTS,PLUS',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'member_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'账户注销状态；0 未注销（默认），1 已销户',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'deleted'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'注册时间，格式: yyyy-MM-dd',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'registrar_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速开始时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_begin_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速结束时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'update_time'
GO

