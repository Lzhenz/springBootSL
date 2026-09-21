# Spring Boot 手机查询后端

用于学习 Spring Boot 分层、参数校验、Spring Data JPA 和分页查询的手机信息后端。

配套前端：[springBootSL-frontend](https://github.com/Lzhenz/springBootSL-frontend)。继续复用当前应用与数据库访问层，不另建后端服务。

> 说明依据 2026-09-21 默认分支代码整理。当前实际采用 JPA + H2，旧 README 中的 MyBatis 描述已过时。本次仅更新文档，未执行启动或数据库联调。

## 当前实现

- 新增手机信息并调用 repository.saveAndFlush 持久化。
- 按手机名称查询、按品牌分页、按品牌与价格区间分页。
- 已有 Specification 动态查询代码，但价格区间条件存在错误。
- 已有 DTO、统一响应类、Bean Validation、全局异常处理。
- 不同接口返回格式尚未统一。
- 单条查询方法未实现；未见手机编辑、删除或登录接口。

## 技术栈

| 组件 | 当前配置 |
| --- | --- |
| Java / Spring Boot | 17 / 3.3.5 |
| 数据访问 | Spring Data JPA、JpaSpecificationExecutor |
| 数据库 | H2 文件模式 |
| Web / 校验 | Spring MVC、Jakarta Validation |
| 接口文档依赖 | springdoc-openapi-starter-webmvc-ui 2.5.0 |
| 构建 | Maven |

## 代码阅读顺序

代码主包：`src/main/java/com/example/helloSpringBoot/`。

1. [pom.xml](pom.xml) 与 [application.properties](src/main/resources/application.properties)：依赖、端口及数据库。
2. [SearchPhoneController.java](src/main/java/com/example/helloSpringBoot/controller/SearchPhoneController.java)：接口及参数。
3. [PhoneDTO.java](src/main/java/com/example/helloSpringBoot/DTO/PhoneDTO.java)：输入字段与校验。
4. [PhoneService.java](src/main/java/com/example/helloSpringBoot/service/PhoneService.java)：新增数据。
5. [PhoneModelService.java](src/main/java/com/example/helloSpringBoot/service/PhoneModelService.java)：查询、分页、Specification 与 DTO 转换。
6. [PhoneModelRepository.java](src/main/java/com/example/helloSpringBoot/Repository/PhoneModelRepository.java)：派生查询和 Specification 执行。
7. [PhoneModel.java](src/main/java/com/example/helloSpringBoot/entity/PhoneModel.java)：实体映射。
8. [GlobalExceptionHandler.java](src/main/java/com/example/helloSpringBoot/exception/GlobalExceptionHandler.java)：错误响应。

SearchPhoneService 当前为空类，实际业务主要位于 PhoneService 和 PhoneModelService。

```text
Vue/Axios → Controller → Service → Repository → H2
                              ↓
                         DTO / Page → JSON
```

## 数据模型

实体映射表名为 PHONEMODEL。

| Java 字段 | 类型 | 用途 |
| --- | --- | --- |
| id | Long，自增主键 | 标识 |
| model | String | 品牌查询字段 |
| phonename | String | 手机名称 |
| price | Integer | 价格 |
| createdat | LocalDateTime | 创建时间 |
| stock | String | 库存，目前不是数值类型 |

输入 DTO 使用 phoneName，实体使用 phonename，转换时注意大小写和命名差异。

## 本地运行

1. 准备 JDK 17 和 Maven。
2. 检查 application.properties 中 H2 文件位置，替换为自己的本地开发路径，或使用 SPRING_DATASOURCE_URL 覆盖。
3. 当前 `spring.jpa.hibernate.ddl-auto=validate`：只校验已有表，**不会建表**。仓库未提供建表或迁移脚本，不能假定全新数据库可以直接启动。
4. 若已有学习数据库，确认它与实体匹配；若没有，应先在独立的学习库中补齐 schema。不要用重建表配置覆盖已有数据。
5. 使用自己的数据库用户名与密码，可用 SPRING_DATASOURCE_USERNAME、SPRING_DATASOURCE_PASSWORD 覆盖；不将真实凭据提交到仓库。
6. 完成数据库准备后执行：

```bash
mvn spring-boot:run
```

当前端口为 8080。H2 Console 配置路径为 /h2-console；应用成功启动后可访问，并填写与应用一致的 JDBC URL。

springdoc 与 Boot 的具体组合尚未运行验证；接口文档页面是否正常应在启动后另行确认。

## 主要接口

| 方法 | 路径 | 输入 | 当前返回体 |
| --- | --- | --- | --- |
| POST | /phoneData/createPhoneModel | JSON：model、phoneName、price、stock | Result<String> |
| POST | /phoneData/getByPhoneName | 请求参数 phoneName | DTO 数组 |
| GET | /phoneData/getPageSearch | model、page、size | Page<PhoneResponseDTO> |
| GET | /phoneData/getPageSearchByModelAndPrice | model、page、size、minPrice、maxPrice | Page<PhoneResponseDTO> |
| GET | /phoneData/getPageSearchByAnyCase | model、page、size、minPrice、maxPrice | Result<Page<PhoneResponseDTO>> |

- page 从 **0** 开始。
- getPageSearch 按 price 降序。
- getPageSearchByAnyCase 的参数目前都声明为必填；即使 Service 支持判空，也不代表 HTTP 参数可省略。
- searchOnePhoneData 没有 HTTP 映射注解，底层查询返回 null，不是已可用接口。
- price 输入需至少为 1；model、phoneName 和 stock 不能为空白。

只读查询示例：

```bash
curl "http://localhost:8080/phoneData/getPageSearch?model=xiaomi&page=0&size=2"
```

需要已有匹配数据；空库或品牌不匹配时没有结果。

新增接口的请求体示例（调用会写入开发数据库）：

```json
{
  "model": "xiaomi",
  "phoneName": "学习测试机型",
  "price": 1999,
  "stock": "10"
}
```

## 前端联调

- 当前 CorsConfig 允许 `http://localhost:5173`。
- application.properties 虽有 cors.allowed.origins，但 CorsConfig 没有读取该属性，修改属性本身不会改变这个 Java 配置。
- 配套前端调用 getPageSearch，读取 Axios 响应中的 res.data.content 和 res.data.totalPages。
- 若统一包装 Result，需要同步调整前端，不能仅修改后端返回结构。
- 与 TFBlogBackEnd 同占 8080，学习时分别启动，或明确修改端口和客户端地址。

## 下一步练习

1. 修正 Specification 价格条件：当前 minPrice、maxPrice 都使用 equal 并以 AND 连接；上下限不同会查不到结果。应表达大于等于下限、小于等于上限。
2. 补充分页边界、价格范围和可选参数校验。
3. 完成按 ID 查询，并为其添加明确的 HTTP 路由。
4. 统一 DTO 转换与响应格式，保持前端契约同步。
5. 增加编辑、删除以及独立测试数据库的集成测试。
6. 补数据库初始化或迁移脚本，减少对个人电脑现有 H2 文件的依赖。

## 验证参考

在独立学习库验证：新增后能查询、分页从 0 开始、品牌筛选、价格上下限、无结果和非法参数。本次未执行这些检查。

如需复习手写 SQL 和 JSP，可对照 [springbootJsp](https://github.com/Lzhenz/springbootJsp)；如需继续建设博客，回到 [TFBlogBackEnd](https://github.com/Lzhenz/TFBlogBackEnd)。
