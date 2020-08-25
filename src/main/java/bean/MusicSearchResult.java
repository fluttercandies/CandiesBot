package bean;

import java.util.List;

public class MusicSearchResult {


    /**
     * songs : [{"id":298317,"name":"屋顶","artists":[{"id":9612,"name":"温岚","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":6452,"name":"周杰伦","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":29597,"name":"有点野","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":996595200000,"size":11,"copyrightId":1416500,"status":40,"picId":74766790689775,"mark":0},"duration":319000,"copyrightId":1416500,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":8192}]
     * hasMore : true
     * songCount : 600
     */

    private ResultBean result;
    /**
     * result : {"songs":[{"id":298317,"name":"屋顶","artists":[{"id":9612,"name":"温岚","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":6452,"name":"周杰伦","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":29597,"name":"有点野","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":996595200000,"size":11,"copyrightId":1416500,"status":40,"picId":74766790689775,"mark":0},"duration":319000,"copyrightId":1416500,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":8192}],"hasMore":true,"songCount":600}
     * code : 200
     */

    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
//        private boolean hasMore;
//        private int songCount;
        /**
         * id : 298317
         * name : 屋顶
         * artists : [{"id":9612,"name":"温岚","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":6452,"name":"周杰伦","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
         * album : {"id":29597,"name":"有点野","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":996595200000,"size":11,"copyrightId":1416500,"status":40,"picId":74766790689775,"mark":0}
         * duration : 319000
         * copyrightId : 1416500
         * status : 0
         * alias : []
         * rtype : 0
         * ftype : 0
         * mvid : 0
         * fee : 8
         * rUrl : null
         * mark : 8192
         */

        private List<SongsBean> songs;

//        public boolean isHasMore() {
//            return hasMore;
//        }
//
//        public void setHasMore(boolean hasMore) {
//            this.hasMore = hasMore;
//        }
//
//        public int getSongCount() {
//            return songCount;
//        }
//
//        public void setSongCount(int songCount) {
//            this.songCount = songCount;
//        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            private int id;
            private String name;
            /**
             * id : 29597
             * name : 有点野
             * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
             * publishTime : 996595200000
             * size : 11
             * copyrightId : 1416500
             * status : 40
             * picId : 74766790689775
             * mark : 0
             */

//            private AlbumBean album;
//            private int duration;
//            private int copyrightId;
//            private int status;
//            private int rtype;
//            private int ftype;
//            private int mvid;
//            private int fee;
//            private Object rUrl;
//            private int mark;

            /**
             * id : 9612
             * name : 温岚
             * picUrl : null
             * alias : []
             * albumSize : 0
             * picId : 0
             * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * img1v1 : 0
             * trans : null
             */

            private List<ArtistsBean> artists;

            //            private List<?> alias;
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            //
//            public AlbumBean getAlbum() {
//                return album;
//            }
//
//            public void setAlbum(AlbumBean album) {
//                this.album = album;
//            }
//
//            public int getDuration() {
//                return duration;
//            }
//
//            public void setDuration(int duration) {
//                this.duration = duration;
//            }
//
//            public int getCopyrightId() {
//                return copyrightId;
//            }
//
//            public void setCopyrightId(int copyrightId) {
//                this.copyrightId = copyrightId;
//            }
//
//            public int getStatus() {
//                return status;
//            }
//
//            public void setStatus(int status) {
//                this.status = status;
//            }
//
//            public int getRtype() {
//                return rtype;
//            }
//
//            public void setRtype(int rtype) {
//                this.rtype = rtype;
//            }
//
//            public int getFtype() {
//                return ftype;
//            }
//
//            public void setFtype(int ftype) {
//                this.ftype = ftype;
//            }
//
//            public int getMvid() {
//                return mvid;
//            }
//
//            public void setMvid(int mvid) {
//                this.mvid = mvid;
//            }
//
//            public int getFee() {
//                return fee;
//            }
//
//            public void setFee(int fee) {
//                this.fee = fee;
//            }
//
//            public Object getRUrl() {
//                return rUrl;
//            }
//
//            public void setRUrl(Object rUrl) {
//                this.rUrl = rUrl;
//            }
//
//            public int getMark() {
//                return mark;
//            }
//
//            public void setMark(int mark) {
//                this.mark = mark;
//            }
//
            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }
