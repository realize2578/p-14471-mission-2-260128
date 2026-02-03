package org.example;

class WiseSaying{
    private int id;
    private String writer;
    private String saying;

    public WiseSaying(int id, String writer, String saying) {
        this.id = id;
        this.writer = writer;
        this.saying = saying;
    }

    public int getId() {
        return id;
    }

    public String getSaying() {
        return saying;
    }

    public String getWriter() {
        return writer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}