# 如意外卖


**简介**:如意外卖


**HOST**:localhost:9000


**联系人**:


**Version**:1.0


**接口路径**:/v2/api-docs


[TOC]






# user-controller


## 用户登录


**接口地址**:`/user/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|map|map|body|true|object||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«User对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||User对象|User对象|
|&emsp;&emsp;avatar|头像|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;idNumber|身份证号|string||
|&emsp;&emsp;name|姓名|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;sex|性别|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常|integer(int32)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"avatar": "",
		"id": 0,
		"idNumber": "",
		"name": "",
		"phone": "",
		"sex": "",
		"status": 0
	},
	"map": {},
	"msg": ""
}
```


## 用户退出


**接口地址**:`/user/logout`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 发送短信


**接口地址**:`/user/sendMsg`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "avatar": "",
  "id": 0,
  "idNumber": "",
  "name": "",
  "phone": "",
  "sex": "",
  "status": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|user|用户信息|body|true|User对象|User对象|
|&emsp;&emsp;avatar|头像||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;idNumber|身份证号||false|string||
|&emsp;&emsp;name|姓名||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;sex|性别||false|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常||false|integer(int32)||
|creationTime||query|false|integer(int64)||
|id||query|false|string||
|lastAccessedTime||query|false|integer(int64)||
|maxInactiveInterval||query|false|integer(int32)||
|new||query|false|boolean||
|valueNames||query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


# 分类管理


## 新增分类


**接口地址**:`/category`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|菜品及套餐分类|body|true|Category对象|Category对象|
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;name|分类名称||false|string||
|&emsp;&emsp;sort|顺序||false|integer(int32)||
|&emsp;&emsp;type|类型   1 菜品分类 2 套餐分类||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 修改分类


**接口地址**:`/category`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "name": "",
  "sort": 0,
  "type": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|category|菜品及套餐分类|body|true|Category对象|Category对象|
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;name|分类名称||false|string||
|&emsp;&emsp;sort|顺序||false|integer(int32)||
|&emsp;&emsp;type|类型   1 菜品分类 2 套餐分类||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 删除分类


**接口地址**:`/category`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 查询分类数据


**接口地址**:`/category/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|createTime|创建时间|query|false|string(date-time)||
|createUser|创建人|query|false|integer(int64)||
|id|主键|query|false|integer(int64)||
|name|分类名称|query|false|string||
|sort|顺序|query|false|integer(int32)||
|type|类型   1 菜品分类 2 套餐分类|query|false|integer(int32)||
|updateTime|更新时间|query|false|string(date-time)||
|updateUser|修改人|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Category对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Category对象|
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;name|分类名称|string||
|&emsp;&emsp;sort|顺序|integer(int32)||
|&emsp;&emsp;type|类型   1 菜品分类 2 套餐分类|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"createTime": "",
			"createUser": 0,
			"id": 0,
			"name": "",
			"sort": 0,
			"type": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 分页查询套餐及菜品分类


**接口地址**:`/category/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


# 员工管理


## 新增员工


**接口地址**:`/employee`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|员工信息|body|true|Employee对象|Employee对象|
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;idNumber|身份证号||false|string||
|&emsp;&emsp;name|姓名||false|string||
|&emsp;&emsp;password|密码||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;sex|性别||false|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;username|用户名||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 修改员工信息


**接口地址**:`/employee`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|员工信息|body|true|Employee对象|Employee对象|
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;idNumber|身份证号||false|string||
|&emsp;&emsp;name|姓名||false|string||
|&emsp;&emsp;password|密码||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;sex|性别||false|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;username|用户名||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 员工登录


