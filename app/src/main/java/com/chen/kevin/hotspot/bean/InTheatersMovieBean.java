package com.chen.kevin.hotspot.bean;

import java.util.List;

public class InTheatersMovieBean {

    /**
     * count : 2
     * start : 0
     * total : 31
     * subjects : [{"rating":{"max":10,"average":6,"stars":"30","min":0},"genres":["剧情","喜剧"],"title":"来电狂响","casts":[{"alt":"https://movie.douban.com/celebrity/1009179/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp"},"name":"佟大为","id":"1009179"},{"alt":"https://movie.douban.com/celebrity/1319032/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp"},"name":"马丽","id":"1319032"},{"alt":"https://movie.douban.com/celebrity/1000145/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp"},"name":"霍思燕","id":"1000145"}],"collect_count":50628,"original_title":"来电狂响","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1321152/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp"},"name":"于淼","id":"1321152"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp"},"alt":"https://movie.douban.com/subject/30377703/","id":"30377703"},{"rating":{"max":10,"average":7.5,"stars":"40","min":0},"genres":["动作","科幻","冒险"],"title":"大黄蜂","casts":[{"alt":"https://movie.douban.com/celebrity/1312964/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20419.webp"},"name":"海莉·斯坦菲尔德","id":"1312964"},{"alt":"https://movie.douban.com/celebrity/1044883/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23477.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23477.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p23477.webp"},"name":"约翰·塞纳","id":"1044883"},{"alt":"https://movie.douban.com/celebrity/1376970/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1545624925.39.webp"},"name":"小豪尔赫·兰登伯格","id":"1376970"}],"collect_count":12173,"original_title":"Bumblebee","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1305796/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1471358307.31.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1471358307.31.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1471358307.31.webp"},"name":"特拉维斯·奈特","id":"1305796"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541662397.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541662397.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541662397.webp"},"alt":"https://movie.douban.com/subject/26394152/","id":"26394152"}]
     * title : 正在上映的电影-广州
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":6,"stars":"30","min":0}
         * genres : ["剧情","喜剧"]
         * title : 来电狂响
         * casts : [{"alt":"https://movie.douban.com/celebrity/1009179/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp"},"name":"佟大为","id":"1009179"},{"alt":"https://movie.douban.com/celebrity/1319032/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1444800807.11.webp"},"name":"马丽","id":"1319032"},{"alt":"https://movie.douban.com/celebrity/1000145/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2520.webp"},"name":"霍思燕","id":"1000145"}]
         * collect_count : 50628
         * original_title : 来电狂响
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1321152/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp"},"name":"于淼","id":"1321152"}]
         * year : 2018
         * images : {"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp"}
         * alt : https://movie.douban.com/subject/30377703/
         * id : 30377703
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 6
             * stars : 30
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp
             * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp
             * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2542268337.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1009179/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp"}
             * name : 佟大为
             * id : 1009179
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1542346320.44.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1321152/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp"}
             * name : 于淼
             * id : 1321152
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483685290.54.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
