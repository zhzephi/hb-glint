# androidThings-glint
androidThings练手demo，控制LED灯，进行间隔性闪烁1次和闪烁2次。

#### 简介
使用树莓派3b进行练手，用led灯接电路进行控制

#### 所需要的组件
* 树莓派主板
* 树莓派配套电源线
* 面包板
* 连接线3根
* LED灯1只
* 200-300Ω电阻一个

#### 接线电路图
1. 找到GPIO针脚的两个针，一个是Ground（TF卡那边开始，内侧一排第5个针脚），另外一个是BCM5（USB那边开始，就是内侧一排倒数第6个针脚）
2. 使用一条线（我用的黑线）一端连接Ground针脚，另一端插在面包板的最外边第一个针眼
3. 另外一条线（我用的白线）一端连接BCM5针脚，另一端插在面包板a9位置
4. 把电阻一端插在a9连接的一行任意针眼，另一端插入B18针眼位置
5. 用LED一端插在B18一行（5针一行）任意位置，另一端插入f18位置
6. 用一条线（我用的黑线）一端插入f18一行（5针一行）任意位置，另一端插入最外层Ground一行（最外层一行整个是通电的）
7. 打开电源开关，运行apk，看到led按照程序闪烁


#### 注意点
* 面包板使用方式，不懂的话先花2分钟google一下
* 为什么加电阻，最重要是为了保护电路，保护树莓派针脚，避免出现短路，烧坏元器件
