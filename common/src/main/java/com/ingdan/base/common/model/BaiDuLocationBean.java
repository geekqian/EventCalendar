package com.ingdan.base.common.model;

import java.util.List;

/**
 * Created by geekqian on 2017/12/18.
 * 描述: 百度返回的数据模型
 * 更新者:
 * 更新时间:
 * 更新描述:
 */

public class BaiDuLocationBean {

    /**
     * status : 0
     * result : {"location":{"lng":116.32899999999994,"lat":39.93400007551505},"formatted_address":"北京市海淀区增光路35-6号","business":"航天桥,甘家口,车公庄","addressComponent":{"country":"中国","country_code":0,"country_code_iso":"CHN","province":"北京市","city":"北京市","city_level":2,"district":"海淀区","town":"","adcode":"110108","street":"增光路","street_number":"35-6号","direction":"附近","distance":"13"},"pois":[{"addr":"北京市海淀区增光路小区35号","cp":" ","direction":"附近","distance":"8","name":"中国建设银行(增光路支行)","poiType":"金融","point":{"x":116.3290094537929,"y":39.93405701060194},"tag":"金融;银行","tel":"","uid":"e3082848bd8911bfb34c4941","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"增光路35号3-4楼","cp":" ","direction":"附近","distance":"23","name":"美廉美超市(增光路店)","poiType":"购物","point":{"x":116.32919809795,"y":39.934063926261146},"tag":"购物;超市","tel":"","uid":"24d2ccf27b96947f06026f26","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区钢丝厂宿舍3号楼","cp":" ","direction":"东北","distance":"60","name":"增光路40号院","poiType":"房地产","point":{"x":116.32863216547872,"y":39.93369047965539},"tag":"房地产;住宅区","tel":"","uid":"f1f5cac52a81239b36b06cea","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市增光路33号","cp":" ","direction":"西南","distance":"136","name":"中国标协写字楼","poiType":"房地产","point":{"x":116.32976403042129,"y":39.934734741857575},"tag":"房地产;写字楼","tel":"","uid":"43b7e8899273446a59f6beae","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路美廉美(首都师范大学东校区北)","cp":" ","direction":"西南","distance":"64","name":"增光路35号楼","poiType":"房地产","point":{"x":116.3292969115561,"y":39.934382045823824},"tag":"房地产;住宅区","tel":"","uid":"1f36c96004ec2b5d276e987b","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路甲38号","cp":" ","direction":"西北","distance":"152","name":"甲38号写字楼","poiType":"房地产","point":{"x":116.33024911539668,"y":39.93357291270627},"tag":"房地产;写字楼","tel":"","uid":"e889a744b5e060b58705bfaf","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"增光路36号院1","cp":" ","direction":"西","distance":"141","name":"大型五金建材超市","poiType":"购物","point":{"x":116.33019521706608,"y":39.93367664826017},"tag":"购物;家居建材","tel":"","uid":"bfffc43dddb9ca9712882483","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路27号院26楼增光路分理处","cp":" ","direction":"西","distance":"182","name":"中国农业银行(增光路分理处)","poiType":"金融","point":{"x":116.33062640371087,"y":39.93413999846609},"tag":"金融;银行","tel":"","uid":"9f97b1c5fccfe67bb74f54b4","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"阜成路白堆子131号","cp":" ","direction":"北","distance":"276","name":"北京市海淀实验中学(阜成路北二街)","poiType":"教育培训","point":{"x":116.32861419936852,"y":39.93211368245396},"tag":"教育培训;中学","tel":"","uid":"00f1c7fb23d9311fc056ac7d","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路45号(中国劳动关系学院东门)","cp":" ","direction":"东南","distance":"377","name":"中工大厦","poiType":"酒店","point":{"x":116.32589233367328,"y":39.935052858277366},"tag":"酒店;其他","tel":"","uid":"5ce2637d86be2648ae31e504","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}],"roads":[],"poiRegions":[],"sematic_description":"中国建设银行(增光路支行)附近8米","cityCode":131}
     */

