**一、*****\*本实训所对应的课程目标\****

课程目标1. 能够在移动应用的设计和开发过程中结合用户需求和客户特点，充分发挥创新思维，能够结合成本、性能、美观等客户需求，并能在设计决策的过程中综合考虑社会、健康、安全、法律、文化以及环境等因素；

课程目标2. 能够对移动应用的设计指标如响应时间、访问时间、资源占用等实验数据进行收集、分析和解释，并通过信息综合得到移动应用性能指标等结论；

课程目标3. 能够结合成本、性能、美观等客户需求，综合替他成员的意见，组织和协调团队成员展开工作；

课程目标4. 能够面对业界同行和社会公众，针对项目产品的设计理念、技术选型、功能特点、主要用例等内容进行有效的沟通和交流；

课程目标5. 能够掌握一定的项目开发能力，掌握应用Android进行手机APP开发的技能，在本项目的设计过程中综合考虑易用性、成本、效率、性能等目标来指导项目设计和实施。

**二、*****\*需求分析\****

本次实训选择的项目是开发一个贪吃蛇手机游戏。贪吃蛇游戏是一条蛇，不停地在手机屏幕上游走，吃在手机屏幕上出现的食物。当蛇吃掉1个食物后会变长，并且吃完食物时食物会消失，并立即随机生成1个新的食物，只要蛇头碰到屏幕四周或者碰到自己的身子，蛇就立即死亡。蛇死亡后会记录当前玩家本局的分数，纳入排行榜，排行榜会显示前十的分数。

通过本次课程设计，了解android软件的开发过程，熟悉并掌握JAVA语言， 程序关键在于表示蛇的图形及蛇的移动。用一个小矩形块表示蛇的一节身体，身体每长一节，增加一个矩形块，蛇头用一节表示。移动时必须从蛇头开始，所以蛇不能向相反的方向移动，如果不按任意键，蛇自行在当前方向上前移，但按下有效方向键后，蛇头朝着该方向移动，一步移动一节身体，所以按下有效方向键后，先确定蛇头的位置，而后蛇的身体随蛇头移动。意义是方便人们在休闲时通过玩手机游戏获得一点快乐，同时锻炼自己的大脑。

**三、*****\*概要设计\****

1、开发环境及工具

在Window10下进行，采用Android Studio开发工具，基于安卓操7.0作系统。

环境搭建:

a.  JDK安装

b.  Android Studio安装

c.  Gradle安装 Gradle是一款基于JVM的专注于灵活性和性能的开源构建工具。 

d.  ADT安装创建AVD

2、游戏界面分析

操作界面应该人性化设计，提示玩家按什么按键开始游戏，开始游戏之后，在游戏界面中，以坐标的形式对整体界面进行划分，将界面划分为网格，还应设计蛇的样式，食物的样式和墙的样式，在蛇吃到食物后的样式，还有游戏结束时的界面显示，游戏结束后，要显示所得的分数。

3、游戏角色分析

设置游戏贪吃蛇初始时由固定小矩形块组成，在游戏中，要随机出现由单个矩形块构成的食物，并且设置随机出现的食物不要出现在蛇的身体中，在蛇吃到食物的时候，蛇的身体加长。此外，要判定游戏成功与失败的条件，当蛇的头和尾相撞或者蛇的头部撞到了墙上，则游戏失败，此时游戏结束，界面显示所得分数。另外蛇的移动原理，由外部按键设置监听控制蛇头的移动方向，在方向的指引下进行移动，蛇及食物的位置都是由坐标数组确定的，食物的位置也是随机产生的蛇的移动原理是后一矩形块覆盖前一个矩形块。当一个食物被吃掉的时候，要自动随机生成并显示下一个食物的位置。这些都是在设计过程中需要实现的。

4、游戏控制分析

游戏中需要通过按键对蛇的移动方位进行控制，共需要设置四个方位，分别是“东”“西”“南”“北”，在按键上用“上”“下”“左”“右”，按键与执行部分涉及到监听，通过监听指示蛇的运动，此外，要设置蛇移动是的默认方向为“右”

，蛇的移动只能是90度偏转，不能进行180度偏转。此外还要设置游戏的状态，有运行和结束两种状态，蛇体变长的时候用静态变量进行加分。

5、可行性分析

　　 贪吃蛇游戏是一种简单的大众的游戏，自从进入现代化以来，深受广大电脑和手机玩家的喜爱，所以做一个简单的贪吃蛇小游戏是有用的。

