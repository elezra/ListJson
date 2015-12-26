package com.example.eli.newstest;

/**
 * Created by Eli on 22/12/2015.
 */
public class ItemNews {
    private String formule,url;

    public ItemNews(String formule,String url){
        this.formule=formule;
        this.url=url;

    }


    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
