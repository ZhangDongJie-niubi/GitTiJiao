package com.example.mvp.model.bean;

import java.util.List;

public class RiBaoInfo {

    /**
     * date : 20191108
     * stories : [{"image_hue":"0x8c8a82","title":"快要退休的 3.5 寸软盘，曾是核武库最可靠的信使","url":"https://daily.zhihu.com/story/9716938","hint":"游研社 · 5 分钟阅读","ga_prefix":"110809","images":["https://pic2.zhimg.com/v2-15282d41d05f16c5668979184cd1c601.jpg"],"type":0,"id":9716938},{"image_hue":"0xd4d2ce","title":"为什么刑法会存在「追诉时效」?","url":"https://daily.zhihu.com/story/9716729","hint":"潘效辉律师 · 1 分钟阅读","ga_prefix":"110807","images":["https://pic4.zhimg.com/v2-28df7318aa0b6284d5539470af89f55b.jpg"],"type":0,"id":9716729},{"image_hue":"0xc0c2c1","title":"瞎扯 · 如何正确地吐槽","url":"https://daily.zhihu.com/story/9717229","hint":"VOL.2257","ga_prefix":"110806","images":["https://pic1.zhimg.com/v2-2e07e4d4b8a48f8f1cfa7e33631aa9d0.jpg"],"type":0,"id":9717229}]
     * top_stories : [{"image_hue":"0x838d84","hint":"作者 / Ellen","url":"https://daily.zhihu.com/story/9716798","image":"https://pic2.zhimg.com/v2-ff7f892ad30add54de1baa35568eb65d.jpg","title":"为什么有的人喜欢半英文半中文讲话？","ga_prefix":"110607","type":0,"id":9716798},{"image_hue":"0x97a4ae","hint":"作者 / 陈大可","url":"https://daily.zhihu.com/story/9716567","image":"https://pic3.zhimg.com/v2-3458c80a7eaa1f47f3869e30848f0dc6.jpg","title":"如何看待非全日制研究生受到的就业歧视？","ga_prefix":"110320","type":0,"id":9716567},{"image_hue":"0xe0ddc6","hint":"作者 / Jianfeng","url":"https://daily.zhihu.com/story/9716793","image":"https://pic1.zhimg.com/v2-db3d89c7c4b8025d25895d293f90c7fc.jpg","title":"未来 20 年，中国能否成为向世界提供平价药品的主要国家？","ga_prefix":"110307","type":0,"id":9716793},{"image_hue":"0xe1e1e1","hint":"作者 / Cecilia","url":"https://daily.zhihu.com/story/9717009","image":"https://pic3.zhimg.com/v2-b31c56ec6f512cf19f0246a4d1a371d6.jpg","title":"「30 岁，买个 AirPods Pro 要纠结好久」","ga_prefix":"110116","type":0,"id":9717009},{"image_hue":"0x9c9b42","hint":"作者 / Mr-HH","url":"https://daily.zhihu.com/story/9716617","image":"https://pic4.zhimg.com/v2-b1663d2b817b9c228d171c0db7b5f5fb.jpg","title":"除了视觉，动物界还有哪些用来感知周围世界的奇妙能力？","ga_prefix":"103109","type":0,"id":9716617}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * image_hue : 0x8c8a82
         * title : 快要退休的 3.5 寸软盘，曾是核武库最可靠的信使
         * url : https://daily.zhihu.com/story/9716938
         * hint : 游研社 · 5 分钟阅读
         * ga_prefix : 110809
         * images : ["https://pic2.zhimg.com/v2-15282d41d05f16c5668979184cd1c601.jpg"]
         * type : 0
         * id : 9716938
         */

        private String image_hue;
        private String title;
        private String url;
        private String hint;
        private String ga_prefix;
        private int type;
        private int id;
        private List<String> images;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image_hue : 0x838d84
         * hint : 作者 / Ellen
         * url : https://daily.zhihu.com/story/9716798
         * image : https://pic2.zhimg.com/v2-ff7f892ad30add54de1baa35568eb65d.jpg
         * title : 为什么有的人喜欢半英文半中文讲话？
         * ga_prefix : 110607
         * type : 0
         * id : 9716798
         */

        private String image_hue;
        private String hint;
        private String url;
        private String image;
        private String title;
        private String ga_prefix;
        private int type;
        private int id;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
