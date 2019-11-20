package bean;

import java.util.List;

public class Rec {

    /**
     * error : false
     * results : [{"_id":"5d6c617c9d21222784aff65b","createdAt":"2019-09-02T00:25:32.782Z","desc":"趣头条大佬带你飞：实现阿里无抖动换肤","publishedAt":"2019-09-03T01:42:23.876Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/mGv_SO5ivqEmHJX9bojT0A","used":true,"who":"潇湘剑雨"},{"_id":"5d6ccadf9d212227862f8a65","createdAt":"2019-09-02T07:55:11.696Z","desc":"Flutter完整开发实战详解 实用技巧与填坑，带来 Flutter 开发过程中的实用技巧，让你继续弯道超车，全篇均为个人的日常干货总结，以实用填坑为主，让你少走弯路狂飙车。","publishedAt":"2019-09-03T01:41:57.750Z","source":"web","type":"Android","url":"https://juejin.im/post/5d6cb579f265da03da24aeb9","used":true,"who":"潇湘剑雨"},{"_id":"5d64e3969d2122031b79811a","createdAt":"2019-08-27T08:02:30.158Z","desc":"一个轻量级、可插拔的Android消息推送框架。一键集成推送（极光推送、友盟推送、华为、小米推送等），提供有效的保活机制，支持推送的拓展，充分解耦推送和业务逻辑","publishedAt":"2019-08-29T01:18:56.54Z","source":"web","type":"Android","url":"https://github.com/xuexiangjys/XPush","used":true,"who":"潇湘剑雨"},{"_id":"5d60d6fd9d2122031b798118","createdAt":"2019-08-24T06:19:41.437Z","desc":"Android博客大汇总，全面系统解析各个知识点，所有博客开源到GitHub！","publishedAt":"2019-08-24T06:20:15.192Z","source":"web","type":"Android","url":"https://juejin.im/post/5d60ad5df265da03c42899f1","used":true,"who":"潇湘剑雨"},{"_id":"5d5f37419d2122774f0cd91c","createdAt":"2019-08-23T00:45:53.276Z","desc":"腾讯Android插件库，技压群雄实现零反射全动态","publishedAt":"2019-08-24T06:20:12.285Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/w_tHM1P-mYIoKs5BAacu3w","used":true,"who":"潇湘剑雨"},{"_id":"5d5204ea9d2122032146219b","createdAt":"2019-08-13T00:31:38.367Z","desc":"郭霖大神的抽丝剥茧心法修炼： 深剖RecyclerView源码","publishedAt":"2019-08-21T00:45:09.75Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/08LpubdLTUdYW10yAzomZg","used":true,"who":"潇湘剑雨"},{"_id":"5d4a0f6b9d2122031ea5226f","createdAt":"2019-08-06T23:38:19.436Z","desc":" Android 9.0 适配指南","publishedAt":"2019-08-07T11:25:27.837Z","source":"web","type":"Android","url":"https://weilu.blog.csdn.net/article/details/98336225","used":true,"who":"潇湘剑雨"},{"_id":"5d4965fa9d2122031b7980fd","createdAt":"2019-08-06T11:35:22.731Z","desc":"自定义阴影效果的控件，支持设置阴影偏移效果，支持设置扩散阴影，设置圆角大小，设置阴影颜色，还可以设置上下左右某个方法显示阴影效果，控件小巧但功能强大，方便维护和统一管理设置阴影操作。同时可以用于RecyclerView的item设置阴影，采用缓存可以有效避免设置阴影时创建大量bitmap。","images":["http://img.gank.io/2ffb5d07-fb27-40d5-910c-43d3a3f83e8b","http://img.gank.io/030f4dc4-73ad-4f76-b55d-51de6f9b9454"],"publishedAt":"2019-08-06T11:57:09.876Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCCardView","used":true,"who":"潇湘剑雨"},{"_id":"5d48cd4f9d2122031b7980fc","createdAt":"2019-08-06T00:43:59.766Z","desc":"仅用5分钟，搞定Android同事所有不规范代码","publishedAt":"2019-08-06T11:56:52.751Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/JvouV_bH7jnsL3eaK-qtQw","used":true,"who":"潇湘剑雨"},{"_id":"5d423ff19d2122031ea52264","createdAt":"2019-08-01T01:27:13.311Z","desc":"Android开发者！好好管理你应用文件夹，别再乱用了","publishedAt":"2019-08-02T01:18:34.406Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247494106&idx=1&sn=e85aae97a1cca6b91ac98f515277cf32&chksm=96ce4897a1b9c18172767245841c742828d070a193a289a4843214cedc604699f96f1f7a4054&token=1238464417&lang=zh_CN#rd","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5d6c617c9d21222784aff65b
         * createdAt : 2019-09-02T00:25:32.782Z
         * desc : 趣头条大佬带你飞：实现阿里无抖动换肤
         * publishedAt : 2019-09-03T01:42:23.876Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s/mGv_SO5ivqEmHJX9bojT0A
         * used : true
         * who : 潇湘剑雨
         * images : ["http://img.gank.io/2ffb5d07-fb27-40d5-910c-43d3a3f83e8b","http://img.gank.io/030f4dc4-73ad-4f76-b55d-51de6f9b9454"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
