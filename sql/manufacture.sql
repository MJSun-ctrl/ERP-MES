-- 产品信息表
CREATE TABLE product
(
    product_id BIGINT AUTO_INCREMENT COMMENT '产品ID',

    product_code VARCHAR(50)
        NOT NULL COMMENT '产品编码',

    product_name VARCHAR(100)
        NOT NULL COMMENT '产品名称',

    specification VARCHAR(200)
        DEFAULT NULL COMMENT '规格型号',

    unit VARCHAR(20)
        DEFAULT NULL COMMENT '单位',

    product_type VARCHAR(50)
        DEFAULT NULL COMMENT '产品类型',

    status CHAR(1)
        DEFAULT '0'
        COMMENT '状态（0正常 1停用）',

    create_by VARCHAR(64)
        DEFAULT '',

    create_time DATETIME,

    update_by VARCHAR(64)
        DEFAULT '',

    update_time DATETIME,

    remark VARCHAR(500),

    PRIMARY KEY(product_id),

    UNIQUE KEY(product_code)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='产品信息表';