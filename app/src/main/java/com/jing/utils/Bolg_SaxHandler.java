package com.jing.utils;

import android.util.Log;

import com.jing.model.News_BolgModel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jing on 2016/1/6.
 */
public class Bolg_SaxHandler extends DefaultHandler {

    private List<News_BolgModel> list;
    private  String content;
    private News_BolgModel model;

    public Bolg_SaxHandler(List<News_BolgModel> list) {
        this.list = list;
    }

    /**
     * 节点开始解析，当SAX解析器解析到XML文档开始时，会调用的方法
     *
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        list=new ArrayList<News_BolgModel>();
    }

    /**
     * 当SAX解析器解析到某个元素结束时，会调用的方法 其中localName记录的是元素属性名
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("id".equals(localName)){
            Log.i("TAG",content+"id");
            model.setId(content);
        }else
        if("title".equals(localName)){
            Log.i("TAG", content + "title");
            model.setTitle(content);
        }
        else if("body".equals(localName)){
            Log.i("TAG", content + "id");
            model.setBody(content);
        }
        else if("commentCount".equals(localName)){
            Log.i("TAG", content + "commentCount");
            model.setCommentCount(content);
        }
        else if("authorname".equals(localName)){
            Log.i("TAG", content + "authorname");
            model.setAuthorname(content);
        }
        else if("authorid".equals(localName)){
            Log.i("TAG", content + "authorid");
            model.setAuthorid(content);
        }
        else if("pubDate".equals(localName)){
            model.setPubDate(content);
        }else  if("url".equals(localName)) {
            model.setUrl(content);
        }else  if("documentType".equals(localName)) {
            model.setDocumentType(content);
        }
        else if("blog".equals(localName)) {
            list.add(model);
        }
    }

    /**
     * 当SAX解析器解析到某个属性值时，会调用的方法 其中参数ch记录了这个属性值的内容
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch,start, length);
    }
    /**
     * 当SAX解析器解析到某个元素开始时，会调用的方法 其中localName记录的是元素属性名
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("blog".equals(localName)){
            model=new News_BolgModel();
        }

    }

    /**
     * 节点结束解析，当SAX解析器解析到XML文档结束时，会调用的方法
     *
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

    }
    public List<News_BolgModel> getList(){
        return  list;
    }
}
