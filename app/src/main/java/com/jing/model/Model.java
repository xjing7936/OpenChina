package com.jing.model;

import java.util.List;

/**
 * Created by jing on 2016/1/8.
 */
public class Model {

    /**
     * message : 操作成功
     * result : true
     * data : [{"imagePath":"http://103.27.6.3:909/upload/banner/20160107124931235846_guanggao1.jpg","desc":"guanggao1","contentLink":"http://103.27.6.3:2111/upload/ume/guanggao.html ","type":"3","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151207030549275623_shijian.jpg","desc":"shijian2","contentLink":"http://103.27.6.3:2111/upload/ume/shijian.html","type":"3","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151207030503385681_yanglao.jpg","desc":"yanglao2","contentLink":"http://103.27.6.3:2111/upload/ume/yanglao.html","type":"4","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151207030348895618_huodong.jpg","desc":"lunbo22","contentLink":"http://103.27.6.3:2111/upload/ume/huodong.html","type":"3","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151207030257220407_guanggao1.jpg","desc":"lunbo11","contentLink":"http://103.27.6.3:2111/upload/ume/guanggao.html ","type":"3","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151126110704637746_yanglao.jpg","desc":"aa","contentLink":"http://www.baidu.com","type":"4","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151120030527347952_d6fce2fb-54d6-43ff-a45b-ceddbfb92bd6.jpeg","desc":"234","contentLink":"www.baidu.com","type":"4","linkType":2},{"imagePath":"http://103.27.6.3:909/upload/banner/20151120030227658454_aaf25c2b-55ea-4a13-821b-0f3cc8e87df7.jpeg","desc":"234","contentLink":"2604","type":"1","linkType":1}]
     */

    private String message;
    private boolean result;
    /**
     * imagePath : http://103.27.6.3:909/upload/banner/20160107124931235846_guanggao1.jpg
     * desc : guanggao1
     * contentLink : http://103.27.6.3:2111/upload/ume/guanggao.html
     * type : 3
     * linkType : 2
     */

    private List<DataEntity> data;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResult() {
        return result;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String imagePath;
        private String desc;
        private String contentLink;
        private String type;
        private int linkType;

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setContentLink(String contentLink) {
            this.contentLink = contentLink;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getDesc() {
            return desc;
        }

        public String getContentLink() {
            return contentLink;
        }

        public String getType() {
            return type;
        }

        public int getLinkType() {
            return linkType;
        }
    }
}
