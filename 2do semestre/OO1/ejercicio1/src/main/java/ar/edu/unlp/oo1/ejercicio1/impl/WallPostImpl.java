package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private int likes;
	private String text;
	private boolean featured;

	public WallPostImpl() {
		likes = 0;
		text = "Undefined post";
		featured = false;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void like() {
		likes++;
	}
	
	public void dislike() {
		if (likes > 0) {
			likes--;
		}
	}
	
	public boolean isFeatured() {
		return featured;
	}
	
	public void toggleFeatured() {
		featured = !featured;
	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
