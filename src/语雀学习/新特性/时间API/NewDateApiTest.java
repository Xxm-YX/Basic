package 语雀学习.新特性.时间API;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class NewDateApiTest {

    public static void main(String[] args) {

        //旧
        Date date = new Date();
        System.out.println("old api"+ date);

        //新的方式，只能通过给定的方法获取
        LocalDate newDate = LocalDate.now();//日期 2020-12-12
        LocalTime newTime = LocalTime.now();//16:30:00:000
        LocalDateTime newDateTime = LocalDateTime.now();//日期+时间 2020-12-11
        System.out.println("newDate" + newDate);
        System.out.println("newTime" + newTime);
        System.out.println("newDateTime" + newDateTime);

        // 还可以组合
        LocalDateTime combineDateTime = LocalDateTime.of(newDate, newTime);
        System.out.println("combineDateTime" + combineDateTime);

        // 创建指定时间
        LocalDate customDate = LocalDate.of(2020, 11, 5);
        LocalTime customTime = LocalTime.of(16, 30, 0);
        LocalDateTime customDateTime = LocalDateTime.of(2020, 11, 5, 16, 30, 0);
        System.out.println("customDate" + customDate);
        System.out.println("customTime" + customTime);
        System.out.println("customDateTime" + customDateTime);


        System.out.println("************************************");
        // 获取时间参数的年、月、日（有时需求要用到）
        System.out.println("获取时间参数的年、月、日：");
        LocalDateTime param = LocalDateTime.now();
        System.out.println("year:" + param.getYear());
        System.out.println("month:" + param.getMonth());
        System.out.println("day:" + param.getDayOfMonth());
        System.out.println("hour:" + param.getHour());
        System.out.println("minute:" + param.getMinute());
        System.out.println("second:" + param.getSecond() + "\n");


        // 计算昨天的同一时刻（由于对象不可修改，所以返回的是新对象）
        System.out.println("计算前一天的当前时刻：");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plus(-1, ChronoUnit.DAYS);
        System.out.println("today:" + today);
        System.out.println("yesterday:" + yesterday);
        System.out.println("same object:" + today.equals(yesterday) + "\n");

        // 计算当天的00点和24点（你看，这里就看到组合的威力了）
        System.out.println("计算当天的00点和24点：");
        LocalDateTime todayBegin = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println("todayBegin:" + todayBegin);
        System.out.println("todayEnd:" + todayEnd + "\n");

        System.out.println("计算一周、一个月、一年前的当前时刻：");
        LocalDateTime oneWeekAgo = today.minus(1, ChronoUnit.WEEKS);
        LocalDateTime oneMonthAgo = today.minus(1, ChronoUnit.MONTHS);
        LocalDateTime oneYearAgo = today.minus(1, ChronoUnit.YEARS);
        System.out.println("oneWeekAgo" + oneWeekAgo);
        System.out.println("oneMonthAgo" + oneMonthAgo);
        System.out.println("oneYearAgo" + oneYearAgo + "\n");


        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:"+now);
        //将day修改为6号
        LocalDateTime modifiedDateTime = now.with(ChronoField.DAY_OF_MONTH, 6);
        System.out.println("modifiedDateTime:" + modifiedDateTime);


        LocalDateTime today1 = LocalDateTime.now();
        LocalDateTime after = today1.plusSeconds(1);
        boolean result = after.isAfter(today1);
        System.out.println("result=" + result);

        //时区**************************
        System.out.println("*************************************");

        //当地时间
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        //时区（id的形式，）默认是本国时区
        ZoneId zoneId = ZoneId.systemDefault();
        //补充时区信息
        ZonedDateTime beijingTime = now.atZone(zoneId);
        System.out.println("beijingTime:" + beijingTime);

        ZoneId of = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoTime = now.atZone(of);
        System.out.println("tokyoTime:" + tokyoTime);

        ZonedDateTime tokyoHot = beijingTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("东京时间："+ tokyoHot);


        // 先把LocalDateTime变为ZonedDateTime，然后调用toInstant()
        // Instant是代表本初子午线的时间，所以比我们的东八区要晚8小时
        Instant instant = beijingTime.toInstant();
        System.out.println("zonedDateTime:" + beijingTime);
        System.out.println("instant:" + instant);

        //转为Date
        Date date1 = Date.from(instant);
        System.out.println("date:" + date1);

        Date date2 = new Date();
        // Date也有toInstant()
        Instant instant1 = date.toInstant();
        System.out.println("date:" + date);
        System.out.println("instant:" + instant);

        // 不带时区：LocalDateTime.of()，带时区：LocalDateTime.ofInstant()
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("localDateTime:" + localDateTime);

        Date date3 = new Date();
        System.out.println(date.getTime() / 1000);

        LocalDateTime now3 = LocalDateTime.now();

        long result3 = now.toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println("bbbbbbbbbbbbbbbbb"+result3);

        LocalDateTime localDateTime3 = LocalDateTime.ofEpochSecond(result3, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);



        System.out.println("格式化前:" + now);
        String format = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("默认格式:" + format);
        String other = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("其他格式:" + other);
    }
}
