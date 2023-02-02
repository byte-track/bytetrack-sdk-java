# bytetrack-sdk-java
openAPI接口对应的java版本sdk
- 该sdk是对bytetrack API接口的Java版封装

# JDK版本
- 1.8及以上

# 安装
- maven引用
<br/>bytetrack-server-sdk的构建包已经托管在中央仓库里，直接在项目里添加依赖即可,当前最新Release版本是v1.0.1
```javascript
<dependency>
  <groupId>io.github.byte-track</groupId>
  <artifactId>bytetrack-server-sdk</artifactId>
  <version>1.0.1</version>
</dependency>
```
# 源码下载
- 下载地址：git@github.com:byte-track/bytetrack-sdk-android.git
- 编译源码并安装到本地maven仓库：mvn -Dmaven.test.skip=true clean install

#开始使用
- 具体用法：参考bytesTrack-server-sdk/src/test/BytetrackTest.java方法，也可参考bytetrack开发者文档