**接口地址**:`/employee/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "createTime": "",
  "createUser": 0,
  "id": 0,
  "idNumber": "",
  "name": "",
  "password": "",
  "phone": "",
  "sex": "",
  "status": 0,
  "updateTime": "",
  "updateUser": 0,
  "username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|employee|员工信息|body|true|Employee对象|Employee对象|
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;idNumber|身份证号||false|string||
|&emsp;&emsp;name|姓名||false|string||
|&emsp;&emsp;password|密码||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;sex|性别||false|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;username|用户名||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Employee对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Employee对象|Employee对象|
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;idNumber|身份证号|string||
|&emsp;&emsp;name|姓名|string||
|&emsp;&emsp;password|密码|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;sex|性别|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;username|用户名|string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": 0,
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


## 员工退出


**接口地址**:`/employee/logout`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 分页查询员工信息


**接口地址**:`/employee/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## 获取单个员工信息


**接口地址**:`/employee/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Employee对象»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Employee对象|Employee对象|
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;idNumber|身份证号|string||
|&emsp;&emsp;name|姓名|string||
|&emsp;&emsp;password|密码|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;sex|性别|string||
|&emsp;&emsp;status|状态 0:禁用，1:正常|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;username|用户名|string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"createUser": 0,
		"id": 0,
		"idNumber": "",
		"name": "",
		"password": "",
		"phone": "",
		"sex": "",
		"status": 0,
		"updateTime": "",
		"updateUser": 0,
		"username": ""
	},
	"map": {},
	"msg": ""
}
```


# 地址铺管理


## 添加地址信息


**接口地址**:`/addressBook`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|地址管理|body|true|AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号||false|string||
|&emsp;&emsp;cityName|市级名称||false|string||
|&emsp;&emsp;consignee|收货人||false|string||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;detail|详细地址||false|string||
|&emsp;&emsp;districtCode|区级区划编号||false|string||
|&emsp;&emsp;districtName|区级名称||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是||false|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;label|标签||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;provinceCode|省级区划编号||false|string||
|&emsp;&emsp;provinceName|省级名称||false|string||
|&emsp;&emsp;sex|性别 0 女 1 男||false|string||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;userId|用户id||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号|string||
|&emsp;&emsp;cityName|市级名称|string||
|&emsp;&emsp;consignee|收货人|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;detail|详细地址|string||
|&emsp;&emsp;districtCode|区级区划编号|string||
|&emsp;&emsp;districtName|区级名称|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;label|标签|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;provinceCode|省级区划编号|string||
|&emsp;&emsp;provinceName|省级名称|string||
|&emsp;&emsp;sex|性别 0 女 1 男|string||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;userId|用户id|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## 修改地址信息


**接口地址**:`/addressBook`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|地址管理|body|true|AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号||false|string||
|&emsp;&emsp;cityName|市级名称||false|string||
|&emsp;&emsp;consignee|收货人||false|string||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;detail|详细地址||false|string||
|&emsp;&emsp;districtCode|区级区划编号||false|string||
|&emsp;&emsp;districtName|区级名称||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是||false|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;label|标签||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;provinceCode|省级区划编号||false|string||
|&emsp;&emsp;provinceName|省级名称||false|string||
|&emsp;&emsp;sex|性别 0 女 1 男||false|string||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;userId|用户id||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 删除地址


**接口地址**:`/addressBook`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|true|array|integer|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 获取默认地址


**接口地址**:`/addressBook/default`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook对象»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号|string||
|&emsp;&emsp;cityName|市级名称|string||
|&emsp;&emsp;consignee|收货人|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;detail|详细地址|string||
|&emsp;&emsp;districtCode|区级区划编号|string||
|&emsp;&emsp;districtName|区级名称|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;label|标签|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;provinceCode|省级区划编号|string||
|&emsp;&emsp;provinceName|省级名称|string||
|&emsp;&emsp;sex|性别 0 女 1 男|string||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;userId|用户id|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## 设置默认地址


**接口地址**:`/addressBook/default`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "cityCode": "",
  "cityName": "",
  "consignee": "",
  "createTime": "",
  "createUser": 0,
  "detail": "",
  "districtCode": "",
  "districtName": "",
  "id": 0,
  "isDefault": 0,
  "isDeleted": 0,
  "label": "",
  "phone": "",
  "provinceCode": "",
  "provinceName": "",
  "sex": "",
  "updateTime": "",
  "updateUser": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addressBook|地址管理|body|true|AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号||false|string||
