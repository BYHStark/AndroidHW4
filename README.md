# AndroidHW4
安卓第四次作业实现了数据库的访问
contentprovider的实现：外界的程序通过ContentResolver接口可以访问ContentProvider提供的数据,可以通过Context使用getContentResolver()获得。
数据操作:CRUD–insert(),update(),delete(),query()
Uri参数： Uri是ContentResolver和ContentProvider进行数据交换的标识。两部分组成–权限+路径
具体使用过程如下:得到uri字符串后转化为Uri对象
使用Uri.parse()方法，把字符串转化成Uri对象。
如果查询:
Cursor cursor=getContentResolver().query{uri,…(其他参数)}

