# MinecraftServerQuerier

------
###### API:
Used To Query Server Information For Minecraft


------

| 输入 | 类型   | 可空  |
| ---- | ------ | ----- |
| host | string | false |
| port | int    | true  |

| 输出      | 类型   | 说明                                   |
| --------- | ------ | -------------------------------------- |
| code      | int    | 状态码,200为成功，其他为错误           |
| msg       | string | 成功返回success                        |
| data      | json   | 所有服务器数据                         |
| ver_name  | string | 当前版本名称，获取失败则为空或None     |
| serv_name | string | 服务器名称，获取失败则为空或None       |
| serv_ver  | string | 服务器版本，获取失败则为空或None       |
| max_l     | string | 支持最大承载人数，获取失败则为空或None |
| onl_l     | string | 当前在线人数，获取失败则为空或None     |
| serv_ping | string | 服务器延迟，获取失败则为空或None       |
| serv_ico  | string | 服务器图标，获取失败则为空或None       |

| code |         说明          |
| :--: | :-------------------: |
| 200  |       请求成功        |
| 100  |     json解析失败      |
| 101  |  token不合法(已弃用)  |
| 102  |       url不合法       |
| 103  |       文件过大        |
| 104  |     文件读取失败      |
| 105  |     数据读取失败      |
| 106  |     参数类型未知      |
| 107  |     内容检测失败      |
| 108  |       参数错误        |
| 109  |       未知异常        |
| 110  | token余额不足(已弃用) |
| 111  |  token不合法(已弃用)  |
| 121  |     访问数据失败      |
| 122  |       请求失败        |