|&emsp;&emsp;cityName|市级名称||false|string||
|&emsp;&emsp;consignee|收货人||false|string||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;detail|详细地址||false|string||
|&emsp;&emsp;districtCode|区级区划编号||false|string||
|&emsp;&emsp;districtName|区级名称||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是||false|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;label|标签||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;provinceCode|省级区划编号||false|string||
|&emsp;&emsp;provinceName|省级名称||false|string||
|&emsp;&emsp;sex|性别 0 女 1 男||false|string||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||
|&emsp;&emsp;userId|用户id||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«AddressBook对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||AddressBook对象|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号|string||
|&emsp;&emsp;cityName|市级名称|string||
|&emsp;&emsp;consignee|收货人|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;detail|详细地址|string||
|&emsp;&emsp;districtCode|区级区划编号|string||
|&emsp;&emsp;districtName|区级名称|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;label|标签|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;provinceCode|省级区划编号|string||
|&emsp;&emsp;provinceName|省级名称|string||
|&emsp;&emsp;sex|性别 0 女 1 男|string||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;userId|用户id|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"cityCode": "",
		"cityName": "",
		"consignee": "",
		"createTime": "",
		"createUser": 0,
		"detail": "",
		"districtCode": "",
		"districtName": "",
		"id": 0,
		"isDefault": 0,
		"isDeleted": 0,
		"label": "",
		"phone": "",
		"provinceCode": "",
		"provinceName": "",
		"sex": "",
		"updateTime": "",
		"updateUser": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## 获取指定地址


