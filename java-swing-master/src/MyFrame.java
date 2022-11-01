import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import java.awt.Image;

import static java.awt.Image.SCALE_DEFAULT;
import static java.awt.Image.SCALE_FAST;

public class MyFrame extends JFrame {
    public MyFrame() {
        /* 初始化各元器件 */
        initComponents();
    }

    /* 初始化元器件函数 */
    private void initComponents() {
        // region 窗口初始化部分
        /* 设置窗口标题 */
        setTitle("课堂选人");
        setLayout(null);
        setSize(450,100);
        /* 设置窗口最小尺寸 */
        setMinimumSize(new Dimension(650, 550));
        /* 设置窗口布局格式 frameContent:窗口内容容器 */
        var frameContent = getContentPane();
        frameContent.setLayout(new BorderLayout());
        /* 设置默认关闭 */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* 设置窗口位置 */
        setLocation(100, 100);
        // endregion
//        String[] srcPath = {"/img/20210201101.jpg", "/img/20210201102.jpg", "/img/20210201103.jpg","/img/20210201104.jpg","/img/20210201105.jpg"};     //资源文件
//        String[] loadPath = new String[10];
        // region 元件初始化部分
        String[] arr2 = {"柏佳怡","贲广龙","柴泽豪","陈海锋","陈教庆","陈凯","陈磊能","陈文浩","陈钖",
                "丁瑞宽", "杜建广","方贝贝","冯佳宝","洪羽音","胡晨阳","胡凯程","胡永涛","李新宇","梁铭琛",
                "林俊杰", "陆俊杰","罗桓宇","邱金剑","邱翔","舒元祺","汪腾","王昌晖","王栋林","王璐阳","吴柳燕",
                "吴雪望", "武振航","夏明锦","夏尚凯","徐洪伟","徐梦婷","徐任坤","徐腾建","许道俊","应晨杰","余建奥",
                "虞彬彬", "郑书涵","周旭","周子禾"
        };
        String[] arr1 = {"猛虎队","面包人","腊肠人","金花茶","花园宝宝"};
        /*文字描述*/
        JLabel pop = new JLabel();
        pop.setText("已选人员:");
        pop.setFont(new java.awt.Font("微软雅黑", 1, 20));
        /* 选人模式 */
        JLabel pick = new JLabel();
        pick.setText("选人模式");
        /* 得分区 */
        JTextField num = new JTextField();
        /* 背景*/
        JPanel Image = new JPanel();
        /*图片*/
        JLabel icon = new JLabel();
        /* 主题区域 */
        JPanel panelMain = new JPanel();
        /* 标题区域 */
        JLabel labelTitle = new JLabel();
        /* 选人姓名区域*/
        JLabel NameText = new JLabel();
        NameText.setText("NEW");
        NameText.setFont(new java.awt.Font("微软雅黑", 1, 50));
        Timer timer1 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int s = (int) (Math.random() * 45);
                System.out.println(s);
                NameText.setText(arr2[s]);
                if(s < 10){
                    int width = 200,height = 250;	//这是图片和JLable的宽度和高度
                    int num = s + 1;
                    ImageIcon image = new ImageIcon("img/2021020110" + num + ".jpg");//实例化ImageIcon 对象
                    image.setImage(image.getImage().getScaledInstance(width, height,SCALE_DEFAULT));
                    icon.setIcon(image);
                    icon.setSize(width,height);
                }else if (s >= 10){
                    int width = 200,height = 250;	//这是图片和JLable的宽度和高度
                    int num = s + 1;
                    ImageIcon image = new ImageIcon("img/202102011" + num  + ".jpg");//实例化ImageIcon 对象
                    image.setImage(image.getImage().getScaledInstance(width, height,SCALE_DEFAULT));
                    icon.setIcon(image);
                    icon.setSize(width,height);
                }

            }
        });
        timer1.stop();
        int a;
        Timer timer2 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = (int) (Math.random() * 5);
                NameText.setText(arr1[a]);
                int width = 200,height = 250;	//这是图片和JLable的宽度和高度
                ImageIcon image = new ImageIcon("img/team/" + a + ".jpg");//实例化ImageIcon 对象
                image.setImage(image.getImage().getScaledInstance(width, height,SCALE_DEFAULT));
                icon.setIcon(image);
                icon.setSize(width,height);
            }
        });
        timer2.stop();
        /* 历史消息区域*/
        JTextArea news = new JTextArea();
        news.setColumns(1);
        /* 出生月选择框 */
        JComboBox<String> comboBoxMonth = new JComboBox<>();

        /* 按钮区域 */
        JPanel panelBtn = new JPanel();
        /* 按钮NS */
        JButton buttonNS = new JButton();
        /* 按钮C */
        JButton buttonC = new JButton();
        /* 按钮E */
        JButton buttonE = new JButton();
        // endregion

        // region panelMain设置区域
        /* 设置panelMain为8行1列网格布局 */
        panelMain.setLayout(null);
        //endregion
        /* 设置下拉框大小 */
        comboBoxMonth.setPreferredSize(new Dimension(140, 30));
        /* 设置下拉框内容 */
        comboBoxMonth.setModel(new DefaultComboBoxModel<>(new String[]{
                "---请选择选人模式---",
                "按组选",
                "按人选"
        }));
        /*选择框*/
        comboBoxMonth.setBounds(65,5,140,30);
        /*描述文字*/
        pick.setBounds(10,-30,100,100);
        /*得分*/
        num.setBounds(490,5,70,30);
        /*确认评分*/
        buttonNS.setBounds(565,5,60,30);
        /*背景颜色*/
        Image.setBounds(0,0,800,600);
        Image.setBackground(new Color(221,221,221));
        /*照片*/
        icon.setBounds(225,70,200,250);
        icon.setBackground(new Color(255,255,255));
        icon.setSize(200,250);
        /*姓名*/
        NameText.setBounds(250,300,300,100);
        /*选人按钮*/
        buttonC.setBounds(250,380,140,50);
        /*文本区*/
        news.setBounds(0,450,650,100);
        pop.setBounds(10,420,100,20);
        panelMain.add(icon);
        panelMain.add(pick);
        panelMain.add(comboBoxMonth);
        panelMain.add(num);
        panelMain.add(NameText);
        panelMain.add(buttonC);
        panelMain.add(pop);
        panelMain.add(news);

        /* 设置按钮文字 */
        buttonNS.setText("评分");
        /* 设置提交事件 */
        buttonNS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // region 检查填写,选择区域
                if( comboBoxMonth.getSelectedItem() == "按人选"){
                    news.setText(news.getText() + "   " + NameText.getText() + "获得(" + num.getText() + "分)");
                }else {
                    news.setText(news.getText() + "   " + NameText.getText() + "小组获得(" + num.getText() + "分)");
                }
            }
        });
        /* 添加到区域 */
        panelMain.add(buttonNS);
        panelMain.add(Image);
        // endregion

        // region Clear按钮
        /* 设置按钮文字 */
        buttonC.setText("开始选人");
        /* 添加清除事件 */
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxMonth.getSelectedItem() == "按人选"){
                    if(timer1.isRunning()){
                        timer1.stop();
                        buttonC.setText("开始选人");
                    }else{
                        timer1.start();
                        buttonC.setText("停止选人");
                    }
                }else{
                    if(timer2.isRunning()){
                        timer2.stop();
                        buttonC.setText("开始选人");
                    }else{
                        timer2.start();
                        buttonC.setText("停止选人");
                    }
                }

            }
        });
        /* 添加到区域 */


        // endregion

        // region Exit按钮

        /* 设置按钮文字 */
        buttonE.setText("Exit");
        /* 退出事件 */
        buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /* 添加到区域 */
        panelBtn.add(buttonE);

        // endregion

        panelMain.add(panelBtn);

        // endregion
        // region 窗口应用区域
        /* 主区域应用panelMain */
        frameContent.add(panelMain, BorderLayout.CENTER);
        /* 自动调整间距 */
        pack();
        //endregion

    }
}