　　本次设计我主要运用Java语言来完成。Java语言是一种跨平台，适合于分布式计算环境的面向对象编程语言，用Java写的应用程序不用修改就可在不同的软硬件平台上运行。

　　由于Java主要用于网络应用程序开发，因此对安全性有较高的要求。如果没有安全保证，用户从网络下载程序执行就非常危险。Java通过自己的安全机制防止了病毒程序的产生和下载程序对本地系统的威胁破坏

 

**四、*****\*详细设计\****

## ***\*功能流程图\****

![img](https://github.com/wkfvawl/Android-RetroSnaker/blob/master/img/%E5%9B%BE%E7%89%871.png)

 

本项目中主要包括4个类，分别为MainActivity（主界面）、ScoreActivity（得分展示界面）、SnakeView（游戏画面绘制）和SnakeDBOpenHelper（数据库辅助类）类，通过不同Activity之间的转换实现不同界面之间的切换。MainActivity和NextScoreActivityctivity继承了Activity类，SnakeView类继承了View类，SnakeDBOpenHelper类继承了SQLiteOpenHelper类。 MainActivity类是这个游戏的入口点， SnakeView类进行游戏的绘画和对游戏控制操作的处理。 

 

**五、*****\*关键代码\****

***\*1、MainActivity类\****

程序的入口，程序的界面。代码如下：

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnSnakeDeadListener,OnSnakeEatFoodListener {
    Button button_start;
    Button button_pause;
    Button button_up;
    Button button_down;
    Button button_left;
    Button button_right;
    TextView textview_score;
    SnakeView snakeView;
    private int highscore = 0;
    private SnakeDBOpenHelper openHelper;
    private EditText input;//Dialog中EditText对象
    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_start = (Button)this.findViewById(R.id.buttonStart);            button_start.setOnClickListener(this);
        button_pause = (Button)this.findViewById(R.id.buttonPause);
        button_pause.setOnClickListener(this);
        button_up = (Button)this.findViewById(R.id.buttonUp);
        button_up.setOnClickListener(this);
        button_down = (Button)this.findViewById(R.id.buttonDown);
        button_down.setOnClickListener(this);
        button_left = (Button)this.findViewById(R.id.buttonLeft);
        button_left.setOnClickListener(this);
        button_right = (Button)this.findViewById(R.id.buttonRight);
        button_right.setOnClickListener(this);
        textview_score = (TextView)this.findViewById(R.id.textView_Score);
        snakeView = (SnakeView)this.findViewById(R.id.myView);
        snakeView.setmOnSnakeDeadListener(this);
        snakeView.setmOnSnakeEatListener(this);

        openHelper = new SnakeDBOpenHelper(this,"table_score",null,1);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 1",null);
        if(cursor != null && cursor.getCount() >= 1){
            cursor.moveToFirst();
            highscore = cursor.getInt(2);
        }
        textview_score.setText("分数：0"+ "    最高分数：" + highscore);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonStart:
                snakeView.StartGame();
                break;
            case R.id.buttonPause:
                snakeView.PauseGame();
                break;
            case R.id.buttonUp:
                snakeView.ControlGame(SnakeView.DIR_UP);
                break;
            case R.id.buttonDown:
                snakeView.ControlGame(SnakeView.DIR_DOWN);
                break;
            case R.id.buttonLeft:
                snakeView.ControlGame(SnakeView.DIR_LEFT);
                break;
            case R.id.buttonRight:
                snakeView.ControlGame(SnakeView.DIR_RIGHT);
                break;
        }
    }
    //加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.view_rank){
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
   //蛇死亡
    @Override
    public void OnSnakeDead(int foodcnt) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View textEntryView = inflater.inflate(R.layout.dialoglayout,null);
        input = (EditText) textEntryView.findViewById(R.id.editText_Name);
        final int score = foodcnt - 4;//最终的得分是蛇身的长度减去4 蛇身一开始就有4单位的长度
        AlertDialog.Builder builder = new AlertDialog.Builder(this);//弹出对话框
        builder.setTitle("游戏结束，请输入姓名");
        builder.setView(textEntryView);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = input.getText().toString().trim();
                SQLiteDatabase db = openHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 10",null);
                //确保有数据
                if(cursor == null){
                    db.close();
                    return;
                }
                //少于十条 直接插入
                if(cursor.getCount() < 10){
                    db.execSQL("insert into table_score(name,score) values(?,?)",
                            new String[]{name,Integer.toString(score)});
                }
                //多于十条 更新
                else{
                    cursor.moveToLast();
                    String id = cursor.getString(0);
                    int oldscore = cursor.getInt(2);
                    if(score > oldscore){
                        db.execSQL("update table_score set name=?,score=? where id=?",
                                new String[]{name,Integer.toString(score),id});
                    }
                }
                db.close();
            }
        });
        builder.show();
        //Toast.makeText(this,"Game Over!",Toast.LENGTH_SHORT).show();
    }
    //蛇吃到食物
    @Override
    public void OnSnakeEatFood(int foodcnt) {
        if(foodcnt > highscore){
            highscore = foodcnt;
        }
        textview_score.setText("分数：" + foodcnt + "    最高分数：" + highscore);
    }
}
```

***\*2、ScoreActivity类\****

得分显示界面的Activity，查询展示游戏得分

代码如下：

```java
public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        SnakeDBOpenHelper openHelper = new SnakeDBOpenHelper(ScoreActivity.this,"table_score",null,1);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 10",null);
        if(cursor == null){
            return;
        }
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("rank", Integer.toString(i + 1));
            map.put("name",cursor.getString(1));
            map.put("score",cursor.getString(2));
            //保存到ArrayList数组队列中
            list.add(map);
            cursor.moveToNext();
        }
        SimpleAdapter adapter = new SimpleAdapter(ScoreActivity.this,list,R.layout.listitemlayout,
                new String[]{"rank","name","score"},
                new int[]{R.id.textView_itemrank,R.id.textView_itemname,R.id.textView_itemscore});
        ListView listView = (ListView)this.findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
