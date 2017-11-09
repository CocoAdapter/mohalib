# mohalib
武汉大学 信息学部图书馆 预约座位 应用. 

核心业务在MainService里，主要作用是：每晚
<pre>
calendar.set(Calendar.HOUR_OF_DAY, 22); //设置22点的时候触发
        calendar.set(Calendar.MINUTE, 30); //设置30分钟的时候触发
        calendar.set(Calendar.SECOND, 0); //设置30秒的时候触发
</pre>
自动触发timer，预约抢座

> 部署在自己的服务器上，或者在本地跑（保证在当晚11：30前程序开始运行就行）。每天预约明天的，免去每晚10：30抢座的烦恼

代码是当时学Spring的时候写的，比较烂。(2017年11月9日19点45分)测试还能预约，以后跑不起来了，可能改API或者代码有问题，请自行修正

思路是：**先抓包从而获取学校系统的API，以及座位图/编号等资源，通过程序自动填表单，解决手速过慢（滑稽.jpg）的问题**

>因为当时发现靠窗位置都是刚过几秒就没了，肯定有人用同样的系统。

#请不要跟考研的人抢，技术无罪人有罪，我不想被喝茶



*Written at the winter of 2016.*

*Copyright © CocoAdapter, Ycoronene All rights reserved*