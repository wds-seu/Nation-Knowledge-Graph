# Nation-Knowledge-Graph
民族知识图谱构建Demo

## 一、 需求分析
进行民族文化基因可融合性的计算。具体步骤包括：
（1） 根据建筑学院提供民族相关的九大要素（衣、食、住、行、工、兵、礼、境、象）进行语料库的构建；——数据抓取和数据清洗
（2） 通过较新的命名实体识别和关系抽取技术进行知识获取；——信息抽取
（3） 构建民族相关知识图谱并进行展示；——知识图谱存储和可视化
（4） 进行文化基因可融合性的计算。——待定
目前只聚焦于人口排名前十的少数民族（不包括汉族）：壮族、维吾尔族、回族、苗族、满族、彝族、土家族、藏族、蒙古族、布依族。共计10个。统计数据来源：第七次人口普查，中国56个民族人口排名 - https://www.bilibili.com/read/cv14109722/

## 二、架构设计
![image](https://user-images.githubusercontent.com/42593013/178111410-c9e39740-2ad7-4ca5-87b1-8cabbd285902.png)

## 三、项目环境
SpringBoot 2.1.3
Elasticsearch 6.5.4  
Kibana 6.5.4

## 四、数据来源
### 4.1 九大要素含义
衣：穿着、服饰等。
食：饮食。
住：建筑。
行：出行、交通等。
工：劳作、工作等。
兵：武器、防御、武术等。
礼：礼仪、风俗等。
境：自然风景、居住聚落的环境等。
象：象征，图腾，符号等。

### 4.2 半结构化数据来源
鉴于互联网资源参差不齐，目前只考虑质量高的几个来源：
● 百度百科：经典
● 中国民族文化资源网：http://www.minzunet.cn/
● 中华民族文化资源库：http://www.minwang.com.cn/
● 维基百科（可以暂不考虑，内容不是很多）

### 4.3 非结构化数据来源
要精挑细选质量高的中文文献，数量不宜多，一个民族中的一个要素1-2篇为宜。

## 五、数据处理
### 5.1 数据爬取/pdf文件转换
pdf文件转换
思路：将pdf按页读取为jpg格式图片（最好为灰度图片，保证每张图片小于1MB），使用ocrspace api，读取图片中的文本信息，读取的文本信息包括注释、作者信息、换行符等噪声，需要清洗

### 5.2 半结构化/非结构化数据清洗

### 5.3 基于ES的语料库构建
参考教程：https://blog.csdn.net/a767815662/article/details/104128170
输入：.xls文件.索引分为十个，“民族、衣、食、住、行、工、兵、礼、境、象”，这样十个民族就是十条数据（暂定），可参照testNation.xlsx
往 ES 中导入数据：执行 Nation-Knowledge-Graph/SpringBoot-Elasticsearch-Nation-Demo/src/test/java/com/xinghua/elasticsearchservice/NationEsTest.java 的 batchInsertOrUpdate 方法进行批量数据的导入
输出：
Kibana界面
![image](https://user-images.githubusercontent.com/42593013/178110309-56e1ec56-6d91-4a55-9f00-4112358faf5b.png)

## 六、信息抽取

## 七、持久化

## 八、业务层

## 九、应用层

## 十、参考文献