**接口地址**:`/addressBook/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|cityCode|市级区划编号|query|false|string||
|cityName|市级名称|query|false|string||
|consignee|收货人|query|false|string||
|createTime|创建时间|query|false|string(date-time)||
|createUser|创建人|query|false|integer(int64)||
|detail|详细地址|query|false|string||
|districtCode|区级区划编号|query|false|string||
|districtName|区级名称|query|false|string||
|id|主键|query|false|integer(int64)||
|isDefault|默认 0 否 1是|query|false|integer(int32)||
|isDeleted|是否删除|query|false|integer(int32)||
|label|标签|query|false|string||
|phone|手机号|query|false|string||
|provinceCode|省级区划编号|query|false|string||
|provinceName|省级名称|query|false|string||
|sex|性别 0 女 1 男|query|false|string||
|updateTime|更新时间|query|false|string(date-time)||
|updateUser|修改人|query|false|integer(int64)||
|userId|用户id|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«AddressBook对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|AddressBook对象|
|&emsp;&emsp;cityCode|市级区划编号|string||
|&emsp;&emsp;cityName|市级名称|string||
|&emsp;&emsp;consignee|收货人|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;detail|详细地址|string||
|&emsp;&emsp;districtCode|区级区划编号|string||
|&emsp;&emsp;districtName|区级名称|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;isDefault|默认 0 否 1是|integer(int32)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;label|标签|string||
|&emsp;&emsp;phone|手机号|string||
|&emsp;&emsp;provinceCode|省级区划编号|string||
|&emsp;&emsp;provinceName|省级名称|string||
|&emsp;&emsp;sex|性别 0 女 1 男|string||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|&emsp;&emsp;userId|用户id|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"cityCode": "",
			"cityName": "",
			"consignee": "",
			"createTime": "",
			"createUser": 0,
			"detail": "",
			"districtCode": "",
			"districtName": "",
			"id": 0,
			"isDefault": 0,
			"isDeleted": 0,
			"label": "",
			"phone": "",
			"provinceCode": "",
			"provinceName": "",
			"sex": "",
			"updateTime": "",
			"updateUser": 0,
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 获取地址列表


**接口地址**:`/addressBook/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«object»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||object||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"map": {},
	"msg": ""
}
```


# 套餐管理


## 新增套餐


**接口地址**:`/setmeal`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": 0,
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|套餐|body|true|Setmeal对象|Setmeal对象|
|&emsp;&emsp;categoryId|菜品分类id||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|编码||false|string||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;description|描述信息||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;name|套餐名称||false|string||
|&emsp;&emsp;price|套餐价格||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish对象|
|&emsp;&emsp;&emsp;&emsp;copies|份数||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品id||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|菜品名称 （冗余字段）||false|string||
|&emsp;&emsp;&emsp;&emsp;price|菜品原价（冗余字段）||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|套餐id ||false|integer||
|&emsp;&emsp;&emsp;&emsp;sort|排序||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人||false|integer||
|&emsp;&emsp;status|状态 0:停用 1:启用||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 修改套餐信息


**接口地址**:`/setmeal`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "createTime": "",
  "createUser": 0,
  "description": "",
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "price": 0,
      "setmealId": 0,
      "sort": 0,
      "updateTime": "",
      "updateUser": 0
    }
  ],
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|setmealDto|套餐|body|true|Setmeal对象|Setmeal对象|
|&emsp;&emsp;categoryId|菜品分类id||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|编码||false|string||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;description|描述信息||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;name|套餐名称||false|string||
|&emsp;&emsp;price|套餐价格||false|number||
|&emsp;&emsp;setmealDishes|||false|array|SetmealDish对象|
|&emsp;&emsp;&emsp;&emsp;copies|份数||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品id||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|菜品名称 （冗余字段）||false|string||
|&emsp;&emsp;&emsp;&emsp;price|菜品原价（冗余字段）||false|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|套餐id ||false|integer||
|&emsp;&emsp;&emsp;&emsp;sort|排序||false|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人||false|integer||
|&emsp;&emsp;status|状态 0:停用 1:启用||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 删除套餐


**接口地址**:`/setmeal`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|true|array|integer|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 移动端查看套餐下的菜品信息


**接口地址**:`/setmeal/dish/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Dish对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Dish对象|
|&emsp;&emsp;categoryId|菜品分类id|integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code|商品码|string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;description|描述信息|string||
|&emsp;&emsp;flavors||array|DishFlavor对象|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|口味名称|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人|integer||
|&emsp;&emsp;&emsp;&emsp;value|口味数据list|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|菜品名称|string||
|&emsp;&emsp;price|菜品价格|number||
|&emsp;&emsp;sort|顺序|integer(int32)||
|&emsp;&emsp;status|0 停售 1 起售|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"categoryName": "",
			"code": "",
			"copies": 0,
			"createTime": "",
			"createUser": 0,
			"description": "",
			"flavors": [
				{
					"createTime": "",
					"createUser": 0,
					"dishId": 0,
					"id": 0,
					"isDeleted": 0,
					"name": "",
					"updateTime": "",
					"updateUser": 0,
					"value": ""
				}
			],
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"sort": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 根据条件查询套餐数据


**接口地址**:`/setmeal/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId|菜品分类id|query|false|integer(int64)||
|code|编码|query|false|string||
|createTime|创建时间|query|false|string(date-time)||
|createUser|创建人|query|false|integer(int64)||
|description|描述信息|query|false|string||
|id|主键|query|false|integer(int64)||
|image|图片|query|false|string||
|isDeleted|是否删除|query|false|integer(int32)||
|name|套餐名称|query|false|string||
|price|套餐价格|query|false|number||
|status|状态 0:停用 1:启用|query|false|integer(int32)||
|updateTime|更新时间|query|false|string(date-time)||
|updateUser|修改人|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Setmeal对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Setmeal对象0|
|&emsp;&emsp;categoryId|菜品分类id|integer(int64)||
|&emsp;&emsp;code|编码|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;description|描述信息|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|套餐名称|string||
|&emsp;&emsp;price|套餐价格|number||
|&emsp;&emsp;status|状态 0:停用 1:启用|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"code": "",
			"createTime": "",
			"createUser": 0,
			"description": "",
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 套餐分页查询


**接口地址**:`/setmeal/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|页码|query|true|integer(int32)||
|pageSize|每页记录数|query|true|integer(int32)||
|name|套餐名称|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## 修改套餐售卖状态


