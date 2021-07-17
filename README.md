# medicineManager
卖药的

以下是前期准备：
每次更新版本号名称示例：v天数.次数_名字拼音缩写，例如我第一天第一次提交：v1.0.1_zq，第二次：v1.0.2_zq，第12次：v1.1.2_zq，第三天第一次：v3.0.1_zq……，上传之前必须保证自己所做部分正确，切记切记。
类的命名、方法名、变量名必须符合相应规范，且有意义，例如根据Id查找名称：getNameById，
若查询的结果是单个属性，前缀是get，多个使用find，禁止使用select。添加使用add，禁止使用insert，删除使用delete，禁止使用remove，更新使用update
请求名称必须有意义但不易过长，代码必须带有必要的注释且符合javadoc规范，不知道什么是javadoc规范请百度或者下载阿里的代码规范插件。
另外注意代码格式，要求逻辑清晰，使用 ctrl+shift+L 快捷键可以整理代码。
无需下载jq，统一使用在线的jq：
<script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
使用到分页的地方还需要添加css样式表
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/images/bootstrap.min.css">

input里的name要和po的相应属性名一致

info.jsp为通用的显示信息页面，是否需要转发或者重定向请仔细考虑。
切勿对不属于自己任务的部分进行操作！！！
切勿更改配置文件及接口等基础代码，切勿修改依赖版本，若有问题请联系我。但某些html文件的后缀可能需要改为jsp，请酌情处理。
不要把多余的文件上传。

每天晚上九点群里报告完成情况。