```

 

***\*3\*******\*、SnakeView类\****

SnakeView的基类是View，包含了贪吃蛇游戏画面的各个设定参数，主要负责绘制游戏画面。还定义了游戏运行时的画面改变及蛇体和食物的更新方法。SnakeView类定义如下：````

```java
public class SnakeView extends View {

    private int mBlocksize = 20;//单元格的边长
    private int mWidth,mHeight;//游戏区域的范围,代表单元格的个数
    private int mOffsetX,mOffsetY;//活动区域的偏移量
    private int mSnakeLen;//蛇身长度
    private int[] mSnakeX = new int[100];//蛇的身体坐标
    private int[] mSnakeY = new int[100];
    private int mSnakeDir;//蛇的移动方向
    private int mFoodX,mFoodY;//食物的坐标
    private int mFoodCnt;//吃到的食物个数
    Paint ptBackground = new Paint();
    Paint ptHead = new Paint();
    Paint ptBody = new Paint();
    Paint ptFood = new Paint();
    Paint ptBorder = new Paint();
    //蛇的游动方向
    public static final int DIR_UP = 0;//向上
    public static final int DIR_RIGHT = 1;//向右
    public static final int DIR_DOWN = 2;//向下
    public static final int DIR_LEFT = 3;//向左
    //定时器相关设置
    //在开发中我们有时会有这样的需求，即在固定的每隔一段时间执行某一个任务。
    //比如UI上的控件需要随着时间改变，我们可以使用Java为提供的计时器的工具类，即Timer和TimerTask。
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private Handler mHandler = null;
    private final int SNAKE_MOVE = 1;
    private int mGameStatus;
    //状态编号
    private final int STATUS_RUN = 1;
    private final int STATUS_DEAD = 2;
    private final int STATUS_PAUSE = 3;
    private final int STATUS_START = 0;
    private OnSnakeEatFoodListener mOnSnakeEatListener;
    private OnSnakeDeadListener mOnSnakeDeadListener;

    public void setmOnSnakeEatListener(OnSnakeEatFoodListener mOnSnakeEatListener){
        this.mOnSnakeEatListener = mOnSnakeEatListener;
    }
    public void setmOnSnakeDeadListener(OnSnakeDeadListener mOnSnakeDeadListener){
        this.mOnSnakeDeadListener = mOnSnakeDeadListener;
    }