**接口地址**:`/setmeal/status/{status}`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|status|status|path|true|integer(int32)||
|ids|ids|query|false|array|string|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 通过id获取套餐信息


**接口地址**:`/setmeal/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Setmeal对象»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Setmeal对象|Setmeal对象|
|&emsp;&emsp;categoryId|菜品分类id|integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code|编码|string||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;description|描述信息|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|套餐名称|string||
|&emsp;&emsp;price|套餐价格|number||
|&emsp;&emsp;setmealDishes||array|SetmealDish对象|
|&emsp;&emsp;&emsp;&emsp;copies|份数|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品id|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|菜品名称 （冗余字段）|string||
|&emsp;&emsp;&emsp;&emsp;price|菜品原价（冗余字段）|number||
|&emsp;&emsp;&emsp;&emsp;setmealId|套餐id |integer||
|&emsp;&emsp;&emsp;&emsp;sort|排序|integer||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人|integer||
|&emsp;&emsp;status|状态 0:停用 1:启用|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"createTime": "",
		"createUser": 0,
		"description": "",
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"setmealDishes": [
			{
				"copies": 0,
				"createTime": "",
				"createUser": 0,
				"dishId": 0,
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"price": 0,
				"setmealId": 0,
				"sort": 0,
				"updateTime": "",
				"updateUser": 0
			}
		],
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


# 菜品管理


## 新增菜品


**接口地址**:`/dish`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "copies": 0,
  "createTime": "",
  "createUser": 0,
  "description": "",
  "flavors": [
    {
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "updateTime": "",
      "updateUser": 0,
      "value": ""
    }
  ],
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "sort": 0,
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|菜品管理|body|true|Dish对象|Dish对象|
|&emsp;&emsp;categoryId|菜品分类id||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|商品码||false|string||
|&emsp;&emsp;copies|||false|integer(int32)||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;description|描述信息||false|string||
|&emsp;&emsp;flavors|||false|array|DishFlavor对象|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|口味名称||false|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人||false|integer||
|&emsp;&emsp;&emsp;&emsp;value|口味数据list||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;name|菜品名称||false|string||
|&emsp;&emsp;price|菜品价格||false|number||
|&emsp;&emsp;sort|顺序||false|integer(int32)||
|&emsp;&emsp;status|0 停售 1 起售||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 更新菜品信息


**接口地址**:`/dish`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "categoryId": 0,
  "categoryName": "",
  "code": "",
  "copies": 0,
  "createTime": "",
  "createUser": 0,
  "description": "",
  "flavors": [
    {
      "createTime": "",
      "createUser": 0,
      "dishId": 0,
      "id": 0,
      "isDeleted": 0,
      "name": "",
      "updateTime": "",
      "updateUser": 0,
      "value": ""
    }
  ],
  "id": 0,
  "image": "",
  "isDeleted": 0,
  "name": "",
  "price": 0,
  "sort": 0,
  "status": 0,
  "updateTime": "",
  "updateUser": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dishDto|菜品管理|body|true|Dish对象|Dish对象|
|&emsp;&emsp;categoryId|菜品分类id||false|integer(int64)||
|&emsp;&emsp;categoryName|||false|string||
|&emsp;&emsp;code|商品码||false|string||
|&emsp;&emsp;copies|||false|integer(int32)||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;createUser|创建人||false|integer(int64)||
|&emsp;&emsp;description|描述信息||false|string||
|&emsp;&emsp;flavors|||false|array|DishFlavor对象|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间||false|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人||false|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品||false|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键||false|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除||false|integer||
|&emsp;&emsp;&emsp;&emsp;name|口味名称||false|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间||false|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人||false|integer||
|&emsp;&emsp;&emsp;&emsp;value|口味数据list||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;name|菜品名称||false|string||
|&emsp;&emsp;price|菜品价格||false|number||
|&emsp;&emsp;sort|顺序||false|integer(int32)||
|&emsp;&emsp;status|0 停售 1 起售||false|integer(int32)||
|&emsp;&emsp;updateTime|更新时间||false|string(date-time)||
|&emsp;&emsp;updateUser|修改人||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 删除菜品


**接口地址**:`/dish`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|true|array|integer|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 分类id查询菜品信息


**接口地址**:`/dish/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|categoryId|菜品分类id|query|false|integer(int64)||
|code|商品码|query|false|string||
|createTime|创建时间|query|false|string(date-time)||
|createUser|创建人|query|false|integer(int64)||
|description|描述信息|query|false|string||
|id|主键|query|false|integer(int64)||
|image|图片|query|false|string||
|isDeleted|是否删除|query|false|integer(int32)||
|name|菜品名称|query|false|string||
|price|菜品价格|query|false|number||
|sort|顺序|query|false|integer(int32)||
|status|0 停售 1 起售|query|false|integer(int32)||
|updateTime|更新时间|query|false|string(date-time)||
|updateUser|修改人|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«Dish对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|Dish对象|
|&emsp;&emsp;categoryId|菜品分类id|integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code|商品码|string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;description|描述信息|string||
|&emsp;&emsp;flavors||array|DishFlavor对象|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|口味名称|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人|integer||
|&emsp;&emsp;&emsp;&emsp;value|口味数据list|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|菜品名称|string||
|&emsp;&emsp;price|菜品价格|number||
|&emsp;&emsp;sort|顺序|integer(int32)||
|&emsp;&emsp;status|0 停售 1 起售|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"categoryId": 0,
			"categoryName": "",
			"code": "",
			"copies": 0,
			"createTime": "",
			"createUser": 0,
			"description": "",
			"flavors": [
				{
					"createTime": "",
					"createUser": 0,
					"dishId": 0,
					"id": 0,
					"isDeleted": 0,
					"name": "",
					"updateTime": "",
					"updateUser": 0,
					"value": ""
				}
			],
			"id": 0,
			"image": "",
			"isDeleted": 0,
			"name": "",
			"price": 0,
			"sort": 0,
			"status": 0,
			"updateTime": "",
			"updateUser": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 分页查询菜品信息


