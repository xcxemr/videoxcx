# 抖音视频解析去水印后端接口

## 技术实现
springboot 2.6.3

## 部署
修改application.yaml
    wx的appid和secret，功能上用来wxcode换openId
    修改jwt.key
prod/dev中有redis的链接配置，请酌情修改

java -jar 直接运行即可


## 接口说明
{POST}/video/parse  #ParseVideoController 解析视频信息
{POST}/login/loginwx #WXLoginController 类似登录，wxcode更换openId 并生成临时token


> 仅供学习参考