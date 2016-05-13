package com.lauren.simplenews.beans;

import java.io.Serializable;

/**
 * Description : 新闻实体类
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/19
 */
public class NewsBean implements Serializable {

    /**
     * docid
     */
    public String docid;
    /**
     * 标题
     */
    public String title;
    /**
     * 小内容
     */
    public String digest;
    /**
     * 图片地址
     */
    public String imgsrc;
    /**
     * 来源
     */
    public String source;
    /**
     * 时间
     */
    public String ptime;
    /**
     * TAG
     */
    private String tag;

    public String url;

}