    private int status;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"lng":116.32899999999994,"lat":39.93400007551505}
         * formatted_address : 北京市海淀区增光路35-6号
         * business : 航天桥,甘家口,车公庄
         * addressComponent : {"country":"中国","country_code":0,"country_code_iso":"CHN","province":"北京市","city":"北京市","city_level":2,"district":"海淀区","town":"","adcode":"110108","street":"增光路","street_number":"35-6号","direction":"附近","distance":"13"}
         * pois : [{"addr":"北京市海淀区增光路小区35号","cp":" ","direction":"附近","distance":"8","name":"中国建设银行(增光路支行)","poiType":"金融","point":{"x":116.3290094537929,"y":39.93405701060194},"tag":"金融;银行","tel":"","uid":"e3082848bd8911bfb34c4941","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"增光路35号3-4楼","cp":" ","direction":"附近","distance":"23","name":"美廉美超市(增光路店)","poiType":"购物","point":{"x":116.32919809795,"y":39.934063926261146},"tag":"购物;超市","tel":"","uid":"24d2ccf27b96947f06026f26","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区钢丝厂宿舍3号楼","cp":" ","direction":"东北","distance":"60","name":"增光路40号院","poiType":"房地产","point":{"x":116.32863216547872,"y":39.93369047965539},"tag":"房地产;住宅区","tel":"","uid":"f1f5cac52a81239b36b06cea","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市增光路33号","cp":" ","direction":"西南","distance":"136","name":"中国标协写字楼","poiType":"房地产","point":{"x":116.32976403042129,"y":39.934734741857575},"tag":"房地产;写字楼","tel":"","uid":"43b7e8899273446a59f6beae","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路美廉美(首都师范大学东校区北)","cp":" ","direction":"西南","distance":"64","name":"增光路35号楼","poiType":"房地产","point":{"x":116.3292969115561,"y":39.934382045823824},"tag":"房地产;住宅区","tel":"","uid":"1f36c96004ec2b5d276e987b","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路甲38号","cp":" ","direction":"西北","distance":"152","name":"甲38号写字楼","poiType":"房地产","point":{"x":116.33024911539668,"y":39.93357291270627},"tag":"房地产;写字楼","tel":"","uid":"e889a744b5e060b58705bfaf","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"增光路36号院1","cp":" ","direction":"西","distance":"141","name":"大型五金建材超市","poiType":"购物","point":{"x":116.33019521706608,"y":39.93367664826017},"tag":"购物;家居建材","tel":"","uid":"bfffc43dddb9ca9712882483","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路27号院26楼增光路分理处","cp":" ","direction":"西","distance":"182","name":"中国农业银行(增光路分理处)","poiType":"金融","point":{"x":116.33062640371087,"y":39.93413999846609},"tag":"金融;银行","tel":"","uid":"9f97b1c5fccfe67bb74f54b4","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"阜成路白堆子131号","cp":" ","direction":"北","distance":"276","name":"北京市海淀实验中学(阜成路北二街)","poiType":"教育培训","point":{"x":116.32861419936852,"y":39.93211368245396},"tag":"教育培训;中学","tel":"","uid":"00f1c7fb23d9311fc056ac7d","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"北京市海淀区增光路45号(中国劳动关系学院东门)","cp":" ","direction":"东南","distance":"377","name":"中工大厦","poiType":"酒店","point":{"x":116.32589233367328,"y":39.935052858277366},"tag":"酒店;其他","tel":"","uid":"5ce2637d86be2648ae31e504","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}]
         * roads : []
         * poiRegions : []
         * sematic_description : 中国建设银行(增光路支行)附近8米
         * cityCode : 131
         */

        private LocationBean         location;
        private String               formatted_address;
        private String               business;
        private AddressComponentBean addressComponent;
        private String               sematic_description;
        private int                  cityCode;
        private List<PoisBean>       pois;
        private List<?>              roads;
        private List<?>              poiRegions;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentBean getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentBean addressComponent) {
            this.addressComponent = addressComponent;
        }

        public String getSematic_description() {
            return sematic_description;
        }

        public void setSematic_description(String sematic_description) {
            this.sematic_description = sematic_description;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public List<PoisBean> getPois() {
            return pois;
        }

        public void setPois(List<PoisBean> pois) {
            this.pois = pois;
        }

        public List<?> getRoads() {
            return roads;
        }

        public void setRoads(List<?> roads) {
            this.roads = roads;
        }

        public List<?> getPoiRegions() {
            return poiRegions;
        }

        public void setPoiRegions(List<?> poiRegions) {
            this.poiRegions = poiRegions;
        }

        public static class LocationBean {
            /**
             * lng : 116.32899999999994
             * lat : 39.93400007551505
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentBean {
            /**
             * country : 中国
             * country_code : 0
             * country_code_iso : CHN
             * province : 北京市
             * city : 北京市
             * city_level : 2
             * district : 海淀区
             * town :
             * adcode : 110108
             * street : 增光路
             * street_number : 35-6号
             * direction : 附近
             * distance : 13
             */

            private String country;
            private int    country_code;
            private String country_code_iso;
            private String province;
            private String city;
            private int    city_level;
            private String district;
            private String town;
            private String adcode;
            private String street;
            private String street_number;
            private String direction;
            private String distance;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getCountry_code() {
                return country_code;
            }

            public void setCountry_code(int country_code) {
                this.country_code = country_code;
            }

            public String getCountry_code_iso() {
                return country_code_iso;
            }

            public void setCountry_code_iso(String country_code_iso) {
                this.country_code_iso = country_code_iso;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCity_level() {
                return city_level;
            }

            public void setCity_level(int city_level) {
                this.city_level = city_level;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getTown() {
                return town;
            }

            public void setTown(String town) {
                this.town = town;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }

        public static class PoisBean {
            /**
             * addr : 北京市海淀区增光路小区35号
             * cp :
             * direction : 附近
             * distance : 8
             * name : 中国建设银行(增光路支行)
             * poiType : 金融
             * point : {"x":116.3290094537929,"y":39.93405701060194}
             * tag : 金融;银行
             * tel :
             * uid : e3082848bd8911bfb34c4941
             * zip :
             * parent_poi : {"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}
             */

            private String        addr;
            private String        cp;
            private String        direction;
            private String        distance;
            private String        name;
            private String        poiType;
            private PointBean     point;
            private String        tag;
            private String        tel;
            private String        uid;
            private String        zip;
            private ParentPoiBean parent_poi;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getCp() {
                return cp;
            }

            public void setCp(String cp) {
                this.cp = cp;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPoiType() {
                return poiType;
            }

            public void setPoiType(String poiType) {
                this.poiType = poiType;
            }

            public PointBean getPoint() {
                return point;
            }

            public void setPoint(PointBean point) {
                this.point = point;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public ParentPoiBean getParent_poi() {
                return parent_poi;
            }

            public void setParent_poi(ParentPoiBean parent_poi) {
                this.parent_poi = parent_poi;
            }

            public static class PointBean {
                /**
                 * x : 116.3290094537929
                 * y : 39.93405701060194
                 */

                private double x;
                private double y;

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }

            public static class ParentPoiBean {
                /**
                 * name :
                 * tag :
                 * addr :
                 * point : {"x":0,"y":0}
                 * direction :
                 * distance :
                 * uid :
                 */

                private String     name;
                private String     tag;
                private String     addr;
                private PointBeanX point;
                private String     direction;
                private String     distance;
                private String     uid;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getAddr() {
                    return addr;
                }

                public void setAddr(String addr) {
                    this.addr = addr;
                }

                public PointBeanX getPoint() {
                    return point;
                }

                public void setPoint(PointBeanX point) {
                    this.point = point;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public static class PointBeanX {
                    /**
                     * x : 0.0
                     * y : 0.0
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }
            }
        }
    }
}
