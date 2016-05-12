package com.lauren.simplenews.news;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lauren.simplenews.beans.NewsBean;
import com.lauren.simplenews.beans.NewsDetailBean;
import com.lauren.simplenews.utils.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/19
 */
public class NewsJsonUtils {

    private final static String TAG = "NewsJsonUtils";

    /**
     * 将获取到的json转换为新闻列表对象
     *
     * @param res
     * @param value
     *
     * @return
     */
    public static List<NewsBean> readJsonNewsBeans(String res, String value) {
        List<NewsBean> beans = new ArrayList<NewsBean>();
        try {
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(res);
            JsonObject jsonObject = element.getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(value);
            beans = new Gson().fromJson(jsonElement, type(List.class, NewsBean.class));
        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonNewsBeans error", e);
        }
        return beans;
    }

    public static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    public static NewsDetailBean readJsonNewsDetailBeans(String res, String docId) {
        NewsDetailBean newsDetailBean = null;
        try {
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(res);
            JsonObject jsonObject = element.getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(docId);
            newsDetailBean = new Gson().fromJson(jsonElement, NewsDetailBean.class);
        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonNewsBeans error", e);
        }
        return newsDetailBean;
    }
}
