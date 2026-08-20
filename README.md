

</p>


<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">
面向制造业企业的 ERP-MES 集成生产管理平台
</h1>


<h4 align="center">
基于 RuoYi 框架二次开发的企业数字化生产管理系统
</h4>


<p align="center">

<img src="https://img.shields.io/badge/Java-17-orange.svg">

<img src="https://img.shields.io/badge/SpringBoot-2.x-green.svg">

<img src="https://img.shields.io/badge/MyBatis-blue.svg">

<img src="https://img.shields.io/badge/MySQL-8-blue.svg">

<img src="https://img.shields.io/badge/RuoYi-Framework-red.svg">

</p>



# 平台简介


本项目是一套面向离散制造企业的 ERP-MES 一体化生产管理平台。


项目基于开源后台管理框架 RuoYi 进行二次开发，结合制造企业实际生产流程，实现从订单管理、生产计划、生产工单、MES生产执行到库存管理的数据闭环。


系统模拟机械加工制造企业业务场景，实现企业资源计划（ERP）与制造执行系统（MES）的业务协同：

- ERP负责订单、计划以及生产资源管理；
- MES负责生产任务下达、生产执行以及生产结果反馈；
- 库存模块根据生产完工结果自动更新库存。


通过本项目实践工业软件开发中的：

- 企业业务流程建模；
- 数据库设计；
- 后端业务模块开发；
- 管理系统二次开发；
- ERP与MES业务融合。


---

# 技术架构


| 类型 | 技术 |
| :--- | :--- |
| 开发语言 | Java |
| 后端框架 | Spring Boot + Spring MVC |
| 持久层框架 | MyBatis |
| 权限认证 | Apache Shiro |
| 数据库 | MySQL |
| 前端技术 | Thymeleaf + Bootstrap + jQuery |
| 构建工具 | Maven |
| 基础框架 | RuoYi |



---

# 核心功能


## 一、ERP企业资源管理


### 1. 基础数据管理

支持制造企业生产基础数据维护：

- 产品信息管理
- 物料信息管理
- BOM物料清单管理


### 2. 销售订单管理

实现销售订单及订单明细维护，为生产计划提供业务来源。


### 3. 生产计划管理

根据订单需求制定生产计划，实现制造任务提前规划。


### 4. 生产工单管理

根据生产计划生成生产工单，并支持生产工单向MES系统下达。



---

# 二、MES制造执行管理


## 1. MES生产任务管理


ERP生产工单下达后，自动生成MES生产任务。


主要功能：

- MES任务生成；
- 任务状态跟踪；
- 生产任务查询。



业务流程：

```text
生产工单

    ↓

MES生产任务

    ↓

开始生产

    ↓

生产完成
```



## 2. 生产执行管理


模拟制造现场生产过程。


任务状态变化：

```text
待执行

    ↓

执行中

    ↓

已完成
```


生产完成后自动触发库存入库流程。



---

# 三、库存管理


实现生产完成后的库存自动更新。


主要功能：

- 产品库存查询；
- 产品库存维护；
- 生产完工自动入库；
- 入库记录追踪。



业务流程：

```text
MES生产完成

        ↓

生成入库记录

        ↓

更新产品库存

        ↓

形成库存数据
```



---

# 系统业务流程


```text
销售订单

    ↓

生产计划

    ↓

生产工单

    ↓

下达MES

    ↓

MES生产任务

    ↓

生产执行

    ↓

库存入库
```



---

# 项目特点


## 1. 基于企业管理系统进行二次开发


在RuoYi框架基础上：

- 新增制造业务模块；
- 扩展数据库表结构；
- 完成Controller、Service、Mapper三层业务开发；
- 实现制造企业业务流程。



## 2. ERP与MES业务融合


实现企业管理系统与制造执行系统之间的数据流转：

- ERP生产计划驱动MES任务；
- MES反馈生产执行结果；
- 生产结果影响库存。



## 3. 面向制造场景的数据建模


设计制造企业核心业务对象：

- 产品；
- 物料；
- BOM；
- 生产工单；
- MES任务；
- 库存；
- 入库记录。



---

# 开发环境


| 软件 | 版本 |
| :--- | :--- |
| JDK | 17 |
| Maven | 3.9+ |
| MySQL | 8.x |
| Node.js | 22.x |



---

# 项目目录


```text
ERP-MES

├── ruoyi-admin
│
│   ├── Controller
│   └── resources
│
├── ruoyi-system
│
│   ├── domain
│   ├── mapper
│   └── service
│
├── sql
│
└── README.md
```



---

# 系统演示


## 登录页面


<img width="2229" height="1201" alt="登录页面" src="https://github.com/user-attachments/assets/b9dc9e2c-be90-4b8f-bb91-56410da17ec4" />


## 系统首页


<img width="2233" height="1207" alt="首页" src="https://github.com/user-attachments/assets/a8da6c33-fa3a-4d64-a556-977556ebae8d" />




## 生产工单管理



<img width="2234" height="1205" alt="下达工单" src="https://github.com/user-attachments/assets/bb1370b2-7662-4936-a743-8211778b78cf" />




## MES生产任务



<img width="2236" height="1203" alt="MES生产任务" src="https://github.com/user-attachments/assets/7167461f-9e92-4561-bac5-1f4eace423e4" />


## 库存管理


<img width="2235" height="1201" alt="库存管理" src="https://github.com/user-attachments/assets/ec144fa1-5ee3-4262-8c9b-8eb75751fb45" />


---

# 项目运行


## 环境准备


确保安装：

- JDK 17；
- Maven 3.9+；
- MySQL 8.x。



## 数据库初始化


执行：

```sql
sql/ry_20260319.sql

sql/manufacture.sql
```



## 启动项目


执行：

```bash
mvn clean package
```


启动：

```text
ruoyi-admin
```


访问：

```text
http://localhost:8080
```



---

# 后续优化方向


- 库存不足预警；
- 物料需求计划（MRP）；
- 生产质量追溯；
- 设备数据采集；
- 工业互联网接口扩展；
- 数据可视化生产大屏。



---

# 项目说明


本项目用于学习工业软件开发流程，模拟制造企业ERP-MES系统设计与实现。

通过项目实践制造企业数字化系统开发过程，包括：

- ERP业务管理；
- MES生产执行；
- 数据库设计；
- 企业级后台系统开发；
- 业务流程闭环设计。
