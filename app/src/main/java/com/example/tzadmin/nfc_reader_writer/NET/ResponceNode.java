package com.example.tzadmin.nfc_reader_writer.NET;

/**
 * Created by velor on 6/28/17.
 */

public class ResponceNode {
    public String url;
    public String responce;
    public Object passData;

    public ResponceNode(String url, String responce, Object passData) {
        this.url = url;
        this.responce = responce;
        this.passData = passData;
    }
}
