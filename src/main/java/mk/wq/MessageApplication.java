package mk.wq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mk.wq.utils.MessageUtils;

@SpringBootApplication
@EnableScheduling 
@Component 
public class MessageApplication {
    
    /**
    * @MethodName:  main
    * @Description: 程序入口
    * @author Van
    * @date 2017年5月10日 下午7:01:37
     */
	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}
	
	/**
	* @MethodName:  timeTasks
	* @Description: 定时任务
	* @author Van
	* @date 2017年5月10日 下午7:01:10
	 */
	@Scheduled(cron="0 0 7 * * ?")  //每天上午10点触发
    public void timeTasks() { 
	    String content = null;
	    Date date = new Date();
	    SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
	    String day = dateFm.format(date);
	    if(day.equals("星期一")){
	        content = "今天"+day+",新的一周，工作顺利";
	    }else if(day.equals("星期日")){
	        content = "今天"+day+", 掀起周末的门帘子，露出快乐的小样子，迈开轻松的小步子，哼着舒爽的小调子，晃晃开心的脚丫子，喊出你的小名字。祝你周末愉快，开心过日子！";
	    }else if(day.equals("星期六")){
            content = "今天"+day+", 结束五天忙碌，抛掉心中烦恼，释放精神压力，消除周身疲劳。周末到了，网上泡泡，睡睡懒觉，侃侃聊聊，到处跑跑，多彩生活，开心最好！";
        }else if(day.equals("星期五")){
            content = "今天"+day+",  做一个简单的人，踏实务实。不沉溺幻想，不庸人自扰。要快乐，要开朗，要坚韧，要温暖，对人要真诚。要诚恳，要坦然，要慷慨，要宽容，要有平常心。永远对生活充满希望，对于困境与磨难，微笑面对。";
        }else if(day.equals("星期四")){
            content = "今天"+day+", 花落花开，落下满地的思念，开不尽的是我无边的牵挂；云卷云舒，卷起一生的幸福，数不完的是我无限的祝愿。愿你好花常开，好运常来，早安！";
        }else if(day.equals("星期三")){
            content = "今天"+day+", 伴着昨夜美梦，呼吸舒爽晨风，亲吻美丽曙光，带着美好渴望，为了心中理想，喜迎新的一天。早安！祝你每天的清晨都精神抖擞。！";
        }else if(day.equals("星期二")){
            content = "今天"+day+", 人生是一道风景，快乐是一种心境，春看桃，夏见柳，秋观菊，冬赏梅，愿幸福陪伴你；月圆是诗，月缺是画，日上灿烂，日落浪漫，祝永远开心快乐！";
        }else{
            content = "开心最好";
        }
	    System.out.println(content);
	    //发送短信工具类
	    MessageUtils.sendMessage(content);
    } 
}
