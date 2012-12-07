package com.jkali.client.application;

import java.awt.image.BufferedImage;

import com.jkali.client.Menu;

public class Function {
	
	String UUID;
	Menu menu;
	BufferedImage image;
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (UUID == null) {
			if (other.UUID != null)
				return false;
		} else if (!UUID.equals(other.UUID))
			return false;
		return true;
	}
	
	

}
