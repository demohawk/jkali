/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client;

import javafx.scene.control.TreeItem;
import org.jrebirth.core.wave.Wave;

/**
 *
 * @author Paul
 */
public class Menu extends TreeItem<String> {
      private String id;
      private String name;
      private String url;
      private String code;
      private String className;
      private Wave wave;
      
      public Menu(String id,String name,String url){
          this.id =id;
          this.name=name;
          this.url=url;  
          setValue(name);
      }
      

    public String getName() {
        return getValue();
    }
}