**接口地址**:`/dish/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## 停用或者启用菜品


**接口地址**:`/dish/status/{statusType}`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|ids|ids|query|true|array|integer|
|statusType|statusType|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 通过id查询菜品的详细信息


**接口地址**:`/dish/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Dish对象»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Dish对象|Dish对象|
|&emsp;&emsp;categoryId|菜品分类id|integer(int64)||
|&emsp;&emsp;categoryName||string||
|&emsp;&emsp;code|商品码|string||
|&emsp;&emsp;copies||integer(int32)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;createUser|创建人|integer(int64)||
|&emsp;&emsp;description|描述信息|string||
|&emsp;&emsp;flavors||array|DishFlavor对象|
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;createUser|创建人|integer||
|&emsp;&emsp;&emsp;&emsp;dishId|菜品|integer||
|&emsp;&emsp;&emsp;&emsp;id|主键|integer||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|口味名称|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间|string||
|&emsp;&emsp;&emsp;&emsp;updateUser|修改人|integer||
|&emsp;&emsp;&emsp;&emsp;value|口味数据list|string||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|菜品名称|string||
|&emsp;&emsp;price|菜品价格|number||
|&emsp;&emsp;sort|顺序|integer(int32)||
|&emsp;&emsp;status|0 停售 1 起售|integer(int32)||
|&emsp;&emsp;updateTime|更新时间|string(date-time)||
|&emsp;&emsp;updateUser|修改人|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categoryId": 0,
		"categoryName": "",
		"code": "",
		"copies": 0,
		"createTime": "",
		"createUser": 0,
		"description": "",
		"flavors": [
			{
				"createTime": "",
				"createUser": 0,
				"dishId": 0,
				"id": 0,
				"isDeleted": 0,
				"name": "",
				"updateTime": "",
				"updateUser": 0,
				"value": ""
			}
		],
		"id": 0,
		"image": "",
		"isDeleted": 0,
		"name": "",
		"price": 0,
		"sort": 0,
		"status": 0,
		"updateTime": "",
		"updateUser": 0
	},
	"map": {},
	"msg": ""
}
```


# 订单管理


## 派送外卖订单


**接口地址**:`/order`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|订单表|body|true|Orders对象|Orders对象|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|地址id||false|integer(int64)||
|&emsp;&emsp;amount|实收金额||false|number||
|&emsp;&emsp;checkoutTime|结账时间||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;number|订单号||false|string||
|&emsp;&emsp;orderTime|下单时间||false|string(date-time)||
|&emsp;&emsp;payMethod|支付方式 1微信,2支付宝||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|备注||false|string||
|&emsp;&emsp;status|订单状态 1待付款，2待派送，3已派送，4已完成，5已取消||false|integer(int32)||
|&emsp;&emsp;userId|下单用户||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 再来一单


**接口地址**:`/order/again`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|order1|订单表|body|true|Orders对象|Orders对象|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|地址id||false|integer(int64)||
|&emsp;&emsp;amount|实收金额||false|number||
|&emsp;&emsp;checkoutTime|结账时间||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;number|订单号||false|string||
|&emsp;&emsp;orderTime|下单时间||false|string(date-time)||
|&emsp;&emsp;payMethod|支付方式 1微信,2支付宝||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|备注||false|string||
|&emsp;&emsp;status|订单状态 1待付款，2待派送，3已派送，4已完成，5已取消||false|integer(int32)||
|&emsp;&emsp;userId|下单用户||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 后台查看订单明细


**接口地址**:`/order/page`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|beginTime|beginTime|query|false|string||
|endTime|endTime|query|false|string||
|number|number|query|false|string||
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


## 用户下单


**接口地址**:`/order/submit`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "address": "",
  "addressBookId": 0,
  "amount": 0,
  "checkoutTime": "",
  "consignee": "",
  "id": 0,
  "number": "",
  "orderTime": "",
  "payMethod": 0,
  "phone": "",
  "remark": "",
  "status": 0,
  "userId": 0,
  "userName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orders|订单表|body|true|Orders对象|Orders对象|
|&emsp;&emsp;address|||false|string||
|&emsp;&emsp;addressBookId|地址id||false|integer(int64)||
|&emsp;&emsp;amount|实收金额||false|number||
|&emsp;&emsp;checkoutTime|结账时间||false|string(date-time)||
|&emsp;&emsp;consignee|||false|string||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;number|订单号||false|string||
|&emsp;&emsp;orderTime|下单时间||false|string(date-time)||
|&emsp;&emsp;payMethod|支付方式 1微信,2支付宝||false|integer(int32)||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;remark|备注||false|string||
|&emsp;&emsp;status|订单状态 1待付款，2待派送，3已派送，4已完成，5已取消||false|integer(int32)||
|&emsp;&emsp;userId|下单用户||false|integer(int64)||
|&emsp;&emsp;userName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 订单分页数据查询


**接口地址**:`/order/userPage`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|page|query|false|integer(int32)||
|pageSize|pageSize|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Page»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Page|Page|
|&emsp;&emsp;countId||string||
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;maxLimit||integer(int64)||
|&emsp;&emsp;optimizeCountSql||boolean||
|&emsp;&emsp;orders||array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;asc||boolean||
|&emsp;&emsp;&emsp;&emsp;column||string||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|object|
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"countId": "",
		"current": 0,
		"maxLimit": 0,
		"optimizeCountSql": true,
		"orders": [
			{
				"asc": true,
				"column": ""
			}
		],
		"pages": 0,
		"records": [],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"map": {},
	"msg": ""
}
```


