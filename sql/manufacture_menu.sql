-- =============================================
-- 制造管理模块菜单
-- =============================================

-- 1. 制造管理
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '制造管理',
    0,
    5,
    '#',
    'M',
    '0',
    '',
    'fa fa-industry',
    'admin',
    sysdate(),
    '',
    NULL,
    '制造企业ERP-MES管理'
);

-- 保存“制造管理”的 menu_id
SET @manufactureMenuId = LAST_INSERT_ID();


-- 2. 基础数据
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '基础数据',
    @manufactureMenuId,
    1,
    '#',
    'M',
    '0',
    '',
    'fa fa-database',
    'admin',
    sysdate(),
    '',
    NULL,
    '制造基础数据管理'
);

-- 保存“基础数据”的 menu_id
SET @basicDataMenuId = LAST_INSERT_ID();


-- 3. 产品管理
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理',
    @basicDataMenuId,
    1,
    '/manufacture/product',
    'C',
    '0',
    'manufacture:product:view',
    'fa fa-cube',
    'admin',
    sysdate(),
    '',
    NULL,
    '产品管理菜单'
);

-- 保存“产品管理”的 menu_id
SET @productMenuId = LAST_INSERT_ID();


-- =============================================
-- 产品管理按钮权限
-- =============================================

-- 4. 查询
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理查询',
    @productMenuId,
    1,
    '#',
    'F',
    '0',
    'manufacture:product:list',
    '#',
    'admin',
    sysdate(),
    '',
    NULL,
    ''
);


-- 5. 新增
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理新增',
    @productMenuId,
    2,
    '#',
    'F',
    '0',
    'manufacture:product:add',
    '#',
    'admin',
    sysdate(),
    '',
    NULL,
    ''
);


-- 6. 修改
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理修改',
    @productMenuId,
    3,
    '#',
    'F',
    '0',
    'manufacture:product:edit',
    '#',
    'admin',
    sysdate(),
    '',
    NULL,
    ''
);


-- 7. 删除
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理删除',
    @productMenuId,
    4,
    '#',
    'F',
    '0',
    'manufacture:product:remove',
    '#',
    'admin',
    sysdate(),
    '',
    NULL,
    ''
);


-- 8. 导出
INSERT INTO sys_menu
(
    menu_name,
    parent_id,
    order_num,
    url,
    menu_type,
    visible,
    perms,
    icon,
    create_by,
    create_time,
    update_by,
    update_time,
    remark
)
VALUES
(
    '产品管理导出',
    @productMenuId,
    5,
    '#',
    'F',
    '0',
    'manufacture:product:export',
    '#',
    'admin',
    sysdate(),
    '',
    NULL,
    ''
);