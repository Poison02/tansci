# 简介

一个基于SpringBoot2和Vue3+Element-Plus的后台管理系统。

基础模块：菜单管理、角色管理、组织管理、用户管理、字典管理、日志管理（操作日志、异常日志）

## 架构

后端技术

| 名称            |         | 描述         |
| --------------- | ------- | ------------ |
| SpringBoot      | 2.7.12  | 整体架构基础 |
| Mybatis Plus    | 3.4.3.1 | 数据层       |
| Druid           | 1.2.6   | 连接池       |
| Spring Security | --      | 权限认证     |
| Fastjson        | 2.0.33  | --           |
| JJWT            | 0.9.0   | 安全认证     |
| knife4j         | 3.0.3   | API 文档     |
| Lombok          | --      | --           |

前端技术

| 名称         | 版本号       | 描述                |
| ------------ | ------------ | ------------------- |
| vue          | 3.2.16       | 整体架构基础        |
| element-plus | 1.2.0-beta.6 | UI                  |
| vue-router   | 4.0.12       | 路由                |
| vuex         | 4.0.2        | 状态管理模式        |
| vue3-echarts | 1.0.3        | echarts图表         |
| axios        | 0.24.0       | 基于promise的HTTP库 |
| nprogress    | 0.2.0        | --                  |
| less         | 4.1.2        | --                  |

## 项目架构

```
├─docs                         # 文档相关
├─sql                          # 数据库SQL脚本
├─src                          # 后端项目目录
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─tansci
│  │  │          ├─common       # 公共包
│  │  │          ├─config       # 配置
│  │  │          ├─controller   # controller 层
│  │  │          ├─domain       # 映射实体
│  │  │          │  ├─dto       # DTO 实体
│  │  │          │  └─vo        # VO 实体
│  │  │          ├─mapper       # mapper 层
│  │  │          ├─security     # 安全认证相关
│  │  │          ├─service      # service 层
│  │  │          │  └─impl
│  │  │          └─utils        # 工具包
│  │  └─resources
│  │      └─mapper              # mapper XML 映射
│  └─test                       # 测试
└─tansci-view                   # 前端项目目录
    ├─public
    └─src
        ├─api                   # 服务AIP配置
        ├─assets                # 静态资源（包含 公共样式、图片）
        │  ├─css                
        │  └─image
        ├─components            # 公共组件
        ├─layout                # 整体布局
        ├─router                # 路由
        ├─store                 # axios 封装
        ├─utils                 # 工具包
        └─views                 # 功能模块
            └─system            # 基础功能模块
```