    //代码创建控件时被调用
    public SnakeView(Context context) {
        super(context);
        InitGame();
    }
    //此构造方法在XML文件中创建控件时被调用
    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        InitGame();
    }

    public void InitGame(){
        ptBackground.setColor(Color.argb(255,0,0,0));
        ptHead.setColor(Color.argb(255,255,0,0));
        ptBody.setColor(Color.argb(255,255,211,55));
        ptBorder.setColor(Color.argb(255,255,255,255));
        ptFood.setColor(Color.argb(255,0,11,255));
        InitSnake();

        //蛇定时器
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case SNAKE_MOVE:
                        SnakeMove();
                        break;
                    default:
                        break;
                }

            }
        };

        if(mTimer == null){
            mTimer = new Timer();
        }
        if(mTimerTask == null) {
            mTimerTask = new TimerTask(){
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = SNAKE_MOVE;
                    mHandler.sendMessage(message);
                }
            };
        }
        if(mTimer != null && mTimerTask != null){
            mTimer.schedule(mTimerTask,300,300);
        }
    }
    public void SnakeMove(){
        //如果游戏不处于运动状态，不进行蛇的游动
        if(mGameStatus != STATUS_RUN){
            return;
        }
        int newheadx = 0, newheady = 0;
        //计算蛇头的位置
        //mSnakeDir蛇的移动方向
        switch (mSnakeDir){
            case 0:
                newheadx = mSnakeX[0];
                newheady = mSnakeY[0] - 1;
                break;
            case 1:
                newheadx = mSnakeX[0] + 1;
                newheady = mSnakeY[0];
                break;
            case 2:
                newheadx = mSnakeX[0];
                newheady = mSnakeY[0] + 1;
                break;
            case 3:
                newheadx = mSnakeX[0] - 1;
                newheady = mSnakeY[0];
                break;
        }
        //判断蛇头是否超过游戏区域，如果超过进游戏区域更改游戏状态
        if(newheadx < 0 || newheadx >= mWidth || newheady < 0 || newheady >= mHeight){
            mGameStatus = STATUS_DEAD;//撞墙 贪吃蛇死亡游戏结束
            if(mOnSnakeDeadListener != null){
                mOnSnakeDeadListener.OnSnakeDead(mSnakeLen);
            }
            return;
        }
        //判断蛇是否吃到食物，如果吃到食物则将身体增加，并随即生成下一个食物
        if(newheadx == mFoodX && newheady == mFoodY){
            Random random = new Random();//随机生成位置
            mFoodX = random.nextInt(mWidth - 1);
            mFoodY = random.nextInt(mHeight - 1);
            mSnakeLen++;//蛇身长度加1
            mFoodCnt++;//吃到食物加1

            if(mOnSnakeEatListener != null){
                mOnSnakeEatListener.OnSnakeEatFood(mFoodCnt);
            }
        }
        //挪动蛇的位置
        for(int i = mSnakeLen - 1; i > 0; i--){
            mSnakeX[i] = mSnakeX[i - 1];
            mSnakeY[i] = mSnakeY[i - 1];
        }

        //设定蛇头的位置
        mSnakeX[0] = newheadx;
        mSnakeY[0] = newheady;
        //触发onDraw进行重绘
        invalidate();
        //Invalidate()函数的作用是使整个窗口客户区无效，窗口客户无效即需要重绘
    }

    public void StartGame(){
        switch (mGameStatus){
            case STATUS_DEAD:
                InitSnake();
                mGameStatus = STATUS_RUN;
                if(mOnSnakeEatListener != null){
                    mOnSnakeEatListener.OnSnakeEatFood(mFoodCnt);
                }
                break;
            case STATUS_PAUSE:
                mGameStatus = STATUS_RUN;
                break;
            case STATUS_START:
                mGameStatus = STATUS_RUN;
                break;
            default:
                break;
        }
    }

    public void PauseGame(){
        if(mGameStatus == STATUS_RUN){
            mGameStatus = STATUS_PAUSE;
        }
    }
    //核心 控制蛇的方向 依据状态参数
    public void ControlGame(int dir){
        if(mGameStatus != STATUS_RUN){
            return;
        }
        switch (dir){
            case DIR_UP:
                mSnakeDir = dir;
                break;
            case DIR_RIGHT:
            case DIR_DOWN:
            case DIR_LEFT:
                mSnakeDir = dir;
                break;
            default:
                break;
        }
    }

    //蛇的初始化状态
    public void InitSnake(){
        mSnakeLen = 4;
        mSnakeX[0] = 3;
        mSnakeY[0] = 0;
        mSnakeX[1] = 2;
        mSnakeY[1] = 0;
        mSnakeX[2] = 1;
        mSnakeY[2] = 0;
        mSnakeX[3] = 0;
        mSnakeY[3] = 0;
        mFoodX = 4;
        mFoodY = 4;
        mFoodCnt = 0;
        mSnakeDir = DIR_RIGHT;
    }
    //View尺寸发生变化时的方法
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w/mBlocksize - 1;
        mHeight = h/mBlocksize - 1;
        mOffsetX = (w - mWidth * mBlocksize)/2;
        mOffsetY = (h - mHeight * mBlocksize)/2;
    }

    //Paint 类 我们称之为画笔，为画图的过程中，定义各种参数，比如：颜色、线条样式、图案样式等。
    //Canvas 类我们定义为画布，主要提供若干方法用于绘制各种颜色图案：点、线、路径等。
    //绘制布局内容的方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画游戏区域背景
        canvas.drawRect(mOffsetX,mOffsetY,(mWidth) * mBlocksize + mOffsetX,
                (mHeight) * mBlocksize + mOffsetY,ptBackground);
        //画游戏区域边框
        canvas.drawLine(mOffsetX - 1,mOffsetY - 1,mWidth * mBlocksize +mOffsetX,
                mOffsetY - 1,ptBorder);
        canvas.drawLine(mOffsetX - 1,mOffsetY - 1,mOffsetX - 1,
                mHeight * mBlocksize + mOffsetY,ptBorder);
        canvas.drawLine(mWidth * mBlocksize + mOffsetX,mOffsetY - 1,
                mWidth * mBlocksize + mOffsetX,mHeight * mBlocksize + mOffsetY,ptBorder);
        canvas.drawLine(mOffsetX - 1,mHeight * mBlocksize + mOffsetY,
                mWidth * mBlocksize + mOffsetX,mHeight * mBlocksize + mOffsetY,ptBorder);
        //画食物
        canvas.drawRect(mFoodX * mBlocksize + mOffsetX,mFoodY * mBlocksize + mOffsetY,
                (mFoodX + 1) * mBlocksize + mOffsetX,
                (mFoodY + 1) * mBlocksize + mOffsetY,ptFood);
        //画蛇
        for(int i = 0; i < mSnakeLen; i++){
            if(i == 0){
                //画蛇头
                canvas.drawRect(mSnakeX[i] * mBlocksize + mOffsetX,mSnakeY[i] * mBlocksize + mOffsetY,
                        (mSnakeX[i] + 1) * mBlocksize + mOffsetX,
                        (mSnakeY[i] + 1) * mBlocksize + mOffsetY,ptHead);
            }else{
                //画蛇身
                canvas.drawRect(mSnakeX[i] * mBlocksize + mOffsetX,mSnakeY[i] * mBlocksize + mOffsetY,
                        (mSnakeX[i] + 1) * mBlocksize + mOffsetX,
                        (mSnakeY[i] + 1) * mBlocksize + mOffsetY,ptBody);
            }
        }
    }
}
```

***\*4\*******\*、SnakeDBOpenHelper类\****

继承自SQLiteOpenHelper，通过重新onCreate()、onUpgrade()方法用于创建打开数据库

代码如下：

```java
public class SnakeDBOpenHelper extends SQLiteOpenHelper {
    public SnakeDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table table_score(" +
                "id INTEGER NOT NULL PRIMARY KEY ," +
                "name TEXT,score Integer);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_score");
        onCreate(sqLiteDatabase);
    }
}
```



## ***\*界面设计\****

界面设计包括游戏主界面、游戏结束界面的设计。界面的设计采用的是xml文档形式，在xml文档中规划好界面布局布局后，分别在java文件中声明。

（1）游戏主界面activity_main，主界面采用相对布局设定，指定自定义的控件。其activity_main.xml文档如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.test.game.MainActivity">
    <Button
        android:id="@+id/buttonRight"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:text="→"/>
    <Button
        android:id="@+id/buttonDown"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@id/buttonRight"
        android:layout_toLeftOf="@id/buttonRight"
        android:text="↓"/>
    <Button
        android:id="@+id/buttonLeft"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@id/buttonDown"
        android:layout_toLeftOf="@id/buttonDown"
        android:text="←"/>
    <Button
        android:id="@+id/buttonUp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@id/buttonDown"
        android:layout_toRightOf="@id/buttonLeft"
        android:text="↑"/>
    <Button
        android:id="@+id/buttonPause"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@id/buttonLeft"
        android:layout_alignParentLeft="true"
        android:layout_toLeftOf="@id/buttonLeft"
        android:text="暂停"/>
    <Button
        android:id="@+id/buttonStart"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@id/buttonUp"
        android:layout_alignLeft="@id/buttonPause"
        android:layout_alignRight="@id/buttonPause"
        android:text="开始"/>
    <TextView
        android:id="@+id/textView_Score"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@id/buttonStart"
        android:layout_alignParentLeft="true"
        android:text="分数：0 最高分数：0"
        android:textAppearance="?android:attr/textAppearanceLarge"/>
    <com.example.test.widget.SnakeView
        android:id="@+id/myView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@id/textView_Score"
        />
</RelativeLayout>

```

