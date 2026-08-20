USE ry;


DROP TABLE IF EXISTS bom;


CREATE TABLE bom
(
    bom_id BIGINT AUTO_INCREMENT COMMENT '物料清单ID',

    product_id BIGINT NOT NULL COMMENT '产品ID',

    bom_code VARCHAR(50) NOT NULL COMMENT '物料清单编号',

    version VARCHAR(20) DEFAULT 'V1.0'
    COMMENT '版本号',

    status CHAR(1) DEFAULT '0'
    COMMENT '状态（0启用 1停用）',

    effective_date DATE
    COMMENT '生效日期',

    create_by VARCHAR(64),

    create_time DATETIME,

    update_by VARCHAR(64),

    update_time DATETIME,

    remark VARCHAR(500),

    PRIMARY KEY (bom_id),

    UNIQUE KEY bom_code_unique(bom_code)

)
COMMENT='物料清单主表';



DROP TABLE IF EXISTS bom_detail;


CREATE TABLE bom_detail
(
    detail_id BIGINT AUTO_INCREMENT COMMENT '明细ID',

    bom_id BIGINT NOT NULL COMMENT '物料清单ID',

    material_id BIGINT NOT NULL COMMENT '物料ID',

    quantity DECIMAL(10,2)
    COMMENT '用量',

    unit VARCHAR(20)
    COMMENT '单位',

    remark VARCHAR(500),

    PRIMARY KEY(detail_id)

)
COMMENT='物料清单明细表';