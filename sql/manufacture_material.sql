SET NAMES utf8mb4;

USE ry;


DROP TABLE IF EXISTS material;


CREATE TABLE material
(
    material_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '物料ID',

    material_code VARCHAR(50)
        NOT NULL COMMENT '物料编码',

    material_name VARCHAR(100)
        NOT NULL COMMENT '物料名称',

    specification VARCHAR(200)
        DEFAULT NULL COMMENT '规格型号',

    material_type VARCHAR(50)
        DEFAULT NULL COMMENT '物料类型',

    unit VARCHAR(20)
        DEFAULT NULL COMMENT '计量单位',

    safety_stock DECIMAL(10,2)
        DEFAULT 0 COMMENT '安全库存',

    status CHAR(1)
        DEFAULT '0'
        COMMENT '状态（0正常 1停用）',

    create_by VARCHAR(64)
        DEFAULT '',

    create_time DATETIME
        DEFAULT NULL,

    update_by VARCHAR(64)
        DEFAULT '',

    update_time DATETIME
        DEFAULT NULL,

    remark VARCHAR(500)
        DEFAULT NULL COMMENT '备注',


    PRIMARY KEY(material_id),

    UNIQUE KEY uk_material_code(material_code)

)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='物料信息表';