（2）得分显示界面activity_score，界面采用线性布局设定，指定自定义的控件。其activity_score.xml文档如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<!--线性布局-->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.test.game.ScoreActivity"
    android:orientation="vertical">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/textView_HeadRank"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="排名"
            android:gravity="center"
            android:textAppearance="?android:attr/textAppearanceMedium"
            />
        <TextView
            android:id="@+id/textView_HeadName"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="玩家姓名"
            android:gravity="center"
            android:textAppearance="?android:attr/textAppearanceMedium"
            />
        <TextView
            android:id="@+id/textView_HeadScore"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="得分"
            android:gravity="center"
            android:textAppearance="?android:attr/textAppearanceMedium"
            />
    </LinearLayout>
    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></ListView>
</LinearLayout>
```

（3）界面设计完成，但还有最重要的一步，就是将所有的Activity注册到AndroidManifest.xml中。AndroidManifest.xml文档如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.test.game">
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".ScoreActivity"></activity>
    </application>
</manifest>
```

 

**六、*****\*实训\*******\*结果\****

经过在模拟器上的测试,本软件能实现其功能,达到了蛇在屏幕上的移动,蛇吃食物,食物随机出现的功能,当蛇与墙相撞时,游戏结束.这些均在测试中得到验证。

（1）游戏时

