/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.javafxdata.datasources.Format;
import org.javafxdata.datasources.provider.ObjectDataSource;
import org.javafxdata.datasources.reader.DataSourceReader;
import org.javafxdata.datasources.reader.FileSource;
import org.javafxdata.datasources.reader.RestRequestBuilder;
import org.javafxdata.samples.datasources.XmlListSample;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import org.xml.sax.SAXException;

/**
 *
 * @author Paul
 */
public class MenuTreeModel {

    private InputStream stream;

    public MenuTreeModel() throws IOException {
        //RestRequestBuilder request = new RestRequestBuilder("http://localhost:8080/spg").format(Format.XML);
        DataSourceReader reader = new FileSource(getClass().getResourceAsStream("menu.xml"));
        //request.path("main!list.action");
        //DataSourceReader reader =request.build();
        stream = reader.getInputStream();

    }

    private void parseMenu(Menu parent, List parseNodes) {

        for (Iterator it = parseNodes.iterator(); it.hasNext();) {
            Object o = it.next();
            if (o instanceof Element) {
                Element bElement = (Element) o;
                Menu itemtemp= null;
                for (Iterator ita = bElement.getContent().iterator(); ita.hasNext();) {
                    Object oo = ita.next();
                    if (oo instanceof Element) {
                        Element leafElement = (Element) oo;
                        
                        if (leafElement.getName().equals("a")) {
                            String id = leafElement.getAttributeValue("id");
                            String name = leafElement.getText();
                            String url = leafElement.getAttributeValue("url");
                            Menu menu = new Menu(id, name, url);
                            itemtemp= menu;
                            parent.getChildren().add(menu);
                        } else if (leafElement.getName().equals("ul")) {
                            parseMenu(itemtemp, leafElement.getContent());
                        }
                    }
                }
            }
        }
    }
    
    
    public Menu getMenuTreeItem() {
        Menu root = new Menu("root","","");
        SAXBuilder sb = new SAXBuilder();
        try {
            Document doc = sb.build(stream);
            Element rootItem = doc.getRootElement();
            parseMenu(root, rootItem.getContent());

        } catch (JDOMException ex) {
            Logger.getLogger(MenuTreeModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuTreeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return root;
    }
//    @XmlAccessorType(XmlAccessType.FIELD)
//    static class Menu {
//          
//      private String id;
//      private String name;
//      private String url;
//      
//      public Menu(String id,String name,String url){
//          this.id =id;
//          this.name=name;
//          this.url=url;    
//      }
//      
//      @Override
//      public String toString() {
//        return id+": "+ name+": "+url;
//      }
//    }
}
