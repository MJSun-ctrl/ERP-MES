CREATE TABLE sales_order_detail
(
    detail_id bigint AUTO_INCREMENT COMMENT '明细ID',

    order_id bigint NOT NULL COMMENT '订单ID',

    product_id bigint NOT NULL COMMENT '产品ID',

    quantity int NOT NULL COMMENT '数量',

    unit_price decimal(10,2) DEFAULT 0 COMMENT '单价',

    delivery_date date COMMENT '交付日期',

    remark varchar(500),

    create_by varchar(64),
    create_time datetime,

    update_by varchar(64),
    update_time datetime,

    PRIMARY KEY(detail_id)
)
COMMENT='销售订单明细表'
DEFAULT CHARSET=utf8mb4;