//
//            public List<?> getAlias() {
//                return alias;
//            }
//
//            public void setAlias(List<?> alias) {
//                this.alias = alias;
//            }
//
//            public static class AlbumBean {
//                private int id;
//                private String name;
//                /**
//                 * id : 0
//                 * name :
//                 * picUrl : null
//                 * alias : []
//                 * albumSize : 0
//                 * picId : 0
//                 * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
//                 * img1v1 : 0
//                 * trans : null
//                 */
//
//                private ArtistBean artist;
//                private long publishTime;
//                private int size;
//                private int copyrightId;
//                private int status;
//                private long picId;
//                private int mark;
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public ArtistBean getArtist() {
//                    return artist;
//                }
//
//                public void setArtist(ArtistBean artist) {
//                    this.artist = artist;
//                }
//
//                public long getPublishTime() {
//                    return publishTime;
//                }
//
//                public void setPublishTime(long publishTime) {
//                    this.publishTime = publishTime;
//                }
//
//                public int getSize() {
//                    return size;
//                }
//
//                public void setSize(int size) {
//                    this.size = size;
//                }
//
//                public int getCopyrightId() {
//                    return copyrightId;
//                }
//
//                public void setCopyrightId(int copyrightId) {
//                    this.copyrightId = copyrightId;
//                }
//
//                public int getStatus() {
//                    return status;
//                }
//
//                public void setStatus(int status) {
//                    this.status = status;
//                }
//
//                public long getPicId() {
//                    return picId;
//                }
//
//                public void setPicId(long picId) {
//                    this.picId = picId;
//                }
//
//                public int getMark() {
//                    return mark;
//                }
//
//                public void setMark(int mark) {
//                    this.mark = mark;
//                }
//
//                public static class ArtistBean {
//                    private int id;
//                    private String name;
//                    private Object picUrl;
//                    private int albumSize;
//                    private int picId;
//                    private String img1v1Url;
//                    private int img1v1;
//                    private Object trans;
//                    private List<?> alias;
//
//                    public int getId() {
//                        return id;
//                    }
//
//                    public void setId(int id) {
//                        this.id = id;
//                    }
//
//                    public String getName() {
//                        return name;
//                    }
//
//                    public void setName(String name) {
//                        this.name = name;
//                    }
//
//                    public Object getPicUrl() {
//                        return picUrl;
//                    }
//
//                    public void setPicUrl(Object picUrl) {
//                        this.picUrl = picUrl;
//                    }
//
//                    public int getAlbumSize() {
//                        return albumSize;
//                    }
//
//                    public void setAlbumSize(int albumSize) {
//                        this.albumSize = albumSize;
//                    }
//
//                    public int getPicId() {
//                        return picId;
//                    }
//
//                    public void setPicId(int picId) {
//                        this.picId = picId;
//                    }
//
//                    public String getImg1v1Url() {
//                        return img1v1Url;
//                    }
//
//                    public void setImg1v1Url(String img1v1Url) {
//                        this.img1v1Url = img1v1Url;
//                    }
//
//                    public int getImg1v1() {
//                        return img1v1;
//                    }
//
//                    public void setImg1v1(int img1v1) {
//                        this.img1v1 = img1v1;
//                    }
//
//                    public Object getTrans() {
//                        return trans;
//                    }
//
//                    public void setTrans(Object trans) {
//                        this.trans = trans;
//                    }
//
//                    public List<?> getAlias() {
//                        return alias;
//                    }
//
//                    public void setAlias(List<?> alias) {
//                        this.alias = alias;
//                    }
//                }
//            }
//
            public static class ArtistsBean {
                private int id;
                private String name;
                private Object picUrl;
                private int albumSize;
                private int picId;
                private String img1v1Url;
                private int img1v1;
                private Object trans;
                private List<?> alias;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(Object picUrl) {
                    this.picUrl = picUrl;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public Object getTrans() {
                    return trans;
                }

                public void setTrans(Object trans) {
                    this.trans = trans;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }
    }
}
