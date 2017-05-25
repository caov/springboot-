搭建springboot工程，利用阿里大于的免费短信接口，实现定时短信的发送

1.搭建springboot开发环境

2.spring的@Scheduled定时注解的使用

3.阿里大于的短信接口使用，下载jar包

4.Maven引入本地jar包
	阿里大于没有maven repository。只能在项目中导入jar包，本地引入
<!-- 引入本地jar包 -->
<dependency>
	<groupId>my-jar</groupId>   <!--  自己随便取-->
	<artifactId>my-jar</artifactId> <!-- 自己随便取-->
	<version>1.0</version><!-- 自己随便取-->
	<scope>system</scope>
	<systemPath>${project.basedir}/src/main/java/mk/wq/jar/taobao-sdk-java-auto_1455552377940-20160607.jar</systemPath>
</dependency>
