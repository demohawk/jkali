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
      
      public Menu(String id,String name,String url,String className,String code){
          this.id =id;
          this.name=name;
          this.url=url;  
          this.code=code;
          this.className=className;
          setValue("("+code+")"+name);
      }
      

    public String getName() {
        return getValue();
    }
    
    public String getClassName() {
		return className;
	}
}