# 购物车管理


## 添加购物车数据


**接口地址**:`/shoppingCart/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|购物车|body|true|ShoppingCart对象|ShoppingCart对象|
|&emsp;&emsp;amount|金额||false|number||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;dishFlavor|口味||false|string||
|&emsp;&emsp;dishId|菜品id||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;name|名称||false|string||
|&emsp;&emsp;number|数量||false|integer(int32)||
|&emsp;&emsp;setmealId|套餐id||false|integer(int64)||
|&emsp;&emsp;userId|主键||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«ShoppingCart对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ShoppingCart对象|ShoppingCart对象|
|&emsp;&emsp;amount|金额|number||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;dishFlavor|口味|string||
|&emsp;&emsp;dishId|菜品id|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;name|名称|string||
|&emsp;&emsp;number|数量|integer(int32)||
|&emsp;&emsp;setmealId|套餐id|integer(int64)||
|&emsp;&emsp;userId|主键|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"amount": 0,
		"createTime": "",
		"dishFlavor": "",
		"dishId": 0,
		"id": 0,
		"image": "",
		"name": "",
		"number": 0,
		"setmealId": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


## 清空购物车


**接口地址**:`/shoppingCart/clean`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```


## 获取购物车列表


**接口地址**:`/shoppingCart/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«List«ShoppingCart对象»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|ShoppingCart对象|
|&emsp;&emsp;amount|金额|number||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;dishFlavor|口味|string||
|&emsp;&emsp;dishId|菜品id|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;name|名称|string||
|&emsp;&emsp;number|数量|integer(int32)||
|&emsp;&emsp;setmealId|套餐id|integer(int64)||
|&emsp;&emsp;userId|主键|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"amount": 0,
			"createTime": "",
			"dishFlavor": "",
			"dishId": 0,
			"id": 0,
			"image": "",
			"name": "",
			"number": 0,
			"setmealId": 0,
			"userId": 0
		}
	],
	"map": {},
	"msg": ""
}
```