![img](https://github.com/wkfvawl/Android-RetroSnaker/blob/master/img/%E5%9B%BE%E7%89%872.png) 

 

（2）游戏结束时，保存玩家

![img](https://github.com/wkfvawl/Android-RetroSnaker/blob/master/img/%E5%9B%BE%E7%89%873.png) 

（3）查询排名

![img](https://github.com/wkfvawl/Android-RetroSnaker/blob/master/img/%E5%9B%BE%E7%89%874.png) 

通过对游戏软件的功能测试，控制测试和界面测试。对游戏的开始新游戏、退出和统计分数功能进行测试，并测试程序的键盘点击事件，结论是该游戏软件能正确实现功能要求。要求输出的效果与预期的输出效果完全一致。

 

**七、*****\*实训总结\****

这次Android课程设计让我重新熟悉了Android工程的框架及设计的步骤，以及每个文件的作用，稍微掌握了一些View类的方法，同时也学到了更多的界面设计的方法，比如如何自定义视图等。在学习、使用Java的过程中，进一步在总体上让我对编程语言有了新的认识。在设计、调试、修改的过程当中，我对程序的设计与构架在整体上有了进步。

这次通过做Android课程设计，我完成了小游戏贪吃蛇的任务。在整个过程中遇到了一些问题，如蛇头怎样移动，蛇的尾巴怎样跟着移动，还有在默认情况下怎样让蛇自行移动、时间处理的机制和界面的设计问题，但最终部分被解决了，还有一些自己想到的功能，已经去做了但还是出现问题，还没能做出来，如暂停游戏、完成游戏获得分数、存档、游戏排名、蛇无效方向处理和加快蛇移动速度等，后面有时间的话，在继续深入把没有完成的功能做出来。

在这一次的课设过程中，我查阅了相关的资料，对Android有了进一步的认识，希望以后可以用Android做出一款大型软件，而不只是小游戏。Android让我比较头疼的是有些只是知道代码的作用，却不是很清楚硬件的工作原理，还有遇到一些问题就想放弃了，这是我今后要克服的。通过这次编程，还让我认识到了自己的不足，在编程方面，我发现自己是刚刚入门，对代码还不是很熟悉，需要我不断的充实自己，这样才能在程设计方面有所收获。

 
