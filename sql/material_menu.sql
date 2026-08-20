-- 物料管理菜单
insert into sys_menu
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
    remark
)
values
(
    '物料管理',
    2005,
    2,
    '/manufacture/material',
    'C',
    '0',
    'manufacture:material:view',
    '#',
    'admin',
    sysdate(),
    '物料管理'
);


SELECT @parentId := LAST_INSERT_ID();


-- 查询按钮
insert into sys_menu
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
    create_time
)
values
(
    '物料管理查询',
    @parentId,
    1,
    '#',
    'F',
    '0',
    'manufacture:material:list',
    '#',
    'admin',
    sysdate()
);


-- 新增按钮
insert into sys_menu
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
    create_time
)
values
(
    '物料管理新增',
    @parentId,
    2,
    '#',
    'F',
    '0',
    'manufacture:material:add',
    '#',
    'admin',
    sysdate()
);


-- 修改按钮
insert into sys_menu
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
    create_time
)
values
(
    '物料管理修改',
    @parentId,
    3,
    '#',
    'F',
    '0',
    'manufacture:material:edit',
    '#',
    'admin',
    sysdate()
);


-- 删除按钮
insert into sys_menu
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
    create_time
)
values
(
    '物料管理删除',
    @parentId,
    4,
    '#',
    'F',
    '0',
    'manufacture:material:remove',
    '#',
    'admin',
    sysdate()
);


-- 导出按钮
insert into sys_menu
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
    create_time
)
values
(
    '物料管理导出',
    @parentId,
    5,
    '#',
    'F',
    '0',
    'manufacture:material:export',
    '#',
    'admin',
    sysdate()
);