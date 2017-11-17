package com.kemai.basemodule.net.response;

import java.util.List;

public class RoomDetailResponse {
    /**
     * room_play_tour : 0
     * room_cover : 1
     * room_name : 7y77777
     * room_category : 有声小说
     * room_summary : 按时打发运动发射点发
     * room_price : 1
     * room_reply : [{"user_head":"uploads/22/201610151201359819824250014953.jpg","user_reply":"565按时打发首发式地方 ","user_name":"新用户"}]
     * user_id : 1
     * room_frequency : 8
     * room_reply_quantity : 1
     * room_subscribe : 3
     * room_number : 7
     * user_name : 1
     */

    private String room_play_tour;
    private int room_cover;
    private String room_name;
    private String room_category;
    private String room_summary;
    private int room_price;
    private int user_id;
    private String room_frequency;
    private int room_reply_quantity;
    private String room_subscribe;
    private String room_number;
    private int user_name;
    private List<RoomReplyBean> room_reply;

    public String getRoom_play_tour() { return room_play_tour;}

    public void setRoom_play_tour(String room_play_tour) { this.room_play_tour = room_play_tour;}

    public int getRoom_cover() { return room_cover;}

    public void setRoom_cover(int room_cover) { this.room_cover = room_cover;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public String getRoom_category() { return room_category;}

    public void setRoom_category(String room_category) { this.room_category = room_category;}

    public String getRoom_summary() { return room_summary;}

    public void setRoom_summary(String room_summary) { this.room_summary = room_summary;}

    public int getRoom_price() { return room_price;}

    public void setRoom_price(int room_price) { this.room_price = room_price;}

    public int getUser_id() { return user_id;}

    public void setUser_id(int user_id) { this.user_id = user_id;}

    public String getRoom_frequency() { return room_frequency;}

    public void setRoom_frequency(String room_frequency) { this.room_frequency = room_frequency;}

    public int getRoom_reply_quantity() { return room_reply_quantity;}

    public void setRoom_reply_quantity(int room_reply_quantity) { this.room_reply_quantity = room_reply_quantity;}

    public String getRoom_subscribe() { return room_subscribe;}

    public void setRoom_subscribe(String room_subscribe) { this.room_subscribe = room_subscribe;}

    public String getRoom_number() { return room_number;}

    public void setRoom_number(String room_number) { this.room_number = room_number;}

    public int getUser_name() { return user_name;}

    public void setUser_name(int user_name) { this.user_name = user_name;}

    public List<RoomReplyBean> getRoom_reply() { return room_reply;}

    public void setRoom_reply(List<RoomReplyBean> room_reply) { this.room_reply = room_reply;}

    public static class RoomReplyBean {
        /**
         * user_head : uploads/22/201610151201359819824250014953.jpg
         * user_reply : 565按时打发首发式地方
         * user_name : 新用户
         */

        private String user_head;
        private String user_reply;
        private String user_name;

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}

        public String getUser_reply() { return user_reply;}

        public void setUser_reply(String user_reply) { this.user_reply = user_reply;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }
}