## 减少购物车中菜品


**接口地址**:`/shoppingCart/sub`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "amount": 0,
  "createTime": "",
  "dishFlavor": "",
  "dishId": 0,
  "id": 0,
  "image": "",
  "name": "",
  "number": 0,
  "setmealId": 0,
  "userId": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|shoppingCart|购物车|body|true|ShoppingCart对象|ShoppingCart对象|
|&emsp;&emsp;amount|金额||false|number||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;dishFlavor|口味||false|string||
|&emsp;&emsp;dishId|菜品id||false|integer(int64)||
|&emsp;&emsp;id|主键||false|integer(int64)||
|&emsp;&emsp;image|图片||false|string||
|&emsp;&emsp;name|名称||false|string||
|&emsp;&emsp;number|数量||false|integer(int32)||
|&emsp;&emsp;setmealId|套餐id||false|integer(int64)||
|&emsp;&emsp;userId|主键||false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«ShoppingCart对象»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ShoppingCart对象|ShoppingCart对象|
|&emsp;&emsp;amount|金额|number||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;dishFlavor|口味|string||
|&emsp;&emsp;dishId|菜品id|integer(int64)||
|&emsp;&emsp;id|主键|integer(int64)||
|&emsp;&emsp;image|图片|string||
|&emsp;&emsp;name|名称|string||
|&emsp;&emsp;number|数量|integer(int32)||
|&emsp;&emsp;setmealId|套餐id|integer(int64)||
|&emsp;&emsp;userId|主键|integer(int64)||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"amount": 0,
		"createTime": "",
		"dishFlavor": "",
		"dishId": 0,
		"id": 0,
		"image": "",
		"name": "",
		"number": 0,
		"setmealId": 0,
		"userId": 0
	},
	"map": {},
	"msg": ""
}
```


# 通用管理


## 文件下载


**接口地址**:`/common/download`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|name|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 文件上传


**接口地址**:`/common/upload`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|file|file|body|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|map||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"map": {},
	"msg": ""
}
```