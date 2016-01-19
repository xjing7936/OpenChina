package com.jing.utils;

import android.util.Log;

import com.jing.model.NewsModel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jing on 2016/1/6.
 */
public class News_SaxHandler extends DefaultHandler {

    private List<NewsModel> list;
    private  String content;
    private NewsModel model;


    public News_SaxHandler(List<NewsModel> list) {
        this.list = list;
    }

    /**
     * 节点开始解析，当SAX解析器解析到XML文档开始时，会调用的方法
     *
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        list=new ArrayList<NewsModel>();

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
        else if("author".equals(localName)){
            Log.i("TAG", content + "author");
            model.setAuthor(content);
        }
        else if("authorid".equals(localName)){
            Log.i("TAG", content + "authorid");
            model.setAuthorid(content);
        }
        else if("pubDate".equals(localName)){
            model.setPubDate(content);
        }else  if("url".equals(localName)) {
            model.setUrl(content);
        }
        else if("news".equals(localName)) {
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
        if ("news".equals(localName)){
            model=new NewsModel();
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
    public List<NewsModel> getList(){
        return  list;
    }
}
