# Nation-Knowledge-Graph
民族知识图谱构建Demo

## 1 参考教程
https://blog.csdn.net/a767815662/article/details/104128170

## 2 所需工具
SpringBoot + Elasticsearch + Kibana

## 3 使用
### 输入
.xls文件.索引分为十个，“民族、衣、食、住、行、工、兵、礼、境、象”，这样十个民族就是十条数据（暂定），可参照testNation.xlsx

### 往 ES 中导入数据
执行Nation-Knowledge-Graph/SpringBoot-Elasticsearch-Nation-Demo/src/test/java/com/xinghua/elasticsearchservice/NationEsTest.java 的 batchInsertOrUpdate 方法进行批量数据的导入
### 输出
Kibana界面
![image](https://user-images.githubusercontent.com/42593013/178110309-56e1ec56-6d91-4a55-9f00-4112358faf5b.png)
