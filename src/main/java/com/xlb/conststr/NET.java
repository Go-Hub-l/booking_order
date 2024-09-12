package com.xlb.conststr;

public class NET {
    public static final String STATION_INFO = "https://www.12306.cn/index/script/core/common/station_name_new_v10057.js";
    public static final String STATION_LIST = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=#{train_date}&leftTicketDTO.from_station=#{from_station}&leftTicketDTO.to_station=#{to_station}&purpose_codes=ADULT";
    public static final String STATION_STOP = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo?train_no=#{train_no}&from_station_telecode=#{from_station_code}&to_station_telecode=#{to_station_code}&depart_date=#{depart_date}";

    // 请求头

    // cookies会变，如果失效了就更新
    public static final String COOKIES = "JSESSIONID=A9F8BC042F6F243F7CE0AF0FA4D1D8DB; tk=5gMVSg0Rmy8SIPkzjoNDv7wWAE1RqI6WYX7TW19jC0KhNCk5bcX1X0; guidesStatus=off; highContrastMode=defaltMode; cursorStatus=off; _jc_save_fromStation=%u5408%u80A5%2CHFH; _jc_save_toStation=%u4E0A%u6D77%2CSHH; _jc_save_wfdc_flag=dc; BIGipServerotn=1910046986.50210.0000; BIGipServerpassport=904397066.50215.0000; route=495c805987d0f5c8c84b14f60212447d; BIGipServerportal=3151233290.16671.0000; uKey=19f502e6d4facb79ee38eeec3cc9cb026170f726b2803f0dd59312952804231a; _jc_save_fromDate=2024-09-11; _jc_save_toDate=2024-09-11";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36";
}
